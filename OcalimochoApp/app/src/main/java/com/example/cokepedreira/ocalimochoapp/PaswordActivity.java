package com.example.cokepedreira.ocalimochoapp;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PaswordActivity extends BaseActivity {

    List<String> palabras;

    @Bind(R.id.imagenpassword) ImageView imagenPassword;
    @Bind(R.id.instrucciones) TextView instrucciones;
    @Bind(R.id.palabra) TextView listaPalabras;
    @Bind(R.id.continuar) Button continuar;
    @Bind(R.id.cronometro)TextView cronometro;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasword);
        ButterKnife.bind(this);

        imagenPassword.setImageResource(R.drawable.password);

        palabras = new ArrayList<>();
        añadirPalabras();
        Random rand = new Random();
        int tirada = rand.nextInt(palabras.size());
        listaPalabras.setText(palabras.get(tirada));
        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                cronometro.setText("Te quedan: " + millisUntilFinished / 1000 + " segundos");
            }

            public void onFinish() {
                listaPalabras.setText("Se te ha terminado el tiempo");
                continuar.setEnabled(true);
                instrucciones.setVisibility(View.GONE);
                cronometro.setVisibility(View.GONE);

            }
        }.start();

    }
    public void volverTablero(View view){

        finish();
    }

    public void añadirPalabras(){

        palabras.add("Invierno");
        palabras.add("Polla");
        palabras.add("Alcohol");
        palabras.add("Cesped");
        palabras.add("Retraso");
        palabras.add("Pais");
        palabras.add("Estufa");
        palabras.add("Gilipollas");
        palabras.add("Vaso");
        palabras.add("Almirante");
        palabras.add("Cable");
        palabras.add("Television");
        palabras.add("Charmander");
        palabras.add("Hueso");
        palabras.add("Enfado");
        palabras.add("Insulto");
        palabras.add("Burrito");
        palabras.add("Vaca");
        palabras.add("Votar");
        palabras.add("Juego");
        palabras.add("Programa");
        palabras.add("Android");
        palabras.add("Ley");
        palabras.add("Medicamento");
        palabras.add("Clase");
        palabras.add("Refresco");
        palabras.add("Uña");
        palabras.add("Pedo");
        palabras.add("Pota");
        palabras.add("Laser");
        palabras.add("Fiesta");
        palabras.add("Cerveza");
        palabras.add("Movil");
        palabras.add("Mechero");
        palabras.add("Correo");
        palabras.add("Hembra");
        palabras.add("Rezar");



    }
}
