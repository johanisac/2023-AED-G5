package EJERCICIOS;

public class Main2 {
    public static void main(String[] args) {
        // Crear el grafo
        GraphMat<String> grafo = new GraphMat<>(5);

        // Insertar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        // Insertar aristas
        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "D");
        grafo.insertEdge("C", "D");
        grafo.insertEdge("D", "E");

        // Buscar vértices y aristas
        System.out.println("¿Existe el vértice A? " + grafo.searchVertex("A"));
        System.out.println("¿Existe el vértice F? " + grafo.searchVertex("F"));
        System.out.println("¿Existe la arista entre A y B? " + grafo.searchEdge("A", "B"));
        System.out.println("¿Existe la arista entre A y D? " + grafo.searchEdge("A", "D"));

        // Realizar DFS desde un vértice
        System.out.println("Recorrido DFS:");
        grafo.dfs("A");
    }
}
