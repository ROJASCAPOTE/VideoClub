package Vista;

import Controlador.AddressListController;
import Controlador.StoreListController;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Staff;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmStore extends javax.swing.JInternalFrame {

    private Staff administrador;
    private DAOManager manager;
    private Staff staff = null;

    public DAOManager getManager() {
        return manager;
    }

    public void setManager(DAOManager manager) {
        this.manager = manager;
    }
    String ruta, nombre;
    File fichero = null;
    private JPanel contentPane;

    public FrmStore() {
        initComponents();
    }

    public String getTextIdStore() {
        return textIdStore.getText();
    }

    public void setTextIdStore(String textIdStore) {
        this.textIdStore.setText(textIdStore);
    }

    public void setTextAdministrador(JTextField textAdministrador) {
        this.textAdministrador = textAdministrador;
    }

    public JComboBox<String> getCombAddressStore() {
        return combAddressStore;
    }

    public String getTextAdministrador() {
        return textAdministrador.getText();
    }

    public void setAdministrador(Staff administrador) {
        this.administrador = administrador;
    }

    public void setTextAdministrador(int textAdministrador) {
        this.textAdministrador.setText(textAdministrador + "");
    }

    public boolean getRdbNo() {
        return rdbNo.isSelected();
    }

    public boolean getRdbSi() {
        return rdbSi.isSelected();
    }

    public void setRdbNo(boolean rdbNo) {
        this.rdbNo.setSelected(rdbNo);
    }

    public void setRdbSi(boolean rdbSi) {
        this.rdbSi.setSelected(rdbSi);
    }

    public JComboBox<String> getCombAddresManager() {
        return combAddresManager;
    }

    public void addressManager() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        ArrayList<Address> listadoDirecciones;
        listadoDirecciones = manager.getAddressDAO().listadoAddress();
        for (Object direcciones : listadoDirecciones) {
            modelo.addElement(direcciones);
        }
        getCombAddresManager().setModel(modelo);
    }

    public void saveData() {
        if (staff == null) {
            staff = new Staff();
        }
        boolean active = false;
        staff.setStaff_id(Integer.parseInt(textAdministrador.getText()));
        staff.setFirst_name(textFirstName.getText());
        staff.setLast_name(textLastName.getText());
        Address address = (Address) getCombAddresManager().getSelectedItem();
        staff.setAddressId(address.getAddressId());
        staff.setEmail(textEamil.getText());
        staff.setStore_id(Integer.parseInt(textIdStore.getText()));
        if (rdbSi.isSelected()) {
            active = true;
        }
        staff.setActive(active);

        staff.setUsername(textUserName.getText());
        staff.setPassword(textPassword.getText());
    }

    public Staff getStaff() {
        return staff;
    }

    public void limpiarCampos() {
        combAddressStore.setSelectedIndex(0);
        textAdministrador.setText("");
        textLastName.setText("");
        textFirstName.setText("");
        textLastName.setText("");
        combAddresManager.setSelectedIndex(0);
        textEamil.setText("");
        textUserName.setText("");
        textPassword.setText("");
        rdbSi.setSelected(true);
    }

    public void gestionMensajes(String mensaje, String titulo, int icono) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
    }

    public void addListenerNuevo(ActionListener listenerStore) {
        btnNuevo.addActionListener(listenerStore);
    }

    public void addListenerBtnModificar(ActionListener listenerStore) {
        btnModificar.addActionListener(listenerStore);
    }

    public void cargarDireccionStore(ArrayList<Address> ListAddress) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Object direcciones : ListAddress) {
            modelo.addElement(direcciones);
        }
        combAddressStore.setModel(modelo);
    }

    public void obtenerManager(Staff f) {
        DefaultComboBoxModel modelocbxManager;
        modelocbxManager = (DefaultComboBoxModel) combAddresManager.getModel();
        textFirstName.setText(f.getFirst_name());
        textLastName.setText(f.getLast_name());
        modelocbxManager.setSelectedItem(f);
        textEamil.setText(f.getEmail());
        if (f.isActive() == true) {
            rdbSi.setSelected(true);
        }
        if (f.isActive() == false) {
            rdbNo.setSelected(true);
        }
        textUserName.setText(f.getUsername());

    }

    public void activarControlesModificar(boolean estado) {
        textIdStore.setEnabled(!estado);
        textAdministrador.setEnabled(estado);
        combAddressStore.setEnabled(estado);
        textFirstName.setEnabled(estado);
        textLastName.setEnabled(estado);
        combAddresManager.setEnabled(estado);
        textEamil.setEnabled(estado);
        textUserName.setEnabled(estado);
        textPassword.setEnabled(estado);
        btnModificar.setEnabled(estado);

    }

    public void activarControles(boolean estado) {
        textIdStore.setEnabled(false);
        combAddressStore.setEnabled(estado);
        textAdministrador.setEnabled(false);
        textFirstName.setEnabled(estado);
        textLastName.setEnabled(estado);
        combAddresManager.setEnabled(estado);

        textEamil.setEnabled(estado);
        textUserName.setEnabled(estado);
        textPassword.setEnabled(estado);
        btnModificar.setEnabled(estado);
        btnBuscarAddressStore.setEnabled(estado);
    }

    public void nuevoAction() {
        if (btnNuevo.getText().equals("Nuevo")) {
            combAddressStore.setSelectedIndex(0);
            BtnBuscarStore.setEnabled(false);
            activarControles(true);
            btnNuevo.setText("Grabar");
            btnNuevo.setActionCommand("Grabar");
            btnModificar.setText("Cancelar");
            btnModificar.setActionCommand("Cancelar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/Save.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/Cancel.png"))); // NOI18N
            textIdStore.requestFocusInWindow();

        } else {
            activarControles(false);
            limpiarCampos();
            btnNuevo.setText("Nuevo");
            btnNuevo.setActionCommand("Nuevo");
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            BtnBuscarStore.setEnabled(true);
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
        textIdStore.requestFocusInWindow();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textIdStore = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BtnBuscarStore = new javax.swing.JButton();
        btnBuscarAddressStore = new javax.swing.JButton();
        combAddressStore = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        textAdministrador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textLastName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combAddresManager = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        textEamil = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textUserName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        rdbSi = new javax.swing.JRadioButton();
        rdbNo = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        texIdManager = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Store", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Store");

        textIdStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdStoreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address Store");

        BtnBuscarStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar.png"))); // NOI18N
        BtnBuscarStore.setBorder(null);
        BtnBuscarStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarStoreActionPerformed(evt);
            }
        });

        btnBuscarAddressStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dir.png"))); // NOI18N
        btnBuscarAddressStore.setBorder(null);
        btnBuscarAddressStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAddressStoreActionPerformed(evt);
            }
        });

        combAddressStore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textIdStore, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combAddressStore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BtnBuscarStore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarAddressStore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textIdStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(BtnBuscarStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combAddressStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(btnBuscarAddressStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnNuevo.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\New.png")); // NOI18N
        btnNuevo.setText("Nuevo");

        btnModificar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Modify.png")); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Get out.png")); // NOI18N
        btnSalir.setText("Salir");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Administrador.png"))); // NOI18N
        jButton3.setText("Manager");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificar)
                        .addComponent(btnSalir)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Manager");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name");

        textFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFirstNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address Manager");

        combAddresManager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("User Name");

        textUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserNameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Active");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdbSi)
                        .addGap(18, 18, 18)
                        .addComponent(rdbNo))
                    .addComponent(textPassword)
                    .addComponent(textUserName)
                    .addComponent(textFirstName)
                    .addComponent(textAdministrador)
                    .addComponent(textLastName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combAddresManager, javax.swing.GroupLayout.Alignment.TRAILING, 0, 389, Short.MAX_VALUE)
                    .addComponent(textEamil, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(texIdManager))
                .addGap(248, 248, 248))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(textAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texIdManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combAddresManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEamil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbSi)
                    .addComponent(rdbNo)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIdStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdStoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIdStoreActionPerformed

    private void btnBuscarAddressStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAddressStoreActionPerformed
        FrmListAddress addressListView = new FrmListAddress();
        AddressListController controller = new AddressListController(addressListView, manager);
        controller.setVistaStore(this);
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - addressListView.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - addressListView.getHeight() / 2;

        if (addressListView.isShowing()) {
            addressListView.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(addressListView);
            addressListView.setLocation(x, y);
            addressListView.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarAddressStoreActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        addressManager();
    }//GEN-LAST:event_formInternalFrameOpened

    private void BtnBuscarStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarStoreActionPerformed
        FrmListStore frmListStore = new FrmListStore();
        StoreListController listController = new StoreListController(frmListStore, manager);
        listController.setFrmStore(this);
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - frmListStore.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - frmListStore.getHeight() / 2;

        if (frmListStore.isShowing()) {
            frmListStore.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(frmListStore);
            frmListStore.setLocation(x, y);
            frmListStore.setVisible(true);
        }
    }//GEN-LAST:event_BtnBuscarStoreActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void textFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFirstNameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void textUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUserNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarStore;
    private javax.swing.JButton btnBuscarAddressStore;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> combAddresManager;
    private javax.swing.JComboBox<String> combAddressStore;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton rdbNo;
    private javax.swing.JRadioButton rdbSi;
    private javax.swing.JTextField texIdManager;
    private javax.swing.JTextField textAdministrador;
    private javax.swing.JTextField textEamil;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textIdStore;
    private javax.swing.JTextField textLastName;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUserName;
    // End of variables declaration//GEN-END:variables

}
