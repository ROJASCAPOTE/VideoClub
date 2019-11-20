package Controlador;

import Eventos.CityListener;
import Modelo.City;
import Modelo.Country;
import Modelo.Dao.DAOManager;
import Vista.frmCity;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CityController {

    private frmCity vista;
    private DAOManager manager;
    private Object[][] dtCity;

    public CityController(frmCity vista, DAOManager manager) {
        this.vista = vista;
        this.manager = manager;

        vista.addListenerNuevo(new CityListener(this));
        vista.addListenerBtnModificar(new CityListener(this));
        vista.addListenerBtnBorrar(new CityListener(this));
        vista.addListenerCerrar(new CityListener(this));
        vista.activarControles(false);
        ArrayList<Country> listadoMunicipios;
        listadoMunicipios = manager.getCountryDAO().listadoCountry();
        this.vista.cargarCountry(listadoMunicipios);
        codigocity();

    }

    public void codigocity() {
        int codigo = manager.getCityDAO().grtCodigo();
        vista.codigoCity(codigo);
    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

    public void registrarCity() {
        if (vista.getTextCodigo().equals("")) {
            vista.gestionMensajes("Ingrese el código",
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

            int resultado = 0;
            resultado = manager.getCityDAO().grabarCity(city);
            if (resultado == 1) {
                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                vista.activarControles(false);
                vista.nuevoAction();
                vista.limpiarCampos();
                codigocity();
            } else {
                vista.gestionMensajes("Error al grabar",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void modificarCity() {
        City city = new City();
        Country country = null;
        int city_id = Integer.parseInt(vista.getTextCodigo());
        city.setCity_id(city_id);
        city.setCity(vista.getTextCity());
        country = (Country) vista.getCombCountry().getSelectedItem();
        city.setCountry(country);

        if (manager.getCityDAO().modificarCity(city) == 1) {
            vista.gestionMensajes(
                    "Actualización exitosa",
                    "Confirmación ",
                    JOptionPane.INFORMATION_MESSAGE);

            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
            codigocity();

        } else {
            vista.gestionMensajes(
                    "Actualización Falida",
                    "Confirmación ",
                    JOptionPane.ERROR_MESSAGE);
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
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.limpiarCampos();
                    codigocity();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
