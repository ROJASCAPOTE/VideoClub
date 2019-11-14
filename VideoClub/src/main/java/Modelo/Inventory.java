package Modelo;

import java.util.Date;

public class Inventory {

    private int inventoryId;
    private Film film;
    private Store store;
    private Date lastUpdate;

    public Inventory() {
    }

    public Inventory(int inventoryId, Film film, Store store, Date lastUpdate) {
        this.inventoryId = inventoryId;
        this.film = film;
        this.store = store;
        this.lastUpdate = lastUpdate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
