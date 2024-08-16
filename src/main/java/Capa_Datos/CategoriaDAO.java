package Capa_Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CategoriaDAO {

    String mensaje;
    PreparedStatement pst;

    public String agregarCategoria(Connection cn, Categoria cat) {

        String sql = "insert into categoria (nombre,descripcion) values (?,?) ";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, cat.getNombre());
            pst.setString(2, cat.getDescripcion());
            pst.execute();
            mensaje = "Categoria Agregada Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al agregar Categoria";
        }
        return mensaje;
    }

    public String actualizarCategoria(Connection cn, Categoria cat) {

        String sql = "update categoria set nombre=?,descripcion=? where idCategoria=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, cat.getNombre());
            pst.setString(2, cat.getDescripcion());
            pst.setInt(3, cat.idCategoria);
            pst.execute();
            mensaje = "Categoria Actualizada Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al Actualizar Categoria";
        }
        return mensaje;
    }

    public void listar_categoria(Connection con, JTable tabla) {
        DefaultTableModel modelo;
        String sql = "select * from categoria order by idcategoria";
        ResultSet rs;
        String[] columnas = {"Codigo", "Nombre", "Descripcion"};
        String filas[] = new String[columnas.length];
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

    public String eliminarCategoria(Connection cn, int cod) {
        String sql = "Delete from categoria where idcategoria=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, cod);
            pst.execute();
            mensaje = "Categoria eliminada correctamente";
            pst.close();
        } catch (Exception e) {
            mensaje = "Error al eliminar Categoria";
        }

        return mensaje;
    }
}
