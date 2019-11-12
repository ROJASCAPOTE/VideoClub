/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.StaffListController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class StaffMouseListener extends MouseAdapter {

    private StaffListController controller;

    public StaffMouseListener(StaffListController controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        controller.obtenerDatosStaff();
        controller.cerrarAction();
    }
}
