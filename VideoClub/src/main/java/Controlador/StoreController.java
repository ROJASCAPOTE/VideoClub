package Controlador;

import Eventos.StoreListener;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Store;
import Vista.FrmStore;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StoreController {

    private FrmStore vista;
    private DAOManager modelo;
    private StoreListController listController;
    private int pos = 0;

    public StoreController(FrmStore vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addListenerNuevo(new StoreListener(this));
        vista.addListenerBtnModificar(new StoreListener(this));
        vista.activarControles(false);
        obtenerDireccionStore();

    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    public void obtenerDireccionStore() {
        ArrayList<Address> listadoDirecciones;
        listadoDirecciones = modelo.getAddressDAO().listadoAddress();
        vista.cargarDireccionStore(listadoDirecciones);
    }

    public void registrarTienda() {
        boolean active = true;
        Store store = new Store();
        int store_id = Integer.parseInt(vista.getTextIdStore());
        store.setStore_id(store_id);
        vista.saveData();
        store.setManager_staff(vista.getStaff());
        Address address = null;
        address = (Address) vista.getCombAddressStore().getSelectedItem();
        store.setAddress_id(address);
        store.setLast_update(vista.getTextLastUpdateStore());

        int resulStaff = 0, resultadoStore = 0;
        resulStaff = modelo.getStaffDAO().grabarStaff(store.getManager_staff());
        if (resulStaff != 1) {
            vista.gestionMensajes("Error al grabar",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
        } else {
            resultadoStore = modelo.getStoreDAO().grabarStore(store);
            if (resultadoStore == 1) {

                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }

    public void primero() {
        pos = 0;
        countryIndex(pos);
    }

    public void anterior() {

    }

    public void siguiente() {
        pos++;
        if (pos >= modelo.getStoreDAO().listadoStore().size()) {
            pos = modelo.getStoreDAO().listadoStore().size() - 1;
        }
        countryIndex(pos);
    }

    public void ultimo() {
        pos = modelo.getStoreDAO().listadoStore().size() - 1;
        countryIndex(pos);
    }

    public void countryIndex(int index) {

    }

}
