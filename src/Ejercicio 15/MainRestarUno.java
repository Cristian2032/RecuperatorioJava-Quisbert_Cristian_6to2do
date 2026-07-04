import java.util.Arrays;
import java.util.Scanner;

/**
 15) Escribir un metodo en java que, dado un arreglo dado
 arreglo dígitos, reste 1 manejando "préstamos".
 Ej: {1,0,0} → {9,9}
 Ej: {1,2,3} → {1,2,2}

 */
public class MainRestarUno {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de digitos: ");
        int n = teclado.nextInt();

        int[] digitos = new int[n];
        System.out.println("Ingrese los digitos (el mas significativo primero):");
        for (int i = 0; i < n; i++) {
            System.out.print("digitos[" + i + "]: ");
            digitos[i] = teclado.nextInt();
        }

        RestadorUno restador = new RestadorUno();
        int[] resultado = restador.restarUno(digitos);

        System.out.println("Numero original: " + Arrays.toString(digitos));
        System.out.println("Numero - 1:      " + Arrays.toString(resultado));

        teclado.close();
    }
}
