public class Ejercicio05 {
    public static void main(String[] args) {

        // Crear objeto Cajoneria para que se pueda almacenar Golosinas
        Cajoneria<Golosina> cajoneria = new Cajoneria<Golosina>(2);

        // Se crea 5 golosinas y se almace a la cajonería
        Golosina gol1 = new Golosina("Muéganos", 25.0);
        Golosina gol2 = new Golosina("Cocadas", 5.0);
        Golosina gol3 = new Golosina("Bombones", 15.5);
        Golosina gol4 = new Golosina("Gomitas", 12.2);
        Golosina gol5 = new Golosina("Merengues", 7.0);
        Golosina gol6 = new Golosina("Marcianito", 2.0);

        cajoneria.add(new Caja<Golosina>("Rosada", 3));
        cajoneria.add(new Caja<Golosina>("Morada", 2));

        cajoneria.get(0).add(gol1);
        cajoneria.get(0).add(gol3);
        cajoneria.get(0).add(gol5);

        cajoneria.get(1).add(gol2);
        cajoneria.get(1).add(gol4);

        // El metodo buscar en golosinas
        System.out.println(cajoneria.search(gol6));
        System.out.println(cajoneria.search(gol5));

        // El método delete en golosinas
        Golosina eliminada = cajoneria.eliminar(gol1);
        System.out.println((eliminada != null) ? "Se Elimiino a  " + eliminada
                : "La golosina no se encuentra en la cajoneria");
        eliminada = cajoneria.eliminar(gol1);
        System.out.println((eliminada != null) ? "Se Elimiino a  " + eliminada
                : "La golosina no se encuentra en la cajoneria");

        // Imprimir
        System.out.println(cajoneria.toString());

    }
}
