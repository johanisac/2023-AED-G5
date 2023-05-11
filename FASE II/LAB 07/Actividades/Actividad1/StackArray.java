package Actividad1;

class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        tope = -1;
    }

    public void push(E x) {
        if (isFull()) {
            // lanzar una excepción si la pila ya está llena
            throw new RuntimeException("la pila está llena");
        }
        tope++;
        array[tope] = x;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            // lanzar una excepción si la pila ya está llena
            throw new ExceptionIsEmpty("la pila está llena");
        }
        E value = array[tope];
        tope--;
        return value;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            // lanzar una excepción si la pila ya está llena
            throw new ExceptionIsEmpty("la pila está llena");
        }
        return array[tope];
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean isFull() {
        return tope == array.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString();
    }
}
