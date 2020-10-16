package com.company;

import com.company.colaboradores.*;
import com.company.servicios.DispatcherImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

    private final static int llamadas = 100;

    public static void main(String[] args) {
        System.out.println("Comienza!");
        PriorityBlockingQueue<Empleado> queue = new PriorityBlockingQueue<>(  );

        for (int i = 0; i < 5 ; i++) {
            Operador operador = new Operador( i, "Operador " + i, 1);
            queue.add( operador );
        }

        for (int i = 0; i < 3 ; i++) {
            Supervisor supervisor = new Supervisor( i, "Supervisor " + i, 2);
            queue.add( supervisor );
        }

        for (int i = 0; i < 2 ; i++) {
            Director director = new Director( i, "Director " + i, 3);
            queue.add( director );
        }

        ExecutorService executorService = Executors.newFixedThreadPool( llamadas );

        for (int i = 0; i < llamadas ; i++) {
            Llamada llamada = new Llamada(i);
            executorService.execute(new DispatcherImpl(llamada, queue));
        }
    }
}
