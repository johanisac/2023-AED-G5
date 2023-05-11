public class Chocolatina {
    private String marca;// variable de instancia

    // Constructor
    public Chocolatina(String marca) {
        this.marca = marca;
    }

    // Método get para accerder
    public String getMarca() {
        return marca;
    }

    // Método set para modificar
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String toString() {
        return "Marca de la cholatina es " + this.marca;

    }

}
