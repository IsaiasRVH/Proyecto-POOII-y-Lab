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
import Modelo.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luisf
 */
public class JDFormularioProducto extends javax.swing.JDialog {

    //propiedades
    String codigo;
    String modelo;
    String marca;
    String color;
    String estilo;
    double existencias;
    double precio;
    int idProveedor;
    
    //objeto de tipo Producto
    Producto producto = null;
    
    //creamos nuestro manager para manejar los DAO
    private IDAOManager manager = null;
    
    //Los ids de los usuarios en el combobox
    int idsProveedores[];
    
    public JDFormularioProducto(java.awt.Frame parent, boolean modal, Producto producto) {
        super(parent, modal);
        initComponents();
        //creamos la propiedad para manejar nuestros DAO
        this.manager = new MySQLDAOManager();
        this.producto = producto;
        //cargamos el combobox con los proveedores
        cargarProveedores();
        //cargamos el prodcuto a modificar
        cargarProducto();
        //desabilitamos el txtCodigo
        txtCodigo.setEnabled(false);
        
        //Se centra el dialog
        this.setLocationRelativeTo(null);
    }
    
    public JDFormularioProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //creamos la propiedad para manejar nuestros DAO
        this.manager = new MySQLDAOManager();
        //cargamos el combobox con los proveedores
        cargarProveedores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtEstilo = new javax.swing.JTextField();
        txtExistencias = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        cmbProveedores = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        btnGuardar.setBackground(new java.awt.Color(195, 153, 62));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(195, 153, 62));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos del Producto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("IDProveedor:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Precio:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Existencias:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Estilo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Color:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Modelo:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        txtCodigo.setBackground(new java.awt.Color(195, 153, 62));

        txtModelo.setBackground(new java.awt.Color(195, 153, 62));

        txtMarca.setBackground(new java.awt.Color(195, 153, 62));

        txtColor.setBackground(new java.awt.Color(195, 153, 62));

        txtEstilo.setBackground(new java.awt.Color(195, 153, 62));

        txtExistencias.setBackground(new java.awt.Color(195, 153, 62));

        txtPrecio.setBackground(new java.awt.Color(195, 153, 62));

        cmbProveedores.setBackground(new java.awt.Color(195, 153, 62));
        cmbProveedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if(producto == null) {//verificamos para saber si es una insercion o una modificacion
            if(validarDatos()) {
                    if(!validarCodigo()) { //se valida que no se repita el codigo
                    //llamamos al constructor para crear un objeto de tipo Producto
                    Producto miProducto = new Producto(codigo, modelo, marca, color, estilo,existencias, precio, idProveedor);

                    try {
                        manager.getProductoDAO().insertar(miProducto);
                        JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
                        limpiarFormulario();
                    } catch(DAOException ex) {
                        imprimirMensajeDeErrorDAO(ex);
                    }
                }
            }
        } else { //si codigo != null entonces se quiere hacer una modificacion
            if(validarDatos()) {

                //llamamos al constructor para crear un objeto de tipo Producto
                Producto miProducto = new Producto(codigo, modelo, marca, color, estilo,existencias, precio, idProveedor);

                try {
                    manager.getProductoDAO().modificar(miProducto);
                    JOptionPane.showMessageDialog(null, "Los cambios han sido guardados");
                } catch(DAOException ex) {
                    imprimirMensajeDeErrorDAO(ex);
                }
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtEstilo;
    private javax.swing.JTextField txtExistencias;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    /**
     * Valida los datos de entrada del formulario
     * @return true si todos son validos correctamente, false en caso contrario
     */
    private boolean validarDatos() {
        boolean validacion = false;
        codigo = txtCodigo.getText().trim();
        modelo = txtModelo.getText().trim();
        marca = txtMarca.getText().trim();
        color = txtColor.getText().trim();
        estilo = txtEstilo.getText().trim();

        if(codigo.equals("")) {
            JOptionPane.showMessageDialog(null, "Especifica el codigo del producto");
            return validacion;
        }

        if(modelo.equals("")) {
            JOptionPane.showMessageDialog(null, "Especifica el modelo del producto");
            return validacion;
        }

        if(marca.equals("")) {
            JOptionPane.showMessageDialog(null, "Especifica la marca del producto");
            return validacion;
        }

        if(color.equals("")) {
            JOptionPane.showMessageDialog(null, "Especifica el color del producto");
            return validacion;
        }

        if(estilo.equals("")) {
            JOptionPane.showMessageDialog(null, "Especifica el estilo del producto");
            return validacion;
        }

        try {
            existencias = Double.parseDouble(txtExistencias.getText());
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Especifica las existencias del producto",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return validacion;
        }
        
        try {
            precio = Double.parseDouble(txtPrecio.getText());
        } catch(NumberFormatException ex) {
             JOptionPane.showMessageDialog(null, "Especifica el precio del producto",
                        "Error", JOptionPane.ERROR_MESSAGE);
             return validacion;
        }
        
        if(cmbProveedores.getSelectedIndex() != 0) {
            idProveedor = idsProveedores[cmbProveedores.getSelectedIndex() - 1];
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un proveedor para el producto");
            return validacion;
        }
    
        return true;
    }
    
    //metodo para verificar si el codigo no se repite
    public boolean validarCodigo() {
        codigo = txtCodigo.getText();
        boolean validacion = false;
        int index = 0;
        
        //obtenemos todos los codigos de la base de datos
        //creamos una lista
        List<Producto> misProductos = new ArrayList<>();
        
        try {
            misProductos = manager.getProductoDAO().obtenerTodos();
            while(!validacion && index < misProductos.size()) {
                Producto miProducto = misProductos.get(index);
                if(miProducto.getCodigo().equals(codigo)) {
                    //una correspondencia. Podemos dejar de buscar
                    validacion = true;
                } else {
                    index ++;
                }
            }
        } catch (DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
        if(validacion) {
            JOptionPane.showMessageDialog(null, "El codigo se repite, agrega otro");
        }
        return validacion;
    }//fin del metodo validarCodigo
    
    //metodo para cargar los proveedores existentes al combobox
    public void cargarProveedores(){
        try {
            //nuestra lista de los proveedores
            ArrayList<Proveedor> proveedores = new ArrayList<>();
            //se obtienen los proveedores de la base de datos
            proveedores = (ArrayList<Proveedor>) manager.getProveedorDAO().obtenerTodos();
            //En este arreglo se guardan los ids de los proveedores, en el mismo orden en que se agregan al combobox
            idsProveedores = new int [proveedores.size()];
            //se recorren todos los proveedores obtenidos
            for (Proveedor proveedor : proveedores) {
                //ak combobox se agrega un item formado por el nombre del proveedor
                cmbProveedores.addItem(proveedor.getNombre());
                //se agrega el id del proveedor al arreglo en la misma posicion en la que se agrego al combobox
                idsProveedores[cmbProveedores.getItemCount()-2] = proveedor.getIdProveedor();
            }
            
        } catch (DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, 
                "No se ha podido cargar los proveedores." + "\n" + 
                    "Vuelve a intentarlo.",
                "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

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
    
    //metodo para cargar un producto a modificar en las cajas de texto
    private void cargarProducto() {
        txtCodigo.setText(producto.getCodigo());
        txtModelo.setText(producto.getModelo());
        txtMarca.setText(producto.getMarca());
        txtColor.setText(producto.getColor());
        txtEstilo.setText(producto.getEstilo());
        txtExistencias.setText(String.valueOf(producto.getExistencias()));
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        cmbProveedores.setSelectedIndex(producto.getIdProveedor());
    }
    
    private void limpiarFormulario() {
        //limpiamos las cajas de texto
        txtCodigo.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        txtColor.setText("");
        txtEstilo.setText("");
        txtExistencias.setText("");
        txtPrecio.setText("");
        
        //ponemos el combobox en posicion 0
        cmbProveedores.setSelectedIndex(0);
    }
}
