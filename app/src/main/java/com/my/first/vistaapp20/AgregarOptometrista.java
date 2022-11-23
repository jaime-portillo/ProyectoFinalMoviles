package com.my.first.vistaapp20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AgregarOptometrista extends AppCompatActivity {
    private EditText edtOptometristaId, txtnombre, txtfechaNacimiento, txtEdad, txtjvpm, txtDui, txtTelefono, txtDireccion;
    private Button btnGuardar, btnEditar, btnEliminar;
    private int optometristaId;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_optometrista);

        requestQueue = Volley.newRequestQueue(AgregarOptometrista.this);
        optometristaId = getIntent().getIntExtra("OptometristaId", 0);

        edtOptometristaId = findViewById(R.id.AAOid);
        txtnombre = (EditText) findViewById(R.id.AOnombre);
        txtfechaNacimiento = (EditText) findViewById(R.id.AOfecha);
        txtEdad = (EditText) findViewById(R.id.AOedad);
        txtjvpm = (EditText) findViewById(R.id.AOjvpm);
        txtDui = (EditText) findViewById(R.id.AOdui);
        txtTelefono = (EditText) findViewById(R.id.AOtelefono);
        txtDireccion = (EditText) findViewById(R.id.AOdireccion);
        btnGuardar = (Button) findViewById(R.id.AAOguardar);
        btnEditar = (Button) findViewById(R.id.AAUeditar);
        btnEliminar = (Button) findViewById(R.id.AAEliminar);

        if (optometristaId <= 0) {
            btnEliminar.setVisibility(View.INVISIBLE);
            btnEditar.setVisibility(View.INVISIBLE);
            edtOptometristaId.setVisibility(View.INVISIBLE);
        } else {
            btnGuardar.setVisibility(View.INVISIBLE);
            obtenerOptometrista(optometristaId);
        }
    }

    private void obtenerOptometrista(int optometristaId) {
        String url = "http://192.168.1.100:5094/asesores/" + asesorId;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject object) {
                try {
                    edtAsesorId.setText(object.getString("asesorId"));
                    edtNombre.setText(object.getString("nombre"));
                    edtDui.setText(object.getString("dui"));
                    edtTelefono.setText(object.getString("telefono"));
                    edtEdad.setText(object.getString("edad"));
                    edtFechaNacimiento.setText(object.getString("fechaNacimiento"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AgregarAsesor.this, "Error al intentar obtener los datos del Asesor", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(request);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Toast.makeText(this, "Bienvendido a Vista Movil App", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_optometrista_add:
                Intent intentOpt = new Intent(AgregarOptometrista.this, AgregarOptometrista.class);
                startActivity(intentOpt);
                finish();
                return true;
            case R.id.nav_asesor_add:
                Intent intentAsesor = new Intent(AgregarOptometrista.this, AgregarAsesor.class);
                startActivity(intentAsesor);
                finish();
                return true;
            case R.id.nav_paciente_add:
                Intent intentPaciente = new Intent(AgregarOptometrista.this, AgregarPaciente.class);
                startActivity(intentPaciente);
                finish();
                return true;
            case R.id.nav_cita_add:
                Intent intentCita = new Intent(AgregarOptometrista.this, AgregarCita.class);
                startActivity(intentCita);
                finish();
                return true;
            case R.id.nav_receta_add:
                Intent intentRec = new Intent(AgregarOptometrista.this, AgregarReceta.class);
                startActivity(intentRec);
                finish();
                return true;
            case R.id.nav_cotizacion_add:
                Intent intentCot = new Intent(AgregarOptometrista.this, AgregarCotizacion.class);
                startActivity(intentCot);
                finish();
                return true;
            case R.id.nav_producto_add:
                Intent intentPro = new Intent(AgregarOptometrista.this, AgregarProducto.class);
                startActivity(intentPro);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void btnGuardar_onClick(View view) {
    }

    public void btneditar_onClick(View view) {
    }

    public void btneliminar_onClick(View view) {
    }
}