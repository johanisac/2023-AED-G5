import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista = new ArrayList<T>();  // se crea un areglo dinamico de tipo generico
    private int tope; // tope de tipo entero

    public Bolsa(int tope) { // constructor de nuestra clase
        super(); // llama a la super clase
        this.tope = tope;
    }

    public void add(T objeto) {
        if (lista.size() >= tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("no caben mas");
        }
    }

    public Iterator<T> iterator() {
        return lista.iterator();
    }
}