/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Dao.DAOManager;
import Modelo.FilmActor;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author ACER E5
 */
public class ListFilActorModelo extends AbstractListModel {

    private ArrayList<FilmActor> lista;
    private DAOManager modelo;

    public ListFilActorModelo(ArrayList<FilmActor> lista) {
        this.lista = lista;
    }
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lista.get(index);
    }

    public void addElement(FilmActor f) {
        lista.add(f);
    }
    

    public void addElement(ArrayList<FilmActor> filmActors) {
        for (FilmActor film : filmActors) {
            lista.add(film);
        }
    }

}
