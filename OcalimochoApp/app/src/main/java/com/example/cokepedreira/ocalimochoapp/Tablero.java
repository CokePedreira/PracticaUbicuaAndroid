package com.example.cokepedreira.ocalimochoapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import android.support.design.widget.NavigationView;

/**
 * Created by cokepedreira on 19/5/15.
 */
public class Tablero extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private List<Jugador> jugadores;
    private Jugador jugadorActual;

    private List<Casilla> casillas;

    private ViewPager viewPager;
    private PagerAdapter tableroAdapter;

    private Button tirarDado;
    private Button siguienteJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        jugadores = new Gson().fromJson(getIntent().getStringExtra("jugadores"), new TypeToken<ArrayList<Jugador>>() {
        }.getType());

        cargarTablero(jugadores);
        setTitle(casillas.get(0).getNombre());

        viewPager = (ViewPager) findViewById(R.id.tablero_pager);
        tableroAdapter = new TableroPagerAdapter(getSupportFragmentManager(), casillas);
        viewPager.setAdapter(tableroAdapter);
        viewPager.setCurrentItem(0, true);

        // Configurar turno inicial
        this.jugadorActual = jugadores.get(0);
        setTitle(jugadorActual.getNombre());

        // Configurar botones
        tirarDado = (Button) findViewById(R.id.tirarDado);
        siguienteJugador = (Button) findViewById(R.id.siguienteJugador);
        siguienteJugador.setEnabled(false);
        siguienteJugador.setVisibility(View.INVISIBLE);

        tirarDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarDado.setEnabled(false);
                tirarDado.setVisibility(View.INVISIBLE);
                siguienteJugador.setEnabled(true);
                siguienteJugador.setVisibility(View.VISIBLE);

                // Tirar el dado
                Random rand = new Random();
                int tirada = rand.nextInt(6) + 1;
                Toast.makeText(Tablero.this, "Tirada: " + tirada, Toast.LENGTH_SHORT).show();


                if (jugadorActual.puedoSalir()) {

                    // Quitar al jugador de la casilla actual
                    casillas.get(jugadorActual.getCasillaActual()).getJugadoresEnLaCasilla().remove(jugadorActual);

                    if ((jugadorActual.getCasillaActual() + tirada) >= casillas.size()) {
                        tirada -= (casillas.size() - jugadorActual.getCasillaActual());
                        tirada = -tirada;
                    }

                    // Mover jugador e interfaz
                    jugadorActual.setCasillaActual(jugadorActual.getCasillaActual() + tirada);
                    casillas.get(jugadorActual.getCasillaActual()).getJugadoresEnLaCasilla().add(jugadorActual);
                    tableroAdapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(jugadorActual.getCasillaActual(), true);

                    if (casillas.get(jugadorActual.getCasillaActual()).getAccion() != null) {
                        switch (casillas.get(jugadorActual.getCasillaActual()).getAccion()) {

                            case LABERINTO:
                                jugadorActual.setAtrapado(true);

                                break;


                            case PATINAZO:

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        casillas.get(jugadorActual.getCasillaActual()).getJugadoresEnLaCasilla().remove(jugadorActual);
                                        jugadorActual.setCasillaActual(jugadorActual.getCasillaActual() - 20);
                                        casillas.get(jugadorActual.getCasillaActual()).getJugadoresEnLaCasilla().add(jugadorActual);
                                        tableroAdapter.notifyDataSetChanged();
                                        viewPager.setCurrentItem(jugadorActual.getCasillaActual(), true);

                                        Toast.makeText(Tablero.this, "Patinazo: retrocede a la casilla " + jugadorActual.getCasillaActual(), Toast.LENGTH_LONG).show();
                                    }
                                }, 4000/* 4sec delay */);

                                break;

                            case INMUNE:
                                jugadorActual.setInmune(true);
                                break;

                            case MUERTE:
                                if (!jugadorActual.isInmune()) {
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            casillas.get(jugadorActual.getCasillaActual()).getJugadoresEnLaCasilla().remove(jugadorActual);
                                            jugadorActual.setCasillaActual(0);
                                            casillas.get(jugadorActual.getCasillaActual()).getJugadoresEnLaCasilla().add(jugadorActual);
                                            tableroAdapter.notifyDataSetChanged();
                                            viewPager.setCurrentItem(jugadorActual.getCasillaActual(), true);

                                            Toast.makeText(Tablero.this, "Muerte: vuelves a empezar pringao.", Toast.LENGTH_LONG).show();
                                        }
                                    }, 4000/* 4sec delay */);
                                }
                        }
                    }
                } else {

                    if (tirada == 5 || tirada == 6) {
                        jugadorActual.setAtrapado(false);
                        Toast.makeText(Tablero.this, "Sales del laberinto, vuelve a tirar para avanzar.", Toast.LENGTH_LONG).show();
                        tirarDado.setEnabled(true);
                    } else {
                        Toast.makeText(Tablero.this, "Sigues atrapado gilipollas. Bebes " + tirada, Toast.LENGTH_SHORT).show();
                        tirarDado.setEnabled(false);
                    }
                }

            }
        });

        siguienteJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarDado.setEnabled(true);
                tirarDado.setVisibility(View.VISIBLE);
                siguienteJugador.setEnabled(false);
                siguienteJugador.setVisibility(View.INVISIBLE);
                jugadorActual = jugadores.get((jugadores.indexOf(jugadorActual) + 1) % jugadores.size());
                setTitle(jugadorActual.getNombre());
                tableroAdapter.notifyDataSetChanged();
                viewPager.setCurrentItem(jugadorActual.getCasillaActual(), true);

            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void cargarTablero(List<Jugador> jugadores) {
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(getAssets().open("casillas.json")));
            this.casillas = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Casilla>>() {
            }.getType());

            for (Jugador jugador : jugadores) {
                this.casillas.get(0).getJugadoresEnLaCasilla().add(jugador);
            }

//            Collections.reverse(this.casillas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.new_game) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.show_ranking) {

            Intent intent = new Intent(this, RankingActivity.class);

            ArrayList<String> ranking = new ArrayList<>();
            ArrayList<Jugador> copiaListaJugadores = new ArrayList<>(this.jugadores);
            Collections.sort(copiaListaJugadores, new RankingComparator());

            for (Jugador jugador : copiaListaJugadores) {
                ranking.add(jugador.getNombre() + " - Casilla " + jugador.getCasillaActual());
            }

            intent.putExtra("ranking", new Gson().toJson(ranking, new TypeToken<ArrayList<String>>() {
            }.getType()));

            startActivity(intent);
        } else if (id == R.id.options) {

            Intent intent = new Intent(this, Activity_ayuda.class);
            startActivity(intent);


        } else if (id == R.id.theme) {
            setTheme(R.style.AppTheme);


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Seguro que quieres salir?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .show();
    }

    public class RankingComparator implements Comparator<Jugador> {
        public int compare(Jugador object1, Jugador object2) {
            return object2.getCasillaActual() - object1.getCasillaActual();
        }
    }
}