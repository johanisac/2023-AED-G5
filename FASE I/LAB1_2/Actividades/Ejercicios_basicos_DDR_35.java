import java.util.Scanner;

public class Ejercicios_basicos_DDR_35 {
    public enum DiasSemana {
        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES,
        SABADO,
        DOMINGO;
    }

    public static void main(String[] agrs) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribre un dia de la semana");
        String dia = sn.next();

        DiasSemana diaS = DiasSemana.valueOf(dia.toUpperCase());

        switch (diaS) {
            case LUNES:
            case MARTES:
            case MIERCOLES:
            case JUEVES:
            case VIERNES:
                System.out.println("El dia " + diaS.name().toLowerCase() + " es laborable");
                break;
            case SABADO:
            case DOMINGO:
                System.out.println("El dia " + diaS + " no es laborable");
                break;
        }
        sn.close();
    }
}