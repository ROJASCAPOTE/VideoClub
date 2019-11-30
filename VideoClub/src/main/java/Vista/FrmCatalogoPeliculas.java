/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FilmActorController;
import Controlador.FilmCategoryController;
import Controlador.FilmController;
import Eventos.CatalogoPeliculasMouseListener;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import ModeloGUI.CatalogoPeliculaTablaModelo;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER E5
 */
public class FrmCatalogoPeliculas extends javax.swing.JInternalFrame {

    private FrmFilmCategory filmCategory;
    private FrmFilmActor filmActor;
    private DAOManager manager;
    private Film film;

    public FrmCatalogoPeliculas() {
        initComponents();
    }

    public FrmFilmCategory getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(FrmFilmCategory filmCategory) {
        this.filmCategory = filmCategory;
    }

    public FrmFilmActor getFilmActor() {
        return filmActor;
    }

    public void setFilmActor(FrmFilmActor filmActor) {
        this.filmActor = filmActor;
    }

    public void setManager(DAOManager manager) {
        this.manager = manager;
    }

    public void tableCatalogoPeliculas(Object[][] dtCatalogo) {
        String[] columNames = {"Id", "Title", "Release Year", "lenguage", "Rental Duration", "Rental Rate", "Length", "Rating"};
        DefaultTableModel datos = new DefaultTableModel(dtCatalogo, columNames);
        tablaCatalogoPeliculas.setModel(datos);
    }

    public String getTextBuscarTituloCodigo() {
        return textBuscarTituloCodigo.getText();
    }

    public JTable getTablaCatalogoPeliculas() {
        return tablaCatalogoPeliculas;
    }

    public void limpiarCampo() {
        textBuscarTituloCodigo.setText("");
        textBuscarTituloCodigo.requestFocusInWindow();
    }

    public Film getFilm() {
        return film;
    }

    public void setModel(CatalogoPeliculaTablaModelo modelo) {
        tablaCatalogoPeliculas.setModel(modelo);
    }

    public void addListenerBtnConsultar(ActionListener listenerAccion) {
        btnConsultar.addActionListener(listenerAccion);
    }
    
    public void addMouseListenerCatalogoPeliculas(MouseListener keyListenerCatalogoPelicula) {
        tablaCatalogoPeliculas.addMouseListener(keyListenerCatalogoPelicula);
    }

    public void gestionMensajes(String mensaje, String titulo, int icono) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
    }

    public void abrirFilmCategory() {
        FilmCategoryController categoryController = new FilmCategoryController(filmCategory, manager);
        filmCategory.setManager(manager);
        categoryController.setCatalogoPeliculas(this);
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - filmCategory.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - filmCategory.getHeight() / 2;
        if (filmCategory.isShowing()) {
            filmCategory.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(filmCategory);
            filmCategory.setLocation(x, y);
            filmCategory.setVisible(true);
        }
    }

    public void abrirFilmActor() {
        FilmActorController actorController = new FilmActorController(filmActor, manager);
        filmActor.setManager(manager);
        actorController.setCatalogoPeliculas(this);
        actorController.filmActor();
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - filmActor.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - filmActor.getHeight() / 2;
        if (filmActor.isShowing()) {
            filmActor.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(filmActor);
            filmActor.setLocation(x, y);
            filmActor.setVisible(true);
        }
    }

    public void abrirVentana() {
        if (filmActor != null) {
            abrirFilmActor();

        } else if (filmCategory != null) {
            abrirFilmCategory();
        }
    }

    public String getTextoNombreFilm() {
        return textBuscarTituloCodigo.getText();
    }

    public void addaddKeyListener(KeyListener keyListenerCatalogo) {
        textBuscarTituloCodigo.addKeyListener(keyListenerCatalogo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        textBuscarTituloCodigo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCatalogoPeliculas = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnConsultar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Titulo o Codigo Pelicula");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textBuscarTituloCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(704, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textBuscarTituloCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Peliculas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaCatalogoPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCatalogoPeliculas);

        jToolBar1.setRollover(true);

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Guardar.png")); // NOI18N
        btnConsultar.setText("Consultar Todos");
        jToolBar1.add(btnConsultar);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER E5\\Desktop\\ProyectoJava\\VideoClub\\VideoClub\\src\\main\\resources\\Film3.png")); // NOI18N
        jButton1.setText("Registrar Pelicula");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmFilm frmFilm = new FrmFilm();
        FilmController controller = new FilmController(frmFilm, manager);
        frmFilm.setManager(manager);
        int x = (FrmPrincipal.jDesktopPane.getWidth() / 2) - frmFilm.getWidth() / 2;
        int y = (FrmPrincipal.jDesktopPane.getHeight() / 2) - frmFilm.getHeight() / 2;
        if (frmFilm.isShowing()) {
            frmFilm.setLocation(x, y);
        } else {
            FrmPrincipal.jDesktopPane.add(frmFilm);
            frmFilm.setLocation(x, y);
            frmFilm.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaCatalogoPeliculas;
    private javax.swing.JTextField textBuscarTituloCodigo;
    // End of variables declaration//GEN-END:variables

    public void addMouseListenerCatalogoPeliculas(CatalogoPeliculasMouseListener catalogoPeliculasMouseListener) {
        tablaCatalogoPeliculas.addMouseListener(catalogoPeliculasMouseListener);
    }

    public void modificarAction() {
        dispose();
    }

}
