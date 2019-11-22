/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.ActorListController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class ActorListMouseListener extends MouseAdapter {

    private ActorListController actorListController;

    public ActorListMouseListener(ActorListController actorListController) {
        this.actorListController = actorListController;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        actorListController.seleccionarActor();
        actorListController.cerrarAction();
    }
}
