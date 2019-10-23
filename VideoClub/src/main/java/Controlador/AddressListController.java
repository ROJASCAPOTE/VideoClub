/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Event.Address.AddressMouseListener;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Vista.FrmListAddress;
import Vista.FrmStore;

/**
 *
 * @author ACER E5
 */
public class AddressListController {

    private FrmListAddress vista;
    private FrmStore vistaStore;
    private DAOManager manager;
    private Object[][] dtAddress;

    public AddressListController(FrmListAddress vista, DAOManager manager) {
        this.vista = vista;
        this.manager = manager;
        vista.addMouseListenerAddress(new AddressMouseListener(this));
        dtAddress = manager.getAddressDAO().getTableAddress();
        vista.tableAddress(dtAddress);
    }

    public void setVistaStore(FrmStore vistaStore) {
        this.vistaStore = vistaStore;
    }

    public void obtenerDatosDireccion() {
        int id = Integer.parseInt((String) vista.getTablaAddress().getValueAt(vista.getTablaAddress().getSelectedRow(), 0));
        Address address = manager.getAddressDAO().consultarDireccion(id);
        vistaStore.setAddress(address);
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }
}
