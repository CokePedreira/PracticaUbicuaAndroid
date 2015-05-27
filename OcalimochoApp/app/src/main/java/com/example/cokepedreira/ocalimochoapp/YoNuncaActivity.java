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


public class YoNuncaActivity extends ActionBarActivity {

    List<String> yoNunca;



    TextView titulo;
    ImageView imageYoNunca;
    TextView listaYoNunca;
    Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yo_nunca);

        titulo = (TextView) findViewById(R.id.titulo);
        listaYoNunca = (TextView) findViewById(R.id.yoNunca);
        continuar = (Button) findViewById(R.id.continuar);
        yoNunca = new ArrayList<>();
        añadirYoNunca();
        Random rand = new Random();
        int tirada = rand.nextInt(30);
        listaYoNunca.setText(yoNunca.get(tirada));
    }

    public void añadirYoNunca(){

        yoNunca.add("Yo nunca me he bañado desnudo en la playa");
        yoNunca.add("Yo nunca he bebido hasta mearme encima");
        yoNunca.add("Yo nunca me he caido bailando en la discoteca");
        yoNunca.add("Yo nunca me he quedado dormido en un baño borracho");
        yoNunca.add("A mi nunca me han echado de la discoteca por fumar dentro");
        yoNunca.add("Yo nunca he hecho dos hidalgos seguidos");
        yoNunca.add("Yo nunca he hecho o me han hecho una cobra");
        yoNunca.add("Yo nunca he probado el sexo anal");
        yoNunca.add("A mi nunca me ha molado un profesor");
        yoNunca.add("Yo nunca he llorado con una pelicula");
        yoNunca.add("Yo nunca me he picado con un amigo/a por un chico/a");
        yoNunca.add("Yo nunca he invitado a una copa a un ligue");
        yoNunca.add("Yo nunca he probado los porros");
        yoNunca.add("Yo nunca he jugado a la play borrachisimo");
        yoNunca.add("Yo nunca he jugado con juguetes sexuales");
        yoNunca.add("Yo nunca he follado la primera noche");
        yoNunca.add("Yo nunca me he tocado viendo porno");
        yoNunca.add("Yo nunca me he colado en una discoteca");
        yoNunca.add("Yo nunca he bebido sin hielos porque no habia");
        yoNunca.add("Yo nunca me he comido un chicle que estaba en un asiento o una mesa");
        yoNunca.add("Yo nunca he cambiado la sal por el azucar para hacer la gracia");
        yoNunca.add("Yo nunca he dicho: Hoy una cervecita y para casa y al final resulto que no...");
        yoNunca.add("Yo nunca he follado en publico");
        yoNunca.add("Yo nunca he dicho de resaca: Se acabo, no vuelvo a beber");
        yoNunca.add("Yo nunca he tirado a alguien la copa sin querer(o queriendo)");
        yoNunca.add("Yo nunca lo he hecho con mas de una persona el mismo dia");
        yoNunca.add("Yo nunca me he inventado la letra de una cancion en ingles porque no tenia ni puta idea");
        yoNunca.add("Yo nunca he llorado borracho(o fumado) asi porque si");
        yoNunca.add("Yo nunca he roto algo y echado la culpa a otro");
        yoNunca.add("A mi nunca me han dejado a medias");


    }

    public void volverTablero(View view){

        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yo_nunca, menu);
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
