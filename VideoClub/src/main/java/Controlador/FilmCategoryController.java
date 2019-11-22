/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.CategoryListener;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import Vista.FrmFilmCategory;
import Vista.ListModelFilm;
import Vista.ListModeloActorFilm;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FilmCategoryController {

    private FrmFilmCategory vista;
    private DAOManager modelo;
    private ArrayList<Film> listaFilm;
    private ListModelFilm modeloFilm;
    private ListModeloActorFilm modeloActorFilm;

    public FilmCategoryController(FrmFilmCategory vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.listaFilm = new ArrayList();
//        this.vista.addListenerNuevo(new CategoryListener(this));
//        this.vista.addListenerBtnModificar(new CategoryListener(this));
//        this.vista.addListenerCerrar(new CategoryListener(this));
//        this.vista.addListenerAdicionar(new CategoryListener(this));
//        this.vista.activarControles(false);
        ArrayList<Film> lista;
        lista = modelo.getFilmDAO().listadoFilm();
        modeloFilm = new ListModelFilm(modelo, lista);
        vista.setModelo(modeloFilm);
    }

    public void listaFilm() {
        int selection = vista.getListaFilm().getSelectedIndex();
        if (selection != -1) {
            Film codigo = modeloFilm.getFilm(selection);
            Film film = this.modelo.getFilmDAO().buscarFilm(codigo.getFilmId());
            listFilmActor(film);
        } else {
            vista.gestionMensajes("Debe seleccionar una pelicula",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void listFilmActor(Film film) {
        modeloActorFilm = new ListModeloActorFilm();
        Film unItem = buscarItemFilm(film.getTitle());
        if (unItem == null) {
            listaFilm.add(film);
            modeloActorFilm.addElement(listaFilm);
            vista.getDetalleFilmCategory().setModel(modeloActorFilm);
            vista.setModelo(modeloFilm);
            seleccionar(listaFilm.size() - 1);
        } else {
            modeloActorFilm.addElement(listaFilm);
            vista.getDetalleFilmCategory().setModel(modeloActorFilm);
            vista.setModelo(modeloFilm);
            seleccionar(listaFilm.size() - 1);
        }
    }

    public void seleccionar(int seleccionado) {
        vista.getDetalleFilmCategory().setSelectedIndex(seleccionado);
        vista.getDetalleFilmCategory().ensureIndexIsVisible(seleccionado);
    }

    public Film buscarItemFilm(String title) {
        boolean encontrado = false;
        Film item = null;

        // �ndice para el recorrido del arreglo
        int i = 0;
        int totalItems = listaFilm.size();
        // Mientras no encuentre el libro en un �tem
        while (i < totalItems && !encontrado) {
            item = listaFilm.get(i);
            if (item.getTitle().equals(title)) {
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
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
