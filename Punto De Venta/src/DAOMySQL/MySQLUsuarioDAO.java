/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luisf
 */
public class MySQLUsuarioDAO {
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

}
