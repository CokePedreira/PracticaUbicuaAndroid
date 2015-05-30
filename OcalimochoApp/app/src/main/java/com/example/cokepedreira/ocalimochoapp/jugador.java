package com.example.cokepedreira.ocalimochoapp;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by andres on 16/05/2015.
 */
public class Jugador implements Serializable {

    @Expose private final String nombre;
    @Expose private int casillaActual;
    private boolean inmune;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.casillaActual = 0;
        this.inmune = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }

    public boolean isInmune() {
        return inmune;
    }

    public void setInmune(boolean inmune) {
        this.inmune = inmune;
    }
}
