/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author ACER E5
 */
public class FilmActorId {

    private ArrayList<FilmActor> filmActors;

    public FilmActorId() {
        filmActors = new ArrayList<>();
    }

    public FilmActor buscarItem(String title) {
        boolean encontrado = false;
        FilmActor item = null;

        int i = 0;
        int totalItems = filmActors.size();
        while (i < totalItems && !encontrado) {
            item = filmActors.get(i);
            if (item.getFilm().getTitle().equals(title)) {
                encontrado = true;
            }
            i++;
        }
        if (encontrado) {
            return item;
        } else {
            return null;
        }
    }
    
    

}
