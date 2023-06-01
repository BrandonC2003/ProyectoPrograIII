/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Modelos.Usuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author gerso
 */
public class L_Usuarios {
    
    
    public boolean agregarUsuarios(Usuarios objUsuario){
        int confirmacion = 0;
        try (Connection conexion = Conexion.obtenerConexion();) {
    
    String procedimiento = "{call sp_agregarusuario(?, ?, ?, ?, ?, ?, ?)}";
    CallableStatement llamada = conexion.prepareCall(procedimiento);
    
     llamada.setString(1,objUsuario.getNombreUsuario());
     llamada.setString(2,objUsuario.getNombre());
     llamada.setString(3,objUsuario.getApellido());
     llamada.setString(4,objUsuario.getClave());
     llamada.setString(5,objUsuario.getTelefono());
     llamada.setInt(6,objUsuario.getEstado());
     llamada.setString(7,objUsuario.getNivel());
     
     llamada.execute();
     
     llamada.close();
     
             return true;
        } catch (SQLException e) {
            System.out.println("este es el mensaje: "+e.getMessage());
            return false;
        }
    }
    
 public boolean modificarUsuario(Usuarios objUsuario){
        int confirmacion = 0;
        try (Connection conexion = Conexion.obtenerConexion();) {
            //Preparar la llamada al procedimiento almacenado
            String procedimiento = "{call sp_agregarusuario(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
    
            llamada.setString(1,objUsuario.getNombreUsuario());
            llamada.setString(2,objUsuario.getNombre());
            llamada.setString(3,objUsuario.getApellido());
            llamada.setString(4,objUsuario.getClave());
            llamada.setString(5,objUsuario.getTelefono());
            llamada.setInt(6,objUsuario.getEstado());
            llamada.setString(7,objUsuario.getNivel());
            llamada.registerOutParameter(5, java.sql.Types.INTEGER);
            
            llamada.execute();
            
            confirmacion = llamada.getInt(5);
            
            llamada.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
 
   public ArrayList<Usuarios> obtenerUsuarios(){
        ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
        String consulta = "SELECT * From usuarios";
        try(Connection conexion = Conexion.obtenerConexion()){
            
            Statement statement = conexion.createStatement();
            
            // Ejecutar la consulta y obtener el resultado en un objeto ResultSet
            ResultSet resultSet = statement.executeQuery(consulta);
            
            // Recorrer el resultado y procesar los datos
            while (resultSet.next()) {
                Usuarios nuevoUsuario = new Usuarios();
                
                nuevoUsuario.setNombreUsuario(resultSet.getString("NombreUsuario"));
                nuevoUsuario.setNombre(resultSet.getString("Nombre"));
                nuevoUsuario.setApellido(resultSet.getString("Apellido"));
                nuevoUsuario.setClave(resultSet.getString("Clave"));
                nuevoUsuario.setTelefono(resultSet.getString("Telefono"));
                nuevoUsuario.setEstado(resultSet.getInt("Estado"));
                nuevoUsuario.setNivel(resultSet.getString("Nivel"));
                nuevoUsuario.setUsuarioInserta(resultSet.getString("UsuarioInserta"));
                nuevoUsuario.setFechaInserta(resultSet.getDate("FechaInserta"));
                nuevoUsuario.setUsuarioActualiza(resultSet.getString("UsuarioActualiza"));
                nuevoUsuario.setFechaActualiza(resultSet.getDate("FechaActualiza"));
                
                lista.add(nuevoUsuario);
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
   
    public ArrayList<Usuarios> buscarUsuarios(String NombreUsuario){
        ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
        String consulta = "SELECT * FROM usuarios where NombreUsuario = '"+NombreUsuario+"';";
        try(Connection conexion = Conexion.obtenerConexion()){
            
            Statement statement = conexion.createStatement();
            
            // Ejecutar la consulta y obtener el resultado en un objeto ResultSet
            ResultSet resultSet = statement.executeQuery(consulta);
            
            // Recorrer el resultado y procesar los datos
            while (resultSet.next()) {
                Usuarios nuevoUsuario = new Usuarios();
                
                nuevoUsuario.setNombreUsuario(resultSet.getString("NombreUsuario"));
                nuevoUsuario.setNombre(resultSet.getString("Nombre"));
                nuevoUsuario.setApellido(resultSet.getString("Apellido"));
                nuevoUsuario.setClave(resultSet.getString("Clave"));
                nuevoUsuario.setTelefono(resultSet.getString("Telefono"));
                nuevoUsuario.setEstado(resultSet.getInt("Estado"));
                nuevoUsuario.setNivel(resultSet.getString("Nivel"));
                nuevoUsuario.setUsuarioInserta(resultSet.getString("UsuarioInserta"));
                nuevoUsuario.setFechaInserta(resultSet.getDate("FechaInserta"));
                nuevoUsuario.setUsuarioActualiza(resultSet.getString("UsuarioActualiza"));
                nuevoUsuario.setFechaActualiza(resultSet.getDate("FechaActualiza"));
                
                lista.add(nuevoUsuario);
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
