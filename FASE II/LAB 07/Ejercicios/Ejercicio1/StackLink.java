package Ejercicio1;

import Actividad1.*;

public class StackLink<E> implements Stack<E> {

    private Node<E> top;

    public StackLink() {
        top = null;
    }

    public void push(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.next = top;
        top = newNode;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No se puede eliminar más elementos.");
        }
        E element = top.element;
        top = top.next;
        return element;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No se puede obtener el elemento superior.");
        }
        return top.element;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return false;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node<E> current = top;
            while (current != null) {
                sb.append(current.element);
                if (current.next != null) {
                    sb.append(", ");
                }
                current = current.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
