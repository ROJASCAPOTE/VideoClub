/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.FilmActor;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class FilmActorDAO {

    private ConnectionBD con;

    public FilmActorDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grabarFilmActor(ArrayList<FilmActor> filmActor) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(fechaActual);

        try {
            Iterator<FilmActor> FilmIterator = filmActor.iterator();
            String q = "INSERT INTO film_actor VALUES(?, ?, ?)";
            while (FilmIterator.hasNext()) {
                FilmActor elemento = FilmIterator.next();
                pstm = con.getConexion().prepareStatement(q);
                pstm.setInt(1, elemento.getActor_id().getActorId());
                pstm.setInt(2, elemento.getFilm().getFilmId());
                pstm.setString(3, last_update);
                rtdo = pstm.executeUpdate();
            }
            pstm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    

    public int borrarFilmActor(FilmActor filmActor) {
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            String sql = "DELETE FROM film_actor WHERE actor_id = ? and film_id=?";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, filmActor.getActor_id().getActorId());
            pstm.setInt(2, filmActor.getFilm().getFilmId());
            rtdo = pstm.executeUpdate();
            return rtdo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public int borrarFilmActor(int actor_id) {
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            String sql = "DELETE FROM film_actor WHERE actor_id = ? ";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, actor_id);
            rtdo = pstm.executeUpdate();
            return rtdo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public ArrayList<FilmActor> listadoFilmActor(int codigo) {
        FilmDAO filmDAO = new FilmDAO(con);
        ActorDAO actorDAO = new ActorDAO(con);
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<FilmActor> listado = new ArrayList<>();
        try {
            String sql = "select * from film_actor where actor_id=" + codigo + "";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            FilmActor filmActor = null;
            while (rs.next()) {
                filmActor = new FilmActor();
                filmActor.setActor_id(actorDAO.consultarActor(rs.getInt(1)));
                filmActor.setFilm(filmDAO.buscarFilm(rs.getInt(2)));
                listado.add(filmActor);
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

    public FilmActor buscarFilmActor(int codigo) {
        FilmDAO filmDAO = new FilmDAO(con);
        ActorDAO actorDAO = new ActorDAO(con);
        PreparedStatement pstm = null;
        ResultSet rs = null;
        FilmActor filmActor = null;
        try {
            String sql = "select * from film_actor where actor_id=" + codigo + "";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();

            if (rs.next()) {
                filmActor = new FilmActor();
                filmActor.setActor_id(actorDAO.consultarActor(rs.getInt(1)));
                filmActor.setFilm(filmDAO.buscarFilm(rs.getInt(2)));
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
        return filmActor;
    }

    public DefaultComboBoxModel ListaFilmActor(Map carrito_compra) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Iterator it = carrito_compra.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            FilmActor itm = (FilmActor) e.getValue();
            model.addElement(itm.getActor_id().getActorId() + " | " + itm.getActor_id().getFirstName() + "   " + itm.getActor_id().getLastName() + " | " + itm.getFilm().getFilmId() + "  |   " + itm.getFilm().getTitle());
        }
        return model;
    }

    public DefaultComboBoxModel ListaFilmActor(ArrayList<FilmActor> filmActors) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Iterator<FilmActor> FilmIterator = filmActors.iterator();
        while (FilmIterator.hasNext()) {
            FilmActor elemento = FilmIterator.next();
            model.addElement(elemento.getActor_id().getActorId() + "   |    " + elemento.getActor_id().getFirstName() + "       " + elemento.getActor_id().getLastName());
        }
        return model;
    }
}
