package Ejercicio3;
import Actividad1.*;
import Actividad2.*;
import Actividad3.*;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueueLinked<Integer, Integer> pq1 = new PriorityQueueLinked<>(3);
        pq1.enqueue(1, 2);
        pq1.enqueue(2, 1);
        pq1.enqueue(3, 3);
        System.out.println(pq1.front()); // Output: 3
        System.out.println(pq1.dequeue()); // Output: 3
        System.out.println(pq1.front()); // Output: 1

        PriorityQueueLinked<Float, Float> pq2 = new PriorityQueueLinked<>(2);
        pq2.enqueue(3.14f, 1.0f);
        pq2.enqueue(2.71f, 2.0f);
        System.out.println(pq2.front()); // Output: 2.71
        System.out.println(pq2.dequeue()); // Output: 2.71
        System.out.println(pq2.front()); // Output: 3.14

        PriorityQueueLinked<Boolean, Integer> pq3 = new PriorityQueueLinked<>(2);
        pq3.enqueue(true, 1);
        pq3.enqueue(false, 2);
        System.out.println(pq3.front()); // Output: false
        System.out.println(pq3.dequeue()); // Output: false
        System.out.println(pq3.front()); // Output: true
    }
}
