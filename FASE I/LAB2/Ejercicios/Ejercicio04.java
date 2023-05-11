public class Ejercicio04 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Cajoneria<String> cajoneria = new Cajoneria<String>(10);

        String Prueba1 = "Hola";
        String Prueba2 = "mundo";
        String Prueba3 = "15.25";
        String Prueba4 = "Cielo";
        String Prueba5 = "99";

        cajoneria.add(new Caja<String>("Verde", 3));
        cajoneria.add(new Caja<String>("Azul", 2));

        cajoneria.get(0).add(Prueba1);
        cajoneria.get(0).add(Prueba2);
        cajoneria.get(0).add(Prueba4);

        cajoneria.get(1).add(Prueba3);
        cajoneria.get(1).add(Prueba5);

        // El metodo buscar
        System.out.println(cajoneria.search("99"));
        System.out.println(cajoneria.search("90"));
        System.out.println(cajoneria.search("Cielo"));
        System.out.println("");
        // El método delete

        String eliminada = cajoneria.eliminar("Cielo");
        System.out.println((eliminada != null) ? "Se Elimiino a : " + eliminada
                : "La golosina no se encuentra en la cajoneria");
        eliminada = cajoneria.eliminar("Cielo");
        System.out.println((eliminada != null) ? "Se Elimiino a : " + eliminada : "La golosina no se encuentra en la cajoneria");
        System.out.println("");
        //Imprimir 
        System.out.println(cajoneria.toString());

    }
}
