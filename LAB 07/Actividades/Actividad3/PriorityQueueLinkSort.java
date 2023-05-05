package Actividad3;
import Actividad2.*;
import Actividad1.ExceptionIsEmpty;
public class PriorityQueueLinkSort<E, P extends Comparable<P>> implements PriorityQueue<E, P> {

    class EntryNode {
        E data;
        P priority;

        EntryNode(E data, P priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, P pr) {
        EntryNode newEntry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(newEntry);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            Node<EntryNode> current = first;
            Node<EntryNode> previous = null;
            while (current != null && current.getElement().priority.compareTo(pr) >= 0) {
                previous = current;
                current = current.getNext();
            }
            if (previous == null) {
                newNode.setNext(first);
                first = newNode;
            } else if (current == null) {
                last.setNext(newNode);
                last = newNode;
            } else {
                newNode.setNext(current);
                previous.setNext(newNode);
            }
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("No puede eliminar una lista vacia");
        }
        E aux = this.first.getElement().data;
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }
        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola esta vacia");
        }
        return first.getElement().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola esta llena");
        }
        return last.getElement().data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<EntryNode> currentNode = first;
        while (currentNode != null) {
            sb.append("(").append(currentNode.getElement().data).append(", ").append(currentNode.getElement().priority).append(")");
            if (currentNode.getNext() != null) {
                sb.append(", ");
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}