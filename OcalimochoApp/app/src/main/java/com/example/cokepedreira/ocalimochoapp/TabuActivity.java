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


public class TabuActivity extends ActionBarActivity {
    List<String> personajes;



    ImageView imagenTabu;
    TextView avisoTabu;
    TextView listaPersoanjes;
    Button continuar;
    TextView norma1;
    TextView norma2;
    TextView norma3;
    TextView norma4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabu);
        setTitle("Palabra Tabú");
        avisoTabu = (TextView) findViewById(R.id.AvisoTabu);
        listaPersoanjes = (TextView) findViewById(R.id.personaje);
        continuar = (Button) findViewById(R.id.continuar);
        imagenTabu = (ImageView) findViewById(R.id.imagenTABU);
        imagenTabu.setImageResource(R.drawable.tabu);
        norma1 = (TextView) findViewById(R.id.palabra1);
        norma2 = (TextView) findViewById(R.id.palabra2);
        norma3 = (TextView) findViewById(R.id.palabra3);
        norma4 = (TextView) findViewById(R.id.palabra4);

        personajes = new ArrayList<>();
        añadirPersonajes();
        Random rand = new Random();
        int tirada = rand.nextInt(personajes.size());
        listaPersoanjes.setText(personajes.get(tirada));
        String normas = (String)listaPersoanjes.getText();
        ponerNorma(normas);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listaPersoanjes.setText("Se ha acabado el tiempo");
                norma1.setVisibility(View.GONE);
                norma2.setVisibility(View.GONE);
                norma3.setVisibility(View.GONE);
                norma4.setVisibility(View.GONE);
                avisoTabu.setVisibility(View.GONE);

            }
        }, 30000/* 30sec delay */);


    }

    public void ponerNorma(String normas){


        switch (normas){
            case "Napoleon" :{
                norma1.setText("Frances");
                norma2.setText("Revolucion");
                norma3.setText("Militar");
                norma4.setText("Guerra");
            }
            break;
            case "Hitler" :{
                norma1.setText("Aleman");
                norma2.setText("Nazi");
                norma3.setText("Dictador");
                norma4.setText("Judios");

            };
            break;
            case "Isabel II" :{
                norma1.setText("Reina");
                norma2.setText("España");
                norma3.setText("Exilio");
                norma4.setText("Borbon");

            };
            break;
            case "Pablo Picasso" :{
                norma1.setText("Pintor");
                norma2.setText("España");
                norma3.setText("Cubismo");
                norma4.setText("Cuadro");

            };
            break;
            case "Cristobal Colon" :{
                norma1.setText("America");
                norma2.setText("1492");
                norma3.setText("España");
                norma4.setText("Carabelas");

            };
            break;
            case "Cristiano Ronaldo" :{
                norma1.setText("Futbolista");
                norma2.setText("Portugues");
                norma3.setText("Real Madrid");
                norma4.setText("Balon de Oro");

            };
            break;
            case "Messi" :{
                norma1.setText("Futbolista");
                norma2.setText("Argentina");
                norma3.setText("Barcelona");
                norma4.setText("Balon de Oro");

            };
            break;
            case "Zidane" :{
                norma1.setText("Futbolista");
                norma2.setText("Frances");
                norma3.setText("Real Madrid");
                norma4.setText("Cabezazo");

            };
            break;
            case "Alvaro del Bosque" :{
                norma1.setText("Retraso");
                norma2.setText("Seleecion");
                norma3.setText("Tonto");
                norma4.setText("Hijo");

            };
            break;
            case "Lewis Hamilton" :{
                norma1.setText("Piloto");
                norma2.setText("Mercedes");
                norma3.setText("Campeon");
                norma4.setText("Negro");

            };
            break;
            case "Novak Djokovic" :{
                norma1.setText("Tenista");
                norma2.setText("Primero");
                norma3.setText("Serbia");
                norma4.setText("ATP");

            };
            break;
            case "Johnny Depp" :{
                norma1.setText("Actor");
                norma2.setText("Estravagante");
                norma3.setText("Tim Burton");
                norma4.setText("Disfrad");

            };
            break;
            case "Brat Pitt" :{
                norma1.setText("Actor");
                norma2.setText("Adoptar");
                norma3.setText("Angelina");
                norma4.setText("Aniston");

            };
            break;
            case "Dani Martinez" :{
                norma1.setText("Comico");
                norma2.setText("Tonterias");
                norma3.setText("Imitar");
                norma4.setText("Flo");

            };
            break;
            case "Sasha Grey" :{
                norma1.setText("Porno");
                norma2.setText("Mamadas");
                norma3.setText("Icono");
                norma4.setText("Tetas");

            };
            break;
            case "Lucia LaPiedra" :{
                norma1.setText("Porno");
                norma2.setText("España");
                norma3.setText("Miriam");
                norma4.setText("Nacho Vidal");

            };
            break;
            case "Dani Rovira" :{
                norma1.setText("Comico");
                norma2.setText("Andaluz");
                norma3.setText("Familia");
                norma4.setText("Actor");

            };
            break;
            case "Rachel Bilson" :{
                norma1.setText("Actriz");
                norma2.setText("OC");
                norma3.setText("Preciosa");
                norma4.setText("America");

            };
            break;
            case "Ylenia" :{
                norma1.setText("Choni");
                norma2.setText("Gandia");
                norma3.setText("Tiquitiqui");
                norma4.setText("GHVIP");

            };
            break;
            case "Martin Garrix" :{
                norma1.setText("Dj");
                norma2.setText("Joven");
                norma3.setText("Animals");
                norma4.setText("Discoteca");

            };
            break;
            case "Hardwell" :{
                norma1.setText("Dj");
                norma2.setText("UltraMusic");
                norma3.setText("Electro");
                norma4.setText("Tomorrowland");

            };
            break;
            case "Nach" :{
                norma1.setText("Rap");
                norma2.setText("Español");
                norma3.setText("MC");
                norma4.setText("Vocales");

            };
            break;
            case "Pereza" :{
                norma1.setText("Musica");
                norma2.setText("Fumados");
                norma3.setText("Duo");
                norma4.setText("Princesas");

            };
            break;
            case "Justin Bieber" :{
                norma1.setText("Cantante");
                norma2.setText("Niño");
                norma3.setText("Disney");
                norma4.setText("Odio");

            };
            break;
            case "Metallica" :{

                norma1.setText("Musica");
                norma2.setText("Rock");
                norma3.setText("Guitarra");
                norma4.setText("One");
            };
                break;
            case "Michael Jackson" :{

                norma1.setText("Cantente");
                norma2.setText("Rey");
                norma3.setText("Niños");
                norma4.setText("Operado");
            };
            break;
            case "Oliver Atom" :{

                norma1.setText("Dibujos");
                norma2.setText("Japones");
                norma3.setText("Futbol");
                norma4.setText("Crack");
            };
            break;
            case "Tyrion Lannister" :{

                norma1.setText("Enano");
                norma2.setText("Game Of thrones");
                norma3.setText("Deudas");
                norma4.setText("Putero");
            };
            break;
            case "Frodo" :{

                norma1.setText("Anillo");
                norma2.setText("Pelicula");
                norma3.setText("Hobbit");
                norma4.setText("Bolson");
            };
            break;
            case "Pikachu" :{

                norma1.setText("Pokemon");
                norma2.setText("Amarillo");
                norma3.setText("Rata");
                norma4.setText("Electrico");
            };
            break;
            case "Barney Stinson" :{

                norma1.setText("HIMYM");
                norma2.setText("Salido");
                norma3.setText("PlayBook");
                norma4.setText("Legendario");
            };
            break;
            case "Sheldon Cooper" :{

                norma1.setText("Friki");
                norma2.setText("Fisico");
                norma3.setText("Big Bang");
                norma4.setText("Maniatico");
            };
            break;
           default: norma1.setText("FALLO DE PERSONAJE");

        }


    }
    public void volverTablero(View view){

        finish();
    }

    public void añadirPersonajes(){


        personajes.add("Napoleon");
        personajes.add("Hitler");
        personajes.add("Isabel II");
        personajes.add("Pablo Picasso");
        personajes.add("Cristobal Colon");

        personajes.add("Cristiano Ronaldo");
        personajes.add("Messi");
        personajes.add("Zidane");
        personajes.add("Alvaro del Bosque");
        personajes.add("Lewis Hamilton");
        personajes.add("Novak Djokovic");

        personajes.add("Johnny Depp");
        personajes.add("Brat Pitt");
        personajes.add("Dani Martinez");
        personajes.add("Sasha Grey");
        personajes.add("Lucia LaPiedra");
        personajes.add("Dani Rovira");
        personajes.add("Rachel Bilson");
        personajes.add("Ylenia");

        personajes.add("Martin Garrix");
        personajes.add("Hardwell");
        personajes.add("Nach");
        personajes.add("Pereza");
        personajes.add("Justin Bieber");

        personajes.add("Metallica");
        personajes.add("Michael Jackson");

        personajes.add("Oliver Atom");
        personajes.add("Tyrion Lannister");
        personajes.add("Frodo");
        personajes.add("Pikachu");
        personajes.add("Barney Stinson");
        personajes.add("Sheldon Cooper");
    }
}
