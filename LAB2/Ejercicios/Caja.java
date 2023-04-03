import java.util.ArrayList;
import java.util.Iterator;

public class Caja<T> implements Iterable<T> {
    private String color;
    private ArrayList<T> lista = new ArrayList<T>();
    private int tope;

    public Caja(String color, int tope) {
        this.color = color;
        this.tope = tope;
    }

    public void add(T objeto) {
        if (lista.size() < tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("La caja está llena");
        }
    }

    public String getColor() {
        return this.color;
    }

    public Iterator<T> iterator() {
        return lista.iterator();
    }

    //////////
    public boolean contiene(T elemento) {
        for (T objeto : lista) {
            if (objeto.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public T eliminar(T objeto) {
        for (T t : lista) {
            if (t.equals(objeto)) {
                lista.remove(t);
                return t;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public String toString() {
        return "La Caja " + super.toString() + " de color " + this.color + " almacena :";
    }

}
