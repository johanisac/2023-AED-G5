public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;
    static int nContadores = 0;

    // Constructor
    public Rectangulo(Coordenada C1, Coordenada C2) {
        this.esquina1 = C1;
        this.esquina2 = C2;
    }

    public Rectangulo(int CompX, int CompY) {
        this.esquina1 = new Coordenada(0, CompY);
        this.esquina2 = new Coordenada(CompX, 0);
    }

    // get se encarga de mostrar un valor a una propiedad o atributo de un objeto
    public Coordenada getEsquina1() {
        return esquina1;
    }

    // set permite modificar el valor de un atributo de un objeto
    public void setEsquina1(Coordenada C) {
        this.esquina1 = C;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    public void setEsquina2(Coordenada C) {
        this.esquina2 = C;
    }

    public String toString() {
        return " (" +  this.esquina2 + ", " + this.esquina1 + ")";
    }

}
