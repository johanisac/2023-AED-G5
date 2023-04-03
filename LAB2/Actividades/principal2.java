public class principal2 {
    public static void main(String[] args) {
        Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(2);
        Golosina c = new Golosina("Piruletas", 14.0);
        Golosina c1 = new Golosina("Nubes", 5.0);
        Golosina c2 = new Golosina("Gominolas", 12.50);
        bolsaGolo.add(c);
        bolsaGolo.add(c1);
        bolsaGolo.add(c2);
        for (Golosina Golosina : bolsaGolo) {
            System.out.println(Golosina.toString());
        }
    }
}
