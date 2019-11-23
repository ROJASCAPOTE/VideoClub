/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.StaffListener;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Staff;
import Modelo.Store;
import Vista.FrmStaff;
import Vista.FrmStore;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class StaffController {

    private FrmStaff vista;
    private FrmStore frmStore;
    private DAOManager modelo;

    public StaffController() {
    }

    public StaffController(FrmStaff vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.addListenerNuevo(new StaffListener(this));
        vista.addListenerBtnModificar(new StaffListener(this));
        vista.addListenerBtnBorrar(new StaffListener(this));

        ArrayList<Address> listadoDirecciones;
        ArrayList<Store> listaTiendas;
        listadoDirecciones = modelo.getAddressDAO().listadoAddress();
        this.vista.cargarDirecciones(listadoDirecciones);

        listaTiendas = modelo.getStoreDAO().listadoStore();
        vista.cargarTiendas(listaTiendas);
        vista.codigoStaff(false);
        vista.activarControles(false);
        vista.setRdbSi(true);
        getCodigoStaff();
    }

    public void getCodigoStaff() {
        int codigo = modelo.getStaffDAO().getCodigo();
        vista.setTexCodigoStaff(codigo + "");
    }

    public void guardarStaff() {
        Staff staff = new Staff();
        Address address = null;
        Store store = null;
        boolean active = false;
        int staff_id;
        if (vista.getTexCodigoStaff().equals("")) {
            vista.gestionMensajes("Ingrese el código",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } else {
            int codigo = Integer.parseInt(vista.getTexCodigoStaff());
            staff.setStaff_id(codigo);
            staff.setFirst_name(vista.getTextFirstName());
            staff.setLast_name(vista.getTexLastName());
            address = (Address) vista.getCombAddress().getSelectedItem();
            staff.setAddressId(address.getAddressId());
            staff.setEmail(vista.getTexEmail());
            store = (Store) vista.getCmbStore().getSelectedItem();
            staff.setStore_id(store.getStore_id());
            staff.setUsername(vista.getTexUserName());
            staff.setPassword(vista.getTexPassword());
            if (vista.getRdbSi()) {
                active = true;
            }
            staff.setActive(active);
            int resultado = 0;
            resultado = modelo.getStaffDAO().grabarStaff(staff);
            if (resultado == 1) {
                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                vista.activarControles(false);
                vista.nuevoAction();
                getCodigoStaff();
                vista.limpiarCampos();
            } else {
                vista.gestionMensajes("Error al grabar",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void modificarStaff() {
        Staff staff = new Staff();
        Address address = null;
        Store store = null;
        int staff_id;
        int codigo = Integer.parseInt(vista.getTexCodigoStaff());
        staff.setStaff_id(codigo);
        staff.setFirst_name(vista.getTextFirstName());
        staff.setLast_name(vista.getTexLastName());
        address = (Address) vista.getCombAddress().getSelectedItem();
        staff.setAddressId(address.getAddressId());
        staff.setEmail(vista.getTexEmail());
        store = (Store) vista.getCmbStore().getSelectedItem();
        staff.setStore_id(store.getStore_id());
        staff.setUsername(vista.getTexUserName());
        staff.setPassword(vista.getTexPassword());
        if (modelo.getStaffDAO().actualizarEmpleado(staff) == 1) {
            vista.gestionMensajes(
                    "Actualización exitosa",
                    "Confirmación ",
                    JOptionPane.INFORMATION_MESSAGE);

            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
            getCodigoStaff();
        } else {
            vista.gestionMensajes(
                    "Actualización Falida",
                    "Confirmación ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registrarManager() {

    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    public FrmStaff getVista() {
        return vista;
    }

    public void setVista(FrmStaff vista) {
        this.vista = vista;
    }

    public FrmStore getFrmStore() {
        return frmStore;
    }

    public void setFrmStore(FrmStore frmStore) {
        this.frmStore = frmStore;
    }

    public DAOManager getModelo() {
        return modelo;
    }

    public void setModelo(DAOManager modelo) {
        this.modelo = modelo;
    }

}
