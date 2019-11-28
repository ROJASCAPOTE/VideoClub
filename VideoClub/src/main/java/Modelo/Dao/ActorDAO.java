package Modelo.Dao;

import Modelo.Actor;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ActorDAO {

    private ConnectionBD con;

    public ActorDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grtCodigo() {
        String sql = "SELECT MAX(actor_id) as total FROM actor";
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

    public int grabarActor(Actor actor) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(actor.getLastUpdate());
        try {
            String sql = "INSERT INTO actor values (?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, actor.getActorId());
            pstm.setString(2, actor.getFirstName());
            pstm.setString(3, actor.getLastName());
            pstm.setString(4, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public Object[][] getTableActor() {
        int registros = 0;
        String sql = "SELECT * FROM actor ORDER BY actor_id ASC";
        String cantidad = "Select count(*) as total from actor";
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

    public Object[][] getTableActores(String nombActor) {
        int registros = 0;
        String sql = "";
        if (nombActor.equals("")) {
            sql = "SELECT * FROM actor";
        } else {
            sql = "SELECT * FROM actor WHERE  first_name like '%" + nombActor + "%'";
            System.out.println(sql);
        }
        String cantidad = "Select count(*) as total from actor";
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

    public Actor consultarActor(int codigo) {
        String sql = "SELECT * FROM actor WHERE actor_id =" + codigo + "";
        ResultSet resultado = null;
        Statement st = null;
        Actor actor = null;
        try {
            st = con.getConexion().createStatement();
            resultado = st.executeQuery(sql);

            if (resultado.next()) {
                actor = new Actor();
                actor.setActorId(resultado.getInt(1));
                actor.setFirstName(resultado.getString(2));
                actor.setLastName(resultado.getString(3));
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
        return actor;

    }

    public ArrayList<Actor> listadoActores() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Actor> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM actor ORDER BY actor_id";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Actor actor = null;
            while (rs.next()) {
                actor = new Actor();
                actor.setActorId(rs.getInt(1));
                actor.setFirstName(rs.getString(2));
                actor.setLastName(rs.getString(3));
                listado.add(actor);
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

    public ArrayList<Actor> getListFilmActor(int film_id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Actor> listado = new ArrayList<>();
        try {
            String sql = "SELECT c.actor_id, c.first_name, c.last_name, c.last_update FROM film_actor m,  film f, actor c\n"
                    + "where m.film_id=f.film_id and m.actor_id=c.actor_id and m.film_id=" + film_id + "";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Actor actor = null;
            while (rs.next()) {
                actor = new Actor();
                actor.setActorId(rs.getInt(1));
                actor.setFirstName(rs.getString(2));
                actor.setLastName(rs.getString(3));
                listado.add(actor);
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
