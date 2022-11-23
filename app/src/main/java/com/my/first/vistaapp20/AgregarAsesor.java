package com.my.first.vistaapp20;

import androidx.annotation.NonNull;
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
import com.my.first.vistaapp20.services.AsesoresService;

import org.json.JSONException;
import org.json.JSONObject;

public class AgregarAsesor extends AppCompatActivity {
    private Button btnAgregar, btnEditar, btnEliminar;
    private EditText edtAsesorId, edtNombre, edtFechaNacimiento, edtEdad, edtDui, edtTelefono;
    private int asesorId;
    private RequestQueue requestQueue;

    public AgregarAsesor() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_asesor);

        requestQueue = Volley.newRequestQueue(AgregarAsesor.this);

        btnAgregar = findViewById(R.id.AAguardar);
        btnEditar = findViewById(R.id.AAUeditar);
        btnEliminar = findViewById(R.id.AAREliminar);

        edtAsesorId = findViewById(R.id.AAid);
        edtNombre = findViewById(R.id.AAnombre);
        edtFechaNacimiento = findViewById(R.id.AAfecha);
        edtEdad = findViewById(R.id.AAedad);
        edtDui = findViewById(R.id.AAdui);
        edtTelefono = findViewById(R.id.AAtelefono);

        asesorId = getIntent().getIntExtra("AsesorId", 0);

        if (asesorId <= 0) {
            btnEliminar.setVisibility(View.INVISIBLE);
            btnEditar.setVisibility(View.INVISIBLE);
            edtAsesorId.setVisibility(View.INVISIBLE);

            // Evento OnClick para el boton Agregar
            btnAgregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = "http://192.168.1.100:5094/asesores";
                    JSONObject object = new JSONObject();
                    try {
                        object.put("nombre", edtNombre.getText().toString());
                        object.put("fechaNacimiento", edtFechaNacimiento.getText().toString());
                        object.put("edad", Integer.parseInt(edtEdad.getText().toString()));
                        object.put("dui", edtDui.getText().toString());
                        object.put("telefono", edtTelefono.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject object) {
                            try {
                                Toast.makeText(AgregarAsesor.this, "El asesor" + object.getString("nombre").toUpperCase() + "fue agregado con exito", Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(AgregarAsesor.this, "Error al intentar agregar los datos del Asesor", Toast.LENGTH_SHORT).show();
                        }
                    });

                    requestQueue.add(request);
                    setResult(RESULT_OK);
                    AgregarAsesor.super.onBackPressed();
                }
            });
        } else {
            btnAgregar.setVisibility(View.INVISIBLE);
            obtenerAsesor(asesorId);

            // Evento OnClick para el boton Editar
            btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = "http://192.168.1.100:5094/asesores";
                    JSONObject object = new JSONObject();
                    try {
                        object.put("nombre", edtNombre.getText().toString());
                        object.put("fechaNacimiento", edtFechaNacimiento.getText().toString());
                        object.put("edad", Integer.parseInt(edtEdad.getText().toString()));
                        object.put("dui", edtDui.getText().toString());
                        object.put("telefono", edtTelefono.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, url, object, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject object) {
                            try {
                                Toast.makeText(AgregarAsesor.this, "El asesor" + object.getString("nombre").toUpperCase() + "fue editado con exito", Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(AgregarAsesor.this, "Error al intentar editar los datos del Asesor", Toast.LENGTH_SHORT).show();
                        }
                    });

                    requestQueue.add(request);
                }
            });

            // Evento OnClick para el boton Eliminar
            btnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = "http://192.168.1.100:5094/asesores/" + asesorId;
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.DELETE, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject object) {
                            Toast.makeText(AgregarAsesor.this, "El asesor fue eliminado con exito", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(AgregarAsesor.this, "Error al intentar eliminar los datos del Asesor", Toast.LENGTH_SHORT).show();
                        }
                    });

                    requestQueue.add(request);
                }
            });
        }
    }

    private void obtenerAsesor(int asesorId) {
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
                Intent intentOpt = new Intent(AgregarAsesor.this, AgregarOptometrista.class);
                startActivity(intentOpt);
                finish();
                return true;
            case R.id.nav_asesor_add:
                Intent intentAsesor = new Intent(AgregarAsesor.this, AgregarAsesor.class);
                startActivity(intentAsesor);
                finish();
                return true;
            case R.id.nav_paciente_add:
                Intent intentPaciente = new Intent(AgregarAsesor.this, AgregarPaciente.class);
                startActivity(intentPaciente);
                finish();
                return true;
            case R.id.nav_cita_add:
                Intent intentCita = new Intent(AgregarAsesor.this, AgregarCita.class);
                startActivity(intentCita);
                finish();
                return true;
            case R.id.nav_receta_add:
                Intent intentRec = new Intent(AgregarAsesor
                        .this, AgregarReceta.class);
                startActivity(intentRec);
                finish();
                return true;
            case R.id.nav_cotizacion_add:
                Intent intentCot = new Intent(AgregarAsesor.this, AgregarCotizacion.class);
                startActivity(intentCot);
                finish();
                return true;
            case R.id.nav_producto_add:
                Intent intentPro = new Intent(AgregarAsesor.this, AgregarProducto.class);
                startActivity(intentPro);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}