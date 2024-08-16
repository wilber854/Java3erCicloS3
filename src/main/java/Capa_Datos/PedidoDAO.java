package Capa_Datos;

import java.sql.*;

public class PedidoDAO {
    String mensaje;
    PreparedStatement pst;

    public String agregarPedido(Connection cn, Pedido pedido) {

        String sql = "insert into Pedido (idMesa,idMesero,fecha,importe_total) values (?,?,?,?) ";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, pedido.getIdMesa());
            pst.setInt(2, pedido.getIdMesero());
            pst.setDate(3, pedido.getFecha());
            pst.setDouble(4,pedido.getImporte_total());
            pst.execute();
            mensaje = "Pedido Agregado Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al agregar Pedido";
        }
        return mensaje;
    }
}
