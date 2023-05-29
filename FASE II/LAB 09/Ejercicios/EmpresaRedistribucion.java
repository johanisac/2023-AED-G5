import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmpresaRedistribucion {
    private AVLTree<Integer> comercialTree;
    private AVLTree<Integer> produccionTree;
    private AVLTree<Integer> comunicacionesTree;

    public EmpresaRedistribucion() {
        comercialTree = new AVLTree<>();
        produccionTree = new AVLTree<>();
        comunicacionesTree = new AVLTree<>();
    }

    public void redistribuirRegistros(String archivo) throws ItemNotFound {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine(); // Ignorar la primera línea (encabezado)
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 3) {
                    int numeroIdt = Integer.parseInt(campos[0].trim());
                    int origen = Integer.parseInt(campos[1].trim());
                    int destino = Integer.parseInt(campos[2].trim());

                    switch (origen) {
                        case 1:
                            if (comercialTree.contains(numeroIdt)) {
                                comercialTree.remove(numeroIdt);
                            }
                            break;
                        case 2:
                            if (produccionTree.contains(numeroIdt)) {
                                produccionTree.remove(numeroIdt);
                            }
                            break;
                        case 3:
                            if (comunicacionesTree.contains(numeroIdt)) {
                                comunicacionesTree.remove(numeroIdt);
                            }
                            break;
                        default:
                            System.out.println("Departamento de origen inválido: " + origen);
                            break;
                    }
                    switch (destino) {
                        case 1: // comercial
                            comercialTree.insert(numeroIdt);
                            break;
                        case 2: // produccion
                            produccionTree.insert(numeroIdt);
                            break;
                        case 3: // comunicacion
                            comunicacionesTree.insert(numeroIdt);
                            break;
                        default:
                            System.out.println("Departamento de destino inválido: " + destino);
                            break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumEmpleadosComercial() {
        return comercialTree.countNodes();
    }

    public int getNumEmpleadosProduccion() {
        return produccionTree.countNodes();
    }

    public int getNumEmpleadosComunicaciones() {
        return comunicacionesTree.countNodes();
    }

    public void imprimirArboles() {
        System.out.println("Departamento Comercial:");
        System.out.println(comercialTree.toString());

        System.out.println("Departamento Producción:");
        System.out.println(produccionTree.toString());

        System.out.println("Departamento Comunicaciones:");
        System.out.println(comunicacionesTree.toString());
    }

}
