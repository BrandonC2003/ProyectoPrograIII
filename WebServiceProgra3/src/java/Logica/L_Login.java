/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author brand
 */
public class L_Login {
    
    public String SHA_256(String data){
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
}
