package Ejercicio1;

import Actividad1.ExceptionIsEmpty;

public class Test {

    public static void main(String[] args) throws ExceptionIsEmpty {

        StackLink<Integer> pilaEnteros = new StackLink<Integer>();
        StackLink<Float> pilaFlotantes = new StackLink<Float>();
        StackLink<String> pilaCadenas = new StackLink<String>();
        StackLink<Boolean> pilaBooleanos = new StackLink<Boolean>();
       
        
        // Operaciones con la pila de enteros
        System.out.println("\n\tPila de enteros\n");
        pilaEnteros.push(1);
        pilaEnteros.push(2);
        pilaEnteros.push(3);
        System.out.println("Pila de enteros: " + pilaEnteros);
        System.out.println("Mostrar elemento superior : " + pilaEnteros.top());
        System.out.println("Eliminar elemento superior : " + pilaEnteros.pop());
        System.out.println("Pila de enteros después de eliminar : " + pilaEnteros);
        
        // Operaciones con la pila de flotantes
        System.out.println("\n\tPila de Flotantes\n");
        pilaFlotantes.push(1.5f);
        pilaFlotantes.push(2.5f);
        System.out.println("Pila de flotantes: " + pilaFlotantes); // [2.5, 1.5]
        System.out.println("Mostrar elemento superior : " + pilaFlotantes.top()); // 2.5

        // Operaciones con la pila de cadenas
        System.out.println("\n\tPila de Cadena\n");
        pilaCadenas.push("python");
        pilaCadenas.push("Java");
        System.out.println("Pila de cadenas: " + pilaCadenas); // [mundo, hola]
        System.out.println("Mostrar elemento superior : " + pilaCadenas.top()); // mundo

        // Operaciones con la pila de booleanos
        System.out.println("\n\tPila de booleanos\n");
        pilaBooleanos.push(true);
        pilaBooleanos.push(false);
        System.out.println("Pila de booleanos: " + pilaBooleanos); // [false, true]
        System.out.println("¿La pila de booleanos está vacía? " + pilaBooleanos.isEmpty()); // false
        System.out.println("Eliminar elemento superior : " + pilaBooleanos.pop()); // false
        System.out.println("Pila de booleanos después de eliminar : " + pilaBooleanos); // [true]
    }
}
