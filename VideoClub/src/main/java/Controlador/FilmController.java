/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dao.DAOManager;
import Modelo.Language;
import Vista.FrmFilm;
import java.util.ArrayList;

public class FilmController {

    private FrmFilm vista;
    private DAOManager modelo;

    public FilmController(FrmFilm vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        language();
        languageOrginal();
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

}
