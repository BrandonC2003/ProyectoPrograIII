/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceBar;

import Logica.Conexion;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author brand
 */
@WebService(serviceName = "WebServiceBar")
public class WebServiceBar {
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "probarConexionBD")
    public String probarConexionBD(){
        try (Connection connection = Conexion.obtenerConexion();) {
            return "Conexion establecida correctamente";
        } catch (SQLException e) {
            return "Error: "+e.getMessage();
        }
    }
    
}
