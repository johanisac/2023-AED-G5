
public class Test {
    public static void main(String[] args) throws ItemDuplicated, ItemNotFound {
        BSTree<Integer> tree = new BSTree<>();
        try {
            tree.insert(15);
            // System.out.println(tree.toString());
            tree.insert(12);
            tree.insert(18);
            // System.out.println(tree.toString());
            tree.insert(11);
            tree.insert(16);
            // System.out.println(tree.toString());
            tree.insert(20);
            tree.insert(30);
            tree.insert(19);
            tree.insert(5);
            tree.insert(14);
            System.out.println(tree.toString());
            System.out.println("Árbol en orden: " + tree.inOrder());
            // System.out.println("Buscar el elemento : " + tree.search(18));
            // System.out.println("Buscar el elemento 7: " + tree.search(7));
            System.out.println("Nodos no-hojas de un BST : " + tree.countNonLeaves());
            System.out.println("la altura de un nodo : " + tree.getNodeHeight(15));
            System.out.print("PreOrden de los nodos : ");
            tree.preOrderIterative();
            System.out.println();
            System.out.println("Comparar dos arboles");
            BSTree<Integer> tree1 = new BSTree<>();
            BSTree<Integer> tree2 = new BSTree<>();
            tree1.insert(5);
            tree1.insert(3);
            tree1.insert(7);

            tree2.insert(8);
            tree2.insert(4);
            // tree2.insert(6);
            if (tree1.getArea() == tree2.getArea())
                System.out.println("Son iguales " + tree1.toString() + "  " + tree2.toString());
            else
                System.out.println("Son desiguales " + tree1.toString() + "  " + tree2.toString());

            System.out.println("nodo mas grande :" + tree.getMaxNode().data);
            System.out.println("nodo mas pequeño :" + tree.getMinNode().data);
            
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
        // System.out.println("Eliminar 18 ");
        // tree.remove(18);
        System.out.println(tree.toString());
        System.out.println("Árbol en orden : " + tree.inOrder());

        // Crear un árbol binario de búsqueda
        // ejercicio 8
        BSTree<String> treeString = new BSTree<>();
        treeString.insert("Sales");
        treeString.insert("Domestic");
        treeString.insert("International");
        treeString.insert("Canada");
        treeString.insert("S.America");
        treeString.insert("Overseas");
        treeString.insert("Africa");
        treeString.insert("Europe");
        treeString.insert("Asia");
        treeString.insert("Australia");

        // Imprimir la representación entre paréntesis con sangría del árbol
        treeString.parenthesize();
        // System.out.println(treeString.toString());
    }
}