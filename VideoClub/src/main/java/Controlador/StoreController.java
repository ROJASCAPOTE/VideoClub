package Controlador;

import Event.Store.StoreListener;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Staff;
import Modelo.Store;
import Vista.FrmStore;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StoreController {

    private FrmStore vista;
    private DAOManager modelo;

    public StoreController(FrmStore vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addListenerNuevo(new StoreListener(this));
        ArrayList<Address> listadoDirecciones;
        listadoDirecciones = modelo.getAddressDAO().listadoAddress();
        this.vista.cargarDirecciones(listadoDirecciones);
        vista.caompos(false);
        vista.setRdbActiveSi(true);
        cadigarCodigo();
    }

    public void cadigarCodigo() {
        vista.setTextIdStore(modelo.getStoreDAO().grtCodigoStore() + "");
        vista.setTextIdManagerStore(modelo.getStaffDAO().getCodigo() + "");
    }

    public void registrarTienda() {
        boolean active = true;
        Store store = new Store();
        Staff staffMnager = new Staff();
        int id_manager = Integer.parseInt(vista.getTextIdManagerStore());
        staffMnager.setStaff_id(id_manager);
        staffMnager.setFirst_name(vista.getTextFirstNameManager());
        staffMnager.setLast_name(vista.getTextLastNameManager());
        staffMnager.setAddressId(vista.getAddress().getAddressId());
        staffMnager.setRuta(vista.getTextRutaImagen());
        staffMnager.setEmail(vista.getTextEmailManager());
        int storeMnager = Integer.parseInt(vista.getTextIdStore());
        staffMnager.setStore_id(storeMnager);

        if (vista.getRdbActiveSi()) {
            active = true;
        } else if (vista.getRdbActiveNo()) {
            active = false;
        }
        staffMnager.setActive(active);
        staffMnager.setUsername(vista.getTextUserNameManager());
        staffMnager.setPassword(vista.getTextPasswordManager());
        staffMnager.setLast_update(vista.getTextLastUpdateManager());

        int store_id = Integer.parseInt(vista.getTextIdStore());
        store.setStore_id(store_id);
        store.setManager_staff(staffMnager);
        store.setAddress_id(vista.getAddress());
        store.setLast_update(vista.getTextLastUpdateStore());

        int resulStaff = 0, resultadoStore = 0;
        resulStaff = modelo.getStaffDAO().grabarStaff(staffMnager);
        if (resulStaff != 1) {
            vista.gestionMensajes("Error al grabar",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        } else {
            resultadoStore = modelo.getStoreDAO().grabarStore(store);
            if (resultadoStore == 1) {

                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                cadigarCodigo();

            }

        }
    }
}
