package com.my.first.vistaapp20;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.my.first.vistaapp20.adapters.asesoresAdapter;
import com.my.first.vistaapp20.models.AsesorModel;
import com.my.first.vistaapp20.services.AsesoresService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReadAsesor extends AppCompatActivity implements asesoresAdapter.onAsesoresListener {

    private RecyclerView recyclerView;
    private asesoresAdapter asesoresAdapter;
    private RequestQueue requestQueue;
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    obtenerListaAsesores();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_asesor);

        requestQueue = Volley.newRequestQueue(ReadAsesor.this);
        recyclerView = findViewById(R.id.recyclerViewAsesor);
        asesoresAdapter = new asesoresAdapter(ReadAsesor.this);

        obtenerListaAsesores();

        recyclerView.setLayoutManager(new LinearLayoutManager(ReadAsesor.this));
        recyclerView.setAdapter(asesoresAdapter);
    }

    @Override
    public void onaseroresclick(int posision) {
        Bundle bundle = new Bundle();
        bundle.putInt("AsesorId", asesoresAdapter.obtenerListado().get(posision).getAsesorId());
        Intent intent = new Intent(ReadAsesor.this, AgregarAsesor.class);
        intent.putExtras(bundle);
        launcher.launch(intent);
    }

    private void obtenerListaAsesores() {
        String url = "http://192.168.1.100:5094/asesores";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            ArrayList<AsesorModel> modelos = new ArrayList<>();
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject object = new JSONObject(response.get(i).toString());
                    AsesorModel model = new AsesorModel();
                    model.setAsesorId(Integer.parseInt(object.getString("asesorId")));
                    model.setNombre(object.getString("nombre"));
                    model.setDui(object.getString("dui"));
                    model.setTelefono(object.getString("telefono"));
                    model.setEdad(Integer.parseInt(object.getString("edad")));
                    model.setFechaNacimiento(object.getString("fechaNacimiento"));
                    model.setFoto(R.drawable.profile);

                    modelos.add(model);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            asesoresAdapter.cargarListado(modelos);
            asesoresAdapter.notifyDataSetChanged();
        }, error -> Toast.makeText(getApplicationContext(), "Error al intentar obtener la lista de Asesores", Toast.LENGTH_SHORT).show());

        requestQueue.add(request);
    }
}