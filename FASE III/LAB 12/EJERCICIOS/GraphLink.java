package EJERCICIOS;

import java.util.*;

public class GraphLink<E> {
    protected LinkedList<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new LinkedList<Vertex<E>>();
    }

    public void insertVertex(E data) {
        Vertex<E> newVertex = new Vertex<>(data);
        listVertex.add(newVertex);
    }

    public void insertEdge(E verOri, E verDes) {
        Vertex<E> vertexOri = null;
        Vertex<E> vertexDes = null;

        // Buscar los vértices de origen y destino en la lista de vértices
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(verOri)) {
                vertexOri = vertex;
            }
            if (vertex.getData().equals(verDes)) {
                vertexDes = vertex;
            }
        }

        if (vertexOri != null && vertexDes != null) {
            Edge<E> newEdge = new Edge<>(vertexDes);
            vertexOri.listAdj.add(newEdge);
        }
    }

    public boolean searchVertex(E data) {
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(data)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchEdge(E verOri, E verDes) {
        Vertex<E> vertexOri = null;
        Vertex<E> vertexDes = null;

        // Buscar los vértices de origen y destino en la lista de vértices
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(verOri)) {
                vertexOri = vertex;
            }
            if (vertex.getData().equals(verDes)) {
                vertexDes = vertex;
            }
        }

        if (vertexOri != null && vertexDes != null) {
            for (Edge<E> edge : vertexOri.listAdj) {
                if (edge.refDest.equals(vertexDes)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void removeVertex(E data) {
        Vertex<E> vertexToRemove = null;

        // Buscar el vértice a eliminar
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(data)) {
                vertexToRemove = vertex;
                break;
            }
        }

        if (vertexToRemove != null) {
            // Eliminar todas las aristas que tienen al vértice a eliminar como origen
            for (Vertex<E> vertex : listVertex) {
                LinkedList<Edge<E>> edgesToRemove = new LinkedList<>();
                for (Edge<E> edge : vertex.listAdj) {
                    if (edge.refDest.equals(vertexToRemove)) {
                        edgesToRemove.add(edge);
                    }
                }
                vertex.listAdj.removeAll(edgesToRemove);
            }

            // Eliminar el vértice de la lista
            listVertex.remove(vertexToRemove);
        }
    }

    public void removeEdge(E verOri, E verDes) {
        Vertex<E> vertexOri = null;
        Vertex<E> vertexDes = null;

        // Buscar los vértices de origen y destino en la lista de vértices
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(verOri)) {
                vertexOri = vertex;
            }
            if (vertex.getData().equals(verDes)) {
                vertexDes = vertex;
            }
        }

        if (vertexOri != null && vertexDes != null) {
            Edge<E> edgeToRemove = null;
            for (Edge<E> edge : vertexOri.listAdj) {
                if (edge.refDest.equals(vertexDes)) {
                    edgeToRemove = edge;
                    break;
                }
            }

            if (edgeToRemove != null) {
                vertexOri.listAdj.remove(edgeToRemove);
            }
        }
    }

    public void dfs(E data) {
        Vertex<E> startVertex = null;

        // Buscar el vértice de inicio en la lista de vértices
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(data)) {
                startVertex = vertex;
                break;
            }
        }

        if (startVertex != null) {
            LinkedList<Vertex<E>> visited = new LinkedList<>();
            dfsHelper(startVertex, visited);
        }
    }

    private void dfsHelper(Vertex<E> vertex, LinkedList<Vertex<E>> visited) {
        System.out.println(vertex.getData());
        visited.add(vertex);

        for (Edge<E> edge : vertex.listAdj) {
            Vertex<E> neighbor = edge.refDest;
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void bfs(E data) {
        Vertex<E> startVertex = null;

        // Buscar el vértice de inicio en la lista de vértices
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(data)) {
                startVertex = vertex;
                break;
            }
        }

        if (startVertex != null) {
            LinkedList<Vertex<E>> visited = new LinkedList<>();
            LinkedList<Vertex<E>> queue = new LinkedList<>();
            visited.add(startVertex);
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                Vertex<E> currentVertex = queue.poll();
                System.out.println(currentVertex.getData());

                for (Edge<E> edge : currentVertex.listAdj) {
                    Vertex<E> neighbor = edge.refDest;
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public ArrayList<E> bfsPath(E verOri, E verDes) {
        Vertex<E> startVertex = null;
        Vertex<E> endVertex = null;

        // Buscar los vértices de inicio y fin en la lista de vértices
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(verOri)) {
                startVertex = vertex;
            }
            if (vertex.getData().equals(verDes)) {
                endVertex = vertex;
            }
        }

        if (startVertex != null && endVertex != null) {
            LinkedList<Vertex<E>> visited = new LinkedList<>();
            LinkedList<Vertex<E>> queue = new LinkedList<>();
            HashMap<Vertex<E>, Vertex<E>> prevMap = new HashMap<>();
            visited.add(startVertex);
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                Vertex<E> currentVertex = queue.poll();

                if (currentVertex == endVertex) {
                    // Construir el camino a partir del mapa de previos
                    ArrayList<E> path = new ArrayList<>();
                    Vertex<E> vertex = endVertex;
                    while (vertex != null) {
                        path.add(vertex.getData());
                        vertex = prevMap.get(vertex);
                    }
                    Collections.reverse(path);
                    return path;
                }

                for (Edge<E> edge : currentVertex.listAdj) {
                    Vertex<E> neighbor = edge.refDest;
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                        prevMap.put(neighbor, currentVertex);
                    }
                }
            }
        }

        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<E> vertex : listVertex) {
            sb.append(vertex.toString());
        }
        return sb.toString();
    }

    private static class Vertex<E> {
        private E data;
        protected LinkedList<Edge<E>> listAdj;

        public Vertex(E data) {
            this.data = data;
            listAdj = new LinkedList<Edge<E>>();
        }

        public E getData() {
            return data;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(data).append("->").append(listAdj.toString()).append("\n");
            return sb.toString();
        }
    }

    private static class Edge<E> {
        private Vertex<E> refDest;
        private int weight;

        public Edge(Vertex<E> refDest) {
            this(refDest, -1);
        }

        public Edge(Vertex<E> refDest, int weight) {
            this.refDest = refDest;
            this.weight = weight;
        }

        public boolean equals(Object o) {
            if (o instanceof Edge<?>) {
                Edge<E> e = (Edge<E>) o;
                return this.refDest.equals(e.refDest);
            }
            return false;
        }

        public String toString() {
            if (this.weight > -1)
                return refDest.getData() + " [" + this.weight + "], ";
            else
                return refDest.getData() + ", ";
        }
    }

    public void insertEdgeWeight(E verOri, E verDes, int weight) {
        Vertex<E> vertexOri = null;
        Vertex<E> vertexDes = null;

        // Buscar los vértices de origen y destino en la lista de vértices
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(verOri)) {
                vertexOri = vertex;
            }
            if (vertex.getData().equals(verDes)) {
                vertexDes = vertex;
            }
        }

        if (vertexOri != null && vertexDes != null) {
            Edge<E> newEdge = new Edge<>(vertexDes, weight);
            vertexOri.listAdj.add(newEdge);
        }
    }

    public ArrayList<E> shortPath(E verOri, E verDes) {
        Vertex<E> startVertex = null;
        Vertex<E> endVertex = null;

        // Buscar los vértices de inicio y fin en la lista de vértices
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(verOri)) {
                startVertex = vertex;
            }
            if (vertex.getData().equals(verDes)) {
                endVertex = vertex;
            }
        }

        if (startVertex != null && endVertex != null) {
            HashMap<Vertex<E>, Integer> distanceMap = new HashMap<>();
            HashMap<Vertex<E>, Vertex<E>> prevMap = new HashMap<>();
            LinkedList<Vertex<E>> queue = new LinkedList<>();

            for (Vertex<E> vertex : listVertex) {
                distanceMap.put(vertex, Integer.MAX_VALUE);
            }

            distanceMap.put(startVertex, 0);
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                Vertex<E> currentVertex = queue.poll();

                for (Edge<E> edge : currentVertex.listAdj) {
                    Vertex<E> neighbor = edge.refDest;
                    int newDistance = distanceMap.get(currentVertex) + edge.weight;

                    if (newDistance < distanceMap.get(neighbor)) {
                        distanceMap.put(neighbor, newDistance);
                        prevMap.put(neighbor, currentVertex);
                        queue.add(neighbor);
                    }
                }
            }

            // Construir el camino más corto a partir del mapa de previos
            ArrayList<E> shortestPath = new ArrayList<>();
            Vertex<E> vertex = endVertex;

            while (vertex != null) {
                shortestPath.add(vertex.getData());
                vertex = prevMap.get(vertex);
            }

            Collections.reverse(shortestPath);
            return shortestPath;
        }

        return null;
    }
}
