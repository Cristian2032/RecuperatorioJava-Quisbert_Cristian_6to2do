import java.util.InputMismatchException;
import java.util.Scanner;

/**
 19) Escribir un metodo en lenguaje java que, dado un arreglo de enteros que no se encuentra ordenado, retome la longitud de la secuencia más larga de elementos. El método no puede modificar el parámetro.
 Ejemplos: {10, 4, 20, 1 3, 2} ->4, {0, 3, 7, 1, 8, 2, 5, 8, 4, 6, 0, 1}->9.
 */
public class Main_Desordenado {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] arreglo = pedirValores(teclado);

        ArregloDesordenado desordenado = new ArregloDesordenado(arreglo);

        System.out.println("\nArreglo antes de calcular:");
        desordenado.mostrarArreglo();

        int resultado = desordenado.longitudMaximaConsecutiva();

        System.out.println("\nArreglo después de calcular (debe seguir igual):");
        desordenado.mostrarArreglo();

        System.out.println("\nLongitud de la secuencia consecutiva más larga: " + resultado);

        teclado.close();
    }

    private static int[] pedirValores(Scanner teclado) {
        int cantidad = pedirEnteroPositivo(teclado, "Ingrese la cantidad de elementos del arreglo: ");
        int[] arreglo = new int[cantidad];
        System.out.println("Ingrese los " + cantidad + " valores (en cualquier orden):");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Valor [" + i + "]: ");
            arreglo[i] = teclado.nextInt();
        }
        return arreglo;
    }

    private static int pedirEnteroPositivo(Scanner teclado, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = teclado.nextInt();
                if (valor > 0) {
                    return valor;
                }
                System.out.println("El valor debe ser positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }
}
