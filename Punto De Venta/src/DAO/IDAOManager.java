/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author isaia
 */
public interface IDAOManager {
    IClienteDAO getClienteDAO();
    
    IProductoDAO getProductoDAO();
    
    IProveedorDAO getProveedorDAO();
    
    IUsuarioDAO getUsuarioDAO();
    
    IVentaDAO getVentaDAO();
}
