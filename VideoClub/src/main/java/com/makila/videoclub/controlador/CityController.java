package com.makila.videoclub.controlador;

import com.makila.videoclub.modelo.Country;
import com.makila.videoclub.modelo.DAO.DAOManager;
import com.makila.videoclub.vista.frmCity;
import java.util.ArrayList;

public class CityController {

    private frmCity vista;
    private DAOManager manager;
    private Object[][] dtCity;

    public CityController(frmCity vista, DAOManager manager) {
        this.vista = vista;
        this.manager = manager;

        ArrayList<Country> listadoMunicipios;
        listadoMunicipios = manager.getCountryDAO().listadoCountry();
        this.vista.cargarCountry(listadoMunicipios);

        dtCity = this.manager.getCityDAO().getTableCity();
        this.vista.tableCity(dtCity);
    }

}
