import java.util.InputMismatchException;
import java.util.Scanner;

/**
 4) Dada una matriz NxN ordenada ascendentemente pero rotada K
 veces, retorne la posición del target o {-1,-1}.
 Ej: [[4,5,6],[1,2,3],[7,8,9]], target=5 → {0,1}

 */
public class Main_MatrizRotada {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = pedirN(teclado);
        int[][] matriz = pedirMatriz(teclado, n);
        int k = pedirEnteroNoNegativo(teclado, "Ingrese K (cantidad de rotaciones): ");
        int target = pedirEntero(teclado, "Ingrese el valor a buscar (target): ");

        MatrizRotada matrizRotada = new MatrizRotada(matriz, k);

        System.out.println("\nMatriz ingresada:");
        matrizRotada.mostrarMatriz();

        int[] posicion = matrizRotada.buscarPosicion(target);

        System.out.println("\nPosición de " + target + ": {" + posicion[0] + ", " + posicion[1] + "}");

        teclado.close();
    }

    private static int pedirN(Scanner teclado) {
        while (true) {
            System.out.print("Ingrese N (la matriz será de N x N): ");
            try {
                int n = teclado.nextInt();
                if (n > 0) {
                    return n;
                }
                System.out.println("N debe ser un número positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }

    private static int[][] pedirMatriz(Scanner teclado, int n) {
        int[][] matriz = new int[n][n];
        System.out.println("Ingrese los " + (n * n) + " valores de la matriz, fila por fila:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();
            }
        }
        return matriz;
    }

    private static int pedirEnteroNoNegativo(Scanner teclado, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = teclado.nextInt();
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("Debe ser un número mayor o igual a 0.");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }

    private static int pedirEntero(Scanner teclado, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }
}
