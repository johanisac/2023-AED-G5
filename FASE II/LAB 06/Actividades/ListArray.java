public class ListArray<T> implements TDAList<T> {

    private T[] Lista; // arreglo que representa la lista
    private int Longitud; // tamaño actual de la lista

    // Constructor que recibe el tamaño inicial del arreglo
    public ListArray(int tamano) {
        this.Lista = (T[]) new Object[tamano]; // se crea el arreglo con el tamaño especificado
        this.Longitud = 0; // la lista inicia vacía
    }

    @Override
    public boolean isEmptyList() {
        return Longitud == 0; // la lista está vacía si su tamaño es cero
    }

    @Override
    public int length() {
        return Longitud; // la longitud de la lista es su tamaño actual
    }

    @Override
    public void destroyList() {
        // se crea un nuevo arreglo con el mismo tamaño que el original
        this.Lista = (T[]) new Object[Lista.length];
        this.Longitud = 0; // la lista queda vacía
    }

    @Override
    public int search(T x) {
        // se recorre el arreglo buscando el elemento
        for (int i = 0; i < Longitud; i++) {
            if (Lista[i].equals(x)) { // se utiliza el método equals para comparar objetos
                return i; // se retorna la posición del elemento si se encuentra
            }
        }
        return -1; // si no se encuentra, se retorna -1
    }

    @Override
    public void insertFirst(T x) {
        // se desplazan todos los elementos hacia la derecha para dejar espacio al nuevo
        for (int i = Longitud - 1; i >= 0; i--) {
            Lista[i + 1] = Lista[i];
        }
        Lista[0] = x; // se inserta el nuevo elemento al inicio
        Longitud++; // se aumenta el tamaño de la lista
    }

    @Override
    public void insertLast(T x) {
        Lista[Longitud] = x; // se inserta el nuevo elemento al final
        Longitud++; // se aumenta el tamaño de la lista
    }

    @Override
    public void removeNode(T x) {
        // se recorre el arreglo buscando el elemento a eliminar
        for (int i = 0; i < Longitud; i++) {
            if (Lista[i].equals(x)) { // se utiliza el método equals para comparar objetos
                // se desplazan todos los elementos a la izquierda a partir de la posición del
                // elemento a eliminar
                for (int j = i; j < Longitud - 1; j++) {
                    Lista[j] = Lista[j + 1];
                }
                Lista[Longitud - 1] = null; // se elimina la referencia al último elemento
                Longitud--; // se reduce el tamaño de la lista
                break; // se sale del ciclo una vez que se elimina el elemento
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Longitud; i++) {
            sb.append(Lista[i]);
            if (i < Longitud - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
