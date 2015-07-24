package com.example.cokepedreira.ocalimochoapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int numJugadores;
    Button bComenzar;
    EditText etNumJugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         bComenzar = (Button) findViewById(R.id.b_comenzar);
         etNumJugadores = (EditText) findViewById(R.id.et_num_jugadores);

    }

    public void comenzar(View view){
        Context context = getApplicationContext();

        if(!TextUtils.isEmpty(etNumJugadores.getText())) {
            numJugadores = Integer.parseInt(etNumJugadores.getText().toString());
            if (numJugadores <= 8 && numJugadores >= 2) {
                Toast toast = Toast.makeText(context, "ok", Toast.LENGTH_SHORT);
                toast.show();
                Intent myIntent = new Intent(this, SeleccionJugadores.class);
                myIntent.putExtra("key", numJugadores); //Optional parameters
                startActivity(myIntent);
                finish();
            } else {
                Toast toast = Toast.makeText(context, "introduce entre 2 y 8 jugadores", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
