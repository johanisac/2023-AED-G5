package ACTIVIDADES;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, ListLinked<String>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String vertex) {
        if (!vertices.containsKey(vertex)) {
            vertices.put(vertex, new ListLinked<>());
        }
    }

    public void addEdge(String vertex1, String vertex2) {
        if (vertices.containsKey(vertex1) && vertices.containsKey(vertex2)) {
            vertices.get(vertex1).add(vertex2);
            vertices.get(vertex2).add(vertex1);
        }
    }

    public void removeVertex(String vertex) {
        if (vertices.containsKey(vertex)) {
            vertices.remove(vertex);
            // Eliminar las referencias al vértice en las listas de adyacencia de los otros vértices
            for (ListLinked<String> adjacencyList : vertices.values()) {
                adjacencyList.remove(vertex);
            }
        }
    }

    public void removeEdge(String vertex1, String vertex2) {
        if (vertices.containsKey(vertex1) && vertices.containsKey(vertex2)) {
            vertices.get(vertex1).remove(vertex2);
            vertices.get(vertex2).remove(vertex1);
        }
    }

    public ListLinked<String> getAdjacentVertices(String vertex) {
        return vertices.get(vertex);
    }

    public boolean hasVertex(String vertex) {
        return vertices.containsKey(vertex);
    }

    public boolean hasEdge(String vertex1, String vertex2) {
        if (vertices.containsKey(vertex1) && vertices.containsKey(vertex2)) {
            return vertices.get(vertex1).contains(vertex2);
        }
        return false;
    }

    public void printGraph() {
        for (String vertex : vertices.keySet()) {
            System.out.print(vertex + " -> ");
            ListLinked<String> adjacencyList = vertices.get(vertex);
            System.out.println(adjacencyList.toString());
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.printGraph();
    }
}
