package Modelo.Dao;

import Modelo.Country;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CountryDAO {

    private ConnectionBD con = null;

    public CountryDAO(ConnectionBD con) {
        this.con = con;
    }
    
    public Country obtenerCountry(String nombre) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Country country = null;
        try {
            String sql = "SELECT * FROM country WHERE country='" + nombre + "'";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                country = new Country();
                country.setCountry_id(rs.getInt(1));
                country.setCountry(rs.getString(2));
                country.setLastUpdate(rs.getDate(3));
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
        return country;
    }

    public ArrayList<Country> listadoCountry() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Country> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM country ORDER BY country";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Country country = null;
            while (rs.next()) {
                country = new Country();
                country.setCountry_id(rs.getInt(1));
                country.setCountry(rs.getString(2));
                country.setLastUpdate(rs.getDate(3));
                listado.add(country);
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
}
