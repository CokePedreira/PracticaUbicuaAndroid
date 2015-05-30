package com.example.cokepedreira.ocalimochoapp;

/**
 * Created by cokepedreira on 19/5/15.
 */
public enum Accion {
    CASILLA_FINAL(MainActivity.class),
    MIMICA(MimicaActivity.class),
    PALABRA_TABU(TabuActivity.class),
    YO_NUNCA(YoNuncaActivity.class),
    PASSWORD(PaswordActivity.class),
    PREGUNTA(PreguntaActivity.class),
    DUELO(DueloActivity.class),
    DUELOTRES(DueloTresActivity.class),
    CARCEL(CarcelActivity.class),
    LABERINTO(null),
    INMUNE(null),
    MUERTE(null),
    PATINAZO(null);



    private final Class<?> activityClass;

    Accion(Class<?> activityClass) {
        this.activityClass = activityClass;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }
}
