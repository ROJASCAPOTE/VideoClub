package Modelo.Dao;

import Modelo.Staff;
import Servisios.ConnectionBD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StaffDAO {

    private ConnectionBD con;

    public StaffDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grtCodigoStaff() {
        String sql = "SELECT MAX(staff_id) as total FROM staff";
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

    public int actualizarEmpleado(Staff s) {

        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(s.getLast_update());
        String sql = "UPDATE staff"
                + " SET first_name=?, last_name=?, address_id=?, picture=?, email=?, store_id=?, active=?, username=?, password=?, last_update=?  WHERE staff_id=?";
        try {
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setString(1, s.getFirst_name());
            pstm.setString(2, s.getLast_name());
            pstm.setInt(3, s.getAddressId());
            pstm.setBytes(4, s.getPicture());
            pstm.setString(5, s.getEmail());
            pstm.setInt(6, s.getStore_id());
            pstm.setBoolean(7, s.isActive());
            pstm.setString(8, s.getUsername());
            pstm.setString(9, s.getPassword());
            pstm.setString(10, last_update);
            pstm.setInt(11, s.getStaff_id());
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
            rs.next();
            numero = rs.getInt("total") + 1;
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return numero;
    }

    public ArrayList<Staff> listadoStaff() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Staff> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM staff";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();

            Staff staff = null;
            while (rs.next()) {
                staff = new Staff();
                staff.setStaff_id(rs.getInt(1));
                staff.setFirst_name(rs.getString(2));
                staff.setLast_name(rs.getString(3));
                staff.setAddressId(rs.getInt(4));
                staff.setRuta(rs.getString(5));
                staff.setEmail(rs.getString(6));
                staff.setStore_id(rs.getInt(7));
                staff.setActive(rs.getBoolean(8));
                staff.setUsername(rs.getString(9));
                staff.setPassword(rs.getString(10));
                staff.setLast_update(rs.getDate(11));
                listado.add(staff);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }

    public Staff obtenerStaff(int codigo) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Staff staff = null;
        try {
            String sql = "SELECT * FROM staff  WHERE staff_id=" + codigo + "";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                staff = new Staff();
                staff.setStaff_id(rs.getInt(1));
                staff.setFirst_name(rs.getString(2));
                staff.setLast_name(rs.getString(3));
                staff.setAddressId(rs.getInt(4));
                staff.setPicture(rs.getBytes(5));
                staff.setEmail(rs.getString(6));
                staff.setStore_id(rs.getInt(7));
                staff.setActive(rs.getBoolean(8));
                staff.setUsername(rs.getString(9));
                staff.setPassword(rs.getString(10));
                staff.setLast_update(rs.getDate(11));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return staff;
    }

    public Object[][] getTableStaff(int codigo, String nombre) {
        int registros = 0;

        String sql = "";
        if (codigo == 0) {
            sql = "select staff_id, first_name, last_name, address_id, email, store_id from staff  ORDER BY  store_id  ASC";
        } else {
            sql = "staff_id, first_name, last_name, address_id,  email, store_id from staff where store_id=" + codigo + "";
        }

        if (nombre.equals("")) {
            sql = "select staff_id, first_name, last_name, address_id, email, store_id from staff  ORDER BY  store_id  ASC";

        } else {
            sql = "staff_id, first_name, last_name, address_id,  email, store_id from staff where first_name  like '%" + nombre + "%'";
        }
        String cantidad = "Select count(*) as total from staff";
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            pstm = con.getConexion().prepareStatement(cantidad);
            res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][6];
        PreparedStatement pst = null;
        ResultSet resp = null;
        int i = 0;
        try {
            pst = con.getConexion().prepareStatement(sql);
            resp = pst.executeQuery();
            while (resp.next()) {
                data[i][0] = resp.getString(1);
                data[i][1] = resp.getString(2);
                data[i][2] = resp.getString(3);
                data[i][3] = resp.getString(4);
                data[i][4] = resp.getString(5);
                data[i][5] = resp.getString(6);
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }
}
