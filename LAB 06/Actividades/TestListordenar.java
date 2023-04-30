public class TestListordenar {
    public static void main(String[] args) {
        // Probando con enteros
        System.out.println("Prueba de enteros");
        OrderListLinked<Integer> intList = new OrderListLinked<Integer>();

        // Insertar algunos elementos en la lista
        intList.orderedInsert(10);
        intList.orderedInsert(5);
        intList.orderedInsert(20);
        intList.orderedInsert(15);

        // Imprimir la lista
        System.out.println("Lista ordenada de enteros:");
        intList.printList();

        // Eliminar un elemento de la lista
        System.out.println("Eliminacion del 10 ");
        intList.orderedRemove(10);

        // Imprimir la lista actualizada
        System.out.println("Lista ordenada de enteros actualizada:");
        intList.printList();

        // Buscar un elemento en la lista
        int searchInt = 20;
        if (intList.orderedSearch(searchInt)) {
            System.out.println(searchInt + " está en la lista");
        } else {
            System.out.println(searchInt + " no está en la lista");
        }
        System.out.println("\nPrueba de String");
        // Crear una lista ordenada de cadenas
        OrderListLinked<String> stringList = new OrderListLinked<String>();

        // Insertar algunos elementos en la lista
        stringList.orderedInsert("caracteres");
        stringList.orderedInsert("pruebas");
        stringList.orderedInsert("buenos");
        stringList.orderedInsert("amable");

        // Imprimir la lista
        System.out.println("Lista ordenada de cadenas:");
        stringList.printList();

        // Eliminar un elemento de la lista
        System.out.println("Eliminacion del la palabra amable");
        stringList.orderedRemove("amable");

        // Imprimir la lista actualizada
        System.out.println("Lista ordenada de cadenas actualizada:");
        stringList.printList();

        // Buscar un elemento en la lista
        String searchString = "buenas";
        if (stringList.orderedSearch(searchString)) {
            System.out.println(searchString + " está en la lista");
        } else {
            System.out.println(searchString + " no está en la lista");
        }
    }
}
