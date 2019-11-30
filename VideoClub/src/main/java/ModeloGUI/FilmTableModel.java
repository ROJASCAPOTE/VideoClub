/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloGUI;

import Vista.*;
import Modelo.Film;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER E5
 */
public class FilmTableModel extends AbstractTableModel {
    
    private final ArrayList<Film> listaFilms;
    private final Object[] columnas = {"Film Id", "Title", "Release year", "Rental Duration", "Rental Rate", "length", "rating"};
    
    public FilmTableModel(ArrayList<Film> listaFilms) {
        this.listaFilms = listaFilms;
    }
    
    @Override
    public int getRowCount() {
        return listaFilms.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnas[column].toString();
    }
    
    public Film getFilm(int index) {
        return listaFilms.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaFilms.get(rowIndex).getFilmId();
            case 1:
                return listaFilms.get(rowIndex).getTitle();
            case 2:
                return listaFilms.get(rowIndex).getReleaseYear();
            case 3:
                return listaFilms.get(rowIndex).getRentalDuration();
            case 4:
                return listaFilms.get(rowIndex).getRentalRate();
            case 5:
                return listaFilms.get(rowIndex).getLength();
            case 6:
                return listaFilms.get(rowIndex).getRating();
            default:
                return null;
        }
    }
    
}
