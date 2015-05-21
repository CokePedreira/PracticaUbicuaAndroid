package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cokepedreira on 19/5/15.
 */
public class Tablero extends FragmentActivity {

    private List<Jugador> jugadores;
    private List<Casilla> casillas;

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        cargarTablero();
        jugadores = new Gson().fromJson(getIntent().getStringExtra("jugadores"), new TypeToken<ArrayList<Jugador>>(){}.getType());
        setTitle(casillas.get(0).getNombre());

        viewPager = (ViewPager) findViewById(R.id.tablero_viewPager);
        pagerAdapter = new TableroPagerAdapter(getSupportFragmentManager(), casillas);
        viewPager.setAdapter(pagerAdapter);
    }

    public void cargarTablero() {
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(getAssets().open("casillas.json")));
            this.casillas = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Casilla>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}