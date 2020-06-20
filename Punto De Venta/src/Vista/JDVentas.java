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
import java.sql.Date;
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
            
            //los botones se mantendran inactivos hasta que no se seleccionen en la tabla
            this.tblVentas.getSelectionModel().addListSelectionListener(e -> {
                 boolean seleccionValida = (tblVentas.getSelectedRow() != -1);
                btnDetalles.setEnabled(seleccionValida);
            });
            
            //Se centra el dialog
            this.setLocationRelativeTo(null);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        dateBusqueda = new com.toedter.calendar.JDateChooser();
        btnDetalles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

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

        btnSalir.setBackground(new java.awt.Color(195, 153, 62));
        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(195, 153, 62));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        dateBusqueda.setBackground(new java.awt.Color(195, 153, 62));

        btnDetalles.setBackground(new java.awt.Color(195, 153, 62));
        btnDetalles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/detalleVenta.png"))); // NOI18N
        btnDetalles.setText("Detalles");
        btnDetalles.setEnabled(false);
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dateBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDetalles))
                                .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 95, Short.MAX_VALUE)
                        .addComponent(btnDetalles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            //Obtenemos la fecha seleccionada en el DateChooser
            Date fecha = new Date(dateBusqueda.getDate().getTime());
            //Actualizamos la lista basandonos en la fecha obtenida
            actualizarListaVentas(fecha);
        } catch(DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Seleccione una fecha.", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser dateBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
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
     * inicializa los titulos de las columnas de nuestra tabla tblVentas
     */
    private void inicializarListaVentas() {
        model = new VentasTableModel(manager.getVentaDAO());
        
        //asignamos el modelo pero sin llamar al metodo actualizar
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
    
    /**
     * actualiza el contenido de la tabla tblVentas con la busqueda por fecha
     * @throws DAOException 
     */
    private void actualizarListaVentas(Date fecha) throws DAOException {
        /*si no hay ningun error actualizamos la tabla
        *para mostrar las ventas
        */
        model.updateModel(fecha);
        
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
