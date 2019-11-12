/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.StaffManagerStoreController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class StaffListenerManager implements ActionListener {

    private StaffManagerStoreController controller;

    public StaffListenerManager(StaffManagerStoreController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Aceptar")) {
            
        }if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            controller.cerrarAction();
        }
    }

}
