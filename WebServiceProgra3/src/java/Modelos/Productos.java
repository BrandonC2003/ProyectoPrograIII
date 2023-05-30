/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.time.LocalDateTime;

/**
 *
 * @author brand
 */
public class Productos {

    private int idProducto;
    private int idCategoria;
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private double descuento;
    private String usuarioInserta;
    private LocalDateTime fechaInserta;
    private String usuarioActualiza;
    private LocalDateTime fechaActualiza;
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getUsuarioInserta() {
        return usuarioInserta;
    }

    public void setUsuarioInserta(String usuarioInserta) {
        this.usuarioInserta = usuarioInserta;
    }

    public LocalDateTime getFechaInserta() {
        return fechaInserta;
    }

    public void setFechaInserta(LocalDateTime fechaInserta) {
        this.fechaInserta = fechaInserta;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public LocalDateTime getFechaActualiza() {
        return fechaActualiza;
    }

    public void setFechaActualiza(LocalDateTime fechaActualiza) {
        this.fechaActualiza = fechaActualiza;
    }
    
}
