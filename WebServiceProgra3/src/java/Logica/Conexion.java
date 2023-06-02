/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author brand
 */
public class Conexion {
//<<<<<<< Updated upstream
    
  
//=======

    private static final String URL = "jdbc:mysql://127.0.0.1:3307/bar1";
//>>>>>>> Stashed changes
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";
    public static String SHA_256(String data){
        try {
            // Obtener instancia del algoritmo de hash SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            
            // Convertir los datos a bytes
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            
            // Aplicar el algoritmo de hash
            byte[] hashedBytes = messageDigest.digest(bytes);
            
            // Convertir el resultado a una representación legible (hexadecimal)
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            String hashedData = stringBuilder.toString();
            
            return hashedData;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    
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
