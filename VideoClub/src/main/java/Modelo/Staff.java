package Modelo;

import java.util.Date;

public class Staff {

    private int staff_id;
    private String first_name;
    private String last_name;
    private int addressId;
    private byte[] picture;
    private String email;
    private int store_id;
    private boolean active;
    private String username;
    private String password;
    private Date last_update;

    public Staff() {
    }

    public Staff(int staff_id, String first_name, String last_name, int addressId, byte[] picture, String email, int store_id, boolean active, String username, String password, Date last_update) {
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.addressId = addressId;
        this.picture = picture;
        this.email = email;
        this.store_id = store_id;
        this.active = active;
        this.username = username;
        this.password = password;
        this.last_update = last_update;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

   

}
