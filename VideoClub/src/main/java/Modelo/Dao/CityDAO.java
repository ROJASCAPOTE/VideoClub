/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.City;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class CityDAO {
    
    private ConnectionBD con;
    
    public CityDAO(ConnectionBD con) {
        this.con = con;
    }
    
    public int grabarCity(City c) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(c.getLast_update());
        try {
            
            String sql = "INSERT INTO city values (?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, c.getCity_id());
            pstm.setString(2, c.getCity());
            pstm.setInt(3, c.getCountry().getCountry_id());
            pstm.setString(4, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }
    
    public int modificarCity(City c) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(c.getLast_update());
        try {
            String sql = "UPDATE city "
                    + "SET city=?, country_id=?, last_update=?  WHERE city_id=?";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setString(1, c.getCity());
            pstm.setInt(2, c.getCountry().getCountry_id());
            pstm.setString(3, last_update);
            pstm.setInt(4, c.getCity_id());
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }
    
    public int borrarCity(int city_id) {
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            String sql = "DELETE FROM city WHERE city_id = ? ";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, city_id);
            rtdo = pstm.executeUpdate();
            return rtdo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }
    
    public ArrayList<City> listadoCity() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<City> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM city ORDER BY city";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            City city = null;
            while (rs.next()) {
                city = new City();
                city.setCity_id(rs.getInt(1));
                city.setCity(rs.getString(2));
                city.setLast_update(rs.getDate(3));
                listado.add(city);
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
    
    public Object[][] getTableCity() {
        int registros = 0;
        String sql = "SELECT ci.city_id, ci.city, co.country, Date(ci.last_update) FROM city ci, country co"
                + " WHERE ci.country_id=co.country_id ORDER BY ci.city_id ASC";
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
