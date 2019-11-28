/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Film;
import Modelo.FilmActor;
import Modelo.FilmCategory;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class FilmCategoryDAO {

    private ConnectionBD con;

    public FilmCategoryDAO(ConnectionBD con) {
        this.con = con;
    }

    public int grabarFilmCategory(ArrayList<FilmCategory> filmCategory) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(fechaActual);

        try {
            Iterator<FilmCategory> FilmIterator = filmCategory.iterator();
            String q = "INSERT INTO film_category VALUES(?, ?, ?)";
            while (FilmIterator.hasNext()) {
                FilmCategory elemento = FilmIterator.next();
                pstm = con.getConexion().prepareStatement(q);
                pstm.setInt(1, elemento.getFilm().getFilmId());
                pstm.setInt(2, elemento.getCategory_id().getCategoryId());
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

    public DefaultComboBoxModel ListaFilmCategory(ArrayList<FilmCategory> filmCategory) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Iterator<FilmCategory> FilmIterator = filmCategory.iterator();
        while (FilmIterator.hasNext()) {
            FilmCategory elemento = FilmIterator.next();
            model.addElement(elemento.getCategory_id().getCategoryId() + "   |    " + elemento.getCategory_id().getName());
        }
        return model;
    }
}
