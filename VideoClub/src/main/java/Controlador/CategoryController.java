/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.CategoryListener;
import Eventos.CategoryMouseListener;
import Modelo.Actor;
import Modelo.Category;
import Modelo.Dao.DAOManager;
import Vista.FrmCategory;
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
        this.vista.addMouseListenerCategory(new CategoryMouseListener(this));
        this.vista.addListenerBtnEliminarCategory(new CategoryListener(this));
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

        vista.salveData();
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

    public void actualizarCategory() {
        vista.salveData();
        if (modelo.getCategoriaDAO().modificarCategory(vista.getCategory()) == 1) {
            vista.gestionMensajes(
                    "Actualización exitosa",
                    "Confirmación ",
                    JOptionPane.INFORMATION_MESSAGE);

            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
            dtCategory = modelo.getCategoriaDAO().getTableCategory();
            vista.tableCategory(dtCategory);
            codigoCategory();
        } else {
            vista.gestionMensajes(
                    "Actualización Falida",
                    "Confirmación ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void borrarCategory() {
        int codigo = 0;
        vista.salveData();
        codigo = vista.getCategory().getCategoryId();
        if (codigo == 0) {
            vista.gestionMensajes(
                    "Por favor seleccione un programa de la tabla",
                    "Mensaje de Advertencia ",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar la comuna de codigo : "
                    + codigo + " ?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                if (modelo.getCategoriaDAO().borrarCategory(codigo) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción",
                            JOptionPane.INFORMATION_MESSAGE);
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.limpiarCampos();
                    dtCategory = modelo.getCategoriaDAO().getTableCategory();
                    vista.tableCategory(dtCategory);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void seleccionarCategory() {
        int category_id = Integer.parseInt((String) vista.getTablaCategory().getValueAt(vista.getTablaCategory().getSelectedRow(), 0));
        Category category = modelo.getCategoriaDAO().consultarCategory(category_id);
        vista.cargarDatosCategory(category);
        vista.modificarAction();
    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
