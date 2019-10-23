package Modelo.Dao;

import Modelo.Staff;
import Modelo.Store;
import Servisios.ConnectionBD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class StaffDAO {

    private ConnectionBD con;

    public StaffDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grabarStaff(Staff s) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(s.getLast_update());
        FileInputStream fis = null;
        File file = null;

        try {
            file = new File(s.getRuta());
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {

        }

        try {

            String sql = "INSERT INTO staff values (?,?,?,?,?,?,?,?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, s.getStaff_id());
            pstm.setString(2, s.getFirst_name());
            pstm.setString(3, s.getLast_name());
            pstm.setInt(4, s.getAddressId());
            pstm.setBinaryStream(5, fis, (long) file.length());
            pstm.setString(6, s.getEmail());
            pstm.setInt(7, s.getStore_id());
            pstm.setBoolean(8, s.isActive());
            pstm.setString(9, s.getUsername());
            pstm.setString(10, s.getPassword());
            pstm.setString(11, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public int getCodigo() {
        String sql = "SELECT MAX(staff_id) as total FROM staff";
        PreparedStatement st = null;
        ResultSet rs = null;
        int numero = 0;
        try {
            st = con.getConexion().prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                numero = rs.getInt("total") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return numero;
    }
}
