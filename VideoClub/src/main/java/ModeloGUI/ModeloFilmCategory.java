/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloGUI;

import Modelo.FilmCategory;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author ACER E5
 */
public class ModeloFilmCategory extends AbstractListModel {

    private ArrayList<FilmCategory> listCategory;

    public ModeloFilmCategory(ArrayList<FilmCategory> listCategory) {
        this.listCategory = listCategory;
    }

    @Override
    public int getSize() {
        return listCategory.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listCategory.get(index);
    }

    public void addElement(FilmCategory f) {
        listCategory.add(f);
    }

    public void eliminar(int index) {
        listCategory.remove(index);
        this.fireIntervalRemoved(index, getSize(), getSize() + 1);
    }

    public void addElement(ArrayList<FilmCategory> filmCategorys) {
        for (FilmCategory category : filmCategorys) {
            listCategory.add(category);
        }
    }

}
