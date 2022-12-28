package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MasInfo extends AppCompatActivity {

    private final int LLAMADA_TELEFONO = 1;


    Intent i;
    private RadioButton rbtEnlace;
    private RadioButton rbtLlamada;
    private Button btnAccion;
    private Button btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        rbtEnlace = findViewById(R.id.rbtEnlace);
        rbtLlamada = findViewById(R.id.rbtLlamada);
        btnAccion = findViewById(R.id.accionBtn);
        btnAtras = findViewById(R.id.atrasBtn);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_info);



        btnAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if (rbtEnlace.isChecked()) {
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://es.wikipedia.org/wiki/El_emperador_Carlos_V_con_un_perro"));
                    startActivity(i);

                }
                if (rbtLlamada.isChecked()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                            i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)981445566"));
                            startActivity(i);
                        } else {
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONO);
                        }
                    }
                }
            }
        });
    }





    public void nuevas2(View view){
        finishActivity(RESULT_OK);
        finish();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==LLAMADA_TELEFONO){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)981445566"));
                startActivity(i);
            }
            else {
                Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}