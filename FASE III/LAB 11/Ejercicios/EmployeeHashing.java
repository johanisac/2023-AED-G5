import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeHashing {
    private static int hashFunction(int key, int size) {
        return key % size;
    }

    private static void quadraticProbingHashing(List<String> elements, int size) {
        String[] hashTable = new String[size];
        int[] searchLengths = new int[size];
        for (String element : elements) {
            String[] employeeData = element.split(",");
            int code = Integer.parseInt(employeeData[0].trim());
            int hashValue = hashFunction(code, size);
            int length = 0;
            while (hashTable[hashValue] != null) {
                length++;
                hashValue = (hashValue + length * length) % size;
            }
            hashTable[hashValue] = element;
            searchLengths[hashValue] = length;
        }
        printHashTable(hashTable, searchLengths);
    }

    private static List<String> readEmployeesFromFile(String filename) throws IOException {
        List<String> elements = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Lea la primera línea para determinar el número de empleados
            int numEmployees = Integer.parseInt(reader.readLine().trim());
            String line;
            while ((line = reader.readLine()) != null) {
                elements.add(line.trim());
            }
            if (numEmployees != elements.size()) {
                throw new IllegalArgumentException("The number of employees in the file does not match the specified count.");
            }
        }
        return elements;
    }

    private static void printHashTable(String[] hashTable, int[] searchLengths) {
        System.out.println("Hash Table:");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                String[] employeeData = hashTable[i].split(",");
                int code = Integer.parseInt(employeeData[0].trim());
                String name = employeeData[1].trim();
                String address = employeeData[2].trim();
                System.out.printf("Hash: %d | Real Address: %d | Code: %d | Name: %s | Address: %s | Search Length: %d%n",
                        i, hashFunction(code, hashTable.length), code, name, address, searchLengths[i]);
            }
        }
    }

    public static void main(String[] args) {
        String filename = "C:/Users/Usuario/OneDrive - Universidad Católica de Santa María/UCSM/V SEMESTRE/ALGORITMOS Y ESTRUCTURA DE DATOS/PRÁCTICA/FASE III/2023-AED-G4-SG01/LAB11-HASHING-DISPERSION/EJERCICIOS/EMPLEADO.txt";
        try {
            List<String> elements = readEmployeesFromFile(filename);
            int tableSize = (int) Math.ceil(elements.size() * 1.4); // Adición del 40% al número de elementos
            quadraticProbingHashing(elements, tableSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


