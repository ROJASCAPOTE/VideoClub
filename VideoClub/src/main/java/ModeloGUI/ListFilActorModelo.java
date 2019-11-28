/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloGUI;

import Modelo.Actor;
import Modelo.Dao.DAOManager;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author ACER E5
 */
public class ListFilActorModelo extends AbstractListModel {

    private ArrayList<Actor> lista;
    private DAOManager modelo;

    public ListFilActorModelo(ArrayList<Actor> lista) {
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

    public void addElement(Actor f) {
        lista.add(f);
    }

    public void addElement(ArrayList<Actor> actors) {
        for (Actor film : actors) {
            lista.add(film);
        }
    }

}
