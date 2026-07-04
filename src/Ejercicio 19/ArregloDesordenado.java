import java.util.HashSet;
import java.util.Set;

public class ArregloDesordenado {

    private final int[] arreglo;

    public ArregloDesordenado(int[] arreglo) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        this.arreglo = arreglo;
    }

    public int longitudMaximaConsecutiva() {
        if (arreglo.length == 0) {
            return 0;
        }

        Set<Integer> valores = new HashSet<>();
        for (int valor : arreglo) {
            valores.add(valor);
        }

        int maxLongitud = 0;

        for (int valor : valores) {

            if (!valores.contains(valor - 1)) {
                int actual = valor;
                int longitudActual = 1;

                while (valores.contains(actual + 1)) {
                    actual++;
                    longitudActual++;
                }

                maxLongitud = Math.max(maxLongitud, longitudActual);
            }
        }

        return maxLongitud;
    }

    public void mostrarArreglo() {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < arreglo.length; i++) {
            sb.append(arreglo[i]);
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        System.out.println(sb);
    }
}
