import java.util.Scanner;

/**
 10) Dado arreglo, retorne longitud MÁS LARGA donde cada número
 aparece EXACTAMENTE 2 veces consecutivas.

 Ej: {1,2,2,3,3,4,1} → 4 (2,2,3,3)

 */
public class Main_2Veces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresá el arreglo separado por comas (Ej: 1,2,2,3,3,4,1):");
        String linea = sc.nextLine();

        int[] datos = parsearArreglo(linea);

        ArregloAnalizador analizador = new ArregloAnalizador(datos);
        int resultado = analizador.longitudMasLargaParesConsecutivos();
        int[] segmento = analizador.getMejorSegmento();

        System.out.println(formatearLlaves(datos) + " → " + resultado + " " + formatearParentesis(segmento));

        sc.close();
    }

    private static int[] parsearArreglo(String linea) {
        String[] partes = linea.replace("{", "").replace("}", "").split(",");
        int[] datos = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            datos[i] = Integer.parseInt(partes[i].trim());
        }
        return datos;
    }

    private static String formatearLlaves(int[] arr) {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }

    private static String formatearParentesis(int[] arr) {
        if (arr.length == 0) return "()";
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(",");
        }
        sb.append(")");
        return sb.toString();
    }
}
