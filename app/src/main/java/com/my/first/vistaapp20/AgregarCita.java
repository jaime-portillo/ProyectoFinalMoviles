package com.my.first.vistaapp20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AgregarCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cita);
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
                Intent intentOpt = new Intent(AgregarCita.this, AgregarOptometrista.class);
                startActivity(intentOpt);
                finish();
                return true;
            case R.id.nav_asesor_add:
                Intent intentAsesor = new Intent(AgregarCita.this, AgregarAsesor.class);
                startActivity(intentAsesor);
                finish();
                return true;
            case R.id.nav_paciente_add:
                Intent intentPaciente = new Intent(AgregarCita.this, AgregarPaciente.class);
                startActivity(intentPaciente);
                finish();
                return true;
            case R.id.nav_cita_add:
                Intent intentCita = new Intent(AgregarCita.this, AgregarCita.class);
                startActivity(intentCita);
                finish();
                return true;
            case R.id.nav_receta_add:
                Intent intentRec = new Intent(AgregarCita.this, AgregarReceta.class);
                startActivity(intentRec);
                finish();
                return true;
            case R.id.nav_cotizacion_add:
                Intent intentCot = new Intent(AgregarCita.this, AgregarCotizacion.class);
                startActivity(intentCot);
                finish();
                return true;
            case R.id.nav_producto_add:
                Intent intentPro = new Intent(AgregarCita.this, AgregarProducto.class);
                startActivity(intentPro);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}