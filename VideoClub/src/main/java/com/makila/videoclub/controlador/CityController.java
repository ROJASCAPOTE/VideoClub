
package com.makila.videoclub.controlador;

import com.makila.videoclub.modelo.DAO.DAOManager;
import com.makila.videoclub.vista.frmCity;


public class CityController {
    private frmCity vista;
    private DAOManager manager;

    public CityController(frmCity vista, DAOManager manager) {
        this.vista = vista;
        this.manager = manager;
    }
    
}
