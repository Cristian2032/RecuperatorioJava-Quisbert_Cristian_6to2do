import java.util.Scanner;

/**
 12) Escribir un metodo en java que, dado un arreglo Matriz donde cada fila desciende
 y primera columna de fila  es MENOR que última de fila anterior. Busque target.
 Ej: [[10,8,6],[7,5,3],[1,0,-1]] target=5 → true

 */
public class Main_BuscarMatriz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresá la cantidad de filas:");
        int filas = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Ingresá la cantidad de columnas:");
        int columnas = Integer.parseInt(sc.nextLine().trim());

        int[][] matriz = new int[filas][columnas];
        System.out.println("Ingresá cada fila separada por comas, en orden DESCENDENTE (Ej: 50,40,30):");
        for (int i = 0; i < filas; i++) {
            System.out.println("Fila " + (i + 1) + ":");
            matriz[i] = parsearFila(sc.nextLine());
        }

        System.out.println("Ingresá el número a buscar (target):");
        int target = Integer.parseInt(sc.nextLine().trim());

        try {
            BuscadorMatriz buscador = new BuscadorMatriz(matriz);

            boolean cumple = buscador.cumpleCondiciones();
            boolean encontrado = buscador.existe(target);

            System.out.println("¿Cada fila desciende y cada primera columna de fila es MENOR que última de fila anterior:  " + cumple);
            System.out.println(formatearMatriz(matriz) + " target=" + target + " → " + encontrado);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    private static int[] parsearFila(String linea) {
        String[] partes = linea.replace("{", "").replace("}", "").split(",");
        int[] fila = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            fila[i] = Integer.parseInt(partes[i].trim());
        }
        return fila;
    }

    private static String formatearMatriz(int[][] matriz) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < matriz.length; i++) {
            sb.append("[");
            for (int j = 0; j < matriz[i].length; j++) {
                sb.append(matriz[i][j]);
                if (j < matriz[i].length - 1) sb.append(",");
            }
            sb.append("]");
            if (i < matriz.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
