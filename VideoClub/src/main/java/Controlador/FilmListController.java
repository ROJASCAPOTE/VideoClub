/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.CategoryFilmListListener;
import Eventos.FilmMouseListener;
import Modelo.Category;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import Vista.FilmTableModel;
import Vista.FrmFilm;
import Vista.FrmListFilm;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class FilmListController {

    private FrmListFilm vista;
    private DAOManager modelo;
    private FilmTableModel filmTableModel;
    private FrmFilm frmFilm;

    public FilmListController(FrmListFilm vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addListenerBuscar(new CategoryFilmListListener(this));
        this.vista.addaddKeyListenerBuscar(new CategoryFilmListListener(this));
        this.vista.addMouseListenerCountry(new FilmMouseListener(this));
        ArrayList<Film> lista;
        lista = modelo.getFilmDAO().getListFilm("");
        filmTableModel = new FilmTableModel(lista);
        vista.setModel(filmTableModel);

        ArrayList<Category> listCategory;
        listCategory = modelo.getCategoriaDAO().listadoCategory();
        vista.cargarCategorias(listCategory);

    }

    public void setFrmFilm(FrmFilm frmFilm) {
        this.frmFilm = frmFilm;
    }

    public void buscarFilm() {
        Category category = (Category) vista.getCombCategory().getSelectedItem();
        ArrayList<Film> listaFilmCategoria = modelo.getFilmDAO().getListFilmCategoria(category.getCategoryId());
        if (listaFilmCategoria.size() > 0) {
            filmTableModel = new FilmTableModel(listaFilmCategoria);
            vista.setModel(filmTableModel);
        } else {
            vista.gestionMensajes("No hay peliculas de  " + category.getName(),
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            filmTableModel = new FilmTableModel(listaFilmCategoria);
            vista.setModel(filmTableModel);
        }
    }

    public void buscarPorNombreFilm() {
        String nombre = vista.getTextoNombreFilm();
        ArrayList<Film> listNameFilm = modelo.getFilmDAO().getListFilm(nombre);
        filmTableModel = new FilmTableModel(listNameFilm);
        vista.setModel(filmTableModel);
    }

    public void seleccionarPelicula() {
        int filaSeleccionada = vista.getTableListFilm().getSelectedRow();
        int film_id = (int) vista.getTableListFilm().getValueAt(filaSeleccionada, 0);
        Film film = modelo.getFilmDAO().getFilm(film_id);
        if (film != null) {
            frmFilm.mostrarFilm(film);
            frmFilm.modificarAction();
        } else {
            vista.gestionMensajes("Error en la busqueda de la pelicula  ",
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
