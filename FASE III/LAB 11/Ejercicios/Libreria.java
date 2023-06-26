import java.util.*;

public class Libreria {
    private class Libro {
        String titulo;
        String autor;
        int ventas;
        int calificacion;
        String especialidad;
        String comentarios;

        public Libro(String titulo, String autor, int ventas, int calificacion, String especialidad,
                String comentarios) {
            this.titulo = titulo;
            this.autor = autor;
            this.ventas = ventas;
            this.calificacion = calificacion;
            this.especialidad = especialidad;
            this.comentarios = comentarios;
        }
    }

    private Map<String, Libro> libros;

    public Libreria() {
        libros = new HashMap<>();
    }

    public void agregarLibro(String titulo, String autor, int ventas, int calificacion, String especialidad,
            String comentarios) {
        Libro libro = new Libro(titulo, autor, ventas, calificacion, especialidad, comentarios);
        libros.put(titulo, libro);
    }

    public void modificarLibro(String titulo, String autor, int ventas, int calificacion, String especialidad,
            String comentarios) {
        if (libros.containsKey(titulo)) {
            Libro libro = libros.get(titulo);
            libro.autor = autor;
            libro.ventas = ventas;
            libro.calificacion = calificacion;
            libro.comentarios = comentarios;
        } else {
            agregarLibro(titulo, autor, ventas, calificacion, especialidad, comentarios);
        }
    }

    public String compraSegura(String autor) {
        List<Libro> librosAutor = new ArrayList<>();

        for (Libro libro : libros.values()) {
            if (libro.autor.equals(autor)) {
                librosAutor.add(libro);
            }
        }

        if (librosAutor.isEmpty()) {
            return "No se encontraron libros del autor " + autor;
        }

        Libro mejorCritica = librosAutor.get(0);

        for (Libro libro : librosAutor) {
            if (libro.calificacion > mejorCritica.calificacion) {
                mejorCritica = libro;
            }
        }

        return mejorCritica.titulo;
    }

    public List<String> listado(String especialidad) {
        List<Libro> librosEspecialidad = new ArrayList<>();

        for (Libro libro : libros.values()) {
            if (libro.especialidad.equals(especialidad)) {
                librosEspecialidad.add(libro);
            }
        }

        Collections.sort(librosEspecialidad, (l1, l2) -> Integer.compare(l2.ventas, l1.ventas));

        List<String> listaTitulos = new ArrayList<>();

        for (Libro libro : librosEspecialidad) {
            listaTitulos.add(libro.titulo);
        }

        return listaTitulos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Libreria libreria = new Libreria();

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("=== Menú de opciones ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Compra segura por autor");
            System.out.println("4. Listado por especialidad");
            System.out.println("5. Salir");
            System.out.print("Ingrese el número de opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese las ventas del libro: ");
                    int ventas = scanner.nextInt();
                    System.out.print("Ingrese la calificación de la crítica del libro: ");
                    int calificacion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese la especialidad del libro: ");
                    String especialidad = scanner.nextLine();
                    System.out.print("Ingrese los comentarios del libro: ");
                    String comentarios = scanner.nextLine();
                    libreria.agregarLibro(titulo, autor, ventas, calificacion, especialidad, comentarios);
                    System.out.println("Libro agregado correctamente.");
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el título del libro a modificar: ");
                    String tituloModificar = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autorModificar = scanner.nextLine();
                    System.out.print("Ingrese las ventas del libro: ");
                    int ventasModificar = scanner.nextInt();
                    System.out.print("Ingrese la calificación de la crítica del libro: ");
                    int calificacionModificar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese los comentarios del libro: ");
                    String comentariosModificar = scanner.nextLine();
                    libreria.modificarLibro(tituloModificar, autorModificar, ventasModificar, calificacionModificar, "",
                            comentariosModificar);
                    System.out.println("Libro modificado correctamente.");
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Ingrese el autor para la compra segura: ");
                    String autorCompraSegura = scanner.nextLine();
                    String libroCompraSegura = libreria.compraSegura(autorCompraSegura);
                    System.out.println(
                            "La compra segura para el autor " + autorCompraSegura + " es: " + libroCompraSegura);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Ingrese la especialidad para el listado: ");
                    String especialidadListado = scanner.nextLine();
                    List<String> listadoEspecialidad = libreria.listado(especialidadListado);
                    System.out.println("Listado de libros de la especialidad " + especialidadListado + ":");
                    for (String tituloLibro : listadoEspecialidad) {
                        System.out.println(tituloLibro);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
