public class TestList {
    public static void main(String[] args) {
        // Prueba con enteros
        ListArray<Integer> listaEnteros = new ListArray<>(5);
        System.out.println("Prueba de enteros");
        listaEnteros.insertLast(10);
        listaEnteros.insertFirst(500);
        listaEnteros.insertLast(15);
        listaEnteros.insertFirst(0);
        listaEnteros.removeNode(5);
        System.out.println("Longitud: " + listaEnteros.length());
        System.out.println("Posicion de 10: " + listaEnteros.search(10));
        System.out.println("Posicion de 5: " + listaEnteros.search(5));
        listaEnteros.destroyList();
        System.out.println("Lista vacia: " + listaEnteros.isEmptyList());

        // Prueba con cadenas
        ListArray<String> listaCadenas = new ListArray<>(3);
        System.out.println("\nPrueba de cadenas");
        listaCadenas.insertLast("hola");
        listaCadenas.insertFirst("buenos");
        listaCadenas.insertLast("días");
        System.out.println("Longitud: " + listaCadenas.length());
        System.out.println("Posicion de hola: " + listaCadenas.search("hola"));
        System.out.println("Posicion de chau: " + listaCadenas.search("chau"));
        listaCadenas.removeNode("buenos");
        System.out.println("Longitud despues de eliminar buenos: " + listaCadenas.length());

        // Prueba con floats
        ListArray<Float> listaFloats = new ListArray<>(3);
        System.out.println("\nPrueba de floats:");
        listaFloats.insertLast(1.5f);
        listaFloats.insertFirst(0.5f);
        listaFloats.insertLast(2.5f);
        System.out.println("Longitud: " + listaFloats.length());
        System.out.println("Posicion de 1.5: " + listaFloats.search(1.5f));
        System.out.println("Posicion de 3.0: " + listaFloats.search(3.0f));

        // Prueba con booleans
        ListArray<Boolean> listaBooleans = new ListArray<>(2);
        System.out.println("\nPrueba de booleans:");
        listaBooleans.insertLast(true);
        listaBooleans.insertFirst(false);
        System.out.println("Longitud: " + listaBooleans.length());
        System.out.println("Posicion de true: " + listaBooleans.search(true));
        System.out.println("Posicion de false: " + listaBooleans.search(false));
    }
}
