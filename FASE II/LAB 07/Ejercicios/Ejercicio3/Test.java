package Ejercicio3;

import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {

        // Test with Integer elements
        System.out.println("\n\tPila de enteros\n");
        PriorityQueueLinked<Integer, Integer> Enterospryority = new PriorityQueueLinked<>(4);
        Enterospryority.enqueue(10, 1);
        Enterospryority.enqueue(202, 2);
        Enterospryority.enqueue(30, 3);
        Enterospryority.enqueue(50, 2);
        Enterospryority.enqueue(60, 1);
        System.out.println(Enterospryority.toString());
        System.out.println("Primer Elemento: " + Enterospryority.front());
        System.out.println("Ultimo Elemento: " + Enterospryority.back());
        System.out.println("Elemento a Eliminar : " + Enterospryority.dequeue());
        System.out.print("Cola de los elementos: ");
        while (!Enterospryority.isEmpty()) {
            System.out.print(Enterospryority.dequeue() + " ");
        }

        System.out.println("\n\n\tPila de float\n");
        PriorityQueueLinked<Float, Integer> floatpryority = new PriorityQueueLinked<>(4);
        floatpryority.enqueue(10.4f, 3);
        floatpryority.enqueue(202.4f, 3);
        floatpryority.enqueue(30.3f, 1);
        floatpryority.enqueue(50.8f, 2);
        floatpryority.enqueue(60.9f, 1);
        System.out.println(floatpryority.toString());
        System.out.println("Primer Elemento: " + floatpryority.front());
        System.out.println("Ultimo Elemento: " + floatpryority.back());
        System.out.println("Elemento a Eliminar : " + floatpryority.dequeue());
        System.out.print("Cola de los elementos: ");
        while (!floatpryority.isEmpty()) {
            System.out.print(floatpryority.dequeue() + " ");
        }

        System.out.println("\n\n\tPila de Cadena\n");
        PriorityQueueLinked<String, Integer> cadenapryority = new PriorityQueueLinked<>(6);
        cadenapryority.enqueue("Jose", 3);
        cadenapryority.enqueue("Johan", 1);
        cadenapryority.enqueue("Erick", 5);
        cadenapryority.enqueue("Grabiel", 4);
        cadenapryority.enqueue("Favio", 1);
        cadenapryority.enqueue("Angeles", 4);
        cadenapryority.enqueue("Antonio", 3);
        cadenapryority.enqueue("Paul", 5);
        cadenapryority.enqueue("Edwin", 1);
        System.out.println(cadenapryority.toString());
        System.out.println("Primer Elemento: " + cadenapryority.front());
        System.out.println("Ultimo Elemento: " + cadenapryority.back());
        System.out.println("Elemento a Eliminar : " + cadenapryority.dequeue());
        System.out.print("Cola de los elementos: ");
        while (!cadenapryority.isEmpty()) {
            System.out.print(cadenapryority.dequeue() + " ");
        }

    }
}