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
    
    
    
    public GenerarReporte(int idVenta, Double pago) throws DAOException{
          try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\Ticket.jasper";
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
           
            conectar();
            
            Map parametros = new HashMap();
            parametros.put("idVenta", idVenta);
            parametros.put("pago", pago);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, conn);
            
            JasperViewer view = new JasperViewer(jprint, false);
            
            JDialog dialog = new JDialog((Frame) null,true);
            dialog.setContentPane(view.getContentPane());
            dialog.setSize(view.getSize());
            dialog.setTitle("Ticket de Venta");
            dialog.setVisible(true);
            
            desconectar();
        } catch (JRException ex) {
            throw new DAOException("No se ha podido generar el ticket.");
        }
    }
    
    
    public void conectar() throws DAOException {
        conn = Conectar.realizarConexion();
    }
    
    
    public void desconectar() throws DAOException {
        Conectar.desconectarConnection(conn);
    }

    public Connection getConn() {
        return conn;
    }
}
