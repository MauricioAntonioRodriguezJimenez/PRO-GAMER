package proyecto.programacion;


public class Producto {
    private String nombre;
    private String marca;
    private String modelo;
    private double precio;
    private int cantidad;
    
    //Metodo para Modificar el Nombre del Producto
    
    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    //Metodo para Modificar la Marca del Producto
    public void setMarca(String _marca){
        this.marca = _marca;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    //Metodo para Modificar el Modelo del Producto
    public void setModelo(String _modelo){
        this.modelo = _modelo;
    }
    
    public String setModelo(){
        return this.modelo;
    }
    
    //Metodo para Modificar el Precio del Producto
    public void setPrecio(double _precio){
        this.precio = _precio;
    }
    
    public double setPrecio(){
        return this.precio;
    }
    
    //Metodo para Modificar la Cantidad de Productos
    public void setCantidad(int _cantidad){
        this.cantidad = _cantidad;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    //Metodo para conocer la Existencia de algún Producto
    
    public void Existencia(){
    
        int cantidadProducto = this.cantidad;
        boolean Existencia;
        
        
        if(cantidadProducto >=1 ){
            Existencia = true;
        } else { 
           Existencia = false;
        }
        
        if(Existencia == true){
            
            System.out.println("El producto esta en existencia");
        } else {
            System.out.println("Por el moemnto el producto esta agotado!");
        }   
}
    
    //Metodo para agregar cantidad de Productos
    public int NuevoProducto(int NuevosProductos){
        
       int cantidad = this.cantidad;
        
       cantidad = NuevosProductos + cantidad;
        
       return cantidad;
        
    }
   
    
    
    
}
