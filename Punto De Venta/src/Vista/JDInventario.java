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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author luisf
 */
public class JDInventario extends javax.swing.JDialog {

    //creamos un objeto del tipo interface ITituloDAO
    private IDAOManager manager = null;
    
    //el modelo para nuestra tabla tblAutores
    private InventarioTableModel model;
    
    //propiedad para modificar el width de nuestra tabla tblInventario
    TableColumnModel columnModel = null;
    
    public JDInventario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            
            //creamos la propiedad para manejar nuestros DAO
            this.manager = new MySQLDAOManager();
            
            //llamada al metodo para inicializar la tabla tblInventario
            inicializarListaInventario();
            
            actualizarListaInventario();
            
            this.tblInventario.getSelectionModel().addListSelectionListener(e -> {
                boolean seleccionValida = (tblInventario.getSelectedRow() != -1);
                btnModificar.setEnabled(seleccionValida);
                btnEliminar.setEnabled(seleccionValida);
            });
            
            //Se centra el dialog
            this.setLocationRelativeTo(null);
        } catch (DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(236, 214, 67));

        jPanel1.setBackground(new java.awt.Color(236, 214, 67));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Buscador:"));

        txtBuscar.setBackground(new java.awt.Color(195, 153, 62));

        btnBuscar.setBackground(new java.awt.Color(195, 153, 62));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setText("Total de Productos:");

        jLabel2.setText("0");

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblInventario);

        jToolBar1.setBackground(new java.awt.Color(236, 214, 67));
        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNuevo.setBackground(new java.awt.Color(195, 153, 62));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);
        jToolBar1.add(jSeparator1);

        btnModificar.setBackground(new java.awt.Color(195, 153, 62));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.setFocusable(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnModificar);

        btnEliminar.setBackground(new java.awt.Color(195, 153, 62));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);
        jToolBar1.add(jSeparator2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        JDFormularioProducto miFP = new JDFormularioProducto(null, true);
        miFP.setLocationRelativeTo(null);
        miFP.setVisible(true);
        try {
            actualizarListaInventario();
        } catch(DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            //obtenemos el producto que se selecciono
            Producto miProducto = getProductoSeleccionado();
            //abrimos nuestro JDFormularioProducto para poder modificarlo
            JDFormularioProducto miFP = new JDFormularioProducto(null, true, miProducto);
            miFP.setLocationRelativeTo(null);
            miFP.setVisible(true);
            actualizarListaInventario();
        } catch(DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            Producto miProducto = getProductoSeleccionado();
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Deseas eliminar el producto seleccionado?", "Confirmar", 0);
            if(respuesta == 0) {
                manager.getProductoDAO().eliminar(miProducto.getCodigo());
                //si no ocurre una excepcion
                JOptionPane.showMessageDialog(null, "El titulo ha sido eliminado");
                actualizarListaInventario();
            }
        } catch(DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!txtBuscar.equals("")) {
            try {
                actualizarListaInventario(txtBuscar.getText());
            } catch(DAOException ex) {
                imprimirMensajeDeErrorDAO(ex);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    /**
     * inicializa los titulos de las columnas de nuestra tabla tblInventario
     */
    private void inicializarListaInventario() {
        model = new InventarioTableModel(manager.getProductoDAO());
        
        //asignamos el modelo pero sin llamar al metodo actualizar
        //ya que al iniciar el isbn esta en blanco
        tblInventario.setModel(model);
        
        //redimensionamos las celdas
        setJTableColumnsWidth(tblInventario, 850,50,40,40,40,40,60,40,40);
    }//fin del metodo inicializarListaInventario
    
    /**
     * actualiza el contenido de la tabla tblInventario
     * @throws DAOException 
     */
    private void actualizarListaInventario() throws DAOException {
        /*si no hay ningun error actualizamos la tabla
        *para mostrar los productos del inventario
        */
        model.updateModel();
        
        //hacemos que se reflejen los cambios
        model.fireTableDataChanged();
        
        //redimensionamos las celdas
        setJTableColumnsWidth(tblInventario, 850,50,40,40,40,40,60,40,40);
    }//fin del metodo actualizarListaAutores
    
    /**
     * actualiza el contenido de la tabla tblInventario con un parametro para buscar
     * @throws DAOException 
     */
    private void actualizarListaInventario(String buscar) throws DAOException {
        /*si no hay ningun error actualizamos la tabla
        *para mostrar los productos del inventario
        */
        model.updateModel(buscar);
        
        //hacemos que se reflejen los cambios
        model.fireTableDataChanged();
        
        //redimensionamos las celdas
        setJTableColumnsWidth(tblInventario, 850,50,40,40,40,40,60,40,40);
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
     * Metodo para saber el codigo del producto seleccionado en la tabla
     */
    private Producto getProductoSeleccionado() throws DAOException {
        String codigo = (String) tblInventario.getValueAt(tblInventario.getSelectedRow(), 0);
        return manager.getProductoDAO().obtener(codigo);
    }
}
