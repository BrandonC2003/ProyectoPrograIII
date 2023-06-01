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
import Logica.L_Login;
import Logica.L_Productos;
import Modelos.Productos;

/**
 *
 * @author brand
 */
@WebService(serviceName = "WebServiceBar")
public class WebServiceBar {
    
    //en esta parte se crean los objetos y posteriormente se inicializan en el constructor.
    private L_DetalleVentas objDetalle;
    private L_categorias objCategoria;
    private L_Login objLogin;
    private L_Productos objProductos;
    
    public WebServiceBar(){
        objDetalle = new L_DetalleVentas();
        objCategoria = new L_categorias();
        objLogin = new L_Login();
        objProductos = new L_Productos();
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
      * Este metodo cumple la funcion de agregar los detalles de venta no confirmados, a una venta
      * si todo esta correcto retorna true y sino retorna false
      * @param usuarioInserta
      * @return true | false
      */
    @WebMethod(operationName = "confirmarVenta")
    public boolean confirmarVenta(@WebParam(name = "usuarioInserta") String usuarioInserta) {
        return objDetalle.confirmarVenta(usuarioInserta);
    }
    /**
     * Este metetodo sirve para obtener los valores de la tabla de detalleVenta y la filtra por usuarios
     * @param usuarioInserta
     * @return ArrayList<DetalleVenta>
     */
    @WebMethod(operationName = "obtenerDetalleVenta")
    public ArrayList<DetalleVenta> obtenerDetalleVenta(@WebParam(name = "usuarioInserta") String usuarioInserta) {
        return objDetalle.obtenerDetalles(usuarioInserta);
    }

    /**
     * Este metodo realiza la busqueda de una venta especifica y retorna una lista de objetos
     * @param idVenta
     * @return ArrayList<DetalleVenta>
     */
    @WebMethod(operationName = "buscarVenta")
    public ArrayList<DetalleVenta> buscarVenta(@WebParam(name = "idVenta") int idVenta) {
        return objDetalle.buscarVenta(idVenta);
    }
    
    /**
     * Este metodo obtiene todas las ventas realizadas
     * @return ArrayList<Ventas>
     */
    @WebMethod(operationName = "listarVentas")
    public ArrayList<Ventas> buscarVentas() {
        return objDetalle.ListarVentas();
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
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        return objLogin.login(usuario, clave);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarProductos")
    public boolean insertarProductos(@WebParam(name = "idCategoria") int idCategoria, @WebParam(name = "nombreProducto") String nombreProducto, @WebParam(name = "cantidad") int cantidad, @WebParam(name = "precioUnitario") double precioUnitario, @WebParam(name = "descuento") double descuento, @WebParam(name = "usuarioInserta") String usuarioInserta) {
        Productos producto = new Productos();
        producto.setIdCategoria(idCategoria);
        producto.setNombreProducto(nombreProducto);
        producto.setCantidad(cantidad);
        producto.setPrecioUnitario(precioUnitario);
        producto.setDescuento(descuento);
        producto.setUsuarioInserta(usuarioInserta);
        return objProductos.insertarProductos(producto);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarProducto")
    public boolean modificarProducto(@WebParam(name = "idProducto") int idProducto,@WebParam(name = "idCategoria") int idCategoria, @WebParam(name = "nombreProducto") String nombreProducto, @WebParam(name = "cantidad") int cantidad, @WebParam(name = "precioUnitario") double precioUnitario, @WebParam(name = "descuento") double descuento, @WebParam(name = "usuarioActualiza") String usuarioActualiza) {
        Productos producto = new Productos();
        producto.setIdProducto(idProducto);
        producto.setIdCategoria(idCategoria);
        producto.setNombreProducto(nombreProducto);
        producto.setCantidad(cantidad);
        producto.setPrecioUnitario(precioUnitario);
        producto.setDescuento(descuento);
        producto.setUsuarioActualiza(usuarioActualiza);
        return objProductos.modificarProductos(producto);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarProductos")
    public boolean agregarProductos(@WebParam(name = "idProducto") int idProducto, @WebParam(name = "cantidad") int cantidad) {
        Productos producto = new Productos();
        producto.setIdProducto(idProducto);
        producto.setCantidad(cantidad);
        return objProductos.agregarProductos(producto);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarProductos")
    public ArrayList<Productos> listarProductos() {
        return objProductos.listarProductos();
    }
}
