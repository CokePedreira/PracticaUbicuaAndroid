package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Jugador> jugadores;
    private List<EditText> nombresJugadores;
    private LinearLayout textViewsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        jugadores = new ArrayList<>();
        nombresJugadores = new ArrayList<>();

        textViewsView = (LinearLayout) findViewById(R.id.text_views_view);
        Button startButton = (Button) findViewById(R.id.start_button);
        FloatingActionButton añadirButton = (FloatingActionButton) findViewById(R.id.añadir_jugadores);

        textViewsView.addView(new EditText(this));


        añadirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombreJugador = new EditText(MainActivity.this);
                nombresJugadores.add(nombreJugador);
                textViewsView.addView(nombreJugador);
            }
        });

        startButton.setText("Comenzar");
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
}
