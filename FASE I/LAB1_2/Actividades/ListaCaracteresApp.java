public class ListaCaracteresApp {
    public static void main(String[] args) {
        String cadena = "La lluvia en Sevilla es una maravilla";
        for (int i = 0; i < cadena.length(); i++) {
            // Hacemos un casting para convertir el char a int
            System.out.print((int) cadena.charAt(i) + " ");
        }
    }
}
