package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Polaca1 {

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
                System.out.println(postfija);
                int resultado = resultExpresion(postfija);
                System.out.println(infija + " = " + resultado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String inToPos(String infija) {
        Map<Character, Integer> precedencia = new HashMap<>();
        precedencia.put('+', 1);
        precedencia.put('-', 1);
        precedencia.put('*', 2);
        precedencia.put('/', 2);
        precedencia.put('S', 3);

        StringBuilder postfija = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (char caracter : infija.toCharArray()) {
            if (Character.isDigit(caracter)) {
                postfija.append(caracter);
                postfija.append(' ');
            } else if (precedencia.containsKey(caracter)) {
                while (!pila.isEmpty() && pila.peek() != '('
                        && precedencia.get(pila.peek()) >= precedencia.get(caracter)) {
                    postfija.append(pila.pop());
                }
                pila.push(caracter);
            } else if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    postfija.append(pila.pop());
                }
                pila.pop();
            }
        }

        while (!pila.isEmpty()) {
            postfija.append(pila.pop());
        }

        return postfija.toString();
    }

    public int resultExpresion(String postfija) {
        Stack<Integer> pila = new Stack<>();

        for (char caracter : postfija.toCharArray()) {
            if (Character.isDigit(caracter)) {
                pila.push(Character.getNumericValue(caracter));
            } else {
                int op2 = pila.pop();
                int op1 = pila.pop();
                switch (caracter) {
                    case '+':
                        pila.push(op1 + op2);
                        break;
                    case '-':
                        pila.push(op1 - op2);
                        break;
                    case '*':
                        pila.push(op1 * op2);
                        break;
                    case '/':
                        pila.push(op1 / op2);
                        break;
                    case 'S':
                        pila.push((int) Math.pow(op1, op2));
                        break;
                }
            }
        }

        return pila.peek();
    }
}
