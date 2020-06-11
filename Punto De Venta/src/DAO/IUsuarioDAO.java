/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author isaia
 */
public interface IUsuarioDAO extends IDAO<Usuario, Integer> {
    public List<Usuario> obtenerBuscados(String parametro) throws DAOException;
}
