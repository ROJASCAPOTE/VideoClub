/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Film;
import Servisios.ConnectionBD;
import java.sql.PreparedStatement;
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

    public int grabarFilmActor(int film_id, ArrayList<Film> filmActor) {
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        String last_update = sdf.format(fechaActual);
        
        try {
            Iterator<Film> FilmIterator = filmActor.iterator();
            String q = "INSERT INTO film_actor VALUES(?, ?, ?)";
            while (FilmIterator.hasNext()) {
                Film elemento = FilmIterator.next();
                pstm = con.getConexion().prepareStatement(q);
                pstm.setInt(1, film_id);
                pstm.setInt(2, elemento.getFilmId());
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
}
