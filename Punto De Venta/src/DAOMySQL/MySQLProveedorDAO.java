/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMySQL;

import DAO.DAOException;
import DAO.IProveedorDAO;
import Modelo.Proveedor;
import MySQLConection.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisf
 */
public class MySQLProveedorDAO implements IProveedorDAO {
    //Creamos las variables para trabajar con SQL
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Consultas SQL a utilizar
    private final String INSERT = "INSERT INTO proveedor (nombre, calleYNumero,"
            + " colonia, ciudad, codigoPostal, estado, pais, telefono, email) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String UPDATE = "UPDATE proveedor SET nombre = ?, "
            + "calleYNumero = ?, colonia = ?, ciudad = ?, codigoPostal = ?, "
            + "estado = ?, pais = ?, telefono = ?, email = ?";

    private final String DELETE = "DELETE FROM proveedor WHERE idProveedor = ?";

    private final String GETALL = "SELECT idProveedor, nombre, calleYNumero, "
            + "colonia, ciudad, codigoPostal, estado, pais, telefono, email "
            + "FROM proveedor";

    private final String GETONE = GETALL + " WHERE idProveedor = ?";

    @Override
    public void insertar(Proveedor proveedor) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getCalleYNumero());
            ps.setString(3, proveedor.getColonia());
            ps.setString(4, proveedor.getCiudad());
            ps.setString(5, proveedor.getCodigoPostal());
            ps.setString(6, proveedor.getEstado());
            ps.setString(7, proveedor.getPais());
            ps.setString(8, proveedor.getTelefono());
            ps.setString(9,proveedor.getEmail());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) { //if 1.0
                throw new DAOException( "No se pudo guardar el proveedor." );
            }
            else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) { //if 1.1
                    proveedor.setIdProveedor(rs.getInt(1));
                }
                else {
                    throw new DAOException ( "No se pudo asignar el ID a este proveedor.");
                } //fin del if 1.1
            } //fin del if 1.0
        } catch (SQLException ex) {
            throw new DAOException ( "Error en SQL: ", ex );
        }
        finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo insertar

    @Override
    public void modificar(Proveedor proveedor) throws DAOException {
       try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(UPDATE);
                ps.setString(1, proveedor.getNombre());
                ps.setString(2, proveedor.getCalleYNumero());
                ps.setString(3, proveedor.getColonia());
                ps.setString(4, proveedor.getCiudad());
                ps.setString(5, proveedor.getCodigoPostal());
                ps.setString(6, proveedor.getEstado());
                ps.setString(7, proveedor.getPais());
                ps.setString(8, proveedor.getTelefono());
                ps.setString(9,proveedor.getEmail());
                ps.setInt(10, proveedor.getIdProveedor());
                
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) {
                throw new DAOException ("Hubo un problema "
                            + "y no se realizaron los cambios.");
            }
        } 
        catch (SQLException ex) {
            throw new DAOException ("Error de SQL:", ex);
        }
        finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo modificar

    @Override
    public void eliminar(Integer id) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, id);
            
            //ejecutamos la consulta y verificamos el resultado
            if( ps.executeUpdate() == 0) {
                throw new DAOException ("Hubo un problema y no se pudo "
                        + "eliminar el registro.");
            }
        } catch (SQLException ex) {
            throw new DAOException( "Error en SQL: ", ex);
        }
        finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo eliminar

    @Override
    public List<Proveedor> obtenerTodos() throws DAOException {
        //Lista de proveedores a retornar
        List <Proveedor> misProveedors = new ArrayList<Proveedor>();
            
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta
            ps = conn.prepareStatement(GETALL);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto
            //ResultSet
            rs = ps.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item al ArrayList
            while( rs.next()) {
                Proveedor miProveedor = new Proveedor();
                miProveedor.setIdProveedor(rs.getInt("idProveedor"));
                miProveedor.setNombre(rs.getString("nombre"));
                miProveedor.setCalleYNumero(rs.getString("calleYNumero"));
                miProveedor.setColonia(rs.getString("colonia"));
                miProveedor.setCiudad(rs.getString("ciudad"));
                miProveedor.setCodigoPostal(rs.getString("codigoPostal"));
                miProveedor.setEstado(rs.getString("estado"));
                miProveedor.setPais(rs.getString("pais"));
                miProveedor.setTelefono(rs.getString("telefono"));
                miProveedor.setEmail(rs.getString("email"));
                misProveedors.add(miProveedor);
            }
        } catch (SQLException ex) {
            throw new DAOException( "Error en SQL: ", ex);
        }
        finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
        
        return misProveedors;
    }//fin del metodo obtenerTodos

    @Override
    public Proveedor obtener(Integer id) throws DAOException {
        //Proveedor a retornar
        Proveedor miProveedor = new Proveedor();
            
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y definimos los parametros
            ps = conn.prepareStatement(GETONE);
            ps.setInt(1, id);
            
            //ejecutamos la consulta y el resultado lo almacenamos en un ResultSet
            rs = ps.executeQuery();
            
            //verificamos si el ResultSet obtuvo un resultado y lo asignamos
            //al objeto correspondiente
            if(rs.next()) {
                miProveedor = new Proveedor();
                miProveedor.setIdProveedor(rs.getInt("idProveedor"));
                miProveedor.setNombre(rs.getString("nombre"));
                miProveedor.setCalleYNumero(rs.getString("calleYNumero"));
                miProveedor.setColonia(rs.getString("colonia"));
                miProveedor.setCiudad(rs.getString("ciudad"));
                miProveedor.setEstado(rs.getString("estado"));
                miProveedor.setPais(rs.getString("pais"));
                miProveedor.setTelefono(rs.getString("telefono"));
                miProveedor.setEmail(rs.getString("email"));
                
            }
            else {
                throw new DAOException ( "No se encontro el proveedor." );
            }
        } catch (SQLException ex) {
            throw new DAOException ( "Error en SQL: ", ex );
        }
        finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
        
        return miProveedor;
    }//fin del metodo obtener
}
