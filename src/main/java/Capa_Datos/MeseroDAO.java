package Capa_Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MeseroDAO {

    String mensaje;
    PreparedStatement pst;

    public String agregarMesero(Connection cn, Mesero mesero) {

        String sql = "insert into mesero (dni,nombre,apellidos,fecha_nacimiento,telefono,direccion) values (?,?,?,?,?,?) ";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, mesero.getDni());
            pst.setString(2, mesero.getNombre());
            pst.setString(3, mesero.getApellido());
            pst.setDate(4, mesero.getFec_nacimiento());
            pst.setString(5, mesero.getTelefono());
            pst.setString(6, mesero.getDireccion());
            pst.execute();
            mensaje = "Mesero Agregado Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al agregar Mesero";
        }
        return mensaje;
    }

    public String actualizarMesero(Connection cn, Mesero mesero) {

        String sql = "update mesero set dni=?,nombre=?,apellidos=?,fecha_nacimiento=?,telefono=?,direccion=? where idmesero=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, mesero.getDni());
            pst.setString(2, mesero.getNombre());
            pst.setString(3, mesero.getApellido());
            pst.setDate(4, mesero.getFec_nacimiento());
            pst.setString(5, mesero.getTelefono());
            pst.setString(6, mesero.getDireccion());
            pst.setInt(7,mesero.getIdMesero());
            pst.execute();
            mensaje = "Mesero Actualizado Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al actualizar Mesero";
        }
        return mensaje;
    }

    public void listar_mesero(Connection con, JTable tabla) {
        DefaultTableModel modelo;
        String sql = "select * from mesero order by idmesero";
        ResultSet rs;
        String filas[] = new String[7];
        String[] columnas = {"Codigo", "DNI","Nombre", "Apellido", "Fecha de Nacimiento","Telefono","Direccion"};
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

    public String eliminarMesero(Connection cn, int cod) {
        String sql = "Delete from mesero where idmesero=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, cod);
            pst.execute();
            mensaje = "Mesero eliminado correctamente";
            pst.close();
        } catch (Exception e) {
            mensaje = "Error al eliminar mesero";
        }

        return mensaje;
    }

}
