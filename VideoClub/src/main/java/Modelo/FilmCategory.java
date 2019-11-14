package Modelo;

import java.util.Date;

public class FilmCategory {

    private int id;
    private Category category;
    private Film film;
    private Date lastUpdate;

    public FilmCategory() {
    }

    public FilmCategory(int id, Category category, Film film, Date lastUpdate) {
        this.id = id;
        this.category = category;
        this.film = film;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
