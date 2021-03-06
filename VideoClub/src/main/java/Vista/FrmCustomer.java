/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AddressController;
import Controlador.AddressListController;
import Modelo.Address;
import Modelo.Customer;
import Modelo.Dao.DAOManager;
import Modelo.Store;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class FrmCustomer extends javax.swing.JInternalFrame {

    private Customer customer;
    private DAOManager manager;
    private Address address;
    private AddressController addressController;

    public FrmCustomer() {
        initComponents();
    }

    public void setManager(DAOManager manager) {
        this.manager = manager;
    }

    public void salveData() {
        if (customer == null) {
            customer = new Customer();
        }
        boolean active = false;
        int customer_id = Integer.parseInt(textCustomerId.getText());
        customer.setCustomerId(customer_id);
        Store store = (Store) cmbStore.getSelectedItem();
        customer.setStore(store);
        customer.setFirstName(textFirsName.getText());
        customer.setLastName(textLastName.getText());
        customer.setEmail(textEmail.getText());
        customer.setAddress(address);
        if (rdbSi.isSelected()) {
            active = true;
        }
        customer.setActive(active);

    }

    public Customer getCustomer() {
        return customer;
    }

    public void customerId(int codigo) {
        String numCadena = String.valueOf(codigo);
        textCustomerId.setText(numCadena);

    }

    public void cargarStore(ArrayList<Store> ListaTiendas) {
        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        for (Object tiendas : ListaTiendas) {
            mod.addElement(tiendas);
        }
        cmbStore.setModel(mod);
    }

//    public void cargarDireccioneCustomer(ArrayList<Address> ListAddress) {
//        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
//        modelo.addElement("Select Address");
//        for (Object direcciones : ListAddress) {
//            modelo.addElement(direcciones);
//        }
//        combAddress.setModel(modelo);
//    }
//    
//    public void cargarDireccioneCustomer() {
//        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
//        combAddress.setModel(modelo);
//    }
//    
    public void mostrarCustomer(Customer c) {
        this.address = c.getAddress();
        DefaultComboBoxModel modeloStore;
        modeloStore = (DefaultComboBoxModel) getCmbStore().getModel();

        String customer_id = String.valueOf(c.getCustomerId());
        textCustomerId.setText(customer_id);
        modeloStore.setSelectedItem(c.getStore());
        textFirsName.setText(c.getFirstName());
        textLastName.setText(c.getLastName());
        textAddess.setText(c.getAddress().getAddress());
        textEmail.setText(c.getEmail());
        if (c.isActive() == true) {
            rdbSi.setSelected(true);
        }
        if (c.isActive() == false) {
            rdbNo.setSelected(true);
        }

    }

    public void setAddresCustomer(Address address) {
        this.address = address;
        textAddess.setText(address.getAddress());

    }

    public Address getAddress() {
        return address;
    }

    public JComboBox<String> getCmbStore() {
        return cmbStore;
    }

    public void addListenerNuevo(ActionListener listenerCustomer) {
        btnNuevo.addActionListener(listenerCustomer);
    }

    public void addListenerCerrar(ActionListener listenerCustomer) {
        btnSalir.addActionListener(listenerCustomer);
    }

    public void addListenerBtnModificar(ActionListener listenerCustomer) {
        btnModificar.addActionListener(listenerCustomer);
    }

    public void addListenerBtnBuscar(ActionListener listenerCustomer) {
        btnBuscar.addActionListener(listenerCustomer);
    }

    public void addListenerBtnEliminar(ActionListener listenerCustomer) {
        btnEliminar.addActionListener(listenerCustomer);
    }

    public void gestionMensajes(String mensaje, String titulo, int icono) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
    }

    public void cerrarAction() {
        dispose();
    }

    public void limpiarCampos() {
        cmbStore.setSelectedIndex(0);
        textFirsName.setText("");
        textLastName.setText("");
        textEmail.setText("");
        textAddess.setText("");
        address = null;
        rdbSi.setSelected(true);
    }

    public void activarControles(boolean estado) {
        textCustomerId.setEnabled(false);
        cmbStore.setEnabled(estado);
        textFirsName.setEnabled(estado);
        textLastName.setEditable(estado);
        textEmail.setEditable(estado);
        textAddess.setEnabled(false);
        rdbSi.setEnabled(estado);
        rdbNo.setEnabled(estado);
        textCreateData.setDate(Calendar.getInstance().getTime());
        textCreateData.setEnabled(estado);
        btnModificar.setEnabled(estado);
        btnEliminar.setEnabled(estado);
        btnAdicionarAddress.setEnabled(estado);
    }

    public void activarControlesModificar(boolean estado) {
        textCustomerId.setEnabled(false);
        cmbStore.setEnabled(estado);
        textFirsName.setEnabled(estado);
        textLastName.setEditable(estado);
        textEmail.setEditable(estado);
        textAddess.setEnabled(false);
        rdbSi.setEnabled(estado);
        rdbNo.setEnabled(estado);
        textCreateData.setDate(Calendar.getInstance().getTime());
        textCreateData.setEnabled(estado);
        btnModificar.setEnabled(estado);
        btnEliminar.setEnabled(estado);
        btnAdicionarAddress.setEnabled(estado);

    }

    public void nuevoAction() {
        if (btnNuevo.getText().equals("Nuevo")) {
            cmbStore.setSelectedIndex(0);
            textFirsName.setText("");
            textLastName.setText("");
            textEmail.setText("");
            textAddess.setText("");
            rdbSi.setSelected(true);
            activarControles(true);
            btnNuevo.setText("Grabar");
            btnNuevo.setActionCommand("Grabar");
            btnModificar.setText("Cancelar");
            btnModificar.setActionCommand("Cancelar");
            btnEliminar.setEnabled(false);
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/Save.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/Cancel.png"))); // NOI18N
            textFirsName.requestFocusInWindow();

        } else {
            activarControles(false);
            limpiarCampos();
            btnNuevo.setText("Nuevo");
            btnNuevo.setActionCommand("Nuevo");
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnNuevo.requestFocusInWindow();
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/New.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/Modify.png"))); // NOI18N
        }
    }

    public void modificarAction() {
        activarControlesModificar(true);
        btnNuevo.setText("Actualizar");
        btnNuevo.setActionCommand("Actualizar");
        btnModificar.setText("Cancelar");
        btnModificar.setActionCommand("Cancelar");
        btnNuevo.setIcon(new ImageIcon(getClass().
                getResource("/Modify.png"))); // NOI18N
        btnModificar.setIcon(new ImageIcon(getClass().
                getResource("/Cancel.png"))); // NOI18N
        textFirsName.requestFocusInWindow();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textCustomerId = new javax.swing.JTextField();
        cmbStore = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textFirsName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textCreateData = new com.toedter.calendar.JDateChooser();
        rdbSi = new javax.swing.JRadioButton();
        rdbNo = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textIdentificacion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAdicionarAddress = new javax.swing.JButton();
        textAddess = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Customer");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Store");

        cmbStore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Create Date");

        rdbSi.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rdbSi);
        rdbSi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbSi.setForeground(new java.awt.Color(255, 255, 255));
        rdbSi.setText("Si");

        rdbNo.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rdbNo);
        rdbNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbNo.setForeground(new java.awt.Color(255, 255, 255));
        rdbNo.setText("No");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Active");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\buscar.png")); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAdicionarAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionarAddress.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Dir.png")); // NOI18N
        btnAdicionarAddress.setBorder(null);
        btnAdicionarAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAddressActionPerformed(evt);
            }
        });

        textAddess.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(21, 21, 21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdbSi)
                                .addGap(18, 18, 18)
                                .addComponent(rdbNo))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbStore, 0, 369, Short.MAX_VALUE)
                                .addComponent(textFirsName)
                                .addComponent(textLastName)
                                .addComponent(textEmail)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(textAddess)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAdicionarAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(textCreateData, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(textCustomerId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(textCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(textFirsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(textAddess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionarAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbSi)
                    .addComponent(rdbNo)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCreateData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnNuevo.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\New.png")); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Modify.png")); // NOI18N
        btnModificar.setText("Modificar");

        btnSalir.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Get out.png")); // NOI18N
        btnSalir.setText("Salir");

        btnEliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Remove.png")); // NOI18N
        btnEliminar.setText("Eliminar");

        btnBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\LookFor.png")); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmListCustomer frmListCustomer = new FrmListCustomer();
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - frmListCustomer.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - frmListCustomer.getHeight() / 2;
        if (frmListCustomer.isShowing()) {
            frmListCustomer.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(frmListCustomer);
            frmListCustomer.setLocation(x, y);
            frmListCustomer.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAdicionarAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAddressActionPerformed
        FrmListAddress frmListAddress = new FrmListAddress();
        AddressListController controller = new AddressListController(frmListAddress, manager);
        controller.setCustomer(this);
        frmListAddress.setManager(manager);
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - frmListAddress.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - frmListAddress.getHeight() / 2;

        if (frmListAddress.isShowing()) {
            frmListAddress.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(frmListAddress);
            frmListAddress.setLocation(x, y);
            frmListAddress.setVisible(true);
        }
    }//GEN-LAST:event_btnAdicionarAddressActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAddress;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbStore;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rdbNo;
    private javax.swing.JRadioButton rdbSi;
    private javax.swing.JTextField textAddess;
    private com.toedter.calendar.JDateChooser textCreateData;
    private javax.swing.JTextField textCustomerId;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFirsName;
    private javax.swing.JTextField textIdentificacion;
    private javax.swing.JTextField textLastName;
    // End of variables declaration//GEN-END:variables
}
