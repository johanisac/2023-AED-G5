import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                double ComponenteX, ComponenteY;
                int opciones = 0;
                Rectangulo Rectangle = new Rectangulo(new Coordenada(3, 0), new Coordenada(0, 7));
                Coordenada CodenadaX = new Coordenada(1, 5);
                Coordenada CodenadaY = new Coordenada(1, 5);
                System.out.print("\n Capacidad maxima del contenedor de rectangulos: ");
                int numeros = sc.nextInt();
                ContainerRect contenedor = new ContainerRect(numeros);

                do {
                        try {

                                menu();
                                System.out.print("Ingresar Opcion :");
                                opciones = sc.nextInt();
                                while (opciones > 5 || opciones <= 0) {
                                        System.out.print("Ingresar Opcion (1-3):");
                                        opciones = sc.nextInt();
                                }
                                switch (opciones) {
                                        case 1:
                                                System.out.println("Ingrese una esquina del rectángulo:");
                                                ComponenteX = sc.nextDouble();
                                                ComponenteY = sc.nextDouble();
                                                CodenadaX = new Coordenada(ComponenteX, ComponenteY);

                                                System.out.println("Ingrese la esquina opuesta del rectángulo:");
                                                ComponenteX = sc.nextDouble();
                                                ComponenteY = sc.nextDouble();
                                                CodenadaY = new Coordenada(ComponenteX, ComponenteY);
                                                Rectangle = new Rectangulo(CodenadaX, CodenadaY);
                                                contenedor.addRectangulo(Rectangle);
                                                break;
                                        case 2:
                                                System.out.println("\n" + contenedor.toString());
                                                break;
                                        case 3:
                                                System.out.println(
                                                                "\n\n *************************** VISITANOS MUY PRONTO *************************** \t");
                                                break;
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Error: No se pudo completar la operacion");
                                sc.next();
                        }
                } while (opciones != 3);
                sc.close();
        }

        public static void menu() {
                System.out.println(
                                "\n************************************** MENU **************************************");
                System.out.println("\t1.Agregar Rectangulo.\t");
                System.out.println("\t2.Mostrar Lista de Rectangulos\t");
                System.out.println("\t3.Salir \t");
                System.out.println(
                                "***********************************************************************************\n");
        }

}
