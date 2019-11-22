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
import Vista.FrmFilmActor;
import Vista.ListFilActorModelo;
import Vista.ListModelFilm;
import Vista.ListModeloActorFilm;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class FilmActorController {

    private FrmFilmActor vista;
    private DAOManager modelo;
    private ArrayList<Film> listaFilm;
    private ArrayList<FilmActor> filmActorLista;
    private ListModeloActorFilm modeloActorFilm;
    private ListModelFilm modeloFilm;
    private DefaultListModel model;
    private ListFilActorModelo modeloFilmActor;

    public FilmActorController(FrmFilmActor vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.listaFilm = new ArrayList();
        this.filmActorLista = new ArrayList();
        vista.addListenerNuevo(new FilmActorListener(this));
        vista.addListenerBtnModificar(new FilmActorListener(this));
        vista.addListenerCerrar(new FilmActorListener(this));
        vista.addListenerBtnConsultar(new FilmActorListener(this));
        vista.addListenerBtnAdicionar(new FilmActorListener(this));
        vista.addListenerBtnEliminar(new FilmActorListener(this));
        this.vista.activarControles(false);
        ArrayList<Film> lista;
        lista = modelo.getFilmDAO().listadoFilm();
        modeloFilm = new ListModelFilm(modelo, lista);
        vista.setModelo(modeloFilm);

        ArrayList<Actor> listadoActores;
        listadoActores = modelo.getActorDAO().listadoActores();
        vista.cargarActores(listadoActores);
    }

    public void listaFilm() {
        int selection = vista.getListaFilm().getSelectedIndex();
        if (selection != -1) {
            Film codigo = modeloFilm.getFilm(selection);
            Film film = this.modelo.getFilmDAO().buscarFilm(codigo.getFilmId());
            listFilmActor(film);
            adiccionarFilmActor(film);
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
            vista.getDetalleFilmActor().setModel(modeloActorFilm);
            vista.setModelo(modeloFilm);
            seleccionar(listaFilm.size() - 1);
        } else {
            modeloActorFilm.addElement(listaFilm);
            vista.getDetalleFilmActor().setModel(modeloActorFilm);
            vista.setModelo(modeloFilm);
            seleccionar(listaFilm.size() - 1);
        }
    }

    public void adiccionarFilmActor(Film film) {
        FilmActor filmActor = null;
        Actor actor = (Actor) vista.getCobActores().getSelectedItem();
        filmActor = new FilmActor(actor, film);
        filmActorLista.add(filmActor);

    }

    public void seleccionar(int seleccionado) {
        vista.getDetalleFilmActor().setSelectedIndex(seleccionado);
        vista.getDetalleFilmActor().ensureIndexIsVisible(seleccionado);
    }

    public void selecionarPelicula(int seleccionado) {
        vista.getListaFilm().setSelectedIndex(seleccionado);
        vista.getListaFilm().ensureIndexIsVisible(seleccionado);
    }

    public void refrescarLista() {
        vista.getDetalleFilmActor().setSelectedIndex(0);
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

    public void consultarFilmActor() {
        Actor actor = (Actor) vista.getCobActores().getSelectedItem();
        filmActorLista = modelo.getFilmActorDAO().listadoFilmActor(actor.getActorId());
        modeloFilmActor = new ListFilActorModelo(filmActorLista);
        vista.getDetalleFilmActor().setModel(modeloFilmActor);
        vista.modificarAction();
        vista.BtnEliminar();
    }

    public void guardarFilmActor() {
        if (listaFilm.size() > 0) {

            int resultado = 0;
            resultado = modelo.getFilmActorDAO().grabarFilmActor(filmActorLista);
            if (resultado == 1) {
                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                vista.activarControles(false);
                vista.nuevoAction();
                vista.getDetalleFilmActor().setModel(new ListModeloActorFilm());
                this.listaFilm.clear();
                this.filmActorLista.clear();
            } else {
                vista.gestionMensajes("Ya esta registrado el actor de la pelicula",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void modificarCity() {
        FilmActor filmActor = null;
        int resultado = 0;
        int selection = vista.getListaFilm().getSelectedIndex();
        int detalle = vista.getDetalleFilmActor().getSelectedIndex();
        if (selection != -1 && detalle != -1) {
            Actor actor = (Actor) vista.getCobActores().getSelectedItem();
            Film codigo = modeloFilm.getFilm(selection);
            FilmActor filmA = (FilmActor) modeloFilmActor.getElementAt(detalle);
            filmActor = new FilmActor(actor, codigo);
            resultado = modelo.getFilmActorDAO().modificarFilmActor(filmA, filmActor);
            if (resultado == 1) {
                vista.gestionMensajes(
                        "Actualización exitosa",
                        "Confirmación ",
                        JOptionPane.INFORMATION_MESSAGE);

                vista.activarControles(false);
                vista.nuevoAction();
                vista.limpiarCampos();
                consultarFilmActor();
                vista.setModelo(modeloFilm);
            } else {
                vista.gestionMensajes(
                        "Actualización Falida",
                        "Confirmación ",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            vista.gestionMensajes(
                    "Seleccione una pelicula",
                    "Confirmación ",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void borrarFilmActor() {
        int detalle = vista.getDetalleFilmActor().getSelectedIndex();
        System.out.println("Controlador.FilmActorController.borrarFilmActor()" + detalle);
        if (detalle == -1) {
            vista.gestionMensajes(
                    "Por favor seleccione Film actor",
                    "Mensaje de Advertencia ",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            FilmActor filmA = (FilmActor) modeloFilmActor.getElementAt(detalle);
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar la comuna de codigo : "
                    + filmA.getActor_id().getActorId() + "," + filmA.getFilm().getFilmId() + " ?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                int codigo = modelo.getFilmActorDAO().borrarFilmActor(filmA);
                if (codigo == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción",
                            JOptionPane.INFORMATION_MESSAGE);
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.limpiarCampos();
                    consultarFilmActor();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void nuevoAction() {
        vista.nuevoAction();
        vista.getDetalleFilmActor().setModel(new ListModeloActorFilm());
        this.listaFilm.clear();
        this.filmActorLista.clear();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
