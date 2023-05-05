package Actividad2;

import Actividad1.ExceptionIsEmpty;

public class TestQueue {
    public static void main(String[] args) throws ExceptionIsEmpty {
        // Test with Integer elements
        System.out.println("\n\tPila de enteros\n");
        Queue<Integer> q1 = new QueueLink<>();
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        q1.enqueue(50);
        q1.enqueue(60);
        System.out.println(q1);
        System.out.println(q1.front());
        System.out.println(q1.back());
        q1.dequeue();
        System.out.println(q1.back());
        System.out.println(q1.back());
        q1.dequeue();
        System.out.println(q1);

        System.out.println("\n\tPila de float\n");
        Queue<Float> q2 = new QueueLink<>();
        q2.enqueue(10.5f);
        q2.enqueue(20.5f);
        q2.enqueue(30.5f);
        System.out.println(q2);
        System.out.println(q2.front());
        System.out.println(q2.back());
        q2.dequeue();
        System.out.println(q2);

        System.out.println("\n\tPila de Cadena\n");
        Queue<String> q3 = new QueueLink<>();
        q3.enqueue("Adios");
        q3.enqueue("Java");
        q3.enqueue("UCSM");
        System.out.println(q3);
        System.out.println(q3.front());
        System.out.println(q3.back());
        q3.dequeue();
        System.out.println(q3);

        System.out.println("\n\tPila de Boolean\n");
        Queue<Boolean> q4 = new QueueLink<>();
        q4.enqueue(true);
        q4.enqueue(false);
        System.out.println(q4);
        System.out.println(q4.front());
        System.out.println(q4.back());
        q4.dequeue();
        System.out.println(q4);
    }
}
