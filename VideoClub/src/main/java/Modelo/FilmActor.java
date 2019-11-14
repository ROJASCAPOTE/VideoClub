package Modelo;

import java.util.Date;

public class FilmActor {

    private Actor actor;
    private Film film;
    private Date lastUpdate;

    public FilmActor() {
    }

    public FilmActor(Actor actor, Film film, Date lastUpdate) {
        this.actor = actor;
        this.film = film;
        this.lastUpdate = lastUpdate;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
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
