package ACTIVIDADES;

public class Main {
    public static void main(String[] args) {
        // Crear un grafo
        GraphLink<Integer> graph = new GraphLink<>();

        // Insertar vértices
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        graph.insertVertex(5);

        // Insertar aristas
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 5);

        // Imprimir el grafo
        System.out.println("Grafo original:");
        System.out.println(graph);

        // Buscar vértices y aristas
        System.out.println("Buscar vértices:");
        System.out.println("Existe vértice 1: " + graph.searchVertex(1));
        System.out.println("Existe vértice 6: " + graph.searchVertex(6));
        System.out.println();

        System.out.println("Buscar aristas:");
        System.out.println("Existe arista entre 1 y 2: " + graph.searchEdge(1, 2));
        System.out.println("Existe arista entre 2 y 3: " + graph.searchEdge(2, 3));
        System.out.println("Existe arista entre 4 y 5: " + graph.searchEdge(4, 5));
        System.out.println("Existe arista entre 5 y 1: " + graph.searchEdge(5, 1));
        System.out.println();

        // Eliminar vértices y aristas
        graph.removeVertex(3);
        graph.removeEdge(2, 4);

        // Imprimir el grafo actualizado
        System.out.println("Grafo después de eliminar vértice y arista:");
        System.out.println(graph);

        // Realizar recorrido en profundidad
        System.out.println("Recorrido en profundidad (DFS) desde el vértice 1:");
        graph.dfs(1);
    }
}
