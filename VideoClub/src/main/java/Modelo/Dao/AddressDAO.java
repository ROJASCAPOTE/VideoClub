/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Address;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class AddressDAO {
    
    private ConnectionBD con;
    
    public AddressDAO(ConnectionBD con) {
        this.con = con;
    }
    
    public Address consultarDireccion(int codigo) {
        String sql = "SELECT address_id, address FROM address WHERE address_id =" + codigo + "";
        ResultSet resultado = null;
        Statement st = null;
        Address address = null;
        try {
            st = con.getConexion().createStatement();
            resultado = st.executeQuery(sql);
            
            if (resultado.next()) {
                address = new Address();
                address.setAddressId(resultado.getShort(1));
                address.setAddress(resultado.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return address;
    }
    
    public ArrayList<Address> listadoAddress() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Address> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Address ORDER BY address";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Address address = null;
            while (rs.next()) {
                address = new Address();
                address.setAddressId(rs.getShort(1));
                address.setAddress(rs.getString(2));
                address.setAddress2(rs.getString(3));
                address.setDistrict(rs.getString(4));
                address.setCity_id(rs.getInt(5));
                address.setPostalCode(rs.getString(6));
                address.setPhone(rs.getString(7));
                address.setLastUpdate(rs.getDate(8));
                listado.add(address);
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
    
    public Object[][] getTableAddress() {
        int registros = 0;
        String sql = "SELECT a.address_id, a.address, a.address2, a.district, c.city, a.postal_code, a.phone, Date(a.last_update) FROM address a, city c"
                + " WHERE a.city_id=c.city_id ORDER BY address_id ASC";
        String cantidad = "Select count(*) as total from address";
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
        
        Object[][] data = new String[registros][8];
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
                data[i][6] = resp.getString(7);
                data[i][7] = resp.getString(8);
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }
}
