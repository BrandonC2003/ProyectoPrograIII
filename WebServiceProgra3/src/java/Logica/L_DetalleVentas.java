/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Modelos.DetalleVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author brand
 */
public class L_DetalleVentas {
    
    public boolean insertarDetalleVenta(DetalleVenta objDetalle){
        int confirmacion = 0;
        try (Connection conexion = Conexion.obtenerConexion();) {
            //Preparar la llamada al procedimiento almacenado
            String procedimiento = "{call sp_InsertarDetalleVenta(?, ?, ?, ?)}";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
            
            //Establecer los parametros del procedimeitno almacenado
            llamada.setInt(1,objDetalle.getIdProducto());
            llamada.setInt(2,objDetalle.getCantidad());
            llamada.setString(3,objDetalle.getUsuarioInserta());
            
            //registrar parametro de salida
            llamada.registerOutParameter(4, java.sql.Types.INTEGER);
            
            //Ejecutar el procedimiento alamcenado
            llamada.execute();
            
            //Recuperar el parametro de salida
            confirmacion = llamada.getInt(4);
            
            //liberar recursos
            llamada.close();
            
            //si la confirmacion es 1 retornara true sino false
            return confirmacion==1 ? true : false;
        } catch (SQLException e) {
            System.out.println("este es el mensaje: "+e.getMessage());
            return false;
        }
    }
    
}
