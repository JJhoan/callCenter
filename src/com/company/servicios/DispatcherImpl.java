package com.company.servicios;

import com.company.colaboradores.Empleado;
import com.company.colaboradores.Llamada;
import com.company.colaboradores.Operador;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Logger;

public class DispatcherImpl implements Runnable, IDispatcher {

    private final Llamada llamada;
    private PriorityBlockingQueue<Empleado> empleados;
    public final Logger log = Logger.getLogger(this.getClass().toString());
    public static Boolean papeleo = Boolean.TRUE;

    public DispatcherImpl(Llamada llamada, PriorityBlockingQueue<Empleado> empleados) {
        this.llamada = llamada;
        this.empleados = empleados;
    }

    @Override
    public void run() {
        dispatchCall();
    }

    @Override
    public void dispatchCall() {
        try {
            if(empleados.isEmpty()) {
                System.out.println("Llamada "+llamada.getIdLlamada()+" en espera.");
            }

            Empleado empleado = empleados.take();
            log.info(" ---- " + empleado.getNombre() + " tomo la llamada " + llamada.getIdLlamada() + "\n");

            Thread.sleep((long) llamada.getTiempo());

            if(papeleo) {
                papeleo = false;
                float tiempoPapeleo = new Random().nextFloat() * (5000 - 20000) + 20000;
                log.info(" !! SE DEBE TOMAR UN PAPELEO QUE TOMARA " + tiempoPapeleo / 1000  + " SEGUNDOS\n");
                Thread.sleep((long) tiempoPapeleo);
                papeleo = true;
            }

            empleados.add(empleado);
            log.info(" **** El empleado " + empleado.getNombre() + " termino con la llamada " + empleado.getId() + "\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
