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

    @Override
    public int compareTo(Empleado empleado) {
        return Integer.compare(this.prioridad, empleado.prioridad);
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
