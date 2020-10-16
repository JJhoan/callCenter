package com.company.colaboradores;

import java.util.Random;

public class Llamada {

    private final float tiempo;
    private final int idLlamada;

    public Llamada(int id) {
        this.tiempo = new Random().nextFloat() * (5000 - 10000) + 10000;
        this.idLlamada = id;
    }

    public float getTiempo() {
        return tiempo;
    }

    public int getIdLlamada() {
        return idLlamada;
    }
}
