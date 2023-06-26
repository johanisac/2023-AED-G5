public class Libro<T> {
    private String titulo;
    private String autor;
    private int ventas;
    private int calificacionCritica;
    private String especialidad;
    private T comentarios;

    public Libro(String titulo, String autor, int ventas, int calificacionCritica, String especialidad, T comentarios) {
        this.titulo = titulo;
        this.autor = autor;
        this.ventas = ventas;
        this.calificacionCritica = calificacionCritica;
        this.especialidad = especialidad;
        this.comentarios = comentarios;
    }

    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return String return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return int return the ventas
     */
    public int getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    /**
     * @return int return the calificacionCritica
     */
    public int getCalificacionCritica() {
        return calificacionCritica;
    }

    /**
     * @param calificacionCritica the calificacionCritica to set
     */
    public void setCalificacionCritica(int calificacionCritica) {
        this.calificacionCritica = calificacionCritica;
    }

    /**
     * @return String return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return T return the comentarios
     */
    public T getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(T comentarios) {
        this.comentarios = comentarios;
    }

}
