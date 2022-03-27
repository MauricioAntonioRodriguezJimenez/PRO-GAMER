package proyecto.programacion;

public class Producto implements Comparadores {

    private String nombre;
    private String marca;
    private String modelo;
    private double precio;
    private int cantidad;
    private int codigo;

    //Metodo Constructor

    public Producto(String _nombre, String _modelo, String _marca, double _precio, int _cantidad, int _codigo) {
        nombre = _nombre;
        modelo = _modelo;
        marca = _marca;
        precio = _precio;
        cantidad = _cantidad;
        codigo = _codigo;
    }

    //Metodo para Modificar el Nombre del Producto
    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    //Metodo para Modificar la Marca del Producto
    public void setMarca(String _marca) {
        this.marca = _marca;
    }

    public String getMarca() {
        return this.marca;
    }

    //Metodo para Modificar el Modelo del Producto
    public void setModelo(String _modelo) {
        this.modelo = _modelo;
    }

    public String getModelo() {
        return this.modelo;
    }

    //Metodo para Modificar el Precio del Producto
    public void setPrecio(double _precio) {
        this.precio = _precio;
    }

    public double getPrecio() {
        return this.precio;
    }

    //Metodo para Modificar la Cantidad de Productos
    public void setCantidad(int _cantidad) {
        this.cantidad = _cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    //Metodo para Moidifcar el Codigo de un Producto
    public void setCodigo(int _codigo) {
        this.codigo = _codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    //Metodo para conocer la Existencia de algun Producto
    public void Existencia() {

        int cantidadProducto = this.cantidad;
        boolean Existencia;

        if (cantidadProducto >= 1) {
            Existencia = true;
        } else {
            Existencia = false;
        }

        if (Existencia == true) {
            System.out.println("El producto esta en existencia");
        } else {
            System.out.println("Por el moemnto el producto esta agotado!");
        }
    }

    //Metodo para agregar cantidad de Productos
    public int NuevoProducto(int NuevosProductos) {

        int cantidad = this.cantidad;

        cantidad = NuevosProductos + cantidad;

        return cantidad;

    }

    //--------------------------------------------------------------
    public double toDouble() {
        return this.precio;
    }

    //Metodos abstractos
    @Override
    public boolean igualQue(Object o) {
        Producto n = (Producto) o;
        return this.toDouble() == n.toDouble();
    }

    @Override
    public boolean menorQue(Object o) {
        Producto n = (Producto) o;
        return this.toDouble() < n.toDouble();
    }

    @Override
    public boolean mayorQue(Object o) {
        Producto n = (Producto) o;
        return this.toDouble() > n.toDouble();
    }

    @Override
    public boolean menorIgual(Object o) {
        Producto n = (Producto) o;
        return this.toDouble() <= n.toDouble();
    }

    @Override
    public boolean mayorIgual(Object o) {
        Producto n = (Producto) o;
        return this.toDouble() >= n.toDouble();
    }

}

