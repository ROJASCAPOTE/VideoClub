package Modelo.Dao;

import Modelo.Address;
import Modelo.Customer;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CustomerDAO {

    private ConnectionBD con;

    public CustomerDAO(ConnectionBD con) {
        this.con = con;
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
