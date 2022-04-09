package proyecto.programacion;

import java.util.List;

public abstract class Producto  implements CRUD{

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
    
    //Metodo Constructor
    
    public Producto(String nombre, String marca, String modelo, double precio, int cantidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Metodo Constructor
    public Producto() {
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

    @Override
    public int Create(Object g) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int Delete(int key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List Buscar(double  key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List readAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   

  
}
