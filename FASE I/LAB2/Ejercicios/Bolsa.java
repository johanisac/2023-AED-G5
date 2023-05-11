import java.util.ArrayList;
import java.util.Iterator;

//implements=indica que la clase bolsa pondrá en funcionamiento la interfaz "Iterable"
//La clase Bolsa tiene un tipo genérico "T", entonces puede trabajar con cualquier tipo de objeto
//Usamos ArrayList para almacenar los objetos
public class Bolsa<T> implements Iterable<T> {

    private ArrayList<T> lista = new ArrayList<T>(); //Usamos ArrayList para almacenar los objetos
    private int tope; //para limitar el número de objetos agregados en la bolsa

    public Bolsa(int tope) {
        super();
        this.tope = tope;
    }

    public void add(T objeto) {//funcón para validar el limite de objetos 
        if (lista.size() >= tope) {
        lista.add(objeto);
        } else {
        throw new RuntimeException("no caben mas");//excepcion en tiempo de ejecución
        }
    }

    public Iterator<T> iterator() {//Devuelve un objeto iterator (los revuelve)
        return lista.iterator();
    }
}
