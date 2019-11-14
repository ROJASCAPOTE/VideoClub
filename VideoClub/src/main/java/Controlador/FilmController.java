/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dao.DAOManager;
import Vista.FrmFilm;

public class FilmController {

    private FrmFilm vista;
    private DAOManager modelo;

    public FilmController(FrmFilm vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    
    
}
