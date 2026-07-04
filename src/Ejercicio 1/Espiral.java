
public class Espiral {

    private static final int VALOR_INICIAL = 9;

    private final int[][] matriz;
    private final int tamanio;


    private enum Direccion {
        IZQUIERDA(0, -1),
        ABAJO(1, 0),
        DERECHA(0, 1),
        ARRIBA(-1, 0);

        private final int deltaFila;
        private final int deltaColumna;

        Direccion(int deltaFila, int deltaColumna) {
            this.deltaFila = deltaFila;
            this.deltaColumna = deltaColumna;
        }
    }

    private static final Direccion[] ORDEN_GIRO = {
            Direccion.IZQUIERDA, Direccion.ABAJO, Direccion.DERECHA, Direccion.ARRIBA
    };

    public Espiral(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("La matriz no puede ser nula ni vacía.");
        }
        for (int[] fila : matriz) {
            if (fila.length != matriz.length) {
                throw new IllegalArgumentException("La matriz debe ser cuadrada (N x N).");
            }
        }
        if (matriz.length % 2 == 0) {
            throw new IllegalArgumentException(
                    "La matriz debe tener lado impar para tener un único centro.");
        }
        this.matriz = matriz;
        this.tamanio = matriz.length;
    }


    public boolean esEspiralDescendenteDesdeCentro() {
        int fila = tamanio / 2;
        int columna = tamanio / 2;
        int valorEsperado = VALOR_INICIAL;
        int totalCeldas = tamanio * tamanio;
        int celdasVisitadas = 0;

        // Se revisa primero el centro
        if (matriz[fila][columna] != valorEsperado) {
            return false;
        }
        celdasVisitadas++;
        valorEsperado--;

        int pasos = 1;          // longitud del próximo tramo recto
        int indiceDireccion = 0; // apunta a ORDEN_GIRO

        while (celdasVisitadas < totalCeldas) {
            // cada longitud de "pasos" se usa dos veces antes de crecer,
            // igual que en una espiral cuadrada clásica (1,1,2,2,3,3,...)
            for (int vez = 0; vez < 2 && celdasVisitadas < totalCeldas; vez++) {
                Direccion direccion = ORDEN_GIRO[indiceDireccion];

                for (int paso = 0; paso < pasos && celdasVisitadas < totalCeldas; paso++) {
                    fila += direccion.deltaFila;
                    columna += direccion.deltaColumna;

                    if (!dentroDeRango(fila, columna) || matriz[fila][columna] != valorEsperado) {
                        return false;
                    }

                    celdasVisitadas++;
                    valorEsperado--;
                }
                indiceDireccion = (indiceDireccion + 1) % ORDEN_GIRO.length;
            }
            pasos++;
        }

        return true;
    }

    private boolean dentroDeRango(int fila, int columna) {
        return fila >= 0 && fila < tamanio && columna >= 0 && columna < tamanio;
    }

    public void mostrarMatriz() {
        for (int[] fila : matriz) {
            StringBuilder sb = new StringBuilder();
            for (int valor : fila) {
                sb.append(String.format("%4d", valor));
            }
            System.out.println(sb);
        }
    }
}
