package com.example.cokepedreira.ocalimochoapp;

/**
 * Created by cokepedreira on 19/5/15.
 */
public enum Accion {
    MIMICA(MainActivity.class),
    PALABRA_TABU(MainActivity.class),
    YO_NUNCA(MainActivity.class),
    CARTA_ALTA(MainActivity.class),
    RULETA(MainActivity.class),
    MINI_CARRERA(MainActivity.class),
    DUELO(MainActivity.class),
    DUELOTRES(MainActivity.class),
    CARCEL(MainActivity.class),
    LABERINTO(null),
    PATINAZO(null);



    private final Class<?> activityClass;

    Accion(Class<?> activityClass) {
        this.activityClass = activityClass;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }
}
