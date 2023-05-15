package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Ejercicio3.PriorityQueueLinked;
import Actividad1.*;
import Ejercicio1.StackLink;

class Polaca {
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
                //System.out.println("posfijo " + postfija);
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
        int i = 0;
        try {
            while (i < infija.length()) {
                char caracter = infija.charAt(i);
                if (Character.isDigit(caracter)) {
                    int j = i;
                    while (j < infija.length() && Character.isDigit(infija.charAt(j))) {
                        j++;
                    }
                    postfija.append(infija.substring(i, j));
                    postfija.append(" ");
                    i = j - 1;
                } else if (operaciones.Searchel(caracter)) {
                    while (!pilaoperaciones.isEmpty() && pilaoperaciones.top() != '('
                            && operaciones.Searchpriority(pilaoperaciones.top()) >= operaciones
                                    .Searchpriority(caracter)) {
                        postfija.append(pilaoperaciones.pop());
                        postfija.append(" ");
                    }
                    pilaoperaciones.push(caracter);
                } else if (caracter == '(') {
                    if (i > 0 && (Character.isDigit(infija.charAt(i - 1)) || infija.charAt(i - 1) == ')')) {
                        // Multiplicar
                        pilaoperaciones.push('*');
                    }
                    pilaoperaciones.push(caracter);
                } else if (caracter == ')') {
                    while (!pilaoperaciones.isEmpty() && pilaoperaciones.top() != '(') {
                        postfija.append(pilaoperaciones.pop());
                        postfija.append(" ");
                    }
                    pilaoperaciones.pop();
                    if (i < infija.length() - 1
                            && (Character.isDigit(infija.charAt(i + 1)) || infija.charAt(i + 1) == '(')) {
                        // Multiplicar
                        postfija.append('*');
                        postfija.append(" ");
                    }
                }
                i++;
            }
            while (!pilaoperaciones.isEmpty()) {
                postfija.append(pilaoperaciones.pop());
                postfija.append(" ");
            }
        } catch (ExceptionIsEmpty e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return postfija.toString();
    }

    public int resultExpresion(String postfija) {
        StackLink<Float> pilaresultado = new StackLink<Float>();
        int resultado = 0;
        String[] tokens = postfija.split(" ");
        for (String token : tokens) {
            if (token.matches("\\d+")) { // si el token es un número
                pilaresultado.push(Float.parseFloat(token));
            } else { // si el token es un operador
                Float op2 = 0f;
                Float op1 = 0f;
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
                        pilaresultado.push((float) Math.pow(op1, op2));
                        break;
                }
            }
        }

        try {
            resultado = pilaresultado.top().intValue();
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        return resultado;
    }

}