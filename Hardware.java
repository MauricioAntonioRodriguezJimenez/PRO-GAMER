package proyecto.programacion;

public class Hardware extends Producto {

    public Hardware() {
        super("Procesador", "Intel", "i5", 255.00, 1, 1990);
    }

    private double total;
    private double descuento;

    public void cobrar() {
        double _precio = this.getPrecio();
        int _cantidad = this.getCantidad();

        total = (_cantidad * _precio);

    }

    public double Descuento(double total) {

        double descuento = 0;

        if (total >= 100) {
            descuento = 0.05 * total;
            total = total - descuento;

        } else if (total >= 101 && total < 700) {
            descuento = 0.10 * total;
            total = total - descuento;

        } else if (total >= 700 && total < 1500) {
            descuento = 0.15 * total;
            total = total - descuento;

        } else if (total >= 1500) {
            descuento = 0.20 * total;
            total = total - descuento;
        }

        return total;

    }
}
