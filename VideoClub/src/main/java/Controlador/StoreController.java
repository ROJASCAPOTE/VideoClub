package Controlador;

import Modelo.Dao.DAOManager;
import Modelo.Staff;
import Modelo.Store;
import Vista.FrmStore;

public class StoreController {

    private FrmStore vista;
    private DAOManager modelo;

    public StoreController(FrmStore vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void registrarTienda() {
        Store store = new Store();
        Staff staff = new Staff();
        
    }
}
