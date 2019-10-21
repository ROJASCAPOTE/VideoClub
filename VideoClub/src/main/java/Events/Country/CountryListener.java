/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events.Country;

import Controlador.CountryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class CountryListener implements ActionListener {

    private CountryController controller;

    public CountryListener(CountryController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            controller.registrarCountry();
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
            controller.modificarCountry();
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            controller.eliminarCountry();
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            controller.cerrarAction();
        }

    }

}
