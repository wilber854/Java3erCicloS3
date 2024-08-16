package Capa_Negocio;

import Capa_Datos.*;
import Conexiones.ConexionMySQL1;
import java.sql.Connection;

public class neg_Pedido {

    String mensaje = "";
    PedidoDAO pedido_dao = new PedidoDAO();
    ConexionMySQL1 conex = new ConexionMySQL1();

    public String agregarPedido(Pedido pedido) {
        Connection cn = conex.conexion();
        try {
            mensaje = pedido_dao.agregarPedido(cn, pedido);
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
