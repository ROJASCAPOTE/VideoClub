/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Film;

/**
 *
 * @author ACER E5
 */
public class PeliculasComboView {

    private Film film;

    public PeliculasComboView(Film film) {
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
 @Override
    public String toString() {
        return film.toString();
    }
}
