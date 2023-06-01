/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Modelos.DetalleVenta;
import Modelos.Productos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author brand
 */
public class L_Productos {
    
    public boolean insertarProductos(Productos producto){
        try(Connection conexion = Conexion.obtenerConexion();){
            String procedimiento = "insert into productos(IdCategoria,nombreProducto,Cantidad,PrecioUnitario,Descuento,UsuarioInserta,FechaInserta) values"
                    + "(?,?,?,?,?,?,NOW());";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
            
            //establecer los parametros para el delete
            llamada.setInt(1, producto.getIdCategoria());
            llamada.setString(2,producto.getNombreProducto());
            llamada.setInt(3,producto.getCantidad());
            llamada.setDouble(4,producto.getPrecioUnitario());
            llamada.setDouble(5, producto.getDescuento());
            llamada.setString(6, producto.getUsuarioInserta());
            //ejecutar la llamada
            llamada.execute();
            
            llamada.close();
            
            return true;
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public boolean modificarProductos(Productos producto){
        try(Connection conexion = Conexion.obtenerConexion();){
            String procedimiento = "UPDATE productos set IdCategoria = ?, NombreProducto = ?, Cantidad = ?, PrecioUnitario = ?, Descuento = ?, UsuarioActualiza=?,"
                    + " FechaActualiza = NOW() where IdProducto = ?";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
            
            //establecer los parametros para el delete
            llamada.setInt(1, producto.getIdCategoria());
            llamada.setString(2,producto.getNombreProducto());
            llamada.setInt(3,producto.getCantidad());
            llamada.setDouble(4,producto.getPrecioUnitario());
            llamada.setDouble(5, producto.getDescuento());
            llamada.setString(6, producto.getUsuarioActualiza());
            llamada.setInt(7, producto.getIdProducto());
            //ejecutar la llamada
            llamada.execute();
            
            llamada.close();
            
            return true;
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public boolean agregarProductos(Productos producto){
        try(Connection conexion = Conexion.obtenerConexion();){
            String procedimiento = "{call sp_agregarproductos(?,?)}";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
            
            //establecer los parametros para el delete
            llamada.setInt(1, producto.getIdProducto());
            llamada.setInt(2, producto.getCantidad());
            //ejecutar la llamada
            llamada.execute();
            
            llamada.close();
            
            return true;
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Productos> listarProductos(){
        ArrayList<Productos> lista = new ArrayList<Productos>();
        String consulta = "SELECT * From productos;";
        try(Connection conexion = Conexion.obtenerConexion()){
            
            Statement statement = conexion.createStatement();
            
            // Ejecutar la consulta y obtener el resultado en un objeto ResultSet
            ResultSet resultSet = statement.executeQuery(consulta);
            
            // Recorrer el resultado y procesar los datos
            while (resultSet.next()) {
                Productos nuevoProducto = new Productos();
                
                nuevoProducto.setIdProducto(resultSet.getInt("IdProducto"));
                nuevoProducto.setIdCategoria(resultSet.getInt("IdCategoria"));
                nuevoProducto.setNombreProducto(resultSet.getString("nombreProducto"));
                nuevoProducto.setCantidad(resultSet.getInt("Cantidad"));
                nuevoProducto.setPrecioUnitario(resultSet.getDouble("PrecioUnitario"));
                nuevoProducto.setDescuento(resultSet.getDouble("Descuento"));
                nuevoProducto.setUsuarioInserta(resultSet.getString("UsuarioInserta"));
                nuevoProducto.setFechaInserta(resultSet.getDate("FechaInserta"));
                nuevoProducto.setUsuarioActualiza(resultSet.getString("UsuarioActualiza"));
                nuevoProducto.setFechaActualiza(resultSet.getDate("FechaActualiza"));
                
                lista.add(nuevoProducto);
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
