package Capa_Datos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductoDAO {

    String mensaje;
    PreparedStatement pst;
    private Image data;

    public String agregarProducto(Connection cn, Producto pro) {

        String sql = "insert into producto (nombre,precio,imagen,idcategoria) values (?,?,?,?) ";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, pro.getNombre());
            pst.setDouble(2, pro.getPrecio());
            pst.setBinaryStream(3, pro.getFoto(), pro.getLongi());
            pst.setInt(4, pro.getIdcategoria());
            pst.execute();
            mensaje = "Producto Agregado Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al agregar Producto";
        }
        return mensaje;
    }

    public String actualizarProducto_sf(Connection cn, Producto pro) {

        String sql = "update Producto set nombre=?,precio=?,idcategoria=? where idproducto=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, pro.getNombre());
            pst.setDouble(2, pro.getPrecio());
            pst.setInt(3, pro.getIdcategoria());
            pst.setInt(4, pro.getIdProducto());
            pst.execute();
            mensaje = "Producto Actualizado Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al actualizar Producto";
        }
        return mensaje;
    }

    public String actualizarProducto_cf(Connection cn, Producto pro) {

        String sql = "update Producto set nombre=?,precio=?,imagen=?,idcategoria=? where idproducto=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, pro.getNombre());
            pst.setDouble(2, pro.getPrecio());
            pst.setBinaryStream(3,pro.getFoto(),pro.getLongi());
            pst.setInt(4, pro.getIdcategoria());
            pst.setInt(5, pro.getIdProducto());
            pst.execute();
            mensaje = "Producto Actualizado Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al actualizar Producto";
        }
        return mensaje;
    }

    public void listar_producto(Connection con, JTable tabla) {
        DefaultTableModel modelo;
        String sql = "select * from producto order by idproducto";
        ResultSet rs;
        String[] columnas = {"Codigo", "Nombre", "Precio", "Imagen", "Categoria"};
        Object filas[] = new Object[columnas.length];
        modelo = new DefaultTableModel(null, columnas);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                filas[0] = rs.getString(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getString(3);

                try {
                    byte[] bi = rs.getBytes(4);
                    BufferedImage image = null;
                    InputStream is = new ByteArrayInputStream(bi);
                    image = ImageIO.read(is);
                    ImageIcon imgIC = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    filas[3] = new JLabel(imgIC);
                } catch (Exception e) {
                    filas[3] = new JLabel("src\\Foto\\sinfoto.jpg");
                }
                filas[4] = rs.getInt(5);
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }

    public String eliminarProducto(Connection cn, int cod) {
        String sql = "Delete from Producto where idproducto=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, cod);
            pst.execute();
            mensaje = "Producto eliminado correctamente";
            pst.close();
        } catch (Exception e) {
            mensaje = "Error al eliminar Producto";
        }

        return mensaje;
    }

    public Image recuperarfotos(int codalu, Connection con) {
        try {
            String sql = "SELECT foto FROM alumno where idalumno= ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, codalu);
            ResultSet res = pst.executeQuery();
            int i = 0;
            while (res.next()) {
                //se lee la cadena de bytes de la base de datos
                byte[] b = res.getBytes(1);
                data = ConvertirImagen(b);
                i++;
            }
            res.close();

        } catch (IOException | SQLException ex) {

        }
        return data;
    }//end funcion

    private Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);

    }

}
