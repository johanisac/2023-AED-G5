import javax.swing.JOptionPane;

public class Ejercicios_basicos_DDR_29 {
    public static void main(String[] args) {
        String texto = JOptionPane.showInputDialog(null,
                "Introduce un texto , cadena vacia para terminar",
                "Introducir texto",
                JOptionPane.INFORMATION_MESSAGE);

        String cadenaResultante = "";
        // mientras no este vacio la cadena escrita continuo
        while (!texto.isEmpty()) {
            // concatenamos el texto
            cadenaResultante += texto;

            // reintroducimos de nuevo una cadena
            texto = JOptionPane.showInputDialog(null,
                    "Introduce un texto , cadena vacia para terminar",
                    "Introducir texto",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,
                cadenaResultante,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
    }
}