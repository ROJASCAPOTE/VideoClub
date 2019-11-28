/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.CatalogoPeliculasController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ACER E5
 */
public class CatalogoPeliculasMouseListener extends MouseAdapter {

    private CatalogoPeliculasController controller;

    public CatalogoPeliculasMouseListener(CatalogoPeliculasController controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        controller.detallePelucula();
    }

}
