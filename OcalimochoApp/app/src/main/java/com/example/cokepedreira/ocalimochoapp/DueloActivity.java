package com.example.cokepedreira.ocalimochoapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class DueloActivity extends ActionBarActivity {


    TextView titulo;
    ImageView imagenDuelo;
    Button dado1;
    Button dado2;
    TextView resultado1;
    TextView resultado2;
    Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo);
        titulo = (TextView) findViewById(R.id.titulo);
        dado1 = (Button) findViewById(R.id.dado1);
        dado2 = (Button) findViewById(R.id.dado2);
        resultado1 = (TextView) findViewById(R.id.resultado1);
        resultado2 = (TextView) findViewById(R.id.resultado2);
        continuar = (Button) findViewById(R.id.continuar);
        imagenDuelo = (ImageView) findViewById(R.id.imagenduelo);
        imagenDuelo.setImageResource(R.drawable.duelo);







    }
    public int aleatorio(){
        Random rand = new Random();
        int tirada = rand.nextInt(6) + 1;

        return tirada;
    }
    public void tirardado1(View view){
       resultado1.setText(Integer.toString(aleatorio()));



    }
    public void tirardado2(View view){

        resultado2.setText(Integer.toString(aleatorio()));

    }

    public void volverTablero(View view){

        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_duelo, menu);
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
