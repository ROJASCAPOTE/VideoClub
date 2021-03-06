/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.FilmCategoryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class FilmCategoryListener implements ActionListener {

    private FilmCategoryController categoryController;

    public FilmCategoryListener(FilmCategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            categoryController.nuevoAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Cancelar")) {
//            categoryController.nuevoAction();
            categoryController.cerrarAction();
        } else if (e.getActionCommand().equalsIgnoreCase("Actualizar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Grabar")) {
            categoryController.guardarFilmCategory();
        } else if (e.getActionCommand().equalsIgnoreCase("Adiccionar")) {
            categoryController.adiccionarFilmCategory();
        } else if (e.getActionCommand().equalsIgnoreCase("Consultar")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
        } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            categoryController.sacarLista();
        }
    }

}
