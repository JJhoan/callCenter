package com.company.servicios;

import com.company.colaboradores.Empleado;
import com.company.colaboradores.Llamada;

import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Logger;

public class DispatcherImpl implements Runnable, IDispatcher {

    private final Llamada llamada;
    private final PriorityBlockingQueue<Empleado> empleados;
    public final Logger log = Logger.getLogger(this.getClass().toString());

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
        Empleado empleado = empleados.poll();
        try {
            System.out.println("-> Llamada entrante " + llamada.getIdLlamada());
            if(Objects.isNull(empleado)) {
                System.out.println("    <- Llamada "+llamada.getIdLlamada()+" en espera.");
                Thread.sleep((long) llamada.getTiempo());
            }

            empleado = empleados.take();
            System.out.println(" ---- " + empleado.getNombre() + " tomo la llamada " + llamada.getIdLlamada() + "\n");

            Thread.sleep((long) llamada.getTiempo());

            empleados.add(empleado);
            log.info(" **** El empleado " + empleado.getNombre() + " termino con la llamada " + empleado.getId() + "\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
