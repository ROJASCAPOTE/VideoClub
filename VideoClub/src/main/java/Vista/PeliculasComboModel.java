/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Dao.DAOManager;
import Modelo.Film;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class PeliculasComboModel extends DefaultComboBoxModel {

    private DAOManager film;
    private List<Film> lista;

    public PeliculasComboModel(DAOManager film) {
        this.film = film;
        lista = new ArrayList<>();
    }

    public void update() {
        if (film != null) {
            lista = film.getFilmDAO().listadoFilm();
            removeAllElements();
            for (Film p : lista) {
                addElement(new PeliculasComboView(p));
            }
        }
    }

}
