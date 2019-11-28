package ModeloGUI;

import Modelo.Film;
import Modelo.Language;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CatalogoPeliculaTablaModelo extends AbstractTableModel {
//film_id, title, release_year, language_id, original_language_id, rental_duration, rental_rate, length, rating

    private final Object[] columnas = {"Film Id", "Title", "Release year", "Rental Duration", "Rental Rate", "length", "rating"};
    private ArrayList<Film> listaPeliculas;

    public CatalogoPeliculaTablaModelo(ArrayList<Film> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    @Override
    public int getRowCount() {
        return listaPeliculas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column].toString();
    }

    public Film getFilm(int item) {
        return listaPeliculas.get(item);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaPeliculas.get(rowIndex).getFilmId();
            case 1:
                return listaPeliculas.get(rowIndex).getTitle();
            case 2:
                return listaPeliculas.get(rowIndex).getReleaseYear();
            case 3:
                return listaPeliculas.get(rowIndex).getRentalDuration();
            case 4:
                return listaPeliculas.get(rowIndex).getRentalRate();
            case 5:
                return listaPeliculas.get(rowIndex).getLength();
            case 6:
                return listaPeliculas.get(rowIndex).getRating();

            default:
                return null;
        }
    }

}
