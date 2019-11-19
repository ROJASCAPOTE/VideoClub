/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.ActorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class ListFilmListener implements ActionListener {

    private ActorController controller;

    public ListFilmListener(ActorController controller) {
        this.controller = controller;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
     controller.listaFilm();
    }

}
