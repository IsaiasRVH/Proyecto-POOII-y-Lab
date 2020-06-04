/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMySQL;

import DAO.DAOException;
import DAO.IProductoDAO;
import Modelo.Producto;
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
public class MySQLProductoDAO implements IProductoDAO{

    //propiedades para manipular la base de datos
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    //consultas SQL a utilizar
    private final String INSERT  = "INSERT INTO producto (codigo, modelo, marca, color, estilo, existencias, precio, idProveedor) VALUES (?, ?, ?, ?, ?,  ?, ?, ?)";
    private final String UPDATE = "UPDATE producto SET  modelo = ?, marca= ?, color = ?, estilo = ?, existencias = ?, precio = ?, idProveedor = ? WHERE codigo = ?";
    private final String DELETE = "DELETE FROM producto WHERE codigo = ?";
    private final String GETALL = "SELECT codigo, modelo, marca, color, estilo, existencias, precio, idProveedor FROM producto";
    private final String GETONE = "SELECT codigo, modelo, marca, color, estilo, existencias, precio, idProveedor FROM producto WHERE codigo = ?";

    @Override
    public void insertar(Producto producto) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getModelo());
            ps.setString(3, producto.getMarca());
            ps.setString(4, producto.getColor());
            ps.setString(5, producto.getEstilo());
            ps.setDouble(6, producto.getExistencias());
            ps.setDouble(7, producto.getPrecio());
            ps.setInt(8, producto.getIdProveedor());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) {
                throw new DAOException("No se pudo guardar el nuevo producto.");
            } 
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo insertar

    @Override
    public void modificar(Producto producto) throws DAOException {
        try{
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, producto.getModelo());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getColor());
            ps.setString(4, producto.getEstilo());
            ps.setDouble(5, producto.getExistencias());
            ps.setDouble(6, producto.getPrecio());
            ps.setInt(7, producto.getIdProveedor());
            ps.setString(8, producto.getCodigo());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) {
                throw new DAOException("Hubo un problema y no se guardaron los cambios");
            }
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo modificar

    @Override
    public void eliminar(String codigo) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(DELETE);
            ps.setString(1, codigo);
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) { //si es igual con 0 hubo un problema
                throw new DAOException("Hubo un problema y no se pudo eliminar el registro");
            }
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo eliminar

    /**
     * Este metodo obtiene todos los registros de la base de datos de la tabla productos
     * @return retorna una lista de tipo productos
     * @throws DAOException 
     */
    @Override
    public List<Producto> obtenerTodos() throws DAOException {
        //Lista de productos a retornar
        List<Producto> misProductos = new ArrayList<Producto>();
        
        try {
            //creamos la conexion a la base de datos
             conn = Conectar.realizarConexion();
            
            ////preparamos la consulta
            ps = conn.prepareStatement(GETALL);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
            
            //Recorremos el ResultSet y agreamos cada item al arrayList
            while(rs.next()) {
                Producto miProducto = new Producto();
                miProducto.setCodigo(rs.getString("codigo"));
                miProducto.setModelo(rs.getString("modelo"));
                miProducto.setMarca(rs.getString("marca"));
                miProducto.setColor(rs.getString("color"));
                miProducto.setEstilo(rs.getString("estilo"));
                miProducto.setExistencias(rs.getDouble("existencias"));
                miProducto.setPrecio(rs.getDouble("precio"));
                miProducto.setIdProveedor(rs.getInt("idProveedor"));
                misProductos.add(miProducto);
            }
        } catch(SQLException ex) {
            throw new DAOException("Error en SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        };
        return misProductos;
    }//fin del metodo obtenerTodos

    @Override
    public Producto obtener(String codigo) throws DAOException {
        //Producto a retornar
        Producto miProducto = null;
        
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y definimos sus parametros que recibe la consulta
            ps = conn.prepareStatement(GETONE);
            ps.setString(1, codigo);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
            
            /*
            verificamos si el resultSet obtuvo un resultado y lo asignamos al objeto
            correspondiente
            */
            if(rs.next()) {
                miProducto = new Producto();
                miProducto.setCodigo(rs.getString("codigo"));
                miProducto.setModelo(rs.getString("modelo"));
                miProducto.setMarca(rs.getString("marca"));
                miProducto.setColor(rs.getString("color"));
                miProducto.setEstilo(rs.getString("estilo"));
                miProducto.setExistencias(rs.getDouble("existencias"));
                miProducto.setPrecio(rs.getDouble("precio"));
                miProducto.setIdProveedor(rs.getInt("idProveedor"));
            } else {
                throw new DAOException("No se encontro el elemento");
            }
        } catch(SQLException ex) {
            throw new DAOException ("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
        return miProducto;
    }//fin del metodo obtener
}
