import java.util.Scanner;

/**
 16) String dígitos, ventana k con SUMA EXACTA de dígitos = target.
 Retorne índice INICIO o -1.

 */
public class MainVentanaSumaExacta {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cadena de digitos (ej: 129394): ");
        String digitos = teclado.next();

        System.out.print("Ingrese el tamanio de la ventana k: ");
        int k = teclado.nextInt();

        System.out.print("Ingrese el target (suma exacta buscada): ");
        int target = teclado.nextInt();

        BuscadorVentanaSumaExacta buscador = new BuscadorVentanaSumaExacta();
        int indiceInicio = buscador.buscarInicio(digitos, k, target);

        if (indiceInicio == -1) {
            System.out.println("No existe ninguna ventana de tamanio " + k
                    + " cuya suma de digitos sea " + target);
        } else {
            String ventana = digitos.substring(indiceInicio, indiceInicio + k);
            System.out.println("Se encontro la ventana \"" + ventana
                    + "\" que empieza en el indice " + indiceInicio);
        }

        teclado.close();
    }
}
