package Controlador;

import Eventos.StaffMouseListener;
import Modelo.Address;
import Modelo.Dao.DAOManager;
import Modelo.Staff;
import Modelo.Store;
import Vista.FrmListStaff;
import Vista.FrmStaff;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
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

    public void obtenerDatosStaff() throws IOException {
        Staff staff = null;
        Address address = null;
        Store store = null;
        DefaultComboBoxModel modelocbxaAddress;
        modelocbxaAddress = (DefaultComboBoxModel) frmStaff.getCombAddress().getModel();

        DefaultComboBoxModel modelocbxaStore;
        modelocbxaStore = (DefaultComboBoxModel) frmStaff.getCmbStore().getModel();
        staff = obtenerSeleccionStaff();
        frmStaff.setTexCodigoStaff(staff.getStaff_id() + "");
        frmStaff.setTextFirstName(staff.getFirst_name());
        frmStaff.setTexLastName(staff.getLast_name());
        address = obtenerSeleccionAddress();
        modelocbxaAddress.setSelectedItem(address);
        frmStaff.setTexEmail(staff.getEmail());

        store = obtenerSeleccionStore();
        modelocbxaStore.setSelectedItem(store);
        frmStaff.modificarAction();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
