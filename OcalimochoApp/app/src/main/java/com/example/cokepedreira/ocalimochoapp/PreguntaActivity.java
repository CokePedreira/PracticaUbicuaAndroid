package com.example.cokepedreira.ocalimochoapp;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PreguntaActivity extends BaseActivity {

    List<String> nombrePreguntas;
    ImageView imagenPregunta;
    TextView instrucciones;
    TextView listaPreguntas;
    Button continuar;
    int respuestaCorrecta;
    Button respuesta1;
    Button respuesta2;
    Button respuesta3;
    Button respuesta4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        setTitle("Pregunta");
        instrucciones = (TextView) findViewById(R.id.instrucciones);
        listaPreguntas = (TextView) findViewById(R.id.pregunta);
        continuar = (Button) findViewById(R.id.continuar);
        imagenPregunta = (ImageView) findViewById(R.id.imagenPregunta);
        imagenPregunta.setImageResource(R.drawable.pregunta);
        respuesta1 = (Button) findViewById(R.id.respuesta1);
        respuesta2 = (Button) findViewById(R.id.respuesta2);
        respuesta3 = (Button) findViewById(R.id.respuesta3);
        respuesta4 = (Button) findViewById(R.id.respuesta4);

        nombrePreguntas = new ArrayList<>();
        añadirPregunta();
        Random rand = new Random();
        int tirada = rand.nextInt(nombrePreguntas.size());
        listaPreguntas.setText(nombrePreguntas.get(tirada));
        String normas = (String) listaPreguntas.getText();
        ponerRespuestas(normas);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);

                switch (respuestaCorrecta) {
                    case 1:
                        respuesta1.setEnabled(true);
                        respuesta1.setTextColor(Color.rgb(87, 166, 57));
                        break;

                    case 2:
                        respuesta2.setEnabled(true);
                        respuesta2.setTextColor(Color.rgb(87,166,57));
                        break;

                    case 3:
                        respuesta3.setEnabled(true);
                        respuesta3.setTextColor(Color.rgb(87,166,57));
                        break;

                    case 4:
                        respuesta4.setEnabled(true);
                        respuesta4.setTextColor(Color.rgb(87,166,57));
                        break;
                }

            }
        }, 10000/* 10sec delay */);
    }

    public void respuesta1 (View view){
        if(respuestaCorrecta == 1){
            respuesta1.setEnabled(true);
            respuesta2.setEnabled(false);
            respuesta2.setVisibility(View.INVISIBLE);
            respuesta3.setEnabled(false);
            respuesta3.setVisibility(View.INVISIBLE);
            respuesta4.setEnabled(false);
            respuesta4.setVisibility(View.INVISIBLE);
            respuesta1.setTextColor(Color.rgb(87, 166, 57));
        } else {
            respuesta1.setEnabled(false);
            respuesta1.setTextColor(Color.rgb(255, 0, 0));
            respuesta2.setVisibility(View.INVISIBLE);
            respuesta3.setVisibility(View.INVISIBLE);
            respuesta4.setVisibility(View.INVISIBLE);
        }
    }

    public void respuesta2 (View view){
        if(respuestaCorrecta == 2){
            respuesta1.setEnabled(false);
            respuesta1.setVisibility(View.INVISIBLE);
            respuesta2.setEnabled(true);
            respuesta3.setEnabled(false);
            respuesta3.setVisibility(View.INVISIBLE);
            respuesta4.setEnabled(false);
            respuesta4.setVisibility(View.INVISIBLE);
            respuesta2.setTextColor(Color.rgb(87, 166, 57));
        } else {
            respuesta2.setEnabled(false);
            respuesta2.setTextColor(Color.rgb(255, 0, 0));
            respuesta1.setVisibility(View.INVISIBLE);
            respuesta3.setVisibility(View.INVISIBLE);
            respuesta4.setVisibility(View.INVISIBLE);
        }
    }

    public void respuesta3 (View view){
        if(respuestaCorrecta == 3){
            respuesta1.setEnabled(false);
            respuesta1.setVisibility(View.INVISIBLE);
            respuesta2.setEnabled(false);
            respuesta2.setVisibility(View.INVISIBLE);
            respuesta3.setEnabled(true);
            respuesta4.setEnabled(false);
            respuesta4.setVisibility(View.INVISIBLE);
            respuesta3.setTextColor(Color.rgb(87, 166, 57));
        } else {
            respuesta3.setEnabled(false);
            respuesta3.setTextColor(Color.rgb(255, 0, 0));
            respuesta2.setVisibility(View.INVISIBLE);
            respuesta1.setVisibility(View.INVISIBLE);
            respuesta4.setVisibility(View.INVISIBLE);
        }
    }

    public void respuesta4 (View view){
        if(respuestaCorrecta == 4){
            respuesta1.setEnabled(false);
            respuesta1.setVisibility(View.INVISIBLE);
            respuesta2.setEnabled(false);
            respuesta2.setVisibility(View.INVISIBLE);
            respuesta3.setEnabled(false);
            respuesta3.setVisibility(View.INVISIBLE);
            respuesta4.setEnabled(true);
            respuesta4.setTextColor(Color.rgb(87, 166, 57));
        } else {
            respuesta4.setEnabled(false);
            respuesta4.setTextColor(Color.rgb(255, 0, 0));
            respuesta2.setVisibility(View.INVISIBLE);
            respuesta3.setVisibility(View.INVISIBLE);
            respuesta1.setVisibility(View.INVISIBLE);
        }
    }

    public void ponerRespuestas(String normas){


        switch (normas){
            case "¿A que pais pertenece la isla de Santorini?" :

                respuesta1.setText("Egipto");
                respuesta2.setText("Italia");
                respuesta3.setText("Grecia");
                respuesta4.setText("Chipre");

                respuestaCorrecta = 3;

            break;
            case "Parque natural protegido mas extenso de España con 210.000 hectareas" :

                respuesta1.setText("Ordesa");
                respuesta2.setText("Cazorla Segura");
                respuesta3.setText("Timanfaya");
                respuesta4.setText("Doñana");

                respuestaCorrecta = 2;

                break;
            case "¿Donde desemboca el rio Mijares?" :{
                respuesta1.setText("Almazora");
                respuesta2.setText("Castellon");
                respuesta3.setText("Villarreal");
                respuesta4.setText("Burriana");
                respuestaCorrecta = 2;
            };
            break;
            case "¿Cual es el punto mas meridional de Europa?" :

                respuesta1.setText("Tanger");
                respuesta2.setText("Tarifa");
                respuesta3.setText("Melilla");
                respuesta4.setText("Colin de la frontera");

                respuestaCorrecta = 2;

                break;
            case "¿Cuantas estrellas tiene la bandera de Australia?" :{
                respuesta1.setText("2");
                respuesta2.setText("4");
                respuesta3.setText("6");
                respuesta4.setText("8");

                respuestaCorrecta = 3;
            };
            break;
            case "Unico equipo que ha ganado mas champions que ligas" :

                respuesta1.setText("Nottingham");
                respuesta2.setText("Ajax");
                respuesta3.setText("Bradley");
                respuesta4.setText("Chelsea");

                respuestaCorrecta = 1;

                break;
            case "¿Cuantas copas del rey ha ganado el Real Union?" :

                respuesta1.setText("3");
                respuesta2.setText("4");
                respuesta3.setText("1");
                respuesta4.setText("0");

                respuestaCorrecta = 1;

                break;
            case "¿Como se llamaba antes Mestalla?" :{
                respuesta1.setText("Ciutat de valencia");
                respuesta2.setText("Algiros");
                respuesta3.setText("Luis casanova");
                respuesta4.setText("Mestalleta");
                respuestaCorrecta =3;

            };
            break;
            case "¿Que pais elimino a España en el mundial de futbol de 1990?" :

                respuesta1.setText("Rusia");
                respuesta2.setText("Yugoslavia");
                respuesta3.setText("Italia");
                respuesta4.setText("Francia");

                respuestaCorrecta = 2;

                break;
            case "¿Quien marco el gol mil de los mundiales?" :

                respuesta1.setText("Platini");
                respuesta2.setText("Muller");
                respuesta3.setText("Kempes");
                respuesta4.setText("Rensenbrink");

                respuestaCorrecta = 4;

                break;
            case "¿En que año los Jacksons five su primer numero 1?" :
                respuesta1.setText("1968");
                respuesta2.setText("1969");
                respuesta3.setText("1971");
                respuesta4.setText("1970");
                respuestaCorrecta = 2;

            break;
            case "¿Como se llama la reina del hielo en la pelicula Frozen?" :

                respuesta1.setText("Anna");
                respuesta2.setText("Esmeralda");
                respuesta3.setText("Elsa");
                respuesta4.setText("Ninguna de las anteriores");

                respuestaCorrecta = 3;

                break;
            case "¿Cual es el apellido de un protagonista de Friends?" :

                respuesta1.setText("Maldonado");
                respuesta2.setText("Tribbiani");
                respuesta3.setText("Nakamura");
                respuesta4.setText("Orswell");

                respuestaCorrecta = 2;

                break;
            case "¿Quien no ha sido cantante en Iron Maiden?" :
                respuesta1.setText("Blaze Bayley");
                respuesta2.setText("Paul Di'anno");
                respuesta3.setText("Michael Kiske");
                respuesta4.setText("Bruce Dickinson");
                respuestaCorrecta = 4;


            break;
            case "¿Quien era la mejor amiga de Marissa Cooper en the O.C?" :

                respuesta1.setText("Holly");
                respuesta2.setText("Taylor");
                respuesta3.setText("Summer");
                respuesta4.setText("Lindsey");

                respuestaCorrecta = 3;

                break;
            case "¿Cual de estas rocas no es metamorfica?" :

                respuesta1.setText("Esquisto");
                respuesta2.setText("Marmol");
                respuesta3.setText("Granodiorita");
                respuesta4.setText("Gneis");

                respuestaCorrecta = 3;

                break;
            case "¿Cuantos componentes quimicos tiene el cafe?" :

                respuesta1.setText("850");
                respuesta2.setText("800");
                respuesta3.setText("900");
                respuesta4.setText("1000");

                respuestaCorrecta = 2;

                break;
            case "¿Cuantos meses de gestacion tiene una oveja?" :

                respuesta1.setText("9");
                respuesta2.setText("5");
                respuesta3.setText("4");
                respuesta4.setText("6");

                respuestaCorrecta = 2;

                break;
            case "¿Quien es el creador de Linux?" :

                respuesta1.setText("John Linux");
                respuesta2.setText("Linus Torvalds");
                respuesta3.setText("Steve Jobs");
                respuesta4.setText("Bill Gates");

                respuestaCorrecta = 2;

                break;

            case "¿Cuantos dientes de leche tenemos?" :

                respuesta1.setText("26");
                respuesta2.setText("20");
                respuesta3.setText("30");
                respuesta4.setText("32");

                respuestaCorrecta = 2;

                break;
            case "¿Cual es la montaña rusa mal alta de Europa?" :

                respuesta1.setText("Dragon Khan");
                respuesta2.setText("Shambhala");
                respuesta3.setText("Formula rossa");
                respuesta4.setText("Furius baco");

                respuestaCorrecta = 2;

                break;
            case "¿Donde se celebra el famoso lunes de aguas?" :

                respuesta1.setText("Valencia");
                respuesta2.setText("Bilbao");
                respuesta3.setText("Cadiz");
                respuesta4.setText("Salamanca");

                respuestaCorrecta = 4;

                break;

            case "¿En que año se creo el buscador de imagenes de Google?" :

                respuesta1.setText("2002");
                respuesta2.setText("2000");
                respuesta3.setText("1999");
                respuesta4.setText("1998");

                respuestaCorrecta = 2;

                break;
            case "¿Que es una clementina?" :

                respuesta1.setText("Una enfermedad");
                respuesta2.setText("Una Actriz de cine");
                respuesta3.setText("Una mandarina");
                respuesta4.setText("Una pelicula");

                respuestaCorrecta = 3;

                break;
            case "¿En cuantos paises se conduce por la izquierda?" :

                respuesta1.setText("90");
                respuesta2.setText("12");
                respuesta3.setText("75");
                respuesta4.setText("56");

                respuestaCorrecta = 4;

                break;



            default: respuesta1.setText("FALLO DE RESPUESTA");

        }


    }
    public void volverTablero(View view){

        finish();
    }

    public void añadirPregunta(){


        nombrePreguntas.add("¿A que pais pertenece la isla de Santorini?");
        nombrePreguntas.add("Parque natural protegido mas extenso de España con 210.000 hectareas");
        nombrePreguntas.add("¿Donde desemboca el rio Mijares?");
        nombrePreguntas.add("¿Cual es el punto mas meridional de Europa?");
        nombrePreguntas.add("¿Cuantas estrellas tiene la bandera de Australia?");


        nombrePreguntas.add("Unico equipo que ha ganado mas champions que ligas");
        nombrePreguntas.add("¿Cuantas copas del rey ha ganado el Real Union?");
        nombrePreguntas.add("¿Como se llamaba antes Mestalla?");
        nombrePreguntas.add("¿Que pais elimino a España en el mundial de futbol de 1990?");
        nombrePreguntas.add("¿Quien marco el gol mil de los mundiales?");

        nombrePreguntas.add("¿En que año los Jacksons five su primer numero 1");
        nombrePreguntas.add("¿Como se llama la reina del hielo en la pelicula Frozen?");
        nombrePreguntas.add("¿Cual es el apellido de un protagonista de Friends?");
        nombrePreguntas.add("¿Quien no ha sido cantante en Iron Maiden?");
        nombrePreguntas.add("¿Quien era la mejor amiga de Marissa Cooper en the O.C?");

        nombrePreguntas.add("¿Cual de estas rocas no es metamorfica?");
        nombrePreguntas.add("¿Cuantos componentes quimicos tiene el cafe?");
        nombrePreguntas.add("¿Cuantos meses de gestacion tiene una oveja?");
        nombrePreguntas.add("¿Quien es el creador de Linux?");
        nombrePreguntas.add("¿Cuantos dientes de leche tenemos?");

        nombrePreguntas.add("¿Cual es la montaña rusa mal alta de Europa?");
        nombrePreguntas.add("¿Donde se celebra el famoso lunes de aguas?");
        nombrePreguntas.add("¿En que año se creo el buscador de imagenes de Google?");
        nombrePreguntas.add("¿Que es una clementina?");
        nombrePreguntas.add("¿En cuantos paises se conduce por la izquierda?");
    }
}
