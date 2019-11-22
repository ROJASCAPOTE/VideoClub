/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.FilmActorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class ListFilmListener implements ActionListener {

    private FilmActorController controller;

    public ListFilmListener(FilmActorController controller) {
        this.controller = controller;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
     controller.listaFilm();
    }

}
