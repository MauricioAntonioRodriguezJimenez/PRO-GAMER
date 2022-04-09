package proyecto.programacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Hardware extends Producto {

    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cx;

    private String nombre;
    private String marca;
    private String modelo;
    private double precio;
    private int cantidad;
    private int codigo;

    private double total;
    private double descuento;
    
       public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    

    public Hardware(String nombre, String marca, String modelo, double precio, int cantidad, int codigo) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    public Hardware() {
    }


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
    
    
    //Método para agregar productos hardware
    @Override
    public int Create(Object g) {
       int crear=0;
       String SQL_CREATE = "INSERT INTO productohardware (nombre, marca, modelo,precio, cantidad,codigo) VALUES (?,?,?,?,?,?)";
        try{
            cx=Conectar.getConexion();
            ps=cx.prepareStatement(SQL_CREATE);
            ps.setString(1, this.getNombre());
            ps.setString(2, this.getMarca());
            ps.setString (3, this.getModelo());
            ps.setDouble(4, this.getPrecio());
            ps.setInt(5, this.getCantidad());
            ps.setInt(6, this.getCodigo());
            crear=ps.executeUpdate();
            
            System.out.println("Producto de Hardware Registrado con Exito!");
            
        }catch(Exception e){
            System.out.println("Error: " +e);
        }
        
        return crear;
    }
    
    
    //Método para mostrar la tabla de productos hardware
    @Override
    public List readAll() {
    
        List<Producto> listaRA=new ArrayList<>();
        
        String SQL_READALL = "SELECT * FROM productohardware";
        
        try{
            cx=Conectar.getConexion();
            ps=cx.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            System.out.println("Lista de Productos de Hardware!");
            while(rs.next()){
                
                Hardware HardwareRA = new Hardware();
                
                HardwareRA.setNombre(rs.getString(1));
                HardwareRA.setMarca(rs.getString(2));
                HardwareRA.setModelo(rs.getString(3));
                HardwareRA.setPrecio(rs.getDouble(4));
                HardwareRA.setCantidad(rs.getInt(5));
                HardwareRA.setCodigo(rs.getInt(6));
               
                listaRA.add(HardwareRA);
            } 
        }catch  (SQLException e){
            System.out.println("Error: " +e);
        }
     return listaRA;  
    }   
    
    //Método de búsqueda por precio
    @Override
    public List<Hardware> Buscar(double key) {
        
    String SQL_READ = "SELECT * FROM productohardware WHERE precio = ?";
        
       Hardware hardRead = new Hardware();
       System.out.println("Busqueda de Producto de Hardware!");
       List<Hardware> listaR =new ArrayList<>();
       try{
           cx = Conectar.getConexion();
           ps = cx.prepareStatement(SQL_READ);
           ps.setDouble(1, key);
           rs = ps.executeQuery();
           while(rs.next()){
                hardRead.setNombre(rs.getString(1));
                hardRead.setMarca(rs.getString(2));
                hardRead.setModelo(rs.getString(3));
                hardRead.setPrecio(rs.getDouble(4));
                hardRead.setCantidad(rs.getInt(5));
                hardRead.setCodigo(rs.getInt(6));
               listaR.add(hardRead);
           }
           }catch(Exception e){
                   System.out.println("Error: " +e);
           }
           return listaR;
       }
    
    //Método para eliminar por código
    @Override
    public int Delete(int key) {
         int delete=0;
         String SQL_DELETE = "DELETE FROM productohardware WHERE codigo = ?";
        try{
           cx=Conectar.getConexion();
           ps=cx.prepareStatement(SQL_DELETE);
           ps.setInt(1,key);
           delete=ps.executeUpdate();
           System.out.println("Producto de Hardware Eliminado con Exito!");
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
        return delete;
    }



