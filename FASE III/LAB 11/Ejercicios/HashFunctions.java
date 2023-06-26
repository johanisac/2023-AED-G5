public class HashFunctions {
    public static int squareMethod(int key) {
        return key * key;
    }

    public static int foldingMethodSum(int key) {
        int sumOfDigits = 0;
        while (key > 0) {
            sumOfDigits += key % 10;
            key /= 10;
        }
        return sumOfDigits;
    }
}
