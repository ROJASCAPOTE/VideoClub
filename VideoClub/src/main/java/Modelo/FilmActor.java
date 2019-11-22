package Modelo;

import java.util.Date;

public class FilmActor {

    private Actor actor_id;
    private Film film;
    private Date lastUpdate;

    public FilmActor() {
        lastUpdate = new Date();
    }

    public FilmActor(Actor actor_id, Film film) {
        this.actor_id = actor_id;
        this.film = film;
    }

    public Actor getActor_id() {
        return actor_id;
    }

    public void setActor_id(Actor actor_id) {
        this.actor_id = actor_id;
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
        return actor_id.getActorId() + "   -   " + actor_id.getFirstName() + "  " + actor_id.getLastName() + "    |  " + film.toString();
    }

}
