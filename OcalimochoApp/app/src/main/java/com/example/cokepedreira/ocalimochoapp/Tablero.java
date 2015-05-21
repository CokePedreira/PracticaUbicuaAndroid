package com.example.cokepedreira.ocalimochoapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cokepedreira on 19/5/15.
 */
public class Tablero extends FragmentActivity {

    private List<Jugador> jugadores;
    private Jugador jugadorActual;

    private List<Casilla> casillas;

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private TextView jugadorActualTextView;
    private Button tirarDado;
    private Button siguienteJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        jugadores = new Gson().fromJson(getIntent().getStringExtra("jugadores"), new TypeToken<ArrayList<Jugador>>(){}.getType());

        cargarTablero(jugadores);
        setTitle(casillas.get(0).getNombre());

        jugadorActualTextView = (TextView) findViewById(R.id.jugadorActual);
        viewPager = (ViewPager) findViewById(R.id.tablero_viewPager);
        pagerAdapter = new TableroPagerAdapter(getSupportFragmentManager(), casillas);
        viewPager.setAdapter(pagerAdapter);

        // Configurar turno inicial
        this.jugadorActual = jugadores.get(0);
        jugadorActualTextView.setText(jugadorActual.getNombre());

        // Configurar botones
        tirarDado = (Button) findViewById(R.id.tirarDado);
        tirarDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarDado.setEnabled(false);

                // Quitar al jugador de la casilla actual
                casillas.get(jugadorActual.getCasillaActual()).getJugadoresEnLaCasilla().remove(jugadorActual);

                // Tirar el dado
                Random rand = new Random();
                int tirada = rand.nextInt(6) + 1;
                Toast.makeText(Tablero.this, "Tirada: " + tirada, Toast.LENGTH_SHORT).show();
                if((jugadorActual.getCasillaActual() + tirada) >= casillas.size()) {
                    tirada -= 2*(casillas.size() - 1 - jugadorActual.getCasillaActual());
                }

                // Mover jugador e interfaz
                jugadorActual.setCasillaActual(jugadorActual.getCasillaActual() + tirada);
                casillas.get(jugadorActual.getCasillaActual()).getJugadoresEnLaCasilla().add(jugadorActual);
                pagerAdapter.notifyDataSetChanged();
                viewPager.setCurrentItem(jugadorActual.getCasillaActual(), true);
            }
        });


        siguienteJugador = (Button) findViewById(R.id.siguienteJugador);
        siguienteJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarDado.setEnabled(true);

                // Cambiar de jugador
                jugadorActual = jugadores.get((jugadores.indexOf(jugadorActual) + 1) % jugadores.size());
                jugadorActualTextView.setText(jugadorActual.getNombre());
                pagerAdapter.notifyDataSetChanged();
                viewPager.setCurrentItem(jugadorActual.getCasillaActual(), true);
            }
        });
    }

    public void cargarTablero(List<Jugador> jugadores) {
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(getAssets().open("casillas.json")));
            this.casillas = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Casilla>>(){}.getType());

            for (Jugador jugador : jugadores) {
                this.casillas.get(0).getJugadoresEnLaCasilla().add(jugador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}