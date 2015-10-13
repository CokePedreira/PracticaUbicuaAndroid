package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
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


public class MimicaActivity extends BaseActivity {

    List<String> peliculas;



    ImageView imageMimica;
    TextView instrucciones;
    TextView listaPelicula;
    Button continuar;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimica);
        setTitle("Mímica");
        instrucciones = (TextView) findViewById(R.id.instrucciones);
        listaPelicula = (TextView) findViewById(R.id.pelicula);
        continuar = (Button) findViewById(R.id.continuar);
        imageMimica = (ImageView) findViewById(R.id.imagenmimica);
        imageMimica.setImageResource(R.drawable.mimica);

        peliculas = new ArrayList<>();
        añadirPeliculas();
        Random rand = new Random();
        int tirada = rand.nextInt(peliculas.size());
        listaPelicula.setText(peliculas.get(tirada));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listaPelicula.setText("Se te ha terminado el tiempo");
                instrucciones.setVisibility(View.GONE);

            }
        }, 30000/* 30sec delay */);

    }

    public void volverTablero(View view){

        finish();
    }

    public void añadirPeliculas(){

        peliculas.add("Godzilla");
        peliculas.add("Los tres mosqueteros");
        peliculas.add("Harry Potter");
        peliculas.add("El señor de los anillos");
        peliculas.add("300");
        peliculas.add("Saw");
        peliculas.add("Scream");
        peliculas.add("Resacon en las vegas");
        peliculas.add("Star Wars");
        peliculas.add("Jurasic Park");
        peliculas.add("La mascara");
        peliculas.add("El rey leon");
        peliculas.add("La sirenita");
        peliculas.add("La bella y la bestia");
        peliculas.add("Tarzan");
        peliculas.add("Tiburon");
        peliculas.add("American pie");
        peliculas.add("Titanic");
        peliculas.add("Rocky");
        peliculas.add("Avatar");
        peliculas.add("El planeta de los simios");
        peliculas.add("Iron man");
        peliculas.add("Matrix");
        peliculas.add("Zombieland");
        peliculas.add("Eduardo manos tijeras");
        peliculas.add("El exorcista");
        peliculas.add("James Bond");
        peliculas.add("El club de los poetas muertos");
        peliculas.add("El pianista");
        peliculas.add("King Kong");
        peliculas.add("ET");
        peliculas.add("Pinocho");
        peliculas.add("Jumanji");
        peliculas.add("La guerra de los mundos");
        peliculas.add("La momia");
        peliculas.add("Indiana Jones");
        peliculas.add("Juego de Tronos");
        peliculas.add("Los Simpsons");
        peliculas.add("Fast and Furious");
        peliculas.add("Los Vengadores");
        peliculas.add("Dragon Ball");
        peliculas.add("Pokemon");
        peliculas.add("X-Men");
        peliculas.add("Malditos Bastardos");


    }

}
