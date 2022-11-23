package com.my.first.vistaapp20.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.my.first.vistaapp20.R;
import com.my.first.vistaapp20.models.AsesorModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AsesoresService {

    private final Context context;
    private ArrayList<AsesorModel> asesores;

    public AsesoresService(Context context) {
        this.context = context;
        this.asesores = new ArrayList<>();
    }

    //
    // Metodo para crear Asesores
    //
    public int createAsesor(AsesorModel asesorModel) {
        return 0;
    }

    //
    // Metodo para modificar Asesores
    //
    public int updateAsesor(AsesorModel asesorModel) {
        return 0;
    }

    //
    // Metodo para eliminar Asesores
    //
    public int deleteAsesor(int asesorId) {
        return 0;
    }

    //
    // Metodo para obtener Asesor por Id
    //
    public AsesorModel asesorById(int asesorId) {
        return new AsesorModel();
    }

    //
    // Metodo para obtener la lista de Asesores
    //
    private void asesoresList() {
        String url = "http://192.168.1.100:5094/asesores";
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        AsesorModel model = new AsesorModel();
                        model.setAsesorId(Integer.parseInt(object.getString("asesorId")));
                        model.setNombre(object.getString("nombre"));
                        model.setDui(object.getString("dui"));
                        model.setTelefono(object.getString("telefono"));
                        model.setEdad(Integer.parseInt(object.getString("edad")));
                        model.setFechaNacimiento(object.getString("fechaNacimiento"));
                        model.setFoto(R.drawable.profile);
                        asesores.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error al intentar obtener la lista de Asesores", Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(context).add(request);
    }

    public ArrayList<AsesorModel> ObtenerListaAsesores() {
        this.asesoresList();
        return this.asesores;
    }
}
