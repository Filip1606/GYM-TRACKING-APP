/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Teretana;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Filip
 */
public class TableModelTeretana extends AbstractTableModel{
    
    private List<Teretana> lista=new ArrayList<>();
    private String[] kolone={"naziv","kontakt","mesto","adresa"};
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teretana t = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getNaziv();
            case 1:
                return t.getKontakt();
            case 2:
                return t.getMesto();
            case 3:
                return t.getAdresa();
            default: 
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Teretana> getLista() {
        return lista;
    }

    public void setLista(List<Teretana> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
}
