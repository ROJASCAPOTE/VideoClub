package Controlador;

import Events.City.CityMouseListener;
import Modelo.City;
import Modelo.Country;
import Modelo.Dao.DAOManager;
import Vista.FrmCityView;
import Vista.frmCity;
import javax.swing.DefaultComboBoxModel;

public class CityListViewController {

    private FrmCityView vista;
    private DAOManager modelo;
    private frmCity city;
    private Object[][] dtCity;

    public CityListViewController(FrmCityView vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.addMouseListenerCity(new CityMouseListener(this));
        dtCity = this.modelo.getCityDAO().getTableCity();
        this.vista.tableCity(dtCity);
    }

    public void setCity(frmCity city) {
        this.city = city;
    }

    public Country obtenerSeleccionCountry() {
        String country = (String) vista.getTableCity().getValueAt(vista.getTableCity().getSelectedRow(), 2);
        return modelo.getCountryDAO().obtenerCountry(country);

    }

    public void obtenerDatosCity() {
        DefaultComboBoxModel modelocbxCountry;
        modelocbxCountry = (DefaultComboBoxModel) city.getCombCountry().getModel();
        int city_id = Integer.parseInt((String) vista.getTableCity().getValueAt(vista.getTableCity().getSelectedRow(), 0));
        String nomcity = (String) vista.getTableCity().getValueAt(vista.getTableCity().getSelectedRow(), 1);
        city.setTextCodigo(city_id);
        city.setTextCity(nomcity);
        Country country = obtenerSeleccionCountry();
        modelocbxCountry.setSelectedItem(country);
        city.modificarAction();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}