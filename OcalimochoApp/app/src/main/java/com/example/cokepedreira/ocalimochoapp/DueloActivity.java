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


public class DueloActivity extends BaseActivity {


    ImageView imagenDuelo;
    Button dado1;
    Button dado2;
    TextView resultado1;
    TextView resultado2;
    Button continuar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo);
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
        dado1.setEnabled(false);



    }
    public void tirardado2(View view){

        resultado2.setText(Integer.toString(aleatorio()));
        dado2.setEnabled(false);

    }

    public void volverTablero(View view){

        finish();
    }
}
