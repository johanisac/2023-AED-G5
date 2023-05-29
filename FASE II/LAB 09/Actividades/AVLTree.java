
public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
    class NodeAVL extends Node {
        protected int bf;

        public NodeAVL(E data) {
            super(data);
            bf = 0;
        }

        public String toString() {
            return super.toString() + " (BF: " + bf + ")";
        }
    }

    private boolean height;

    public AVLTree() {
        super();
    }

    public void insert(E x) {
        height = false;
        root = insert(x, (NodeAVL) root);
    }

    protected Node insert(E x, NodeAVL node) {
        NodeAVL fat = node;
        
        if (node == null) {
            height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);
            if (resC == 0) {
                return fat; // Ignore duplicate items.
            }
            if (resC < 0) {
                fat.right = insert(x, (NodeAVL) node.right);
                if (height) {
                    switch (fat.bf) {
                        case -1:
                            fat.bf = 0;
                            height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            height = true;
                            break;
                        case 1: // bf = 2
                            fat = balanceToLeft(fat);
                            height = false;
                            break;
                    }
                }
            } else {
                fat.left = insert(x, (NodeAVL) node.left);
                if (height) {
                    switch (fat.bf) {
                        case 1:
                            fat.bf = 0;
                            height = false;
                            break;
                        case 0:
                            fat.bf = -1;
                            height = true;
                            break;
                        case -1: // bf = -2
                            fat = balanceToRight(fat);
                            height = false;
                            break;
                    }
                }
            }
        }
        
        return fat;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.right;
        switch (hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;
        switch (hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 0;
                        hijo.bf = -1;
                        break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
        }
        return node;
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }
}