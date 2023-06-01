/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author brand
 */
public class Conexion {
//<<<<<<< Updated upstream
    
  
//=======

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bar1";
//>>>>>>> Stashed changes
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    
    public static Connection obtenerConexion() throws SQLException {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("SE CONECTO A LA BASE DE DATOS...");
        }catch(ClassNotFoundException e){
            System.out.println("NO SE CONECTO A LA BASE DE DATOS: ERROR:" + e.getMessage());
        }finally{
            return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        }
    }
}
