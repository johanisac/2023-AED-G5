public class Book {
    private String title;
    private String author;
    private int sales;
    private int rating;
    private String specialty;
    private String comments;

    public Book(String title, String author, int sales, int rating, String specialty, String comments) {
        this.title = title;
        this.author = author;
        this.sales = sales;
        this.rating = rating;
        this.specialty = specialty;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public static void main(String[] args) {
        // Crear objetos Book
        Book book1 = new Book("La sombra del viento", "Carlos Ruiz Zafón", 1000, 4, "Ficción", "Excelente libro");
        Book book2 = new Book("Cien años de soledad", "Gabriel García Márquez", 1500, 5, "Realismo mágico",
                "Obra maestra");

        // Obtener los valores de los campos utilizando los getters
        System.out.println("Título: " + book1.getTitle());
        System.out.println("Autor: " + book1.getAuthor());
        System.out.println("Ventas: " + book1.getSales());
        System.out.println("Calificación: " + book1.getRating());
        System.out.println("Especialidad: " + book1.getSpecialty());
        System.out.println("Comentarios: " + book1.getComments());

        // Modificar los valores de los campos utilizando los setters
        book2.setTitle("Cien años de soledad (Edición especial)");
        book2.setSales(2000);
        book2.setRating(4);

        // Imprimir los nuevos valores de los campos
        System.out.println("Título: " + book2.getTitle());
        System.out.println("Ventas: " + book2.getSales());
        System.out.println("Calificación: " + book2.getRating());

    }

    public String getAutor() {
        return null;
    }

    public String getTitulo() {
        return null;
    }

}
