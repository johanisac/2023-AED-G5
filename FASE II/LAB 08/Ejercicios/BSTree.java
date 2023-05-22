import java.util.Stack;

public class BSTree<E extends Comparable<E>> {
    protected class Node {
        protected E data;
        protected Node left, right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    private Node root;

    public BSTree() {
        root = null;
    }

    public void insert(E x) throws ItemDuplicated {
        root = insert(root, x);
    }

    private Node insert(Node node, E x) throws ItemDuplicated {
        if (node == null) {
            return new Node(x);
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            node.left = insert(node.left, x);
        } else if (compareResult > 0) {
            node.right = insert(node.right, x);
        } else {
            throw new ItemDuplicated("El elemento ya se encuentra en el árbol.");
        }

        return node;
    }

    public E search(E x) throws ItemNotFound {
        return search(root, x);
    }

    private E search(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento no se encuentra en el árbol.");
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            return search(node.left, x);
        } else if (compareResult > 0) {
            return search(node.right, x);
        } else {
            return node.data;
        }
    }

    public void remove(E x) throws ItemNotFound {
        root = remove(root, x);
    }

    private Node remove(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento no se encuentra en el árbol.");
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            node.left = remove(node.left, x);
        } else if (compareResult > 0) {
            node.right = remove(node.right, x);
        } else {
            if (node.left != null && node.right != null) {
                node.data = findMin(node.right);
                node.right = remove(node.right, node.data);
            } else {
                node = (node.left != null) ? node.left : node.right;
            }
        }

        return node;
    }

    private E findMin(Node node) {
        if (node.left == null) {
            return node.data;
        }
        return findMin(node.left);
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data.toString()).append(" ");
            inOrder(node.right, sb);
        }
    }

    public String toString() {
        return "[" + toStringNode(root) + "]";
    }

    private String toStringNode(Node node) {
        if (node == null) {
            return "";
        }

        String leftStr = toStringNode(node.left);
        String rightStr = toStringNode(node.right);

        if (!leftStr.isEmpty() && !rightStr.isEmpty()) {
            return "[" + leftStr + "] " + node.data + " [" + rightStr + "]";
        } else if (!leftStr.isEmpty()) {
            return "[" + leftStr + "] " + node.data;
        } else if (!rightStr.isEmpty()) {
            return node.data + " [" + rightStr + "]";
        } else {
            return String.valueOf(node.data);
        }
    }

    // Ejercicios
    // 1.Retorna el número de nodos no-hojas de un BST
    public int countNonLeaves() {
        return countNonLeaves(root);
    }

    private int countNonLeaves(Node node) {
        // Caso Base
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        // Si el nodo actual no es un nodo hoja, añade 1 a la cuenta
        // y luego recursivamente cuenta en los subárboles izquierdo y derecho
        return 1 + countNonLeaves(node.left) + countNonLeaves(node.right);
    }

    // 2.Retorna la altura de un nodo X cualquiera de un BST siempre y cuando exista
    // en el árbol
    public int getNodeHeight(E x) {
        return getNodeHeight(root, x);
    }

    private int getNodeHeight(Node node, E x) {
        if (node == null) {
            return -1; // Nodo no encontrado, se retorna -1
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            return getNodeHeight(node.left, x) + 1; // Búsqueda en el subárbol izquierdo
        } else if (compareResult > 0) {
            return getNodeHeight(node.right, x) + 1; // Búsqueda en el subárbol derecho
        } else {
            return getHeight(node); // Se encontró el nodo, se retorna su altura
        }
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1; // Altura máxima entre los subárboles izquierdo y derecho, más 1
    }

    // 3.Método iterative (no recursive) que recorra en PreOrden los nodos de un
    // BST.
    public void preOrderIterative() {
        if (root == null) {
            return; // El árbol está vacío, no hay nodos para recorrer
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 4.Retorne el área del árbol binario de búsqueda
    public int getArea() {
        int leafCount = countLeaves(root);
        int height = calculateHeight(root);

        return leafCount * height;
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 6.Devuelve el nodo con el valor más bajo (mínimo) de un BST
    public Node getMinNode() {
        if (root == null) {
            return null; // Árbol vacío, no hay nodo mínimo
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // 7.Retorna el nodo con el valor más alto (máximo) de un BST
    public Node getMaxNode() {
        if (root == null) {
            return null; // Árbol vacío, no hay nodo máximo
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    // 8.La representación entre paréntesis

    public void parenthesize() {
        parenthesize(root, 0);
    }

    private void parenthesize(Node node, int level) {
        if (node == null) {
            return;
        }

        // Imprimir la sangría según el nivel actual
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        // Imprimir el valor del nodo con paréntesis de apertura
        System.out.print(node.data + " (\n");

        // Verificar si el nodo tiene hijos
        if (node.left != null) {
            // Llamar recursivamente para imprimir el hijo izquierdo
            parenthesize(node.left, level + 1);
        }

        if (node.right != null) {
            // Imprimir la sangría para el hijo derecho
            for (int i = 0; i < level + 1; i++) {
                System.out.print("  ");
            }

            // Imprimir el valor del nodo con paréntesis de cierre
            System.out.println(node.right.data + " )");

            // Llamar recursivamente para imprimir el hijo derecho
            parenthesize(node.right, level + 1);
        } else {
            // Imprimir la sangría para el paréntesis de cierre
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }

            // Imprimir el paréntesis de cierre
            System.out.println(")");
        }
    }


}
