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
public class FilmActorListener implements ActionListener {

    private FilmActorController controller;

    public FilmActorListener(FilmActorController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
//            controller.nuevoAction();
            controller.cerrarAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
            controller.modificarCity();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            controller.guardarFilmActor();
        } else if (e.getActionCommand().equalsIgnoreCase("Adicionar a la lista")) {
            controller.adiccionarFilmActor();
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            controller.sacarLista();
        } else if (e.getActionCommand().equalsIgnoreCase("Film")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            controller.cerrarAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            controller.borrarFilmActor();
        }
    }

}
