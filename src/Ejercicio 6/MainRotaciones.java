import java.util.Arrays;
import java.util.Scanner;

/**
 6) Dados nums y array rotaciones[r][2] donde r=[start,end],
 aplique TODAS las rotaciones simultáneamente.
 Ej: [1,2,3,4,5], rot=[[0,1],[2,3]] → [2,1,4,3,5]

 */
public class MainRotaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresá el tamaño del arreglo nums: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Ingresá los " + n + " elementos separados por espacio: ");
        String[] partesNums = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(partesNums[i]);
        }

        System.out.print("Ingresá la cantidad de rotaciones (r): ");
        int r = Integer.parseInt(sc.nextLine().trim());

        int[][] rotaciones = new int[r][2];
        for (int i = 0; i < r; i++) {
            System.out.print("Ingresá start y end de la rotación " + (i + 1) + " (separados por espacio): ");
            String[] partesRotacion = sc.nextLine().trim().split("\\s+");
            rotaciones[i][0] = Integer.parseInt(partesRotacion[0]);
            rotaciones[i][1] = Integer.parseInt(partesRotacion[1]);
        }

        AplicadorRotaciones aplicador = new AplicadorRotaciones();
        int[] resultado = aplicador.aplicarRotaciones(nums, rotaciones);

        System.out.println("Arreglo original: " + Arrays.toString(nums));
        System.out.println("Arreglo final:    " + Arrays.toString(resultado));

        sc.close();
    }
}
