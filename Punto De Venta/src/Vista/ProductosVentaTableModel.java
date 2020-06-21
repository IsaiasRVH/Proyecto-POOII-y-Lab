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
    * Se elimina el registro que esta en la posicion del index
    * @param index El indice del elemento a eliminar
    **/
    public void removeRow(int index) {
        datos.remove(index);
        cantidad.remove(index);
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
        //Variable para saber si el producto ya se encuentra en la tabla
        boolean existente = false;
        //Se recorren los registros de la tabla
        for(int i = 0; i < datos.size(); i++) {
            //Se comprueba si el producto de la iteracion actual es el mismo que el que se
            //quiere agregar
            if(datos.get(i).getCodigo().equals(codigo)) {
                //Si es el mismo existente se asigna a true
                existente = true;
                //Se comprueba si al agregar una unidad mas no se sobrepasen las existencias
                if(cantidad.get(i) + 1 > datos.get(i).getExistencias()) {
                    throw new DAOException("Producto agotado.");
                }
            else {
                //Si no se sobrepasaron las existencias se agrega una unidad
                //a la cantidad de elementos de ese codigo
                cantidad.set(i, cantidad.get(i)+1);
            }
            //Se asigna a i el tamaño de los datos para terminar el for
            i = datos.size();
          }
        }
        //Mira como termino la variable existente
        //Si termino en false significa que el producto no esta en la lista
        if(!existente) {
            //Se obtiene el producto que coincide con el codigo
            Producto temp = manager.getProductoDAO().obtener(codigo);
            //Se comprueba que haya en existencias
            if(temp.getExistencias() > 0) {
                //Si hay se agrega el producto a la lista
                datos.add(temp);
                //Tambien se agrega la cantidad al ArrayList de cantidad
                //Se asigna 1 porque es el primero de este codigo en la lista
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
