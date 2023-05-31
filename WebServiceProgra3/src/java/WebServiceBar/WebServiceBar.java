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
import  Modelos.Categorias;
import java.util.ArrayList;

/**
 *
 * @author brand
 */
@WebService(serviceName = "WebServiceBar")
public class WebServiceBar {
    
    //en esta parte se crean los objetos y posteriormente se inicializan en el constructor.
    private L_DetalleVentas objDetalle;
    private L_categorias objCategoria;
    
    public WebServiceBar(){
        objDetalle = new L_DetalleVentas();
        objCategoria = new L_categorias();
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
     * Este metodo sirve para insertar datos en la tabla DetalleVenta
     * recibe como argumento un objeto de tipo DetalleVenta del cual utiliza las variables idProducto, cantidad
     * y usuarioInserta.
     * retorna true si la operacion se realizo correctamente o false si hubo algun error o si la cantidad de productos que se intenta
     * comprar es menor que la que hay en el inventario.
     * @param detalle
     * @return true | false
     */
    @WebMethod(operationName = "insetarDetalleVenta")
    public boolean insetarDetalleVenta(@WebParam(name = "objDetalle") DetalleVenta detalle) {
        return this.objDetalle.insertarDetalleVenta(detalle);
    }
    
    /**
     * Este metodo sirve para modificar la tabla detalleventa, trecibe como parametro un objeto de tipo detalleventa
     * del cual se utilizan los campos idDetalle, idProducto, cantidad y usuarioInserta. retorna
     * true si todo esta correcto o false si hubo un error o si la cantidad de productos en inventario no es suficiente.
     * @param detalle
     * @return true | false
     */
    @WebMethod(operationName = "modificarDetalleVenta")
    public boolean modificarDetalleVenta(@WebParam(name = "objDetalle") DetalleVenta detalle) {
        return objDetalle.modificarDetalle(detalle);
    }
    
    /**
     * Este metodo sirve para eliminar detalles de venta, recibe como parametro el id del detalle de venta 
     * y retorna true si todo esta correcto o false si hay algun error
     * @param idDetalle
     * @return true | false
     */
    @WebMethod(operationName = "eliminarDetalleVenta")
    public boolean eliminarDetalleVenta(@WebParam(name = "idDetalle") int idDetalle) {
        return objDetalle.eliminarDetalleVenta(idDetalle);
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "confirmarVenta")
    public boolean confirmarVenta(@WebParam(name = "usuarioInserta") String usuarioInserta) {
        return objDetalle.confirmarVenta(usuarioInserta);
    }
    /**
     * Este metodo sirve para insertar datos a la tabla categorias, recibe como parametro un objeto de 
     * tipo categoria del cual se utiliza la variable categoria y descripcion.
     * retorna true si la accion se ejecuto correctamente o false si hubo algun error o 
     * si la categoria esta repetida, ya que debe de ser unica.
     * @param categoria
     * @return true | false
     */
    @WebMethod(operationName = "insertarCategoria")
    public boolean insertarCategoria(@WebParam(name = "objCategoria") Categorias categoria ) {
        return objCategoria.insertarCategorias(categoria);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerDetalleVenta")
    public ArrayList<DetalleVenta> obtenerDetalleVenta() {
        return objDetalle.obtenerDetalles();
    }
    
    
}
