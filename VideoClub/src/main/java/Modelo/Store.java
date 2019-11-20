package Modelo;

import java.util.Date;

public class Store {

    private int store_id;
    private Staff manager_staff;
    private Address address_id;
    private Date last_update;
    private int manager_id;
    private int codigo_address;

    public Store() {
        this.store_id = 0;
        this.manager_staff = null;
        this.address_id = null;
        this.last_update = new Date();
    }

    public Store(int store_id, Staff manager_staff, Address address_id, Date last_update) {
        this.store_id = store_id;
        this.manager_staff = manager_staff;
        this.address_id = address_id;
        this.last_update = last_update;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public Staff getManager_staff() {
        return manager_staff;
    }

    public void setManager_staff(Staff manager_staff) {
        this.manager_staff = manager_staff;
    }

    public Address getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Address address_id) {
        this.address_id = address_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getCodigo_address() {
        return codigo_address;
    }

    public void setCodigo_address(int codigo_address) {
        this.codigo_address = codigo_address;
    }

    @Override
    public String toString() {
        return getStore_id() + "";
    }

}
