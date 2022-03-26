package proyecto.programacion;

public class Software extends Producto {

    public Software() {
        super("Windows 10", "Microsoft", "Pro", 15.00, 1, 2322);
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

        if (total >= 50) {
            descuento = 0.05 * total;
            total = total - descuento;

        } else if (total >= 51 && total < 200) {
            descuento = 0.10 * total;
            total = total - descuento;

        } else if (total >= 200 && total < 800) {
            descuento = 0.15 * total;
            total = total - descuento;

        } else if (total >= 800) {
            descuento = 0.20 * total;
            total = total - descuento;
        }

        return total;

    }
}
