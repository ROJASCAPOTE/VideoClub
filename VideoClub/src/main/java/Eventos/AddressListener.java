/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.AddressController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class AddressListener implements ActionListener {

    private AddressController addressController;

    public AddressListener(AddressController addressController) {
        this.addressController = addressController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            addressController.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            addressController.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            addressController.cargarDireccion();
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Buscar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            addressController.cerrarAction();
        }

    }

}
