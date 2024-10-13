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

public class Vezba extends DomainObject implements Serializable{
    
    private int IDVezbe;
    private String naziv;
    private int ponavljanja;
    private int tezina;
    private Sprava IDSprave;
    private Trening IDTreninga;

    public Vezba() {
    }

    public Vezba(int IDVezbe, String naziv, int ponavljanja, int tezina, Sprava IDSprave, Trening IDTreninga) {
        this.IDVezbe = IDVezbe;
        this.naziv = naziv;
        this.ponavljanja = ponavljanja;
        this.tezina = tezina;
        this.IDSprave = IDSprave;
        this.IDTreninga = IDTreninga;
    }

    public int getIDVezbe() {
        return IDVezbe;
    }

    public void setIDVezbe(int IDVezbe) {
        this.IDVezbe = IDVezbe;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPonavljanja() {
        return ponavljanja;
    }

    public void setPonavljanja(int ponavljanja) {
        this.ponavljanja = ponavljanja;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public Sprava getIDSprave() {
        return IDSprave;
    }

    public void setIDSprave(Sprava IDSprave) {
        this.IDSprave = IDSprave;
    }

    public Trening getIDTreninga() {
        return IDTreninga;
    }

    public void setIDTreninga(Trening IDTreninga) {
        this.IDTreninga = IDTreninga;
    }
    
    @Override
    public String getTableName() {
        return "vezba";
    }

    @Override
    public String getColumnsForInsert() {
        return "naziv, ponavljanja, tezina, IDSprave, IDTreninga";
    }

    @Override
    public String getParamsForInsert() {
        return "(?, ?, ?, ?, ?)";
    }

    @Override
    public String getParamsForUpdate() {
        return "naziv=?, ponavljanja=?, tezina=?, IDSprave=?, IDTreninga=? WHERE IDVezbe = ?";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Vezba) {
            Vezba vezba = (Vezba) domainObject;
            statement.setString(1, vezba.getNaziv());
            statement.setInt(2, vezba.getPonavljanja());
            statement.setInt(3, vezba.getTezina());
            statement.setInt(4, vezba.getIDSprave().getIDSprave());
            statement.setInt(5, vezba.getIDTreninga().getIDTreninga());
            
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Vezba");
        }
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Vezba) {
            Vezba vezba = (Vezba) domainObject;
            statement.setString(1, vezba.getNaziv());
            statement.setInt(2, vezba.getPonavljanja());
            statement.setInt(3, vezba.getTezina());
            statement.setInt(4, vezba.getIDSprave().getIDSprave());
            statement.setInt(5, vezba.getIDTreninga().getIDTreninga());
            statement.setInt(6, vezba.getIDVezbe());
        } else {
            throw new IllegalArgumentException("Ocekivan objekat tipa Vezba");
        }
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Vezba) {
            Vezba vezba = (Vezba) domainObject;
            statement.setInt(1, vezba.getIDVezbe());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Vezba.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(int primaryKey) {
        setIDVezbe(primaryKey);
    }

    @Override
    public String getParamsForDelete() {
        return " WHERE IDVezbe = ?";
    }

    @Override
    public String getColumnsForSelect() throws SQLException {
        return "*";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws SQLException {
        List<DomainObject> vezbe = new ArrayList<>();
        while (rs.next()) {
            Vezba vezba = new Vezba();
            vezba.setIDVezbe(rs.getInt("IDVezbe"));
            vezba.setNaziv(rs.getString("naziv"));
            vezba.setPonavljanja(rs.getInt("ponavljanja"));
            vezba.setTezina(rs.getInt("tezina"));
            
            Sprava s = new Sprava();
            s.setIDSprave(rs.getInt("IDSprave"));
            s.setNaziv(rs.getString("s.naziv"));
            s.setMaxTezina(rs.getDouble("maxTezina"));
            vezba.setIDSprave(s);
            
            Trening t = new Trening();
            t.setIDTreninga(rs.getInt("IDTreninga"));
            t.setNaziv(rs.getString("t.naziv"));
            t.setTrajanje(rs.getInt("trajanje"));
            t.setBeleska(rs.getString("beleska"));
//            Korisnik k = new Korisnik();
//            k.setIDKorisnika(rs.getInt("IDKorisnika"));
//            t.setIDKorisnika(k);
            vezba.setIDTreninga(t);
            vezbe.add(vezba);
        }
        return (List<DomainObject>) vezbe;
    }

    @Override
    public String getInnerJoin() throws SQLException {
        return "trening t on v.IDTreninga = t.IDTreninga INNER JOIN sprava s on v.IDSprave = s.IDSprave";
    }

    @Override
    public String getTableName2() {
        return "vezba v";
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
        return "v.naziv=?";
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Vezba) {
            Vezba vezba = (Vezba) domainObject;
            statement.setString(1, vezba.getNaziv());
        } 
        else{
            throw new IllegalArgumentException("Ocekivan objekat tipa Vežba");
        }
    }
    
}
