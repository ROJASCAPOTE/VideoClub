/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Controlador.StoreListController;
import Modelo.Store;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER E5
 */
public class StoreEventoBuscarStore implements ActionListener {

    private StoreListController controller;

    public StoreEventoBuscarStore(StoreListController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Store valorSelecionado = null;

        valorSelecionado = (Store) controller.getCampoSelecionarStore().getSelectedItem();
        controller.getCampoSelecionarStore(valorSelecionado.getStore_id());
    }

}
