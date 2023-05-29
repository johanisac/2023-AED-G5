
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

    private NodeAVL rotateSL(NodeAVL node) {
        if (node == null || node.right == null) {
            return node;
        }
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        if (node == null || node.left == null) {
            return node;
        }
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }

    // public void remove(E x) throws ItemNotFound {
    // height = false;
    // root = remove(x, (NodeAVL) root);
    // }

    // protected NodeAVL remove(E x, NodeAVL node) throws ItemNotFound {
    // if (node == null) {
    // throw new ItemNotFound("El elemento no se encuentra en el árbol.");
    // }

    // NodeAVL fat = node;

    // if (node.data.compareTo(x) < 0) {
    // node.right = remove(x, (NodeAVL) node.right);
    // if (height) {
    // fat = removbalanceToRight(fat);
    // }
    // } else if (node.data.compareTo(x) > 0) {
    // node.left = remove(x, (NodeAVL) node.left);
    // if (height) {
    // fat = removebalanceToLeft(fat);
    // }
    // } else {
    // if (node.left != null && node.right != null) {
    // node.data = findMin(node.right);
    // node.right = remove(node.data, (NodeAVL) node.right);
    // if (height) {
    // fat = removbalanceToRight(fat);
    // }
    // } else {
    // fat = (node.left != null) ? (NodeAVL) node.left : (NodeAVL) node.right;
    // height = true;
    // }
    // }

    // return fat;
    // }

    // protected NodeAVL removebalanceToLeft(NodeAVL node) {
    // switch (node.bf) {
    // case 1:
    // node.bf = 0;
    // break;
    // case 0:
    // node.bf = -1;
    // height = false;
    // break;
    // default:
    // NodeAVL hijo = (NodeAVL) node.right;
    // if (hijo == null) {
    // return node; // No balanceo necesario, hijo derecho es nulo
    // }
    // switch (hijo.bf) {
    // case 0:
    // case 1:
    // node = rotateSL(node);
    // if (hijo.bf == 0) {
    // node.bf = -1;
    // hijo.bf = 1;
    // height = false;
    // } else {
    // node.bf = 0;
    // hijo.bf = 0;
    // }
    // break;
    // default:
    // NodeAVL nieto = (NodeAVL) hijo.left;
    // if (nieto == null) {
    // return node; // No balanceo necesario, nieto izquierdo es nulo
    // }
    // node.right = rotateSR(hijo);
    // node = rotateSL(node);
    // switch (nieto.bf) {
    // case -1:
    // node.bf = 0;
    // hijo.bf = 1;
    // break;
    // case 0:
    // node.bf = 0;
    // hijo.bf = 0;
    // break;
    // case 1:
    // node.bf = 1;
    // hijo.bf = 0;
    // break;
    // }

    // nieto.bf = 0;
    // break;
    // }
    // break;
    // }

    // return node;
    // }

    // private NodeAVL removbalanceToRight(NodeAVL node) {
    // switch (node.bf) {
    // case -1:
    // node.bf = 0;
    // break;
    // case 0:
    // node.bf = 1;
    // height = false;
    // break;
    // default:
    // NodeAVL hijo = (NodeAVL) node.left;
    // if (hijo == null) {
    // return node; // No balanceo necesario, hijo izquierdo es nulo
    // }
    // switch (hijo.bf) {
    // case 0:
    // case -1:
    // node = rotateSR(node);
    // if (hijo.bf == 0) {
    // node.bf = 1;
    // hijo.bf = -1;
    // height = false;
    // } else {
    // node.bf = 0;
    // hijo.bf = 0;
    // }
    // break;
    // default:
    // NodeAVL nieto = (NodeAVL) hijo.right;
    // if (nieto == null) {
    // return node; // No balanceo necesario, nieto derecho es nulo
    // }
    // node.left = rotateSL(hijo);
    // node = rotateSR(node);
    // switch (nieto.bf) {
    // case 0:
    // node.bf = 0;
    // hijo.bf = 0;
    // break;
    // case -1:
    // node.bf = 1;
    // hijo.bf = 0;
    // break;
    // default:
    // node.bf = 0;
    // hijo.bf = -1;
    // break;
    // }

    // nieto.bf = 0;
    // break;
    // }
    // break;
    // }

    // return node;
    // }

    public void remove(E x) throws ItemNotFound {
        height = false;
        root = remove(x, (NodeAVL) root);
    }

    protected NodeAVL remove(E x, NodeAVL node) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento no se encuentra en el árbol.");
        }

        NodeAVL fat = node;

        if (node.data.compareTo(x) < 0) {
            node.right = remove(x, (NodeAVL) node.right);
            if (height) {
                fat = removbalanceToRight(fat);
            }
        } else if (node.data.compareTo(x) > 0) {
            node.left = remove(x, (NodeAVL) node.left);
            if (height) {
                fat = removebalanceToLeft(fat);
            }
        } else {
            if (node.left != null && node.right != null) {
                node.data = findMin(node.right);
                node.right = remove(node.data, (NodeAVL) node.right);
                if (height) {
                    fat = removbalanceToRight(fat);
                }
            } else {
                fat = (node.left != null) ? (NodeAVL) node.left : (NodeAVL) node.right;
                height = true;
            }
        }

        return fat;
    }

    protected NodeAVL removebalanceToLeft(NodeAVL node) {
        switch (node.bf) {
            case 1:
                node.bf = 0;
                break;
            case 0:
                node.bf = -1;
                height = false;
                break;
            default:
                NodeAVL hijo = (NodeAVL) node.right;
                if (hijo == null) {
                    return node; // No balanceo necesario, hijo derecho es nulo
                }
                switch (hijo.bf) {
                    case 0:
                    case 1:
                        node = rotateSL(node);
                        if (hijo.bf == 0) {
                            node.bf = -1;
                            hijo.bf = 1;
                            height = false;
                        } else {
                            node.bf = 0;
                            hijo.bf = 0;
                        }
                        break;
                    default:
                        NodeAVL nieto = (NodeAVL) hijo.left;
                        if (nieto == null) {
                            return node; // No balanceo necesario, nieto izquierdo es nulo
                        }
                        node.right = rotateSR(hijo);
                        node = rotateSL(node);
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
                        break;
                }
                break;
        }
        return node;
    }

    protected NodeAVL removbalanceToRight(NodeAVL node) {
        switch (node.bf) {
            case -1:
                node.bf = 0;
                break;
            case 0:
                node.bf = 1;
                height = false;
                break;
            default:
                NodeAVL hijo = (NodeAVL) node.left;
                if (hijo == null) {
                    return node; // No balanceo necesario, hijo izquierdo es nulo
                }
                switch (hijo.bf) {
                    case 0:
                    case -1:
                        node = rotateSR(node);
                        if (hijo.bf == 0) {
                            node.bf = 1;
                            hijo.bf = -1;
                            height = false;
                        } else {
                            node.bf = 0;
                            hijo.bf = 0;
                        }
                        break;
                    default:
                        NodeAVL nieto = (NodeAVL) hijo.right;
                        if (nieto == null) {
                            return node; // No balanceo necesario, nieto derecho es nulo
                        }
                        node.left = rotateSL(hijo);
                        node = rotateSR(node);
                        switch (nieto.bf) {
                            case 0:
                                node.bf = 0;
                                hijo.bf = 0;
                                break;
                            case -1:
                                node.bf = 1;
                                hijo.bf = 0;
                                break;
                            default:
                                node.bf = 0;
                                hijo.bf = -1;
                                break;
                        }
                        nieto.bf = 0;
                        break;
                }
                break;
        }
        return node;
    }

    protected E findMin(NodeAVL node) {
        if (node.left == null) {
            return node.data;
        }
        return findMin((NodeAVL) node.left);
    }

    protected E findMax(NodeAVL node) {
        if (node.right == null) {
            return node.data;
        }
        return findMax((NodeAVL) node.right);
    }

    public boolean contains(E x) {
        return contains(x, (NodeAVL) root);
    }

    private boolean contains(E x, NodeAVL node) {
        if (node == null) {
            return false;
        }

        int comparison = node.data.compareTo(x);

        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return contains(x, (NodeAVL) node.right);
        } else {
            return contains(x, (NodeAVL) node.left);
        }
    }

}
