import java.util.Scanner;

/**
 5) Dado string s y k, retorne máximo de consonantes en cualquier
 subcadena de longitud k (consonantes = no vocales).
 Ej: "abcuuudef", k=3 → 2 ("def")
 */
public class MainConsonantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresá el string: ");
        String s = sc.nextLine();

        System.out.print("Ingresá K: ");
        int k = Integer.parseInt(sc.nextLine().trim());

        ContadorConsonantes contador = new ContadorConsonantes();
        ContadorConsonantes.ResultadoConsonantes resultado = contador.buscarMaxConsonantes(s, k);

        System.out.println("Máximo de consonantes en una subcadena de longitud "
                + k + ": " + resultado);

        sc.close();
    }
}
