public class TestLists {
    public static void main(String[] args) {
        // Probando con enteros
        System.out.println("Prueba de enteros");
        ListLinked<Integer> intList = new ListLinked<>();
        System.out.println("¿Está vacía la lista de enteros? " + intList.isEmptyList());
        System.out.println("Longitud de la lista de enteros: " + intList.length());
        intList.insertFirst(5);
        intList.insertLast(10);
        intList.insertFirst(2);
        System.out.println("Lista de enteros después de insertar elementos: " + intList.toString());
        intList.removeNode(10);
        System.out.println("Lista de enteros después de eliminar un elemento: " + intList.toString());
        System.out.println("Posición de 2 en la lista de enteros: " + intList.search(2));

        // Probando con cadenas
        ListLinked<String> stringList = new ListLinked<>();
        System.out.println("\nPrueba de cadenas");
        System.out.println("¿La lista de cadenas está vacía? " + stringList.isEmptyList());
        System.out.println("Longitud de la lista de cadenas: " + stringList.length());
        stringList.insertFirst("hello");
        stringList.insertLast("world");
        stringList.insertFirst("sistemas");
        System.out.println("Lista de cadenas después de insertar elementos: " + stringList.toString());
        stringList.removeNode("world");
        System.out.println("lista de cadenas después de eliminar un elemento: " + stringList.toString());
        System.out.println("Posición de 'sistemas' en la lista de cadenas: " + stringList.search("hi"));

        // Probando con floats
        ListLinked<Float> floatList = new ListLinked<>();
        System.out.println("\nPrueba de floats");
        System.out.println("¿La lista flotante está vacía? " + floatList.isEmptyList());
        System.out.println("Longitud de la lista flotante: " + floatList.length());
        floatList.insertFirst(2.55f);
        floatList.insertLast(3.27f);
        floatList.insertFirst(1.23f);
        System.out.println("Lista flotante después de insertar elementos: " + floatList.toString());
        floatList.removeNode(3.27f);
        System.out.println("Lista flotante después de eliminar un elemento: " + floatList.toString());
        System.out.println("Posición de 1.23f en la lista flotante: " + floatList.search(1.3f));

        // Probando con booleans
        ListLinked<Boolean> boolList = new ListLinked<>();
        System.out.println("\nPrueba de booleans");
        System.out.println("¿La lista booleana está vacía? " + boolList.isEmptyList());
        System.out.println("Longitud de la lista booleana: " + boolList.length());
        boolList.insertFirst(true);
        boolList.insertLast(false);
        boolList.insertFirst(false);
        System.out.println("¿La lista booleana está vacía? " + boolList.isEmptyList());
        System.out.println("Lista booleana después de insertar elementos: " + boolList.toString());
        boolList.removeNode(true);
        System.out.println("Lista booleana después de eliminar un elemento: " + boolList.toString());
        System.out.println("Posición de falso en la lista booleana: " + boolList.search(false));
        boolList.destroyList();
        System.out.println("¿La lista booleana está vacía? " + boolList.isEmptyList());
    }
}
