
public class SumadorBaseK {

    private int[] a;
    private int[] b;
    private int base;

    public SumadorBaseK(int[] a, int[] b, int base) {
        validarBase(base);
        validarArreglos(a, b, base);
        this.a = a;
        this.b = b;
        this.base = base;
    }

    private void validarBase(int base) {
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("La base debe estar entre 2 y 16.");
        }
    }

    private void validarArreglos(int[] a, int[] b, int base) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Los arreglos no pueden ser nulos.");
        }
        if (a.length == 0 || a.length != b.length) {
            throw new IllegalArgumentException("Los arreglos deben tener la misma longitud (mayor a 0).");
        }
        for (int digito : a) {
            if (digito < 0 || digito >= base) {
                throw new IllegalArgumentException("Dígito inválido en A para base " + base + ": " + digito);
            }
        }
        for (int digito : b) {
            if (digito < 0 || digito >= base) {
                throw new IllegalArgumentException("Dígito inválido en B para base " + base + ": " + digito);
            }
        }
    }


    public int[] sumar() {
        int n = a.length;
        int[] resultadoInvertido = new int[n + 1];
        int carry = 0;

        for (int i = 0; i < n; i++) {
            int pos = n - 1 - i;
            int suma = a[pos] + b[pos] + carry;
            resultadoInvertido[i] = suma % base;
            carry = suma / base;
        }
        resultadoInvertido[n] = carry;

        int longitudFinal = (carry == 0) ? n : n + 1;
        int[] resultado = new int[longitudFinal];
        for (int i = 0; i < longitudFinal; i++) {
            resultado[i] = resultadoInvertido[longitudFinal - 1 - i];
        }

        return resultado;
    }

    public int getBase() {
        return base;
    }

    public int[] getA() {
        return a;
    }

    public int[] getB() {
        return b;
    }
}
