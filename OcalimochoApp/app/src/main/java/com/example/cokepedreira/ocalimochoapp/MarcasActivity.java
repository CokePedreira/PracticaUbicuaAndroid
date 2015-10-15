package com.example.cokepedreira.ocalimochoapp;

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


public class MarcasActivity extends BaseActivity {

    List<String> palabras;



    ImageView imagenmarcas;
    TextView instrucciones;
    TextView listaPalabras;
    Button continuar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcas);
        instrucciones = (TextView) findViewById(R.id.instrucciones);
        listaPalabras = (TextView) findViewById(R.id.marca);
        continuar = (Button) findViewById(R.id.continuar);
        imagenmarcas = (ImageView) findViewById(R.id.imagenmarcas);
        imagenmarcas.setImageResource(R.drawable.marcas);

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

        palabras.add("Condones");
        palabras.add("Leche");
        palabras.add("Ron");
        palabras.add("Polo");
        palabras.add("Supermercado");
        palabras.add("Pais");
        palabras.add("Ordenadores");
        palabras.add("Tabaco");
        palabras.add("Cerveza");
        palabras.add("Nevera");
        palabras.add("Television");
        palabras.add("Agua");
        palabras.add("Pokemon");
        palabras.add("Ketchup");
        palabras.add("Animal");
        palabras.add("Ropa deportiva");
        palabras.add("Equipo de futbol");
        palabras.add("Maquillaje");
        palabras.add("Colonia");
        palabras.add("Asignatura del colegio");
        palabras.add("Pasta");
        palabras.add("Sistema operativo");
        palabras.add("Vater");
        palabras.add("Medicamento");
        palabras.add("Mechero");
        palabras.add("Refresco");
        palabras.add("Helado");
        palabras.add("Pipas");
        palabras.add("Coche");
        palabras.add("Deporte");
        palabras.add("Avion");
        palabras.add("Emisora de radio");
        palabras.add("Movil");
        palabras.add("Boli");
        palabras.add("Gafas");
        palabras.add("Turron");
        palabras.add("Red Social");



    }
}