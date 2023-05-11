public class Verificador {

    public static boolean esSobrepos(Rectangulo R1, Rectangulo R2) {
        double E11, E12, E13, E14, E21, E22, E23, E24, Cambio;

        E11 = R1.getEsquina1().getX();
        E12 = R1.getEsquina1().getY();
        E13 = R1.getEsquina2().getX();
        E14 = R1.getEsquina2().getY();

        E21 = R2.getEsquina1().getX();
        E22 = R2.getEsquina1().getY();
        E23 = R2.getEsquina2().getX();
        E24 = R2.getEsquina2().getY();

        System.out.println("A " + E11 + " " + E12 + " " + E13 + " " + E14);
        System.out.println("A " + E21 + " " + E22 + " " + E23 + " " + E24);

        if (E13 < E11 && E14 < E12) {
            Cambio = E13;
            E13 = E11;
            E11 = Cambio;
            Cambio = E14;
            E14 = E12;
            E12 = Cambio;
        } else if (E13 < E11) {
            Cambio = E13;
            E13 = E11;
            E11 = Cambio;
        } else if (E14 < E12) {
            Cambio = E14;
            E14 = E12;
            E12 = Cambio;
        }
        if (E23 < E21 && E24 < E22) {
            Cambio = E23;
            E23 = E21;
            E21 = Cambio;
            Cambio = E24;
            E24 = E22;
            E22 = Cambio;
        } else if (E23 < E21) {
            Cambio = E23;
            E23 = E21;
            E21 = Cambio;
        } else if (E24 < E22) {
            Cambio = E24;
            E24 = E22;
            E22 = Cambio;
        }
        if (E11 > E21) {
            Cambio = E11;
            E11 = E21;
            E21 = Cambio;
            Cambio = E12;
            E12 = E22;
            E22 = Cambio;
            Cambio = E13;
            E13 = E23;
            E23 = Cambio;
            Cambio = E14;
            E14 = E24;
            E24 = Cambio;
        }
        if (E11 == E21 && E12 == E22 && E13 == E23 && E14 == E24) {
            System.out.println("Rectangulos A y B se sobreponen 0");
            System.out.println("Area: " + positivo(((E24 - E22) * (E13 - E11))));
            return true;
        } else if (E11 < E21 && E23 > E13 && E21 < E13 && E14 > E12 && E14 < E24 && E22 < E12) {
            System.out.println("Rectangulos A y B se sobreponen 1");
            System.out.println("Area: " + positivo(((E13 - E21) * (E14 - E12))));
            return true;
        } else if (E21 > E11 && E13 < E23 && E13 > E21 && E14 > E22 && E24 > E14 && E22 > E12) {
            System.out.println("Rectangulos A y B se sobreponen 2");
            System.out.println("Area: " + positivo(((E14 - E22) * (E13 - E21))));
            return true;
        } else if (E21 > E11 && E13 < E23 && E13 > E21 && E14 > E22 && E24 < E14 && E22 < E12) {
            System.out.println("Rectangulos A y B se sobreponen 3");
            System.out.println("Area: " + positivo(((E24 - E12) * (E13 - E21))));
            return true;
        } else if (E21 > E11 && E13 > E23 && E13 > E21 && E14 > E22 && E24 > E14 && E22 < E12) {
            System.out.println("Rectangulos A y B se sobreponen 4");
            System.out.println("Area: " + positivo(((E14 - E12) * (E23 - E21))));
            return true;
        } else if (E21 > E11 && E13 > E23 && E13 > E21 && E14 > E22 && E24 > E14 && E22 > E12) {
            System.out.println("Rectangulos A y B se sobreponen 5");
            System.out.println("Area: " + positivo(((E14 - E22) * (E23 - E21))));
            return true;
        } else if (E21 > E11 && E13 < E23 && E13 > E21 && E14 > E22 && E24 < E14 && E22 > E12) {
            System.out.println("Rectangulos A y B se sobreponen 7");
            System.out.println("Area: " + positivo(((E21 - E13) * (E24 - E22))));
            return true;
        } else if (E21 == E11 && E13 > E23 && E13 > E21 && E14 > E22 && E24 < E14 && E22 > E12) {
            System.out.println("Rectangulos A y B se sobreponen 8");
            System.out.println("Area: " + positivo(((E23 - E11) * (E24 - E22))));
            return true;
        } else if (E21 == E11 && E23 > E13 && E23 > E11 && E24 > E12 && E14 < E24 && E12 > E22) {
            System.out.println("Rectangulos A y B se sobreponen 9");
            System.out.println("Area: " + positivo(((E13 - E21) * (E14 - E12))));
            return true;
        } else if (E21 > E11 && E13 == E23 && E13 > E21 && E14 > E22 && E24 < E14 && E22 > E12) {
            System.out.println("Rectangulos A y B se sobreponen 10");
            System.out.println("Area: " + positivo(((E23 - E21) * (E24 - E22))));
            return true;
        } else if (E21 > E11 && E13 > E23 && E13 > E21 && E14 > E22 && E24 == E14 && E22 > E12) {
            System.out.println("Rectangulos A y B se sobreponen 11");
            System.out.println("Area: " + positivo(((E24 - E22) * (E23 - E21))));
            return true;
        }
        return false;
    }

    public static boolean esJunto(Rectangulo R1, Rectangulo R2) {
        double E11, E12, E13, E14, E21, E22, E23, E24;
        E11 = R1.getEsquina1().getX();
        E12 = R1.getEsquina1().getY();
        E13 = R1.getEsquina2().getX();
        E14 = R1.getEsquina2().getY();

        E21 = R2.getEsquina1().getX();
        E22 = R2.getEsquina1().getY();
        E23 = R2.getEsquina2().getX();
        E24 = R2.getEsquina2().getY();

        System.out.println(E11 + " " + E12);
        System.out.println(E11 + " " + E14);
        System.out.println(E13 + " " + E12);
        System.out.println(E13 + " " + E14);

        System.out.println(E21 + " " + E22);
        System.out.println(E21 + " " + E24);
        System.out.println(E23 + " " + E22);
        System.out.println(E23 + " " + E24);
        return false;
    }

    public static boolean esDisjunto(Rectangulo R1, Rectangulo R2) {

        return true;
    }

    public static double positivo(double num) {
        if (num > 0) {
            return num;
        } else {
            return num * -1;
        }

    }
}