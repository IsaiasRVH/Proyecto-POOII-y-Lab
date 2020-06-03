/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMySQL;

import DAO.DAOException;
import DAO.IVentaDAO;
import Modelo.Venta;
import MySQLConection.Conectar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisf
 */
public class MySQLVentaDAO implements IVentaDAO{
    //Creamos las variables para trabajar con SQL
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Consultas SQL a utilizar
    private final String INSERT = "INSERT INTO venta (idUsuario, idCliente, fecha, total, tipoVenta) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE venta SET total = ?, tipoVenta = ? WHERE idVenta = ?";
    private final String GETALL = "SELECT FROM  idVenta, idUsuario, idCliente, fecha, total, tipoVenta FROM venta";
    private final String GETONE = GETALL + " WHERE idVenta = ?";

    @Override
    public void insertar(Venta venta) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getIdUsuario());
            ps.setInt(2, venta.getIdCliente());
            ps.setDate(3, new Date(venta.getFecha().getTime()));
            ps.setDouble(4, venta.getTotal());
            ps.setString(5, venta.getTipoVenta());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) {
                throw new DAOException( "No se pudo guardar la venta.");
            } else {
                rs = ps.getGeneratedKeys();
                if(rs.next()) {
                    venta.setIdVenta(rs.getInt(1));
                } else {
                    throw new DAOException("No se pudo asignar el ID a la venta.");
                }
            }
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.realizarDesconexion(ps, rs, conn);
        }
    }//fin del metodo insertar

    @Override
    public void modificar(Venta venta) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(UPDATE);
            ps.setDouble(1, venta.getTotal());
            ps.setString(2, venta.getTipoVenta());
            ps.setInt(3, venta.getIdVenta());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) {
                throw new DAOException ("Hubo un problema "
                            + "y no se realizaron los cambios.");
            }
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.realizarDesconexion(ps, rs, conn);
        }
    }//fin del metodo modificar

    @Override
    public void eliminar(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> obtenerTodos() throws DAOException {
        //Listas de Ventas a retornar
        List<Venta> misVentas = new ArrayList<Venta>();
        
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
                Venta miVenta = new Venta();
                miVenta.setIdVenta(rs.getInt("idVenta"));
                miVenta.setIdUsuario(rs.getInt("idUsuario"));
                miVenta.setIdCliente(rs.getInt("idCliente"));
                miVenta.setFecha(rs.getDate("fecha"));
                miVenta.setTotal(rs.getDouble("total"));
                miVenta.setTipoVenta(rs.getString("tipoVenta"));
                misVentas.add(miVenta);
            }
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.realizarDesconexion(ps, rs, conn);
        }
        return misVentas;
    }//fin del metodo obtenerTodos

    @Override
    public Venta obtener(Integer id) throws DAOException {
        //venta a retornar
        Venta miVenta = null;
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
                miVenta = new Venta();
                miVenta.setIdVenta(rs.getInt("idVenta"));
                miVenta.setIdUsuario(rs.getInt("idUsuario"));
                miVenta.setIdCliente(rs.getInt("idCliente"));
                miVenta.setFecha(rs.getDate("fecha"));
                miVenta.setTotal(rs.getDouble("total"));
                miVenta.setTipoVenta(rs.getString("tipoVenta"));
            } else {
                throw new DAOException("No se encontro la venta.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.realizarDesconexion(ps, rs, conn);
        }
        return miVenta;
    }//fin del metodo obtener
}
