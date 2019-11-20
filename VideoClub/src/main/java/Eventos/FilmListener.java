/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.FilmController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class FilmListener implements ActionListener {

    private FilmController controller;

    public FilmListener(FilmController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            controller.guardarFilm();
        } else if (e.getActionCommand().equalsIgnoreCase("Adicionar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Buscar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {

        }
    }

}
