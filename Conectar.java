package proyecto.programacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private static final String URL  = "jdbc:mysql://localhost:3306/baseproyecto";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String Usuario = "root";
    private static final String Pass = "";
    private static Connection  conex = null;
    public static Connection getConexion(){
        try{
            if(conex ==null){
                Class.forName(Driver);
                conex=DriverManager.getConnection(URL, Usuario , Pass);
            }
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Error:  No se logro establecer conexion con la base");
        }
    return conex;
}
    
    


    //Prueba de Conexion a la base de Datos
    public static void pruebaConex() {
        if (Conectar.getConexion() != null) {
            System.out.println("Conexión a Base de Datos, ha sido correcta");
        } else {
            System.out.println("No se ha podido conectar a la base de datos");
        }

    }
}
