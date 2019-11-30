/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.InventoryListener;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import Modelo.Store;
import ModeloGUI.FilmTableModel;
import Vista.FrmInventory;
import Vista.FrmListFilm;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class InventoryController {

    private FrmInventory vista;
    private FrmListFilm frmListFilm;
    private DAOManager modelo;
    private Object[][] dtInventary;

    public InventoryController(FrmInventory vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addListenerNuevo(new InventoryListener(this));
        this.vista.addListenerBtnModificar(new InventoryListener(this));
        this.vista.addListenerBtnBorrar(new InventoryListener(this));
        this.vista.addListenerCerrar(new InventoryListener(this));
        this.vista.activarControles(false);
        ArrayList<Store> listaTiendas;
        listaTiendas = modelo.getStoreDAO().listadoStore();
        vista.cargarTiendas(listaTiendas);
        codigoInventory();
    }

    public void codigoInventory() {
        int codigo = modelo.getInventoryDAO().grtCodigo();
        vista.codigoActor(codigo);
    }

    public FrmListFilm getFrmListFilm() {
        return frmListFilm;
    }

    public void setFrmListFilm(FrmListFilm frmListFilm) {
        this.frmListFilm = frmListFilm;
    }

    public void cargarFilmInventory() {
        FilmTableModel mtc = (FilmTableModel) frmListFilm.getTableListFilm().getModel();
        Film film = mtc.getFilm(frmListFilm.getTableListFilm().getSelectedRow());
        vista.cargarDatosFilm(film);
    }

    public void guardarInventario() {
        vista.salveData();

        if (vista.getInventory().getInventoryId() == 0) {
            vista.gestionMensajes("Ingrese el código",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);

        } else {

            int resultado = 0;
            resultado = modelo.getInventoryDAO().grabarInventory(vista.getInventory());
            if (resultado == 1) {
                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                vista.activarControles(false);
                vista.nuevoAction();
                vista.limpiarCampos();
                codigoInventory();
            } else {
                vista.gestionMensajes("Error al grabar",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void nuevoAction() {
        vista.nuevoAction();
        codigoInventory();

    }

    
    public void cerrarAction() {
        vista.cerrarAction();
    }

}
