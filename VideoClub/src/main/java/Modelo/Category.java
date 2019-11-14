package Modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Category {

    private Byte categoryId;
    private String name;
    private Date lastUpdate;
    private Map filmCategory;

    public Category() {
        filmCategory = null;
    }

    public Category(Byte categoryId, String name, Date lastUpdate) {
        this.categoryId = categoryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
        filmCategory = new HashMap();

    }

    public Byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Byte categoryId) {
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

    public Map getFilmCategory() {
        return filmCategory;
    }

    

    @Override
    public String toString() {
        return name;
    }

}
