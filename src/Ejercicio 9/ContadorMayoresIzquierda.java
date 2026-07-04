
public class ContadorMayoresIzquierda {


    public int[] contarMayoresIzquierda(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }

        int n = nums.length;
        int[] counts = new int[n];


        for (int i = 0; i < n; i++) {
            int cantidad = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    cantidad++;
                }
            }
            counts[i] = cantidad;
        }

        return counts;
    }
}
