/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Eventos.CountryListener;
import Modelo.Country;
import Modelo.Dao.DAOManager;
import Vista.FrmCountry;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class CountryController {

    private FrmCountry vista;
    private DAOManager modelo;
    private int pos = 0;
    public CountryController(FrmCountry vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;

        vista.addListenerCerrar(new CountryListener(this));
        vista.addListenerNuevo(new CountryListener(this));
        vista.addListenerBtnModificar(new CountryListener(this));
        vista.addListenerBtnBorrar(new CountryListener(this));

        vista.activarControles(false);
        pos = 0;
        countryIndex(pos);
    }
    
    

    public void obtenerUltimo() {
        Country country = modelo.getCountryDAO().getCountry();
        if (country != null) {
            vista.setTexCodigoCountry(country.getCountry_id());
            vista.setTtexCountry(country.getCountry());
            vista.setTexLastUpdate(country.getLastUpdate());
        }
    }

    public void obtenerDatosPais(Country c) {
        vista.setTexCodigoCountry(c.getCountry_id());
        vista.setTtexCountry(c.getCountry());
    }

    public void primero() {
        pos = 0;
        countryIndex(pos);
    }

    public void anterior() {
        pos--;
        if (pos < 0) {
            pos = 0;
        }
        countryIndex(pos);
    }

    public void siguiente() {

        pos++;
        if (pos >= modelo.getCountryDAO().listadoPais().size()) {
            pos = modelo.getCountryDAO().listadoPais().size() - 1;
        }
        countryIndex(pos);
    }

    public void ultimo() {
        pos = pos = modelo.getCountryDAO().listadoPais().size() - 1;
        countryIndex(pos);
    }

    public void nuevoAction() {
        vista.nuevoAction();
    }

    public void countryIndex(int index) {
        Country country = modelo.getCountryDAO().listadoPais().get(index);
        vista.setTexCodigoCountry(country.getCountry_id());
        vista.setTtexCountry(country.getCountry());
        vista.setTexLastUpdate(country.getLastUpdate());
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

    public void registrarCountry() {
        if (vista.codigoCountry().equals("")) {
            vista.gestionMensajes("Ingrese el código",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } else {
            Country country = new Country();
            country.setCountry_id(vista.getTexCodigoCountry());
            country.setCountry(vista.getTtexCountry());
            country.setLastUpdate(vista.getTexLastUpdate());
            int resultado = 0;
            resultado = modelo.getCountryDAO().grabarCountry(country);
            if (resultado == 1) {
                vista.gestionMensajes("Registro Grabado con éxito",
                        "Confirmación", JOptionPane.INFORMATION_MESSAGE);

                vista.activarControles(false);
                vista.nuevoAction();
                vista.limpiarCampos();
            } else {
                vista.gestionMensajes("Error al grabar",
                        "Confirmación", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void modificarCountry() {
        Country country = new Country();
        country.setCountry_id(vista.getTexCodigoCountry());
        country.setCountry(vista.getTtexCountry());
        country.setLastUpdate(vista.getTexLastUpdate());

        if (modelo.getCountryDAO().modificarCountry(country) == 1) {
            vista.gestionMensajes(
                    "Actualización exitosa",
                    "Confirmación ",
                    JOptionPane.INFORMATION_MESSAGE);

            vista.activarControles(false);
            vista.nuevoAction();
            vista.limpiarCampos();
        } else {
            vista.gestionMensajes(
                    "Actualización Falida",
                    "Confirmación ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarCountry() {
        int codigo = 0;
        codigo = vista.getTexCodigoCountry();

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

                if (modelo.getCountryDAO().borrarCountry(codigo) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción",
                            JOptionPane.INFORMATION_MESSAGE);
                    vista.activarControles(false);
                    vista.nuevoAction();
                    vista.limpiarCampos();
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
