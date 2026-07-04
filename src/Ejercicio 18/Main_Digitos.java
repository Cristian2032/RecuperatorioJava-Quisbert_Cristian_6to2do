import java.util.InputMismatchException;
import java.util.Scanner;

/**
 18)Escribir un metodo en lenguaje java que, dado un arreglo de enteros
 donde cada posición representa los dígitos de un entero,
 retome el valor pasado incrementado en 1. Ejemplos: 1, 2, 3} ->{1, 2, 4},
 */
public class Main_Digitos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] digitos = pedirDigitos(teclado);

        ArregloDigitos numero = new ArregloDigitos(digitos);

        System.out.println("\nNúmero ingresado:");
        ArregloDigitos.mostrarArreglo(digitos);

        int[] resultado = numero.incrementarEnUno();
        System.out.println("\nNúmero incrementado en 1:");
        ArregloDigitos.mostrarArreglo(resultado);

        teclado.close();
    }

    private static int[] pedirDigitos(Scanner teclado) {
        int cantidad = pedirEnteroPositivo(teclado, "Ingrese la cantidad de dígitos del número: ");
        int[] digitos = new int[cantidad];
        System.out.println("Ingrese los " + cantidad + " dígitos:");
        for (int i = 0; i < cantidad; i++) {
            digitos[i] = pedirDigito(teclado, "Dígito [" + i + "]: ");
        }
        return digitos;
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

    private static int pedirDigito(Scanner teclado, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = teclado.nextInt();
                if (valor >= 0 && valor <= 9) {
                    return valor;
                }
                System.out.println("El dígito debe estar entre 0 y 9.");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }
}
