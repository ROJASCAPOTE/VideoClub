/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Modelo.Dao.MYSQLDaoManager;
import Servisios.ConnectionBD;
import Vista.FrmPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ACER E5
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionBD con = null;
        con = ConnectionBD.getInstance();
        MYSQLDaoManager manager = new MYSQLDaoManager(con);
        FrmPrincipal frmPrincipal = new FrmPrincipal(manager);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frmPrincipal);
            frmPrincipal.setLocationRelativeTo(null);
            frmPrincipal.setTitle("Control de Inventario-peliculas");
            frmPrincipal.setVisible(true);
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        }

    }

}
