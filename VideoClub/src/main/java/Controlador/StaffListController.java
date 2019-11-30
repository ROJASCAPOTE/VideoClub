package Controlador;

import Eventos.StaffMouseListener;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Staff;
import Modelo.Store;
import Vista.FrmListStaff;
import Vista.FrmStaff;
import javax.swing.DefaultComboBoxModel;

public class StaffListController {

    private FrmListStaff vista;
    private FrmStaff frmStaff;
    private DAOManager modelo;
    private Object[][] dtStaff;

    public StaffListController(FrmListStaff vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.addMouseListenerStore(new StaffMouseListener(this));
        dtStaff = this.modelo.getStaffDAO().getTableStaff(0, "");
        this.vista.tableStaff(dtStaff);
    }

    public void setFrmStaff(FrmStaff frmStaff) {
        this.frmStaff = frmStaff;
    }

    private Staff obtenerSeleccionStaff() {
        int staff_id = Integer.parseInt((String) vista.getTableStaff().getValueAt(vista.getTableStaff().getSelectedRow(), 0));
        return modelo.getStaffDAO().obtenerStaff(staff_id);
    }

    private Address obtenerSeleccionAddress() {
        int address_id = Integer.parseInt((String) vista.getTableStaff().getValueAt(vista.getTableStaff().getSelectedRow(), 3));
        return modelo.getAddressDAO().consultarDireccion(address_id);
    }

    private Store obtenerSeleccionStore() {
        int store_id = Integer.parseInt((String) vista.getTableStaff().getValueAt(vista.getTableStaff().getSelectedRow(), 5));
        return modelo.getStoreDAO().consultarStore(store_id);
    }

    public void obtenerDatosStaff() {
        Staff staff = null;
        Address address = null;
        Store store = null;

        DefaultComboBoxModel modelocbxaStore;
        modelocbxaStore = (DefaultComboBoxModel) frmStaff.getCmbStore().getModel();
        staff = obtenerSeleccionStaff();
        frmStaff.setTexCodigoStaff(staff.getStaff_id() + "");
        frmStaff.setTextFirstName(staff.getFirst_name());
        frmStaff.setTexLastName(staff.getLast_name());
        address = obtenerSeleccionAddress();
        frmStaff.setAddressStaff(address);
        frmStaff.setTexEmail(staff.getEmail());
        store = obtenerSeleccionStore();
        modelocbxaStore.setSelectedItem(store);
        if (staff.isActive() == true) {
            frmStaff.setRdbSi(true);
        }
        if (staff.isActive() == false) {
            frmStaff.setRdbNo(true);
        }
        
        frmStaff.setTexUserName(staff.getUsername());

        frmStaff.modificarAction();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
