public class Ejercicio1 {
    public static void main(String[] args) {
        String texto = "Johan,Mamani,Jarata;Maria,Fernandez,Aguilar;Rivaldo,Flores,Jarata;";
        String[] filas = texto.split(";");
        String[][] tabla = new String[filas.length][];
        int maxColumnas = 0;
        for (int i = 0; i < filas.length; i++) {
            String[] columnas = filas[i].split(",");
            tabla[i] = columnas;
            maxColumnas = Math.max(maxColumnas, columnas.length);
        }
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < maxColumnas; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                if (j < tabla[i].length) {
                    System.out.print(tabla[i][j] + " | ");
                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println();
        }
    }
}