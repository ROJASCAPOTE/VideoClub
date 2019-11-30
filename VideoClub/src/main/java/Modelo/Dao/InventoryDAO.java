/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Inventory;
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
public class InventoryDAO {

    private ConnectionBD con;

    public InventoryDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grtCodigo() {
        String sql = "SELECT MAX(inventory_id) as total FROM inventory";
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

    public int grabarInventory(Inventory inventory) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(inventory.getLastUpdate());
        try {

            String sql = "INSERT INTO inventory values (?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, inventory.getInventoryId());
            pstm.setInt(2, inventory.getFilm().getFilmId());
            pstm.setInt(3, inventory.getStore().getStore_id());
            pstm.setString(4, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public ArrayList<Inventory> listadoInventario() {
        FilmDAO filmDAO = new FilmDAO(con);
        StoreDAO storeDAO = new StoreDAO(con);
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Inventory> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inventory ORDER BY inventory_id";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Inventory inventory = null;
            while (rs.next()) {
                inventory = new Inventory();
                inventory.setInventoryId(rs.getInt(1));
                inventory.setFilm(filmDAO.buscarFilm(rs.getInt(2)));
                inventory.setStore(storeDAO.consultarStore(rs.getInt(3)));
                inventory.setLastUpdate(rs.getDate(4));
                listado.add(inventory);
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

    public Object[][] getTableInventario() {
        int registros = 0;
        String sql = "SELECT * FROM inventory ORDER BY inventory_id ASC";
        String cantidad = "Select count(*) as total from inventory";
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
