/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.StoreEventoBuscarStore;
import Eventos.StoreMouseListener;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Store;
import Vista.FrmListStore;
import Vista.FrmStore;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author ACER E5
 */
public class StoreListController {

    private FrmListStore vista;
    private DAOManager modelo;
    private FrmStore frmStore;
    private Object[][] dtStore;

    public StoreListController(FrmListStore vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;

        vista.addListenerBuscar(new StoreEventoBuscarStore(this));
        vista.addMouseListenerStore(new StoreMouseListener(this));
        ArrayList<Store> listadoStore;

        listadoStore = modelo.getStoreDAO().listadoStore();
        vista.cargarListStore(listadoStore);

        dtStore = this.modelo.getStoreDAO().getTableStore(0);
        this.vista.tableStore(dtStore);
    }

    public void setFrmStore(FrmStore frmStore) {
        this.frmStore = frmStore;
    }

    public JComboBox<String> getCampoSelecionarStore() {
        return vista.getCombStore();
    }

    public void getCampoSelecionarStore(int codigo) {
        dtStore = this.modelo.getStoreDAO().getTableStore(codigo);
        this.vista.tableStore(dtStore);
    }

    private Address obtenerSeleccionAddress() {
        int address_id = Integer.parseInt((String) vista.getTableStore().getValueAt(vista.getTableStore().getSelectedRow(), 4));
        return modelo.getAddressDAO().consultarDireccion(address_id);
    }

    public void obtenerDatosStore() {
        DefaultComboBoxModel modelocbxStore;
        modelocbxStore = (DefaultComboBoxModel) frmStore.getCombAddressStore().getModel();
        String store_id = (String) vista.getTableStore().getValueAt(vista.getTableStore().getSelectedRow(), 0);
        int staff_id = Integer.parseInt((String) vista.getTableStore().getValueAt(vista.getTableStore().getSelectedRow(), 1));
        frmStore.setTextIdStore(store_id);
        Address address = obtenerSeleccionAddress();
        modelocbxStore.setSelectedItem(address);
        frmStore.setTextAdministrador(staff_id);
        frmStore.modificarAction();

    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
