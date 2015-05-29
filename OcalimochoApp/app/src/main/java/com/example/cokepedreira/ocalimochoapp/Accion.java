package com.example.cokepedreira.ocalimochoapp;

/**
 * Created by cokepedreira on 19/5/15.
 */
public enum Accion {
    MIMICA(MimicaActivity.class),
    PALABRA_TABU(TabuActivity.class),
    YO_NUNCA(YoNuncaActivity.class),
    CARTA_ALTA(MainActivity.class),
    RULETA(MainActivity.class),
    MINI_CARRERA(MainActivity.class),
    DUELO(DueloActivity.class),
    DUELOTRES(DueloTresActivity.class),
    CARCEL(CarcelActivity.class),
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
