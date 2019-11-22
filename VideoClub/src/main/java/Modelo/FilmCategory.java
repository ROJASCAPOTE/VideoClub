package Modelo;

import java.util.Date;

public class FilmCategory {

    private int category_id;
    private Film film;
    private Date lastUpdate;

    public FilmCategory() {
        lastUpdate = new Date();
    }

    public FilmCategory(int category_id, Film film) {
        this.category_id = category_id;
        this.film = film;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
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

}
