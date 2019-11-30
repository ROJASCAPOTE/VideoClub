/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloGUI;

import Modelo.Staff;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER E5
 */
public class StaffTablaModelo extends AbstractTableModel {

    private ArrayList<Staff> listStaff;

    public StaffTablaModelo(ArrayList<Staff> listStaff) {
        this.listStaff = listStaff;
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
