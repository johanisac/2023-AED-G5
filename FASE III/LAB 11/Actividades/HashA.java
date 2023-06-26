import java.util.ArrayList;
import java.util.LinkedList;

public class HashA<E extends Comparable<E>> {
    protected class Element {
        LinkedList<Register<E>> chain;

        public Element() {
            this.chain = new LinkedList<>();
        }
    }

    protected ArrayList<Element> table;
    protected int m;

    public HashA(int n) {
        this.m = n; // calcular el primo cercano a n y asignarlo a m
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++)
            this.table.add(new Element());
    }

    private int functionHash(int key) {
        return key % m;
    }

    public void insert(int key, E reg) {
        Register<E> newRegister = new Register<>(key, reg);
        int hashedAddress = functionHash(key);

        table.get(hashedAddress).chain.add(newRegister);
    }

    public E search(int key) {
        int hashedAddress = functionHash(key);

        LinkedList<Register<E>> chain = table.get(hashedAddress).chain;

        for (Register<E> register : chain) {
            if (register.getKey() == key) {
                return register.value;
            }
        }

        return null;
    }

    public String toString() {
        String s = "D. Real\tD. Hash\tRegister\n";

        for (int i = 0; i < m; i++) {
            s += i + " -->\t" + functionHash(i) + "\t";

            LinkedList<Register<E>> chain = table.get(i).chain;

            if (chain.isEmpty()) {
                s += "Null\n";
            } else {
                for (Register<E> register : chain) {
                    s += register + " -> ";
                }
                s += "\n";
            }
        }

        return s;
    }
}
