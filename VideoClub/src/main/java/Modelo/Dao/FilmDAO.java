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

    public int modificarFilm(Film f) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String last_update = sdf.format(f.getLastUpdate());
        try {
            String sql = "UPDATE film "
                    + "SET title=?, description=?, language_id=?, original_language_id=?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?,rating=?, special_features=?,last_update=? WHERE film_id=?";
            pstm = con.getConexion().prepareStatement(sql);

            pstm.setString(1, f.getTitle());
            pstm.setString(2, f.getDescription());
            pstm.setInt(3, f.getLanguageByLanguageId().getLanguageId());
            pstm.setInt(4, f.getLanguageByOriginalLanguageId().getLanguageId());
            pstm.setInt(5, f.getRentalDuration());
            pstm.setBigDecimal(6, new BigDecimal(f.getRentalRate()));
            pstm.setInt(7, f.getLength());
            pstm.setBigDecimal(8, new BigDecimal(f.getReplacementCost()));
            pstm.setString(9, f.getRating());
            pstm.setString(10, f.getSpecialFeatures());
            pstm.setString(11, last_update);
            pstm.setInt(12, f.getFilmId());
            rtdo = pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public int eliminarFilm(int film_id) {
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try {
            String sql = "DELETE FROM film WHERE film_id = ? ";
            pstm = con.getConexion().prepareStatement(sql);
            pstm.setInt(1, film_id);
            rtdo = pstm.executeUpdate();
            return rtdo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return rtdo;
    }

    public ArrayList<Film> getDetallePelicula() {
        LanguageDAO languageDAO = new LanguageDAO(con);
        String sql = "SELECT * FROM film";
        ResultSet resultado = null;
        Statement st = null;
        ArrayList<Film> listado = new ArrayList<>();
        Film film = null;
        try {
            st = con.getConexion().createStatement();
            resultado = st.executeQuery(sql);
            while (resultado.next()) {
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
                listado.add(film);
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
        return listado;
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

    public ArrayList<Film> getListFilm(int codigo, String nombre) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Film> listado = new ArrayList<>();
        String sql = "";
        if (!nombre.equals("")) {
            sql = "SELECT film_id, title, release_year, rental_duration, rental_rate, length, rating FROM film WHERE  title like '%" + nombre + "%'";
        } else if (codigo > 0) {
            sql = "SELECT film_id, title, release_year, rental_duration, rental_rate, length, rating FROM film WHERE  film_id like '%" + codigo + "%'";
        } else {
            sql = "SELECT film_id, title, release_year, rental_duration, rental_rate, length, rating FROM film";
        }
        try {
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Film film = null;
            while (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt(1));
                film.setTitle(rs.getString(2));
                film.setReleaseYear(rs.getDate(3));
                film.setRentalDuration(rs.getInt(4));
                film.setRentalRate(rs.getDouble(5));
                film.setLength(rs.getInt(6));
                film.setRating(rs.getString(7));
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
            String sql = "select f.film_id, f.title, f.release_year, f.rental_duration, f.rental_rate, f.length, f.rating  from film_category c, film f where c.film_id=f.film_id and c.category_id=" + categoria + "";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();
            Film film = null;
            while (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt(1));
                film.setTitle(rs.getString(2));
                film.setReleaseYear(rs.getDate(3));
                film.setRentalDuration(rs.getInt(4));
                film.setRentalRate(rs.getDouble(5));
                film.setLength(rs.getInt(6));
                film.setRating(rs.getString(7));
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
            String sql = "SELECT film_id, title, description, release_year, rental_duration, rental_rate, length FROM film WHERE film_id=" + codigo + "";
            pstm = con.getConexion().prepareStatement(sql);
            rs = pstm.executeQuery();

            if (rs.next()) {
                film = new Film();
                film.setFilmId(rs.getInt(1));
                film.setTitle(rs.getString(2));
                film.setDescription(rs.getString(3));
                film.setReleaseYear(rs.getDate(4));
                film.setRentalDuration(rs.getInt(5));
                film.setRentalRate(rs.getInt(6));
                film.setLength(rs.getInt(7));
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

    public Object[][] getTablaCatalogoPelicula() {
        LanguageDAO ldao = new LanguageDAO(con);
        int registros = 0;
        String sql = "SELECT film_id, title, release_year, language_id, original_language_id, rental_duration, rental_rate, length, rating FROM film  ORDER BY film_id ASC";
        String cantidad = "Select count(*) as total from film";
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

        Object[][] data = new String[registros][8];
        PreparedStatement pst = null;
        ResultSet resp = null;
        int i = 0;
        String idioma = "";
        try {
            pst = con.getConexion().prepareStatement(sql);
            resp = pst.executeQuery();
            while (resp.next()) {
                data[i][0] = resp.getString(1);
                data[i][1] = resp.getString(2);
                data[i][2] = resp.getString(3);
                data[i][3] = resp.getString(4) + ", " + resp.getString(5);
                data[i][4] = resp.getString(6);
                data[i][5] = resp.getString(7);
                data[i][6] = resp.getString(8);
                data[i][7] = resp.getString(9);
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }
}
