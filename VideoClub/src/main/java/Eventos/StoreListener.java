/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.StoreController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class StoreListener implements ActionListener {

    private StoreController controller;

    public StoreListener(StoreController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            controller.nuevoAction();
            controller.cambiarCodigo();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
           controller.registrarTienda();
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            controller.registrarTienda();
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            controller.registrarTienda();
        }
    }

}
