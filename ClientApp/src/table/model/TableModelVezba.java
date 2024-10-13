/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Vezba;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Filip
 */
public class TableModelVezba extends AbstractTableModel{
    
    private List<Vezba> lista=new ArrayList<>();
    private String[] kolone={"Naziv","Ponavljanja","Tezina", "Sprava"};
    int rb = 0;

    public TableModelVezba() {
    }
    
    public TableModelVezba(List<Vezba> vezbe) {
        this.lista = vezbe;
    }
    
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
        Vezba v = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getNaziv();
            case 1:
                return v.getPonavljanja();
            case 2:
                return v.getTezina();
            case 3:
                return v.getIDSprave().getNaziv();
            default: 
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Vezba> getLista() {
        return lista;
    }

    public void setLista(List<Vezba> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    public Vezba getVezba(int red) {
        return lista.get(red);
    }

    public void obrisiVezbu(int red) {
        lista.remove(red);
        for (Vezba vezba : lista) {
            vezba.setIDVezbe(++rb);
        }
        fireTableDataChanged();
    }
    
}
