public class TestNodos02 {
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node('W');
        head.next = new Node('B');
        head.next.next = new Node('W');
        head.next.next.next = new Node('R');
        head.next.next.next.next = new Node('A');

        printLinkedList(head);

        // Prueba de la implementación basada en punteros
        solucion02.NodeWrapper left = new solucion02.NodeWrapper(head);
        if (solucion02.isPalindrome(left, head)) {
            System.out.println("\nLa lista enlazada es un palíndromo.");
        } else {
            System.out.println("\nLa lista enlazada no es un palíndromo.");
        }

        head = new Node('5');
        head.next = new Node('4');
        head.next.next = new Node('3');
        head.next.next.next = new Node('2');
        head.next.next.next.next = new Node('1');

        printLinkedList(head);

        // Prueba de la implementación basada en punteros
        left = new solucion02.NodeWrapper(head);
        if (solucion02.isPalindrome(left, head)) {
            System.out.println("\nLa lista enlazada es un palíndromo.");
        } else {
            System.out.println("\nLa lista enlazada no es un palíndromo.");
        }

        head = new Node('Z');
        head.next = new Node('Y');
        head.next.next = new Node('X');
        head.next.next.next = new Node('X');
        head.next.next.next.next = new Node('Y');
        head.next.next.next.next.next = new Node('Z');

        printLinkedList(head);

        // Prueba de la implementación basada en punteros
        left = new solucion02.NodeWrapper(head);
        if (solucion02.isPalindrome(left, head)) {
            System.out.println("\nLa lista enlazada es un palíndromo.");
        } else {
            System.out.println("\nLa lista enlazada no es un palíndromo.");
        }
    }
}
