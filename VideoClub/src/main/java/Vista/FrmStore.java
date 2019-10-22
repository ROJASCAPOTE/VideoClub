package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FrmStore extends javax.swing.JInternalFrame {

    public FrmStore() {
        initComponents();
    }

    public String getLabelFotoManager() {
        return labelFotoManager.getName();
    }

    public void setLabelFotoManager(String labelFotoManager) {
        this.labelFotoManager.getText();
    }

    public boolean getRdbActiveNo() {
        return rdbActiveNo.isSelected();
    }

    public void setRdbActiveNo(JRadioButton rdbActiveNo) {
        this.rdbActiveNo = rdbActiveNo;
    }

    public boolean getRdbActiveSi() {
        return rdbActiveSi.isSelected();
    }

    public void setRdbActiveSi(JRadioButton rdbActiveSi) {
        this.rdbActiveSi = rdbActiveSi;
    }

    public JTextField getTextAddresStrore() {
        return textAddresStrore;
    }

    public void setTextAddresStrore(JTextField textAddresStrore) {
        this.textAddresStrore = textAddresStrore;
    }

    public JTextField getTextAddressManager() {
        return textAddressManager;
    }

    public void setTextAddressManager(JTextField textAddressManager) {
        this.textAddressManager = textAddressManager;
    }

    public JTextField getTextEmailManager() {
        return textEmailManager;
    }

    public void setTextEmailManager(JTextField textEmailManager) {
        this.textEmailManager = textEmailManager;
    }

    public JTextField getTextFirstNameManager() {
        return textFirstNameManager;
    }

    public void setTextFirstNameManager(JTextField textFirstNameManager) {
        this.textFirstNameManager = textFirstNameManager;
    }

    public JTextField getTextIdManagerStore() {
        return textIdManagerStore;
    }

    public void setTextIdManagerStore(JTextField textIdManagerStore) {
        this.textIdManagerStore = textIdManagerStore;
    }

    public JTextField getTextIdStore() {
        return textIdStore;
    }

    public void setTextIdStore(JTextField textIdStore) {
        this.textIdStore = textIdStore;
    }

    public JTextField getTextLastNameManager() {
        return textLastNameManager;
    }

    public void setTextLastNameManager(JTextField textLastNameManager) {
        this.textLastNameManager = textLastNameManager;
    }

    public JDateChooser getTextLastUpdateManager() {
        return textLastUpdateManager;
    }

    public void setTextLastUpdateManager(JDateChooser textLastUpdateManager) {
        this.textLastUpdateManager = textLastUpdateManager;
    }

    public JDateChooser getTextLastUpdateStore() {
        return textLastUpdateStore;
    }

    public void setTextLastUpdateStore(JDateChooser textLastUpdateStore) {
        this.textLastUpdateStore = textLastUpdateStore;
    }

    public JPasswordField getTextPasswordManager() {
        return textPasswordManager;
    }

    public void setTextPasswordManager(JPasswordField textPasswordManager) {
        this.textPasswordManager = textPasswordManager;
    }

    public JTextField getTextUserNameManager() {
        return textUserNameManager;
    }

    public void setTextUserNameManager(JTextField textUserNameManager) {
        this.textUserNameManager = textUserNameManager;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textIdStore = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textAddresStrore = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textLastUpdateStore = new com.toedter.calendar.JDateChooser();
        BtnBuscarStore = new javax.swing.JButton();
        btnBuscarAddressStore = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textIdManagerStore = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textFirstNameManager = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textLastNameManager = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textAddressManager = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textEmailManager = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdbActiveSi = new javax.swing.JRadioButton();
        rdbActiveNo = new javax.swing.JRadioButton();
        btnBuscarAddressManager = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        textUserNameManager = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textPasswordManager = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        textLastUpdateManager = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        labelFotoManager = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSubirFoto = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

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
        jLabel2.setText("Address");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Update");

        BtnBuscarStore.setText("....");

        btnBuscarAddressStore.setText("....");
        btnBuscarAddressStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAddressStoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textLastUpdateStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textIdStore, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textAddresStrore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarAddressStore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnBuscarStore))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textIdStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscarStore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textAddresStrore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAddressStore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(textLastUpdateStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id Manager");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Active");

        rdbActiveSi.setBackground(new java.awt.Color(102, 102, 102));
        rdbActiveSi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbActiveSi.setForeground(new java.awt.Color(255, 255, 255));
        rdbActiveSi.setText("Si");

        rdbActiveNo.setBackground(new java.awt.Color(102, 102, 102));
        rdbActiveNo.setForeground(new java.awt.Color(255, 255, 255));
        rdbActiveNo.setText("No");

        btnBuscarAddressManager.setText(".....");
        btnBuscarAddressManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAddressManagerActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("User Name");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Last Update");

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        labelFotoManager.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSubirFoto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSubirFoto.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Imagenes.png")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(labelFotoManager, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubirFoto)
                .addGap(136, 136, 136))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(labelFotoManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubirFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textPasswordManager, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textUserNameManager, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textEmailManager, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textIdManagerStore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(rdbActiveSi)
                        .addGap(18, 18, 18)
                        .addComponent(rdbActiveNo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(textAddressManager, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarAddressManager))
                    .addComponent(textLastNameManager, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFirstNameManager, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textLastUpdateManager, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textIdManagerStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(textFirstNameManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textLastNameManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textAddressManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAddressManager))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(textEmailManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbActiveSi)
                        .addComponent(rdbActiveNo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textUserNameManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textPasswordManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(textLastUpdateManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navegacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Primero.png")); // NOI18N
        jButton5.setText("Primero");

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Anterior.png")); // NOI18N
        jButton6.setText("Anterior");

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Siguiente3.png")); // NOI18N
        jButton7.setText("Siguiente");

        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Ultimo.png")); // NOI18N
        jButton8.setText("Ultimo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\New.png")); // NOI18N
        jButton9.setText("Nuevo");

        jButton10.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Modify.png")); // NOI18N
        jButton10.setText("Modificar");

        jButton12.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Get out.png")); // NOI18N
        jButton12.setText("Salir");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10)
                    .addComponent(jButton12))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void textIdStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdStoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIdStoreActionPerformed

    private void btnBuscarAddressManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAddressManagerActionPerformed
        FrmAddressListView addressListView = new FrmAddressListView();
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - addressListView.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - addressListView.getHeight() / 2;

        if (addressListView.isShowing()) {
            addressListView.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(addressListView);
            addressListView.setLocation(x, y);
            addressListView.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarAddressManagerActionPerformed

    private void btnBuscarAddressStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAddressStoreActionPerformed
        FrmAddressListView addressListView = new FrmAddressListView();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarStore;
    private javax.swing.JButton btnBuscarAddressManager;
    private javax.swing.JButton btnBuscarAddressStore;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFotoManager;
    private javax.swing.JRadioButton rdbActiveNo;
    private javax.swing.JRadioButton rdbActiveSi;
    private javax.swing.JTextField textAddresStrore;
    private javax.swing.JTextField textAddressManager;
    private javax.swing.JTextField textEmailManager;
    private javax.swing.JTextField textFirstNameManager;
    private javax.swing.JTextField textIdManagerStore;
    private javax.swing.JTextField textIdStore;
    private javax.swing.JTextField textLastNameManager;
    private com.toedter.calendar.JDateChooser textLastUpdateManager;
    private com.toedter.calendar.JDateChooser textLastUpdateStore;
    private javax.swing.JPasswordField textPasswordManager;
    private javax.swing.JTextField textUserNameManager;
    // End of variables declaration//GEN-END:variables
}
