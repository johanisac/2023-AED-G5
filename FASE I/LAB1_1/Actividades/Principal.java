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
                System.out.println(" \t ********************** CASOS DE PRUEBA ********************** \t\n\n");
                System.out.printf("%-52s %-10s %-10s\n", "Ingrese una esquina del 1er rectángulo:",
                                Rectangle.getEsquina1().getX(), Rectangle.getEsquina1().getY());
                System.out.printf("%-52s %-10s %-10s\n", "Ingrese la esquina opuesta del 1er rectángulo:",
                                Rectangle.getEsquina2().getX(), Rectangle.getEsquina2().getY());
                System.out.printf("%-52s %-10s %-10s\n", "Ingrese una esquina del 2do rectángulo:",
                                Rectangle1.getEsquina1().getX(), Rectangle1.getEsquina1().getY());
                System.out.printf("%-52s %-10s %-10s\n", "Ingrese la esquina opuesta del 2do rectángulo:",
                                Rectangle1.getEsquina2().getX(), Rectangle1.getEsquina2().getY());
                System.out.println(" ");
                System.out.print("Rectangulo A =");
                System.out.println(Rectangle.toString());

                System.out.print("Rectangulo B =");
                System.out.println(Rectangle1.toString());

                if (Verificador.esSobrepos(Rectangle, Rectangle1)) {
                } else if (Verificador.esDisjunto(Rectangle, Rectangle1)) {
                } else if (Verificador.seJuntan(Rectangle, Rectangle1)) {
                }

                sc.close();
        }

}
