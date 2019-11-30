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
        vista.setTextIdStore(cargarCodigoStore() + "");
        this.vista.setTextAdministrador(cargarCodigoStaff());

    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    

    public int cargarCodigoStore() {
        int codigo = 0;
        codigo = modelo.getStoreDAO().grtCodigoStore();
        return codigo;
    }

    public int cargarCodigoStaff() {
        int codigo = 0;
        codigo = modelo.getStaffDAO().getCodigo();
        return codigo;
    }
    
    public void cambiarCodigo(){
        vista.setTextIdStore(cargarCodigoStore() + "");
        vista.setTextAdministrador(cargarCodigoStaff());
    }

    public void registrarTienda() {
        Store store = new Store();
        int store_id = Integer.parseInt(vista.getTextIdStore());
        store.setStore_id(store_id);
        vista.saveData();
        store.setManager_staff(vista.getStaff());
        Address address = null;
        store.setAddress_id(vista.getAddressStore());
        store.setManager_staff(vista.getStaff());

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
                vista.activarControles(false);
                vista.nuevoAction();
                vista.limpiarCampos();
                vista.setTextIdStore(cargarCodigoStore() + "");
                vista.setTextAdministrador(cargarCodigoStaff());
            }

        }
    }

}
