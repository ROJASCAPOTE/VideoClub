/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.CountryListController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class ContryMouseListener extends MouseAdapter {

    private CountryListController controlador;

    public ContryMouseListener(CountryListController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        controlador.obtenerDatosPais();
        controlador.cerrarAction();
    }
}
