/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import DAO.DAOException;
import MySQLConection.Conectar;
import java.awt.Frame;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Isaías Ricardo Valdivia Hernández
 */
public class GenerarReporte {
    //La conexion a la base de datos
    private Connection conn;
    
    
    
    public GenerarReporte(int idVenta, Double pago, String tipo) throws DAOException{
          try {
            //Variable para generar el reporte
            JasperReport reporte = null;
            //Ruta donde se encuentra el reporte
            String path = "src\\Reportes\\Ticket" + tipo + ".jasper";
            
            //Se carga el reporte del archivo
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
           
            //Se establece conexion con la base de datos
            conectar();
            
            //Se crea el Map y se agregan los parametros necesarios
            Map parametros = new HashMap();
            parametros.put("idVenta", idVenta);
            parametros.put("pago", pago);
            
            //Se crea el JasperPrint con el reporte cargado, los parametros y la conexion
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, conn);
            
            //Se crea la vista para el reporte
            JasperViewer view = new JasperViewer(jprint, false);
            
            //La vista se asigna a un JDialog para que este hasta el frente de las ventanas
            JDialog dialog = new JDialog((Frame) null,true);
            dialog.setContentPane(view.getContentPane());
            dialog.setSize(view.getSize());
            dialog.setTitle("Ticket de Venta");
            dialog.setVisible(true);
            
            //Se cierra la conexion con la base de datos
            desconectar();
        } catch (JRException ex) {
            throw new DAOException("No se ha podido generar el ticket.");
        }
    }
    
    
    public void conectar() throws DAOException {
        //Se obtiene una conexion a la base de datos
        conn = Conectar.realizarConexion();
    }
    
    
    public void desconectar() throws DAOException {
        //Se cierra la conexxion con la base de datos
        Conectar.desconectarConnection(conn);
    }
}
