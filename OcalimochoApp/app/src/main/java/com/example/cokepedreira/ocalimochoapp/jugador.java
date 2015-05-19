package com.example.cokepedreira.ocalimochoapp;

import android.app.Activity;

import java.io.Serializable;

/**
 * Created by andres on 16/05/2015.
 */
public class jugador  implements Serializable {
    private String nombre;
    private int copasadeber;
    private Activity casilla;

    public Activity getcasilla(){
        return this.casilla;
    }
    public String getnombre() {
        return this.nombre;
    }
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    public void setcasilla ( Activity casilla){
        this.casilla = casilla;
    }
    public int getcopasadeber(){
        return this.copasadeber;
    }
    public void sumarcopas(int copas){
        this.copasadeber+=copas;
    }
    public jugador(){
        this.nombre ="";
        this.copasadeber=0;

    }
}
