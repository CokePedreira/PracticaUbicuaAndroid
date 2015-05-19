package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class casilla2 extends ActionBarActivity {
    jugador []jugadores = new jugador[8];
    TextView texto;
    TextView jugador;
    Button ok;
    Button tirar;
    int turno =0;
    Random tirada = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casilla2);
        texto = (TextView) findViewById(R.id.textView);
        jugador = (TextView) findViewById(R.id.jugador);
        ok = (Button)findViewById(R.id.button2);
        tirar = (Button)findViewById(R.id.button);
        tirar.getBackground().setAlpha(0);//255 es visible

        jugador.setHint(jugadores[0].getnombre());

    }

    public void tirar(View view){
        int dado = (tirada.nextInt()%6) +1 ;
        switch(dado){
            case 1: {
                Intent myIntent = new Intent(this, casilla2.class);
                myIntent.putExtra("jugador", this.jugadores[1]) ;
                myIntent.putExtra("turno",turno+1);//Optional parameters
                this.startActivity(myIntent);
                break;
            }

        }
    }
    public void siguientejugador(View View){
        Intent myIntent = new Intent(this, jugadores[(turno+1)%6].getcasilla());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_casilla2, menu);
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
