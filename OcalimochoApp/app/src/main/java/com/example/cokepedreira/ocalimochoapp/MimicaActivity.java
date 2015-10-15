package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
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


public class MimicaActivity extends BaseActivity {

    List<String> peliculas;

    @Bind(R.id.imagenmimica) ImageView imageMimica;
    @Bind(R.id.instrucciones) TextView instrucciones;
    @Bind(R.id.pelicula) TextView listaPelicula;
    @Bind(R.id.cronometro) TextView cronometro;
    @Bind(R.id.continuar) Button continuar;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimica);
        ButterKnife.bind(this);

        imageMimica.setImageResource(R.drawable.mimica);
        continuar.setEnabled(false);

        peliculas = new ArrayList<>();
        añadirPeliculas();
        Random rand = new Random();
        int tirada = rand.nextInt(peliculas.size());
        listaPelicula.setText(peliculas.get(tirada));


        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                cronometro.setText("Te quedan: " + millisUntilFinished / 1000 + " segundos");
            }

            public void onFinish() {
                listaPelicula.setText("Se te ha terminado el tiempo");
                continuar.setEnabled(true);
                instrucciones.setVisibility(View.GONE);
                cronometro.setVisibility(View.GONE);

            }
        }.start();

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
