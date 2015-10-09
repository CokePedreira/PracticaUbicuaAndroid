package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Jugador> jugadores;
    private List<EditText> nombresJugadores;
    private LinearLayout textViewsView;
    //private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Ocalimocho");

        jugadores = new ArrayList<>();
        nombresJugadores = new ArrayList<>();

        //scrollView = (ScrollView) findViewById(R.id.players_selection_scroll_view);
        textViewsView = (LinearLayout) findViewById(R.id.text_views_view);
        añadeNombreJugador();
        Button startButton = (Button) findViewById(R.id.start_button);
        FloatingActionButton añadirButton = (FloatingActionButton) findViewById(R.id.fab);
        //añadirButton.attachToScrollView(scrollView);



        añadirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadeNombreJugador();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                for (EditText nombreJugador : nombresJugadores) {
                    jugadores.add(new Jugador(TextUtils.isEmpty(nombreJugador.getText())
                            ? "Jugador " + (++i) : nombreJugador.getText().toString()));


                }

                Intent intent = new Intent(MainActivity.this, Tablero.class);
                intent.putExtra("jugadores", new Gson().toJson(jugadores, new TypeToken<ArrayList<Jugador>>() {
                }.getType()));
                startActivity(intent);
                finish();
            }
        });

    }

    private void añadeNombreJugador() {
        EditText nombreJugador = (EditText) getLayoutInflater().inflate(R.layout.nombre_jugador, textViewsView, false);
        nombresJugadores.add(nombreJugador);
        textViewsView.addView(nombreJugador);
        nombreJugador.requestFocus();
    }
}
