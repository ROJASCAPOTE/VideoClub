/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makila.videoclub.modelo.DAO;

/**
 *
 * @author ACER E5
 */
public class MYSQLManager implements DAOManager {

    private CityDAO city;
    private CountryDAO country;

    @Override
    public CityDAO getCityDAO() {
        if (city == null) {
            city = new CityDAO();
        }
        return city;
    }

    @Override
    public CountryDAO getCountryDAO() {
        if (country == null) {
            country = new CountryDAO();
        }
        return country;
    }

}
