class ContainerRect {
    // atributos de instancia
    private Rectangulo[] rectangulos; // arreglo de rectangulos
    private double[] distancias; // arreglo de distancias euclideanas
    private double[] areas; // arreglo de areas
    private int n; // capacidad maxima del contenedor

    // atributo de clase
    private static int numRec = 0; // contador de rectangulos agregados

    // constructor
    public ContainerRect(int n) {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    // metodo para agregar un rectangulo al contenedor
    public void addRectangulo(Rectangulo r) {
        if (numRec < n) { // si hay espacio en el contenedor
            rectangulos[numRec] = r; // se guarda el rectangulo en el arreglo
            distancias[numRec] = r.distancia(); // se calcula y guarda la distancia euclideana del rectangulo
            areas[numRec] = r.calculoArea(); // se calcula y guarda el area del rectangulo
            numRec++; // se incrementa el contador de rectangulos agregados
        } else { // si no hay espacio en el contenedor
            System.out.println("++++++++ No es posible guardar el rectángulo. +++++++++++++"); // se muestra un mensaje indicando que no se
                                                                        // puede agregar el rectangulo
        }
    }

    // metodo para mostrar los datos del contenedor
    public String toString() {
        String s = String.format("%-15s %-32s %-12s %-15s \n", "Rectángulo", "Coordenadas", "Distancia", "Area"); // se crea una cadena con los encabezados de la tabla
        for (int i = 0; i < numRec; i++) { // se recorre el arreglo de rectangulos hasta el numero actual de rectagulos
                                           // agregados
            s += String.format("    %-10s %-33s %-12s %-15s \n", (i + 1), rectangulos[i].toString(),  String.format("%.3f", distancias[i]) , String.format("%.2f", areas[i]));
            /*
             * se concatena a la cadena cada fila con los datos del i-esimo rectagulo: su
             * numero, sus coordenadas, su distancia y su area
             */
        }
        return s; // se retorna la cadena formada por la tabla completa
    }
}