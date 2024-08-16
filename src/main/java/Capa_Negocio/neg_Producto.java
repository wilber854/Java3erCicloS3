/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import Capa_Datos.*;
import Conexiones.ConexionMySQL1;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author COOR ETI
 */
public class neg_Producto {

    String mensaje = "";
    ProductoDAO producto_dao = new ProductoDAO();
    ConexionMySQL1 conex = new ConexionMySQL1();

    public String agregarProducto(Producto producto) {
        Connection cn = conex.conexion();
        try {
            mensaje = producto_dao.agregarProducto(cn, producto);
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

    public String actualizarProducto_cf(Producto producto) {
        Connection cn = conex.conexion();
        try {
            mensaje = producto_dao.actualizarProducto_cf(cn, producto);
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

    public String actualizarProducto_sf(Producto producto) {
        Connection cn = conex.conexion();
        try {
            mensaje = producto_dao.actualizarProducto_sf(cn, producto);
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

    public void listarProducto(JTable tabla) {
        Connection cn = conex.conexion();
        producto_dao.listar_producto(cn, tabla);
        try {
            cn.close();
        } catch (Exception e) {
        }

    }

    public String eliminarProducto(int cod) {
        Connection cn = conex.conexion();
        try {
            mensaje = producto_dao.eliminarProducto(cn, cod);
        } catch (Exception e) {
            mensaje = mensaje + e.getMessage();
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return mensaje;
    }
    
    public Image recuperarfoto(int codigo) {
        Connection cn = conex.conexion();
        Image r = producto_dao.recuperarfotos(codigo, cn);
        try {
            cn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
}
