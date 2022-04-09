package proyecto.programacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Empleado implements CRUD {

    private String nombre;
    private String apellido;
    private int ID;
    private char sexo;
    private int fechaNacimiento;

    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cx;

    //Metodos Constructores 
    public Empleado(String _nombre, String _apellido, int _ID, char _sexo, int _fechaNacimiento) {
        this.nombre = _nombre;
        this.apellido = _apellido;
        this.ID = _ID;
        this.sexo = _sexo;
        this.fechaNacimiento = _fechaNacimiento;
    }

    public Empleado(String nombre, String apellido, char sexo, int fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleado() {
    }

    //Metodos de Modificar el Nombre del Empleado
    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    //Metodos de Modificar el Apellido del Empleado
    public void setApellido(String _apellido) {
        this.apellido = _apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    //Metodos para modificar el ID del Empleado
    public void setID(int _ID) {
        this.ID = _ID;
    }

    public int getID() {
        return this.ID;
    }

    // Metodos para modificar el Sexo del Empleado
    public void setSexo(char _sexo) {
        this.sexo = _sexo;
    }

    //Metodo para saber si el Empleado es hombre o mujer.  
    public String getSexo() {
        char sex = "M".charAt(0);

        if (sex == this.sexo) {
            return "MASCULINO";

        } else {
            return "FEMENINO";
        }
    }

    //Metodo para Modificar la Fecha de Nacimiento del Empleado
    public void setFechaNacimiento(int _fechaNacimiento) {
        this.fechaNacimiento = _fechaNacimiento;
    }

    // Metodo para Calcular la Edad del Empleado
    public int getEdad() {
        int edad;
        edad = 2022 - fechaNacimiento;
        return edad;
    }

    //Método para agregar empleados
    @Override
    public int Create(Object g) {
        int crear = 0;
        String SQL_CREATE = "INSERT INTO empleado (nombre, apellido,ID,sexo,edad) VALUES (?,?,?,?,?)";
        try {
            cx = Conectar.getConexion();
            ps = cx.prepareStatement(SQL_CREATE);
            ps.setString(1, this.getNombre());
            ps.setString(2, this.getApellido());
            ps.setInt(3, this.getID());
            ps.setString(4, this.getSexo());
            ps.setInt(5, this.getEdad());
            crear = ps.executeUpdate();
            System.out.println("Empleado Registrado con exito!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return crear;
    }

    //Muestra la lista de empleados
    @Override
    public List readAll() {
        List<Empleado> listaRA =new ArrayList<>();
        
        String SQL_READALL = "SELECT * FROM empleado";
        System.out.println("lista de empleados actual!");
        try{
            cx=Conectar.getConexion();
            ps=cx.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Empleado empleadosRA = new Empleado();
                
                empleadosRA.setNombre(rs.getString(1));
                empleadosRA.setApellido(rs.getString(2));
                empleadosRA.setID(rs.getInt(3));
                empleadosRA.setSexo(rs.getString(4).charAt(sexo));
                empleadosRA.setFechaNacimiento(rs.getInt(5));
                
               
                listaRA.add(empleadosRA);
            } 
        }catch  (SQLException e){
            System.out.println("Error: " +e);
        }
     return listaRA;  

    }

    //Método de busqueda por  ID
    @Override
    public List Buscar(double key) {
        
        String SQL_READ = "SELECT * FROM empleado WHERE ID = ?";

        Empleado empRead = new Empleado();
        
        List<Empleado> listaR = new ArrayList<>();
        
        try {
            System.out.println("Busqueda de ID de Empleados!");
            cx = Conectar.getConexion();
            ps = cx.prepareStatement(SQL_READ);
            ps.setDouble(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                empRead.setNombre(rs.getString(1));
                empRead.setApellido(rs.getString(2));
                empRead.setID(rs.getInt(3));
                empRead.setSexo(rs.getString(4).charAt(sexo));
                empRead.setFechaNacimiento(rs.getInt(5));
                listaR.add(empRead);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return listaR;
    }


    
    //Método para la eliminacion de empleados por ID
    @Override
    public int Delete(int key) {
        int delete = 0;
        String SQL_DELETE = "DELETE FROM empleado WHERE ID = ?";
        try {
            cx = Conectar.getConexion();
            ps = cx.prepareStatement(SQL_DELETE);
            ps.setInt(1, key);
            delete = ps.executeUpdate();
            System.out.println("ID de empleado Eliminado con Exito!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return delete;
    }
}
