/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelos.Categorias;
import java.sql.CallableStatement;
import java.sql.Connection;



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
 
            String sqlCategoria = "UPDATE INTO categorias (Categoria,Descripcion) VALUES(?,?)";
            
            CallableStatement categoria = conexion.prepareCall(sqlCategoria);
            
            
            categoria.setString(1, objCategorias.getCategoria());
            categoria.setString(2, objCategorias.getDescripcion());
            
            categoria.execute();
            
            categoria.close();
           
            return true;
        } catch (Exception e) {
            System.out.println("Error: al modificar datos. "+e.getMessage());
            return false;
        }
    }
    public boolean listarCategoria(Categorias objCategorias){
        try (Connection conexion = Conexion.obtenerConexion();){
 
            String sqlCategoria = "SELECT * FROM categorias (Categoria,Descripcion) VALUES(?,?)";
            
            CallableStatement categoria = conexion.prepareCall(sqlCategoria);
            
            
            categoria.setString(1, objCategorias.getCategoria());
            categoria.setString(2, objCategorias.getDescripcion());
            
            categoria.execute();
            
            categoria.close();
           
            return true;
        } catch (Exception e) {
            System.out.println("Error: al modificar datos. "+e.getMessage());
            return false;
        }
    }
}
     
     
     
     

