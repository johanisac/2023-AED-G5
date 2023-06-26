//package B_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Árbol B.
 */
public class ArbolB {
    NodoArbolB root;
    int t;

    // Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
    }

    /**
     * Busca el valor ingresado y muestra el contenido del nodo que contiene el
     * valor.
     */
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    // Search
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0; // se empieza a buscar siempre en la primera posición

        // Incrementa el índice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        // Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        // Si llegamos hasta aquí, entonces hay que buscar los hijos
        // Se revisa primero si tiene hijos
        if (actual.leaf) {
            return null;
        } else {
            // Si tiene hijos, hace una llamada recursiva
            return search(actual.child[i], key);
        }
    }

    /**
     * Inserta una clave en el Árbol B.
     */
    public void insertar(int key) {
        NodoArbolB r = root;

        // Si el nodo está lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }

    // Caso cuando la raíz se divide
    // x = | | | | | |
    // /
    // |10|20|30|40|50|
    // i = 0
    // y = |10|20|30|40|50|
    private void split(NodoArbolB x, int i, NodoArbolB y) {
        // Nodo temporal que será el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(t);
        z.leaf = y.leaf;
        z.n = (t - 1);

        // Copia las últimas (t - 1) claves del nodo y al inicio del nodo z // z =
        // |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        // Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }

        // Nuevo tamaño de y // x = | | | | | |
        y.n = (t - 1); // / \
                       // |10|20| | | |
        // Mueve los hijos de x para darle espacio a z
        for (int j = x.n; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }
        // Reasigna el hijo (i+1) de x // x = | | | | | |
        x.child[(i + 1)] = z; // / \
                              // |10|20| | | | |40|50| | | |

        // Mueve las claves de x
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        // Agrega la clave situada en la mediana // x = |30| | | | |
        x.key[i] = y.key[(t - 1)]; // / \
        x.n++; // |10|20| | | | |40|50| | | |
    }

    private void nonFullInsert(NodoArbolB x, int key) {
        // Si es una hoja
        if (x.leaf) {
            int i = x.n; // cantidad de valores del nodo
            // busca la posición i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1]; // Desplaza los valores mayores a key
                i--;
            }

            x.key[i] = key; // Asigna el valor al nodo
            x.n++; // Aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            // Busca la posición del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            // Si el nodo hijo está lleno lo separa
            if (x.child[j].n == (2 * t - 1)) {
                split(x, j, x.child[j]);

                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.child[j], key);
        }
    }

    /**
     * Muestra el estado del Árbol B.
     */
    public void showBTree() {
        print(root);
    }

    // Print en preorder
    private void print(NodoArbolB n) {
        n.imprimir();

        // Si no es hoja
        if (!n.leaf) {
            // Recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }

    ///// Ejercicio 1//////////////
    // 1. Agregue a la clase ÁrbolB un método que realice la eliminación de una
    ///// clave
    public void eliminar(int key) {
        eliminarClave(root, key);
    }

    private void eliminarClave(NodoArbolB nodo, int key) {
        int indice = buscarIndice(nodo, key);

        if (indice != -1) {
            if (nodo.leaf) {
                eliminarClaveEnNodo(nodo, indice);
            } else {
                eliminarClaveEnNodoNoHoja(nodo, indice);
            }
        } else {
            if (nodo.leaf) {
                System.out.println("No se encontró la clave " + key + " en el árbol.");
            } else {
                int hijoIndex = buscarIndiceHijo(nodo, key);
                if (hijoIndex == -1) {
                    System.out.println("No se encontró la clave " + key + " en el árbol.");
                    return;
                }
                boolean esHijoDerecho = (hijoIndex == nodo.n);
                NodoArbolB hijo = nodo.child[hijoIndex];

                if (hijo.n < t) {
                    llenarHijo(nodo, hijoIndex);
                }
                if (esHijoDerecho && hijoIndex > nodo.n) {
                    eliminarClave(nodo.child[hijoIndex - 1], key);
                } else {
                    eliminarClave(nodo.child[hijoIndex], key);
                }
            }
        }
    }

    private void eliminarClaveEnNodo(NodoArbolB nodo, int indice) {
        for (int i = indice + 1; i < nodo.n; i++) {
            nodo.key[i - 1] = nodo.key[i];
        }
        nodo.n--;
    }

    private void eliminarClaveEnNodoNoHoja(NodoArbolB nodo, int indice) {
        int clave = nodo.key[indice];

        if (nodo.child[indice].n >= t) {
            int predecesor = obtenerPredecesor(nodo.child[indice]);
            nodo.key[indice] = predecesor;
            eliminarClave(nodo.child[indice], predecesor);
        } else if (nodo.child[indice + 1].n >= t) {
            int sucesor = obtenerSucesor(nodo.child[indice + 1]);
            nodo.key[indice] = sucesor;
            eliminarClave(nodo.child[indice + 1], sucesor);
        } else {
            fusionarNodos(nodo, indice);
            eliminarClave(nodo.child[indice], clave);
        }
    }

    private int obtenerPredecesor(NodoArbolB nodo) {
        while (!nodo.leaf) {
            nodo = nodo.child[nodo.n];
        }
        return nodo.key[nodo.n - 1];
    }

    private int obtenerSucesor(NodoArbolB nodo) {
        while (!nodo.leaf) {
            nodo = nodo.child[0];
        }
        return nodo.key[0];
    }

    private void fusionarNodos(NodoArbolB nodo, int indice) {
        NodoArbolB hijo = nodo.child[indice];
        NodoArbolB hermano = nodo.child[indice + 1];

        hijo.key[t - 1] = nodo.key[indice];

        for (int i = 0; i < hermano.n; i++) {
            hijo.key[i + t] = hermano.key[i];
        }

        if (!hijo.leaf) {
            for (int i = 0; i <= hermano.n; i++) {
                hijo.child[i + t] = hermano.child[i];
            }
        }

        for (int i = indice + 1; i < nodo.n; i++) {
            nodo.key[i - 1] = nodo.key[i];
        }

        for (int i = indice + 2; i <= nodo.n; i++) {
            nodo.child[i - 1] = nodo.child[i];
        }

        hijo.n += hermano.n + 1;
        nodo.n--;
    }

    private void llenarHijo(NodoArbolB nodo, int indice) {
        NodoArbolB hijo = nodo.child[indice];

        if (indice != 0 && nodo.child[indice - 1].n >= t) {
            moverClaveDerecha(hijo, nodo.child[indice - 1]);
        } else if (indice != nodo.n && nodo.child[indice + 1].n >= t) {
            moverClaveIzquierda(hijo, nodo.child[indice + 1]);
        } else {
            if (indice != nodo.n) {
                fusionarNodos(hijo, indice);
            } else {
                fusionarNodos(nodo.child[indice - 1], indice - 1);
            }
        }
    }

    private void moverClaveDerecha(NodoArbolB destino, NodoArbolB fuente) {
        for (int i = destino.n - 1; i >= 0; i--) {
            destino.key[i + 1] = destino.key[i];
        }

        if (!destino.leaf) {
            for (int i = destino.n; i >= 0; i--) {
                destino.child[i + 1] = destino.child[i];
            }
        }

        destino.key[0] = fuente.key[fuente.n - 1];

        if (!fuente.leaf) {
            destino.child[0] = fuente.child[fuente.n];
        }

        fuente.n--;
        destino.n++;
    }

    private void moverClaveIzquierda(NodoArbolB destino, NodoArbolB fuente) {
        destino.key[destino.n] = fuente.key[0];

        if (!fuente.leaf) {
            destino.child[destino.n + 1] = fuente.child[0];
        }

        for (int i = 1; i < fuente.n; i++) {
            fuente.key[i - 1] = fuente.key[i];
        }

        if (!fuente.leaf) {
            for (int i = 1; i <= fuente.n; i++) {
                fuente.child[i - 1] = fuente.child[i];
            }
        }

        fuente.n--;
        destino.n++;
    }

    private int buscarIndice(NodoArbolB nodo, int key) {
        int indice = 0;
        while (indice < nodo.n && key > nodo.key[indice]) {
            indice++;
        }
        if (indice < nodo.n && key == nodo.key[indice]) {
            return indice;
        } else {
            return -1;
        }
    }

    private int buscarIndiceHijo(NodoArbolB nodo, int key) {
        int indice = 0;
        while (indice < nodo.n && key > nodo.key[indice]) {
            indice++;
        }
        return indice;
    }

    /// Ejercicio 2//////////////

    // Método que retorna el camino recorrido durante la búsqueda,inserción o
    // eliminación

    public List<NodoArbolB> obtenerCaminoRecorrido(int valor) {
        List<NodoArbolB> camino = new ArrayList<>();
        buscarNodoPorClave(root, valor, camino);
        return camino;
    }

    // Método auxiliar para buscar un valor y almacenar el camino recorrido

    private void buscarNodoPorClave(NodoArbolB nodo, int valor, List<NodoArbolB> camino) {
        int i = 0;
        while (i < nodo.n && valor > nodo.key[i]) {
            i++;
        }

        camino.add(nodo);

        if (i < nodo.n && valor == nodo.key[i]) {
            return;
        }

        if (nodo.leaf) {
            return;
        }

        buscarNodoPorClave(nodo.child[i], valor, camino);
    }

    /// Ejercicio 3//////////

    // Método que busca un valor y retorna todas las claves del nodo que lo contiene
    public List<Integer> buscarClavesDelNodo(int valor) {
        List<Integer> claves = new ArrayList<>();
        NodoArbolB nodo = buscarNodoPorClave(root, valor);
        if (nodo != null) {
            for (int i = 0; i < nodo.n; i++) {
                claves.add(nodo.key[i]);
            }
        }
        return claves;
    }

    // Método auxiliar para buscar un valor y retornar el nodo que lo contiene
    private NodoArbolB buscarNodoPorClave(NodoArbolB nodo, int valor) {
        int i = 0;
        while (i < nodo.n && valor > nodo.key[i]) {
            i++;
        }

        if (i < nodo.n && valor == nodo.key[i]) {
            return nodo;
        }

        if (nodo.leaf) {
            return null;
        }

        return buscarNodoPorClave(nodo.child[i], valor);
    }

    /// Ejercicio 4//////////
    // Método que retorna el valor máximo del árbol B
    public int obtenerValorMaximo() {
        if (root == null) {
            throw new IllegalStateException("El árbol está vacío");
        }

        NodoArbolB nodo = obtenerNodoMaximo(root);
        return nodo.key[nodo.n - 1];
    }

    // Método auxiliar para obtener el nodo con el valor máximo
    private NodoArbolB obtenerNodoMaximo(NodoArbolB nodo) {
        if (nodo.leaf) {
            return nodo;
        } else {
            return obtenerNodoMaximo(nodo.child[nodo.n]);
        }
    }

    /// Ejercicio 5//////////
    // Método que retorna el nodo mínimo de la raíz del árbol B
    public NodoArbolB obtenerNodoMinimo() {
        if (root == null) {
            throw new IllegalStateException("El árbol está vacío");
        }

        NodoArbolB nodo = obtenerNodoMinimoRecursivo(root);
        return nodo;
    }

    // Método auxiliar recursivo para obtener el nodo mínimo
    private NodoArbolB obtenerNodoMinimoRecursivo(NodoArbolB nodo) {
        if (nodo.leaf) {
            return nodo;
        } else {
            return obtenerNodoMinimoRecursivo(nodo.child[0]);
        }
    }
}
