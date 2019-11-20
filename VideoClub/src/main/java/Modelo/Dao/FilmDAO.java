/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.City;
import Modelo.Film;
import Servisios.ConnectionBD;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    public int grtCodigo() {
        String sql = "SELECT MAX(film_id) as total FROM film";
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

    public int grabarFilm(Film film) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(film.getLastUpdate());

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
        String realease_year = dateFormat.format(film.getReleaseYear());
        System.out.println("Modelo.Dao.FilmDAO.grabarFilm()" + realease_year);
        
        try {
            String sql = "INSERT INTO film"
                    + "(`film_id`,`title`,`description`,`release_year`,`language_id`,`original_language_id`,`rental_duration`,`rental_rate`,`length`,`replacement_cost`,`rating`,`special_features`,`last_update`)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, film.getFilmId());
            pstm.setString(2, film.getTitle());
            pstm.setString(3, film.getDescription());
            pstm.setString(4, realease_year);
            pstm.setInt(5, film.getLanguageByLanguageId().getLanguageId());
            pstm.setInt(6, film.getLanguageByOriginalLanguageId().getLanguageId());
            pstm.setInt(7, film.getRentalDuration());
            pstm.setBigDecimal(8, new BigDecimal(film.getRentalRate()));
            pstm.setInt(9, film.getLength());
            pstm.setBigDecimal(10, new BigDecimal(film.getReplacementCost()));
            pstm.setString(11, film.getRating());
            pstm.setString(12, film.getSpecialFeatures());
            pstm.setString(13, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public ArrayList<Film> listadoFilm() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Film> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM film ORDER BY film_id";
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
