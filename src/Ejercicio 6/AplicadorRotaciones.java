
public class AplicadorRotaciones {


    public int[] aplicarRotaciones(int[] nums, int[][] rotaciones) {
        if (nums == null) {
            throw new IllegalArgumentException("El arreglo nums no puede ser nulo.");
        }

        int[] resultado = nums.clone();

        if (rotaciones == null) {
            return resultado;
        }

        for (int[] rotacion : rotaciones) {
            int start = rotacion[0];
            int end = rotacion[1];
            rotarSubarregloIzquierda(resultado, start, end);
        }

        return resultado;
    }


    private void rotarSubarregloIzquierda(int[] arr, int start, int end) {
        if (start < 0 || end >= arr.length || start >= end) {
            return;
        }

        int primero = arr[start];
        for (int i = start; i < end; i++) {
            arr[i] = arr[i + 1];
        }
        arr[end] = primero;
    }
}
