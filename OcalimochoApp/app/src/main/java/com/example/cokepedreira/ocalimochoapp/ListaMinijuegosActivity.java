package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListaMinijuegosActivity extends BaseActivity {

    private List<String> minijuegosNombres;
    private List<Accion> minijuegos;

    @Bind(R.id.minijuegos_list) ListView minijuegosList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_minijuegos);
        ButterKnife.bind(this);

        minijuegos = new ArrayList<>();
        minijuegosNombres = new ArrayList<>();
        for (Accion accion : Accion.values()) {
            if(accion.esMinijuego()) {
                minijuegosNombres.add(accion.getNombre());
                minijuegos.add(accion);
            }
        }

        minijuegosList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, minijuegosNombres));
        minijuegosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaMinijuegosActivity.this, minijuegos.get(position).getActivityClass());
                startActivity(intent);
            }
        });
    }
}
