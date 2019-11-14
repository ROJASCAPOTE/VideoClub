/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Servisios.ConnectionBD;

/**
 *
 * @author ACER E5
 */
public class MYSQLDaoManager implements DAOManager {

    private CityDAO city;
    private CountryDAO country;
    private AddressDAO address;
    private StoreDAO store;
    private StaffDAO staff;
    private FilmDAO film;
    private ConnectionBD conn = null;

    public MYSQLDaoManager(ConnectionBD conn) {
        this.conn = conn;
    }

    @Override
    public CityDAO getCityDAO() {
        if (city == null) {
            city = new CityDAO(conn);
        }
        return city;
    }

    @Override
    public CountryDAO getCountryDAO() {
        if (country == null) {
            country = new CountryDAO(conn);
        }
        return country;
    }

    @Override
    public AddressDAO getAddressDAO() {
        if (address == null) {
            address = new AddressDAO(conn);
        }
        return address;
    }

    @Override
    public StoreDAO getStoreDAO() {
        if (store == null) {
            store = new StoreDAO(conn);
        }
        return store;
    }

    @Override
    public StaffDAO getStaffDAO() {
        if (staff == null) {
            staff = new StaffDAO(conn);
        }
        return staff;
    }

    @Override
    public FilmDAO getFilmDAO() {
        if (film == null) {
            film = new FilmDAO(conn);
        }
        return film;
    }

}
