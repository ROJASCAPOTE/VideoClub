/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.StaffListenerManager;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Staff;
import Vista.FrmManagerStore;
import Vista.FrmStore;
import java.util.ArrayList;

/**
 *
 * @author ACER E5
 */
public class StaffManagerStoreController {
    
    private FrmManagerStore vista;
    private FrmStore vistaStore;
    private DAOManager manager;
    
    public StaffManagerStoreController(FrmManagerStore vista, DAOManager manager) {
        this.vista = vista;
        this.manager = manager;
        vista.addListenerCerrar(new StaffListenerManager(this));
        vista.addListenerCancelar(new StaffListenerManager(this));
        obtenerDireccionStaffManager();
        vista.setRdbSi(true);
    }
    
    private void obtenerDireccionStaffManager() {
        ArrayList<Address> listadoDirecciones;
        listadoDirecciones = manager.getAddressDAO().listadoAddress();
        vista.cargarDireccionManager(listadoDirecciones);
    }
    
    public void setVistaStore(FrmStore vistaStore) {
        this.vistaStore = vistaStore;
    }
    
    
    
    public void cerrarAction() {
        vista.cerrarAction();
    }
    
}
