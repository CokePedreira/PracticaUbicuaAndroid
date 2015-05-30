package com.example.cokepedreira.ocalimochoapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cokepedreira on 21/5/15.
 */

public class FragmentCasilla extends Fragment {

    private Casilla casilla;

    private TextView nombreCasilla;
    private TextView listaJugadores;
    private TextView descripcion;
    private ImageView imagen;
    private Button accion;
    private  Jugador jugador;

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
        recursosImagen.add(new Imagen(R.drawable.cegatos, "cegatos"));
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

    }

    public Bitmap urlImageToBitmap(String urlImage) {

        Bitmap mIcon1 = null;
        String imag = "R.drawable."+ urlImage;
        try {
            URL url_value = new URL(urlImage);
            if (url_value != null) {
                mIcon1 = BitmapFactory.decodeStream(url_value.openConnection().getInputStream());
            }
        }catch(Exception e){
            System.out.print("Error");

        }
        return mIcon1;
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
        descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(this.casilla.getDescripcion());

        imagen = (ImageView) view.findViewById(R.id.imagen);
//        imagen.setImageBitmap(urlImageToBitmap(this.casilla.getImagen()));
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
        accion = (Button) view.findViewById(R.id.accion);
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
