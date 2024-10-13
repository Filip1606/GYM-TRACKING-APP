/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class Sprava extends DomainObject implements Serializable{

    private int IDSprave;
    private String naziv;
    private double maxTezina;

    public Sprava() {
    }

    public Sprava(int IDSprave, String naziv, double maxTezina) {
        this.IDSprave = IDSprave;
        this.naziv = naziv;
        this.maxTezina = maxTezina;
    }

    public int getIDSprave() {
        return IDSprave;
    }

    public void setIDSprave(int IDSprave) {
        this.IDSprave = IDSprave;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getMaxTezina() {
        return maxTezina;
    }

    public void setMaxTezina(double maxTezina) {
        this.maxTezina = maxTezina;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
    @Override
    public String getTableName() {
        return "sprava";
    }

    @Override
    public String getColumnsForInsert() {
        return "naziv, maxTezina";
    }

    @Override
    public String getParamsForInsert() {
        return "(?, ?)";
    }

    @Override
    public String getParamsForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Sprava) {
            Sprava sprava = (Sprava) domainObject;
            statement.setString(1, sprava.getNaziv());
            statement.setDouble(2, sprava.getMaxTezina());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Sprava");
        }
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setIDSprave(primaryKey);
    }

    @Override
    public String getParamsForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        return "*";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws SQLException {
        List<DomainObject> sprave = new ArrayList<>();
        while (rs.next()) {
            Sprava sprava = new Sprava();
            sprava.setIDSprave(rs.getInt("IDSprave"));
            sprava.setNaziv(rs.getString("naziv"));
            sprava.setMaxTezina(rs.getDouble("maxTezina"));
            sprave.add(sprava);
        }
        return (List<DomainObject>) sprave;
    }

    @Override
    public String getInnerJoin() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForSelect1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getReqForSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
