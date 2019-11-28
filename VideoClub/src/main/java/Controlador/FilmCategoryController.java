/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.FilmCategoryListener;
import Modelo.Category;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import Modelo.FilmCategory;
import ModeloGUI.ModeloFilmCategory;
import Vista.FrmFilmCategory;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class FilmCategoryController {

    private FrmFilmCategory vista;
    private DAOManager modelo;
    private ArrayList<FilmCategory> listaFilmCategory;
    private Film film;
    private ModeloFilmCategory modeloFilmCategory;

    public FilmCategoryController(FrmFilmCategory vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.listaFilmCategory = new ArrayList();
        this.vista.addListenerNuevo(new FilmCategoryListener(this));
        this.vista.addListenerBtnModificar(new FilmCategoryListener(this));
        this.vista.addListenerCerrar(new FilmCategoryListener(this));
        this.vista.addListenerAdicionar(new FilmCategoryListener(this));
        this.vista.addListenerBtnSacarLista(new FilmCategoryListener(this));
        this.vista.activarControles(false);

        ArrayList<Category> listadoCategory;
        listadoCategory = modelo.getCategoriaDAO().listadoCategory();
        vista.cargarCategory(listadoCategory);
    }

    public void sacarLista() {
        int selectedIndex = vista.getDetalleFilmCategory().getSelectedIndex();
        if (selectedIndex != -1) {
            modeloFilmCategory.eliminar(selectedIndex);
            vista.getDetalleFilmCategory().setModel(modeloFilmCategory);
        } else {
            vista.gestionMensajes("Seleccione una categoria para sacar de la lista",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void adiccionarFilmCategory() {
        FilmCategory filmCategory = new FilmCategory();
        int seleccion = vista.getConbCategory().getSelectedIndex();
        if (seleccion == 0) {
            vista.gestionMensajes("Seleccione una categoria",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        } else {
            Category category = (Category) vista.getConbCategory().getSelectedItem();
            if (category != null) {
                FilmCategory fc = buscarItemFilmCategory(category.getCategoryId());
                if (fc == null) {
                    filmCategory.setFilm(film);
                    filmCategory.setCategory_id(category);
                    listaFilmCategory.add(filmCategory);
                    modeloFilmCategory = new ModeloFilmCategory(listaFilmCategory);
                    vista.getDetalleFilmCategory().setModel(modeloFilmCategory);
                    seleccionar(listaFilmCategory.size() - 1);
                } else {
                    vista.gestionMensajes("La categoria ya se encuentra en la lista",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                vista.gestionMensajes("Seleccione un actor",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void guardarFilmCategory() {
        if (listaFilmCategory.size() > 0) {

            int resultado = 0;
            resultado = modelo.getFilCategoryDAO().grabarFilmCategory(listaFilmCategory);
            if (resultado == 1) {
                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                vista.activarControles(false);
                vista.nuevoAction();
                vista.getDetalleFilmCategory().setModel(new DefaultComboBoxModel());
                vista.cerrarAction();
                this.listaFilmCategory.clear();
            } else {
                vista.gestionMensajes("Ya esta registrado el actor de la pelicula",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

////    public void listFilmActor(Film film) {
////        modeloActorFilm = new ListModeloActorFilm();
////        Film unItem = buscarItemFilm(film.getTitle());
////        if (unItem == null) {
////            listaFilm.add(film);
////            modeloActorFilm.addElement(listaFilm);
////            vista.getDetalleFilmCategory().setModel(modeloActorFilm);
////            seleccionar(listaFilm.size() - 1);
////        } else {
////            modeloActorFilm.addElement(listaFilm);
////            vista.getDetalleFilmCategory().setModel(modeloActorFilm);
////            seleccionar(listaFilm.size() - 1);
////        }
////    }
    public void seleccionar(int seleccionado) {
        vista.getDetalleFilmCategory().setSelectedIndex(seleccionado);
        vista.getDetalleFilmCategory().ensureIndexIsVisible(seleccionado);
    }

    public FilmCategory buscarItemFilmCategory(int codigo) {
        boolean encontrado = false;
        FilmCategory item = null;

        // �ndice para el recorrido del arreglo
        int i = 0;
        int totalItems = listaFilmCategory.size();
        // Mientras no encuentre el libro en un �tem
        while (i < totalItems && !encontrado) {
            item = listaFilmCategory.get(i);
            if (item.getCategory_id().getCategoryId() == codigo) {
                encontrado = true;
            }
            i++;
        }
        if (encontrado) {
            return item;
        } else {
            return null;
        }
    }

    public void guardarCategory() {

    }

    public void nuevoAction() {
        vista.nuevoAction();
        this.listaFilmCategory.clear();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

    public void setFilm(Film film) {
        this.film = film;
        vista.setFilmCategory(film);
    }

    public Film getFilm() {
        return film;
    }

}
