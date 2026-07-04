
public class ContadorDigitosPares {

    public int[] contarParesPorBloque(String digitos, int k) {
        validar(digitos, k);

        int n = digitos.length();
        int cantidadBloques = (n + k - 1) / k;
        int[] conteos = new int[cantidadBloques];

        for (int b = 0; b < cantidadBloques; b++) {
            int inicio = b * k;
            int fin = Math.min(inicio + k, n);

            int contador = 0;
            for (int i = inicio; i < fin; i++) {
                if (esPar(digitos.charAt(i))) {
                    contador++;
                }
            }
            conteos[b] = contador;
        }

        return conteos;
    }


    public String obtenerBloque(String digitos, int k, int indiceBloque) {
        int inicio = indiceBloque * k;
        int fin = Math.min(inicio + k, digitos.length());
        return digitos.substring(inicio, fin);
    }


    public int maximoDigitosParesEnBloque(String digitos, int k) {
        int[] conteos = contarParesPorBloque(digitos, k);
        int maximo = conteos[0];
        for (int c : conteos) {
            maximo = Math.max(maximo, c);
        }
        return maximo;
    }

    private boolean esPar(char c) {
        int digito = c - '0';
        return digito % 2 == 0;
    }

    private void validar(String digitos, int k) {
        if (digitos == null || digitos.isEmpty()) {
            throw new IllegalArgumentException("La cadena de digitos no puede ser nula ni vacia");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("k debe ser mayor a 0");
        }
        for (int i = 0; i < digitos.length(); i++) {
            if (!Character.isDigit(digitos.charAt(i))) {
                throw new IllegalArgumentException("La cadena debe contener solo digitos (0-9)");
            }
        }
    }
}
