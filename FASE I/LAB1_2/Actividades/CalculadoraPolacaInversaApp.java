import javax.swing.JOptionPane;

public class CalculadoraPolacaInversaApp {
    public static void main(String[] args) {
        // no importa que sean int o double
        double operando1;
        double operando2;
        double resultado = 0;
        // Nos pide los operandos y el signo de operacion
        String texto = JOptionPane.showInputDialog("Escribe el operando 1");
        operando1 = Integer.parseInt(texto);
        String operacion = JOptionPane.showInputDialog("Escribe el codigo de operacion");
        String texto2 = JOptionPane.showInputDialog("Escribe el operando 2");
        operando2 = Integer.parseInt(texto2);
        // segun el codigo de operacion, haremos una u otra accion
        switch (operacion) {
            case "+":
                resultado = operando1 + operando2;
                break;
            case "-":
                resultado = operando1 - operando2;
                break;
            case "*":
                resultado = operando1 * operando2;
                break;
            case "/":
                resultado = operando1 / operando2;
                break;
            case "A":
                resultado = (int) Math.pow(operando1, operando2);
                break;
            case "%":
                resultado = operando1 % operando2;
                break;
        }
        JOptionPane.showMessageDialog(null, operando1 + " " + operacion + " " + operando2 + " = " + resultado);
    }
}