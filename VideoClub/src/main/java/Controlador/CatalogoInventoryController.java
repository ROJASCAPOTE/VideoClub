/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dao.DAOManager;
import Vista.FrmCatalogoInventory;

/**
 *
 * @author ACER E5
 */
public class CatalogoInventoryController {
     private FrmCatalogoInventory vista;
    private DAOManager modelo;
    private Object[][] dtInventary;

    public CatalogoInventoryController(FrmCatalogoInventory vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
        dtInventary = modelo.getInventoryDAO().getTableInventario();
        vista.tableInventory(dtInventary);
    }

}
