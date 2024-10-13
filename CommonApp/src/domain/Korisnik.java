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
import java.util.Objects;

/**
 *
 * @author Filip
 */

public class Korisnik extends DomainObject implements Serializable{
    private int IDKorisnika;
    private String mejl;
    private String lozinka;
    private String ime;
    private String prezime;

    public Korisnik() {
    }

    public Korisnik(int IDKorisnika, String mejl, String lozinka, String ime, String prezime) {
        this.IDKorisnika = IDKorisnika;
        this.mejl = mejl;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
    }


    public int getIDKorisnika() {
        return IDKorisnika;
    }

    public void setIDKorisnika(int IDKorisnika) {
        this.IDKorisnika = IDKorisnika;
    }

    public String getMejl() {
        return mejl;
    }

    public void setMejl(String mejl) {
        this.mejl = mejl;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.mejl, other.mejl)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public String getColumnsForInsert() {
        return "ime, prezime, mejl, lozinka";
    }

    @Override
    public String getParamsForInsert() {
        return "(?, ?, ?, ?)";
    }

    @Override
    public String getParamsForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        if (domainObject instanceof Korisnik) {
            Korisnik korisnik = (Korisnik) domainObject;
            statement.setString(1, korisnik.getIme());
            statement.setString(2, korisnik.getPrezime());
            statement.setString(3, korisnik.getMejl());
            statement.setString(4, korisnik.getLozinka());
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Korisnik.");
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
        setIDKorisnika(primaryKey);
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
        List<DomainObject> korisnici = new ArrayList<>();
        while (rs.next()) {
            Korisnik k = new Korisnik();
            k.setIDKorisnika(rs.getInt("IDKorisnika"));
            k.setIme(rs.getString("ime"));
            k.setPrezime(rs.getString("prezime"));
            k.setMejl(rs.getString("mejl"));
            k.setLozinka(rs.getString("lozinka"));
            korisnici.add(k);
        }
        return (List<DomainObject>) korisnici;
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
        return "mejl=? AND lozinka=?";
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException{
        if (domainObject instanceof Korisnik) {
            Korisnik korisnik=(Korisnik)domainObject;
            statement.setString(1, korisnik.getMejl());
            statement.setString(2, korisnik.getLozinka());
        }
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) throws SQLException{
        Korisnik korisnik=new Korisnik();
        if (domainObject instanceof Korisnik) {
            korisnik=(Korisnik)domainObject;
            if (rs.next()) {
                korisnik.setIDKorisnika(rs.getInt("IDKorisnika"));
                korisnik.setIme(rs.getString("ime"));
                korisnik.setPrezime(rs.getString("prezime"));
            }
            else{
                korisnik=null;
            }
        }
        return (DomainObject)korisnik;
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
