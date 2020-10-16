package com.company.colaboradores;

public class Empleado implements Comparable<Empleado> {
    private final Integer id;
    private final String nombre;
    private final Integer prioridad;

    public Empleado(Integer id, String nombre, Integer prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public int compareTo(Empleado empleado) {
        return this.prioridad.compareTo( empleado.getPrioridad() );
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}
