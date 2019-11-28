package Modelo;

import java.util.Date;

public class FilmCategory {

    private Category category_id;
    private Film film;
    private Date lastUpdate;

    public FilmCategory() {
        category_id = null;
        film = null;
        lastUpdate = new Date();
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return category_id.getCategoryId() + "   -   " + category_id.getName() + "  |  " + film.toString();
    }

}
