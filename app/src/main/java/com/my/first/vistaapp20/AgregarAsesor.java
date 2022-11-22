package com.my.first.vistaapp20;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.my.first.vistaapp20.models.AsesorModel;
import com.my.first.vistaapp20.services.AsesoresService;

public class AgregarAsesor extends AppCompatActivity {

    private AsesoresService asesoresService;

    public AgregarAsesor() {
        this.asesoresService = new AsesoresService();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_asesor);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
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

    public void btnGuardar_onClick(View view) {
        AsesorModel asesorModel = new AsesorModel();
        EditText nombre = view.findViewById(R.id.AAnombre);
        EditText fechaNacimiento = view.findViewById(R.id.AAfecha);
        EditText edad = view.findViewById(R.id.AAedad);
        EditText telefono = view.findViewById(R.id.AAtelefono);
        EditText dui = view.findViewById(R.id.AAdui);

        asesorModel.setNombre(nombre.getText().toString());
        asesorModel.setFechaNacimiento(fechaNacimiento.getText().toString());
        asesorModel.setEdad(Integer.parseInt(edad.getText().toString()));
        asesorModel.setTelefono(telefono.getText().toString());
        asesorModel.setDui(dui.getText().toString());

        if (this.asesoresService.createAsesor(asesorModel) <= 0) {
            Toast.makeText(this, "Error al crear el asesor", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnEliminar_onClick(View view) {
    }

    public void btnEditar_onClick(View view) {
    }

    public void btnGuardarR_onClick(View view) {
    }
}