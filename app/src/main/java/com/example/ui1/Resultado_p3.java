package com.example.ui1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


import com.example.ui1.WebService.Asynchtask;

import org.json.JSONException;

import java.util.HashMap;

public class Resultado_p3 extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_p3);
        Bundle b = this.getIntent().getExtras();
        String valores[]=b.getStringArray("Valores");

        HashMap<String,String> datos = new HashMap<String, String>();
        com.example.ui1.WebService.WebService ws= new com.example.ui1.WebService.WebService("http://uealecpeterson.net/ws/login.php?usr="
                + valores[0] + "&pass=" + valores[1],
                datos, Resultado_p3.this, Resultado_p3.this);
        ws.execute("GET");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        TextView tv1 = (TextView)findViewById(R.id.lblResultado);
        tv1.setText("Respuesta de WebService:"+result);
    }
}