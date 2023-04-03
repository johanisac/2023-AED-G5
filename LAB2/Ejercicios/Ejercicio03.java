public class Ejercicio03 {
    public static void main(String[] args) {
        Cajoneria<Object> cajoneria = new Cajoneria<Object>(500);
        Caja<Object> caja1 = new Caja<Object>("Rojo", 5);
        Caja<Object> caja2 = new Caja<Object>("Azul", 5);
        Chocolatina choco = new Chocolatina("Sublime");
        Golosina Caramelo = new Golosina("Masmelo", 12.5);

        caja1.add("Java");
        caja1.add("Python");
        caja1.add("C++");

        caja2.add(3.1416);
        caja2.add("pi");
        caja2.add(choco);
        caja2.add(Caramelo);

        cajoneria.add(caja1);
        cajoneria.add(caja2);

        for (Caja<Object> caja : cajoneria) {
            System.out.println(caja.toString());
            for (Object objeto : caja) {
                System.out.println("\t - " + objeto);
            }
        }
    }
}
