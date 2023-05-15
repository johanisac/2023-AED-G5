package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Ejercicio3.PriorityQueueLinked;
import Actividad1.*;
import Ejercicio1.StackLink;

// Esta es mi primera version en la cual me estoy dando cuenta que falta muchos detalles como primeor el detalle que solo acepta el tamaño del numero que es 1
// en la cual solo haci operaciones con uno otro detalle que podemos ver es que es en resultExpresion cuando dividimos en entero 10/3 = 3 pero en una operacion puede ser perjudicial.
public class pruebas {

    public void readFile(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.length() == 0 || linea.charAt(0) != '$' || linea.charAt(linea.length() - 1) != '$') {
                    System.out.println("Expresión inválida " + linea);
                    continue;
                }
                String infija = linea.substring(1, linea.length() - 1);
                String postfija = inToPos(infija);
                // System.out.println("postfija " + postfija);
                int resultado = resultExpresion(postfija);
                System.out.println(infija + " = " + resultado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String inToPos(String infija) {
        PriorityQueueLinked<Character, Integer> operaciones = new PriorityQueueLinked<>(3);
        operaciones.enqueue('+', 1);
        operaciones.enqueue('-', 1);
        operaciones.enqueue('*', 2);
        operaciones.enqueue('/', 2);
        operaciones.enqueue('S', 3);
        StringBuilder postfija = new StringBuilder();
        StackArray<Character> pilaoperaciones = new StackArray<>(100);
        try {
            for (char caracter : infija.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    postfija.append(caracter);

                } else if (operaciones.Searchel(caracter)) {
                    while (!pilaoperaciones.isEmpty() && pilaoperaciones.top() != '('
                            && operaciones.Searchpriority(pilaoperaciones.top()) >= operaciones
                                    .Searchpriority(caracter)) {
                        postfija.append(pilaoperaciones.pop());
                    }
                    pilaoperaciones.push(caracter);
                } else if (caracter == '(') {
                    pilaoperaciones.push(caracter);
                } else if (caracter == ')') {
                    while (!pilaoperaciones.isEmpty() && pilaoperaciones.top() != '(') {
                        postfija.append(pilaoperaciones.pop());
                    }
                    pilaoperaciones.pop();
                }
            }
            while (!pilaoperaciones.isEmpty()) {
                postfija.append(pilaoperaciones.pop());
            }
        } catch (ExceptionIsEmpty e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return postfija.toString();
    }

    public int resultExpresion(String postfija) {
        StackLink<Integer> pilaresultado = new StackLink<Integer>();
        int resultado = 0;
        for (char caracter : postfija.toCharArray()) {
            if (Character.isDigit(caracter)) {
                pilaresultado.push(Character.getNumericValue(caracter));
            } else {
                int op2 = 0;
                int op1 = 0;
                try {
                    op2 = pilaresultado.pop();
                    op1 = pilaresultado.pop();
                } catch (ExceptionIsEmpty e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                switch (caracter) {
                    case '+':
                        pilaresultado.push(op1 + op2);
                        break;
                    case '-':
                        pilaresultado.push(op1 - op2);
                        break;
                    case '*':
                        pilaresultado.push(op1 * op2);
                        break;
                    case '/':
                        pilaresultado.push(op1 / op2);
                        break;
                    case 'S':
                        pilaresultado.push((int) Math.pow(op1, op2));
                        break;
                }
            }
        }
        try {
            resultado = pilaresultado.top();
        } catch (ExceptionIsEmpty e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;

    }
}
