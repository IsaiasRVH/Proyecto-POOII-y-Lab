/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DAO.DAOException;
import DAO.IDAOManager;
import DAOMySQL.MySQLDAOManager;
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
    private IDAOManager manager = null;
    //lista de elementos de tipo Producto
    private List<Producto> datos = null;
    private List<Integer> cantidad = null;
    
    //constructor con un parametro
    public ProductosVentaTableModel () {
        manager = new MySQLDAOManager();
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
            case 5: return preguntado.getPrecio();
            case 6: return cantidad.get(rowIndex);
            case 7: return cantidad.get(rowIndex) * preguntado.getPrecio();
            default: return "";
        }
    }
    
    /**
     * Muestra una lista de la tabla Productos se que esten agregando
     * @param codigo
     */
    public void updateModel(String codigo) throws DAOException {
        boolean existente = false;
        for(int i = 0; i < datos.size(); i++) {
          if(datos.get(i).getCodigo().equals(codigo)) {
            existente = true;
            if(cantidad.get(i) + 1 > datos.get(i).getExistencias()) {
                throw new DAOException("Producto agotado.");
            }
            else {
                cantidad.set(i, cantidad.get(i)+1);
            }
            i = datos.size();
          }
        }
        if(!existente) {
            Producto temp = manager.getProductoDAO().obtener(codigo);
            if(temp.getExistencias() > 0) {
                datos.add(temp);
                Integer cant = 1;
                cantidad.add(1);
            }
            else {
                throw new DAOException("Producto agotado.");
            }
        }
    } 

    /**
    * Limpia la tabla
    **/
    public void cleanModel() {
      datos = new ArrayList<>();
      
      cantidad = new ArrayList<>();
    
    }
}
