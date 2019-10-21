/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events.Country;

import Controlador.CountryListViewController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class ContryMouseListener extends MouseAdapter {

    private CountryListViewController controlador;

    public ContryMouseListener(CountryListViewController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        controlador.obtenerDatosPais();
        controlador.cerrarAction();
    }
}
