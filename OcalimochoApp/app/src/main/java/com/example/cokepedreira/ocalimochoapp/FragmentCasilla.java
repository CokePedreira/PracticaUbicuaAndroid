package com.example.cokepedreira.ocalimochoapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;

import java.net.URL;

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


    public static FragmentCasilla newInstance(Casilla casilla) {
        FragmentCasilla fragmentCasilla = new FragmentCasilla();
        Bundle args = new Bundle();
        args.putString("casilla", new Gson().toJson(casilla, Casilla.class));
        fragmentCasilla.setArguments(args);
        return fragmentCasilla;
    }

    public FragmentCasilla() {
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
         imagen.setImageBitmap(urlImageToBitmap(this.casilla.getImagen()));

        accion =(Button) view.findViewById(R.id.accion);
        if(this.casilla.getAccion()==null) {
            accion.setEnabled(false);
        }
        else{
            accion.setEnabled(true);
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
