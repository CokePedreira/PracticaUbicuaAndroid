package com.example.cokepedreira.ocalimochoapp;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by andres on 16/05/2015.
 */
public class Jugador implements Serializable {

    @Expose private final String nombre;
    @Expose private int copasADeber;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCopasADeber() {
        return copasADeber;
    }

    public void setCopasADeber(int copasADeber) {
        this.copasADeber = copasADeber;
    }
}
