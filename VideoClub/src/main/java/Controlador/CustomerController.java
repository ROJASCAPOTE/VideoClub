/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
        this.vista.addListenerBtnEliminar(new CustomerListener(this));
        ArrayList<Store> listaTiendas;
        listaTiendas = modelo.getStoreDAO().listadoStore();
        vista.cargarStore(listaTiendas);

//        ArrayList<Address> listadoDirecciones;
//        listadoDirecciones = modelo.getAddressDAO().listadoAddress();

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
        if (vista.getCustomer().getCustomerId() == 0) {
            vista.gestionMensajes("Ingrese el código",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);

        } else {

            int resultado = 0;
            resultado = modelo.getCustomerDAO().grabarCustomer(vista.getCustomer());
            if (resultado == 1) {
                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                vista.activarControles(false);
                vista.nuevoAction();
                vista.limpiarCampos();
                customerId();
            } else {
                vista.gestionMensajes("Error al grabar",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void modificarCustomer() {
        vista.salveData();
        int resultado = 0;
        resultado = modelo.getCustomerDAO().modificarCustomer(vista.getCustomer());
        if (resultado == 1) {
            vista.gestionMensajes(
                    "Actualización exitosa",
                    "Confirmación ",
                    JOptionPane.INFORMATION_MESSAGE);

            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
            customerId();
        } else {
            vista.gestionMensajes(
                    "Actualización Falida",
                    "Confirmación ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarCustomer() {
        int codigo = 0;
        vista.salveData();
        if (vista.getCustomer().getCustomerId() == 0) {
            vista.gestionMensajes(
                    "Ingrese el codigo del customer",
                    "Mensaje de Advertencia ",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar el cliente  de codigo : "
                    + codigo + " ?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                codigo = modelo.getCustomerDAO().borrarCustomer(vista.getCustomer().getCustomerId());
                if (codigo == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción",
                            JOptionPane.INFORMATION_MESSAGE);
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.limpiarCampos();
                    customerId();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void nuevoAction() {
        vista.nuevoAction();
        customerId();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
