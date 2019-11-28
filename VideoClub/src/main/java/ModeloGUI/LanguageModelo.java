package ModeloGUI;

import Modelo.Language;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class LanguageModelo extends AbstractTableModel {

    private final Object[] columnas = {"Id", "Language", "Last Update"};
    private ArrayList<Language> listLanguage;

    public LanguageModelo(ArrayList<Language> listLanguage) {
        this.listLanguage = listLanguage;
    }

    @Override
    public int getRowCount() {
        return listLanguage.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column].toString();
    }

    public Language getLanguage(int language_id) {
        return listLanguage.get(language_id);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listLanguage.get(rowIndex).getLanguageId();
            case 1:
                return listLanguage.get(rowIndex).getName();
            case 2:
                return listLanguage.get(rowIndex).getLastUpdate();
            default:
                return null;
        }
    }

}
