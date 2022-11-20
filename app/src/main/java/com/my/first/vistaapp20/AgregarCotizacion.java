package com.my.first.vistaapp20;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarCotizacion extends AppCompatActivity {
private EditText nombre, desAro, precioAro,desLente,precioLente,descuento;
    private TextView subtotal, tdescuento, total ;
    private Button vCalcular;
    private CheckBox chek1;

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cotizacion);
        nombre=(EditText) findViewById(R.id.edNombre);
        desAro=(EditText) findViewById(R.id.edDesAro);
        precioAro=(EditText) findViewById(R.id.edPrecioAro);
        desLente=(EditText) findViewById(R.id.edDesLente);
        precioLente=(EditText) findViewById(R.id.edPreLente);
        descuento=(EditText) findViewById(R.id.edDescuento);
        subtotal=(TextView) findViewById(R.id.tvSubTotal);
        tdescuento=(TextView) findViewById(R.id.tvDescuento);
        total=(TextView) findViewById(R.id.tvTotal);
        chek1=(CheckBox) findViewById(R.id.checkAntireflejo);
        vCalcular=(Button) findViewById(R.id.btnCalcular);

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
                Intent intentOpt = new Intent(AgregarCotizacion.this, AgregarOptometrista.class);
                startActivity(intentOpt);
                finish();
                return true;
            case R.id.nav_asesor_add:
                Intent intentAsesor = new Intent(AgregarCotizacion.this, AgregarAsesor.class);
                startActivity(intentAsesor);
                finish();
                return true;
            case R.id.nav_paciente_add:
                Intent intentPaciente = new Intent(AgregarCotizacion.this, AgregarPaciente.class);
                startActivity(intentPaciente);
                finish();
                return true;
            case R.id.nav_cita_add:
                Intent intentCita = new Intent(AgregarCotizacion.this, AgregarCita.class);
                startActivity(intentCita);
                finish();
                return true;
            case R.id.nav_receta_add:
                Intent intentRec = new Intent(AgregarCotizacion.this, AgregarReceta.class);
                startActivity(intentRec);
                finish();
                return true;
            case R.id.nav_cotizacion_add:
                Intent intentCot = new Intent(AgregarCotizacion.this, AgregarCotizacion.class);
                startActivity(intentCot);
                finish();
                return true;
            case R.id.nav_producto_add:
                Intent intentPro = new Intent(AgregarCotizacion.this, AgregarProducto.class);
                startActivity(intentPro);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void CalcularDescuento(View view) {
        if(precioAro.getText().toString().isEmpty()){
            precioAro.setText("debe ingresar precio del aro");
        }else if( precioLente.getText().toString().isEmpty()){
            precioLente.setText("debe ingresar precio del lente");
        } else if(descuento.getText().toString().isEmpty()){
            descuento.setText("debe ingresar descuento en porcentaje 5,10,15");
        }else {
            operar();
        }
    }

    private void operar() {
        double preAro=Double.parseDouble(precioAro.getText().toString());
        double preLente=Double.parseDouble(precioLente.getText().toString());
        double des=Double.parseDouble(descuento.getText().toString());

        if(chek1.isChecked()==true){
            subtotal.setText("Subtotal: " +String.format("%.2f", preAro+preLente+75));
            tdescuento.setText("Descuento: " +String.format("%.2f",preLente*(des/100)));
            total.setText("Total: " +String.format("%.2f",(preAro+preLente+75)-(preLente*(des/100))));

        }else{
            subtotal.setText("subtotal: " + String.format("%.2f", preAro+preLente));
            tdescuento.setText("Descuento: " + String.format("%.2f",preLente*(des/100)));
            total.setText("Total: " +String.format("%.2f",(preAro+preLente)-(preLente*(des/100))));
        }

    }
}