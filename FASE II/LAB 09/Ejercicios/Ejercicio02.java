public class Ejercicio02 {

    /**
     * @param args
     * @throws ItemNotFound
     */
    public static void main(String[] args) throws ItemNotFound {
        AVLTree<Integer> tree = new AVLTree<>();

        // Caso 1: Eliminación que requiere RSR
        // tree.insert(1);
        // tree.insert(2);
        // tree.insert(3);
        // tree.insert(4);
        // tree.insert(5);
        // System.out.println(tree.toString());
        // tree.remove(2);
        // System.out.println(tree.toString());
        
        tree.insert(33);
        tree.insert(20);
        tree.insert(45);
        tree.insert(12);
        tree.insert(26);
        tree.insert(41);
        tree.insert(56);
        tree.insert(6);
        tree.insert(15);
        tree.insert(24);
        tree.insert(35);
        tree.insert(44);
        tree.insert(48);
        tree.insert(59);
        tree.insert(17);
        tree.insert(38);
        tree.insert(46);
        tree.insert(53);
        tree.insert(65);
        tree.insert(50);
        System.out.println(tree.toString());
        tree.remove(12);
        System.out.println(tree.toString());
        tree.remove(33);
        System.out.println(tree.toString());
        tree.remove(46);
        System.out.println(tree.toString());
        tree.remove(59);
        System.out.println(tree.toString());
        tree.remove(45);
        System.out.println(tree.toString());
        tree.remove(56);
        System.out.println(tree.toString());
    }
}
