/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DAO.DAOException;
import DAO.IVentaDAO;
import DAOMySQL.MySQLDAOManager;
import Modelo.Venta;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luisf
 */
public class VentasTableModel extends AbstractTableModel{

     //propiedades
    private IVentaDAO venta = null;
    
    //lista de elementos de tipo Venta
    private List<Venta> datos = new ArrayList<>();
    
    //constructor con un parametro
    public VentasTableModel (IVentaDAO venta) {
        this.venta = venta;
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
            case 1: return "ID Usuario";
            case 2: return "ID Cliente";
            case 3: return "Fecha";
            case 4: return "Tipo Venta";
            case 5: return "Total";
            default : return "[no]";
        }
    }
    
    /**
     * retorna el numero de elementos obtenidos de la tabla ventas
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
        return 6;
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
        Venta preguntada = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return preguntada.getIdVenta();
            case 1: return preguntada.getIdUsuario();
            case 2: return preguntada.getIdCliente();
            case 3: return preguntada.getFecha();
            case 4: return preguntada.getTipoVenta();
            case 5: return preguntada.getTotal();
            default : return "";
        }
    }
    
    public void updateModel() throws DAOException {
        datos = venta.obtenerTodos();
    }
    
    public void updateModel(Date fecha) throws DAOException {
        datos = venta.obtenerPorFecha(fecha);
    }
}
