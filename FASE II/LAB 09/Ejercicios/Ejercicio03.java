public class Ejercicio03 {
    public static void main(String[] args) throws ItemNotFound {
        EmpresaRedistribucion empresa = new EmpresaRedistribucion();
        empresa.redistribuirRegistros("C:/Users/JOHAN/Documents/JAVA_HOME/2023-ED/FASE II/LAB 09/Ejercicios/EMPRESA.txt");
        empresa.imprimirArboles();
        System.out.println("Número de empleados en el departamento Comercial: " + empresa.getNumEmpleadosComercial());
        System.out.println("Número de empleados en el departamento Producción: " + empresa.getNumEmpleadosProduccion());
        System.out.println("Número de empleados en el departamento Comunicaciones: " + empresa.getNumEmpleadosComunicaciones());
    }
}
