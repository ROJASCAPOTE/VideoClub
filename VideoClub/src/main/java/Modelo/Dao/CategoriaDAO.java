package Modelo.Dao;

import Modelo.Category;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CategoriaDAO {

    private ConnectionBD con;

    public CategoriaDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grtCodigo() {
        String sql = "SELECT MAX(category_id) as total FROM category";
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

    public int grabarCategory(Category category) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(category.getLastUpdate());
        try {
            String sql = "INSERT INTO category values (?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, category.getCategoryId());
            pstm.setString(2, category.getName());
            pstm.setString(3, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public ArrayList<Category> listadoCategory() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Category> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM category ORDER BY category_id";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Category category = null;
            while (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt(1));
                category.setName(rs.getString(2));
                listado.add(category);
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

    public Object[][] getTableCategory() {
        int registros = 0;
        String sql = "SELECT * FROM category ORDER BY category_id ASC";
        String cantidad = "Select count(*) as total from category";
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

        Object[][] data = new String[registros][2];
        PreparedStatement pst = null;
        ResultSet resp = null;
        int i = 0;
        try {
            pst = con.getConexion().prepareStatement(sql);
            resp = pst.executeQuery();
            while (resp.next()) {
                data[i][0] = resp.getString(1);
                data[i][1] = resp.getString(2);
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }

}
