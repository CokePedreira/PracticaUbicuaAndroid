package com.example.cokepedreira.ocalimochoapp;

/**
 * Created by cokepedreira on 19/5/15.
 */
public enum Accion {
    CASILLA_FINAL(SelectorJugadoresActivity.class, false, "Casilla final"),
    MIMICA(MimicaActivity.class, true, "Mimica"),
    PALABRA_TABU(TabuActivity.class, true, "Palabra tabú"),
    YO_NUNCA(YoNuncaActivity.class, true, "Yo nunca"),
    PASSWORD(PaswordActivity.class, true, "Password"),
    PREGUNTA(PreguntaActivity.class, true, "Pregunta"),
    DUELO(DueloActivity.class, false, "Duelo"),
    DUELOTRES(DueloTresActivity.class, false, "Duelo tres"),
    CARCEL(CarcelActivity.class, false, "Carcel"),
    LABERINTO(null, false, "Laberinto"),
    INMUNE(null, false, "Inmune"),
    MUERTE(null, false, "Muerte"),
    PATINAZO(null, false, "Patinazo"),
    MARCAS(MarcasActivity.class, true, "Marcas");



    private final Class<?> activityClass;
    private final String nombre;
    private final boolean minijuego;

    Accion(Class<?> activityClass, boolean minijuego, String nombre) {
        this.activityClass = activityClass;
        this.minijuego = minijuego;
        this.nombre = nombre;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }
    public boolean esMinijuego() { return minijuego; }
    public String getNombre() { return nombre; }

}
