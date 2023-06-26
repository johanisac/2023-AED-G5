public class Test02 {
    public static void main(String[] args) {
        HashA<String> hashTable = new HashA<>(7);

        hashTable.insert(34, "Registro1");//6
        hashTable.insert(3, "Registro2");//3
        hashTable.insert(7, "Registro3");//0
        hashTable.insert(30, "Registro4");//2
        hashTable.insert(11, "Registro5");//4
        hashTable.insert(8, "Registro6");//1
        hashTable.insert(7, "Registro7");//0
        hashTable.insert(23, "Registro8");//2
        hashTable.insert(41, "Registro9");//6
        hashTable.insert(16, "Registro10");//2
        hashTable.insert(34, "Registro11");//6


        System.out.println(hashTable.toString());
    }
}
