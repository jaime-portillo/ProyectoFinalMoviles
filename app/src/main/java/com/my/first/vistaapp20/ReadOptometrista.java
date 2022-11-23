package com.my.first.vistaapp20;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.my.first.vistaapp20.adapters.optometristaAdapter;
import com.my.first.vistaapp20.models.AsesorModel;
import com.my.first.vistaapp20.models.OptometristaModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReadOptometrista extends AppCompatActivity implements optometristaAdapter.OnOptometristasListener {

    private RecyclerView recyclerView;
    private optometristaAdapter adapter;
    private RequestQueue requestQueue;
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    obtenerLista();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_read_optometrista);

        recyclerView = findViewById(R.id.recyclerViewOptometrista);
        requestQueue = Volley.newRequestQueue(ReadOptometrista.this);
        adapter = new optometristaAdapter(ReadOptometrista.this);

        obtenerLista();

        recyclerView.setLayoutManager(new LinearLayoutManager(ReadOptometrista.this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickListener(int posicion) {
        Bundle bundle = new Bundle();
        bundle.putInt("OptometristaId", adapter.obtenerListado().get(posicion).getOptometristaId());
        Intent intent = new Intent(ReadOptometrista.this, AgregarOptometrista.class);
        intent.putExtras(bundle);
        launcher.launch(intent);
    }

    private void obtenerLista() {
        String url = "http://192.168.1.100:5094/optometristas";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            ArrayList<OptometristaModel> modelos = new ArrayList<>();
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject object = new JSONObject(response.get(i).toString());
                    OptometristaModel model = new OptometristaModel();
                    model.setOptometristaId(Integer.parseInt(object.getString("optometristaId")));
                    model.setNombre(object.getString("nombre"));
                    model.setDui(object.getString("dui"));
                    model.setTelefono(object.getString("telefono"));
                    model.setEdad(Integer.parseInt(object.getString("edad")));
                    model.setFechaNacimiento(object.getString("fechaNacimiento"));
                    model.setDireccion(object.getString("direccion"));
                    model.setJvpm(object.getString("jvpm"));
                    model.setFoto(R.drawable.profile);

                    modelos.add(model);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            adapter.cargarListado(modelos);
            adapter.notifyDataSetChanged();
        }, error -> Toast.makeText(getApplicationContext(), "Error al intentar obtener la lista de optometristas", Toast.LENGTH_SHORT).show());

        requestQueue.add(request);
    }
}