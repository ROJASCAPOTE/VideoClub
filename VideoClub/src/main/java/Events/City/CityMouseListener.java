/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events.City;

import Controlador.CityListViewController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class CityMouseListener extends MouseAdapter {

    private CityListViewController controlador;

    public CityMouseListener(CityListViewController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        controlador.obtenerDatosCity();
        controlador.cerrarAction();

    }
}
