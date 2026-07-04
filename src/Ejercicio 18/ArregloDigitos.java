
public class ArregloDigitos {

    private final int[] digitos;

    public ArregloDigitos(int[] digitos) {
        if (digitos == null || digitos.length == 0) {
            throw new IllegalArgumentException("El arreglo de dígitos no puede ser nulo ni vacío.");
        }
        for (int digito : digitos) {
            if (digito < 0 || digito > 9) {
                throw new IllegalArgumentException("Cada posición debe ser un dígito entre 0 y 9.");
            }
        }
        this.digitos = digitos;
    }

    public int[] incrementarEnUno() {
        int n = digitos.length;
        int[] resultado = digitos.clone();

        for (int i = n - 1; i >= 0; i--) {
            if (resultado[i] < 9) {
                resultado[i]++;
                return resultado;
            }
            resultado[i] = 0;
        }

        int[] conAcarreoExtra = new int[n + 1];
        conAcarreoExtra[0] = 1;
        System.arraycopy(resultado, 0, conAcarreoExtra, 1, n);
        return conAcarreoExtra;
    }

    public static void mostrarArreglo(int[] arreglo) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < arreglo.length; i++) {
            sb.append(arreglo[i]);
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        System.out.println(sb);
    }
}
