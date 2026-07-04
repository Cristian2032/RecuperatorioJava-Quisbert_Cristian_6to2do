import java.util.Arrays;

public class MonedasCambio {

    private final int[] monedas;

    public MonedasCambio(int[] monedas) {
        if (monedas == null) {
            throw new IllegalArgumentException("El arreglo de monedas no puede ser nulo.");
        }
        for (int moneda : monedas) {
            if (moneda <= 0) {
                throw new IllegalArgumentException("Las denominaciones deben ser valores positivos.");
            }
        }
        this.monedas = monedas;
    }

    public int cantidadMinima(int monto) {
        if (monto < 0) {
            return -1;
        }
        if (monto == 0) {
            return 0;
        }

        int[] dp = new int[monto + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // MAX_VALUE representa "todavía no alcanzable"
        dp[0] = 0;

        for (int subMonto = 1; subMonto <= monto; subMonto++) {
            for (int moneda : monedas) {
                if (moneda <= subMonto && dp[subMonto - moneda] != Integer.MAX_VALUE) {
                    dp[subMonto] = Math.min(dp[subMonto], dp[subMonto - moneda] + 1);
                }
            }
        }

        return dp[monto] == Integer.MAX_VALUE ? -1 : dp[monto];
    }
}
