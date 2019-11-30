/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.ActorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ACER E5
 */
public class ActorListener extends KeyAdapter implements ActionListener {

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
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
            controller.actualizarActor();
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            controller.borrarActor();
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            controller.cerrarAction();
        }

    }
    
    @Override
    public void keyReleased(KeyEvent evento) {
        controller.buscarActor();
    }

}
