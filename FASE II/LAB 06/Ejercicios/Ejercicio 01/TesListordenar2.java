public class TesListordenar2 {
    public static void main(String[] args) {
        OrderListLinked<Person> personList = new OrderListLinked<>();

        personList.orderedInsert(new Person("Johan", "Perez", 25));
        personList.orderedInsert(new Person("Maria", "Aguilar", 30));
        personList.orderedInsert(new Person("Carlos", "Hernandez", 35));
        personList.orderedInsert(new Person("Josue", "Velarde", 35));

        System.out.println("Imprimiendo lista de personas");
        personList.printList();

        System.out.println("\nBuscando a Johan");
        boolean aliceFound = personList.orderedSearch(new Person("Johan", "Perez", 25));
        System.out.println("Se encuentra Johan : " + aliceFound);

        System.out.println("\nEliminado a Carlos");
        personList.orderedRemove(new Person("Carlos", "Hernandez", 35));
        System.out.println("Lista después de eliminar a Carlos");
        personList.printList();
    }
}
