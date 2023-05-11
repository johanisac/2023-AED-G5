import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Fabrica f = new Fabrica();
        cargarFabrica(f);

        // PRUEBA PUNTO A)
        System.out.println("\n********************************* PRIMERA PARTE *******************************\n");
        f.listarInstrumentos();
        System.out.println("\n******************************* FIN PRIMERA PARTE *******************************\n");

        // PRUEBA PUNTO B)
        System.out.println("\n********************************* SEGUNDA PARTE *******************************\n");
        ArrayList<Instrumento> lista = f.instrumentosPorTipo(TipoInstrumento.PERCUSION);
        for (Instrumento instrumento : lista) {
            System.out.println(instrumento);
        }
        System.out.println("\n******************************* FIN SEGUNDA PARTE *******************************\n");

        // PRUEBA PUNTO C)
        System.out.println("\n********************************* TERCERA PARTE *******************************\n");
        Instrumento borrado = f.borrarInstrumento("ZZZ111");
        System.out.println("Se borró: " + borrado);
        f.listarInstrumentos();
        System.out.println("\n******************************* FIN TERCERA PARTE *******************************\n");

        // PRUEBA PUNTO D)
        System.out.println("\n********************************* CUARTA PARTE *******************************\n");
        double[] porcs = f.porcInstrumentosPorTipo("Sucursal B");
        for (int i = 0; i < porcs.length; i++) {
            System.out.println(porcs[i]);
        }
        System.out.println("\n******************************* FIN CUARTA PARTE *******************************\n");
    }

    private static void cargarFabrica(Fabrica f) {
        Sucursal s1 = new Sucursal("Sucursal A");
        Sucursal s2 = new Sucursal("Sucursal B");

        s1.agregarInstrumento(new Instrumento("ABC123", 13214, TipoInstrumento.CUERDA));
        s1.agregarInstrumento(new Instrumento("BCD456", 13432, TipoInstrumento.VIENTO));
        s1.agregarInstrumento(new Instrumento("DEF567", 15464, TipoInstrumento.PERCUSION));

        s2.agregarInstrumento(new Instrumento("ASD353", 52432, TipoInstrumento.CUERDA));
        s2.agregarInstrumento(new Instrumento("VXCBE2", 45645, TipoInstrumento.VIENTO));

        f.agregarSucursal(s1);
        f.agregarSucursal(s2);
    }

}