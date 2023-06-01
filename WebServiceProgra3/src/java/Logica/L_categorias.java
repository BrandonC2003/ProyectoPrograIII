/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelos.Categorias;
import Modelos.Ventas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author ea521
 */
public class L_categorias {
     public boolean insertarCategorias(Categorias objCategorias){
        
        try (Connection conexion = Conexion.obtenerConexion();){
 
            String sqlCategoria = "INSERT INTO categorias (Categoria,Descripcion) VALUES(?,?)";
            
            CallableStatement categoria = conexion.prepareCall(sqlCategoria);
            
            
            categoria.setString(1, objCategorias.getCategoria());
            categoria.setString(2, objCategorias.getDescripcion());
            
            categoria.execute();
            
            categoria.close();
           
            return true;
        } catch (Exception e) {
            System.out.println("Error: Al insertar datos. "+e.getMessage());
            return false;
        }
    }
    public boolean modificarCategoria(Categorias objCategorias){
         
        try (Connection conexion = Conexion.obtenerConexion();){
 
            String sqlCategoria = "UPDATE categorias set Categria = ? , Descripcion = ? where IdCategoria = ?";
            
            CallableStatement categoria = conexion.prepareCall(sqlCategoria);
            
            
            categoria.setString(1, objCategorias.getCategoria());
            categoria.setString(2, objCategorias.getDescripcion());
            categoria.setInt(3, objCategorias.getIdCategoria());
            
            categoria.execute();
            
            categoria.close();
           
            return true;
        } catch (Exception e) {
            System.out.println("Error: al modificar datos. "+e.getMessage());
            return false;
        }
    }
    public ArrayList<Categorias>listarCategoria() throws SQLException{
        ArrayList<Categorias> lista = new ArrayList<Categorias>();
        String consulta = "SELECT * From categorias;";
        
        try (Connection conexion = Conexion.obtenerConexion()){
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            
            while (resultSet.next()) {
                Categorias nuevaCategoria = new Categorias();
                
                nuevaCategoria.setIdCategoria(resultSet.getInt("IdCategoria"));
                nuevaCategoria.setCategoria(resultSet.getString("Categoria"));
                nuevaCategoria.setDescripcion(resultSet.getString("Descripcion"));
                
                lista.add(nuevaCategoria);
            }
            resultSet.close();
            statement.close();
  
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            lista = null;
        }
        return lista;
    }
}
     
     
     
     

