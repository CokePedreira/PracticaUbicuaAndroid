package com.example.cokepedreira.ocalimochoapp;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import java.util.List;

/**
 * Created by cokepedreira on 13/10/15.
 */
enum BoardPersistanceData {
    INSTANCE;

    private List<Jugador> jugadores;
    private Jugador jugadorActual;
    private List<Casilla> casillas;
    private int viewPagerIndex;

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(List<Casilla> casillas) {
        this.casillas = casillas;
    }

    public int getViewPagerIndex() {
        return viewPagerIndex;
    }

    public void setViewPagerIndex(int viewPagerIndex) {
        this.viewPagerIndex = viewPagerIndex;
    }
}
