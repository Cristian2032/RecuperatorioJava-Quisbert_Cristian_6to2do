
public class ResultadoVocales {

    private final int cantidad;
    private final String ventana;

    public ResultadoVocales(int cantidad, String ventana) {
        this.cantidad = cantidad;
        this.ventana = ventana;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getVentana() {
        return ventana;
    }

    @Override
    public String toString() {
        return cantidad + " (\"" + ventana + "\")";
    }
}
