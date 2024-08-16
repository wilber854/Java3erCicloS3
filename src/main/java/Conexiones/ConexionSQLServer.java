package Conexiones;

import java.sql.*;

public class ConexionSQLServer {

    String url = "jdbc:sqlserver://localhost:1433;databasename=dbalu;"
            + "encrypt=true;trustServerCertificate=true";
    String usuario = "sa";
    String pass = "1234";
    Connection cn;
    
    public Connection conexion() {
        try {
            //cargar el controlador
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Establecer la conexion
             cn = DriverManager.getConnection(url, usuario, pass);

            if (cn != null) {
                System.out.println("Conexion Exitosa");
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("Controlador no encontrado " + e.getMessage());
        } catch (SQLException se) {
            System.err.println("error al conectar la BD " + se.getMessage());
        }
        return cn;
    }
    
    public static void main(String[] args) {
        ConexionSQLServer con=new ConexionSQLServer();
        con.conexion();
    }

}
