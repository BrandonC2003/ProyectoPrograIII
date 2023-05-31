/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServiceBar;

import Logica.Conexion;
import Modelos.DetalleVenta;
import Logica.L_DetalleVentas;
import Logica.L_categorias;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.SQLException;
import Modelos.Ventas;

/**
 *
 * @author brand
 */
@WebService(serviceName = "WebServiceBar")
public class WebServiceBar {
    /**
     * This is a sample web service operation
     */
    private L_DetalleVentas objDetalle;
    private L_categorias objCategoria;
    
    public WebServiceBar(){
        objDetalle = new L_DetalleVentas();
        objCategoria = new L_categorias();
    }

    
    
    
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insetarDetalleVenta")
    public boolean insetarDetalleVenta(@WebParam(name = "id") int id,@WebParam(name = "cantidad") int cantidad,@WebParam(name = "usuario") String usuario) {
        DetalleVenta detalle = new DetalleVenta();
        detalle.setIdProducto(id);
        detalle.setCantidad(cantidad);
        detalle.setUsuarioInserta(usuario);
        return this.objDetalle.insertarDetalleVenta(detalle);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarCategoria")
    public Boolean insertarCategoria(@WebParam(name = "categoria") String categoria, @WebParam(name = "Descripcion") Descripcion Descripcion) {
        //TODO write your implementation code here:
        return null;
    }
    
}
