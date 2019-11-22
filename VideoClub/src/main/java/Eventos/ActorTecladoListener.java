/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.ActorListController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ACER E5
 */
public class ActorTecladoListener extends KeyAdapter {

    private ActorListController controller;

    public ActorTecladoListener(ActorListController controller) {
        this.controller = controller;
    }

    @Override
    public void keyReleased(KeyEvent evento) {
        controller.buscarActor();
    }
}
