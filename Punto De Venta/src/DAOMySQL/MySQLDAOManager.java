/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOMySQL;

import DAO.IClienteDAO;
import DAO.IDAOManager;
import DAO.IProductoDAO;
import DAO.IProveedorDAO;
import DAO.IUsuarioDAO;
import DAO.IVentaDAO;

/**
 *
 * @author Isaías Ricardo Valdivia Hernández
 */
public class MySQLDAOManager implements IDAOManager{

    private IClienteDAO clientes = null;
    private IProductoDAO productos = null;
    private IProveedorDAO proveedores = null;
    private IUsuarioDAO usuarios = null;
    private IVentaDAO ventas = null;

    
    
    @Override
    public IClienteDAO getClienteDAO() {
        if( clientes == null ) {
            clientes = new MySQLClienteDAO();
        }
        return clientes;
    }

    @Override
    public IProductoDAO getProductoDAO() {
        if( productos == null ) {
            productos = new MySQLProductoDAO();
        }
        return productos;
    }

    @Override
    public IProveedorDAO getProveedorDAO() {
        if( proveedores == null ) {
            proveedores = new MySQLProveedorDAO();
        }
        return proveedores;
    }

    @Override
    public IUsuarioDAO getUsuarioDAO() {
        if( usuarios == null ) {
            usuarios = new MySQLUsuarioDAO();
        }
        return usuarios;
    }

    @Override
    public IVentaDAO getVentaDAO() {
        if( ventas == null ) {
            ventas = new MySQLVentaDAO();
        }
        return ventas;
    }

}
