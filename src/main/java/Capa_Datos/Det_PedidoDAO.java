package Capa_Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Det_PedidoDAO {

    String mensaje;
    PreparedStatement pst;

    public String agregarDetPedido(Connection cn, Det_Pedido det_pedido) {

        String sql = "insert into detalle_pedido (idPedido,idProducto,cantidad,subtotal) values (?,?,?,?) ";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, det_pedido.getIdPedido());
            pst.setInt(2, det_pedido.getIdProducto());
            pst.setInt(3, det_pedido.getCantidad());
            pst.setDouble(4, det_pedido.getSubtotal());
            pst.execute();
            mensaje = "Detalle Pedido Agregado Correctamente";
            pst.close();

        } catch (Exception e) {
            mensaje = "Error al agregar Detalle Pedido";
        }
        return mensaje;
    }
}
