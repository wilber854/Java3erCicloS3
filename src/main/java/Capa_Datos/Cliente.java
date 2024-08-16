
package Capa_Datos;

public class Cliente {
    int idCliente;
    String dni;
    String razon_social;

    public Cliente(int idCliente, String dni, String razon_social) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.razon_social = razon_social;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }
    
    
}
