package com.example.cokepedreira.ocalimochoapp;

/**
 * Created by cokepedreira on 19/5/15.
 */
public enum Minijuego {
    MIMICA(MainActivity.class),
    PALABRA_TABU(MainActivity.class),
    YO_NUNCA(MainActivity.class),
    CARTA_ALTA(MainActivity.class),
    RULETA_COLOR(MainActivity.class),
    MINI_CARRERA(MainActivity.class);

    private final Class<?> activityClass;

    Minijuego(Class<?> activityClass) {
        this.activityClass = activityClass;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }
}
