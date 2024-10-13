/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Filip
 */

public class Clanstvo extends DomainObject implements Serializable{

    private Teretana IDTeretane;
    private Korisnik IDKorinsika;
    private LocalDate datumOd;
    private LocalDate datumDo;   
    private int cena;

    public Clanstvo() {
    }

    public Clanstvo(Teretana IDTeretane, Korisnik IDKorinsika, LocalDate datumOd, LocalDate datumDo, int cena) {
        this.IDTeretane = IDTeretane;
        this.IDKorinsika = IDKorinsika;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.cena = cena;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    

    public Teretana getIDTeretane() {
        return IDTeretane;
    }

    public void setIDTeretane(Teretana IDTeretane) {
        this.IDTeretane = IDTeretane;
    }

    public Korisnik getIDKorinsika() {
        return IDKorinsika;
    }

    public void setIDKorinsika(Korisnik IDKorinsika) {
        this.IDKorinsika = IDKorinsika;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    
    
    
    @Override
    public String getTableName() {
        return "clanstvo";
    }

    @Override
    public String getColumnsForInsert() {
        return "IDTeretane, IDKorisnika, datumOd, datumDo, cena";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?,?,?)";
    }

    @Override
    public String getParamsForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Clanstvo) {
            Clanstvo clanstvo = (Clanstvo) domainObject;
            statement.setInt(1, clanstvo.getIDTeretane().getIDTeretane());
            statement.setInt(2, clanstvo.getIDKorinsika().getIDKorisnika());
            statement.setDate(3, java.sql.Date.valueOf(clanstvo.getDatumOd()));
            statement.setDate(4, java.sql.Date.valueOf(clanstvo.getDatumDo()));
            statement.setInt(5, clanstvo.getCena());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Članstvo");
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
