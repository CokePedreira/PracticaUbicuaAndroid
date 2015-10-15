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

import butterknife.Bind;
import butterknife.ButterKnife;


public class DueloActivity extends BaseActivity {

    @Bind(R.id.imagenduelo) ImageView imagenDuelo;
    @Bind(R.id.dado1) Button dado1;
    @Bind(R.id.dado2) Button dado2;
    @Bind(R.id.resultado1) TextView resultado1;
    @Bind(R.id.resultado2) TextView resultado2;
    @Bind(R.id.continuar) Button continuar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelo);
        ButterKnife.bind(this);

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
