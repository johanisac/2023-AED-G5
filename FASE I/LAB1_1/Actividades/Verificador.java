public class Verificador {

    public static boolean esSobrepos(Rectangulo r1, Rectangulo r2) {
        Rectangulo rect1 = ordenarCoordenadas(r1);
        Rectangulo rect2 = ordenarCoordenadas(r2);

        if (rect1.getEsquina2().getX() < rect2.getEsquina1().getX()
                || rect1.getEsquina2().getY() < rect2.getEsquina1().getY()
                || rect1.getEsquina1().getX() > rect2.getEsquina2().getX()
                || rect1.getEsquina1().getY() > rect2.getEsquina2().getY()) {
            //System.out.println("Rectangulos A y B NO se sobreponen");
            return false;
        } else {
            double base = Math.min(rect1.getEsquina2().getX(), rect2.getEsquina2().getX())
                    - Math.max(rect1.getEsquina1().getX(), rect2.getEsquina1().getX());
            double altura = Math.min(rect1.getEsquina2().getY(), rect2.getEsquina2().getY())
                    - Math.max(rect1.getEsquina1().getY(), rect2.getEsquina1().getY());
            if (positivo(base * altura) == 0) {
                return false;
            }
            System.out.println("Rectangulos A y B se sobreponen");
            System.out.println("Area de sobreposicion = " + positivo(base * altura));
            return true;
        }
    }

    private static Rectangulo ordenarCoordenadas(Rectangulo r) {
        double e11, e12, e13, e14, cambio;

        e11 = r.getEsquina1().getX();
        e12 = r.getEsquina1().getY();
        e13 = r.getEsquina2().getX();
        e14 = r.getEsquina2().getY();

        if (e13 < e11) {
            cambio = e13;
            e13 = e11;
            e11 = cambio;
        }

        if (e14 < e12) {
            cambio = e14;
            e14 = e12;
            e12 = cambio;
        }

        return new Rectangulo(new Coordenada(e11, e12), new Coordenada(e13, e14));
    }

    public static double positivo(double num) {
        return num >= 0 ? num : -num;
    }

    public static boolean seJuntan(Rectangulo r1, Rectangulo r2) {
        double e11, e12, e13, e14, e21, e22, e23, e24, cambio;

        e11 = r1.getEsquina1().getX();
        e12 = r1.getEsquina1().getY();
        e13 = r1.getEsquina2().getX();
        e14 = r1.getEsquina2().getY();

        e21 = r2.getEsquina1().getX();
        e22 = r2.getEsquina1().getY();
        e23 = r2.getEsquina2().getX();
        e24 = r2.getEsquina2().getY();

        if (e13 < e11 && e14 < e12) {
            cambio = e13;
            e13 = e11;
            e11 = cambio;
            cambio = e14;
            e14 = e12;
            e12 = cambio;
        } else if (e13 < e11) {
            cambio = e13;
            e13 = e11;
            e11 = cambio;
        } else if (e14 < e12) {
            cambio = e14;
            e14 = e12;
            e12 = cambio;
        }

        if (e23 < e21 && e24 < e22) {
            cambio = e23;
            e23 = e21;
            e21 = cambio;
            cambio = e24;
            e24 = e22;
            e22 = cambio;
        } else if (e23 < e21) {
            cambio = e23;
            e23 = e21;
            e21 = cambio;
        } else if (e24 < e22) {
            cambio = e24;
            e24 = e22;
            e22 = cambio;
        }

        if (e11 <= e23 && e13 >= e21 && e14 >= e22 && e12 <= e24) {
            // coordenadas se sobreponen
            return false;
        } else if (e13 == e21 && (e14 >= e22 && e12 <= e24 || e24 >= e14 && e22 <= e12)) {
            // coordenadas se juntan
            return true;
        } else if (e11 == e23 && (e14 >= e22 && e12 <= e24 || e24 >= e14 && e22 <= e12)) {
            // coordenadas se juntan
            return true;
        } else if (e12 == e24 && (e13 >= e21 && e11 <= e23 || e23 >= e13 && e21 <= e11)) {
            // coordenadas se juntan
            return true;
        } else if (e14 == e22 && (e13 >= e21 && e11 <= e23 || e23 >= e13 && e21 <= e11)) {
            // coordenadas se juntan
            System.out.println("Rectangulos A y B se juntan 01 ");
            return true;
        } else {
            // coordenadas disjuntas
            return false;
        }
    }

    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        double e11, e12, e13, e14, e21, e22, e23, e24;

        e11 = r1.getEsquina1().getX();
        e12 = r1.getEsquina1().getY();
        e13 = r1.getEsquina2().getX();
        e14 = r1.getEsquina2().getY();

        e21 = r2.getEsquina1().getX();
        e22 = r2.getEsquina1().getY();
        e23 = r2.getEsquina2().getX();
        e24 = r2.getEsquina2().getY();

        if (e13 < e11 && e14 < e12) {
            double cambio = e13;
            e13 = e11;
            e11 = cambio;
            cambio = e14;
            e14 = e12;
            e12 = cambio;
        } else if (e13 < e11) {
            double cambio = e13;
            e13 = e11;
            e11 = cambio;
        } else if (e14 < e12) {
            double cambio = e14;
            e14 = e12;
            e12 = cambio;
        }

        if (e23 < e21 && e24 < e22) {
            double cambio = e23;
            e23 = e21;
            e21 = cambio;
            cambio = e24;
            e24 = e22;
            e22 = cambio;
        } else if (e23 < e21) {
            double cambio = e23;
            e23 = e21;
            e21 = cambio;
        } else if (e24 < e22) {
            double cambio = e24;
            e24 = e22;
            e22 = cambio;
        }

        if (e11 > e23 || e13 < e21 || e14 < e22 || e12 > e24) {
            System.out.println("Rectangulos A y B NO se juntan");
            return true;
        } else {
            System.out.println("Rectangulos A y B se juntan");
            return false;
        }
    }

}