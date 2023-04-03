public class Ejercicio06 {
    public static void main(String[] args) {
        // Crear objeto Cajoneria para que se pueda almacenar Golosinas
        Cajoneria<Chocolatina> cajoneria = new Cajoneria<Chocolatina>(3);

        // Se crea 5 Chocolatina y se almace a la cajonería
        Chocolatina cho1 = new Chocolatina("Teoscher");
        Chocolatina cho2 = new Chocolatina("Callebaut");
        Chocolatina cho3 = new Chocolatina("Alpezzi");
        Chocolatina cho4 = new Chocolatina("Confections");
        Chocolatina cho5 = new Chocolatina("Bremen");

        cajoneria.add(new Caja<Chocolatina>("Cafe", 3));
        cajoneria.add(new Caja<Chocolatina>("Blanco", 3));
        cajoneria.add(new Caja<Chocolatina>("Azul", 3));

        cajoneria.get(0).add(cho5);
        cajoneria.get(1).add(cho2);
        cajoneria.get(2).add(cho3);
        cajoneria.get(2).add(cho4);

        // El metodo buscar en chocolatina
        System.out.println("");
        System.out.println(cajoneria.search(cho1));
        System.out.println(cajoneria.search(cho3));

        // El método delete en chocolatina
        System.out.println("");
        Chocolatina eliminada = cajoneria.eliminar(cho3);
        System.out.println((eliminada != null) ? "Se Elimiino a  " + eliminada
                : "La golosina no se encuentra en la cajoneria");
        eliminada = cajoneria.eliminar(cho3);
        System.out.println((eliminada != null) ? "Se Elimiino a  " + eliminada
                : "La golosina no se encuentra en la cajoneria");

        // Imprimir
        System.out.println("");
        System.out.println("Chocolatinas restantes en la cajonería:");
        System.out.println(cajoneria.toString());
    }

}
