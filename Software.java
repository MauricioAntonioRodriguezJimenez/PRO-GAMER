package proyecto.programacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Software extends Producto{
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cx;

    private String nombre;
    private String marca;
    private String modelo;
    private double precio;
    private int cantidad;
    private int codigo;


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

    public Software(String nombre, String marca, String modelo, double precio, int cantidad, int codigo) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }


    public Software() {
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
    

    //Método para agregar productos de software
    @Override
    public int Create(Object g) {
       int crear=0;
       String SQL_CREATE = "INSERT INTO productosoftware (nombre, marca, modelo,precio, cantidad,codigo) VALUES (?,?,?,?,?,?)";
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
            
            System.out.println("Producto de Software Registrado con Exito!");
            
        }catch(Exception e){
            System.out.println("Error: " +e);
        }
        
        return crear;
    }
    
    //Método de mostrar la tabla de los productos de software
    @Override
    public List readAll() {
    
        List<Software> lista = new ArrayList<>();
        
        String SQL_READALL = "SELECT * FROM productosoftware";
        
        try{
            cx=Conectar.getConexion();
            ps=cx.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            System.out.println("lista de Productos de Software!");
            while(rs.next()){
                
                Software softwareC = new Software();
                
                softwareC.setNombre(rs.getString(1));
                softwareC.setMarca(rs.getString(2));
                softwareC.setModelo(rs.getString(3));
                softwareC.setPrecio(rs.getDouble(4));
                softwareC.setCantidad(rs.getInt(5));
                softwareC.setCodigo(rs.getInt(6));
               
                lista.add(softwareC);
            } 
        }catch  (SQLException e){
            System.out.println("Error: " +e);
        }
     return lista;  
    }   
    //Método de busqueda por precios
    @Override
    public List<Software> Buscar(double key) {
    String SQL_READ = "SELECT * FROM productosoftware WHERE precio = ?";
        
       Software softRead = new Software();
       System.out.println("Busqueda de Producto de Software: ");
       List<Software> lista = new ArrayList<>();
       try{
           cx = Conectar.getConexion();
           ps = cx.prepareStatement(SQL_READ);
           ps.setDouble(1, key);
           rs = ps.executeQuery();
           while(rs.next()){
                softRead.setNombre(rs.getString(1));
                softRead.setMarca(rs.getString(2));
                softRead.setModelo(rs.getString(3));
                softRead.setPrecio(rs.getDouble(4));
                softRead.setCantidad(rs.getInt(5));
                softRead.setCodigo(rs.getInt(6));
               lista.add(softRead);
           }
           }catch(Exception e){
                   System.out.println("Error: " +e);
           }
           return lista;
       }
    //Método de eliminación por código 
    @Override
    public int Delete(int key) {
         int delete=0;
         String SQL_DELETE = "DELETE FROM productosoftware WHERE codigo = ?";
        try{
           cx=Conectar.getConexion();
           ps=cx.prepareStatement(SQL_DELETE);
           ps.setInt(1,key);
           delete=ps.executeUpdate();
           System.out.println("Producto de Software Eliminado con Exito!");
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
        return delete;
    }



}
