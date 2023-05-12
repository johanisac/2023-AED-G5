package Ejercicio3;

import Actividad1.ExceptionIsEmpty;
import Actividad2.QueueLink;
import Actividad3.PriorityQueue;

public class PriorityQueueLinked<E, P extends Comparable<P>> implements PriorityQueue<E, P> {

    private QueueLink<E>[] queues;
    private int numOfPriorities;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int numOfPriorities) {
        this.numOfPriorities = numOfPriorities;
        queues = new QueueLink[numOfPriorities];
        for (int i = 0; i < numOfPriorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    public void enqueue(E element, P priority) {
        int index = getPriorityIndex(priority);
        queues[index].enqueue(element);
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < numOfPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < numOfPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    public E back() throws ExceptionIsEmpty {
        for (int i = numOfPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    public boolean isEmpty() {
        for (int i = 0; i < numOfPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private int getPriorityIndex(P priority) {
        for (int i = 0; i < numOfPriorities; i++) {
            if (priority.compareTo(getPriority(i)) <= 0) {
                return i;
            }
        }
        return numOfPriorities - 1;
    }

    private P getPriority(int index) {
        int step = 1 + (numOfPriorities - 1) / 10;
        return (P) new Integer(index * step);
    }

    public String toString() {

        String sb = "";
        for (int i = 1; i < numOfPriorities; i++) {
            sb += "Prioridad " + getPriority(i) + " : ";
            sb += queues[i].toString();
            if (i < numOfPriorities - 1) {
                sb += "\n";
            }
        }
        return sb;
    }
}
