package Controlador;

import Events.City.CityMouseListener;
import Events.Country.ContryMouseListener;
import Events.Country.CountryEventoTecladoCountry;
import Modelo.Country;
import Modelo.Dao.DAOManager;
import Vista.FrmCountry;
import Vista.FrmCountryView;

public class CountryListViewController {

    private FrmCountryView vista;
    private DAOManager modelo;
    private FrmCountry frmCountry;
    private Object[][] dtCountry;

    public CountryListViewController(FrmCountryView vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.addMouseListenerCity(new ContryMouseListener(this));
        vista.addaddKeyListener(new CountryEventoTecladoCountry(this));
        this.dtCountry = modelo.getCountryDAO().getTableCountry("");
        this.vista.tableCountry(dtCountry);
    }

    public void setFrmCountry(FrmCountry frmCountry) {
        this.frmCountry = frmCountry;
    }

    public void obtenerDatosPais() {
        int codigo = Integer.parseInt((String) vista.getTableCountry().getValueAt(vista.getTableCountry().getSelectedRow(), 0));
        String country = (String) vista.getTableCountry().getValueAt(vista.getTableCountry().getSelectedRow(), 1);
        frmCountry.setTexCodigoCountry(codigo);
        frmCountry.setTtexCountry(country);
        frmCountry.modificarAction();
    }

    public void buscarPais() {
        if (!vista.getTexBuscarPais().equals("")) {
            this.dtCountry = modelo.getCountryDAO().getTableCountry(vista.getTexBuscarPais());
            this.vista.tableCountry(dtCountry);
        } else {
            this.dtCountry = modelo.getCountryDAO().getTableCountry("");
            this.vista.tableCountry(dtCountry);
        }
    }

    public void cerrarAction() {
        vista.cerrarAction();
    }

}
