public class ListLinked<T> implements TDAList<T> {
    protected Node<T> first;
    protected int count;

    public ListLinked() {
        first = null;
        count = 0;
    }

    // Función para determinar si la lista está vacía.
    // Postcondición: Devuelve verdadero si la lista está vacía; de lo
    // contrario,devuelve falso.
    public boolean isEmptyList() {
        return first == null;
    }

    // Función para devolver el número de nodos de la lista.
    // Postcondición: Se devuelve el valor de count.
    public int length() {
        return count;
    }

    // Función para borrar todos los nodos de la lista.
    // Poscondición: primero = nulo, cuenta = 0
    public void destroyList() {
        first = null;
        count = 0;
    }

    // Función para determinar si el elemento de búsqueda está en la lista.
    // Postcondición: Devuelve la posición si se encuentra searchItem en la lista;
    // de lo contrario, devuelve -1.
    public int search(T searchItem) {
        Node<T> current = first;
        int position = 1;
        while (current != null) {
            if (current.getData().equals(searchItem)) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1;
    }

    // Función para insertar nuevo elemento en la lista.
    // Postcondición: primero apunta a la nueva lista y se inserta newItem en el
    // comienzo de la lista.
    public void insertFirst(T newItem) {
        Node<T> newNode = new Node<T>(newItem, first);
        first = newNode;
        count++;
    }

    // Función para insertar newItem al final de la lista.
    // Poscondición: primero apunta a la nueva lista, se inserta nuevo elemento al
    // final de la lista.
    public void insertLast(T newItem) {
        Node<T> newNode = new Node<T>(newItem);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        count++;
    }

    // Función para borrar deleteItem de la lista.
    // Condición posterior: si se encuentra, el nodo que contiene deleteItem se
    // elimina del lista, primero apunta al primer nodo de la lista actualizada.
    public void removeNode(T deleteItem) {
        if (first != null) {
            if (first.getData().equals(deleteItem)) {
                first = first.getNext();
                count--;
            } else {
                Node<T> previous = first;
                Node<T> current = first.getNext();
                while (current != null && !current.getData().equals(deleteItem)) {
                    previous = current;
                    current = current.getNext();
                }
                if (current != null) {
                    previous.setNext(current.getNext());
                    count--;
                }
            }
        }
    }

    // Función para devolver la información almacenada en la lista
    // Postcondición: Devuelve información.
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = first;
        while (current != null) {
            result.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return result.toString();
    }
}
