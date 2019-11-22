package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Category {

    private int categoryId;
    private String name;
    private Date lastUpdate;
    private ArrayList<Film> listFilm;

    public Category() {
        listFilm = new ArrayList();
        lastUpdate = new Date();
    }

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
        listFilm = new ArrayList();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public ArrayList<Film> getListFilm() {
        return listFilm;
    }

    public void setListFilm(ArrayList<Film> listFilm) {
        this.listFilm = listFilm;
    }

    @Override
    public String toString() {
        return name;
    }

}
