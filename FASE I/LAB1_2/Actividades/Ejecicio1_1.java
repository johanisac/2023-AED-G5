public class Ejecicio1_1 {

    public static void main(String[] args) {
        double salario = 3000.0;
        String categoria;
        switch ((int) salario) {
            case 1000:
            case 1500:
            case 2000:
                categoria = "Junior";
                break;
            case 2500:
            case 3000:
            case 3500:
                categoria = "Senior";
                break;
            default:
                categoria = "Indefinido";
                break;
        }
        System.out.println("El empleado con salario " + salario + " pertenece a la categoría " + categoria);
    }
}
