/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Address;
import Modelo.Language;
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
public class LanguageDAO {

    private ConnectionBD con;

    public LanguageDAO(ConnectionBD con) {
        this.con = con;
    }

    public ArrayList<Language> listLanguage() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Language> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM language ORDER BY name";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Language language = null;
            while (rs.next()) {
                language = new Language();
                language.setLanguageId(rs.getInt(1));
                language.setName(rs.getString(2));
                language.setLastUpdate(rs.getDate(3));
                listado.add(language);
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

    public ArrayList<Language> listOriginalLanguage() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Language> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM language ORDER BY name";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Language language = null;
            while (rs.next()) {
                language = new Language();
                language.setLanguageId(rs.getInt(1));
                language.setName(rs.getString(2));
                language.setLastUpdate(rs.getDate(3));
                listado.add(language);
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

    public Language buscarLanguage(int codigo) {
        String sql = "SELECT * FROM language WHERE language_id =" + codigo + "";
        ResultSet resultado = null;
        Statement st = null;
        Language language = null;
        try {
            st = con.getConexion().createStatement();
            resultado = st.executeQuery(sql);

            if (resultado.next()) {
                language = new Language();
                language.setLanguageId(resultado.getInt(1));
                language.setName(resultado.getString(2));
                language.setLastUpdate(resultado.getDate(3));
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
        return language;
    }
}
