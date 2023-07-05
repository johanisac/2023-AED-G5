package EJERCICIOS;

public class GraphMat<E> {
    private Object[] vertexArray;
    private boolean[][] adjMatrix;
    private int numVertices;

    public GraphMat(int maxVertices) {
        vertexArray = new Object[maxVertices];
        adjMatrix = new boolean[maxVertices][maxVertices];
        numVertices = 0;
    }

    public void insertVertex(E data) {
        if (!searchVertex(data)) {
            vertexArray[numVertices] = data;
            numVertices++;
        }
    }

    public void insertEdge(E verOri, E verDes) {
        int indexOri = getIndex(verOri);
        int indexDes = getIndex(verDes);

        if (indexOri != -1 && indexDes != -1) {
            adjMatrix[indexOri][indexDes] = true;
            adjMatrix[indexDes][indexOri] = true;
        }
    }

    public boolean searchVertex(E data) {
        return getIndex(data) != -1;
    }

    public boolean searchEdge(E verOri, E verDes) {
        int indexOri = getIndex(verOri);
        int indexDes = getIndex(verDes);

        if (indexOri != -1 && indexDes != -1) {
            return adjMatrix[indexOri][indexDes];
        }

        return false;
    }

    public void dfs(E data) {
        int startIndex = getIndex(data);
        if (startIndex != -1) {
            boolean[] visited = new boolean[numVertices];
            dfsHelper(startIndex, visited);
        }
    }

    private void dfsHelper(int vertexIndex, boolean[] visited) {
        System.out.println(vertexArray[vertexIndex]);

        visited[vertexIndex] = true;

        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertexIndex][i] && !visited[i]) {
                dfsHelper(i, visited);
            }
        }
    }

    private int getIndex(E data) {
        for (int i = 0; i < numVertices; i++) {
            if (vertexArray[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }
}

