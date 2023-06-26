import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashingEmpleados {
    private static final double porcentaje = 0.4;

    public static void main(String[] args) {
        int numEmpleados = obtenerNumeroEmpleados();
        int m = calcularTamañoTabla(numEmpleados);
        HashC<Empleado> tablaHash = new HashC<>(m);
        leerArchivoEmpleados(tablaHash, numEmpleados);
        System.out.println("Tabla Hash:");
        System.out.println(tablaHash.toString());
    }

    private static int obtenerNumeroEmpleados() {
        int numEmpleados = 0;
        try (BufferedReader br = new BufferedReader(
                new FileReader("C:/Users/JOHAN/Documents/JAVA_HOME/EMPLEADO.TXT"))) {
            String line = br.readLine();
            numEmpleados = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo EMPLEADO.TXT: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("El archivo EMPLEADO.TXT no contiene el número de empleados válido.");
        }
        return numEmpleados;
    }

    private static int calcularTamañoTabla(int numEmpleados) {
        int m = (int) (numEmpleados / porcentaje);
    m = siguientePrimo(m);
        return m;
    }

    private static void leerArchivoEmpleados(HashC<Empleado> tablaHash, int numEmpleados) {
        try (BufferedReader br = new BufferedReader(new FileReader("EMPLEADO.TXT"))) {
            // Saltar la primera línea que contiene el número de empleados
            br.readLine();

            for (int i = 0; i < numEmpleados; i++) {
                String line = br.readLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    int codigo = Integer.parseInt(data[0]);
                    String nombre = data[1];
                    String direccion = data[2];
                    Empleado empleado = new Empleado(codigo, nombre, direccion);
                    tablaHash.insert(empleado.getCodigo(), empleado);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo EMPLEADO.TXT: " + e.getMessage());
        }
    }

    private static int siguientePrimo(int n) {
        if (n <= 1) {
            return 2;
        }

        int primo = n;
        boolean encontrado = false;

        while (!encontrado) {
            primo++;
            if (esPrimo(primo)) {
                encontrado = true;
            }
        }

        return primo;
    }

    private static boolean esPrimo(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static class Empleado implements Comparable<Empleado> {
        private int codigo;
        private String nombre;
        private String direccion;

        public Empleado(int codigo, String nombre, String direccion) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        @Override
        public int compareTo(Empleado otro) {
            return Integer.compare(this.codigo, otro.codigo);
        }

        @Override
        public String toString() {
            return "Empleado{" +
                    "codigo=" + codigo +
                    ", nombre='" + nombre + '\'' +
                    ", direccion='" + direccion + '\'' +
                    '}';
        }
    }
}
