/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.FilmListController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ACER E5
 */
public class CategoryFilmListListener extends KeyAdapter  implements ActionListener {

    private FilmListController controller;

    public CategoryFilmListListener(FilmListController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buscarFilm();
    }

    @Override
    public void keyReleased(KeyEvent evento) {
        controller.buscarPorCodigoNombre();
    }
}
