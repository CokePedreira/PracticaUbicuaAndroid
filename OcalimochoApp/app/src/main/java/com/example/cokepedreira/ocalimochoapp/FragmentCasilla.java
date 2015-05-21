package com.example.cokepedreira.ocalimochoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.gson.Gson;

/**
 * Created by cokepedreira on 21/5/15.
 */

public class FragmentCasilla extends Fragment {

    private Casilla casilla;

    private TextView nombreCasilla;
    private TextView listaJugadores;

    public static FragmentCasilla newInstance(Casilla casilla) {
        FragmentCasilla fragmentCasilla = new FragmentCasilla();
        Bundle args = new Bundle();
        args.putString("casilla", new Gson().toJson(casilla, Casilla.class));
        fragmentCasilla.setArguments(args);
        return fragmentCasilla;
    }

    public FragmentCasilla() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.casilla = new Gson().fromJson(getArguments().getString("casilla"), Casilla.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_casilla, container, false);

        nombreCasilla = (TextView) view.findViewById(R.id.nombreCasilla);
        nombreCasilla.setText(this.casilla.getPosicion() + ": " +this.casilla.getNombre());

        listaJugadores = (TextView) view.findViewById(R.id.listaJugadores);
        String nombresJugadores = "";
        for (Jugador jugador : casilla.getJugadoresEnLaCasilla()) {
            nombresJugadores += jugador.getNombre() + " ";
        }

        if(nombresJugadores.isEmpty()) {
            listaJugadores.setVisibility(View.GONE);
        } else {
            listaJugadores.setVisibility(View.VISIBLE);
            listaJugadores.setText("Jugadores: " + nombresJugadores);
        }

        return view;
    }
}
