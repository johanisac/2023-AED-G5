import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibreriaUniversal {
    private Map<String, List<Book>> librosPorEspecialidad;

    public LibreriaUniversal() {
        librosPorEspecialidad = new HashMap<>();
    }

    public void agregarLibro(Book libro) {
        String especialidad = libro.getSpecialty();
        if (!librosPorEspecialidad.containsKey(especialidad)) {
            librosPorEspecialidad.put(especialidad, new ArrayList<>());
        }

        librosPorEspecialidad.get(especialidad).add(libro);
    }

    public void modificarLibro(Book libro) {
        String especialidad = libro.getSpecialty();
        if (librosPorEspecialidad.containsKey(especialidad)) {
            List<Book> libros = librosPorEspecialidad.get(especialidad);
            for (int i = 0; i < libros.size(); i++) {
                Book libroExistente = libros.get(i);
                if (libroExistente.getAuthor().equals(libro.getAuthor()) && libroExistente.getTitle().equals(libro.getTitle())) {
                    libros.set(i, libro);
                    break;
                }
            }
        }
    }

    public Book compraSegura(String autor) {
        Book mejorLibro = null;
        int mejorCalificacion = Integer.MIN_VALUE;

        for (List<Book> libros : librosPorEspecialidad.values()) {
            for (Book libro : libros) {
                if (libro.getAuthor().equals(autor) && libro.getRating() > mejorCalificacion) {
                    mejorLibro = libro;
                    mejorCalificacion = libro.getRating();
                }
            }
        }

        return mejorLibro;
    }

    public List<Book> listado(String especialidad) {
        List<Book> librosEspecialidad = librosPorEspecialidad.getOrDefault(especialidad, new ArrayList<>());
        librosEspecialidad.sort((libro1, libro2) -> Integer.compare(libro2.getSales(), libro1.getSales()));
        return librosEspecialidad;
    }

    public Book buscarLibro(String autor, String titulo) {
        for (List<Book> libros : librosPorEspecialidad.values()) {
            for (Book libro : libros) {
                if (libro.getAuthor().equals(autor) && libro.getTitle().equals(titulo)) {
                    return libro;
                }
            }
        }

        return null;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibreriaUniversal libreria = new LibreriaUniversal();

        int opcion = 0;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    agregarLibro(libreria, scanner);
                    break;
                case 2:
                    modificarLibro(libreria, scanner);
                    break;
                case 3:
                    compraSegura(libreria, scanner);
                    break;
                case 4:
                    listarLibros(libreria, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Agregar libro");
        System.out.println("2. Modificar libro");
        System.out.println("3. Compra segura");
        System.out.println("4. Listar libros");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void agregarLibro(LibreriaUniversal libreria, Scanner scanner) {
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ingrese las ventas: ");
        int ventas = scanner.nextInt();

        System.out.print("Ingrese la calificación de la crítica: ");
        int calificacion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Ingrese la especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.print("Ingrese los comentarios: ");
        String comentarios = scanner.nextLine();

        Book libro = new Book(titulo, autor, ventas, calificacion, especialidad, comentarios);
        libreria.agregarLibro(libro);

        System.out.println("Libro agregado correctamente.");
    }

    private static void modificarLibro(LibreriaUniversal libreria, Scanner scanner) {
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();

        Book libroExistente = libreria.buscarLibro(autor, titulo);
        if (libroExistente != null) {
            System.out.println("Libro encontrado:");
            System.out.println(libroExistente);
            System.out.println();

            System.out.print("Ingrese las ventas: ");
            int ventas = scanner.nextInt();

            System.out.print("Ingrese la calificación de la crítica: ");
            int calificacion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            System.out.print("Ingrese los comentarios: ");
            String comentarios = scanner.nextLine();

            libroExistente.setSales(ventas);
            libroExistente.setRating(calificacion);
            libroExistente.setComments(comentarios);

            libreria.modificarLibro(libroExistente);

            System.out.println("Libro modificado correctamente.");
        } else {
            System.out.println("El libro no existe en la librería.");
        }
    }

    private static void compraSegura(LibreriaUniversal libreria, Scanner scanner) {
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();

        Book libroCompraSegura = libreria.compraSegura(autor);
        if (libroCompraSegura != null) {
            System.out.println("El libro con mejor crítica del autor " + autor + " es:");
            System.out.println(libroCompraSegura);
        } else {
            System.out.println("No hay libros del autor " + autor + " en la librería.");
        }
    }

    private static void listarLibros(LibreriaUniversal libreria, Scanner scanner) {
        System.out.print("Ingrese la especialidad: ");
        String especialidad = scanner.nextLine();

        List<Book> librosEspecialidad = libreria.listado(especialidad);
        if (!librosEspecialidad.isEmpty()) {
            System.out.println("Listado de libros de la especialidad " + especialidad + ":");
            for (Book libro : librosEspecialidad) {
                System.out.println(libro);
            }
        } else {
            System.out.println("No hay libros de la especialidad " + especialidad + " en la librería.");
        }

    }

}
