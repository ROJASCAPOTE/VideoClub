/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ActorController;
import Controlador.FilmActorController;
import Controlador.AddressController;
import Controlador.CategoryController;
import Controlador.FilmCategoryController;
import Controlador.CityController;
import Controlador.CountryController;
import Controlador.CustomerController;
import Controlador.FilmController;
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new DesktopConFondo();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        saveMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        saveAsMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        copyMenuItem = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        pasteMenuItem = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        deleteMenuItem = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

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

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Address.png"))); // NOI18N
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Address");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);
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

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pelicula.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Peliculas");

        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        cutMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Category.png"))); // NOI18N
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Category");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem);
        editMenu.add(jSeparator4);

        copyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        copyMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Film3.png"))); // NOI18N
        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Film");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);
        editMenu.add(jSeparator5);

        pasteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        pasteMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pasteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Language.png"))); // NOI18N
        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Language");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(pasteMenuItem);
        editMenu.add(jSeparator6);

        deleteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        deleteMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actor.png"))); // NOI18N
        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Actor");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(deleteMenuItem);
        editMenu.add(jSeparator11);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem3.setText("Film Actor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem3);
        editMenu.add(jSeparator10);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem4.setText("Film Category");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem4);

        menuBar.add(editMenu);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Negocio2.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Negocio");

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

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        FrmFilm frmFilm = new FrmFilm();
        FilmController controller = new FilmController(frmFilm, manager);
        int x = (jDesktopPane.getWidth() / 2) - frmFilm.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmFilm.getHeight() / 2;
        
        if (frmFilm.isShowing()) {
            frmFilm.setLocation(x, y);
        } else {
            jDesktopPane.add(frmFilm);
            frmFilm.setLocation(x, y);
            frmFilm.setVisible(true);
        }
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pasteMenuItemActionPerformed

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

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        FrmAddess frmAddess = new FrmAddess();
        AddressController controller = new AddressController(frmAddess, manager);
        int x = (jDesktopPane.getWidth() / 2) - frmAddess.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmAddess.getHeight() / 2;
        
        if (frmAddess.isShowing()) {
            frmAddess.setLocation(x, y);
        } else {
            jDesktopPane.add(frmAddess);
            frmAddess.setLocation(x, y);
            frmAddess.setVisible(true);
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

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

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        FrmCategory category = new FrmCategory();
        
        CategoryController controller = new CategoryController(category, manager);
        int x = (jDesktopPane.getWidth() / 2) - category.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - category.getHeight() / 2;
        
        if (category.isShowing()) {
            category.setLocation(x, y);
        } else {
            jDesktopPane.add(category);
            category.setLocation(x, y);
            category.setVisible(true);
        }
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
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
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FrmFilmActor filmActor = new FrmFilmActor();
        FilmActorController controller = new FilmActorController(filmActor, manager);
        filmActor.setManager(manager);
        int x = (jDesktopPane.getWidth() / 2) - filmActor.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - filmActor.getHeight() / 2;
        if (filmActor.isShowing()) {
            filmActor.setLocation(x, y);
        } else {
            jDesktopPane.add(filmActor);
            filmActor.setLocation(x, y);
            filmActor.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        FrmFilmCategory frmFilmCategory = new FrmFilmCategory();
        int x = (jDesktopPane.getWidth() / 2) - frmFilmCategory.getWidth() / 2;
        int y = (jDesktopPane.getHeight() / 2) - frmFilmCategory.getHeight() / 2;
        if (frmFilmCategory.isShowing()) {
            frmFilmCategory.setLocation(x, y);
        } else {
            jDesktopPane.add(frmFilmCategory);
            frmFilmCategory.setLocation(x, y);
            frmFilmCategory.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    public static javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
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
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
