package proyecto.programacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    //Hacer la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/baseproyecto";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String Usuario = "root";
    private static final String Pass = "";
    private static Connection conex = null;

    public static Connection getConexion() {
        try {
            if (conex == null) {
                Class.forName(Driver);
                conex = DriverManager.getConnection(URL, Usuario, Pass);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        return conex;
    }
}
