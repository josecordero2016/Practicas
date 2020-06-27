package com.example.ui1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Reconoce los que tengan un parámetro view
    public void btEnviar(View view){
        //Intent local - Intent que recibirá
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        //Creamos la información a pasar entre actividades - Pares Key-Value
        Bundle b = new Bundle();
        b.putString("NOMBRE", txtNombre.getText().toString());
        //Añadimos la información al intent
        intent.putExtras(b);
        // Iniciamos la nueva actividad
        startActivity(intent);
    }

    public void bntPractica3(View view){
        Intent intent = new Intent(MainActivity.this, Practica3.class);
        startActivity(intent);
    }
}