import java.util.InputMismatchException;
import java.util.Scanner;

/**
 17) Escribir un metodo en java que, dado un arreglo monedas que representa los valores de monedas de
 diferentes denominaciones y un entero monto, retorne la cantidad mínima de monedas que se necesitan para alcanzar ese monto. Si no se puede obtener el monto con ninguna combinación de monedas el método debe retornar -1.
 Se puede asumir que se dispone de una cantidad infinita de monedas.
 */
public class Main_Monedas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] monedas = pedirMonedas(teclado);
        int monto = pedirMonto(teclado);

        MonedasCambio calculadora = new MonedasCambio(monedas);
        int resultado = calculadora.cantidadMinima(monto);

        if (resultado == -1) {
            System.out.println("\nNo se puede formar el monto " + monto + " con esas monedas.");
        } else {
            System.out.println("\nCantidad mínima de monedas para formar " + monto + ": " + resultado);
        }

        teclado.close();
    }

    private static int[] pedirMonedas(Scanner teclado) {
        int cantidad = pedirEnteroPositivo(teclado, "Ingrese la cantidad de denominaciones de monedas: ");
        int[] monedas = new int[cantidad];
        System.out.println("Ingrese las " + cantidad + " denominaciones (valores positivos):");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Moneda [" + i + "]: ");
            monedas[i] = teclado.nextInt();
        }
        return monedas;
    }

    private static int pedirMonto(Scanner teclado) {
        System.out.print("Ingrese el monto a alcanzar: ");
        return teclado.nextInt();
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
