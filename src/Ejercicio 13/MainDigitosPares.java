import java.util.Scanner;

/**
 13) Escribir un metodo en java que, dado un arreglo string de dígitos y k,
 máximo dígitos PARES en ventana k.

 */
public class MainDigitosPares {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cadena de digitos (ej: 334567890): ");
        String digitos = teclado.next();

        System.out.print("Ingrese el tamaño del bloque k: ");
        int k = teclado.nextInt();

        ContadorDigitosPares contador = new ContadorDigitosPares();
        int[] conteos = contador.contarParesPorBloque(digitos, k);

        for (int i = 0; i < conteos.length; i++) {
            String bloque = contador.obtenerBloque(digitos, k, i);
            System.out.println("Bloque \"" + bloque + "\" (indice " + i + "): "
                    + conteos[i] + " par");
        }

        int maximo = conteos[0];
        int mejorIndice = 0;
        for (int i = 1; i < conteos.length; i++) {
            if (conteos[i] >= maximo) {
                maximo = conteos[i];
                mejorIndice = i;
            }
        }
        String mejorBloque = contador.obtenerBloque(digitos, k, mejorIndice);

        System.out.println();
        System.out.println("\"" + digitos + "\", k=" + k + " \u2192 " + maximo + " (\"" + mejorBloque + "\")");

        teclado.close();
    }
}
