package Actividad3;

import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueueLinkSort<String, Integer> queue = new PriorityQueueLinkSort<>();

        queue.enqueue("flor", 3);
        queue.enqueue("Johan", 1);
        queue.enqueue("Kevin", 10);
        queue.enqueue("Diego", 2);
        System.out.println("Mostrar lista completa");
        System.out.println(queue.toString());
        System.out.println("Muestra ultimo prioridad");
        System.out.println(queue.front());
        System.out.println("Muestra primero prioridad");
        System.out.println(queue.back());
        System.out.println(queue.toString());
        System.out.println("Eliminar ultimo prioridad");
        System.out.println(queue.dequeue());
        System.out.println("Mostrar lista completa");
        System.out.println(queue.toString());
        queue.dequeue();
    }
}
