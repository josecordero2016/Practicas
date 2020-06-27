package com.example.ui1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.example.ui1.WebService.Asynchtask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Practica3 extends AppCompatActivity implements Asynchtask {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica3);
        et1 = (EditText)findViewById(R.id.txtNombreUsuario);
        et2 = (EditText)findViewById(R.id.txtContrasena);
        HashMap<String,String> datos = new HashMap<String, String>();
        com.example.ui1.WebService.WebService ws= new com.example.ui1.WebService.WebService("https://api-uat.kushkipagos.com/transfer-subscriptions/v1/bankList",
                datos, Practica3.this, Practica3.this);
        ws.execute("GET","Public-Merchant-Id","c1db6bee50a1493dac1d337285414418");
    }

    public void btnAcceder(View view){
        String usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();
        Intent in = new Intent(Practica3.this, Resultado_p3.class);
        Bundle b = new Bundle();
        String valores[]={usuario,contrasena};
        b.putStringArray("Valores",valores);
        in.putExtras(b);
        startActivity(in);
    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView et3 = (TextView)findViewById(R.id.lblBancos);
        String lstBancos="";
        JSONArray JSONlista = new JSONArray(result);
        for(int i=0; i< JSONlista.length();i++){
            JSONObject banco = JSONlista.getJSONObject(i);
            lstBancos+="\n"+(banco.getString("name").toString());
        }
        et3.setText(lstBancos);
    }
}