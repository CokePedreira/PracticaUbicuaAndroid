package com.example.cokepedreira.ocalimochoapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private List<Jugador> jugadores;
    private List<EditText> nombresJugadores;
    private LinearLayout textViewsView;
    private Button startButton;
    //private ScrollView scrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Ocalimocho");


        jugadores = new ArrayList<>();
        nombresJugadores = new ArrayList<>();
        //scrollView = (ScrollView) findViewById(R.id.players_selection_scroll_view);
        textViewsView = (LinearLayout) findViewById(R.id.text_views_view);
        añadeNombreJugador();
        startButton = (Button) findViewById(R.id.start_button);
        FloatingActionButton añadirButton = (FloatingActionButton) findViewById(R.id.fab);
        //añadirButton.attachToScrollView(scrollView);


        añadirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadeNombreJugador();
                if(nombresJugadores.size() == 1) {
                    startButton.setEnabled(true);
                }
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
        final EditText nombreJugador = (EditText) getLayoutInflater().inflate(R.layout.nombre_jugador, textViewsView, false);
        nombresJugadores.add(nombreJugador);
        nombreJugador.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Eliminar")
                    .setMessage("¿Seguro desea eliminar " + (nombreJugador.getText().toString().isEmpty() ? "al jugador " + (nombresJugadores.indexOf(nombreJugador) + 1) : "a " + nombreJugador.getText().toString()) + "?")
                    .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            nombreJugador.setVisibility(View.GONE);
                            nombresJugadores.remove(nombreJugador);

                            if (nombresJugadores.size() == 0) {
                                startButton.setEnabled(false);
                            }
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .show();

                return false;
            }
        });

        textViewsView.addView(nombreJugador);
        nombreJugador.requestFocus();
    }
}
