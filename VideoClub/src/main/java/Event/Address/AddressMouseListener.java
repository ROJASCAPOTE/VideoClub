/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event.Address;

import Controlador.AddressListController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class AddressMouseListener extends MouseAdapter {

    private AddressListController controller;

    public AddressMouseListener(AddressListController controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        controller.obtenerDatosDireccion();
        controller.cerrarAction();
    }
}
