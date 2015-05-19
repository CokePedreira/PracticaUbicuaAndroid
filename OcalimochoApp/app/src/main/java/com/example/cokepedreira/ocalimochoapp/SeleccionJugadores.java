package com.example.cokepedreira.ocalimochoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;


public class SeleccionJugadores extends ActionBarActivity {
    private ArrayList<model> listajugadores;
    private Adapter adapter;
    private TextView[] nombrejugador =  new TextView[8];
    private ListView jugadores;
    Activity activity;
    int numerojugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_jugadores);
        Intent intent = getIntent();
        numerojugadores= Integer.parseInt(intent.getStringExtra("key"));
        jugadores = (ListView) findViewById(R.id.lv_jugadores);
        adapter = new Adapter(this, listajugadores);

        jugadores.setAdapter(adapter);
        for(int i =0;i< numerojugadores;i++){
            nombrejugador[i]= new TextView(this);
            nombrejugador[i].setHint("nombre jugador");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seleccion_jugadores, menu);
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

    public void aniadirFila(final model serie){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listajugadores.add(serie);
                adapter.notifyDataSetChanged();

                jugadores.smoothScrollToPosition(adapter.getCount() - 1);
            }
        });

    }
}
