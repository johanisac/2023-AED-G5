package Actividad1;

public class ExceptionIsEmpty extends Exception {

    public ExceptionIsEmpty() {
        super("La lista está vacía");
    }

    public ExceptionIsEmpty(String message) {
        super(message);
    }
}