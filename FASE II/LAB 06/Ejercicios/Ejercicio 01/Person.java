public class Person implements Comparable<Person> {
    private String nombre;
    private String apellidos;
    private int edad;

    public Person(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true; // son el mismo objeto
        }
        if (!(obj instanceof Person)) {
            return false; // no son objetos de la misma clase
        }
        Person p = (Person) obj; // se hace un cast a la clase Person
        return this.nombre.equals(p.nombre) &&
                this.apellidos.equals(p.apellidos) &&
                this.edad == p.edad; // se comparan los atributos de los objetos
    }
    @Override
    public int compareTo(Person other) {
        return nombre.compareTo(other.nombre);
    }

    public String toString() {
        return nombre + " " + apellidos + " (" + edad + ")";
    }
}
