import java.util.InputMismatchException;
import java.util.Scanner;

/**
 2) Dado un arreglo circular de enteros, retorne la longitud de
 la secuencia más larga de números consecutivos (considerando
 que el final conecta con el inicio).
 Ej: {1,2,4,5,6,7} → 4 (4,5,6,7)
 Ej: {2,1} → 2 (circular: 1,2)

 */
public class Main_Circular {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int tamanio = pedirTamanio(teclado);
        int[] arreglo = pedirValores(teclado, tamanio);

        ArregloCircular circular = new ArregloCircular(arreglo);

        System.out.println("\nArreglo ingresado:");
        circular.mostrarArreglo();

        ArregloCircular.ResultadoSecuencia resultado = circular.buscarSecuenciaMasLarga();
        System.out.println("\nSecuencia consecutiva más larga: " + resultado);

        teclado.close();
    }

    private static int pedirTamanio(Scanner teclado) {
        while (true) {
            System.out.print("Ingrese la cantidad de elementos del arreglo: ");
            try {
                int tamanio = teclado.nextInt();
                if (tamanio > 0) {
                    return tamanio;
                }
                System.out.println("La cantidad debe ser un número positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }

    private static int[] pedirValores(Scanner teclado, int tamanio) {
        int[] arreglo = new int[tamanio];
        System.out.println("Ingrese los " + tamanio + " valores:");
        for (int i = 0; i < tamanio; i++) {
            System.out.print("Valor [" + i + "]: ");
            arreglo[i] = teclado.nextInt();
        }
        return arreglo;
    }
}
