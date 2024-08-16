package Capa_Negocio;

import Capa_Datos.*;
import Conexiones.ConexionMySQL1;
import java.sql.Connection;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class neg_Mesero {

    String mensaje = "";
    MeseroDAO mesero_dao = new MeseroDAO();
    ConexionMySQL1 conex = new ConexionMySQL1();
    JasperReport reporte;

    public String agregarMesero(Mesero mesero) {
        Connection cn = conex.conexion();
        try {
            mensaje = mesero_dao.agregarMesero(cn, mesero);
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

    public String actualizarMesero(Mesero mesero) {
        Connection cn = conex.conexion();
        try {
            mensaje = mesero_dao.actualizarMesero(cn, mesero);
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

    public void listarMesero(JTable tabla) {
        Connection cn = conex.conexion();
        mesero_dao.listar_mesero(cn, tabla);
        try {
            cn.close();
        } catch (Exception e) {
        }

    }

    public String eliminarMesero(int cod) {
        Connection cn = conex.conexion();
        try {
            mensaje = mesero_dao.eliminarMesero(cn, cod);
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

    public void mostrar_reporte(int cod) {

        Connection cn = conex.conexion();
        Map parametros = new Hashtable();
        parametros.put("CodMesero", cod);

        try {
            // Cargar y compilar el archivo JRXML
            JasperReport jasperReport = JasperCompileManager.compileReport("src/main/java/Capa_Reportes/Mesero.jrxml");

            // Crear un mapa de parámetros
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("CodMesero", cod);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, cn);
            JasperViewer ver = new JasperViewer(jasperPrint, false);
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
