package Ejercicio3;

import Actividad1.ExceptionIsEmpty;
import Actividad2.QueueLink;
import Actividad3.PriorityQueue;

public class PriorityQueueLinked<E, P extends Comparable<P>> implements PriorityQueue<E, P> {

    private QueueLink<E>[] queues;
    private int numOfPriorities;

    public PriorityQueueLinked(int numOfPriorities) {
        this.numOfPriorities = numOfPriorities;
        queues = new QueueLink[numOfPriorities];
        for (int i = 0; i < numOfPriorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    public void enqueue(E element, P priority) {
        int index = getPriorityIndex(priority);
        queues[index - 1].enqueue(element);
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
        if (priority.compareTo((P) new Integer(numOfPriorities)) < 0 && (int) priority > 0) {
            return (int) priority;
        } else {
            return numOfPriorities;
        }
    }

    public boolean Searchel(E element) {
        for (int i = 0; i < numOfPriorities; i++) {
            if (queues[i].Searchelemto(element)) {
                return true;
            }
        }
        return false;
    }

    public int Searchpriority(E element) {
        for (int i = 0; i < numOfPriorities; i++) {
            if (queues[i].Searchelemto(element)) {
                return i+1;
            }
        }
        return 1;
    }

    public String toString() {

        String sb = "";
        for (int i = 0; i < numOfPriorities; i++) {
            sb += "Prioridad " + (i + 1) + " : ";
            sb += queues[i].toString();
            if (i < numOfPriorities - 1) {
                sb += "\n";
            }
        }
        return sb;
    }
}
