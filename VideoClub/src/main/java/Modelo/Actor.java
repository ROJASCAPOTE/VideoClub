package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Actor {

    private int actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
    private ArrayList<Film> filmActors;

    public Actor() {
        lastUpdate = new Date();
        this.actorId = 0;
        firstName = "";
        lastName = "";
    }

    public Actor(int actorId, String firstName, String lastName, Date lastUpdate, ArrayList<Film> filmActors) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
        this.filmActors = filmActors;
    }

    public Actor(String firstName, String lastName, Date lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public ArrayList<Film> getFilmActors() {
        return filmActors;
    }

    public void setFilmActors(ArrayList<Film> filmActors) {
        this.filmActors = filmActors;
    }

    @Override
    public String toString() {
        return actorId + " - " + firstName + "  " + lastName;
    }

}
