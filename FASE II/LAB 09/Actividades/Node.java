public class Node<E> {
    int data;
    Node<E> left;
    Node<E> right;
    int factor_de_equilibrio;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
        this.factor_de_equilibrio = 0;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public int getfactor_de_equilibrio() {
        return factor_de_equilibrio;
    }

    public void setfactor_de_equilibrio(int factor_de_equilibrio) {
        this.factor_de_equilibrio = factor_de_equilibrio;
    }

    public boolean isLeaf() {
        return (factor_de_equilibrio == 0);
    }

    public boolean isEmpty() {
        return (this == null);
    }
}