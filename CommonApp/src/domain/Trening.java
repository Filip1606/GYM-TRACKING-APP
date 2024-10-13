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

public class Trening extends DomainObject implements Serializable{

    private int IDTreninga;
    private String naziv;
    private int trajanje;
    private String beleska;
    private Korisnik IDKorisnika;
    private List<Vezba> vezbe = new ArrayList<>();

    public Trening() {
    }

    public Trening(int IDTreninga, String naziv, int trajanje, String beleska, Korisnik IDKorisnika) {
        this.IDTreninga = IDTreninga;
        this.naziv = naziv;
        this.trajanje = trajanje;
        this.beleska = beleska;
        this.IDKorisnika = IDKorisnika;
    }

    public int getIDTreninga() {
        return IDTreninga;
    }

    public void setIDTreninga(int IDTreninga) {
        this.IDTreninga = IDTreninga;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getBeleska() {
        return beleska;
    }

    public void setBeleska(String beleska) {
        this.beleska = beleska;
    }

    public Korisnik getIDKorisnika() {
        return IDKorisnika;
    }

    public void setIDKorisnika(Korisnik IDKorisnika) {
        this.IDKorisnika = IDKorisnika;
    }

    public List<Vezba> getVezbe() {
        return vezbe;
    }

    public void setVezbe(List<Vezba> vezbe) {
        this.vezbe = vezbe;
    }
    
    @Override
    public String toString() {
        return naziv;
    }
    
    @Override
    public String getTableName() {
        return "trening";
    }

    @Override
    public String getColumnsForInsert() {
        return "naziv, trajanje, beleska, IDKorisnika";
    }

    @Override
    public String getParamsForInsert() {
        return "(?, ?, ?, ?)";
    }

    @Override
    public String getParamsForUpdate() {
        return "naziv=?, trajanje=?, beleska=?, IDKorisnika=? WHERE IDTreninga=?";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Trening) {
            Trening trening = (Trening) domainObject;
            statement.setString(1, trening.getNaziv());
            statement.setInt(2, trening.getTrajanje());
            statement.setString(3, trening.getBeleska());
            statement.setInt(4, trening.getIDKorisnika().getIDKorisnika());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Trening");
        }
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Trening) {
            Trening trening = (Trening) domainObject;
            statement.setString(1, trening.getNaziv());
            statement.setInt(2, trening.getTrajanje());
            statement.setString(3, trening.getBeleska());
            statement.setInt(4, trening.getIDKorisnika().getIDKorisnika());
            statement.setInt(5, trening.getIDTreninga());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Trening");
        }
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Trening) {
            Trening trening = (Trening) domainObject;
            statement.setInt(1, trening.getIDTreninga());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Trening.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setIDTreninga(primaryKey);
    }

    @Override
    public String getParamsForDelete() {
        return " WHERE IDTreninga = ?";
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        return "*";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws SQLException {
        List<DomainObject> treninzi = new ArrayList<>();

        while (rs.next()) {
            Trening trening = new Trening();
            trening.setIDTreninga(rs.getInt("IDTreninga"));
            trening.setNaziv(rs.getString("naziv"));
            trening.setTrajanje(rs.getInt("trajanje"));
            trening.setBeleska(rs.getString("beleska"));
            Korisnik k = new Korisnik();
            k.setIDKorisnika(rs.getInt("IDKorisnika"));
            k.setIme(rs.getString("ime"));
            k.setPrezime(rs.getString("prezime"));
            k.setMejl(rs.getString("mejl"));
            k.setLozinka(rs.getString("lozinka"));
            trening.setIDKorisnika(k);
            treninzi.add(trening);
        }

        return (List<DomainObject>) treninzi;
    }
    
    @Override
    public String getInnerJoin() throws SQLException {
        return "korisnik k on tr.IDKorisnika = k.IDKorisnika";
    }

    @Override
    public String getTableName2() {
        return "trening tr";
    }

    @Override
    public String getParamsForSelect1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getReqForSearch() {
        return "tr.naziv=?";
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Trening) {
            Trening trening = (Trening) domainObject;
            statement.setString(1, trening.getNaziv());
        } 
        else{
            throw new IllegalArgumentException("Ocekivan objekat tipa Trening");
        }
    }
    
    
    
}
