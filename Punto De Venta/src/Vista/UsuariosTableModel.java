/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import DAO.DAOException;
import DAO.IDAOManager;
import DAO.IUsuarioDAO;
import DAOMySQL.MySQLDAOManager;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Isaías Ricardo Valdivia Hernández
 */
public class UsuariosTableModel extends AbstractTableModel {
    
    //propiedades
    private IDAOManager manager = null;
    private IUsuarioDAO usuario = null;
    
    //lista de elementos de tipo Titulo
    private List<Usuario> datos = new ArrayList<>();
    
    //constructor sin parametros
    public UsuariosTableModel() {
        manager = new MySQLDAOManager();
    }

    /**
     * retorna el nombre de cada columna
     * @param column
     * @return 
     */
    @Override
    public String getColumnName(int column) {
        switch( column ) {
            case 0: return "ID Usuario";
            case 1: return "Nombre";
            case 2: return "Apellidos";
            case 3: return "Dirección";
            case 4: return "Colonia";
            case 5: return "Código Postal";
            case 6: return "Ciudad";
            case 7: return "Estado";
            case 8: return "País";
            case 9: return "E-Mail";
            case 10: return "Teléfono";
            case 11: return "Salario";
            default: return "[no]";
        }
    }
    
    /**
     * retorna el número de elementos obtenidos de la tabla títulos
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
        return 12;
    }

    /**
     * retorna el valor que contenga la interseccion de una fila y columna 
     * pasadas como parametros
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario preguntado = datos.get(rowIndex);
        switch( columnIndex ) {
            case 0: return preguntado.getIdUsuario();
            case 1: return preguntado.getNombre();
            case 2: return preguntado.getApellidos();
            case 3: return preguntado.getCalleYNumero();
            case 4: return preguntado.getColonia();
            case 5: return preguntado.getCodigoPostal();
            case 6: return preguntado.getCiudad();
            case 7: return preguntado.getEstado();
            case 8: return preguntado.getPais();
            case 9: return preguntado.getEmail();
            case 10: return preguntado.getTelefono();
            case 11: return preguntado.getSalario();
            default: return "";
        }
    }
    
    /**
     * Actualiza el modelo con los usuarios obtenidos
     * @param parametro El parametro con el que se buscara, ya sea null para
     * obtener todos o el apellido, nombre o ID para obtener solo los que 
     * coincidan con la busqueda.
     * @throws DAOException 
     */
    public void updateModel (String parametro )throws DAOException {
        if(parametro.equals("")){
            datos = manager.getUsuarioDAO().obtenerTodos();
        }
        else {
            datos = manager.getUsuarioDAO().obtenerBuscados(parametro);
        }
    }
    
}
