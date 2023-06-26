import java.util.List;

/**
 * Clase de prueba para verificar y probar el funcionamiento de un Árbol B.
 */
public class TestArbolB {

    public static void main(String[] args) {
        // grado minimo del Arbol B es t=3
        // Cada nodo soporta 2t hijos y 2t-1 claves
        int t = 3;
        // Se crea el arbol B segun t
        ArbolB arbolB = new ArbolB(t);

        // Valores a ingresar primera ronda
        int[] valoresUno = { 20, 10, 50, 30, 40 };
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for (int i = 0; i < valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
        }

        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar segunda ronda
        System.out.println("Insertando... valor 60");
        arbolB.insertar(60);
        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar tercera ronda
        System.out.println("Insertando... valor 80");
        arbolB.insertar(80);
        System.out.println("Insertando... valor 70");
        arbolB.insertar(70);
        System.out.println("Insertando... valor 90");
        arbolB.insertar(90);

        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Obtener el camino recorrido para un valor específico
        int valorBuscado = 40;
        List<NodoArbolB> caminoRecorrido = arbolB.obtenerCaminoRecorrido(valorBuscado);

        // Imprimir el camino recorrido
        System.out.println("Camino recorrido para el valor " + valorBuscado + ":");
        for (NodoArbolB nodo : caminoRecorrido) {
            nodo.imprimir();
        }
        System.out.println("");

        // Buscar claves del nodo que contiene un valor específico
        valorBuscado = 80;
        List<Integer> clavesDelNodo = arbolB.buscarClavesDelNodo(valorBuscado);

        // Imprimir las claves del nodo
        System.out.println("Claves del nodo que contiene el valor " + valorBuscado + ":");
        System.out.print("[");
        for (int i = 0; i < clavesDelNodo.size(); i++) {
            System.out.print(clavesDelNodo.get(i));
            if (i < clavesDelNodo.size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println("]");
        // Obtener el valor máximo del árbol
        System.out.println("El valor máximo del árbol B es: " + arbolB.obtenerValorMaximo());

        // Obtener el nodo mínimo de la raíz del árbol
        // Imprimir las claves del nodo mínimo
        System.out.print("Las claves del nodo mínimo son: [");
        for (int i = 0; i < arbolB.obtenerNodoMinimo().n; i++) {
            System.out.print(arbolB.obtenerNodoMinimo().key[i]);
            if (i < arbolB.obtenerNodoMinimo().n - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println("]");

        // Eliminar
        System.out.print("Eliminar el nodo 60");
        arbolB.eliminar(60);

        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
        // Buscar
        System.out.println("\nBuscando el nodo con el valor 80 en el arbol B:");
        arbolB.buscarNodoPorClave(80);

        System.out.println("");
        System.out.println("-- FIN --");

        // ArbolB arbol = new ArbolB(2); // Crear un árbol B con grado mínimo 3

        // Insertar claves en el árbol
        // arbol.insertar(75);
        // arbol.insertar(40);
        // arbol.insertar(23);
        // arbol.insertar(8);
        // arbol.insertar(6);
        // arbol.insertar(37);
        // arbol.insertar(32);
        // arbol.insertar(45);
        // arbol.insertar(25);
        // arbol.insertar(1);
        // arbol.insertar(88);
        // arbol.insertar(29);
        // arbol.insertar(4);
        // arbol.insertar(11);
        // arbol.insertar(39);
        // arbol.insertar(14);
        // arbol.insertar(66);
        // arbol.insertar(24);
        // arbol.insertar(12);
        // arbol.insertar(7);

        // Mostrar el árbol
        // System.out.println("Árbol B:");
        // arbol.showBTree();

        // Buscar un valor en el árbol y mostrar las claves del nodo encontrado
        // System.out.println("\nBuscando el nodo con el valor 80:");
        // arbol.buscarNodoPorClave(80);

        // Eliminar una clave del árbol
        // System.out.println("\nEliminando la clave 30:");
        // arbol.eliminar(30);

        // Mostrar el árbol después de la eliminación
        // System.out.println("\nÁrbol B después de la eliminación:");
        // arbol.showBTree();

        // Obtener el valor máximo del árbol
        // System.out.println("\nValor máximo del árbol B: " +
        // arbol.obtenerValorMaximo());

        // Obtener el nodo mínimo de la raíz del árbol
        // System.out.println("\nNodo mínimo de la raíz del árbol B:");
        // arbol.obtenerNodoMinimo().imprimir();
    }
}
