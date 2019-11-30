/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloGUI;

import Modelo.Inventory;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER E5
 */
public class InventoryTablaModelo extends AbstractTableModel {

    private final Object[] columnas = {"Inventory Id", "Film", "Title", "Store", "Lenght"};

    private ArrayList<Inventory> listInventory;

    public InventoryTablaModelo(ArrayList<Inventory> listInventory) {
        this.listInventory = listInventory;
    }

    @Override
    public int getRowCount() {
        return listInventory.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column].toString();
    }

    public Inventory getFilm(int item) {
        return listInventory.get(item);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listInventory.get(rowIndex).getInventoryId();
            case 1:
                return listInventory.get(rowIndex).getFilm().getFilmId();
            case 2:
                return listInventory.get(rowIndex).getFilm().getTitle();
            case 3:
                return listInventory.get(rowIndex).getStore().getStore_id();
            case 4:
                return listInventory.get(rowIndex).getFilm().getLength();
            default:
                return null;
        }
    }
}
