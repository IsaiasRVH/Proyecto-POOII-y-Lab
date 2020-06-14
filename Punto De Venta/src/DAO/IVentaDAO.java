/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DetalleVenta;
import Modelo.Venta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author luisf
 */
public interface IVentaDAO extends IDAO<Venta, Integer> {
    
    List<DetalleVenta> obtenerDetalleVenta(int id) throws DAOException;
    
    List<Venta> obtenerPorFecha(Date fecha) throws DAOException;
}
