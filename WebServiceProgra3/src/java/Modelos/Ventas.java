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
public class Ventas {
    
    private int idVenta;
    private double montoTotal;
    private double descuentoTotal;
    private LocalDateTime fechaHora;
    private String usuarioInserta;
    private LocalDateTime fechaInserta;
    private String usuarioActualiza;
    private LocalDateTime fechaActualiza;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
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
