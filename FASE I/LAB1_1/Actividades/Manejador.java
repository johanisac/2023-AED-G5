

public class Manejador {

    public static double area(Rectangulo R) {
        double area, altura, base;
        Coordenada nuevoX, nuevoY;
        nuevoX = R.getEsquina1();
        nuevoY = R.getEsquina2();
        Coordenada inferior = new Coordenada(nuevoX.getX(), nuevoY.getY());
        altura = Coordenada.distancia(inferior, R.getEsquina1());
        base = Coordenada.distancia(inferior, R.getEsquina2());
        area = altura * base;
        return area;
    }

    public static double perimetro(Rectangulo R) {
        double Perimetro, altura, base;
        Coordenada nuevoX, nuevoY;
        nuevoX = R.getEsquina1();
        nuevoY = R.getEsquina2();
        Coordenada inferior = new Coordenada(nuevoX.getX(), nuevoY.getY());
        altura = Coordenada.distancia(inferior, R.getEsquina1());
        base = Coordenada.distancia(inferior, R.getEsquina2());
        Perimetro = (altura * 2) + (base * 2);
        return Perimetro;
    }

    public static void moverX(int num, Rectangulo R) {
        Coordenada nuevoX, nuevoY;
        nuevoX = R.getEsquina1();
        nuevoY = R.getEsquina2();
        nuevoX.setx(num + nuevoX.getX());
        nuevoY.setx(num + nuevoY.getX());
        System.out.println(R.getEsquina1());
        System.out.println(R.getEsquina2());
    }

    public static void moverY(int num, Rectangulo R) {
        Coordenada nuevoX, nuevoY;
        nuevoX = R.getEsquina1();
        nuevoY = R.getEsquina2();
        nuevoX.setY(num + nuevoX.getY());
        nuevoY.setY(num + nuevoY.getY());
        System.out.println(R.getEsquina1());
        System.out.println(R.getEsquina2());
    }

}
