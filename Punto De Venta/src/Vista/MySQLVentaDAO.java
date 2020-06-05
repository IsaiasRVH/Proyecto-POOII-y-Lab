/*
 * To change this license header, choose License HeadersVenta in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMySQL;

import DAO.DAOException;
import DAO.IVentaDAO;
import Modelo.DetalleVenta;
import Modelo.Venta;
import MySQLConection.Conectar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisf
 */
public class MySQLVentaDAO implements IVentaDAO{
    //Creamos las variables para trabajar con SQL
    private Connection conn;
    private PreparedStatement psVenta = null;
    private PreparedStatement psDetalleVenta = null;
    private ResultSet rsVenta = null;
    private ResultSet rsDetalleVenta  = null;
    
    //Consultas SQL a utilizar
    private final String INSERT = "INSERT INTO venta (idUsuario, idCliente, fecha, total, tipoVenta) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE venta SET total = ?, tipoVenta = ? WHERE idVenta = ?";
    private final String GETALL = "SELECT FROM  idVenta, idUsuario, idCliente, fecha, total, tipoVenta FROM venta";
    private final String GETONE = GETALL + " WHERE idVenta = ?";
    private final String GETDETALLEVENTAPORIDVENTA = "SELECT venta.idVenta, "
            + "producto.codigo, detalleVenta.cantidad, detalleVenta.precio, "
            + "detalleVenta.importe FROM venta INNER JOIN detalleVenta ON "
            + "venta.idVenta = detalleVenta.idVenta INNER JOIN producto ON "
            + "producto.codigo = detalleVenta.codigo WHERE venta.idVenta = ?";
    private final String UPDATEDETALLEVENTA = "UPDATE detalleVenta SET  cantidad = ?, "
            + "precio = ?, importe = ? WHERE idVenta = ? AND codigo = ?";
    private final String INSERTDETALLEVENTA = "INSERT INTO detalleVenta (idVenta, codigo, "
            + "cantidad, precio, importe) VALUES (?, ?, ?, ?, ?)";

    @Override
    public void insertar(Venta venta) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            conn.setAutoCommit(false);
            
            //preparamos la consulta y especificamos los parametros de entrada
            psVenta = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            psVenta.setInt(1, venta.getIdUsuario());
            psVenta.setInt(2, venta.getIdCliente());
            psVenta.setDate(3, new Date(venta.getFecha().getTime()));
            psVenta.setDouble(4, venta.getTotal());
            psVenta.setString(5, venta.getTipoVenta());
            
            //ejecutamos la consulta y verificamos el resultado
            if(psVenta.executeUpdate() == 0) {
                throw new DAOException( "No se pudo guardar la venta.");
            } else {
                rsVenta = psVenta.getGeneratedKeys();
                if(rsVenta.next()) {
                    venta.setIdVenta(rsVenta.getInt(1));
                } else {
                    throw new DAOException("No se pudo asignar el ID a la venta.");
                }
            }
            
            for (DetalleVenta detalleVenta : venta.getDetallesVenta()) {
                psDetalleVenta = conn.prepareStatement(INSERTDETALLEVENTA);
                psDetalleVenta.setInt(1, detalleVenta.getIdVenta());
                psDetalleVenta.setString(2, detalleVenta.getCodigo());
                psDetalleVenta.setInt(3, detalleVenta.getCantidad());
                psDetalleVenta.setDouble(4, detalleVenta.getPrecio());
                psDetalleVenta.setDouble(5, detalleVenta.getImporte());
                
                
                //ejecutamos la consulta y verificamos el resultado
                if(psDetalleVenta.executeUpdate() == 0) {
                    throw new DAOException( "No se pudo guardar la venta.");
                }
            }
            
            
            
            conn.commit();
        } catch(SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                throw new DAOException("Error de SQL: ", ex);
            }
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rsVenta);
            Conectar.desconectarPS(psVenta);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo insertar

    @Override
    public void modificar(Venta venta) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            psVenta = conn.prepareStatement(UPDATE);
            psVenta.setDouble(1, venta.getTotal());
            psVenta.setInt(3, venta.getIdVenta());
            
            //ejecutamos la consulta y verificamos el resultado
            if(psVenta.executeUpdate() == 0) {
                throw new DAOException ("Hubo un problema "
                            + "y no se realizaron los cambios.");
            }
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rsVenta);
            Conectar.desconectarPS(psVenta);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo modificar

    @Override
    public void eliminar(Integer id) throws DAOException {
        
    }

    @Override
    public List<Venta> obtenerTodos() throws DAOException {
        //Listas de Ventas a retornar
        List<Venta> misVentas = new ArrayList<Venta>();
        
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta
            psVenta = conn.prepareStatement(GETALL);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto
            //ResultSet
            rsVenta = psVenta.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item al ArrayList
            while( rsVenta.next()) {
                Venta miVenta = new Venta();
                miVenta.setIdVenta(rsVenta.getInt("idVenta"));
                miVenta.setIdUsuario(rsVenta.getInt("idUsuario"));
                miVenta.setIdCliente(rsVenta.getInt("idCliente"));
                miVenta.setFecha(rsVenta.getDate("fecha"));
                miVenta.setTotal(rsVenta.getDouble("total"));
                miVenta.setTipoVenta(rsVenta.getString("tipoVenta"));
                misVentas.add(miVenta);
            }
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rsVenta);
            Conectar.desconectarPS(psVenta);
            Conectar.desconectarConnection(conn);
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
            psVenta = conn.prepareStatement(GETONE);
            psVenta.setInt(1, id);
            
            
            //ejecutamos la consulta y el resultado lo almacenamos en un ResultSet
            rsVenta = psVenta.executeQuery();
            
            psDetalleVenta = conn.prepareStatement(GETDETALLEVENTAPORIDVENTA);
            psDetalleVenta.setInt(1, id);
            
            rsDetalleVenta = psDetalleVenta.executeQuery();
            
            //verificamos si el ResultSet obtuvo un resultado y lo asignamos
            //al objeto correspondiente
            if(rsVenta.next()) {
                miVenta = new Venta();
                miVenta.setIdVenta(rsVenta.getInt("idVenta"));
                miVenta.setIdUsuario(rsVenta.getInt("idUsuario"));
                miVenta.setIdCliente(rsVenta.getInt("idCliente"));
                miVenta.setFecha(rsVenta.getDate("fecha"));
                miVenta.setTotal(rsVenta.getDouble("total"));
                miVenta.setTipoVenta(rsVenta.getString("tipoVenta"));
                
                while(rsDetalleVenta.next()) {
                    DetalleVenta miDetalle = new DetalleVenta();
                    miDetalle.setIdVenta(rsDetalleVenta.getInt("idVenta"));
                    miDetalle.setCodigo(rsDetalleVenta.getString("codigo"));
                    miDetalle.setCantidad(rsDetalleVenta.getInt("cantidad"));
                    miDetalle.setPrecio(rsDetalleVenta.getDouble("precio"));
                    miDetalle.setImporte(rsDetalleVenta.getDouble("importe"));
                }
                
                
            } else {
                throw new DAOException("No se encontro la venta.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rsVenta);
            Conectar.desconectarPS(psVenta);
            Conectar.desconectarConnection(conn);
        }
        return miVenta;
    }//fin del metodo obtener
}
