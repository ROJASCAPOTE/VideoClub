/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Film;
import Servisios.ConnectionBD;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(film.getLastUpdate());

//        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
//        String realease_year = dateFormat.format(film.getReleaseYear());
        try {
            String sql = "INSERT INTO film"
                    + "(`film_id`,`title`,`description`,`language_id`,`original_language_id`,`rental_duration`,`rental_rate`,`length`,`replacement_cost`,`rating`,`special_features`,`last_update`)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, film.getFilmId());
            pstm.setString(2, film.getTitle());
            pstm.setString(3, film.getDescription());
            pstm.setInt(4, film.getLanguageByLanguageId().getLanguageId());
            pstm.setInt(5, film.getLanguageByOriginalLanguageId().getLanguageId());
            pstm.setInt(6, film.getRentalDuration());
            pstm.setBigDecimal(7, new BigDecimal(film.getRentalRate()));
            pstm.setInt(8, film.getLength());
            pstm.setBigDecimal(9, new BigDecimal(film.getReplacementCost()));
            pstm.setString(10, film.getRating());
            pstm.setString(11, film.getSpecialFeatures());
            pstm.setString(12, last_update);
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public Film getFilm(int codigo) {
        LanguageDAO languageDAO = new LanguageDAO(con);
        String sql = "SELECT * FROM film WHERE film_id =" + codigo + "";
        ResultSet resultado = null;
        Statement st = null;
        Film film = null;
        try {
            st = con.getConexion().createStatement();
            resultado = st.executeQuery(sql);
            if (resultado.next()) {
                film = new Film();
                film.setFilmId(resultado.getInt(1));
                film.setTitle(resultado.getString(2));
                film.setDescription(resultado.getString(3));
                film.setReleaseYear(resultado.getDate(4));
                film.setLanguageByLanguageId(languageDAO.buscarLanguage(resultado.getInt(5)));
                film.setLanguageByOriginalLanguageId(languageDAO.buscarLanguage(resultado.getInt(6)));
                film.setRentalDuration(resultado.getInt(7));
                film.setRentalRate(resultado.getDouble(8));
                film.setLength(resultado.getInt(9));
                film.setReplacementCost(resultado.getDouble(10));
                film.setRating(resultado.getString(11));
                film.setSpecialFeatures(resultado.getString(12));
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
        return film;
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

    public ArrayList<Film> getListFilm(String nombre) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Film> listado = new ArrayList<>();
        String sql = "";
        if (nombre.equals("")) {
            sql = "SELECT film_id, title, rental_duration, rental_rate, length, special_features FROM film";
        } else {
            sql = "SELECT film_id, title, rental_duration, rental_rate, length, special_features FROM film  WHERE title like '%" + nombre + "%'";
        }
        try {
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Film film = null;
            while (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setRentalDuration(rs.getInt("rental_duration"));
                film.setRentalRate(rs.getDouble("rental_rate"));
                film.setLength(rs.getInt("length"));
                film.setSpecialFeatures(rs.getString("special_features"));
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

    public ArrayList<Film> getListFilmCategoria(int categoria) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Film> listado = new ArrayList<>();
        try {
            String sql = "select f.film_id, f.title, f.rental_duration, f.rental_rate, f.length, f.special_features  from film_category c, film f where c.film_id=f.film_id and c.category_id=" + categoria + "";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Film film = null;
            while (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt(1));
                film.setTitle(rs.getString(2));
                film.setRentalDuration(rs.getInt(3));
                film.setRentalRate(rs.getDouble(4));
                film.setLength(rs.getInt(5));
                film.setSpecialFeatures(rs.getString(6));
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
