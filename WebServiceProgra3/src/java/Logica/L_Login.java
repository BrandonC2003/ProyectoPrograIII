package Logica;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;



/**
 *
 * @author Adonay
 */
public class L_Login {
        
    
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
    
    public boolean login(String usuario, String clave){
        int confirmacion = 0;
        try (Connection conexion = Conexion.obtenerConexion();) {
            //Preparar la llamada al procedimiento almacenado
            String procedimiento = "{call sp_Login(?, ?, ?)}";
            CallableStatement llamada = conexion.prepareCall(procedimiento);
            
            //Establecer los parametros del procedimeitno almacenado
            llamada.setString(1,usuario);
            llamada.setString(2,clave);
            
            //registrar parametro de salida
            llamada.registerOutParameter(3, java.sql.Types.INTEGER);
            
            //Ejecutar el procedimiento alamcenado
            llamada.execute();
            
            //Recuperar el parametro de salida
            confirmacion = llamada.getInt(3);
            
            //liberar recursos
            llamada.close();
            
            //si la confirmacion es 1 retornara true sino false
            return confirmacion==1 ? true : false;
        } catch (SQLException e) {
            System.out.println("este es el mensaje: "+e.getMessage());
            return false;
        }
    }
    
}
