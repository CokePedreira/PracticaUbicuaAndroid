package com.example.cokepedreira.ocalimochoapp;

import com.google.gson.annotations.Expose;

/**
 * Created by cokepedreira on 19/5/15.
 */

public class Casilla {

    @Expose private String nombre;
    @Expose private int posicion;
    @Expose private String imagen;
    @Expose private String descripcion;
    @Expose private Accion accion;

    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
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
}
