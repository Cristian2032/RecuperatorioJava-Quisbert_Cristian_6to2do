import java.util.Arrays;

public class RestadorUno {

    private static final int BASE = 10;


    public int[] restarUno(int[] digitos) {
        validar(digitos);

        int[] resultado = Arrays.copyOf(digitos, digitos.length);
        int posicion = resultado.length - 1;
        boolean hayPrestamo = true;

        while (posicion >= 0 && hayPrestamo) {
            if (resultado[posicion] > 0) {
                resultado[posicion]--;
                hayPrestamo = false;
            } else {

                resultado[posicion] = BASE - 1;
                posicion--;
            }
        }

        return quitarCerosIniciales(resultado);
    }

    private int[] quitarCerosIniciales(int[] resultado) {
        int inicio = 0;
        while (inicio < resultado.length - 1 && resultado[inicio] == 0) {
            inicio++;
        }
        return Arrays.copyOfRange(resultado, inicio, resultado.length);
    }

    private void validar(int[] digitos) {
        if (digitos == null || digitos.length == 0) {
            throw new IllegalArgumentException("El arreglo de digitos no puede ser nulo ni vacio");
        }
        for (int digito : digitos) {
            if (digito < 0 || digito >= BASE) {
                throw new IllegalArgumentException("Cada digito debe estar entre 0 y " + (BASE - 1));
            }
        }
        if (esCero(digitos)) {
            throw new IllegalArgumentException("No se puede restar 1 a 0 (resultado negativo)");
        }
    }

    private boolean esCero(int[] digitos) {
        for (int digito : digitos) {
            if (digito != 0) {
                return false;
            }
        }
        return true;
    }
}
