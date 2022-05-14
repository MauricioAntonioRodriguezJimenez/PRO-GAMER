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
            System.out.println("Error: No se a podido registrar el producto...");
        }
        
        return crear;
    }
    
    
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
            System.out.println("Error: No se puede mostrar la tabla en pantalla");
        }
     return lista;  
    }   
    
    @Override
    public List<Software> Buscar(double key) {
   
        String SQL_READ = "SELECT nombre, marca, modelo FROM productosoftware WHERE precio = ?";
        
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
               lista.add(softRead);

           }
           }catch(Exception e){
                   System.out.println("Error: No se pudo encontrar el producto en la tabla" );
           }
           return lista;
       }
    
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
            System.out.println("Error: No se pudo eliminar el producto");
        }
        return delete;
    }



}
