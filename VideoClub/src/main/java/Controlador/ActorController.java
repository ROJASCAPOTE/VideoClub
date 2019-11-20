/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.ActorListener;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import Vista.FrmActor;
import Vista.ListModelFilm;
import Vista.ListModeloActorFilm;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class ActorController {

    private FrmActor vista;
    private DAOManager modelo;
    private ArrayList<Film> listaFilm;
    private ListModeloActorFilm modeloActorFilm;
    private ListModelFilm modeloFilm;
    private DefaultListModel model;

    ;

    public ActorController(FrmActor vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.listaFilm = new ArrayList();
        this.vista.addListenerNuevo(new ActorListener(this));
        this.vista.addListenerBtnModificar(new ActorListener(this));
        this.vista.addListenerCerrar(new ActorListener(this));
        this.vista.addListenerAdicionar(new ActorListener(this));
        this.vista.activarControles(false);
        ArrayList<Film> lista;
        lista = modelo.getFilmDAO().listadoFilm();
        modeloFilm = new ListModelFilm(modelo, lista);
        vista.setModelo(modeloFilm);
        getActorId();
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

    public void getActorId() {
        int codigo = modelo.getActorDAO().grtCodigo();
        vista.getActorId(codigo);
    }

    public void guardarActor() {
        if (listaFilm.size() > 0) {
            vista.salveData();
            vista.getActor().setFilmActors(listaFilm);
            int resultado;
            resultado = modelo.getActorDAO().grabarActor(vista.getActor());
            if (resultado != 1) {
                vista.gestionMensajes("Error al grabar",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
                vista.activarControles(false);
                vista.nuevoAction();
            } else {
                int resultadoFilmActor = modelo.getFilmActorDAO().grabarFilmActor(vista.getActor().getActorId(), listaFilm);
                if (resultadoFilmActor == 1) {
                    vista.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.limpiarCampos();
                    getActorId();
                    vista.setModelo(modeloFilm);
                    vista.getDetalleFilmActor().setModel(new ListModeloActorFilm());
                    listaFilm.clear();
                }

            }
        } else {
            vista.gestionMensajes("Sellecione una pelicula",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
