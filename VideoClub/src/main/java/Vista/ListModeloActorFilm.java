package Vista;

import Modelo.Film;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class ListModeloActorFilm extends AbstractListModel {

    private ArrayList<Film> films;

    public ListModeloActorFilm() {
        films = new ArrayList();
    }

    @Override
    public int getSize() {
        return films.size();
    }

    @Override
    public Object getElementAt(int index) {
        return films.get(index);
    }

    public void addElement(ArrayList<Film> LisFilm) {
        for (Film film : LisFilm) {
            films.add(film);
        }
    }

    public void removeAllElements() {
        for (int i = 0; i < films.size(); i++) {
            films.remove(i);
        }
    }

}
