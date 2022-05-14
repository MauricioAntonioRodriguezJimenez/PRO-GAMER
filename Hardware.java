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
            System.out.println("Error: No se logro registrar el producto...");
        }
        
        return crear;
    }
    
    
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
            System.out.println("Error: No se puede mostrar la tabla en pantalla");
        }
     return listaRA;  
    }   
    
    @Override
    public List<Hardware> Buscar(double key) {
        
    String SQL_READ = "SELECT marca, modelo, precio FROM productohardware WHERE precio = ?";
        
       Hardware hardRead = new Hardware();
       System.out.println("Busqueda de Producto de Hardware!");
       List<Hardware> listaR =new ArrayList<>();
       try{
           cx = Conectar.getConexion();
           ps = cx.prepareStatement(SQL_READ);
           ps.setDouble(1, key);
           rs = ps.executeQuery();
           while(rs.next()){
               hardRead.setMarca(rs.getString(1));
               hardRead.setModelo(rs.getString(2));
               hardRead.setPrecio(rs.getDouble(3));
               listaR.add(hardRead);
           }
           }catch(Exception e){
                   System.out.println("Error: No se pudo encontrar el producto a buscar");
           }
           return listaR;
       }
    
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
            System.out.println("Error: No se pudo eliminar el producto de la tabal...");
        }
        return delete;
    }



}
