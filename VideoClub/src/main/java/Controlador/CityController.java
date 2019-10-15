package Controlador;

import Events.City.CityListener;
import Events.City.CityMouseListener;
import Modelo.City;
import Modelo.Country;
import Modelo.Dao.DAOManager;
import Vista.frmCity;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CityController {

    private frmCity vista;
    private DAOManager manager;
    private Object[][] dtCity;

    public CityController(frmCity vista, DAOManager manager) {
        this.vista = vista;
        this.manager = manager;

        vista.addListenerBtnNuevo(new CityListener(this));
        vista.addListenerBtnGuardar(new CityListener(this));
        vista.addListenerBtnModificar(new CityListener(this));
        vista.addListenerBtnEliminar(new CityListener(this));
        vista.addListenerBtnCerrar(new CityListener(this));
        vista.addListenerBtnCancelar(new CityListener(this));
        vista.addMouseListenerCity(new CityMouseListener(this));
        vista.activarControles(false);

        ArrayList<Country> listadoMunicipios;
        listadoMunicipios = manager.getCountryDAO().listadoCountry();
        this.vista.cargarCountry(listadoMunicipios);

        dtCity = this.manager.getCityDAO().getTableCity();
        this.vista.tableCity(dtCity);

    }

    public Country obtenerCountrySeleccionada() {
        String country = (String) vista.getTableCity().getValueAt(vista.getTableCity().getSelectedRow(), 2);
        return manager.getCountryDAO().obtenerCountry(country);
    }

    public void actionNuevoRegistro() {
        vista.nuevoAction();
    }

    public void actionGuardar() {
        vista.guardarAction();
    }

    public void actionModificarRegistro() {
        vista.modificarAction();
    }

    public void actionCerrar() {
        vista.cerrarAction();
    }

    public void actionCancelar() {
        vista.cancelarAction();
    }

    public void registrarCity() {
        if (vista.getTextCodigo().equals("")) {
            vista.gestionMensajes("Ingrese el código",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            vista.camposObligatorios();
        } else if (vista.getTextLastUpdate() == null) {
            vista.gestionMensajes("Ingrese la fecha",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            vista.camposObligatorios();
        } else {
            City city = new City();
            Country country = null;
            int city_id = Integer.parseInt(vista.getTextCodigo());
            city.setCity_id(city_id);
            city.setCity(vista.getTextCity());
            country = (Country) vista.getCombCountry().getSelectedItem();
            city.setCountry(country);
            city.setLast_update(vista.getTextLastUpdate());

            int resultado = 0;
            resultado = manager.getCityDAO().grabarCity(city);
            if (resultado == 1) {
                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                dtCity = this.manager.getCityDAO().getTableCity();
                this.vista.tableCity(dtCity);
                vista.guardarAction();
            } else {
                vista.gestionMensajes("Error al grabar",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void modificarCity() {

        if (vista.getTextLastUpdate() == null) {
            vista.gestionMensajes("Ingrese la fecha",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            vista.camposObligatorios();
        } else {
            City city = new City();
            Country country = null;
            int city_id = Integer.parseInt(vista.getTextCodigo());
            city.setCity_id(city_id);
            city.setCity(vista.getTextCity());
            country = (Country) vista.getCombCountry().getSelectedItem();
            city.setCountry(country);
            city.setLast_update(vista.getTextLastUpdate());

            if (manager.getCityDAO().modificarCity(city) == 1) {
                vista.gestionMensajes(
                        "Actualización exitosa",
                        "Confirmación ",
                        JOptionPane.INFORMATION_MESSAGE);

                vista.activarControles(false);
                vista.nuevoAction();
                dtCity = this.manager.getCityDAO().getTableCity();
                this.vista.tableCity(dtCity);
                vista.modificarAction();

            } else {
                vista.gestionMensajes(
                        "Actualización Falida",
                        "Confirmación ",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void borrarCity() {
        int codigo = 0;
        codigo = Integer.parseInt(vista.getTextCodigo());

        if (codigo == 0) {
            vista.gestionMensajes(
                    "Por favor seleccione un programa de la tabla",
                    "Mensaje de Advertencia ",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar la comuna de codigo : "
                    + codigo + " ?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                if (manager.getCityDAO().borrarCity(codigo) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción",
                            JOptionPane.INFORMATION_MESSAGE);

                    dtCity = this.manager.getCityDAO().getTableCity();
                    this.vista.tableCity(dtCity);
                    vista.guardarAction();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void seleccionarCity() {
        boolean seleccion = vista.getTableCity().getSelectedRow() != -1;
        if (seleccion) {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTableCity().getModel();

            DefaultComboBoxModel modelocbxCountry;
            modelocbxCountry = (DefaultComboBoxModel) vista.getCombCountry().getModel();

            vista.setTextCodigo(modelo.getValueAt(vista.getTableCity().getSelectedRow(), 0).toString());
            vista.setTextCity(modelo.getValueAt(vista.getTableCity().getSelectedRow(), 1).toString());
            Country country = obtenerCountrySeleccionada();
            modelocbxCountry.setSelectedItem(country);
            vista.activarBotonesCRUD(seleccion);
        }
    }
}
