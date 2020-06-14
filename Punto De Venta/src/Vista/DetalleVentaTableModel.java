/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DAO.DAOException;
import DAO.IDAOManager;
import DAOMySQL.MySQLDAOManager;
import Modelo.DetalleVenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luisf
 */
public class DetalleVentaTableModel extends AbstractTableModel {

    //propiedades
    private IDAOManager manager = null;
    
    //lista de elementos de tipo Venta
    private List<DetalleVenta> datos = new ArrayList<>();
    
    //constructor con un parametro
    public DetalleVentaTableModel () {
        this.manager = new MySQLDAOManager();
    }
    
    /**
     * retorna el nombre de cada columna
     * @param column
     * @return 
     */
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID Venta";
            case 1: return "Codigo Producto";
            case 2: return "Cantidad";
            case 3: return "Precio";
            case 4: return "Importe";
            default : return "[no]";
        }
    }
    
    /**
     * retorna el numero de elementos obtenidos de la tabla DetalleVenta
     * @return 
     */
    @Override
    public int getRowCount() {
        return datos.size();
    }

    /**
     * retorna el numero de columnas
     * @return 
     */
    @Override
    public int getColumnCount() {
        return 5;
    }

    /**
     * retorna el valor que contenga la interseccion de una fila y columna 
     * pasadas como parametro
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleVenta preguntada = datos.get(rowIndex);
        switch(columnIndex) {
            case 0: return preguntada.getIdVenta();
            case 1: return preguntada.getCodigo();
            case 2: return preguntada.getCantidad();
            case 3: return preguntada.getPrecio();
            case 4: return preguntada.getImporte();
            default : return "";
        }
    }
    
    public void updateModel(int id) throws DAOException {
        datos = manager.getVentaDAO().obtenerDetalleVenta(id);
    }
}
