package EJERCICIOS;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear un grafo
        GraphLink<String> graph = new GraphLink<>();

        // Insertar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // Insertar aristas con peso
        graph.insertEdgeWeight("A", "B", 2);
        graph.insertEdgeWeight("A", "C", 4);
        graph.insertEdgeWeight("B", "D", 1);
        graph.insertEdgeWeight("C", "D", 3);
        graph.insertEdgeWeight("C", "E", 5);
        graph.insertEdgeWeight("D", "E", 2);

        // Realizar el recorrido en amplitud (BFS) desde el vértice "A"
        System.out.println("Recorrido en amplitud (BFS):");
        graph.bfs("A");
        System.out.println();

        // Obtener el camino más corto entre los vértices "A" y "E"
        System.out.println("Camino más corto entre 'A' y 'E':");
        ArrayList<String> shortestPath = graph.shortPath("A", "E");
        if (shortestPath != null) {
            for (String vertex : shortestPath) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No se encontró un camino válido.");
        }
        System.out.println();

        // Realizar el recorrido en amplitud (BFS) desde el vértice "C"
        System.out.println("Recorrido en amplitud (BFS) desde 'C':");
        graph.bfsPath("C", "E");
        System.out.println();
    }
}
