
public class ContadorConsonantes {

    private static final String VOCALES = "aeiouAEIOU";


    public static class ResultadoConsonantes {
        private final int cantidad;
        private final String subcadena;

        public ResultadoConsonantes(int cantidad, String subcadena) {
            this.cantidad = cantidad;
            this.subcadena = subcadena;
        }

        public int getCantidad() {
            return cantidad;
        }

        public String getSubcadena() {
            return subcadena;
        }

        @Override
        public String toString() {
            return cantidad + " (\"" + subcadena + "\")";
        }
    }


    public ResultadoConsonantes buscarMaxConsonantes(String s, int k) {
        if (s == null) {
            throw new IllegalArgumentException("El string no puede ser nulo.");
        }
        if (k <= 0 || k > s.length()) {
            throw new IllegalArgumentException("K debe ser mayor a 0 y no superar la longitud del string.");
        }

        // Contamos las consonantes de la primera ventana (los primeros k caracteres)
        int consonantesActuales = 0;
        for (int i = 0; i < k; i++) {
            if (esConsonante(s.charAt(i))) {
                consonantesActuales++;
            }
        }

        int maxConsonantes = consonantesActuales;
        int mejorInicio = 0;


        for (int i = k; i < s.length(); i++) {
            if (esConsonante(s.charAt(i))) {
                consonantesActuales++;
            }
            if (esConsonante(s.charAt(i - k))) {
                consonantesActuales--;
            }

            int inicioVentana = i - k + 1;
            if (consonantesActuales >= maxConsonantes) {
                maxConsonantes = consonantesActuales;
                mejorInicio = inicioVentana;
            }
        }

        String subcadena = s.substring(mejorInicio, mejorInicio + k);
        return new ResultadoConsonantes(maxConsonantes, subcadena);
    }


    public int maxConsonantesEnSubcadena(String s, int k) {
        return buscarMaxConsonantes(s, k).getCantidad();
    }

    private boolean esConsonante(char c) {
        return Character.isLetter(c) && VOCALES.indexOf(c) == -1;
    }
}
