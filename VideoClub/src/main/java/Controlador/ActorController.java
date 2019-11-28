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
            codigoActor();
        } else {
            vista.gestionMensajes("Error al grabar",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
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
