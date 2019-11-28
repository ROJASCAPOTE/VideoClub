/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ActorController;
import Controlador.CatalogoPeliculasController;
import Controlador.CategoryController;
import Controlador.CityController;
import Controlador.CountryController;
import Controlador.CustomerController;
import Controlador.LanguageController;
import Controlador.StaffController;
import Controlador.StoreController;
import Modelo.Dao.DAOManager;
import Modelo.DesktopConFondo;

/**
 *
 * @author ACER E5
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private DAOManager manager;

    public FrmPrincipal(DAOManager manager) {
        initComponents();
        this.setExtendedState(FrmPrincipal.MAXIMIZED_BOTH);
        this.manager = manager;
        ((DesktopConFondo) jDesktopPane).setImagen("/fondo.jpg");
    }

    public void film() {
        FrmCatalogoPeliculas frmCatalogoPeliculas = new FrmCatalogoPeliculas();
        CatalogoPeliculasController controller = new CatalogoPeliculasController(frmCatalogoPeliculas, manager);
        frmCatalogoPeliculas.setManager(manager);
        int x = (jDesktopPane.getWidth() / 2) - frmCatalogoPeliculas.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmCatalogoPeliculas.getHeight() / 2;
        if (frmCatalogoPeliculas.isShowing()) {
            frmCatalogoPeliculas.setLocation(x, y);
        } else {
            jDesktopPane.add(frmCatalogoPeliculas);
            frmCatalogoPeliculas.setLocation(x, y);
            frmCatalogoPeliculas.setVisible(true);
        }
    }

    public void category() {
        FrmCategory frmCategory = new FrmCategory();
        CategoryController categoryController = new CategoryController(frmCategory, manager);
        int x = (jDesktopPane.getWidth() / 2) - frmCategory.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmCategory.getHeight() / 2;
        if (frmCategory.isShowing()) {
            frmCategory.setLocation(x, y);
        } else {
            jDesktopPane.add(frmCategory);
            frmCategory.setLocation(x, y);
            frmCategory.setVisible(true);
        }
    }

    public void actor() {
        FrmActor frmActor = new FrmActor();
        ActorController controller = new ActorController(frmActor, manager);
        int x = (jDesktopPane.getWidth() / 2) - frmActor.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmActor.getHeight() / 2;
        if (frmActor.isShowing()) {
            frmActor.setLocation(x, y);
        } else {
            jDesktopPane.add(frmActor);
            frmActor.setLocation(x, y);
            frmActor.setVisible(true);
        }
    }

    public void language() {
        FrmLanguage frmLanguage = new FrmLanguage();
        LanguageController controller = new LanguageController(frmLanguage, manager);
        int x = (jDesktopPane.getWidth() / 2) - frmLanguage.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmLanguage.getHeight() / 2;
        if (frmLanguage.isShowing()) {
            frmLanguage.setLocation(x, y);
        } else {
            jDesktopPane.add(frmLanguage);
            frmLanguage.setLocation(x, y);
            frmLanguage.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator15 = new javax.swing.JSeparator();
        jDesktopPane = new DesktopConFondo();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        saveAsMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Datos");
        fileMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        openMenuItem.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\java\\Imagenes\\Customer.png")); // NOI18N
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Customer");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);
        fileMenu.add(jSeparator1);
        fileMenu.add(jSeparator2);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveAsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/City.png"))); // NOI18N
        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("City");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(jSeparator3);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Country.png"))); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Country");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);
        fileMenu.add(jSeparator9);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exit.png"))); // NOI18N
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        menuBar.add(fileMenu);

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Pelicula.png")); // NOI18N
        jMenu1.setText("Inventario");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Category.png")); // NOI18N
        jMenuItem4.setText("Category");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Film3.png")); // NOI18N
        jMenuItem5.setText("Film");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Actor.png")); // NOI18N
        jMenuItem6.setText("Actor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);
        jMenu1.add(jSeparator6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Language.png")); // NOI18N
        jMenuItem7.setText("Language");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        menuBar.add(jMenu1);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Negocio2.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Negocio");
        helpMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        contentMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Staff.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Staff");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);
        helpMenu.add(jSeparator7);

        aboutMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/store.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Store");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);
        helpMenu.add(jSeparator8);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Payment2.png"))); // NOI18N
        jMenuItem1.setText("Payment");
        helpMenu.add(jMenuItem1);
        helpMenu.add(jSeparator17);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Rental.png")); // NOI18N
        jMenuItem3.setText("Rental");
        helpMenu.add(jMenuItem3);
        helpMenu.add(jSeparator18);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem8.setText("Inventory");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem8);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        FrmCountry frmCountry = new FrmCountry();
        CountryController countryController = new CountryController(frmCountry, manager);
        frmCountry.setManager(manager);
        int x = (jDesktopPane.getWidth() / 2) - frmCountry.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmCountry.getHeight() / 2;

        if (frmCountry.isShowing()) {
            frmCountry.setLocation(x, y);
        } else {
            jDesktopPane.add(frmCountry);
            frmCountry.setLocation(x, y);
            frmCountry.setVisible(true);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        FrmCustomer customer = new FrmCustomer();
        CustomerController controller = new CustomerController(customer, manager);
        customer.setManager(manager);

        int x = (jDesktopPane.getWidth() / 2) - customer.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - customer.getHeight() / 2;

        if (customer.isShowing()) {
            customer.setLocation(x, y);
        } else {
            jDesktopPane.add(customer);
            customer.setLocation(x, y);
            customer.setVisible(true);
        }
    }//GEN-LAST:event_openMenuItemActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        frmCity cityView = new frmCity();
        CityController cityController = new CityController(cityView, manager);
        cityView.setManager(manager);
        int x = (jDesktopPane.getWidth() / 2) - cityView.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - cityView.getHeight() / 2;

        if (cityView.isShowing()) {
            cityView.setLocation(x, y);
        } else {
            jDesktopPane.add(cityView);
            cityView.setLocation(x, y);
            cityView.setVisible(true);
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        FrmStore frmStore = new FrmStore();
        StoreController controller = new StoreController(frmStore, manager);
        StaffController staffController = new StaffController();
        frmStore.setManager(manager);
        staffController.setFrmStore(frmStore);
        staffController.setModelo(manager);
        int x = (jDesktopPane.getWidth() / 2) - frmStore.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmStore.getHeight() / 2;

        if (frmStore.isShowing()) {
            frmStore.setLocation(x, y);
        } else {
            jDesktopPane.add(frmStore);
            frmStore.setLocation(x, y);
            frmStore.setVisible(true);
        }
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        FrmStaff frmStaffView = new FrmStaff();
        StaffController controller = new StaffController(frmStaffView, manager);
        frmStaffView.setManager(manager);
        int x = (jDesktopPane.getWidth() / 2) - frmStaffView.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmStaffView.getHeight() / 2;

        if (frmStaffView.isShowing()) {
            frmStaffView.setLocation(x, y);
        } else {
            jDesktopPane.add(frmStaffView);
            frmStaffView.setLocation(x, y);
            frmStaffView.setVisible(true);
        }
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        category();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        film();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        actor();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        language();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        FrmCatalogoInventory frmInventory = new FrmCatalogoInventory();
        frmInventory.setManager(manager);
        int x = (jDesktopPane.getWidth() / 2) - frmInventory.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmInventory.getHeight() / 2;

        if (frmInventory.isShowing()) {
            frmInventory.setLocation(x, y);
        } else {
            jDesktopPane.add(frmInventory);
            frmInventory.setLocation(x, y);
            frmInventory.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    public static javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    // End of variables declaration//GEN-END:variables

}
