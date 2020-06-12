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
public class ProductosVentaTableModel extends AbstractTableModel{
    //propiedades
    private IProductoDAO producto;
    //lista de elementos de tipo Producto
    private List<Producto> datos = new ArrayList<>();
    
    //constructor con un parametro
    public ProductosVentaTableModel (IProductoDAO producto) {
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
            case 5: return "Precio Unit.";
            case 6: return "Cantidad";
            case 7: return "Importe";
            default: return "[no]";
        }
    }
    
    /**
     * retorna el numero de elementos obtenidos de la tabla productos
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
        Producto preguntado = datos.get(rowIndex);
        switch(columnIndex) {
            case 0: preguntado.getCodigo();
            case 1: preguntado.getModelo();
            case 2: preguntado.getMarca();
            case 3: preguntado.getColor();
            case 4: preguntado.getEstilo();
            case 5: preguntado.getPrecio();
            default: return "";
        }
    }
    
    /**
     * Muestra una lista de la tabla Productos se que esten agregando
     * @param codigo
     */
    
    //queda pendiente este metodo
    public void updateModel(String codigo) throws DAOException {
        datos = (List<Producto>) producto.obtener(codigo);
    }
    
}
