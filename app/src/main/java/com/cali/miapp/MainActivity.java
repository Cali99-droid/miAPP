package com.cali.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView tvFecha;
    private EditText etNombre;
    private EditText etTelf;
    private EditText etMail;
    private EditText etDesc;
    private DatePickerDialog.OnDateSetListener listenerFecha;
    private Button btnSiguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre     = findViewById(R.id.etNom);
        etTelf       = findViewById(R.id.etTelf);
        etMail       = findViewById(R.id.etEmail);
        etDesc       = findViewById(R.id.etDesc);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        tvFecha = findViewById(R.id.tvFecha);

        tvFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int anio     = cal.get(Calendar.YEAR);
                int mes      = cal.get(Calendar.MONTH);
                int dia      = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dtp = new DatePickerDialog(MainActivity.this,listenerFecha,anio, mes,dia);
                dtp.show();
            }
        });
        listenerFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + month + "/" + year;
                tvFecha.setText(fecha);
            }
        };
        editarNuevo();
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ConfirmDatos.class);
                intent.putExtra(getResources().getString(R.string.pNombre), etNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pFecha), tvFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.pTelf),  etTelf.getText().toString() );
                intent.putExtra(getResources().getString(R.string.pMail), etMail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pDesc), etDesc.getText().toString());
                startActivity(intent);
               finish();

            }
        });

    }

    public  void editarNuevo(){

        Bundle parametros = getIntent().getExtras();

        if ( parametros != null){
            String nombre = parametros.getString(getResources().getString(R.string.pNombre));
            String fecha  = parametros.getString(getResources().getString(R.string.pFecha));
            String telf   = parametros.getString(getResources().getString(R.string.pTelf));
            String mail   = parametros.getString(getResources().getString(R.string.pMail));
            String desc   = parametros.getString(getResources().getString(R.string.pDesc));

            etNombre.setText(nombre);
            tvFecha.setText(fecha);
            etTelf.setText(telf);
            etMail.setText(mail);
            etDesc.setText(desc);
        }

    }

}
