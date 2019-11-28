/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.CatalogoPeliculasController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogoPeliculasListener implements ActionListener {

    private CatalogoPeliculasController controller;

    public CatalogoPeliculasListener(CatalogoPeliculasController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Consultar Todos")) {
            controller.consultarCatalogoPeliculas();
        }
    }

}
