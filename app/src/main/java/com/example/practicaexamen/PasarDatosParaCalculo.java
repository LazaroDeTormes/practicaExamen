package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasarDatosParaCalculo extends AppCompatActivity {

    EditText etAlto;
    EditText etPeso;

    Button btnOpeCalc;

    float imc;
    float altura;
    float peso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasar_datos_para_calculo);

        etAlto = findViewById(R.id.etAlto);
        etPeso = findViewById(R.id.etPeso);
        btnOpeCalc = findViewById(R.id.btnOpeCalc);




    }



    public void onClick(View view){

        if (etAlto.getText().toString().equals("") || etPeso.getText().toString().equals("")){

            Toast.makeText(this, "Cubre los datos", Toast.LENGTH_SHORT).show();

        } else {


            altura = Float.parseFloat(etAlto.getText().toString());
            peso = Float.parseFloat(etPeso.getText().toString());

            imc = (peso) / (altura * altura);

            String sol = ""+imc;

            Intent i = new Intent(this, Resultado.class);
            i.putExtra("ope", sol);
            startActivity(i);
        }


    }



}