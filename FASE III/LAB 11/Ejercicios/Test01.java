public class Test01 {

    public static void main(String[] args) {
        HashC<String> hashTable = new HashC<>(11);
        System.out.println("hola");
        hashTable.insert(hashTable.cuadradometodoHash(34), "Registro1"); // 1
        hashTable.insert(hashTable.sumaMetodoHash(3), "Registro2"); // 3
        hashTable.insert(hashTable.cuadradometodoHash(7), "Registro3"); // 7
        hashTable.insert(hashTable.sumaMetodoHash(30), "Registro4"); // 8
        hashTable.insert(hashTable.cuadradometodoHash(11), "Registro5"); // 0
        hashTable.insert(hashTable.sumaMetodoHash(8), "Rdsegistro6"); // 8
        hashTable.insert(hashTable.cuadradometodoHash(7), "Registro7"); // 7
        hashTable.insert(hashTable.sumaMetodoHash(23), "Registro8"); // 1
        hashTable.insert(hashTable.sumaMetodoHash(41), "Registro9"); // 8
        hashTable.insert(hashTable.sumaMetodoHash(16), "Registro10"); // 5
        hashTable.insert(hashTable.cuadradometodoHash(34), "Registro11"); // 1
        System.out.println(hashTable.toString());
    }
}
