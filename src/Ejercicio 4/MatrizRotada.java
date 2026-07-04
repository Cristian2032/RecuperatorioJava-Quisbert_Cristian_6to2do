
public class MatrizRotada {

    private final int[][] matriz;
    private final int n;
    private final int k;

    public MatrizRotada(int[][] matriz, int k) {
        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("La matriz no puede ser nula ni vacía.");
        }
        for (int[] fila : matriz) {
            if (fila == null || fila.length != matriz.length) {
                throw new IllegalArgumentException("La matriz debe ser NxN (cuadrada).");
            }
        }
        this.matriz = matriz;
        this.n = matriz.length;

        int total = n * n;

        this.k = ((k % total) + total) % total;
    }


    public int[] buscarPosicion(int target) {
        int total = n * n;
        int izquierda = 0;
        int derecha = total - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            int posRotada = posicionOrdenadaARotada(medio);
            int fila = posRotada / n;
            int columna = posRotada % n;
            int valor = matriz[fila][columna];

            if (valor == target) {
                return new int[]{fila, columna};
            } else if (valor < target) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return new int[]{-1, -1};
    }


    private int posicionOrdenadaARotada(int posOrdenada) {
        int total = n * n;
        return ((posOrdenada - k) % total + total) % total;
    }


    public void mostrarMatriz() {
        for (int[] fila : matriz) {
            StringBuilder sb = new StringBuilder("{ ");
            for (int j = 0; j < fila.length; j++) {
                sb.append(fila[j]);
                if (j < fila.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            System.out.println(sb);
        }
    }
}
