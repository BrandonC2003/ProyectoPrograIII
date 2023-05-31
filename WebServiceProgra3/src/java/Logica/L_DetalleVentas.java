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
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

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
    
    public boolean modificarDetalle(DetalleVenta objDetalle){
        int confirmacion = 0;
        try (Connection conexion = Conexion.obtenerConexion();) {
            //Preparar la llamada al procedimiento almacenado
            String procedimiento = "{call sp_modificarDetalle(?, ?, ?, ?, ?)}";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
            
            //Establecer los parametros del procedimeitno almacenado
            llamada.setInt(1,objDetalle.getIdDetalle());
            llamada.setInt(2,objDetalle.getIdProducto());
            llamada.setInt(3,objDetalle.getCantidad());
            llamada.setString(4,objDetalle.getUsuarioActualiza());
            
            //registrar parametro de salida
            llamada.registerOutParameter(5, java.sql.Types.INTEGER);
            
            //Ejecutar el procedimiento alamcenado
            llamada.execute();
            
            //Recuperar el parametro de salida
            confirmacion = llamada.getInt(5);
            
            //liberar recursos
            llamada.close();
            
            //si la confirmacion es 1 retornara true sino false
            return confirmacion==1 ? true : false;
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarDetalleVenta(int idDetalle){
        try(Connection conexion = Conexion.obtenerConexion();){
            String procedimiento = "{call sp_eliminarDetalle(?)}";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
            
            //establecer los parametros para el delete
            llamada.setInt(1, idDetalle);
            
            //ejecutar la llamada
            llamada.execute();
            
            llamada.close();
            
            return true;
            
        }catch(SQLException e){
            System.out.println("Error:" +e.getMessage());
            return false;
        }
    }
    
    public boolean confirmarVenta(String usuarioInserta){
        try(Connection conexion = Conexion.obtenerConexion();){
            String procedimiento = "{call sp_ConfirmarVenta(?)}";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
            
            //establecer los parametros para el delete
            llamada.setString(1, usuarioInserta);
            
            //ejecutar la llamada
            llamada.execute();
            
            llamada.close();
            
            return true;
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<DetalleVenta> obtenerDetalles(){
        ArrayList<DetalleVenta> lista = new ArrayList<DetalleVenta>();
        String consulta = "SELECT * From detalleVenta";
        try(Connection conexion = Conexion.obtenerConexion()){
            
            Statement statement = conexion.createStatement();
            
            // Ejecutar la consulta y obtener el resultado en un objeto ResultSet
            ResultSet resultSet = statement.executeQuery(consulta);
            
            // Recorrer el resultado y procesar los datos
            while (resultSet.next()) {
                DetalleVenta nuevoDetalle = new DetalleVenta();
                
                nuevoDetalle.setIdDetalle(resultSet.getInt("IdDetalle"));
                nuevoDetalle.setIdProducto(resultSet.getInt("IdProducto"));
                nuevoDetalle.setIdVenta(resultSet.getInt("IdVenta"));
                nuevoDetalle.setCantidad(resultSet.getInt("Cantidad"));
                nuevoDetalle.setPrecio(resultSet.getDouble("Precio"));
                nuevoDetalle.setDescuento(resultSet.getDouble("Descuento"));
                nuevoDetalle.setUsuarioInserta(resultSet.getString("UsuarioInserta"));
                nuevoDetalle.setFechaInserta(resultSet.getDate("FechaInserta"));
                nuevoDetalle.setUsuarioActualiza(resultSet.getString("UsuarioActualiza"));
                nuevoDetalle.setFechaActualiza(resultSet.getDate("FechaActualiza"));
                
                lista.add(nuevoDetalle);
            }
            
            // Cerrar recursos
            resultSet.close();
            statement.close();
            
            return lista;
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
            lista = null;
        }
        
        return lista;
    }
}
