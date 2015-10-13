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


public class YoNuncaActivity extends BaseActivity {

    List<String> yoNunca;



    ImageView imageYoNunca;
    TextView listaYoNunca;
    Button continuar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yo_nunca);
        setTitle("Yo nunca");
        listaYoNunca = (TextView) findViewById(R.id.yoNunca);
        continuar = (Button) findViewById(R.id.continuar);

        imageYoNunca = (ImageView) findViewById(R.id.imagenYoNunca);
        imageYoNunca.setImageResource(R.drawable.yo_nunca);

        yoNunca = new ArrayList<>();
        añadirYoNunca();
        Random rand = new Random();
        int tirada = rand.nextInt(yoNunca.size());
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
        yoNunca.add("Yo nunca he fardado de algo que no he hecho");
        yoNunca.add("Yo nunca he conducido borracho");
        yoNunca.add("Yo nunca he robado ago con valor superior a 10€");
        yoNunca.add("Yo nunca le he mirado las tetas a una amiga");
        yoNunca.add("Yo nunca he ligado a traves de internet");
        yoNunca.add("Yo nunca he jugado al Streap Poker");
        yoNunca.add("Yo nunca me he imaginado como seria follar con alguien de los que estan jugando ahora");
        yoNunca.add("Yo nunca negue un beso");
        yoNunca.add("Yo nunca he sentido asco al follar con alguien");
        yoNunca.add("Yo nunca me he olvidado de haber follado con alguen");
        yoNunca.add("Yo nunca me he masturbado mas de 3 veces en un mismo dia");
        yoNunca.add("Yo nunca me he grabado haciendolo");
        yoNunca.add("Yo nunca he besado a alguien del mismo sexo");
        yoNunca.add("Yo nunca me acostaria con alguien por 1000€");
        yoNunca.add("Yo nunca me he despertado aun borracho al dia siguiente");
        yoNunca.add("Yo nunca he dado sexo oral");
        yoNunca.add("Yo nunca he ido a un puti");
        yoNunca.add("Yo nunca he hecho un 69");
        yoNunca.add("Yo nunca he estado con el/la ex de un amigo/a");
        yoNunca.add("Yo nunca me he chocado con un cristal");
        yoNunca.add("Yo nunca he esposado a mi pareja a la cama");
        yoNunca.add("Yo nunca he follado en la ducha");
        yoNunca.add("Yo nunca he vacilado a un policia etando borracho");
        yoNunca.add("Yo nunca he dicho a una chica 'las damas primero' solo la mirarle el culo ");
        yoNunca.add("Yo nunca he buscado mi nombre en google");
        yoNunca.add("Yo nunca he follado en el cine");
        yoNunca.add("Yo nunca he hecho un striptease");
        yoNunca.add("Yo nunca me he colado en una fiesta");
        yoNunca.add("A mi nunca me ha entrado un virus en internet por descargar porno");
        yoNunca.add("Yo nunca me liaria con ninguno de los que esta jugando(si es pareja no vale)");




    }

    public void volverTablero(View view){

        finish();
    }
}
