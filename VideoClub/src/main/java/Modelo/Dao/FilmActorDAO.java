/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Film;
import Modelo.FilmActor;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

    public int modificarFilmActor(FilmActor fa, FilmActor filmActor) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            String sql = "UPDATE film_actor SET actor_id=?, film_id=? WHERE actor_id=? and film_id=?";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, filmActor.getActor_id().getActorId());
            pstm.setInt(2, filmActor.getFilm().getFilmId());
            pstm.setInt(3, fa.getActor_id().getActorId());
            pstm.setInt(4, fa.getFilm().getFilmId());
            rtdo = pstm.executeUpdate();
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

    public static void main(String[] args) {

    }
}
