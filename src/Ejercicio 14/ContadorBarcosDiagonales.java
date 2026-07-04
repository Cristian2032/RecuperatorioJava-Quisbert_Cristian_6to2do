
public class ContadorBarcosDiagonales {

    public int contarBarcosDiagonales(boolean[][] tablero) {
        validar(tablero);

        int filas = tablero.length;
        int columnas = tablero[0].length;
        int contador = 0;

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (!tablero[f][c]) {
                    continue;
                }


                boolean esInicioBackslash = (f == 0 || c == 0 || !tablero[f - 1][c - 1]);
                if (esInicioBackslash) {
                    if (longitudDiagonal(tablero, f, c, 1, 1) >= 2) {
                        contador++;
                    }
                }

                boolean esInicioSlash = (f == 0 || c == columnas - 1 || !tablero[f - 1][c + 1]);
                if (esInicioSlash) {
                    if (longitudDiagonal(tablero, f, c, 1, -1) >= 2) {
                        contador++;
                    }
                }
            }
        }

        return contador;
    }


    private int longitudDiagonal(boolean[][] tablero, int filaInicio, int colInicio,
                                  int deltaFila, int deltaCol) {
        int filas = tablero.length;
        int columnas = tablero[0].length;

        int longitud = 0;
        int f = filaInicio;
        int c = colInicio;

        while (f >= 0 && f < filas && c >= 0 && c < columnas && tablero[f][c]) {
            longitud++;
            f += deltaFila;
            c += deltaCol;
        }

        return longitud;
    }

    private void validar(boolean[][] tablero) {
        if (tablero == null || tablero.length == 0 || tablero[0].length == 0) {
            throw new IllegalArgumentException("El tablero no puede ser nulo ni vacio.");
        }
        int columnas = tablero[0].length;
        for (boolean[] fila : tablero) {
            if (fila.length != columnas) {
                throw new IllegalArgumentException("Todas las filas deben tener la misma cantidad de columnas.");
            }
        }
    }
}
