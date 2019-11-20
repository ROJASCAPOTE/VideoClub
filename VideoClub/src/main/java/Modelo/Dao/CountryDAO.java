package Modelo.Dao;

import Modelo.Country;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class CountryDAO {

    private ConnectionBD con = null;

    public CountryDAO() {
    }

    public CountryDAO(ConnectionBD con) {
        this.con = con;
    }
    
    public int grtCodigo() {
        String sql = "SELECT MAX(country_id) as total FROM country";
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

    public int grabarCountry(Country c) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(c.getLastUpdate());
        try {

            String sql = "INSERT INTO country values (?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, c.getCountry_id());
            pstm.setString(2, c.getCountry());
            pstm.setString(3, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public int modificarCountry(Country c) {

        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastUpdate = sdf.format(c.getLastUpdate());
        try {
            String sql = "UPDATE country "
                    + "SET country=?, last_update=? WHERE country_id=?";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setString(1, c.getCountry());
            pstm.setString(2, lastUpdate);
            pstm.setInt(3, c.getCountry_id());
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public int borrarCountry(int country_id) {
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            String sql = "DELETE FROM country WHERE country_id = ? ";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, country_id);
            rtdo = pstm.executeUpdate();
            return rtdo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
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

    public Country getCountry() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Country country = null;
        try {
            String sql = "SELECT * FROM country";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
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

    public ArrayList<Country> listadoPais() {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Country> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM country ORDER BY country_id";

            pstm = con.getConexion().prepareStatement(sql);

            rs = pstm.executeQuery();

            Country country = null;
            while (rs.next()) {
                country = convertir(rs);
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

    Country convertir(ResultSet rs) throws SQLException {
        int id = rs.getInt("country_id");
        String country = rs.getString("country");
        Date lastUpdate = rs.getDate("last_update");
        Country c = new Country(id, country, lastUpdate);
        return c;
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

    public Object[][] getTableCountry(String nombPais) {
        int registros = 0;
        String sql = "";
        if (nombPais.equals("")) {
            sql = "SELECT * FROM country";
        } else {
            sql = "SELECT * FROM country WHERE country like '%" + nombPais + "%'";
            System.out.println(sql);
        }
        String cantidad = "Select count(*) as total from country";
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

        Object[][] data = new String[registros][3];
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

                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }

}
