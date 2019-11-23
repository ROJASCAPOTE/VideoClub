package Modelo.Dao;

import Modelo.Address;
import Modelo.Customer;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class CustomerDAO {

    private ConnectionBD con;

    public CustomerDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grabarCustomer(Customer c) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(c.getLastUpdate());
        SimpleDateFormat dateCreate = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String create = dateCreate.format(c.getCreateDate());
        try {

            String sql = "INSERT INTO customer values (?,?,?,?,?,?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, c.getCustomerId());
            pstm.setInt(2, c.getStore().getStore_id());
            pstm.setString(3, c.getFirstName());
            pstm.setString(4, c.getLastName());
            pstm.setString(5, c.getEmail());
            pstm.setInt(6, c.getAddress().getAddressId());
            pstm.setBoolean(7, c.isActive());
            pstm.setString(8, last_update);
            pstm.setString(9, create);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public int modificarCustomer(Customer c) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat dateCreate = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String create = dateCreate.format(c.getCreateDate());
        try {
            String sql = "UPDATE customer "
                    + "SET store_id=?, first_name=?, last_name=?, email=?, address_id=?, active=?, create_date=?  WHERE customer_id=?";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, c.getStore().getStore_id());
            pstm.setString(2, c.getFirstName());
            pstm.setString(3, c.getLastName());
            pstm.setString(4, c.getEmail());
            pstm.setInt(5, c.getAddress().getAddressId());
            pstm.setBoolean(6, c.isActive());
            pstm.setString(7, create);
            pstm.setInt(8, c.getCustomerId());
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }
    
     public int borrarCustomer(int customer_id) {
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            String sql = "DELETE FROM customer WHERE customer_id = ? ";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, customer_id);
            rtdo = pstm.executeUpdate();
            return rtdo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public int grtCodigo() {
        String sql = "SELECT MAX(customer_id) as total FROM customer";
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

    public Customer getCustomer(int codigo) {
        AddressDAO addressDAO = new AddressDAO(con);
        StoreDAO storeDAO = new StoreDAO(con);
        String sql = "SELECT * FROM customer WHERE customer_id =" + codigo + "";
        ResultSet resultado = null;
        Statement st = null;
        Customer customer = null;
        try {
            st = con.getConexion().createStatement();
            resultado = st.executeQuery(sql);

            if (resultado.next()) {
                customer = new Customer();
                customer.setCustomerId(resultado.getInt(1));
                customer.setStore(storeDAO.consultarStore(resultado.getInt(2)));
                customer.setFirstName(resultado.getString(3));
                customer.setLastName(resultado.getString(4));
                customer.setEmail(resultado.getString(5));
                customer.setAddress(addressDAO.consultarDireccion(resultado.getInt(6)));
                customer.setActive(resultado.getBoolean(7));
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
        return customer;
    }
}
