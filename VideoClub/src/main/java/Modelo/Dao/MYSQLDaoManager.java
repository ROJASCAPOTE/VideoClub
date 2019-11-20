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
    private LanguageDAO language;
    private ActorDAO actor;
    private CategoriaDAO categoria;
    private CustomerDAO customer;
    private FilmActorDAO filmActor;
    private FilmCategoryDAO filmCategory;
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

    @Override
    public LanguageDAO getLanguageDAO() {
        if (language == null) {
            language = new LanguageDAO(conn);
        }
        return language;
    }

    @Override
    public ActorDAO getActorDAO() {
        if (actor == null) {
            actor = new ActorDAO(conn);
        }
        return actor;
    }

    @Override
    public CategoriaDAO getCategoriaDAO() {
        if (categoria == null) {
            categoria = new CategoriaDAO(conn);
        }
        return categoria;
    }

    @Override
    public FilmActorDAO getFilmActorDAO() {
        if (filmActor == null) {
            filmActor = new FilmActorDAO(conn);
        }
        return filmActor;
    }

    @Override
    public FilmCategoryDAO getFilCategoryDAO() {
        if (filmCategory == null) {
            filmCategory = new FilmCategoryDAO(conn);
        }
        return filmCategory;
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        if (customer == null) {
            customer = new CustomerDAO(conn);
        }
        return customer;
    }

}
