/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.util.Date;

/**
 *
 * @author brand
 */
public class Usuarios {
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private String clave;
    private String telefono;
    private int estado;
    private String nivel;
    private String usuarioInserta;
    private Date fechaInserta;
    private String usuarioActualiza;
    private Date fechaActualiza;
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.nombreUsuario = NombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String Clave) {
        this.clave = Clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    public int isEstado() {
        return estado;
    }

    public void setEstado(int Estado) {
        this.estado = Estado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String Nivel) {
        this.nivel = Nivel;
    }

    public String getUsuarioInserta() {
        return usuarioInserta;
    }

    public void setUsuarioInserta(String UsuarioInserta) {
        this.usuarioInserta = UsuarioInserta;
    }

    public Date getFechaInserta() {
        return fechaInserta;
    }

    public void setFechaInserta(Date FechaInserta) {
        this.fechaInserta = FechaInserta;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String UsuarioActualiza) {
        this.usuarioActualiza = UsuarioActualiza;
    }

    public Date getFechaActualiza() {
        return fechaActualiza;
    }

    public void setFechaActualiza(Date FechaActualiza) {
        this.fechaActualiza = FechaActualiza;
    }

    public int getEstado() {
        return this.estado;
    }
}
