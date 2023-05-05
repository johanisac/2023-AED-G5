package Ejercicio2;

import Actividad1.ExceptionIsEmpty;

public class Test {

    public static void main(String[] args) throws ExceptionIsEmpty {
        QueueArray<Integer> colaEnteros = new QueueArray<>(5);
        // QueueArray<Float> colaFlotantes = new QueueArray<>(5);
        // QueueArray<String> colaCadenas = new QueueArray<>(5);
        // QueueArray<Boolean> colaBooleanos = new QueueArray<>(5);
        // Operaciones con la cola de enteros
        System.out.println("\n\tcola de enteros\n");
        colaEnteros.enqueue(1);
        colaEnteros.enqueue(2);
        colaEnteros.enqueue(3);
        colaEnteros.enqueue(4);
        colaEnteros.enqueue(5);
        System.out.println("Pila de enteros: " + colaEnteros);
        System.out.println("Primer elemento  " + colaEnteros.front());
        System.out.println("Último elemento : " + colaEnteros.back());

        System.out.println(colaEnteros.dequeue());
        System.out.println(colaEnteros.dequeue());
        System.out.println(colaEnteros.dequeue());
        System.out.println("Pila de enteros: " + colaEnteros);

        System.out.println(colaEnteros.dequeue());
        System.out.println(colaEnteros.dequeue());

        System.out.println("¿La cola  está vacía? " + colaEnteros.isEmpty());
        System.out.println("¿La cola  está llena? " + colaEnteros.isFull());
        System.out.println("Pila de enteros: " + colaEnteros);

    }

}
