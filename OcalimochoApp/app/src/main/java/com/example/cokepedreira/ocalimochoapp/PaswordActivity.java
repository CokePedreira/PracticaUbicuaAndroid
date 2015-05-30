package com.example.cokepedreira.ocalimochoapp;

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


public class PaswordActivity extends ActionBarActivity {

    List<String> palabras;



    TextView titulo;
    ImageView imagenPassword;
    TextView instrucciones;
    TextView listaPalabras;
    Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasword);

        titulo = (TextView) findViewById(R.id.titulo);
        instrucciones = (TextView) findViewById(R.id.instrucciones);
        listaPalabras = (TextView) findViewById(R.id.palabra);
        continuar = (Button) findViewById(R.id.continuar);
        imagenPassword = (ImageView) findViewById(R.id.imagenpassword);
        imagenPassword.setImageResource(R.drawable.password);

        palabras = new ArrayList<>();
        añadirPalabras();
        Random rand = new Random();
        int tirada = rand.nextInt(palabras.size());
        listaPalabras.setText(palabras.get(tirada));

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
        palabras.add("Baca");
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

    }
}
