/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloGUI;

import Modelo.FilmActor;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author ACER E5
 */
public class ModeloFilmActor extends AbstractListModel {

    private ArrayList<FilmActor> listFilmActor;

    public ModeloFilmActor(ArrayList<FilmActor> listFilmActor) {
        this.listFilmActor = listFilmActor;
    }

    @Override
    public int getSize() {
        return listFilmActor.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listFilmActor.get(index);
    }

    public void addElement(FilmActor f) {
        listFilmActor.add(f);
    }

    public void eliminar(int index) {
        listFilmActor.remove(index);
        this.fireIntervalRemoved(index, getSize(), getSize() + 1);
    }

    public void addElement(ArrayList<FilmActor> filmActors) {
        for (FilmActor filmActor : filmActors) {
            listFilmActor.add(filmActor);
        }
    }
}
