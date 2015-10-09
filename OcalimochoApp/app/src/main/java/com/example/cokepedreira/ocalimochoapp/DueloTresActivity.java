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


public class DueloTresActivity extends ActionBarActivity {

    ImageView imagenDuelotres;
    Button dado1;
    Button dado2;
    Button dado3;
    TextView resultado1;
    TextView resultado2;
    TextView resultado3;
    Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo_tres);
        setTitle("Triple duelo");

        dado1 = (Button) findViewById(R.id.dado1);
        dado2 = (Button) findViewById(R.id.dado2);
        dado3 = (Button) findViewById(R.id.dado3);
        resultado1 = (TextView) findViewById(R.id.resultado1);
        resultado2 = (TextView) findViewById(R.id.resultado2);
        resultado3 = (TextView) findViewById(R.id.resultado3);
        continuar = (Button) findViewById(R.id.continuar);
        imagenDuelotres = (ImageView) findViewById(R.id.imagenduelo3);
        imagenDuelotres.setImageResource(R.drawable.duelotres);
    }

    public int aleatorio(){
        Random rand = new Random();
        int tirada = rand.nextInt(6) + 1;

        return tirada;
    }
    public void tirardado1(View view){
        resultado1.setText(Integer.toString(aleatorio()));
        dado1.setEnabled(false);
        dado1.setVisibility(View.INVISIBLE);



    }
    public void tirardado2(View view){

        resultado2.setText(Integer.toString(aleatorio()));
        dado2.setEnabled(false);
        dado2.setVisibility(View.INVISIBLE);

    }
    public void tirardado3(View view){

        resultado3.setText(Integer.toString(aleatorio()));
        dado3.setEnabled(false);
        dado3.setVisibility(View.INVISIBLE);

    }


    public void volverTablero(View view){

        finish();
    }
}
