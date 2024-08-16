package Capa_Datos;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MesaDAO {

    String mensaje;
    PreparedStatement pst;

    public String agregarMesa(Connection cn, Mesa mesa) {

        String sql = "insert into mesa (nombre,ubicacion,estado) values (?,?,?) ";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, mesa.getNombre());
            pst.setString(2, mesa.getUbicacion());
            pst.setBoolean(3, mesa.isEstado());
            pst.execute();
            mensaje = "Mesa Agregada Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al agregar Mesa";
        }
        return mensaje;
    }

    public String actualizarMesa(Connection cn, Mesa mesa) {

        String sql = "update mesa set nombre=?,ubicacion=?,estado=? where idmesa=? ";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, mesa.getNombre());
            pst.setString(2, mesa.getUbicacion());
            pst.setBoolean(3, mesa.isEstado());
            pst.setInt(4, mesa.idmesa);
            pst.execute();
            mensaje = "Mesa Actualizada Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al agregar Mesa";
        }
        return mensaje;
    }

    public void listar_mesa(Connection con, JTable tabla) {
        DefaultTableModel modelo;
        String sql = "select * from mesa order by idmesa";
        ResultSet rs;
        String filas[] = new String[4];
        String[] columnas = {"Codigo", "Nombre", "Ubicacion", "Estado"};
        modelo = new DefaultTableModel(null, columnas);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {

        }
    }

    public String eliminarMesa(Connection cn, int cod) {
        String sql = "Delete from mesa where idmesa=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, cod);
            pst.execute();
            mensaje = "Mesa eliminada correctamente";
            pst.close();
        } catch (Exception e) {
            mensaje = "Error al eliminar mesa";
        }

        return mensaje;
    }

}
