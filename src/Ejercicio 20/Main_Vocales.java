import java.util.InputMismatchException;
import java.util.Scanner;

/**
 20) Escribir un metodo en java que, dado un string s y un entero k,
 retorne la cantidad máxima de vocales en las subcadenas de longitud k de s. Los siguientes caracteres deben ser considerados vocales “a”, “e”, “i”, “o”, “u”.
 Por ejemplo: dada s= “abcuuudef”. Si k=2->2. Si k=3->3 y si k=5->4.
 */
public class Main_Vocales {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el string: ");
        String cadena = teclado.nextLine();

        ContadorVocales contador = new ContadorVocales(cadena);

        int k = pedirK(teclado, cadena.length());

        ResultadoVocales resultado = contador.maximoVocalesConVentana(k);
        System.out.println("\nMáximo de vocales en una subcadena de longitud " + k + ": " + resultado);

        teclado.close();
    }

    private static int pedirK(Scanner teclado, int longitudMaxima) {
        while (true) {
            System.out.print("Ingrese k (entre 1 y " + longitudMaxima + "): ");
            try {
                int k = teclado.nextInt();
                if (k >= 1 && k <= longitudMaxima) {
                    return k;
                }
                System.out.println("k debe estar entre 1 y " + longitudMaxima + ".");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }
}
