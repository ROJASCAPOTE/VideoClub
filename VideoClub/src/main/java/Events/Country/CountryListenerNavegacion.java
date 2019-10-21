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
public class CountryListenerNavegacion implements ActionListener {

    private CountryController controlador;

    public CountryListenerNavegacion(CountryController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Primero")) {
            controlador.primero();
        } else if (e.getActionCommand().equalsIgnoreCase("Anterior")) {
            controlador.anterior();
        } else if (e.getActionCommand().equalsIgnoreCase("Siguiente")) {
            controlador.siguiente();
        } else if (e.getActionCommand().equalsIgnoreCase("Ultimo")) {
            controlador.ultimo();
        }
    }

}
