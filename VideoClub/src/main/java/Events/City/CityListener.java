/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events.City;

import Controlador.CityController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class CityListener implements ActionListener {

    private CityController controller = null;

    public CityListener(CityController controlador) {
        this.controller = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            controller.registrarCity();
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
           controller.modificarCity();
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            controller.borrarCity();
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            controller.cerrarAction();
        }
    }

}
