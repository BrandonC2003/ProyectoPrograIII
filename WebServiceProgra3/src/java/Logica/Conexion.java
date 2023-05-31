/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.sql.ResultSet;

/**
 *
 * @author brand
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://127.0.0.1:3307/bar1";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    
    public static Connection obtenerConexion() throws SQLException {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            
        }finally{
            return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        }
    }
}
