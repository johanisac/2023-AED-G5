public class Golosina {
    private String nombre;
    private double peso;

    // ConstrUctor con dos parámetros
    // Parámetro: variables utilizadas para recibir valores en una rutina
    // Argumento: valores enviados de la rutina invocante

    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    // Métodos get y set
    // Método: procedimiento o funcion que pertence a una clase (POO)
    public String getNombre() {
        return this.nombre;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %-12s Peso: %.2f" , this.nombre, this.peso);
    }
}
