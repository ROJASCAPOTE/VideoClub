package Modelo.Dao;

import Modelo.Actor;
import Modelo.Film;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
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

    public boolean grabarActor(Actor actor) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(actor.getLastUpdate());
        try {

            String sql = "INSERT INTO actor values (?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, actor.getActorId());
            pstm.setString(2, actor.getFirstName());
            pstm.setString(3, actor.getLastName());
            pstm.setString(4, last_update);
            rtdo = pstm.executeUpdate();
            pstm.close();

            Iterator<Film> FilmIterator = actor.getFilmActors().iterator();
            String q = "INSERT INTO film_actor VALUES(?, ?, ?)";
            while (FilmIterator.hasNext()) {
                Film elemento = FilmIterator.next();
                pstm = con.getConexion().prepareStatement(q);
                pstm.setInt(1, actor.getActorId());
                pstm.setInt(2, elemento.getFilmId());
                pstm.setString(3, last_update);
                rtdo = pstm.executeUpdate();
                pstm.close();
            }
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return false;
    }
}
