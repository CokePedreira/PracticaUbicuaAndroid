package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
public class Tablero extends ActionBarActivity {

    private List<Jugador> jugadores;
    private List<Casilla> casillas;
    private TextView texto;
    private TextView jugador;
    private Button ok;
    private Button tirar;
    private int turno = 0;
    private Random tirada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casilla);

        cargarTablero();


        jugadores = new Gson().fromJson(getIntent().getStringExtra("jugadores"), new TypeToken<ArrayList<Jugador>>(){}.getType());
        texto = (TextView) findViewById(R.id.textView);
        jugador = (TextView) findViewById(R.id.jugador);
        ok = (Button) findViewById(R.id.button2);
        tirar = (Button) findViewById(R.id.button);
        tirada = new Random();

        setTitle(casillas.get(0).getNombre());

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DEBUG
                Accion accion = casillas.get(1).getAccion();

                if(accion != null) {
                    Intent intent = new Intent(Tablero.this, accion.getActivityClass());
                    startActivity(intent);
                }
            }
        });
    }

    public void cargarTablero() {
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(getAssets().open("casillas.json")));
            this.casillas = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Casilla>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tirar(View view) {
        int dado = (tirada.nextInt() % 6) + 1;
        switch (dado) {
            case 1: {

                break;
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_casilla1, menu);
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