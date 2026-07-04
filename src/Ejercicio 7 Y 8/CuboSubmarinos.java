
public class CuboSubmarinos {


    public int contarSubmarinos(boolean[][][] cubo) {
        if (cubo == null || cubo.length == 0 || cubo[0].length == 0 || cubo[0][0].length == 0) {
            throw new IllegalArgumentException("El cubo no puede ser nulo ni tener dimensiones vacías.");
        }

        int tamX = cubo.length;
        int tamY = cubo[0].length;
        int tamZ = cubo[0][0].length;

        int contador = 0;

        for (int y = 0; y < tamY; y++) {
            for (int z = 0; z < tamZ; z++) {
                boolean[] linea = new boolean[tamX];
                for (int x = 0; x < tamX; x++) {
                    linea[x] = cubo[x][y][z];
                }
                contador += contarRunsDeTres(linea);
            }
        }

        for (int x = 0; x < tamX; x++) {
            for (int z = 0; z < tamZ; z++) {
                boolean[] linea = new boolean[tamY];
                for (int y = 0; y < tamY; y++) {
                    linea[y] = cubo[x][y][z];
                }
                contador += contarRunsDeTres(linea);
            }
        }

        for (int x = 0; x < tamX; x++) {
            for (int y = 0; y < tamY; y++) {
                boolean[] linea = new boolean[tamZ];
                for (int z = 0; z < tamZ; z++) {
                    linea[z] = cubo[x][y][z];
                }
                contador += contarRunsDeTres(linea);
            }
        }

        return contador;
    }


    private int contarRunsDeTres(boolean[] linea) {
        int contador = 0;
        int longitudActual = 0;

        for (boolean celda : linea) {
            if (celda) {
                longitudActual++;
            } else {
                if (longitudActual == 3) {
                    contador++;
                }
                longitudActual = 0;
            }
        }

        if (longitudActual == 3) {
            contador++;
        }

        return contador;
    }
}
