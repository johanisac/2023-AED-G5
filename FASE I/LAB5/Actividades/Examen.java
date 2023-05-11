import java.util.Scanner;

public class Examen {

    public static void showArrayimpar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + ", ");
            }
        }
    }
    public static void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
        }
        System.out.println(" ");
    }

    public static void selectionSort(int a[]) {
        int min;

        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j])
                    min = j;
            }
            int aux = a[min];
            a[min] = a[i];
            a[i] = aux;
        }
    }

    public static void fun(int a[]) {
        int min;

        for (int i = 1; i < a.length; i++) {
            min = a[i];
            for (int j = i - 1; j>0 && a[j] < a[j + 1]; j--) {
                a[j] = a[j + 1];
            }
            a[i] = min;
        }
    }

    public static void main(String[] args) {
        // int[] listaNumeros = new int[12];
        // Scanner sc = new Scanner(System.in);
        // try {
        //     for (int i = 0; i < listaNumeros.length; i++) {
        //         System.out.print("Ingrese un número entero [" + (i + 1) + "]: ");
        //         listaNumeros[i] = sc.nextInt();
        //     }
        //     selectionSort(listaNumeros);
        //     showArrayimpar(listaNumeros);
        //     sc.close();
        // } catch (Exception e) {
        //     System.out.println("Colocar numeros enteros");
        // }
        int a []={10,3,6,5,78,1000,8,4};
        showArray(a);
        fun(a);
        showArray(a);
    }
}
