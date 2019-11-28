/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dao.DAOManager;
import Modelo.Language;
import ModeloGUI.LanguageModelo;
import Vista.FrmLanguage;
import java.util.ArrayList;

/**
 *
 * @author ACER E5
 */
public class LanguageController {
    
    private FrmLanguage vista;
    private DAOManager modelo;
    private LanguageModelo languageModelo;
    
    public LanguageController(FrmLanguage vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ArrayList<Language> listaLanguage;
        listaLanguage = modelo.getLanguageDAO().listLanguage();
        languageModelo = new LanguageModelo(listaLanguage);
        vista.setModel(languageModelo);
    }
    
}
