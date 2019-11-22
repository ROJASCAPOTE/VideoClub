/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.ActorController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class ActorMouseListener extends MouseAdapter {

    private ActorController controller;

    public ActorMouseListener(ActorController controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
      controller.seleccionarActor();
    }
}
