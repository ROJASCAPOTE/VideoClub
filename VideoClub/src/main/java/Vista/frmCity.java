/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CountryListViewController;
import Modelo.Country;
import Modelo.Dao.DAOManager;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class frmCity extends javax.swing.JInternalFrame {

    private DAOManager manager;
    public frmCity() {
        initComponents();
    }

    public void setTextCodigo(String codigo) {
        textCodigo.setText(codigo);
    }

    public String getTextCodigo() {
        return textCodigo.getText();
    }

    public void setTextCity(String city) {
        textCity.setText(city);
    }

    public String getTextCity() {
        return textCity.getText();
    }

    public Date getTextLastUpdate() {
        return textLastUpdate.getDate();
    }

    public JComboBox<String> getCombCountry() {
        return combCountry;
    }

    public DAOManager getManager() {
        return manager;
    }

    public void setManager(DAOManager manager) {
        this.manager = manager;
    }
    
    

//    public JTable getTableCity() {
//        return tableCity;
//    }

    public void cargarCountry(ArrayList<Country> ListCountry) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Object municipio : ListCountry) {
            modelo.addElement(municipio);
        }
        combCountry.setModel(modelo);
    }

//    public void tableCity(Object[][] dtCity) {
//        String[] columNames = {"Id", "City", "Country", "Last update"};
//        DefaultTableModel datos = new DefaultTableModel(dtCity, columNames);
//        tableCity.setModel(datos);
//    }

    public void gestionMensajes(String mensaje, String titulo, int icono) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
    }

    public void activarControles(boolean estado) {
        textCodigo.setEnabled(estado);
        textCity.setEnabled(estado);
        combCountry.setEnabled(estado);
        textLastUpdate.setEnabled(estado);
//        btnGuardar.setEnabled(estado);
//        btnModificar.setEnabled(estado);
//        btnEliminar.setEnabled(estado);
//        tableCity.setEnabled(estado);
//        btnCancelar.setEnabled(estado);
//        btnSalir.setEnabled(!estado);
//        tableCity.setEnabled(!estado);
    }

    public void campos(boolean estado) {
        textCity.setEnabled(estado);
        combCountry.setEnabled(estado);
        textLastUpdate.setEnabled(estado);

    }

    public void limpiarCampos() {
        textCodigo.setText("");
        textCity.setText("");
        combCountry.setSelectedIndex(0);
        textLastUpdate.setDate(null);
    }

//    public void activarBotonesCRUD(boolean activo) {
//        this.btnEliminar.setEnabled(activo);
//        this.btnModificar.setEnabled(activo);
//        btnGuardar.setEnabled(false);
//        textCodigo.setEnabled(false);
//        campos(activo);
//        activarNuevo(!activo);
//        activarCancelar(activo);
//    }
//
//    void activarBotonesGuardar(boolean activo) {
//        this.btnGuardar.setEnabled(activo);
//        this.btnCancelar.setEnabled(activo);
//    }

//    public void activarNuevo(boolean estado) {
//        btnNuevo.setEnabled(estado);
//    }
//
//    public void activarCancelar(boolean estado) {
//        btnCancelar.setEnabled(estado);
//    }
//
//    public void activarEditar(boolean estado) {
//        btnModificar.setEnabled(estado);
//        btnEliminar.setEnabled(estado);
//    }
//
//    public void addListenerBtnNuevo(ActionListener listenCity) {
//        btnNuevo.addActionListener(listenCity);
//    }
//
//    public void addListenerBtnGuardar(ActionListener listenCity) {
//        btnGuardar.addActionListener(listenCity);
//    }
//
//    public void addListenerBtnModificar(ActionListener listenCity) {
//        btnModificar.addActionListener(listenCity);
//    }
//    
//    public void addListenerBtnEliminar(ActionListener listenCity) {
//        btnEliminar.addActionListener(listenCity);
//    }
//
//    public void addListenerBtnCancelar(ActionListener listenCity) {
//        btnCancelar.addActionListener(listenCity);
//    }
//
//    public void addListenerBtnCerrar(ActionListener listenCity) {
//        btnSalir.addActionListener(listenCity);
//    }
//
//    public void addMouseListenerCity(MouseListener mouseCity) {
//        tableCity.addMouseListener(mouseCity);
//    }

    public void cerrarAction() {
        dispose();
    }

//    public void nuevoAction() {
//        textCodigo.setEnabled(true);
//        textCodigo.setText("");
//        textCity.setText("");
//        combCountry.setSelectedIndex(0);
//        textLastUpdate.setDate(null);
//        activarBotonesGuardar(true);
//        btnNuevo.requestFocusInWindow();
//        textCodigo.requestFocusInWindow();
//        activarNuevo(false);
//        campos(true);
//        btnNuevo.setActionCommand("Nuevo");
//
//    }
//
//    public void modificarAction() {
//        activarBotonesCRUD(false);
//        activarBotonesGuardar(false);
//        activarControles(false);
//        activarNuevo(true);
//
//    }
//
//    public void guardarAction() {
//        activarBotonesCRUD(false);
//        activarBotonesGuardar(false);
//        activarControles(false);
//        activarNuevo(true);
//    }
//
//    public void cancelarAction() {
//        activarBotonesCRUD(false);
//        activarBotonesGuardar(false);
//        activarControles(false);
//        activarNuevo(true);
//        limpiarCampos();
//    }

    public void camposObligatorios() {
        if (getTextCodigo().equals("")) {
            textCodigo.requestFocusInWindow();
            return;
        }

        if (getTextLastUpdate() == null) {
            textLastUpdate.requestFocusInWindow();
            return;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textCity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combCountry = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        textLastUpdate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "City", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("City");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Country");

        combCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lasp update");

        jButton1.setText(".....");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(combCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textCity)
                    .addComponent(textLastUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textLastUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmCountryView frmInsertarCountry = new FrmCountryView();
        CountryListViewController controller = new CountryListViewController(frmInsertarCountry, manager);
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - frmInsertarCountry.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - frmInsertarCountry.getHeight() / 2;

        if (frmInsertarCountry.isShowing()) {
            frmInsertarCountry.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(frmInsertarCountry);
            frmInsertarCountry.setLocation(x, y);
            frmInsertarCountry.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combCountry;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField textCity;
    private javax.swing.JTextField textCodigo;
    private com.toedter.calendar.JDateChooser textLastUpdate;
    // End of variables declaration//GEN-END:variables

}
