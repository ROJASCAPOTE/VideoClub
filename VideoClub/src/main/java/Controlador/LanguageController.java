/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.LanguageListener;
import Eventos.LanguageMouseListener;
import Modelo.Dao.DAOManager;
import Modelo.Language;
import ModeloGUI.LanguageModelo;
import Vista.FrmLanguage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER E5
 */
public class LanguageController {
    
    private FrmLanguage vista;
    private DAOManager modelo;
    private LanguageModelo languageModelo;
    private TableRowSorter trsfiltro;
    String filtro;
    
    public LanguageController(FrmLanguage vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ArrayList<Language> listaLanguage;
        listaLanguage = modelo.getLanguageDAO().listLanguage();
        languageModelo = new LanguageModelo(listaLanguage);
        vista.addMouseListenerLanguage(new LanguageMouseListener(this));
        vista.addListenerBtnBorrar(new LanguageListener(this));
        vista.addListenerBtnModificar(new LanguageListener(this));
        vista.addListenerNuevo(new LanguageListener(this));
        vista.addListenerCerrar(new LanguageListener(this));
        this.vista.activarControles(false);
        vista.setModel(languageModelo);
        codigoLanguage();
    }
    
    public void codigoLanguage() {
        int codigo = modelo.getLanguageDAO().grtCodigo();
        vista.codigoLanguage(codigo);
    }
    
    public void seleccionarLanguage() {
        LanguageModelo mtc = (LanguageModelo) vista.getTablaLanguage().getModel();
        Language language = mtc.getLanguage(vista.getTablaLanguage().getSelectedRow());
        vista.cargarDatosLanguage(language);
        vista.modificarAction();
    }
    
    public void nuevoAction() {
        vista.nuevoAction();
    }
    
}
