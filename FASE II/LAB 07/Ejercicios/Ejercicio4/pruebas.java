package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Ejercicio3.PriorityQueueLinked;
import Actividad1.*;
import Ejercicio1.StackLink;

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
                //System.out.println(postfija);
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
        StringBuilder numero = new StringBuilder(); // Para construir números de más de un dígito
        try {
            for (char caracter : infija.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    numero.append(caracter); // Agregar dígitos al número
                } else {
                    if (numero.length() > 0) {
                        // Si hay un número pendiente, agregarlo a la cadena de salida
                        postfija.append(numero.toString());
                        postfija.append(" ");
                        numero.setLength(0); // Limpiar el StringBuilder del número
                    }
                    if (operaciones.Searchel(caracter)) {
                        while (!pilaoperaciones.isEmpty() && pilaoperaciones.top() != '('
                                && operaciones.Searchpriority(pilaoperaciones.top()) >= operaciones
                                        .Searchpriority(caracter)) {
                            postfija.append(pilaoperaciones.pop());
                            postfija.append(" ");
                        }
                        pilaoperaciones.push(caracter);
                    } else if (caracter == '(') {
                        pilaoperaciones.push(caracter);
                    } else if (caracter == ')') {
                        while (!pilaoperaciones.isEmpty() && pilaoperaciones.top() != '(') {
                            postfija.append(pilaoperaciones.pop());
                            postfija.append(" ");
                        }
                        pilaoperaciones.pop();
                    }
                }
            }
            if (numero.length() > 0) {
                // Si hay un número pendiente, agregarlo a la cadena de salida
                postfija.append(numero.toString());
                postfija.append(" ");
            }
            while (!pilaoperaciones.isEmpty()) {
                postfija.append(pilaoperaciones.pop());
                postfija.append(" ");
            }
        } catch (ExceptionIsEmpty e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return postfija.toString().trim(); // Eliminar espacios sobrantes al inicio y final
    }

    public int resultExpresion(String postfija) {
        StackLink<Integer> pilaresultado = new StackLink<Integer>();
        int resultado = 0;
        String[] tokens = postfija.split(" ");
        for (String token : tokens) {
            if (token.matches("\\d+")) { // si el token es un número
                pilaresultado.push(Integer.parseInt(token));
            } else { // si el token es un operador
                int op2 = 0;
                int op1 = 0;
                try {
                    op2 = pilaresultado.pop();
                    op1 = pilaresultado.pop();
                } catch (ExceptionIsEmpty e) {
                    e.printStackTrace();
                }
                switch (token) {
                    case "+":
                        pilaresultado.push(op1 + op2);
                        break;
                    case "-":
                        pilaresultado.push(op1 - op2);
                        break;
                    case "*":
                        pilaresultado.push(op1 * op2);
                        break;
                    case "/":
                        pilaresultado.push(op1 / op2);
                        break;
                    case "S":
                        pilaresultado.push((int) Math.pow(op1, op2));
                        break;
                }
            }
        }
        try {
            resultado = pilaresultado.top();
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        return resultado;
    }

}
