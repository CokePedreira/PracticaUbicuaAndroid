package com.example.cokepedreira.ocalimochoapp;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cokepedreira on 19/5/15.
 */

public class Casilla {

    @Expose private String nombre;
    @Expose private String posicion;
    @Expose private String imagen;
    @Expose private String descripcion;
    @Expose private Accion accion;
    @Expose private String color;
    @Expose private List<Jugador> jugadoresEnLaCasilla = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Accion getAccion() {
        return accion;
    }

    public List<Jugador> getJugadoresEnLaCasilla() {
        return jugadoresEnLaCasilla;
    }

    public String getColor() {
        return color;
    }
}
