public class Ejercicio1 {
    public static void main(String[] args) {
        Hanoi objHanoi = new Hanoi();
        int movimientos = objHanoi.torresHanoi(5, 1, 2, 3, 0);
        System.out.println("Número de movimientos necesarios: " + movimientos);

    }

    // Creando el metodo recursivo para la solucion de las torres hanoi
    public int torresHanoi(int discos, int torre1, int torre2, int torre3, int movimientos) {
        // Caso base
        if (discos == 1) {
            movimientos++;
        } else {
            // Dominio (problema – 1)
            movimientos = torresHanoi(discos - 1, torre1, torre3, torre2, movimientos);
            movimientos++;
            movimientos = torresHanoi(discos - 1, torre2, torre1, torre3, movimientos);
        }
        return movimientos;
    }
}
