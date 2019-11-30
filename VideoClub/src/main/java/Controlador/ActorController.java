/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.ActorListener;
import Eventos.ActorMouseListener;
import Modelo.Actor;
import Modelo.Dao.DAOManager;
import Vista.FrmActor;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class ActorController {

    private FrmActor vista;
    private DAOManager modelo;
    private Object[][] dtActores;

    public ActorController(FrmActor vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addListenerNuevo(new ActorListener(this));
        this.vista.addListenerBtnModificar(new ActorListener(this));
        this.vista.addListenerCerrar(new ActorListener(this));
        vista.addMouseListenerActor(new ActorMouseListener(this));
        this.vista.addListenerBtnBorrar(new ActorListener(this));
        this.vista.addaddKeyListener(new ActorListener(this));
        this.vista.activarControles(false);
        dtActores = modelo.getActorDAO().getTableActor();
        vista.tableActores(dtActores);
        codigoActor();
    }

    public void codigoActor() {
        int codigo = modelo.getActorDAO().grtCodigo();
        vista.codigoActor(codigo);
    }

    public void guardarActor() {
        vista.salveData();
        int resultado = 0;
        resultado = modelo.getActorDAO().grabarActor(vista.getActor());
        if (resultado == 1) {
            vista.gestionMensajes("Registro Grabado con éxito",
                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            dtActores = modelo.getActorDAO().getTableActor();
            vista.tableActores(dtActores);
            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
            dtActores = modelo.getActorDAO().getTableActor();
            vista.tableActores(dtActores);
            codigoActor();
        } else {
            vista.gestionMensajes("Error al grabar",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void actualizarActor() {
        vista.salveData();

        if (modelo.getActorDAO().modificarActor(vista.getActor()) == 1) {
            vista.gestionMensajes(
                    "Actualización exitosa",
                    "Confirmación ",
                    JOptionPane.INFORMATION_MESSAGE);

            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
            dtActores = modelo.getActorDAO().getTableActor();
            vista.tableActores(dtActores);
            codigoActor();
        } else {
            vista.gestionMensajes(
                    "Actualización Falida",
                    "Confirmación ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void borrarActor() {
        int codigo = 0;
        vista.salveData();
        codigo = vista.getActor().getActorId();

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

                if (modelo.getActorDAO().borrarActor(codigo) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción",
                            JOptionPane.INFORMATION_MESSAGE);
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.limpiarCampos();
                    dtActores = modelo.getActorDAO().getTableActor();
                    vista.tableActores(dtActores);
                    codigoActor();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void buscarActor() {

        if (!vista.getTexBuscarActor().equals("")) {
            this.dtActores = modelo.getActorDAO().getTableActores(vista.getTexBuscarActor());
            this.vista.tableActores(dtActores);
        } else {
            this.dtActores = modelo.getActorDAO().getTableActores("");
            this.vista.tableActores(dtActores);
        }
    }

    public void seleccionarActor() {
        int actor_id = Integer.parseInt((String) vista.getTablaActores().getValueAt(vista.getTablaActores().getSelectedRow(), 0));
        Actor actor = modelo.getActorDAO().consultarActor(actor_id);
        vista.cargarDatosActor(actor);
        vista.modificarAction();

    }

    public void nuevoAction() {
        vista.nuevoAction();
        codigoActor();
        dtActores = modelo.getActorDAO().getTableActor();
        vista.tableActores(dtActores);
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
