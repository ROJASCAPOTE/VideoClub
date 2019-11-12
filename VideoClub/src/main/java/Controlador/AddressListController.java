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
import Vista.FrmListAddress;
import Vista.FrmStore;
import javax.swing.DefaultComboBoxModel;

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
        vista.addaddKeyListener(new StoreEventoTeclado(this));
        dtAddress = manager.getAddressDAO().getTableAddress("");
        vista.tableAddress(dtAddress);
    }

    public void setVistaStore(FrmStore vistaStore) {
        this.vistaStore = vistaStore;
    }

    public void obtenerDatosDireccion() {

        DefaultComboBoxModel modeloCombAddressStore;
        modeloCombAddressStore = (DefaultComboBoxModel) vistaStore.getCombAddressStore().getModel();
        
        int id = Integer.parseInt((String) vista.getTablaAddress().getValueAt(vista.getTablaAddress().getSelectedRow(), 0));
        Address address = manager.getAddressDAO().consultarDireccion(id);
        modeloCombAddressStore.setSelectedItem(address);
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
