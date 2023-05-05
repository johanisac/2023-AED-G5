package Ejercicio3;
import Actividad1.ExceptionIsEmpty;
import Actividad2.QueueLink;
import Actividad3.PriorityQueue;

public class PriorityQueueLinked<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
    private int numPriorities;
    private QueueLink<E>[] queues;

    public PriorityQueueLinked(int numPriorities) {
        this.numPriorities = numPriorities;
        queues = (QueueLink<E>[]) new QueueLink[numPriorities];
        for (int i = 0; i < numPriorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    public void enqueue(E element, P priority) {
        int index = getPriorityIndex(priority);
        queues[index].enqueue(element);
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public E front() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public E back() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public boolean isEmpty() {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private int getPriorityIndex(P priority) {
        int index = numPriorities - 1;
        for (int i = 0; i < numPriorities - 1; i++) {
            if (priority.compareTo(getPriorityAtIndex(i)) > 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    private P getPriorityAtIndex(int index) {
        // This method should be overridden by subclasses to provide a mapping
        // from index to priority value. The default implementation returns null.
        return null;
    }
}
