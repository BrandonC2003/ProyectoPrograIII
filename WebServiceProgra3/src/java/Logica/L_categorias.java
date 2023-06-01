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
     public boolean insertarCategorias(Categorias categorias){
        
        try (Connection conexion = Conexion.obtenerConexion();){
 
            String sqlCategoria = "INSERT INTO categorias (Categoria,Descripcion) VALUES(?,?)";
            
            CallableStatement categoria = conexion.prepareCall(sqlCategoria);
            
            
            categoria.setString(1, categorias.getCategoria());
            categoria.setString(2, categorias.getDescripcion());
            
            categoria.execute();
            
            categoria.close();
           
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
}
