package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.comenzar)
    ImageButton comenzar;
    @Bind(R.id.minijuegos)
    ImageButton minijuegos;
    @Bind(R.id.cambiarTema)
    Switch cambiarTema;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ButterKnife.bind(this);

        SharedPreferences prefs = getSharedPreferences("Ocalimocho_Shared_Preferences", MODE_PRIVATE);
        boolean modoNoche = prefs.getBoolean("modo_noche", true);
        if (modoNoche) {
            Utility.setTheme(getApplicationContext(), 2);
        } else {
            Utility.setTheme(getApplicationContext(), 1);
        }

        cambiarTema.setChecked(modoNoche);

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SelectorJugadoresActivity.class);
                startActivity(intent);
            }
        });

        minijuegos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ListaMinijuegosActivity.class);
                startActivity(intent);

            }
        });

        cambiarTema.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = getSharedPreferences("Ocalimocho_Shared_Preferences", MODE_PRIVATE).edit();

                if (isChecked) {
                    editor.putBoolean("modo_noche", true);
                } else {
                    editor.putBoolean("modo_noche", false);
                }

                editor.apply();
                recreate();
            }
        });

    }
    public void recreateActivity() {
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

}
