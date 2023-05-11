public class CambioLetrasApp {
    public static void main(String[] args) {
        String cadena="La lluvia en Sevilla es una maravilla";
        //Aviso, de esta forma no modifica el String original 
        System.out.print(cadena.replace('a', 'e'));
    }
}
