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

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.ButterKnife;


public class CarcelActivity extends BaseActivity {


    @Bind(R.id.imagencarcel) ImageView imagenCarcel;
    @Bind(R.id.tirada) Button tirardados;
    @Bind(R.id.castigo) TextView castigo;
    @Bind(R.id.continuar) Button continuar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carcel);
        ButterKnife.bind(this);

        imagenCarcel.setImageResource(R.drawable.carcel);
    }


    public int aleatorio(){
        Random rand = new Random();
        int tirada = rand.nextInt(6) + 1;

        return tirada;
    }
    public void tirarDados(View view){
        castigo.setText("La fianza para salir es: " +Integer.toString(   aleatorio() + aleatorio() ) );
        tirardados.setEnabled(false);
        tirardados.setVisibility(View.INVISIBLE);



    }


    public void volverTablero(View view){

        finish();
    }
}
