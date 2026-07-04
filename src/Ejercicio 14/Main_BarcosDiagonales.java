import java.util.Scanner;

/**
 14) Escribir un metodo en java que, dado un arreglo Tablero booleanos,
 cuente barcos DIAGONALES (/) o (\$ de
 longitud >=2. No modificar tablero.
 */
public class Main_BarcosDiagonales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresá la cantidad de filas:");
        int filas = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Ingresá la cantidad de columnas:");
        int columnas = Integer.parseInt(sc.nextLine().trim());

        boolean[][] tablero = new boolean[filas][columnas];
        System.out.println("Ingresá cada fila usando 1 (ocupado) y 0 (vacío), separados por coma. Ej: 1,0,0,1");
        for (int i = 0; i < filas; i++) {
            System.out.println("Fila " + (i + 1) + ":");
            tablero[i] = parsearFila(sc.nextLine(), columnas);
        }

        ContadorBarcosDiagonales contador = new ContadorBarcosDiagonales();

        try {
            int cantidad = contador.contarBarcosDiagonales(tablero);

            System.out.println();
            mostrarTablero(tablero);
            System.out.println("Cantidad de barcos diagonales (longitud >= 2): " + cantidad);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    private static boolean[] parsearFila(String linea, int columnasEsperadas) {
        String[] partes = linea.replace("{", "").replace("}", "").split(",");
        boolean[] fila = new boolean[partes.length];
        for (int i = 0; i < partes.length; i++) {
            fila[i] = partes[i].trim().equals("1");
        }
        return fila;
    }

    private static void mostrarTablero(boolean[][] tablero) {
        for (boolean[] fila : tablero) {
            StringBuilder sb = new StringBuilder();
            for (boolean celda : fila) {
                sb.append(celda ? '1' : '0');
            }
            System.out.println(sb);
        }
        System.out.println();
    }
}
