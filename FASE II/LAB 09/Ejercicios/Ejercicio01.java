public class Ejercicio01 {
    public static void main(String[] args) throws ItemNotFound, ItemDuplicated {
        BSTree<Integer> bstTree = new BSTree<>();

        // Insertar elementos en orden ascendente
        bstTree.insert(1);
        bstTree.insert(2);
        bstTree.insert(3);
        bstTree.insert(4);
        bstTree.insert(5);
        System.out.println("\nProbar el arbol BST\n");
        System.out.println(bstTree.toString());

        // Buscar un elemento en el árbol BST
        System.out.println("BST - Buscar elemento 3: " + bstTree.search(3));

        // Obtener la altura del árbol BST
        System.out.println("BST - Altura del árbol 5: " + bstTree.NodeHeight(5));
        System.out.println("BST - Altura del árbol 1: " + bstTree.NodeHeight(1));

        AVLTree<Integer> avlTree = new AVLTree<>();

        // Insertar elementos en orden ascendente
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        System.out.println("\nProbar el arbol AVL\n");
        System.out.println(avlTree.toString());

        // Buscar un elemento en el árbol AVL
        System.out.println("AVL - Buscar elemento 3: " + avlTree.search(3));

        // Obtener la altura del árbol AVL
        System.out.println("AVL - Altura del árbol 5: " + avlTree.NodeHeight(5));
        System.out.println("AVL - Altura del árbol 1: " + avlTree.NodeHeight(1));
    }
}
