/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DAO.DAOException;
import DAO.IProductoDAO;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luisf
 */
public class InventarioTableModel extends AbstractTableModel {
    
    //propiedades
    private IProductoDAO producto;
    
    //lista de elementos de tipo Producto
    private List<Producto> datos = new ArrayList<>();
    
    //constructor con un parametro
    public InventarioTableModel(IProductoDAO producto) {
        this.producto = producto;
    }
    
    /**
     * retorna el nombre de cada columna
     * @param column
     * @return 
     */
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Codigo";
            case 1: return "Modelo";
            case 2: return "Marca";
            case 3: return "Color";
            case 4: return "Estilo";
            case 5: return "Existencias";
            case 6: return "Precio";
            case 7: return "IdProveedor";
            default: return "[no]";
        }
    }

     /**
     * retorna el numero de elementos obtenidos de la tabla inventario
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
        return 8;
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
        Producto preguntado = datos.get(rowIndex);
        switch(columnIndex) {
            case 0: return preguntado.getCodigo();
            case 1: return preguntado.getModelo();
            case 2: return preguntado.getMarca();
            case 3: return preguntado.getColor();
            case 4: return preguntado.getEstilo();
            case 5: return preguntado.getExistencias();
            case 6: return preguntado.getPrecio();
            case 7: return preguntado.getIdProveedor();
            default : return "";
        } 
    }
    
    public void updateModel() throws DAOException {
        datos = producto.obtenerTodos();
    }
    
    public void updateModel(String buscar) throws DAOException {
        datos = producto.obtenerBuscados(buscar);
    }
    
}
