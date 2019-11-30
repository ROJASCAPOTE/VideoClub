/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.AddressListener;
import Modelo.Address;
import Modelo.City;
import Modelo.Dao.DAOManager;
import Vista.FrmAddess;
import Vista.FrmCustomer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class AddressController {

    private FrmAddess vista;
    private DAOManager modelo;
    private FrmCustomer customer;

    public AddressController(FrmAddess vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.addListenerNuevo(new AddressListener(this));
        vista.addListenerBtnModificar(new AddressListener(this));
        vista.addListenerBtnEliminar(new AddressListener(this));
        vista.addListenerCerrar(new AddressListener(this));
        this.vista.activarControles(false);
        ArrayList<City> listadoCity;
        listadoCity = modelo.getCityDAO().listadoCity();
        this.vista.cargarCity(listadoCity);
        codigoAddress();
    }

    public void setCustomer(FrmCustomer customer) {
        this.customer = customer;
    }

    public void codigoAddress() {
        int codigo = modelo.getAddressDAO().grtCodigo();
        vista.codigoAddress(codigo);
    }

    public void guardarAddress() {
        if (vista.getTexAddress().equals("")) {
            vista.gestionMensajes("Ingrese la direccion",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } else if (vista.getTexPhone().equals("")) {
            vista.gestionMensajes("Ingrese el numero de telefono",
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
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea crear la direccion      : "
                    + address.getAddress() + " ?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                int resultado = 0;
                resultado = modelo.getAddressDAO().grabarAddress(address);
                if (resultado == 1) {
                    vista.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.limpiarCampos();
                    codigoAddress();
                } else {
                    vista.gestionMensajes("Error al grabar",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
