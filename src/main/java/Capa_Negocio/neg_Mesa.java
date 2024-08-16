package Capa_Negocio;

import Capa_Datos.*;
import Conexiones.ConexionMySQL1;
import java.sql.Connection;
import javax.swing.JTable;

public class neg_Mesa {

    String mensaje = "";
    MesaDAO mesa_dao = new MesaDAO();
    ConexionMySQL1 conex = new ConexionMySQL1();

    public String agregarMesa(Mesa mesa) {
        Connection cn = conex.conexion();
        try {
            mensaje = mesa_dao.agregarMesa(cn, mesa);
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

    public String actualizarMesa(Mesa mesa) {
        Connection cn = conex.conexion();
        try {
            mensaje = mesa_dao.actualizarMesa(cn, mesa);
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

    public void listarMesa(JTable tabla) {
        Connection cn = conex.conexion();
        mesa_dao.listar_mesa(cn, tabla);
        try {
            cn.close();
        } catch (Exception e) {
        }

    }

    public String eliminarMesa(int cod) {
        Connection cn = conex.conexion();
        try {
            mensaje = mesa_dao.eliminarMesa(cn, cod);
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
}
