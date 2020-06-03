/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOMySQL;

import DAO.DAOException;
import DAO.IDetalleVentaDAO;
import Modelo.DetalleVenta;
import MySQLConection.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaías Ricardo Valdivia Hernández
 */
public class MySQLDetalleVentaDAO implements IDetalleVentaDAO{
    //Creamos las variables para trabajar con SQL
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Consultas SQL a utilizar
    private final String INSERT = "INSERT INTO detalleVenta (idVenta, codigo, "
            + "cantidad, precio, importe) VALUES (?, ?, ?, ?, ?)";

    private final String UPDATE = "UPDATE detalleVenta SET  cantidad = ?, "
            + "precio = ?, importe = ? WHERE idVenta = ? AND codigo = ?";

    private final String GETALL = "SELECT idVenta, codigo, cantidad, precio, "
            + "importe FROM detalleVenta";

    private final String GETONE = "SELECT idVenta, codigo, cantidad, precio, "
            + "importe FROM detalleVenta WHERE idVenta = ? AND codigo = ?";

    private final String GETDETALLEVENTAPORIDVENTA = "SELECT venta.idVenta, "
            + "producto.codigo, detalleVenta.cantidad, detalleVenta.precio, "
            + "detalleVenta.importe FROM venta INNER JOIN detalleVenta ON "
            + "venta.idVenta = detalleVenta.idVenta INNER JOIN producto ON "
            + "producto.codigo = detalleVenta.codigo WHERE venta.idVenta = ?";


    @Override
    public void insertar(DetalleVenta detalleVenta) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, detalleVenta.getIdVenta());
            ps.setString(2, detalleVenta.getCodigo());
            ps.setInt(3, detalleVenta.getCantidad());
            ps.setDouble(4, detalleVenta.getPrecio());
            ps.setDouble(5, detalleVenta.getImporte());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) { //if 1.0
                throw new DAOException( "No se pudo guardar el detalleVenta." );
            } //fin del if 1.0
        } catch (SQLException ex) {
            throw new DAOException ( "Error en SQL: ", ex );
        }
        finally {
            Conectar.realizarDesconexion(ps, rs, (com.mysql.jdbc.Connection) conn);
        }
    }

    @Override
    public void modificar(DetalleVenta detalleVenta) throws DAOException {
       try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(UPDATE);
                ps.setInt(1, detalleVenta.getCantidad());
                ps.setDouble(2, detalleVenta.getPrecio());
                ps.setDouble(3, detalleVenta.getImporte());
                ps.setInt(4, detalleVenta.getIdVenta());
                ps.setString(5, detalleVenta.getCodigo());
                
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
                Conectar.realizarDesconexion(ps, (com.mysql.jdbc.Connection) conn);
        }
    }

    @Override
    public void eliminar(Integer id) throws DAOException {
        
    }

    @Override
    public List<DetalleVenta> obtenerTodos() throws DAOException {
        //Lista de detalleVentaes a retornar
        List <DetalleVenta> misDetalleVentas = new ArrayList<DetalleVenta>();
            
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
                DetalleVenta miDetalleVenta = new DetalleVenta();
                miDetalleVenta.setIdVenta(rs.getInt("idVenta"));
                miDetalleVenta.setCodigo(rs.getString("codigo"));
                miDetalleVenta.setCantidad(rs.getInt("cantidad"));
                miDetalleVenta.setPrecio(rs.getDouble("precio"));
                miDetalleVenta.setImporte(rs.getDouble("importe"));
                misDetalleVentas.add(miDetalleVenta);
            }
        } catch (SQLException ex) {
            throw new DAOException( "Error en SQL: ", ex);
        }
        finally {
            Conectar.realizarDesconexion(ps, rs, (com.mysql.jdbc.Connection) conn);
        }
        
        return misDetalleVentas;
    }

    @Override
    public DetalleVenta obtener(Integer id) throws DAOException {
        //DetalleVenta a retornar
        DetalleVenta miDetalleVenta = new DetalleVenta();
            
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
                miDetalleVenta.setIdVenta(rs.getInt("idVenta"));
                miDetalleVenta.setCodigo(rs.getString("codigo"));
                miDetalleVenta.setCantidad(rs.getInt("cantidad"));
                miDetalleVenta.setPrecio(rs.getDouble("precio"));
                miDetalleVenta.setImporte(rs.getDouble("importe"));
                
            }
            else {
                throw new DAOException ( "No se encontro el detalleVenta." );
            }
        } catch (SQLException ex) {
            throw new DAOException ( "Error en SQL: ", ex );
        }
        finally {
            Conectar.realizarDesconexion(ps, rs, (com.mysql.jdbc.Connection) conn);
        }
        
        return miDetalleVenta;
    }

    @Override
    public List<DetalleVenta> getVentasPorIdVenta(int idVenta) throws DAOException{
        //Lista de detalleVentaes a retornar
        List <DetalleVenta> misDetalleVentas = new ArrayList<DetalleVenta>();
            
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta
            ps = conn.prepareStatement(GETDETALLEVENTAPORIDVENTA);
            ps.setInt(1, idVenta);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto
            //ResultSet
            rs = ps.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item al ArrayList
            while( rs.next()) {
                DetalleVenta miDetalleVenta = new DetalleVenta();
                miDetalleVenta.setIdVenta(rs.getInt("idVenta"));
                miDetalleVenta.setCodigo(rs.getString("codigo"));
                miDetalleVenta.setCantidad(rs.getInt("cantidad"));
                miDetalleVenta.setPrecio(rs.getDouble("precio"));
                miDetalleVenta.setImporte(rs.getDouble("importe"));
                misDetalleVentas.add(miDetalleVenta);
            }
        } catch (SQLException ex) {
            throw new DAOException( "Error en SQL: ", ex);
        }
        finally {
            Conectar.realizarDesconexion(ps, rs, (com.mysql.jdbc.Connection) conn);
        }
        
        return misDetalleVentas;
    }
}
