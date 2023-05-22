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

}
