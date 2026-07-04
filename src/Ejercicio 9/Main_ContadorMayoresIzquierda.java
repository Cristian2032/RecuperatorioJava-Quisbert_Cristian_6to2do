import java.util.InputMismatchException;
import java.util.Scanner;

/**
 9) Dado nums, retorne counts[i] = cantidad elementos IZQUIERDA
 mayores que nums[i].

 Ej: {5,3,7,1} → {0,1,0,3}

 */
public class Main_ContadorMayoresIzquierda {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int tamanio = pedirTamanio(teclado);
        int[] nums = pedirValores(teclado, tamanio);

        ContadorMayoresIzquierda contador = new ContadorMayoresIzquierda();
        int[] counts = contador.contarMayoresIzquierda(nums);

        System.out.println("\nArreglo ingresado:");
        mostrarArreglo(nums);

        System.out.println("\nCounts (elementos a la izquierda mayores que nums[i]):");
        mostrarArreglo(counts);

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

    private static void mostrarArreglo(int[] arreglo) {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < arreglo.length; i++) {
            sb.append(arreglo[i]);
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        System.out.println(sb);
    }
}
