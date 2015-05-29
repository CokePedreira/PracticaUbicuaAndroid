package com.example.cokepedreira.ocalimochoapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class CarcelActivity extends ActionBarActivity {


    TextView titulo;
    ImageView imagenCarcel;
    Button tirardados;
    TextView castigo;
    Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carcel);

        titulo = (TextView) findViewById(R.id.titulo);
        tirardados = (Button) findViewById(R.id.tirada);
        continuar = (Button) findViewById(R.id.continuar);
        imagenCarcel = (ImageView) findViewById(R.id.imagencarcel);
        imagenCarcel.setImageResource(R.drawable.carcel);
        castigo = (TextView) findViewById(R.id.castigo);


    }


    public int aleatorio(){
        Random rand = new Random();
        int tirada = rand.nextInt(6) + 1;

        return tirada;
    }
    public void tirarDados(View view){
        castigo.setText("La fianza para salir es: " +Integer.toString(   aleatorio() + aleatorio() ) );



    }


    public void volverTablero(View view){

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_carcel, menu);
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
