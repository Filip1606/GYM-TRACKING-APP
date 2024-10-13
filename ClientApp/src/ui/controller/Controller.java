/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Clanstvo;
import domain.Korisnik;
import domain.Sprava;
import domain.Teretana;
import domain.Trening;
import domain.Vezba;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Filip
 */
public class Controller {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Controller instance;

    private Controller() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Korisnik login(Korisnik korisnik) throws Exception {
        Request request = new Request(Operation.LOGIN, korisnik);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Korisnik) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void logout() throws Exception {
        Request request = new Request(Operation.LOGOUT, null);
        sender.send(request);
    }

    public void kreirajKorisnika(Korisnik korisnik) throws Exception{
        Request request = new Request(Operation.DODAJ_KORISNIKA, korisnik);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            korisnik.setIDKorisnika(((Korisnik) response.getResult()).getIDKorisnika());
        } else {
            throw response.getException();
        }
    }

    public void kreirajTrening(Trening trening) throws Exception{
        Request request = new Request(Operation.DODAJ_TRENING, trening);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            trening.setIDTreninga(((Trening) response.getResult()).getIDTreninga());
        } else {
            throw response.getException();
        }
    }
    
    public void kreirajClanstvo(Clanstvo clanstvo) throws Exception{
        Request request = new Request(Operation.DODAJ_CLANSTVO, clanstvo);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            System.out.println("Kreirano clanstvo");
        } else {
            throw response.getException();
        }
    }
    
    public void kreirajSpravu(Sprava sprava) throws Exception{
        Request request = new Request(Operation.DODAJ_SPRAVU, sprava);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            sprava.setIDSprave(((Sprava) response.getResult()).getIDSprave());
        } else {
            throw response.getException();
        }
    }
    
    public List<Trening> vratiTreninge() throws Exception{
        Request request = new Request(Operation.VRATI_SVE_TRENINGE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Trening>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Teretana> vratiTeretane() throws Exception{
        Request request = new Request(Operation.VRATI_SVE_TERETANE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Teretana>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Vezba> vratiVezbe() throws Exception{
        Request request = new Request(Operation.VRATI_SVE_VEZBE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Vezba>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Korisnik> vratiKorisnike() throws Exception{
        Request request = new Request(Operation.VRATI_SVE_KORISNIKE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Korisnik>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    
    public List<Sprava> vratiSprave() throws Exception{
        Request request = new Request(Operation.VRATI_SVE_SPRAVE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Sprava>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void obrisiTrening(Trening izabrani) throws Exception{
        Request request = new Request(Operation.OBRISI_TRENING, izabrani);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public void obrisiVezbu(Vezba izabrana) throws Exception{
        Request request = new Request(Operation.OBRISI_VEZBU, izabrana);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public void izmeniTrening(Trening izmenjeni) throws Exception{
        Request request = new Request(Operation.IZMENI_TRENING, izmenjeni);
        sender.send(request);
        Response response = (Response) receiver.receive();
    }

    public List<Trening> pretraziTreninge(Trening t) throws Exception{
        Request request = new Request(Operation.PRETRAZI_TRENING, t);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Trening>) response.getResult();
        } else {
            throw response.getException();
        }
    }



}
