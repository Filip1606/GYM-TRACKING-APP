/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Clanstvo;
import domain.Korisnik;
import domain.Sprava;
import domain.Teretana;
import domain.Trening;
import domain.Vezba;
import so.IzmeniTrening;
import so.ObrisiTrening;
import so.ObrisiVezbu;
import so.NadjiTreninge;
import so.UcitajListuKorisnika;
import so.UcitajListuSprava;
import so.UcitajListuTeretana;
import so.UcitajListuTreninga;
import so.UcitajListuVezbi;
import so.UlogujKorisnika;
import so.ZapamtiClanstvo;
import so.ZapamtiKorisnika;
import so.ZapamtiSpravu;
import so.ZapamtiTrening;


/**
 *
 * @author Filip
 */
public class Controller {

    public Korisnik login(Korisnik korisnik) throws Exception {
        UlogujKorisnika ulogujKorisnika = new UlogujKorisnika();
        ulogujKorisnika.execute(korisnik);
        return ulogujKorisnika.getKorisnik();
    }

    public void dodajKorisnika(Korisnik korisnik) throws Exception{
        ZapamtiKorisnika zapamtiKorisnika = new ZapamtiKorisnika();
        zapamtiKorisnika.execute(korisnik);
    }

    public void dodajTrening(Trening noviTr) throws Exception{
        ZapamtiTrening zapamtiTrening = new ZapamtiTrening();
        zapamtiTrening.execute(noviTr);
    }
    
    public void dodajClanstvo(Clanstvo novo) throws Exception{
        ZapamtiClanstvo zapamtiClanstvo = new ZapamtiClanstvo();
        zapamtiClanstvo.execute(novo);
    }
    
    public void dodajSpravu(Sprava nova) throws Exception{
        ZapamtiSpravu zapamtiSpravu = new ZapamtiSpravu();
        zapamtiSpravu.execute(nova);
    }
    
     public Object vratiTreninge() throws Exception{
        UcitajListuTreninga ucitajListuTreninga = new UcitajListuTreninga();
        ucitajListuTreninga.execute(new Trening());
        return ucitajListuTreninga.getTreninzi();
    }

    public Object vratiTeretane() throws Exception{
        UcitajListuTeretana ucitajListuTeretana = new UcitajListuTeretana();
        ucitajListuTeretana.execute(new Teretana());
        return ucitajListuTeretana.getTeretane();
    }

    public Object vratiVezbe() throws Exception{
        UcitajListuVezbi ucitajListuVezbi = new UcitajListuVezbi();
        ucitajListuVezbi.execute(new Vezba());
        return ucitajListuVezbi.getVezbe();
    }

    public Object vratiKorisnike() throws Exception{
        UcitajListuKorisnika ucitajListuKorisnika = new UcitajListuKorisnika();
        ucitajListuKorisnika.execute(new Korisnik());
        return ucitajListuKorisnika.getKorisnici();
    }
    
    public Object vratiSprave() throws Exception{
        UcitajListuSprava ucitajListuSprava = new UcitajListuSprava();
        ucitajListuSprava.execute(new Sprava());
        return ucitajListuSprava.getSprave();
    }

    public void obrisiTrening(Trening izabraniTrening) throws Exception{
        ObrisiTrening obrisiTrening = new ObrisiTrening();
        obrisiTrening.execute(izabraniTrening);
    }

    public void obrisiVezbu(Vezba izabranaVezba) throws Exception{
        ObrisiVezbu obrisiVezbu = new ObrisiVezbu();
        obrisiVezbu.execute(izabranaVezba);
    }

    public void izmeniTrening(Trening izmenjenTrening) throws Exception{
        IzmeniTrening izmeniTrening = new IzmeniTrening();
        izmeniTrening.execute(izmenjenTrening);
    }

    public Object pretraziTreninge(Trening trening) throws Exception{
        NadjiTreninge pretraziTreninge = new NadjiTreninge();
        pretraziTreninge.execute(trening);
        return pretraziTreninge.getTreninzi();
    }

    

    
    
}
