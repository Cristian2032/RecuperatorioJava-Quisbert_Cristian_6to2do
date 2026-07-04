
public class ContadorVocales {

    private static final String VOCALES = "aeiou";

    private final String cadena;

    public ContadorVocales(String cadena) {
        if (cadena == null) {
            throw new IllegalArgumentException("La cadena no puede ser nula.");
        }
        this.cadena = cadena;
    }


    public int maximoVocalesEnVentana(int k) {
        int n = cadena.length();
        if (k <= 0 || k > n) {
            throw new IllegalArgumentException("k debe estar entre 1 y la longitud de la cadena.");
        }

        int vocalesActuales = 0;
        for (int i = 0; i < k; i++) {
            if (esVocal(cadena.charAt(i))) {
                vocalesActuales++;
            }
        }

        int maxVocales = vocalesActuales;

        for (int i = k; i < n; i++) {
            if (esVocal(cadena.charAt(i - k))) {
                vocalesActuales--;
            }
            if (esVocal(cadena.charAt(i))) {
                vocalesActuales++;
            }
            maxVocales = Math.max(maxVocales, vocalesActuales);
        }

        return maxVocales;
    }

    private boolean esVocal(char c) {
        return VOCALES.indexOf(c) != -1;
    }


    public ResultadoVocales maximoVocalesConVentana(int k) {
        int n = cadena.length();
        if (k <= 0 || k > n) {
            throw new IllegalArgumentException("k debe estar entre 1 y la longitud de la cadena.");
        }

        int vocalesActuales = 0;
        for (int i = 0; i < k; i++) {
            if (esVocal(cadena.charAt(i))) {
                vocalesActuales++;
            }
        }

        int maxVocales = vocalesActuales;
        int mejorInicio = 0;

        for (int i = k; i < n; i++) {
            if (esVocal(cadena.charAt(i - k))) {
                vocalesActuales--;
            }
            if (esVocal(cadena.charAt(i))) {
                vocalesActuales++;
            }

            if (vocalesActuales > maxVocales) {
                maxVocales = vocalesActuales;
                mejorInicio = i - k + 1;
            }
        }

        String mejorVentana = cadena.substring(mejorInicio, mejorInicio + k);
        return new ResultadoVocales(maxVocales, mejorVentana);
    }
}
