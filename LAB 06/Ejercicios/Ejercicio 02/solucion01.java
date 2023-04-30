public class solucion01 {
    // Función para construir las cadenas s1 y s2 a partir de los nodos de la lista
    // enlazada
    // en orden de visita y orden inverso de visita, respectivamente
    public static void construct(Node head, StringBuilder s1, StringBuilder s2) {
        // caso base: la lista está vacía
        if (head == null) {
            return;
        }
        // agrega el valor actual del nodo a la cadena s1 y llama a construct()
        // recursivamente con el siguiente nodo
        s1.append(head.data);
        construct(head.next, s1, s2);
        // agrega el valor actual del nodo a la cadena s2
        s2.append(head.data);
    }

    // Función para verificar si una lista enlazada es un palíndromo
    public static boolean isPalindrome(Node head) {
        // construye las cadenas s1 y s2
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        construct(head, s1, s2);

        // compara las cadenas s1 y s2 en orden y reverso, si son iguales, la lista es
        // un palíndromo
        return s1.toString().equals(s2.toString());
    }
}
