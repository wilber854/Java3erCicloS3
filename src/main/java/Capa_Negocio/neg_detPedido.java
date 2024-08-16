package Capa_Negocio;

import Capa_Datos.*;
import Conexiones.ConexionMySQL1;
import java.sql.Connection;

public class neg_detPedido {

    String mensaje = "";
    Det_PedidoDAO det_pedido_dao = new Det_PedidoDAO();
    ConexionMySQL1 conex = new ConexionMySQL1();

    public String agregarDet_Pedido(Det_Pedido det_pedido) {
        Connection cn = conex.conexion();
        try {
            mensaje = det_pedido_dao.agregarDetPedido(cn, det_pedido);
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
}
