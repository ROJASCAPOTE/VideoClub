/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.CustomerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class CustomerListener implements ActionListener {

    private CustomerController controller;

    public CustomerListener(CustomerController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            controller.guardarCustomer();
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
            controller.modificarCustomer();
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            controller.eliminarCustomer();
        } else if (e.getActionCommand().equalsIgnoreCase("Buscar")) {
            controller.buscarCustomer();
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            controller.cerrarAction();
        }

    }

}
