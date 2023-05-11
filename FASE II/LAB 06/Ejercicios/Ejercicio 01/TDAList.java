public interface TDAList<T> {

    // Verifica si la lista está vacía
    public boolean isEmptyList();

    // Obtiene la longitud de la lista
    public int length();

    // Elimina todos los elementos de la lista
    public void destroyList();

    // Verifica si el elemento x está en la lista y retorna su posición
    public int search(T x);

    // Inserta un nuevo elemento x al inicio de la lista
    public void insertFirst(T x);

    // Inserta un nuevo elemento x al final de la lista
    public void insertLast(T x);

    // Elimina el elemento x de la lista
    public void removeNode(T x);
}
