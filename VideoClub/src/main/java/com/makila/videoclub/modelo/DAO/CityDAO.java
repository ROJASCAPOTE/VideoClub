/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makila.videoclub.modelo.DAO;

import com.makila.videoclub.servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER E5
 */
public class CityDAO {

    private ConnectionBD con;

    public CityDAO(ConnectionBD con) {
        this.con = con;
    }

    public Object[][] getTableCity() {
        int registros = 0;
        String sql = "SELECT ci.city_id, ci.city, co.country, Date(ci.last_update) FROM city ci, country co"
                + " WHERE ci.country_id=co.country_id ORDER BY ci.city ASC";
        String cantidad = "Select count(*) as total from city";
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
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }

}
