package com.cali.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmDatos extends AppCompatActivity {

    private TextView tvNombre;
    private  TextView tvFecha;
    private  TextView tvTelf, tvMail, tvDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_datos);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pNombre));
        String fecha  = parametros.getString(getResources().getString(R.string.pFecha));
        String telf   = parametros.getString(getResources().getString(R.string.pTelf));
        String mail   = parametros.getString(getResources().getString(R.string.pMail));
        String desc   = parametros.getString(getResources().getString(R.string.pDesc));

        tvNombre = findViewById(R.id.tvNombre);
        tvFecha  = findViewById(R.id.tvFecha);
        tvTelf   = findViewById(R.id.tvTel);
        tvMail   = findViewById(R.id.tvEmail);
        tvDesc   = findViewById(R.id.tvDesc);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelf.setText(telf);
        tvMail.setText(mail);
        tvDesc.setText(desc);

    }

    public void editar(View V){
        Intent iEditar = new Intent(ConfirmDatos.this, MainActivity.class );
        iEditar.putExtra(getResources().getString(R.string.pNombre),tvNombre.getText().toString());
        iEditar.putExtra(getResources().getString(R.string.pFecha), tvFecha.getText().toString());
        iEditar.putExtra(getResources().getString(R.string.pTelf),  tvTelf.getText().toString() );
        iEditar.putExtra(getResources().getString(R.string.pMail), tvMail.getText().toString());
        iEditar.putExtra(getResources().getString(R.string.pDesc), tvDesc.getText().toString());
        startActivity(iEditar);
        finish();
    }


}
