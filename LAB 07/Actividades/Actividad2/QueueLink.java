package Actividad2;

import Actividad1.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        Node<E> aux = new Node<E>(x);
        if (this.isEmpty()) {
            this.first = aux;
        } else {
            this.last.setNext(aux);
        }
        this.last = aux;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        E frontElement = first.getElement();
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        return frontElement;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return first.getElement();
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return last.getElement();
    }

    public boolean isEmpty() {
        return first == null;
    }

    // public boolean isFull() {

    //     return false; No sirve porque trabaajmos con lista enlazada
    // }

    public void destroyQueue() {
        this.first = null;
        this.last = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> currentNode = first;
        while (currentNode != null) {
            sb.append(currentNode.getElement());
            if (currentNode.getNext() != null) {
                sb.append(", ");
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
