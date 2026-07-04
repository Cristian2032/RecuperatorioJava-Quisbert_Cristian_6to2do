import java.util.InputMismatchException;
import java.util.Scanner;

/**
 7 Y 8) Dado cubo 3D booleanos (barcos=true), cuente submarinos
 que ocupan exactamente 3 celdas consecutivas (X,Y,Z).
 No modificar el cubo.

 */
public class Main_Submarinos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = pedirN(teclado);
        boolean[][][] cubo = pedirCubo(teclado, n);

        System.out.println("\nCubo ingresado (por capas, eje Z):");
        mostrarCubo(cubo);

        CuboSubmarinos contador = new CuboSubmarinos();
        int cantidad = contador.contarSubmarinos(cubo);

        System.out.println("\nCantidad de submarinos (exactamente 3 celdas consecutivas): " + cantidad);

        teclado.close();
    }

    private static int pedirN(Scanner teclado) {
        while (true) {
            System.out.print("Ingrese N (el cubo será de N x N x N): ");
            try {
                int n = teclado.nextInt();
                if (n > 0) {
                    return n;
                }
                System.out.println("N debe ser un número positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.");
                teclado.next();
            }
        }
    }

    private static boolean[][][] pedirCubo(Scanner teclado, int n) {
        boolean[][][] cubo = new boolean[n][n][n];
        System.out.println("Ingrese los valores del cubo (1 = barco, 0 = vacío):");
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int z = 0; z < n; z++) {
                    cubo[x][y][z] = pedirCelda(teclado, x, y, z);
                }
            }
        }
        return cubo;
    }

    private static boolean pedirCelda(Scanner teclado, int x, int y, int z) {
        while (true) {
            System.out.print("Cubo[" + x + "][" + y + "][" + z + "] (1/0): ");
            try {
                int valor = teclado.nextInt();
                if (valor == 0 || valor == 1) {
                    return valor == 1;
                }
                System.out.println("Debe ingresar 1 (barco) o 0 (vacío).");
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar 1 o 0.");
                teclado.next();
            }
        }
    }

    private static void mostrarCubo(boolean[][][] cubo) {
        int n = cubo.length;
        for (int z = 0; z < n; z++) {
            System.out.println("Capa Z=" + z + ":");
            for (int x = 0; x < n; x++) {
                StringBuilder sb = new StringBuilder();
                for (int y = 0; y < n; y++) {
                    sb.append(cubo[x][y][z] ? "1" : "0");
                    if (y < n - 1) {
                        sb.append(" ");
                    }
                }
                System.out.println(sb);
            }
        }
    }
}
