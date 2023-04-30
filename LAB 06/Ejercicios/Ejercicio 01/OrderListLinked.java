public class OrderListLinked<T extends Comparable<T>> extends ListLinked<T> {

    // Método para insertar un elemento en su lugar correspondiente manteniendo el
    // orden de la lista
    // Postcondición: El elemento se inserta en su posición ordenada
    public void orderedInsert(T newItem) {
        Node<T> current = first;
        Node<T> previous = null;
        Node<T> newNode = new Node<T>(newItem);

        while (current != null && current.getData().compareTo(newItem) < 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) { // El nuevo elemento es el primero
            first = newNode;
        } else { // El nuevo elemento va después de previous
            previous.setNext(newNode);
        }

        newNode.setNext(current);
        count++;
    }

    // Método para eliminar un elemento manteniendo el orden de la lista
    // Poscondición: El elemento se elimina de la lista manteniendo su orden
    public void orderedRemove(T deleteItem) {
        Node<T> previous = null;
        Node<T> current = first;

        while (current != null && current.getData().compareTo(deleteItem) < 0) {
            previous = current;
            current = current.getNext();
        }

        if (current != null && current.getData().equals(deleteItem)) {
            if (previous == null) { // El elemento a eliminar es el primero
                first = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
            count--;
        }
    }

    // Método para buscar un elemento manteniendo el orden de la lista
    // Postcondición: Devuelve verdadero si el elemento está en la lista
    // y falso si no lo está
    public boolean orderedSearch(T Item) {
        Node<T> current = first;

        while (current != null && current.getData().compareTo(Item) < 0) {
            current = current.getNext();
        }

        if (current != null && current.getData().equals(Item)) {
            return true;
        }
        return false;
    }

    public void printList() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
