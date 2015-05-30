package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class SeleccionJugadores extends ActionBarActivity {

    private List<Jugador> jugadores;
    private EditText[] nombresJugadores =  new EditText[8];
    private int numerojugadores;
    private LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_jugadores);

        jugadores = new ArrayList<>();

        numerojugadores= getIntent().getIntExtra("key", 0);

        if(numerojugadores != 0) {
            rootView = (LinearLayout) findViewById(R.id.root_view);
            for (int i = 0; i < numerojugadores; i++) {
                nombresJugadores[i] = new EditText(this);
                rootView.addView(nombresJugadores[i]);
            }
        }

        Button button = new Button(this);
        button.setText("Comenzar");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < numerojugadores; i++) {
                    jugadores.add(new Jugador(TextUtils.isEmpty(nombresJugadores[i].getText()) ? "Jugador " + (i+1) : nombresJugadores[i].getText().toString()));
                }

                Intent intent = new Intent(SeleccionJugadores.this, Tablero.class);
                intent.putExtra("jugadores", new Gson().toJson(jugadores, new TypeToken<ArrayList<Jugador>>(){}.getType()));
                startActivity(intent);
                finish();
            }
        });
        rootView.addView(button);
    }
}
