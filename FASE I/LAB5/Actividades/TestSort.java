public class TestSort {
    public static void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21 };
        //int[] arrs = { 35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21 };
        System.out.println("8 13 21 31 35 50 56 57 62 63 64 74 82 ");
        System.out.println("Original array:");
        showArray(arr);
        // System.out.println("bubbleSort array:");
        // sort.bubbleSort(arr);
        // showArray(arr);
        // System.out.println("insertionSort array:");
        // sort.insertionSort(arr);
        // showArray(arr);
        // System.out.println("selectionSort array:");
        // sort.selectionSort(arr);
        // showArray(arr);
        // System.out.println("shellSort array:");
        // sort.shellSort(arr);
        // showArray(arr);
        System.out.println("quickSort array:");
        //sort.quickSort(arr, 0, 0);
        sort.quickSort(arr, 0, arr.length - 1);
        showArray(arr);

    }
}

import java.util.Scanner;

public class NumerosImpares {
    public static void main(String[] args) {
        int[] listaNumeros = new int[12];
        Scanner scanner = new Scanner(System.in);
        
        // Leer números por teclado y almacenarlos en el arreglo
        for (int i = 0; i < listaNumeros.length; i++) {
            System.out.print("Ingrese un número entero: ");
            listaNumeros[i] = scanner.nextInt();
        }
        
        // Ordenar los números impares usando el algoritmo Selection Sort
        for (int i = 0; i < listaNumeros.length - 1; i++) {
            if (listaNumeros[i] % 2 != 0) {
                int minIndex = i;
                for (int j = i + 1; j < listaNumeros.length; j++) {
                    if (listaNumeros[j] % 2 != 0 && listaNumeros[j] < listaNumeros[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = listaNumeros[i];
                listaNumeros[i] = listaNumeros[minIndex];
                listaNumeros[minIndex] = temp;
            }
        }
        
        // Mostrar los números impares ordenados ascendentemente
        System.out.println("Números impares ordenados ascendentemente:");
        for (int i = 0; i < listaNumeros.length; i++) {
            if (listaNumeros[i] % 2 != 0) {
                System.out.print(listaNumeros[i] + " ");
            }
        }
    }
}






