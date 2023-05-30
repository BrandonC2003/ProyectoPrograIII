/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;

/**
 *
 * @author brand
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://www.000webhost.com:3306/id20824078_bar";
    private static final String USUARIO = "id20824078_grupoprograiii";
    private static final String CONTRASEÑA = "GrupoProgra~3";

    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
