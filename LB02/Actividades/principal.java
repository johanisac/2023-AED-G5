public class principal {
    public static void main(String[] args) {

        // Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(0);
        // Chocolatina c = new Chocolatina("milka");
        // Chocolatina c1 = new Chocolatina("milka");
        // Chocolatina c2 = new Chocolatina("ferrero");
        // bolsaCho.add(c);
        // bolsaCho.add(c1);
        // bolsaCho.add(c2);
        // for (Chocolatina chocolatina : bolsaCho) {
        //     System.out.println(chocolatina.getMarca());
        // }

        Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(0);
        Golosina c = new Golosina("milka", 34.0);
        Golosina c1 = new Golosina("milka", 10.0);
        Golosina c2 = new Golosina("ferrero", 20.0);
        bolsaGolo.add(c);
        bolsaGolo.add(c1);
        bolsaGolo.add(c2);
        for (Golosina Golosina : bolsaGolo) {
        System.out.printf("Nombre: %s" + "\t" + "Peso: %.2f" + "\n",
        Golosina.getNombre(), Golosina.getPeso());// %s=String
        }
    }

}
