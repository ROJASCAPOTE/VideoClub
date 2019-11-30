/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.AddressMouseListener;
import Eventos.StoreEventoTeclado;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Vista.FrmCustomer;
import Vista.FrmListAddress;
import Vista.FrmStaff;
import Vista.FrmStore;

/**
 *
 * @author ACER E5
 */
public class AddressListController {

    private FrmListAddress vista;
    private FrmStore vistaStore;
    private FrmStore vistaAddresManager;
    private FrmCustomer customer;
    private FrmStaff frmStaff;
    private DAOManager manager;
    private Object[][] dtAddress;

    public AddressListController(FrmListAddress vista, DAOManager manager) {
        this.vista = vista;
        this.manager = manager;
        vista.addMouseListenerAddress(new AddressMouseListener(this));
        vista.addaddKeyListener(new StoreEventoTeclado(this));
        dtAddress = manager.getAddressDAO().getTableAddress("");
        vista.tableAddress(dtAddress);
    }

    public FrmStore getVistaStore() {
        return vistaStore;
    }

    public void setVistaStore(FrmStore vistaStore) {
        this.vistaStore = vistaStore;
    }

    public FrmCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(FrmCustomer customer) {
        this.customer = customer;
    }

    public FrmStore getVistaAddresManager() {
        return vistaAddresManager;
    }

    public void setVistaAddresManager(FrmStore vistaAddresManager) {
        this.vistaAddresManager = vistaAddresManager;
    }

    public FrmStaff getFrmStaff() {
        return frmStaff;
    }

    public void setFrmStaff(FrmStaff frmStaff) {
        this.frmStaff = frmStaff;
    }

    public void seleccionarVista() {
        if (getVistaStore() != null) {
            obtenerDatosDireccion();
            vistaStore = null;
        } else if (getCustomer() != null) {
            int codigo = Integer.parseInt((String) vista.getTablaAddress().getValueAt(vista.getTablaAddress().getSelectedRow(), 0));
            Address address = manager.getAddressDAO().consultarDireccion(codigo);
            getCustomer().setAddresCustomer(address);
        } else if (getVistaAddresManager() != null) {
            obtenerDatosDireccionManager();
            vistaAddresManager = null;
        } else if (getFrmStaff() != null) {
            int codigo = Integer.parseInt((String) vista.getTablaAddress().getValueAt(vista.getTablaAddress().getSelectedRow(), 0));
            Address address = manager.getAddressDAO().consultarDireccion(codigo);
            getFrmStaff().setAddressStaff(address);
        }
    }

    public void obtenerDatosDireccion() {
        int id = Integer.parseInt((String) vista.getTablaAddress().getValueAt(vista.getTablaAddress().getSelectedRow(), 0));
        Address address = manager.getAddressDAO().consultarDireccion(id);
        vistaStore.AddressStore(address);
    }

    public void obtenerDatosDireccionManager() {
        int id = Integer.parseInt((String) vista.getTablaAddress().getValueAt(vista.getTablaAddress().getSelectedRow(), 0));
        Address address = manager.getAddressDAO().consultarDireccion(id);
        vistaAddresManager.addressMnager(address);
    }

    public void buscarAddress() {
        if (!vista.getTextBuscarAddress().equals("")) {
            dtAddress = manager.getAddressDAO().getTableAddress(vista.getTextBuscarAddress());
            vista.tableAddress(dtAddress);
        } else {
            dtAddress = manager.getAddressDAO().getTableAddress("");
            vista.tableAddress(dtAddress);
        }
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }
}
