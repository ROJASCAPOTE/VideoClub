/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER E5
 */
public class AddressDAO {

    private ConnectionBD con;

    public AddressDAO(ConnectionBD con) {
        this.con = con;
    }

    public Object[][] getTableCity() {
        int registros = 0;
        String sql = "SELECT a.address_id, a.address, a.address2, a.district, c.city, a.postal_code, a.phone, Date(a.last_update) FROM address a, city c"
                + " WHERE a.city_id=c.city_id ORDER BY aaddress_id ASC";
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

        Object[][] data = new String[registros][4];
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
                data[i][3] = resp.getString(5);
                data[i][3] = resp.getString(6);
                data[i][3] = resp.getString(7);
                data[i][3] = resp.getString(8);
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }
}
