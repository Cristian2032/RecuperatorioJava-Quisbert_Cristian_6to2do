import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * 1) Dado un arreglo bidimensional de enteros, retorne true si
 * formando un espiral desde el CENTRO hacia afuera se obtiene
 * la secuencia 1,2,3,...,N en orden.
 * Ej: [[1,2,3],[8,9,4],[7,6,5]] → true
 * [[1,2,3],[4,5,6],[7,8,9]] → false
 */
public class Main_Espiral {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int tamanio = pedirTamanio(teclado);
        int[][] matriz = pedirValores(teclado, tamanio);

        Espiral espiral = new Espiral(matriz);

        System.out.println("\nMatriz ingresada:");
        espiral.mostrarMatriz();

        boolean resultado = espiral.esEspiralDescendenteDesdeCentro();
        System.out.println("\n¿Forma la espiral correcta? " + resultado);

        teclado.close();
    }

    private static int pedirTamanio(Scanner teclado) {
        while (true) {
            System.out.print("Ingrese el tamaño N de la matriz (N x N) ej: 3): ");
            try {
                int tamanio = teclado.nextInt();
                if (tamanio > 0 && tamanio % 2 != 0) {
                    return tamanio;
                }
                System.out.println("El tamaño debe ser un número impar positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }

    private static int[][] pedirValores(Scanner teclado, int tamanio) {
        int[][] matriz = new int[tamanio][tamanio];
        System.out.println("Ingrese los " + (tamanio * tamanio) + " valores, fila por fila: ( 1 2 3 8 9 4 7 6 5 )");
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                System.out.print("Valor [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();
            }
        }
        return matriz;
    }
}
