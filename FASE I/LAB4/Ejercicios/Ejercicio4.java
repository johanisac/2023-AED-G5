public class Ejercicio4 {
    public static int busquedaBinariaRecursiva(int[] arreglo, int valroBucar, int izquierda, int derecha) {
        if (derecha < izquierda) {
            return -1; // El valor no se encuentra en el arreglo
        }

        int medio = (izquierda + derecha) / 2;

        if (valroBucar == arreglo[medio]) {
            return medio; // Encontramos el valor buscado
        } else if (valroBucar < arreglo[medio]) {
            return busquedaBinariaRecursiva(arreglo, valroBucar, izquierda, medio - 1); // Buscamos en la mitad
                                                                                        // izquierda
        } else {
            return busquedaBinariaRecursiva(arreglo, valroBucar, medio + 1, derecha); // Buscamos en la mitad derecha
        }
    }

    public static void main(String[] args) {
        int[] arreglo = { 2, 4, 6, 8, 10, 12, 14, 1 };
        int valroBucar = 16;
        int indice = busquedaBinariaRecursiva(arreglo, valroBucar, 0, arreglo.length - 1);

        if (indice == -1) {
            System.out.println("El valor " + valroBucar + " no se encuentra en el arreglo");
        } else {
            System.out.println("El valor " + valroBucar + " se encuentra en la posición " + indice + " del arreglo");
        }
    }
}
