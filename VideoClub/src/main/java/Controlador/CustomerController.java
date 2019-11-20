/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.CountryListener;
import Eventos.CustomerListener;
import Modelo.Address;
import Modelo.Customer;
import Modelo.Dao.DAOManager;
import Modelo.Store;
import Vista.FrmCustomer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

        this.vista.addListenerNuevo(new CustomerListener(this));
        this.vista.addListenerBtnModificar(new CustomerListener(this));
        this.vista.addListenerCerrar(new CustomerListener(this));
        this.vista.addListenerBtnBuscar(new CustomerListener(this));
        ArrayList<Store> listaTiendas;
        listaTiendas = modelo.getStoreDAO().listadoStore();
        vista.cargarStore(listaTiendas);

        ArrayList<Address> listadoDirecciones;
        listadoDirecciones = modelo.getAddressDAO().listadoAddress();
        vista.cargarDireccioneCustomer(listadoDirecciones);

        this.vista.activarControles(false);
        customerId();
    }

    public void customerId() {
        int codigo = modelo.getCustomerDAO().grtCodigo();
        vista.customerId(codigo);
    }

    public void buscarCustomer() {
        int codigo = 0;
        String customer_id = JOptionPane.showInputDialog(null, "Ingrese el codigo del cliente");
        try {
            codigo = Integer.parseInt(customer_id);
        } catch (NumberFormatException e) {
            codigo = 0;
        }

        if (codigo > 0) //        vista.getCmbStore().setSelectedIndex(codigo - 1);
        {
            Customer customer = modelo.getCustomerDAO().getCustomer(codigo);
            if (customer != null) {
                vista.mostrarCustomer(customer);
                vista.modificarAction();
            } else {
                JOptionPane.showMessageDialog(null, "El cliente no se encuentra registrado");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del cliente");
        }
    }

    public void guardarCustomer() {
        vista.salveData();
    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
