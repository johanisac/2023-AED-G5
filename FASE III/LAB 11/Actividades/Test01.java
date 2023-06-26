public class Test01 {

    public static void main(String[] args) {
        HashC<String> hashTable = new HashC<>(11);

        hashTable.insert(34, "Registro1");  // 1
        hashTable.insert(3, "Registro2");//3
        hashTable.insert(7, "Registro3");//7
        hashTable.insert(30, "Registro4");//8
        hashTable.insert(11, "Registro5");//0
        hashTable.insert(8, "Registro6");//8
        hashTable.insert(7, "Registro7");//7
        hashTable.insert(23, "Registro8");//1
        hashTable.insert(41, "Registro9");//8
        hashTable.insert(16, "Registro10");//5
        hashTable.insert(34, "Registro11");//1

        System.out.println(hashTable.toString());
    }
}


