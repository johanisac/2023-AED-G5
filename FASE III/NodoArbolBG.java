public class NodoArbolBG<T extends Comparable<T>> {
    int n; // número de claves almacenadas en el nodo
    boolean leaf; // indica si el nodo es una hoja (nodo hoja = true; nodo interno = false)
    T key[]; // almacena las claves en el nodo
    NodoArbolBG<T> child[]; // arreglo con referencias a los hijos

    // Constructores
    public NodoArbolBG(int t) {
        n = 0;
        leaf = true;
        key = (T[]) new Comparable[(2 * t) - 1];
        child = (NodoArbolBG<T>[]) new NodoArbolBG[(2 * t)];
    }

    /**
     * Imprime las claves almacenadas en el nodo.
     */
    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(key[i] + " | ");
            } else {
                System.out.print(key[i]);
            }
        }
        System.out.print("]");
    }

    /**
     * Busca una clave en el nodo y devuelve su índice si se encuentra, o -1 si no
     * se encuentra.
     */
    public int find(T k) {
        for (int i = 0; i < n; i++) {
            if (key[i].compareTo(k) == 0) {
                return i;
            }
        }
        return -1;
    }
}
