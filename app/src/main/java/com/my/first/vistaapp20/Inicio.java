package com.my.first.vistaapp20;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Toast.makeText(this, "Asesor creado con exito", Toast.LENGTH_SHORT).show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_optometrista_add:
                Intent intentOpt = new Intent(Inicio.this, AgregarOptometrista.class);
                launcher.launch(intentOpt);
                return true;
            case R.id.nav_optometristas:
                Intent intentOptometristas = new Intent(Inicio.this, ReadOptometrista.class);
                launcher.launch(intentOptometristas);
                return true;
            case R.id.nav_asesor_add:
                Intent intentAsesor = new Intent(Inicio.this, AgregarAsesor.class);
                launcher.launch(intentAsesor);
                return true;
            case R.id.nav_asesores:
                Intent intentAsesores = new Intent(Inicio.this, ReadAsesor.class);
                launcher.launch(intentAsesores);
                return true;
            case R.id.nav_paciente_add:
                Intent intentPaciente = new Intent(Inicio.this, AgregarPaciente.class);
                startActivity(intentPaciente);
                finish();
                return true;
            case R.id.nav_cita_add:
                Intent intentCita = new Intent(Inicio.this, AgregarCita.class);
                startActivity(intentCita);
                finish();
                return true;
            case R.id.nav_receta_add:
                Intent intentRec = new Intent(Inicio.this, AgregarReceta.class);
                startActivity(intentRec);
                finish();
                return true;
            case R.id.nav_cotizacion_add:
                Intent intentCot = new Intent(Inicio.this, AgregarCotizacion.class);
                startActivity(intentCot);
                finish();
                return true;
            case R.id.nav_producto_add:
                Intent intentPro = new Intent(Inicio.this, AgregarProducto.class);
                startActivity(intentPro);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
