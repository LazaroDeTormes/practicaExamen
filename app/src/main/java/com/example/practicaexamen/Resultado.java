package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView tw;
    private ImageView imN, imS, imO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tw = findViewById(R.id.resultado);
        imN = findViewById(R.id.imaN);
        imS = findViewById(R.id.imaS);
        imO = findViewById(R.id.imaO);

        Intent i = getIntent();
        String resultado = i.getStringExtra("ope");

        Float eso = Float.parseFloat(resultado);

        if (eso < 25){
            tw.setText("NORMAL");
            imN.setVisibility(View.VISIBLE);
            imS.setVisibility(View.GONE);
            imO.setVisibility(View.GONE);
        } else if (eso >= 25 && eso < 30){
            tw.setText("SOBREPESO");
            imN.setVisibility(View.GONE);
            imS.setVisibility(View.VISIBLE);
            imO.setVisibility(View.GONE);
        } else {
            tw.setText("OBESO");
            imN.setVisibility(View.GONE);
            imS.setVisibility(View.GONE);
            imO.setVisibility(View.VISIBLE);
        }







    }
}