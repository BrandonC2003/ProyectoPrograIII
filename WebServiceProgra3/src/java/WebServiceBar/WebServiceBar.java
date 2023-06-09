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
import Logica.L_Usuarios;
import Modelos.Usuarios;
import Modelos.Productos;
import Modelos.vwDetalleVentas;

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
    private L_Usuarios objUsuarios;
    
    public WebServiceBar(){
        objDetalle = new L_DetalleVentas();
        objCategoria = new L_categorias();
        objLogin = new L_Login();
        objProductos = new L_Productos();
        objUsuarios = new L_Usuarios();
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
    public ArrayList<vwDetalleVentas> obtenerDetalleVenta(@WebParam(name = "usuarioInserta") String usuarioInserta) {
        return objDetalle.obtenerDetalles(usuarioInserta);
    }

    /**
     * Este metodo realiza la busqueda de una venta especifica y retorna una lista de objetos
     * @param idVenta
     * @return ArrayList<DetalleVenta>
     */
    @WebMethod(operationName = "buscarVenta")
    public ArrayList<vwDetalleVentas> buscarVenta(@WebParam(name = "idVenta") int idVenta) {
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
    
    @WebMethod(operationName = "modificarCategoria")
    public boolean modificarCategoria(@WebParam(name = "idCategoria") int idCategoria, @WebParam( name = "categoria") String categoria, @WebParam(name="descripcion") String descripcion ) {
        Categorias categori = new Categorias();
        categori.setIdCategoria(idCategoria);
        categori.setCategoria(categoria);
        categori.setDescripcion(descripcion);
        return objCategoria.modificarCategoria(categori);
    }
    
    @WebMethod(operationName = "listarCategoria")
    public ArrayList<Categorias>listarCategoria() {
        
        return objCategoria.listarCategoria();
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        return objLogin.login(usuario, Conexion.SHA_256(clave));
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarUsuario")
    public boolean agregarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "clave") String clave, @WebParam(name = "telefono") String telefono, @WebParam(name = "estado") int estado, @WebParam(name = "nivel") String nivel) {
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setClave(Conexion.SHA_256(clave));
        usuario.setEstado(estado);
        usuario.setNivel(nivel);
        
        return objUsuarios.agregarUsuarios(usuario);
    }
    
    
    @WebMethod(operationName = "modificarUsuario")
    public boolean modificarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "clave") String clave, @WebParam(name = "telefono") String telefono, @WebParam(name = "estado") int estado, @WebParam(name = "nivel") String nivel) {
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setClave(Conexion.SHA_256(clave));
        usuario.setEstado(estado);
        usuario.setNivel(nivel);
        
        return objUsuarios.modificarUsuario(usuario);
    }
    
    @WebMethod(operationName = "listarUsuarios")
    public ArrayList<Usuarios> listarUsuarioss(){
        return objUsuarios.obtenerUsuarios();
    }
    
    @WebMethod(operationName = "buscarUsuarios")
    public ArrayList<Usuarios> BuscarUsuarios(@WebParam(name = "nombreUsuario") String nombreUsuario){
        return objUsuarios.buscarUsuarios(nombreUsuario);
    }
}
