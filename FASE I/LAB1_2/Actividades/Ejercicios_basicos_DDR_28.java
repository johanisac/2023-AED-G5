import javax.swing.JOptionPane;

public class Ejercicios_basicos_DDR_28 {
    public static void main(String[] args) {
        String texto = JOptionPane.showInputDialog(null, "Inserte una frase",
                "Insercion",
                JOptionPane.INFORMATION_MESSAGE);
        // usado para almacenar el texto final
        String texto_sin_espacios = "";
        char caracterActual;
        // recorro el Array
        for (int i = 0; i < texto.length(); i++) {
            caracterActual = texto.charAt(i);

            // cuando es un espacio no lo copia a la cadena
            if (caracterActual != ' ') {
                texto_sin_espacios += String.valueOf(caracterActual);
            }
        }
        JOptionPane.showMessageDialog(null,
                "La frase tiene sin es espacios es " + texto_sin_espacios,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
    }
}