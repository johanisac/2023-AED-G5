import java.util.Scanner;

public class Ejercicios_basicos_DDR_32 {
    public static void main(String[] args) {
        // creamos un scanner para tener
        Scanner sn = new Scanner(System.in);
        // pedimos las palabras
        System.out.println("Escribe la palabra 1");
        String palabra1 = sn.next();

        System.out.println("Escribe la palabra 2");
        String palabra2 = sn.next();

        // comparamos con el metodo equals
        // con squalsIgnoreCase, no considera las mayusculas
        if (palabra1.equals(palabra2)) {
            System.out.println("las palabras son iguales");
        } else {
            System.out.println("las palabras no son iguales");
        }
        sn.close();
    }
}