public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Caso de prueba 1: Inserción de elementos que provocan un desequilibrio hacia
        // la derecha y se resuelve con rotaciones RSR.
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.insert(3);
        System.out.println(avlTree.toString());
        // Caso de prueba 2: Inserción de elementos que provocan un desequilibrio hacia
        // la derecha y se resuelve con rotaciones RSR.
        avlTree.insert(2);
        avlTree.insert(1);
        System.out.println(avlTree.toString());

        // Caso de prueba 2: Inserción de elementos que provocan un desequilibrio hacia
        // la izquierda y se resuelve con rotaciones RSL y RDL.
        avlTree.insert(10);
        avlTree.insert(20);
        System.out.println(avlTree.toString());
        avlTree.insert(15);
        System.out.println(avlTree.toString());
        
        avlTree.insert(8);
        System.out.println(avlTree.toString());

        // Caso de prueba 3: Inserción de elementos que provocan un desequilibrio hacia
        // la derecha y se resuelve con rotaciones RSR y RDR.
        System.out.println(avlTree.toString());
        avlTree.insert(7);
        System.out.println(avlTree.toString());

        // Caso de prueba 4: Inserción de elementos que provocan un desequilibrio hacia
        // la izquierda y se resuelve con rotaciones RSL y RDL.
        avlTree.insert(25);
        System.out.println(avlTree.toString());
        avlTree.insert(30);
        avlTree.insert(22);
        System.out.println(avlTree.toString());

        System.out.println(avlTree.toString());

        // Caso de prueba 6: Inserción de elementos que provocan un desequilibrio hacia
        // la izquierda y se resuelve con rotaciones RSL y RDL.
        avlTree.insert(9);
        System.out.println(avlTree.toString());
        System.out.println(avlTree.toString());

        // Caso de prueba 7: Inserción de elementos que provocan un desequilibrio hacia
        // la derecha y se resuelve con rotaciones RSR y RDR.
        avlTree.insert(3);
        avlTree.insert(6);
        System.out.println(avlTree.toString());

        // Caso de prueba 8: Inserción de elementos que provocan un desequilibrio hacia
        // la izquierda y se resuelve con rotaciones RSL y RDL.
        avlTree.insert(12);
        avlTree.insert(18);
        System.out.println(avlTree.toString());
    }
}
