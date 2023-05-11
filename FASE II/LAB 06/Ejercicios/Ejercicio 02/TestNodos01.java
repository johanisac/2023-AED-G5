public class TestNodos01 {
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

        // Prueba de la implementación basada en recursividad
        if (solucion01.isPalindrome(head)) {
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

        // Prueba de la implementación basada en recursividad
        if (solucion01.isPalindrome(head)) {
            System.out.println("\nLa lista enlazada es un palíndromo.");
        } else {
            System.out.println("\nLa lista enlazada no es un palíndromo.");
        }

        head = new Node('z');
        head.next = new Node('y');
        head.next.next = new Node('x');
        head.next.next.next = new Node('x');
        head.next.next.next.next = new Node('y');
        head.next.next.next.next.next = new Node('z');

        printLinkedList(head);

        // Prueba de la implementación basada en recursividad
        if (solucion01.isPalindrome(head)) {
            System.out.println("\nLa lista enlazada es un palíndromo.");
        } else {
            System.out.println("\nLa lista enlazada no es un palíndromo.");
        }
    }
}
