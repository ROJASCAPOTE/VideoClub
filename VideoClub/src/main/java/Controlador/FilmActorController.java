/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.FilmActorListener;
import Modelo.Actor;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import Modelo.FilmActor;
import ModeloGUI.ModeloFilmActor;
import Vista.FrmFilmActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class FilmActorController {

    private FrmFilmActor vista;
    private DAOManager modelo;
    private ArrayList<FilmActor> filmActorLista;
    private Film film;
    private Map filmActor = new HashMap();
    private ModeloFilmActor modeloFilmActor;

    public FilmActorController(FrmFilmActor vista, DAOManager modelo, Film film) {
        this.vista = vista;
        this.modelo = modelo;
        this.film = film;
        this.filmActorLista = new ArrayList();
        vista.addListenerNuevo(new FilmActorListener(this));
        vista.addListenerBtnModificar(new FilmActorListener(this));
        vista.addListenerCerrar(new FilmActorListener(this));
        vista.addListenerBtnAdiccionar(new FilmActorListener(this));
        vista.addListenerBtnSacarLista(new FilmActorListener(this));
        vista.setCodigoPelicula(film);
        this.vista.activarControles(false);

        ArrayList<Actor> listadoActores;
        listadoActores = modelo.getActorDAO().listadoActores();
        vista.cargarActores(listadoActores);
    }

    public void adiccionarFilmActor() {
        FilmActor actorFilm = new FilmActor();
        int seleccion = vista.getCobActores().getSelectedIndex();
        if (seleccion == 0) {
            vista.gestionMensajes("Seleccione un actor",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        } else {
            Actor actor = (Actor) vista.getCobActores().getSelectedItem();
            if (actor != null) {
                FilmActor filmAc = buscarItemFilm(actor.getActorId());
                if (filmAc == null) {
                    actorFilm.setFilm(film);
                    actorFilm.setActor_id(actor);
                    this.filmActorLista.add(actorFilm);
                    modeloFilmActor = new ModeloFilmActor(filmActorLista);
                    vista.getListFilmActor().setModel(modeloFilmActor);
                } else {
                    vista.gestionMensajes("El actor ya esta en la lista de actores ",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                vista.gestionMensajes("Seleccione un actor",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void sacarLista() {
        int selectedIndex = vista.getListFilmActor().getSelectedIndex();
        if (selectedIndex != -1) {
            modeloFilmActor.eliminar(selectedIndex);
            vista.getListFilmActor().setModel(modeloFilmActor);
        } else {
            vista.gestionMensajes("Seleccione una categoria para sacar de la lista",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void seleccionar(int seleccionado) {
        vista.getListFilmActor().setSelectedIndex(seleccionado);
        vista.getListFilmActor().ensureIndexIsVisible(seleccionado);
    }

    public FilmActor buscarItemFilm(int codigo) {
        boolean encontrado = false;
        FilmActor item = null;

        // �ndice para el recorrido del arreglo
        int i = 0;
        int totalItems = filmActorLista.size();
        // Mientras no encuentre el libro en un �tem
        while (i < totalItems && !encontrado) {
            item = filmActorLista.get(i);
            if (item.getActor_id().getActorId() == codigo) {
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

    public void guardarFilmActor() {
        if (filmActorLista.size() > 0) {

            int resultado = 0;
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Guardar",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION) {
                resultado = modelo.getFilmActorDAO().grabarFilmActor(filmActorLista);
                if (resultado == 1) {
                    vista.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.getListFilmActor().setModel(new DefaultComboBoxModel());
                    this.filmActorLista.clear();
                    vista.cerrarAction();
                } else {
                    vista.gestionMensajes("Ya esta registrado el actor de la pelicula",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void modificarCity() {

    }

    public void borrarFilmActor() {

    }

    public void nuevoAction() {
        vista.nuevoAction();
        this.filmActorLista.clear();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
