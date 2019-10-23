/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Store;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class StoreDAO {

    private ConnectionBD con;

    public StoreDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grabarStore(Store store) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(store.getLast_update());
        try {
            String sql = "INSERT INTO store values (?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, store.getStore_id());
            pstm.setInt(2, store.getManager_staff().getStaff_id());
            pstm.setInt(3, store.getAddress_id().getAddressId());
            pstm.setString(4, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public int grtCodigoStore() {
        String sql = "SELECT MAX(store_id) as total FROM store";
        PreparedStatement st = null;
        ResultSet rs = null;
        int cant = 0;
        try {
            st = con.getConexion().prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                cant = rs.getInt("total") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return cant;
    }
}
