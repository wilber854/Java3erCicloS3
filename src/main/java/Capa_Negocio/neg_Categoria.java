package Capa_Negocio;

import Capa_Datos.*;
import Conexiones.ConexionMySQL1;
import java.sql.*;
import javax.swing.JTable;

public class neg_Categoria {

    String mensaje = "";
    CategoriaDAO cat_dao = new CategoriaDAO();
    ConexionMySQL1 conex = new ConexionMySQL1();

    public String agregarCategoria(Categoria cat) {
        Connection cn = conex.conexion();
        try {
            mensaje = cat_dao.agregarCategoria(cn, cat);
        } catch (Exception e) {
            mensaje = mensaje + e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return mensaje;
    }

    public String actualizarCategoria(Categoria cat) {
        Connection cn = conex.conexion();
        try {
            mensaje = cat_dao.actualizarCategoria(cn, cat);
        } catch (Exception e) {
            mensaje = mensaje + e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return mensaje;
    }

    public void listarCategoria(JTable tabla) {
        Connection cn = conex.conexion();
        cat_dao.listar_categoria(cn, tabla);
        try {
            cn.close();
        } catch (Exception e) {
        }

    }
    
    public String eliminarCategoria(int cod){
        Connection cn = conex.conexion();
        try {
            mensaje=cat_dao.eliminarCategoria(cn, cod);
        } catch (Exception e) {
            mensaje=mensaje+e.getMessage();
        }finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return mensaje;
    }
}
