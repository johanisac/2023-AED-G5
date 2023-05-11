import javax.swing.JOptionPane;

/* Solicita al usuario que ingrese una frase y luego le da la opción de transformarla toda a mayúsculas o a minúsculas, dependiendo 
de lo que el usuario seleccione. Finalmente, muestra el resultado de la transformación en una ventana. */

/*  podría ser útil en situaciones en las que se necesite manipular texto, por ejemplo, para convertir nombres de archivos a un 
formato determinado. Por ejemplo, en una aplicación de gestión de archivos, se podría utilizar este programa para convertir 
los nombres de los archivos a minúsculas o mayúsculas para que tengan un formato uniforme.*/

public class Ejercicio2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String texto = JOptionPane.showInputDialog(null, "Por favor, introduce una frase", "Introduccion",
                JOptionPane.INFORMATION_MESSAGE);
        String cadenaResultante;
        // true = lo pasamos todo a mayusculas
        // false = lo pasamos todo a minusculas
        boolean isMayus;

        int eleccion = JOptionPane.showConfirmDialog(null, "Quieres que se pase a mayusculas?", "Eleccion",
                JOptionPane.YES_NO_OPTION);

        isMayus = (eleccion == JOptionPane.YES_OPTION);

        // Segun lo elegido, lo transformaremos a mayuscula o minuscula
        if (isMayus) {
            cadenaResultante = texto.toUpperCase();
        } else {
            cadenaResultante = texto.toLowerCase();
        }

        JOptionPane.showMessageDialog(null, cadenaResultante, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}
// Según lo elegido, transformar a