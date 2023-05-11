import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ComponenteX, ComponenteY;
        Rectangulo Rectangle = new Rectangulo(new Coordenada(3, 0), new Coordenada(0, 7));
        Rectangulo Rectangle1 = new Rectangulo(new Coordenada(3, 0), new Coordenada(0, 7));
        Coordenada CodenadaX = new Coordenada(1, 5);
        Coordenada CodenadaY = new Coordenada(1, 5);

        System.out.println(
                " \t ************************************** BIENVENIDOS ************************************** \t\n\n");

        System.out.println("Ingrese una esquina del 1er rectángulo:");
        ComponenteX = sc.nextDouble();
        ComponenteY = sc.nextDouble();
        CodenadaX = new Coordenada(ComponenteX, ComponenteY);

        System.out.println("Ingrese la esquina opuesta del 1er rectángulo:");
        ComponenteX = sc.nextDouble();
        ComponenteY = sc.nextDouble();
        CodenadaY = new Coordenada(ComponenteX, ComponenteY);
        Rectangle = new Rectangulo(CodenadaX, CodenadaY);

        System.out.println("Ingrese una esquina del 2do rectángulo:");
        ComponenteX = sc.nextDouble();
        ComponenteY = sc.nextDouble();
        CodenadaX = new Coordenada(ComponenteX, ComponenteY);

        System.out.println("Ingrese la esquina opuesta del 2do rectángulo:");
        ComponenteX = sc.nextDouble();
        ComponenteY = sc.nextDouble();
        CodenadaY = new Coordenada(ComponenteX, ComponenteY);
        Rectangle1 = new Rectangulo(CodenadaX, CodenadaY);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("%-52s %-10s %-10s\n", "Ingrese una esquina del 1er rectángulo:",
                Rectangle.getEsquina1().getX(), Rectangle.getEsquina1().getY());
        System.out.printf("%-52s %-10s %-10s\n", "Ingrese la esquina opuesta del 1er rectángulo:",
                Rectangle.getEsquina2().getX(), Rectangle.getEsquina2().getY());
        System.out.printf("%-52s %-10s %-10s\n", "Ingrese una esquina del 2do rectángulo:",
                Rectangle1.getEsquina1().getX(), Rectangle.getEsquina1().getY());
        System.out.printf("%-52s %-10s %-10s\n", "Ingrese la esquina opuesta del 2do rectángulo:",
                Rectangle1.getEsquina2().getX(), Rectangle.getEsquina2().getY());
        System.out.println(" ");

        System.out.print("Rectangulo A =");
        System.out.println(Rectangle.toString());

        System.out.print("Rectangulo B =");
        System.out.println(Rectangle1.toString());

        Verificador.esSobrepos(Rectangle, Rectangle1);

        // do {
        // try {
        // // menu();
        // // System.out.println("Ingresar Opcion :");
        // // opcione;s = sc.nextDouble();
        // opciones = 1;
        // while (opciones > 5 || opciones <= 0) {
        // System.out.println("Ingresar Opcion (1-3):");
        // opciones = sc.nextDouble();
        // }
        // switch (opciones) {
        // case 1:

        // case 2:
        // System.out.println("\t Área del Rectangulo es : " +
        // Manejador.area(Rectangle));
        // System.out.println("\t Perimetro del Rectangulo es : " +
        // Manejador.perimetro(Rectangle));
        // break;
        // case 3:
        // System.out.println("Ingresar Mover en el Eje X : ");
        // mover = sc.nextDouble();
        // Manejador.moverX(mover, Rectangle);

        // break;
        // case 4:
        // System.out.println("Ingresar Mover en el Eje Y: ");
        // mover = sc.nextDouble();
        // Manejador.moverY(mover, Rectangle);
        // break;
        // case 5:
        // System.out.println(
        // "\n\n \t *************************** VISITANOS MUY PRONTO
        // *************************** \t");
        // break;
        // }
        // } catch (InputMismatchException e) {
        // System.out.println("Error: No se pudo completar la operacion");
        // sc.next();
        // }
        // } while (opciones != 5);

        sc.close();
    }

    public static void menu() {
        System.out.println("************************************** MENU **************************************");
        System.out.println("\t1.Crear Rectangulo. \t");
        System.out.println("\t2.Hallar el Area y Perimetro\t");
        System.out.println("\t3.Ingresar Moverse en X \t");
        System.out.println("\t4.Ingresar Moverse en Y \t");
        System.out.println("\t5.Salir \t");
        System.out.println("***********************************************************************************");
    }

}
