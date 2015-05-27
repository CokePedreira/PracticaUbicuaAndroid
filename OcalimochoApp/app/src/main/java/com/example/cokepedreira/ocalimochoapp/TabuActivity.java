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


public class TabuActivity extends ActionBarActivity {
    List<String> personajes;



    TextView titulo;
    ImageView imagenTabu;
    TextView instrucciones;
    TextView listaPersoanjes;
    Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabu);

        titulo = (TextView) findViewById(R.id.titulo);
        instrucciones = (TextView) findViewById(R.id.instrucciones);
        listaPersoanjes = (TextView) findViewById(R.id.personaje);
        continuar = (Button) findViewById(R.id.continuar);
        personajes = new ArrayList<>();
        añadirPersonaje();
        Random rand = new Random();
        int tirada = rand.nextInt(34);
        listaPersoanjes.setText(personajes.get(tirada));
    }
    public void volverTablero(View view){

        finish();
    }

    public void añadirPersonaje(){


        personajes.add("Napoleon");
        personajes.add("Hitler");
        personajes.add("Isabel II");
        personajes.add("Alfonso X");
        personajes.add("Pablo Picasso");

        personajes.add("Cristiano Ronaldo");
        personajes.add("Messi");
        personajes.add("Zidane");
        personajes.add("Alvaro del Bosque");
        personajes.add("Jose Mourinho");
        personajes.add("Pep Guardiola");

        personajes.add("Jonny Depp");
        personajes.add("Brat Pitt");
        personajes.add("Dani Martinez");
        personajes.add("Shasa Grey");
        personajes.add("Lucia LaPiedra");
        personajes.add("Dani Rovira");
        personajes.add("Rachel Bilson");

        personajes.add("Martin Garrix");
        personajes.add("Hardwell");
        personajes.add("David Guetta");
        personajes.add("Avril Lavinge");
        personajes.add("Nach");
        personajes.add("Pereza");
        personajes.add("Justin Bieber");
        personajes.add("Metallica");
        personajes.add("Michael Jackson");
        personajes.add("Cafe Quijano");



        personajes.add("Oliver Atom");
        personajes.add("Tyrion Lannister");
        personajes.add("Frodo");
        personajes.add("Picachu");
        personajes.add("Barney Stinson");
        personajes.add("Sheldon Cooper");





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabu, menu);
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
