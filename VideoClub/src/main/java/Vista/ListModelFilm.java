/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Dao.DAOManager;
import Modelo.Film;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ACER E5
 */
public class ListModelFilm extends AbstractListModel implements ComboBoxModel {

    private Object selectedItem;
    private DAOManager film;
    private ArrayList<Film> listaFilms;

    public ListModelFilm(DAOManager film, ArrayList<Film> listaFilms) {
        this.film = film;
        this.listaFilms = listaFilms;
    }

    @Override
    public int getSize() {
        return listaFilms.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaFilms.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    public Film getFilm(int index) {
        return listaFilms.get(index);
    }

}
