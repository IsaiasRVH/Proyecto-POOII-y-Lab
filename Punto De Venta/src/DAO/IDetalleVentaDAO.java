/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DetalleVenta;
import java.util.List;

/**
 *
 * @author isaia
 */
public interface IDetalleVentaDAO extends IDAO<DetalleVenta, Integer> {
    public List<DetalleVenta> getVentasPorIdVenta(int idVenta) throws DAOException;
}
