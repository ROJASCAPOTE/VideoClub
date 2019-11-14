/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Address;
import Modelo.City;
import Modelo.Country;
import Modelo.Dao.DAOManager;
import Vista.FrmAddess;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class AddressController {

    private FrmAddess vista;
    private DAOManager modelo;

    public AddressController(FrmAddess vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;

        ArrayList<City> listadoCity;
        listadoCity = modelo.getCityDAO().listadoCity();
        this.vista.cargarCity(listadoCity);
    }

    public void guardarAddress() {
        if (vista.getTexAddress().equals("")) {
            vista.gestionMensajes("Ingrese el código",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } else {
            Address address = new Address();
            address.setAddressId(Integer.parseInt(vista.getTexIDaddress()));
            address.setAddress(vista.getTexAddress());
            address.setAddress2(vista.getTexAddress2());
            address.setDistrict(vista.getTexDistrict());
            City city = (City) vista.getComCity().getSelectedItem();
            address.setCity(city);
            address.setPostalCode(vista.getTexCodigoPostal());
            address.setPhone(vista.getTexPhone());
            address.setLastUpdate(vista.getTexLastUpdate());
            int resultado = 0;
            resultado = modelo.getAddressDAO().grabarAddress(address);
            if (resultado == 1) {

            }
        }
    }
}
