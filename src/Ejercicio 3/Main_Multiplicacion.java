import java.util.InputMismatchException;
import java.util.Scanner;

/**
 3) Dado un arreglo de dígitos y entero K (1≤K≤9), retorne el
 resultado de multiplicar el número por K sin usar BigInteger.
 Ej: {1,2,3}, K=3 → {3,6,9}

 */
public class Main_Multiplicacion {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int tamanio = pedirTamanio(teclado);
        int[] digitos = pedirDigitos(teclado, tamanio);
        int k = pedirK(teclado);

        ArregloMultiplicacion arreglo = new ArregloMultiplicacion(digitos);

        System.out.println("\nArreglo ingresado:");
        ArregloMultiplicacion.mostrarArreglo(digitos);

        int[] resultado = arreglo.multiplicarPorK(k);

        System.out.println("\nResultado de multiplicar cada elemento por " + k + ":");
        ArregloMultiplicacion.mostrarArreglo(resultado);

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

    private static int[] pedirDigitos(Scanner teclado, int tamanio) {
        int[] digitos = new int[tamanio];
        System.out.println("Ingrese los " + tamanio + " dígitos (cada uno entre 0 y 9):");
        for (int i = 0; i < tamanio; i++) {
            while (true) {
                System.out.print("Dígito [" + i + "]: ");
                try {
                    int digito = teclado.nextInt();
                    if (digito >= 0 && digito <= 9) {
                        digitos[i] = digito;
                        break;
                    }
                    System.out.println("Debe ser un dígito entre 0 y 9.");
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número entero entre 0 y 9.");
                    teclado.next();
                }
            }
        }
        return digitos;
    }

    private static int pedirK(Scanner teclado) {
        while (true) {
            System.out.print("Ingrese K (entre 1 y 9): ");
            try {
                int k = teclado.nextInt();
                if (k >= 1 && k <= 9) {
                    return k;
                }
                System.out.println("K debe estar entre 1 y 9.");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }
}
