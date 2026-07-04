import java.util.Scanner;

/**
 11) Dados dos arreglos dígitos A,B (misma longitud) y base K(2-16),
 suma A+B en base K.

 */
public class Main_SumaBaseK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresá la base K (2-16):");
        int base = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Ingresá el arreglo A separado por comas (Ej: 1,2,3):");
        int[] a = parsearArreglo(sc.nextLine());

        System.out.println("Ingresá el arreglo B separado por comas (Ej: 9,9,9):");
        int[] b = parsearArreglo(sc.nextLine());

        try {
            SumadorBaseK sumador = new SumadorBaseK(a, b, base);
            int[] resultado = sumador.sumar();

            System.out.println(formatearLlaves(a) + " + " + formatearLlaves(b) +
                    " (base " + base + ") = " + formatearLlaves(resultado));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

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
}
