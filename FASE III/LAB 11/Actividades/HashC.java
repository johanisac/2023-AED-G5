import java.util.ArrayList;

public class HashC<E extends Comparable<E>> {
    protected class Element {
        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected ArrayList<Element> table;
    protected int m;

    public HashC(int n) {
        this.m = n; // calcular el primo cercano a n y asignarlo a m
        this.table = new ArrayList<Element>(m);
        for (int i = 0; i < m; i++)
            this.table.add(new Element(0, null));
    }

    private int functionHash(int key) {
        return key % m;
    }

    private int linearProbing(int hashedAddress, int key) {
        int i = 1;
        int newIndex = (hashedAddress + i) % m;

        while (table.get(newIndex).mark == 1 && table.get(newIndex).reg.getKey() != key) {
            i++;
            newIndex = (hashedAddress + i) % m;
        }

        return newIndex;
    }

    public void insert(int key, E reg) {
        Register<E> newRegister = new Register<>(key, reg);
        int hashedAddress = functionHash(key);
        int index = hashedAddress;

        while (table.get(index).mark == 1) {
            if (table.get(index).reg.getKey() == key) {
                // La clave ya existe, no se permite duplicados
                return;
            }

            index = linearProbing(hashedAddress, key);
        }

        table.get(index).mark = 1;
        table.get(index).reg = newRegister;
    }

    public E search(int key) {
        int hashedAddress = functionHash(key);
        int index = hashedAddress;

        while (table.get(index).mark == 1) {
            if (table.get(index).reg.getKey() == key) {
                return table.get(index).reg.value;
            }

            index = linearProbing(hashedAddress, key);
        }

        return null;
    }

    public String toString() {
        String s = "D. Real\tD. Hash\tRegister\n";
        int i = 0;

        for (Element item : table) {
            s += (i++) + " -->\t";
            if (item.mark == 1)
                s += functionHash(item.reg.getKey()) + "\t" + item.reg + "\n";
            else
                s += "empty \n";
        }
        return s;
    }
}
