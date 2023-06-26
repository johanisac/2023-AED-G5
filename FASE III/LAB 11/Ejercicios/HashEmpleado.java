import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashEmpleado {
    private class Empleado {
        int codigo;
        String nombre;
        String direccion;

        public Empleado(int codigo, String nombre, String direccion) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.direccion = direccion;
        }
    }

    private ArrayList<LinkedList<Empleado>> tablaHash;

    public HashEmpleado(String archivo) {
        tablaHash = new ArrayList<>();
        cargarArchivo(archivo);
        dispersarEmpleados();
    }

    private void cargarArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int cantidadEmpleados = Integer.parseInt(br.readLine());

            tablaHash.ensureCapacity(cantidadEmpleados);

            for (int i = 0; i < cantidadEmpleados; i++) {
                linea = br.readLine();
                String[] campos = linea.split(",");
                int codigo = Integer.parseInt(campos[0]);
                String nombre = campos[1];
                String direccion = campos[2];

                Empleado empleado = new Empleado(codigo, nombre, direccion);

                tablaHash.add(new LinkedList<>());
                tablaHash.get(i).add(empleado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int funcionHash(int codigo, int tamañoTabla) {
        return codigo % tamañoTabla;
    }

    private void dispersarEmpleados() {
        for (LinkedList<Empleado> listaEmpleados : tablaHash) {
            if (listaEmpleados.size() > 1) {
                int tamañoTabla = listaEmpleados.size();
                LinkedList<Empleado> nuevaLista = new LinkedList<>();

                for (Empleado empleado : listaEmpleados) {
                    int indice = funcionHash(empleado.codigo, tamañoTabla);
                    nuevaLista.add(indice, empleado);
                }

                listaEmpleados.clear();
                listaEmpleados.addAll(nuevaLista);
            }
        }
    }

    public void mostrarTablaHash() {
        for (int i = 0; i < tablaHash.size(); i++) {
            LinkedList<Empleado> listaEmpleados = tablaHash.get(i);
            System.out.println("Dirección Hash: " + i);
            System.out.println("Cantidad de elementos: " + listaEmpleados.size());

            for (Empleado empleado : listaEmpleados) {
                System.out.println("Código: " + empleado.codigo + ", Nombre: " + empleado.nombre + ", Dirección: "
                        + empleado.direccion);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashEmpleado hashEmpleado = new HashEmpleado("EMPLEADO.TXT");
        hashEmpleado.mostrarTablaHash();
    }
}
