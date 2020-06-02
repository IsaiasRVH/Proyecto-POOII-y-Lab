/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLConection;

import DAO.DAOException;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author isaia
 */
public class Conectar {
    
    //Propiedades para la conexion a la base de datos
    //Nombre del controlador JDBC
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String URL_BASEDATOS = "jdbc:mysql://192.168.56.1:888/libros?useSSL=true";
    
    private static Connection conn = null;
    
    /**
     * Realizamos la conexion a la base de datos.
     * @return
     * @throws SQLException 
     */
    public static Connection realizarConexion() throws DAOException {
        
        try {
            //Carga la clase controlador
            Class.forName(CONTROLADOR);
            
            //Establece la conexion a la base de datos
            conn = (Connection) DriverManager.getConnection(URL_BASEDATOS, USUARIO, PASSWORD);
            
            System.out.println("EstoyDentro");
        } catch (ClassNotFoundException ex) {
            throw new DAOException("Error en la conexion: ", ex);
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL: ", ex);
        }
        return conn;
    }
    
    public static void realizarDesconexion(PreparedStatement ps, ResultSet rs, Connection conn) throws DAOException {
        if( rs != null ) {
                try {
                    rs.close(); //cierra la conexion a la base de datos
                } catch (SQLException ex) {
                    System.out.print( "Error en SQL: " + ex.getMessage());
                }
            }

            if( ps != null ) {
                try {
                    ps.close(); //cierra la conexion a la base de datos
                } catch (SQLException ex) {
                    System.out.print( "Error en SQL: " + ex.getMessage());
                }
            }

            if( conn != null ) {
                try {
                    conn.close(); //cierra la conexion a la base de datos
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL: ", ex);
                }
            }
    }
    
    public static void realizarDesconexion(PreparedStatement ps, Connection conn) throws DAOException {

            if( ps != null ) {
                try {
                    ps.close(); //cierra la conexion a la base de datos
                } catch (SQLException ex) {
                    System.out.print( "Error en SQL: " + ex.getMessage());
                }
            }

            if( conn != null ) {
                try {
                    conn.close(); //cierra la conexion a la base de datos
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL: ", ex);
                }
            }
    }
    
    public static void realizarDesconexion( Connection conn) throws DAOException {


            if( conn != null ) {
                try {
                    conn.close(); //cierra la conexion a la base de datos
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL: ", ex);
                }
            }
    }
}
