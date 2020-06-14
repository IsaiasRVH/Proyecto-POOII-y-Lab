/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DAO.DAOException;
import DAO.IDAOManager;
import DAOMySQL.MySQLDAOManager;
import Modelo.Venta;
import static Vista.JDInventario.setJTableColumnsWidth;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author luisf
 */
public class JDVentas extends javax.swing.JDialog {
    
    //creamos un objeto del tipo interface IVentaDAO
    private IDAOManager manager = null;

    //el modelo para nuestra tabla tblVentas
    private VentasTableModel model;
    
    //propiedad para modificar el width de nuestra tabla tblInventario
    TableColumnModel columnModel = null;

    /**
     * Creates new form JDVentas
     */
    public JDVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            
            //creamos la propiedad para manejar nuestros DAO
            this.manager = new MySQLDAOManager();
            
            //llamada al metodo para inicializar la tabla tblVentas
            inicializarListaVentas();
            //actualizamos la tabla tblVentas con las ventas realizadas
            actualizarListaVentas();
            
            this.tblVentas.getSelectionModel().addListSelectionListener(e -> {
                 boolean seleccionValida = (tblVentas.getSelectedRow() != -1);
                btnDetalles.setEnabled(seleccionValida);
            });
            
        } catch (DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDetalles = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVentas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Administración de Ventas");

        btnDetalles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/detalleVenta.png"))); // NOI18N
        btnDetalles.setText("Detalles");
        btnDetalles.setEnabled(false);
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDetalles)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(62, 62, 62))))
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDetalles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        try {
            //obtenemos el producto que se selecciono
            Venta miVenta = getVentaSeleccionada();
            //abrimos nuestro JDDetalleVenta para poder visualizar los detalles de venta
            JDDetalleVenta miDV = new JDDetalleVenta(null, true, miVenta);
            miDV.setLocationRelativeTo(null);
            miDV.setVisible(true);
        } catch (DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDVentas dialog = new JDVentas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables

    /**
     * Imprime un mensaje de error personalizado para aquellos errores que son
     * producidos por el acceso a la base de datos
     * @param ex objeto de tipo DAOException
     */
    private void imprimirMensajeDeErrorDAO(DAOException ex) {
        //Si getMessage existe obtenemos su valor
        String mensajeError;
        
        try {
            mensajeError = "Mensaje: "+ ex.getCause().getMessage();
        } catch (NullPointerException error) {
            mensajeError = "";
        }
        
        JOptionPane.showMessageDialog(null, ex.getMessage()+"\n"+mensajeError, "Error",
                JOptionPane.ERROR_MESSAGE);
    }//fin del metodo imprimirMensajeDeErrorDAO
    
    /**
     * inicializa los titulos de las columnas de nuestra tabla tblInventario
     */
    private void inicializarListaVentas() {
        model = new VentasTableModel(manager.getVentaDAO());
        
        //asignamos el modelo pero sin llamar al metodo actualizar
        //ya que al iniciar el isbn esta en blanco
        tblVentas.setModel(model);
        
        //redimensionamos las celdas
        setJTableColumnsWidth(tblVentas, 480,60, 60, 60, 60, 50, 50);
    }//fin del metodo inicializarListaInventario
    
    /**
     * actualiza el contenido de la tabla tblVentas
     * @throws DAOException 
     */
    private void actualizarListaVentas() throws DAOException {
        /*si no hay ningun error actualizamos la tabla
        *para mostrar las ventas
        */
        model.updateModel();
        
        //hacemos que se reflejen los cambios
        model.fireTableDataChanged();
        
        //redimensionamos las celdas
        setJTableColumnsWidth(tblVentas, 480,60, 60, 60, 60, 50, 50);
    }//fin del metodo actualizarListaAutores
    
    
    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
            double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }
        
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (tablePreferredWidth * (percentages[i] / total)));
        }
    }//fin del metodo setJTable

    /**
     * Metodo para saber el codigo del producto seleccionado en la tabla
     */
    private Venta getVentaSeleccionada() throws DAOException {
        int id = (int) tblVentas.getValueAt(tblVentas.getSelectedRow(), 0);
        return manager.getVentaDAO().obtener(id);
    }
}
