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
public class ActorListener implements ActionListener {

    private ActorController controller;

    public ActorListener(ActorController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            controller.guardarActor();
        } else if (e.getActionCommand().equalsIgnoreCase("Adicionar")) {
            controller.listaFilm();
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            controller.cerrarAction();
        }

    }

}
