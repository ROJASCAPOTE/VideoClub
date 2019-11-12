/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Store;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StoreDAO {

    private ConnectionBD con;

    public StoreDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grabarStore(Store store) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(store.getLast_update());
        try {
            String sql = "INSERT INTO store values (?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, store.getStore_id());
            pstm.setInt(2, store.getManager_staff().getStaff_id());
            pstm.setInt(3, store.getAddress_id().getAddressId());
            pstm.setString(4, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public Store consultarStore(int codigo) {
        String sql = "SELECT store_id, manager_staff_id, address_id FROM store WHERE store_id =" + codigo + "";
        ResultSet resultado = null;
        Statement st = null;
        Store store = null;
        try {
            st = con.getConexion().createStatement();
            resultado = st.executeQuery(sql);

            if (resultado.next()) {
                store = new Store();
                store.setStore_id(resultado.getInt(1));
                store.setManager_id(resultado.getInt(2));
                store.setCodigo_address(resultado.getInt(3));
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
        return store;
    }

    public int grtCodigoStore() {
        String sql = "SELECT MAX(store_id) as total FROM store";
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

    public ArrayList<Store> listadoStore() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Store> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM store";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();

            Store store = null;
            while (rs.next()) {
                store = new Store();
                store.setStore_id(rs.getInt(1));
                store.setManager_id(rs.getInt(2));
                store.setCodigo_address(rs.getInt(3));
                store.setLast_update(rs.getDate(4));
                listado.add(store);
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

    public Object[][] getTableStore(int codigo) {
        int registros = 0;

        String sql = "";
        if (codigo == 0) {
            sql = "SELECT s.store_id, s.manager_staff_id ,man.last_name, man.first_name, a.address_id FROM store s, staff man,  address a "
                    + " where s.manager_staff_id=man.staff_id "
                    + " and s.address_id=a.address_id";
        } else {
            sql = "SELECT s.store_id, s.manager_staff_id ,man.last_name, man.first_name, a.address_id FROM store s, staff man,  address a "
                    + " where s.manager_staff_id=man.staff_id"
                    + " and s.address_id=a.address_id  and s.store_id=" + codigo + "";
        }
        System.out.println("Modelo.Dao.StoreDAO.getTableStore()" + sql);
        String cantidad = "Select count(*) as total from store";
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

        Object[][] data = new String[registros][5];
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
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }
}
