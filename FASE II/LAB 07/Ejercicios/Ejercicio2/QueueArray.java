package Ejercicio2;

import Actividad2.Queue;
import Actividad1.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {

    private int maxSize;
    private E[] array;
    private int first;
    private int last;

    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        array = (E[]) new Object[maxSize];
        first = -1;
        last = -1;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return (last + 1) % maxSize == first;
    }

    public void enqueue(E element) {
        if (isEmpty()) {
            first = last = 0;
        } else {
            last = (last + 1) % maxSize; // aritmética modular
        }
        array[last % maxSize] = element;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía. No se pueden desencolar elementos.");
        }
        E element = array[first];
        if (first == last) {
            first = last = -1;
        } else {
            first = (first + 1) % maxSize; // aritmética modular
        }
        return element;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía. No hay elementos para mostrar.");
        }
        return array[first];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía. No hay elementos para mostrar.");
        }
        return array[first];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!isEmpty()) {
            sb.append(array[first]);
            for (int i = (first + 1) % maxSize; i != (last + 1) % maxSize; i = (i + 1) % maxSize) {
                sb.append(", ");
                sb.append(array[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
