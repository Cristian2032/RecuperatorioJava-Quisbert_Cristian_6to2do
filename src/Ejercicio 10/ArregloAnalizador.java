
public class ArregloAnalizador {

    private int[] arreglo;
    private int mejorInicio;
    private int mejorLongitud;

    public ArregloAnalizador(int[] arreglo) {
        this.arreglo = arreglo;
        this.mejorInicio = -1;
        this.mejorLongitud = 0;
    }

    public int[] getArreglo() {
        return arreglo;
    }

    public int longitudMasLargaParesConsecutivos() {
        if (arreglo == null || arreglo.length == 0) {
            mejorInicio = -1;
            mejorLongitud = 0;
            return 0;
        }

        int maxLongitud = 0;
        int longitudActual = 0;
        int inicioActual = 0;
        int mejorInicioLocal = -1;

        int i = 0;
        int n = arreglo.length;

        while (i < n) {
            int j = i;

            while (j < n && arreglo[j] == arreglo[i]) {
                j++;
            }
            int repeticiones = j - i;

            if (repeticiones == 2) {
                if (longitudActual == 0) {
                    inicioActual = i;
                }
                longitudActual += 2;
                if (longitudActual > maxLongitud) {
                    maxLongitud = longitudActual;
                    mejorInicioLocal = inicioActual;
                }
            } else {
                longitudActual = 0;
            }

            i = j;
        }

        this.mejorInicio = mejorInicioLocal;
        this.mejorLongitud = maxLongitud;

        return maxLongitud;
    }


    public int[] getMejorSegmento() {
        if (mejorInicio == -1 || mejorLongitud == 0) {
            return new int[0];
        }
        int[] segmento = new int[mejorLongitud];
        System.arraycopy(arreglo, mejorInicio, segmento, 0, mejorLongitud);
        return segmento;
    }
}
