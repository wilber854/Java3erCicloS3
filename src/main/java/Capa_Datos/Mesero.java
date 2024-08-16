package Capa_Datos;

import java.sql.Date;

public class Mesero {
   int idMesero;
   String dni;
   String nombre;
   String apellido;
   Date fec_nacimiento;
   String telefono;
   String direccion;

    public Mesero(int idMesero, String dni, String nombre, String apelido, Date fec_nacimiento, String telefono, String direccion) {
        this.idMesero = idMesero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apelido;
        this.fec_nacimiento = fec_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Mesero() {
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFec_nacimiento() {
        return fec_nacimiento;
    }

    public void setFec_nacimiento(Date fec_nacimiento) {
        this.fec_nacimiento = fec_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   
   
   
}
