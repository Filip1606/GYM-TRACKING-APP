/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import domain.Trening;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Filip
 */
public class TableModelTrening extends AbstractTableModel{

    private List<Trening> lista=new ArrayList<>();
    private String[] kolone={"naziv","trajanje","beleska","korisnik"};
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    public TableModelTrening(List<Trening> treninzi) {
        this.lista = treninzi;
    }

    public TableModelTrening() {
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trening t = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getNaziv();
            case 1:
                return t.getTrajanje();
            case 2:
                return t.getBeleska();
            case 3:
                return t.getIDKorisnika().getIme();
            default: 
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Trening> getLista() {
        return lista;
    }

    public void setLista(List<Trening> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    
}
