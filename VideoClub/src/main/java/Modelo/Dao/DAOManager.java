/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

/**
 *
 * @author ACER E5
 */
public interface DAOManager {

    CityDAO getCityDAO();

    CountryDAO getCountryDAO();

    AddressDAO getAddressDAO();

    StoreDAO getStoreDAO();

    StaffDAO getStaffDAO();

    FilmDAO getFilmDAO();

    LanguageDAO getLanguageDAO();

    ActorDAO getActorDAO();

    CategoriaDAO getCategoriaDAO();
}
