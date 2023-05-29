public class BSTree<E extends Comparable<E>> {
    protected Node root;

    protected class Node {
        public final int bf = 0;
        protected E data;
        protected Node left, right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return data.toString();
        }

    }

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
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

    protected Node remove(Node node, E x) throws ItemNotFound {
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

    protected E findMin(Node node) {
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

    public void parenthesize() {
        parenthesize(root, 0);
    }

    private void parenthesize(Node node, int level) {
        if (node != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("  "); // Espacios para la sangría
            }
            System.out.println(sb.toString() + "(" + node.data);

            parenthesize(node.left, level + 1);
            parenthesize(node.right, level + 1);

            System.out.println(sb.toString() + ")");
        }
    }

    // 2.Retorna la altura de un nodo X cualquiera de un BST siempre y cuando exista
    // en el árbol
    public Node searchNodeWithChildren(E x) throws ItemNotFound {
        return searchNodeWithChildren(root, x);
    }

    private Node searchNodeWithChildren(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento no se encuentra en el árbol.");
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            return searchNodeWithChildren(node.left, x);
        } else if (compareResult > 0) {
            return searchNodeWithChildren(node.right, x);
        } else {
            return node; // Se encontró el nodo con el valor x y se devuelve con todos sus hijos
        }
    }

    public int NodeHeight(E x) throws ItemNotFound {
        return height(searchNodeWithChildren(x));
    }

    protected int height(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public String toString() {
        return "[" + toStringNode(root) + "]";
    }

    public int countNodes() {
        return countNodes(root);
    }
    
    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
    
        // Recursivamente cuenta los nodos en los subárboles izquierdo y derecho
        int leftCount = countNodes(node.left);
        int rightCount = countNodes(node.right);
    
        // Suma los nodos de los subárboles más el nodo actual
        return 1 + leftCount + rightCount;
    }
    

    private String toStringNode(Node node) {
        if (node == null) {
            return "";
        }

        String leftStr = toStringNode(node.left);
        String rightStr = toStringNode(node.right);

        if (!leftStr.isEmpty() && !rightStr.isEmpty()) {
            return "{" + leftStr + "} " + node.data + " [" + rightStr + "]";
        } else if (!leftStr.isEmpty()) {
            return "{" + leftStr + "}" + node.data;
        } else if (!rightStr.isEmpty()) {
            return node.data + " [" + rightStr + "]";
        } else {
            return String.valueOf(node.data);
        }
    }

}
