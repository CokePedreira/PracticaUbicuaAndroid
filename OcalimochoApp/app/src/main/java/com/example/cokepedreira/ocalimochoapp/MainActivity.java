package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.comenzar) Button comenzar;
    @Bind(R.id.minijuegos) Button minijuegos;
    @Bind(R.id.cambiarTema) Switch cambiarTema;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ButterKnife.bind(this);

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SelectorJugadoresActivity.class);
                startActivity(intent);
                finish();
            }
        });

        minijuegos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ListaMinijuegosActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
