/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import com.makila.videoclub.modelo.DAO.MYSQLDaoManager;
import com.makila.videoclub.servisios.ConnectionBD;
import com.makila.videoclub.vista.FrmPrincipal;

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
        frmPrincipal.setVisible(true);
    }

}
