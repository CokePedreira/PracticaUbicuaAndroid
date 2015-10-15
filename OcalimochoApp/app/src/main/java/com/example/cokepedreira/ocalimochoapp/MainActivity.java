package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends BaseActivity {

    private Button comenzar;
    private Button minijuegos;
    private Switch cambiarTema;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        comenzar = (Button) findViewById(R.id.comenzar);
        minijuegos = (Button) findViewById(R.id.minijuegos);
        cambiarTema = (Switch) findViewById(R.id.cambiarTema);



        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SelectorJugadoresActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
