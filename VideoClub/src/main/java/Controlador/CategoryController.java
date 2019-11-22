/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.CategoryListener;
import Modelo.Dao.DAOManager;
import Vista.FrmCategory;
import Vista.ListModeloActorFilm;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class CategoryController {

    private FrmCategory vista;
    private DAOManager modelo;
    private Object[][] dtCategory;

    public CategoryController(FrmCategory vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addListenerNuevo(new CategoryListener(this));
        this.vista.addListenerBtnModificar(new CategoryListener(this));
        this.vista.addListenerCerrar(new CategoryListener(this));
        this.vista.activarControles(false);
        dtCategory = modelo.getCategoriaDAO().getTableCategory();
        vista.tableCategory(dtCategory);
        codigoCategory();
    }

    public void codigoCategory() {
        int codigo = modelo.getCategoriaDAO().grtCodigo();
        vista.codigoCategory(codigo);
    }

    public void guardarCategory() {

        vista.salveDate();
        int resultado;
        resultado = modelo.getCategoriaDAO().grabarCategory(vista.getCategory());
        if (resultado == 1) {
            vista.gestionMensajes("Registro Grabado con éxito",
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
            codigoCategory();
            dtCategory = modelo.getCategoriaDAO().getTableCategory();
            vista.tableCategory(dtCategory);
        } else {
            vista.gestionMensajes("Error al grabar",
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
