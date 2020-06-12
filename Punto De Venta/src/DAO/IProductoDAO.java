/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Producto;
import java.util.List;

/**
 *
 * @author luisf
 */
public interface IProductoDAO extends IDAO<Producto, String> {
    
    List<Producto> obtenerBuscados(String buscar) throws DAOException;
}
