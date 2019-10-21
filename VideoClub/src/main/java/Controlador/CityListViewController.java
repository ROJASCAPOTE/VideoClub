package Controlador;

import Modelo.Dao.DAOManager;
import Vista.FrmCityView;

public class CityListViewController {

    private FrmCityView vista;
    private DAOManager modelo;

    public CityListViewController(FrmCityView vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
}
