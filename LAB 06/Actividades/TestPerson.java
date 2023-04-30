public class TestPerson {
    public static void main(String[] args) {
        ListArray<Person> array = new ListArray<>(10);
        ListLinked<Person> linked = new ListLinked<>();

        // insertar elementos al principio
        array.insertFirst(new Person("Johan", "Perez", 25));
        array.insertFirst(new Person("Piero", "Jarata", 40));
        linked.insertFirst(new Person("Maria", "Aguilar", 30));
        linked.insertFirst(new Person("Angeles", "Lopez", 20));

        // insertar elementos al final
        array.insertLast(new Person("Carlos", "Hernandez", 35));
        linked.insertLast(new Person("Luis", "Fernandez", 50));

        // imprimir listas
        System.out.println("Imprimir listas");
        System.out.println("Array: " + array.toString());
        System.out.println("Linked: " + linked.toString());

        // buscar elementos
        int Buscar1 = array.search(new Person("Pedro", "Gonzalez", 40));
        System.out.println("Posicion de Pedro Gonzalez in Array: " + Buscar1);

        int Buscar2 = linked.search(new Person("Maria", "Aguilar", 30));
        System.out.println("Posicion de Maria Aguilar in Linked: " + Buscar2);

        // borrar elementos
        array.removeNode(new Person("Piero", "Jarata", 40));
        linked.removeNode(new Person("Maria", "Aguilar", 30));

        // imprimir listas actualizadas
        System.out.println("Imprimir listas");
        System.out.println("Array: " + array.toString());
        System.out.println("Linked: " + linked.toString());
    }
}
