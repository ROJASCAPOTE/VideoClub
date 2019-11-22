/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.FilmListener;
import Modelo.Customer;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import Modelo.Language;
import Vista.FrmFilm;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FilmController {

    private FrmFilm vista;
    private DAOManager modelo;

    public FilmController(FrmFilm vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addListenerNuevo(new FilmListener(this));
        this.vista.addListenerBtnModificar(new FilmListener(this));
        this.vista.addListenerBtnBuscar(new FilmListener(this));
        this.vista.activarControles(false);
        language();
        languageOrginal();
        codigoFilm();
    }

    public void codigoFilm() {
        int codigo = modelo.getFilmDAO().grtCodigo();
        vista.setTexIdFilm(codigo);
    }

    public void language() {
        ArrayList<Language> listadoLanguage;
        listadoLanguage = modelo.getLanguageDAO().listLanguage();
        this.vista.cargarLanguaje(listadoLanguage);
    }

    public void languageOrginal() {
        ArrayList<Language> listadoLanguage;
        listadoLanguage = modelo.getLanguageDAO().listOriginalLanguage();
        this.vista.cargarLanguageOriginal(listadoLanguage);
    }

    public void guardarFilm() {
        vista.salveDate();
        int resultado;
        resultado = modelo.getFilmDAO().grabarFilm(vista.getFilm());
        if (resultado == 1) {
            vista.gestionMensajes("Registro Grabado con éxito",
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void buscarFilm() {
        int codigo = 0;
        String customer_id = JOptionPane.showInputDialog(null, "Ingrese el codigo de la pelicula");
        try {
            codigo = Integer.parseInt(customer_id);
        } catch (NumberFormatException e) {
            codigo = 0;
        }

        if (codigo > 0) //        vista.getCmbStore().setSelectedIndex(codigo - 1);
        {
            Film film = modelo.getFilmDAO().getFilm(codigo);
            if (film != null) {
                vista.mostrarFilm(film);
                vista.modificarAction();
            } else {
                JOptionPane.showMessageDialog(null, "La pelicula no se encuentra registrado");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo de la pelicula");
        }
    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

}
