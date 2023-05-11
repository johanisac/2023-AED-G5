public class Principal {
    public static void main(String[] args) {
        String cadena = "La lluvia en Sevilla es una maravilla"; // cadena guarda informacion de la tipo String
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) { // length nos permite saber la cantidad de cadena que hay
            // Comprobamos si el caracter es una vocal
            if (cadena.charAt(i) == 'a' ||
                    cadena.charAt(i) == 'e' ||
                    cadena.charAt(i) == 'i' ||
                    cadena.charAt(i) == 'o' ||
                    cadena.charAt(i) == 'u') { // Con el if comparamos con el codigo
                contador++; // nos cuenta cada contador
            }
        }
        System.out.println("Hay " + contador + " vocales");
    }
}