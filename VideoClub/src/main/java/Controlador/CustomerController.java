/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Store;
import Vista.FrmCustomer;
import java.util.ArrayList;

/**
 *
 * @author ACER E5
 */
public class CustomerController {
    private FrmCustomer vista;
    private DAOManager modelo;

    public CustomerController(FrmCustomer vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        ArrayList<Store> listaTiendas;
        

        listaTiendas = modelo.getStoreDAO().listadoStore();
        vista.cargarStore(listaTiendas);
        
        ArrayList<Address> listadoDirecciones;
        listadoDirecciones = modelo.getAddressDAO().listadoAddress();
        vista.cargarDireccioneCustomer(listadoDirecciones);
    }
    
}
