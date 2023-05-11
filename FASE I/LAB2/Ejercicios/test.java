public class test {
    // static <T extends Comparable<T>> boolean exist(T[] lista, T element) {
    // for (T item : lista) {
    // if (item.equals(element)) {
    // return true;
    // }
    // }
    // return false;
    // }

    public static <T> boolean exist(T[] lista, T element) {
        for (T item : lista) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] v = { "Perez", "Sanchez", "Rodriguez" };
        Integer[] w = { 12, 34, 56 };
        Golosina a = new Golosina("Fresa", 12.5);
        Golosina b = new Golosina("Netwuia", 10.5);
        Golosina c = new Golosina("Capulite", 1.5);
        Golosina d = new Golosina("Lucuma", 10.5);
        Golosina[] Gol = { a, b, c };

        Chocolatina cha = new Chocolatina("Koala");
        Chocolatina chb = new Chocolatina("Dulce");
        Chocolatina chc = new Chocolatina("Kualena");

        Chocolatina[] Choco = { cha, chb, chc };
        System.out.println(exist(v, "Sanchez"));
        System.out.println(exist(w, 34));
        System.out.println(exist(w, "Salas")); // Error
        System.out.println("Si en la lista Gol existe la golosina d " + exist(Gol, d));
        System.out.println("Si en la lista Gol existe la golosina a " + exist(Gol, a));
        System.out.println("Si en la lista Choco existe la golosina chc " + exist(Choco, chc));

    }

}
