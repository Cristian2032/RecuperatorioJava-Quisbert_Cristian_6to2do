
public class BuscadorMatriz {

    private int[][] matriz;

    public BuscadorMatriz(int[][] matriz) {
        validarMatriz(matriz);
        this.matriz = matriz;
    }

    private void validarMatriz(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            throw new IllegalArgumentException("La matriz no puede ser nula ni vacía.");
        }
        int columnas = matriz[0].length;
        for (int[] fila : matriz) {
            if (fila.length != columnas) {
                throw new IllegalArgumentException("Todas las filas deben tener la misma cantidad de columnas.");
            }
        }
    }


    public int[] buscar(int target) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int lo = 0;
        int hi = filas * columnas - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int fila = mid / columnas;
            int col = mid % columnas;
            int valor = matriz[fila][col];

            if (valor == target) {
                return new int[]{fila, col};
            } else if (valor > target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }


    public boolean existe(int target) {
        int[] posicion = buscar(target);
        return posicion[0] != -1;
    }


    public boolean cumpleCondiciones() {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Condición 1: cada fila debe descender estrictamente
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas - 1; c++) {
                if (matriz[f][c] <= matriz[f][c + 1]) {
                    return false;
                }
            }
        }

        for (int f = 1; f < filas; f++) {
            if (matriz[f][0] >= matriz[f - 1][columnas - 1]) {
                return false;
            }
        }

        return true;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
