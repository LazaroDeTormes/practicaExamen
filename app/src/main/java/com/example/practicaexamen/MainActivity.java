package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    ImageView foto;
    LinearLayout linearPrincipal;
    LinearLayout linearFoto;
    RadioButton rbtIMC;
    RadioButton rbtInfo;
    Button btnCalc;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foto = findViewById(R.id.foto);
        linearPrincipal = findViewById(R.id.linearPrinc);
        linearFoto = findViewById(R.id.linearFoto);
        rbtIMC = findViewById(R.id.rbtIMC);
        rbtInfo = findViewById(R.id.rbtInfo);
        btnCalc = findViewById(R.id.calcularBtn);
        btnInfo = findViewById(R.id.MasInfoBtn);

        foto.setOnClickListener(escuchador);



    }



    public void btnCommand(View view){
        if (rbtIMC.isChecked()){
            btnCalc.setVisibility(View.VISIBLE);
            btnInfo.setVisibility(View.GONE);
        }
        if (rbtInfo.isChecked()){
            btnCalc.setVisibility(View.GONE);
            btnInfo.setVisibility(View.VISIBLE);
        }
    }



    public void nuevasVentanas(View view){
        switch (view.getId()){
            case (R.id.calcularBtn):
                Intent i = new Intent(this, PasarDatosParaCalculo.class);
                startActivity(i);
                break;
            case (R.id.MasInfoBtn):
                Intent in = new Intent(this, MasInfo.class);
                startActivity(in);
                break;
        }
    }





    private View.OnClickListener escuchador = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            linearFoto.setVisibility(View.GONE);
            linearPrincipal.setVisibility(View.VISIBLE);
        }
    };















}