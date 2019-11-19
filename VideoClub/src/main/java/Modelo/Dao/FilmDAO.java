/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.City;
import Modelo.Film;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class FilmDAO {

    private ConnectionBD con;

    public FilmDAO(ConnectionBD con) {
        this.con = con;
    }

    public ArrayList<Film> listadoFilm() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Film> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM film ORDER BY title";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Film film = null;
            while (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt(1));
                film.setTitle(rs.getString(2));
                film.setDescription(rs.getString(3));
                film.setReleaseYear(rs.getDate(4));
                listado.add(film);
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

    public Film buscarFilm(int codigo) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Film film = null;
        try {
            String sql = "SELECT * FROM film WHERE film_id=" + codigo + "";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();

            if (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt(1));
                film.setTitle(rs.getString(2));
                film.setDescription(rs.getString(3));
                film.setReleaseYear(rs.getDate(4));
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
        return film;
    }
//public producto getProducto(String nombre) {
//        producto p = new producto();
//        String q = "SELECT * FROM tproducto WHERE p_descripcion = '" + nombre + "' ";
//        try {
//            PreparedStatement pstm = this.getConexion().prepareStatement(q);
//            ResultSet res = pstm.executeQuery();
//            while (res.next()) {
//                p.setId(res.getString("p_id"));
//                p.setDescripcion(res.getString("p_descripcion"));
//                p.setPrecio(res.getFloat("p_preciov"));
//                p.setStock(res.getInt("p_stock"));
//                p.setCategoria(res.getString("id_categoria"));
//            }
//            res.close();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return p;
//    }

}
