/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.LanguageController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class LanguageListener implements ActionListener {

    private LanguageController controller;

    public LanguageListener(LanguageController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
            controller.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
        }
    }

}
