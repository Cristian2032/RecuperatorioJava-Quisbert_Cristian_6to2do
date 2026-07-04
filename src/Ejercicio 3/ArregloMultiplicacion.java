
public class ArregloMultiplicacion {

    private final int[] digitos;
    private final int tamanio;

    public ArregloMultiplicacion(int[] digitos) {
        if (digitos == null || digitos.length == 0) {
            throw new IllegalArgumentException("El arreglo de dígitos no puede ser nulo ni vacío.");
        }
        for (int d : digitos) {
            if (d < 0 || d > 9) {
                throw new IllegalArgumentException("Cada posición del arreglo debe ser un dígito entre 0 y 9.");
            }
        }
        this.digitos = digitos;
        this.tamanio = digitos.length;
    }


    public int[] multiplicarPorK(int k) {
        if (k < 1 || k > 9) {
            throw new IllegalArgumentException("K debe estar entre 1 y 9.");
        }

        int[] resultado = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            resultado[i] = digitos[i] * k;
        }
        return resultado;
    }

    public static void mostrarArreglo(int[] arreglo) {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < arreglo.length; i++) {
            sb.append(arreglo[i]);
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        System.out.println(sb);
    }
}
