//package B_Tree;

/**
 * Clase que representa un nodo de un Árbol B.
 */
public class NodoArbolB {
    int n; // número de claves almacenadas en el nodo
    boolean leaf; // indica si el nodo es una hoja (nodo hoja = true; nodo interno = false)
    int key[]; // almacena las claves en el nodo
    NodoArbolB child[]; // arreglo con referencias a los hijos

    // Constructores
    public NodoArbolB(int t) {
        n = 0;
        leaf = true;
        key = new int[((2 * t) - 1)];
        child = new NodoArbolB[(2 * t)];
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
    public int find(int k) {
        for (int i = 0; i < n; i++) {
            if (key[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
