public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this(data, null);
    }

    // public Node(T data) {
    //     this.data = data;
    //     this.next = null;
    // }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(char c) {
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    // Función para devolver la información almacenada en el nodo
    // Postcondición: Devuelve información.
    public String toString() {
        return "data " + data + "next " + next;

    }
}
