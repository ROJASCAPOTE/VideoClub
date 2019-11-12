/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.StaffController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class StaffListener implements ActionListener {

    private StaffController controller;

    public StaffListener(StaffController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
            controller.nuevoAction();
            controller.getCodigoStaff();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            controller.guardarStaff();

        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
            controller.modificarStaff();
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
        }
    }

}
