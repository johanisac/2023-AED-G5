public class Test {
    public static void main(String[] args) {
        System.out.println("\nProbar con Enteros\n");
        BSTree<Integer> tree = new BSTree<>();

        try {
            tree.insert(15);
            // System.out.println(tree.toString());
            tree.insert(12);
            tree.insert(18);
            // System.out.println(tree.toString());
            tree.insert(11);
            tree.insert(16);
            System.out.println(tree.toString());
            tree.insert(20);
            tree.insert(30);
            tree.insert(19);
            tree.insert(5);
            tree.insert(14);
            System.out.println(tree.toString());

            System.out.println("Árbol en orden: " + tree.inOrder());

            System.out.println("Buscar el elemento : " + tree.search(18));
            System.out.println("Buscar el elemento 7: " + tree.search(7));

        } catch (ItemDuplicated | ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Eliminar 18 ");
            tree.remove(18);
            System.out.println(tree.toString());
            System.out.println("Árbol en orden : " + tree.inOrder());

        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nProbar con String\n");

        BSTree<String> treeabc = new BSTree<>();

        try {
            treeabc.insert("M");
            // System.out.println(tree.toString());
            treeabc.insert("R");
            treeabc.insert("Z");
            // System.out.println(tree.toString());
            treeabc.insert("H");
            treeabc.insert("A");
            System.out.println(treeabc.toString());

            System.out.println("Árbol en orden: " + treeabc.inOrder());

            System.out.println("Buscar el elemento : " + treeabc.search("A"));

        } catch (ItemDuplicated | ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Eliminar A ");
            treeabc.remove("A");
            System.out.println(treeabc.toString());
            System.out.println("Árbol en orden : " + treeabc.inOrder());

        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}