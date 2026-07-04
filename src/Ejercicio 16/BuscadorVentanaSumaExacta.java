
public class BuscadorVentanaSumaExacta {

    public int buscarInicio(String digitos, int k, int target) {
        validar(digitos, k);

        int sumaActual = 0;
        for (int i = 0; i < k; i++) {
            sumaActual += valorDigito(digitos.charAt(i));
        }

        if (sumaActual == target) {
            return 0;
        }

        for (int i = k; i < digitos.length(); i++) {
            sumaActual += valorDigito(digitos.charAt(i));
            sumaActual -= valorDigito(digitos.charAt(i - k));

            int inicioVentana = i - k + 1;
            if (sumaActual == target) {
                return inicioVentana;
            }
        }

        return -1;
    }

    private int valorDigito(char c) {
        return c - '0';
    }

    private void validar(String digitos, int k) {
        if (digitos == null || digitos.isEmpty()) {
            throw new IllegalArgumentException("La cadena de digitos no puede ser nula ni vacia");
        }
        if (k <= 0 || k > digitos.length()) {
            throw new IllegalArgumentException("k debe ser mayor a 0 y no superar la longitud de la cadena");
        }
        for (int i = 0; i < digitos.length(); i++) {
            if (!Character.isDigit(digitos.charAt(i))) {
                throw new IllegalArgumentException("La cadena debe contener solo digitos (0-9)");
            }
        }
    }
}
