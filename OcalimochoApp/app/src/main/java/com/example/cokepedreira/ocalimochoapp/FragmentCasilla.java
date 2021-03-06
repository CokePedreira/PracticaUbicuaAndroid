package com.example.cokepedreira.ocalimochoapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cokepedreira on 21/5/15.
 */

public class FragmentCasilla extends Fragment {

    private Casilla casilla;
    private Jugador jugador;

    @Bind(R.id.nombreCasilla) TextView nombreCasilla;
    @Bind(R.id.posicionCasilla) TextView posicionCasilla;
    @Bind(R.id.listaJugadores) TextView listaJugadores;
    @Bind(R.id.descripcion) TextView descripcion;
    @Bind(R.id.imagen) ImageView imagen;
    @Bind(R.id.accion) Button accion;



    private class Imagen {
        int resourceID;
        String nombre;

        private Imagen(int resourceID, String nombre) {
            this.resourceID = resourceID;
            this.nombre = nombre;
        }

        public int getResourceID() {
            return resourceID;
        }

        public String getNombre() {
            return nombre;
        }
    }

    private List<Imagen> recursosImagen;

    public static FragmentCasilla newInstance(Casilla casilla) {
        FragmentCasilla fragmentCasilla = new FragmentCasilla();
        Bundle args = new Bundle();
        args.putString("casilla", new Gson().toJson(casilla, Casilla.class));
        fragmentCasilla.setArguments(args);
        return fragmentCasilla;
    }

    public FragmentCasilla() {
        cargarArrayRecursos();
    }

    private void cargarArrayRecursos() {
        recursosImagen = new ArrayList<>();

        recursosImagen.add(new Imagen(R.drawable.alante, "alante"));
        recursosImagen.add(new Imagen(R.drawable.amarillo, "amarillo"));
        recursosImagen.add(new Imagen(R.drawable.atras, "atras"));
        recursosImagen.add(new Imagen(R.drawable.azul, "azul"));
        recursosImagen.add(new Imagen(R.drawable.blanco, "blanco"));
        recursosImagen.add(new Imagen(R.drawable.carcel, "carcel"));
        recursosImagen.add(new Imagen(R.drawable.gafas, "cegatos"));
        recursosImagen.add(new Imagen(R.drawable.condon, "condon"));
        recursosImagen.add(new Imagen(R.drawable.corleone, "corleone"));
        recursosImagen.add(new Imagen(R.drawable.duelo, "duelo"));
        recursosImagen.add(new Imagen(R.drawable.duelotres, "duelotres"));
        recursosImagen.add(new Imagen(R.drawable.enfrente, "enfrente"));
        recursosImagen.add(new Imagen(R.drawable.ganas, "ganas"));
        recursosImagen.add(new Imagen(R.drawable.hembras, "hembras"));
        recursosImagen.add(new Imagen(R.drawable.hipnosis, "hipnosis"));
        recursosImagen.add(new Imagen(R.drawable.impares, "impares"));
        recursosImagen.add(new Imagen(R.drawable.inmune, "inmune"));
        recursosImagen.add(new Imagen(R.drawable.laberinto, "laberinto"));
        recursosImagen.add(new Imagen(R.drawable.lengua, "lengua"));
        recursosImagen.add(new Imagen(R.drawable.machos, "machos"));
        recursosImagen.add(new Imagen(R.drawable.minijuego, "minijuego"));
        recursosImagen.add(new Imagen(R.drawable.muerte, "muerte"));
        recursosImagen.add(new Imagen(R.drawable.musculo, "musculo"));
        recursosImagen.add(new Imagen(R.drawable.naranja, "naranja"));
        recursosImagen.add(new Imagen(R.drawable.negro, "negro"));
        recursosImagen.add(new Imagen(R.drawable.par, "par"));
        recursosImagen.add(new Imagen(R.drawable.patin, "patin"));
        recursosImagen.add(new Imagen(R.drawable.patito, "patito"));
        recursosImagen.add(new Imagen(R.drawable.pintados, "pintados"));
        recursosImagen.add(new Imagen(R.drawable.pis, "pis"));
        recursosImagen.add(new Imagen(R.drawable.piti, "piti"));
        recursosImagen.add(new Imagen(R.drawable.pobres, "pobres"));
        recursosImagen.add(new Imagen(R.drawable.posada, "posada"));
        recursosImagen.add(new Imagen(R.drawable.regla, "regla"));
        recursosImagen.add(new Imagen(R.drawable.rojo, "rojo"));
        recursosImagen.add(new Imagen(R.drawable.rosa, "rosa"));
        recursosImagen.add(new Imagen(R.drawable.salida, "salida"));
        recursosImagen.add(new Imagen(R.drawable.sexo, "sexo"));
        recursosImagen.add(new Imagen(R.drawable.suerte, "suerte"));
        recursosImagen.add(new Imagen(R.drawable.travoltas, "travoltas"));
        recursosImagen.add(new Imagen(R.drawable.verde, "verde"));
        recursosImagen.add(new Imagen(R.drawable.zona, "zona"));
        recursosImagen.add(new Imagen(R.drawable.pregunta, "pregunta"));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.casilla = new Gson().fromJson(getArguments().getString("casilla"), Casilla.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_casilla, container, false);
        ButterKnife.bind(this, view);

        nombreCasilla.setText(this.casilla.getNombre());
        posicionCasilla.setText(this.casilla.getPosicion());
        descripcion.setText(this.casilla.getDescripcion());
        File file = new File(Environment.getExternalStorageDirectory()+File.separator + "alante.png"); //your image file path
        if(file.exists()) {
            imagen.setImageURI(Uri.fromFile(file));
        }


        Iterator<Imagen> iterator = this.recursosImagen.iterator();
        Imagen imagenCasilla = null;
        while (iterator.hasNext() && !this.casilla.getImagen().equals((imagenCasilla = iterator.next()).getNombre()));
        if(imagenCasilla != null) {
            imagen.setBackgroundResource(imagenCasilla.getResourceID());
        }
        if(this.casilla.getAccion()==null) {
            accion.setVisibility(View.GONE);
        } else {

            if(this.casilla.getAccion().getActivityClass() == null) {
                accion.setVisibility(View.GONE);
            } else {
                accion.setVisibility(View.VISIBLE);

                if(this.casilla.getAccion() == Accion.CASILLA_FINAL) {
                    accion.setText("Nueva partida");
                }
                accion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FragmentCasilla.this.getActivity(), casilla.getAccion().getActivityClass());
                        if(casilla.getAccion() == Accion.CASILLA_FINAL) {
                            getActivity().finish();
                        }
                        startActivity(intent);
                    }
                });
            }
        }

        String nombresJugadores = "";

        for (Jugador jugador : casilla.getJugadoresEnLaCasilla()) {
            if(casilla.getJugadoresEnLaCasilla().indexOf(jugador) != casilla.getJugadoresEnLaCasilla().size()-1) {
                nombresJugadores += jugador.getNombre() + "\n";
            } else {
                nombresJugadores += jugador.getNombre();
            }
        }

        if(nombresJugadores.isEmpty()) {
            view.findViewById(R.id.tituloListaJugadores).setVisibility(View.GONE);
            listaJugadores.setVisibility(View.GONE);
        } else {
            view.findViewById(R.id.tituloListaJugadores).setVisibility(View.VISIBLE);
            listaJugadores.setVisibility(View.VISIBLE);
            listaJugadores.setText(nombresJugadores);
        }

        return view;
    }
}
