package Actividad1;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        // crear una pila de enteros
        System.out.println("\n\tPila de enteros\n");
        Stack<Integer> pilaEnteros = new StackArray<>(5);
        // agregar elementos a la pila de enteros
        pilaEnteros.push(10);
        pilaEnteros.push(20);
        pilaEnteros.push(30);

        // mostrar el contenido de la pila de enteros
        System.out.println("Pila de enteros: " + pilaEnteros);
        System.out.println("Elemento en la cima de la pila: " + pilaEnteros.top());

        // quitar elementos de la pila de enteros
        int elemento = pilaEnteros.pop();
        System.out.println("Elemento eliminado: " + elemento);
        System.out.println("Pila de enteros después de eliminar elemento: " + pilaEnteros);

        // crear una pila de flotantes
        System.out.println("\n\tPila de flotantes\n");
        Stack<Float> pilaFlotantes = new StackArray<>(5);

        // agregar elementos a la pila de flotantes
        pilaFlotantes.push(1.5f);
        pilaFlotantes.push(2.7f);
        pilaFlotantes.push(3.9f);

        // mostrar el contenido de la pila de flotantes
        System.out.println("Pila de flotantes: " + pilaFlotantes);
        System.out.println("Elemento en la cima de la pila: " + pilaFlotantes.top());

        // quitar elementos de la pila de flotantes
        float elementoFlotante = pilaFlotantes.pop();
        System.out.println("Elemento eliminado: " + elementoFlotante);
        System.out.println("Pila de flotantes después de eliminar elemento: " + pilaFlotantes);

        // crear una pila de cadenas
        System.out.println("\n\tPila de cadenas\n");
        Stack<String> pilaCadenas = new StackArray<>(5);

        // agregar elementos a la pila de cadenas
        pilaCadenas.push("JAVA");
        pilaCadenas.push("PYTHON");
        pilaCadenas.push("C++");

        // mostrar el contenido de la pila de cadenas
        System.out.println("Pila de cadenas: " + pilaCadenas);
        System.out.println("Elemento en la cima de la pila: " + pilaCadenas.top());

        // quitar elementos de la pila de cadenas
        String elementoCadena = pilaCadenas.pop();
        System.out.println("Elemento eliminado: " + elementoCadena);
        System.out.println("Pila de cadenas después de eliminar elemento: " + pilaCadenas);

        // crear una pila de booleanos
        System.out.println("\n\tPila de booleanos\n");
        Stack<Boolean> pilaBooleanos = new StackArray<>(5);

        // agregar elementos a la pila de booleanos
        pilaBooleanos.push(true);
        pilaBooleanos.push(false);
        pilaBooleanos.push(true);

        // mostrar el contenido de la pila de booleanos
        System.out.println("Pila de booleanos: " + pilaBooleanos);
        System.out.println("Elemento en la cima de la pila: " + pilaBooleanos.top());

        // quitar elementos de la pila de booleanos
        boolean elementoBooleano = pilaBooleanos.pop();
        System.out.println("Elemento eliminado: " + elementoBooleano);
        System.out.println("Pila de booleanos después de eliminar elemento: " + pilaBooleanos);
    }
}
