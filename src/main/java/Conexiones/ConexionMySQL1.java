package Conexiones;

import java.sql.*;

public class ConexionMySQL1 {

    String url = "jdbc:mysql://localhost:3307/bdVentasRestaurante";
    String usuario = "root";
    String pass = "";
    Connection cn;
    
    public Connection conexion() {
        try {
            //cargar el controlador
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        ConexionMySQL1 con=new ConexionMySQL1();
        con.conexion();
    }

}
