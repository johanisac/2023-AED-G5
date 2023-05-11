public class Ejercicio02 {

    // usamos este metodo generico para agregar los elementos que necesitemos por
    // medio de un forege y .add
    public static <T> void addElementos(Bolsa<T> bolsa, T... listaelem) {
        for (T elemento : listaelem) {
            bolsa.add(elemento);
        }
    }

    public static void main(String[] args) {

        Bolsa<Golosina> bolsaGolo = new Bolsa<>(0);
        addElementos(bolsaGolo, new Golosina("Gaseosa", 12.5), new Golosina("Sublime", 10.0),
                new Golosina("Pizarro", 22.0));

        for (Golosina golosina : bolsaGolo) {
            System.out.println(golosina.toString());
        }
    }

}
