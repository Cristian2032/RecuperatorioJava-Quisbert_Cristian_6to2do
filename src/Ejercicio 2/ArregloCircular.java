
public class ArregloCircular {

    private final int[] arreglo;
    private final int tamanio;

    public ArregloCircular(int[] arreglo) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        this.arreglo = arreglo;
        this.tamanio = arreglo.length;
    }

    public static class ResultadoSecuencia {
        private final int longitud;
        private final int[] valores;
        private final boolean creciente;

        public ResultadoSecuencia(int longitud, int[] valores, boolean creciente) {
            this.longitud = longitud;
            this.valores = valores;
            this.creciente = creciente;
        }

        public int getLongitud() {
            return longitud;
        }

        public int[] getValores() {
            return valores;
        }

        public boolean esCreciente() {
            return creciente;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(longitud).append(" (");
            for (int i = 0; i < valores.length; i++) {
                sb.append(valores[i]);
                if (i < valores.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            if (longitud > 1) {
                sb.append(creciente ? " [creciente]" : " [decreciente]");
            }
            return sb.toString();
        }
    }


    public ResultadoSecuencia buscarSecuenciaMasLarga() {
        if (tamanio == 0) {
            return new ResultadoSecuencia(0, new int[0], true);
        }
        if (tamanio == 1) {
            return new ResultadoSecuencia(1, new int[]{arreglo[0]}, true);
        }

        int mejorLongitud = 1;
        int mejorInicio = 0;
        int mejorDireccion = 1;

        for (int inicio = 0; inicio < tamanio; inicio++) {
            for (int direccion : new int[]{1, -1}) {
                int longitudActual = contarLongitudDesde(inicio, direccion);
                if (longitudActual > mejorLongitud) {
                    mejorLongitud = longitudActual;
                    mejorInicio = inicio;
                    mejorDireccion = direccion;
                }
            }
        }

        int[] valores = obtenerSecuencia(mejorInicio, mejorLongitud, mejorDireccion);
        return new ResultadoSecuencia(mejorLongitud, valores, mejorDireccion == 1);
    }


    public int longitudMaximaConsecutiva() {
        return buscarSecuenciaMasLarga().getLongitud();
    }

    private int contarLongitudDesde(int inicio, int direccion) {
        int longitud = 1;

        for (int paso = 1; paso < tamanio; paso++) {
            int indiceActual = (inicio + paso) % tamanio;
            int valorEsperado = arreglo[inicio] + paso * direccion;

            if (arreglo[indiceActual] != valorEsperado) {
                break;
            }
            longitud++;
        }

        return longitud;
    }


    private int[] obtenerSecuencia(int inicio, int longitud, int direccion) {
        int[] secuencia = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            int indice = (inicio + i) % tamanio;
            secuencia[i] = arreglo[indice];
        }
        return secuencia;
    }


    public void mostrarArreglo() {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < tamanio; i++) {
            sb.append(arreglo[i]);
            if (i < tamanio - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        System.out.println(sb);
    }
}
