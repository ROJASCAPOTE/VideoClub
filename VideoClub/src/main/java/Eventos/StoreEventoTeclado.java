/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.AddressListController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ACER E5
 */
public class StoreEventoTeclado extends KeyAdapter {

    private AddressListController controller;

    public StoreEventoTeclado(AddressListController controller) {
        this.controller = controller;
    }
    
    @Override
    public void keyReleased(KeyEvent evento) {
        controller.buscarAddress();
    }
}
