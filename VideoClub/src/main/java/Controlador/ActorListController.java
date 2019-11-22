/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.ActorListMouseListener;
import Eventos.ActorTecladoListener;
import Modelo.Actor;
import Modelo.Dao.DAOManager;
import Modelo.FilmActor;
import Vista.FrmFilmActor;
import Vista.FrmListActores;
import Vista.ListFilActorModelo;
import Vista.ListModeloActorFilm;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class ActorListController {

    private FrmListActores vista;
    private FrmFilmActor filmActor;
    private DAOManager modelo;
    private Object[][] dtActores;
    private ListModeloActorFilm modeloActorFilm;

    public ActorListController(FrmListActores vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.addaddKeyListener(new ActorTecladoListener(this));
        vista.addMouseListenerActor(new ActorListMouseListener(this));
        dtActores = modelo.getActorDAO().getTableActores("");
        vista.tableActores(dtActores);
    }

    public void setFilmActor(FrmFilmActor filmActor) {
        this.filmActor = filmActor;
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
        DefaultComboBoxModel modeloActor;
        modeloActor = (DefaultComboBoxModel) filmActor.getCobActores().getModel();
        int actor_id = Integer.parseInt((String) vista.getTablaActores().getValueAt(vista.getTablaActores().getSelectedRow(), 0));
        Actor actor = modelo.getActorDAO().consultarActor(actor_id);
        modeloActor.setSelectedItem(actor);
        filmActor.modificarAction();

    }

   

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
