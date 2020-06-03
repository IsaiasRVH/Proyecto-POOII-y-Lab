/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOMySQL;

import DAO.DAOException;
import DAO.IClienteDAO;
import Modelo.Cliente;
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
public class MySQLClienteDAO implements IClienteDAO{

    //Creamos las variables para trabajar con SQL
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Consultas SQL a utilizar
    private final String INSERT = "INSERT INTO cliente (nombre, apellidos, "
            + "calleYNumero, colonia, ciudad, codigoPostal, estado, pais, "
            + "telefono, email, adeudo) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?)";

    private final String UPDATE = "UPDATE cliente SET nombre = ?, "
            + "apellidos = ?, calleYNumero = ?, colonia = ?, codigoPostal = ?, "
            + "ciudad = ?, estado = ?, pais = ?, telefono = ?, email = ?, "
            + "adeudo = ? WHERE idCliente = ?";

    private final String DELETE = "DELETE FROM cliente WHERE idCliente = ?";

    private final String GETALL = "SELECT idCliente, nombre, apellidos,"
            + " calleYNumero, colonia, ciudad, codigoPostal, estado, pais, "
            + "telefono, email, adeudo FROM cliente";

    private final String GETONE = "SELECT idCliente, nombre, apellidos, "
            + "calleYNumero, colonia, ciudad, codigoPostal, estado, pais, "
            + "telefono, email, adeudo FROM cliente WHERE idCliente = ?";

    
    @Override
    public void insertar(Cliente cliente) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getCalleYNumero());
            ps.setString(4, cliente.getColonia());
            ps.setString(5, cliente.getCiudad());
            ps.setString(6, cliente.getCodigoPostal());
            ps.setString(7, cliente.getEstado());
            ps.setString(8, cliente.getPais());
            ps.setString(9, cliente.getTelefono());
            ps.setString(10,cliente.getEmail());
            ps.setDouble(11,cliente.getAdeudo());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) { //if 1.0
                throw new DAOException( "No se pudo guardar el cliente." );
            }
            else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) { //if 1.1
                    cliente.setIdCliente(rs.getInt(1));
                }
                else {
                    throw new DAOException ( "No se pudo asignar el ID a erste cliente.");
                } //fin del if 1.1
            } //fin del if 1.0
        } catch (SQLException ex) {
            throw new DAOException ( "Error en SQL: ", ex );
        }
        finally {
            Conectar.realizarDesconexion(ps, rs, conn);
        }
    }

    @Override
    public void modificar(Cliente cliente) throws DAOException {
       try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(UPDATE);
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellidos());
                ps.setString(3, cliente.getCalleYNumero());
                ps.setString(4, cliente.getColonia());
                ps.setString(5, cliente.getCiudad());
                ps.setString(6, cliente.getCodigoPostal());
                ps.setString(7, cliente.getEstado());
                ps.setString(8, cliente.getPais());
                ps.setString(9, cliente.getTelefono());
                ps.setString(10,cliente.getEmail());
                ps.setDouble(11,cliente.getAdeudo());
                ps.setInt(12, cliente.getIdCliente());
                
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
                Conectar.realizarDesconexion(ps, conn);
        }
    }

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
            Conectar.realizarDesconexion(ps, conn);
        }
    }

    @Override
    public List<Cliente> obtenerTodos() throws DAOException {
        //Lista de clientees a retornar
        List <Cliente> misClientes = new ArrayList<Cliente>();
            
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
                Cliente miCliente = new Cliente();
                miCliente.setIdCliente(rs.getInt("idCliente"));
                miCliente.setNombre(rs.getString("nombre"));
                miCliente.setApellidos(rs.getString("apellidos"));
                miCliente.setCalleYNumero(rs.getString("calleYNumero"));
                miCliente.setColonia(rs.getString("colonia"));
                miCliente.setCiudad(rs.getString("ciudad"));
                miCliente.setCodigoPostal(rs.getString("codigoPostal"));
                miCliente.setEstado(rs.getString("estado"));
                miCliente.setPais(rs.getString("pais"));
                miCliente.setTelefono(rs.getString("telefono"));
                miCliente.setEmail(rs.getString("email"));
                miCliente.setAdeudo(rs.getDouble("adeudo"));
                misClientes.add(miCliente);
            }
        } catch (SQLException ex) {
            throw new DAOException( "Error en SQL: ", ex);
        }
        finally {
            Conectar.realizarDesconexion(ps, rs, conn);
        }
        
        return misClientes;
    }

    @Override
    public Cliente obtener(Integer id) throws DAOException {
        //Cliente a retornar
        Cliente miCliente = new Cliente();
            
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
                miCliente = new Cliente();
                miCliente.setIdCliente(rs.getInt("idCliente"));
                miCliente.setNombre(rs.getString("nombre"));
                miCliente.setApellidos(rs.getString("apellidos"));
                miCliente.setCalleYNumero(rs.getString("calleYNumero"));
                miCliente.setColonia(rs.getString("colonia"));
                miCliente.setCiudad(rs.getString("ciudad"));
                miCliente.setCodigoPostal(rs.getString("codigoPostal"));
                miCliente.setEstado(rs.getString("estado"));
                miCliente.setPais(rs.getString("pais"));
                miCliente.setTelefono(rs.getString("telefono"));
                miCliente.setEmail(rs.getString("email"));
                miCliente.setAdeudo(rs.getDouble("adeudo"));
                
            }
            else {
                throw new DAOException ( "No se encontro el cliente." );
            }
        } catch (SQLException ex) {
            throw new DAOException ( "Error en SQL: ", ex );
        }
        finally {
            Conectar.realizarDesconexion(ps, rs, conn);
        }
        
        return miCliente;
    }

}
