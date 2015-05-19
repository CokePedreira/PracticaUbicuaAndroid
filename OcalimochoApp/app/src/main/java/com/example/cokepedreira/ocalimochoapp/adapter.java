package com.example.cokepedreira.ocalimochoapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by andres on 14/05/2015.
 */
 class Adapter extends ArrayAdapter<model> {
    private Activity context;
    private ArrayList<model> items;

    public Adapter(Activity context, ArrayList<model> items) {
        super(context, R.layout.activity_adapter, items);

        this.context = context;
        this.items = items;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_adapter, null);

        final model serie = items.get(position);
        EditText nombreJugador = (EditText) item.findViewById(R.id.et_jugadores);

        nombreJugador.setHint("Nombre Jugador");

        return item;

    }
}

