/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMySQL;

import DAO.DAOException;
import DAO.IUsuarioDAO;
import Modelo.Usuario;
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
public class MySQLUsuarioDAO implements IUsuarioDAO{
    //propiedades para manipular la base de datos
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    //consultas SQL a utilizar
    private final String INSERT = "INSERT INTO usuario (nombre, apellidos, "
            + "telefono, email, calleYNumero, colonia, codigoPostal, ciudad, "
            + "estado, pais, salario, contrasenia) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE usuario SET nombre = ?, apellidos = ?,"
            + " telefono = ?, email = ?, calleYNumero = ?, colonia = ?, "
            + "codigoPostal = ?, ciudad = ?, estado = ?, pais = ?, salario = ?, "
            + "contrasenia = ? WHERE idUsuario = ?";
    private final String DELETE = "DELETE FROM usuario WHERE idUsuario = ?";
    private final String GETALL = "SELECT idUsuario, nombre, apellidos, "
            + "telefono, email, calleYNumero, colonia, codigoPostal, ciudad, "
            + "estado, pais, salario, contrasenia FROM usuario";
    private final String GETONE = GETALL + " WHERE idUsuario = ?";

    @Override
    public void insertar(Usuario usuario) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getCalleYNumero());
            ps.setString(6, usuario.getColonia());
            ps.setString(7, usuario.getCodigoPostal());
            ps.setString(8, usuario.getCiudad());
            ps.setString(9, usuario.getEstado());
            ps.setString(10, usuario.getPais());
            ps.setDouble(11, usuario.getSalario());
            ps.setString(12, usuario.getContrasenia());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) { //if 1.0
                throw new DAOException( "No se pudo guardar el usuario." );
            } else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) { //if 1.1
                    usuario.setIdUsuario(rs.getInt(1));
                } else {
                    throw new DAOException("No se pudo asignar el ID a este usuario.");
                }
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
    public void modificar(Usuario usuario) throws DAOException {
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getCalleYNumero());
            ps.setString(6, usuario.getColonia());
            ps.setString(7, usuario.getCodigoPostal());
            ps.setString(8, usuario.getCiudad());
            ps.setString(9, usuario.getEstado());
            ps.setString(10, usuario.getPais());
            ps.setDouble(11, usuario.getSalario());
            ps.setString(12, usuario.getContrasenia());
            ps.setInt(13, usuario.getIdUsuario());
            
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0) {
                throw new DAOException ("Hubo un problema "
                            + "y no se realizaron los cambios.");
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
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
    }//fin del metodo eliminar

    /**
     * Este metodo obtiene todos los registros de la base de datos de la tabla usuario
     * @return retorna una lista de tipo usuario
     * @throws DAOException 
     */
    @Override
    public List<Usuario> obtenerTodos() throws DAOException {
        //Lista de productos a retornar
        List<Usuario> misUsuarios = new ArrayList<Usuario>();
        
         try {
            //creamos la conexion a la base de datos
             conn = Conectar.realizarConexion();
            
            ////preparamos la consulta
            ps = conn.prepareStatement(GETALL);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
            
            //Recorremos el ResultSet y agreamos cada item al arrayList
            while(rs.next()) {
                Usuario miUsuario = new Usuario();
                miUsuario.setIdUsuario(rs.getInt("idUsuario"));
                miUsuario.setNombre(rs.getString("nombre"));
                miUsuario.setApellidos(rs.getString("apellidos"));
                miUsuario.setTelefono(rs.getString("telefono"));
                miUsuario.setEmail(rs.getString("email"));
                miUsuario.setCalleYNumero(rs.getString("calleYNumero"));
                miUsuario.setColonia(rs.getString("colonia"));
                miUsuario.setCodigoPostal(rs.getString("codigoPostal"));
                miUsuario.setCiudad(rs.getString("ciudad"));
                miUsuario.setEstado(rs.getString("estado"));
                miUsuario.setPais(rs.getString("pais"));
                miUsuario.setSalario(rs.getDouble("salario"));
                miUsuario.setContrasenia(rs.getString("contrasenia"));
                misUsuarios.add(miUsuario);
            } 
        }catch(SQLException ex) {
            throw new DAOException("Error en SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
        return misUsuarios;
    }//fin del metodo obtenerTodos

    @Override
    public Usuario obtener(Integer id) throws DAOException {
        //Usuario a retornar
        Usuario miUsuario = null;
        try {
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            
            //preparamos la consulta y definimos sus parametros que recibe la consulta
            ps = conn.prepareStatement(GETONE);
            ps.setInt(1, id);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
            
            /*
            verificamos si el resultSet obtuvo un resultado y lo asignamos al objeto
            correspondiente
            */
            if(rs.next()) {
                miUsuario = new Usuario();
                miUsuario.setIdUsuario(rs.getInt("idUsuario"));
                miUsuario.setNombre(rs.getString("nombre"));
                miUsuario.setApellidos(rs.getString("apellidos"));
                miUsuario.setTelefono(rs.getString("telefono"));
                miUsuario.setEmail(rs.getString("email"));
                miUsuario.setCalleYNumero(rs.getString("calleYNumero"));
                miUsuario.setColonia(rs.getString("colonia"));
                miUsuario.setCodigoPostal(rs.getString("codigoPostal"));
                miUsuario.setCiudad(rs.getString("ciudad"));
                miUsuario.setEstado(rs.getString("estado"));
                miUsuario.setPais(rs.getString("pais"));
                miUsuario.setSalario(rs.getDouble("salario"));
                miUsuario.setContrasenia(rs.getString("contrasenia"));
            } else {
                throw new DAOException("No se encontro el elemento.");
            }
        } catch(SQLException ex) {
            throw new DAOException("Error de SQL: ", ex);
        } finally {
            Conectar.desconectarRS(rs);
            Conectar.desconectarPS(ps);
            Conectar.desconectarConnection(conn);
        }
        return miUsuario;
    }//fin del metodo obtener
}
