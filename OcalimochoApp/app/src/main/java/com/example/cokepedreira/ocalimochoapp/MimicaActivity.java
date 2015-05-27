package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
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


public class MimicaActivity extends ActionBarActivity {

    List<String> peliculas;



    TextView titulo;
    ImageView imageMimica;
    TextView instrucciones;
    TextView listaPelicula;
    Button continuar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimica);

        titulo = (TextView) findViewById(R.id.titulo);
        instrucciones = (TextView) findViewById(R.id.instrucciones);
        listaPelicula = (TextView) findViewById(R.id.pelicula);
        continuar = (Button) findViewById(R.id.continuar);
        peliculas = new ArrayList<>();
        añadirPeliculas();
        Random rand = new Random();
        int tirada = rand.nextInt(20);
        listaPelicula.setText(peliculas.get(tirada));







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
        peliculas.add("Screqm");
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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mimica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
