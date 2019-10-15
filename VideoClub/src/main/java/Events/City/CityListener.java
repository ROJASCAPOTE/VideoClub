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

    private CityController controlador = null;

    public CityListener(CityController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controlador.actionNuevoRegistro();
        } else if (e.getActionCommand().equalsIgnoreCase("Guardar")) {
            controlador.registrarCity();
        } else if (e.getActionCommand().equalsIgnoreCase("Editar")) {
            controlador.modificarCity();
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            controlador.borrarCity();
        } else if (e.getActionCommand().equalsIgnoreCase("Buscar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            controlador.actionCancelar();
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
           controlador.actionCerrar();
        }
    }

}
