/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Clanstvo;
import domain.Korisnik;
import domain.Sprava;
import domain.Trening;
import domain.Vezba;
import java.net.Socket;
import logic.Controller;
import server.Server;

/**
 *
 * @author Filip
 */
public class ClientThread extends Thread {

    private final Socket clientSocket;
    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    
    private Server server;
    private Korisnik aktivni=null;

    private boolean kraj=false;
    private Korisnik korisnik;

    public ClientThread(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        sender = new Sender(clientSocket);
        receiver = new Receiver(clientSocket);
        controller = new Controller();
        this.server = server;
    }

    @Override
    public void run() {

        while (!kraj) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();

                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Korisnik korisnik = (Korisnik) request.getArgument();
                            if (server.notLogin(korisnik)) {
                                response.setResult(controller.login(korisnik));
                                this.korisnik = korisnik;
                            } else {
                                throw new Exception("Korisnik je vec prijavljen.");
                            }
                            break;
                        case LOGOUT:
                            setKorisnik(null);
                            kraj=true;
                            break;
                        case DODAJ_KORISNIKA:
                            Korisnik novi = (Korisnik) request.getArgument();
                            controller.dodajKorisnika(novi);
                            response.setResult(novi);
                            break;
                        case VRATI_SVE_TRENINGE:
                            response.setResult(controller.vratiTreninge());
                            break;
                        case DODAJ_TRENING:
                            Trening noviTr = (Trening) request.getArgument();
                            controller.dodajTrening(noviTr);
                            response.setResult(noviTr);
                            break;
                        case DODAJ_CLANSTVO:
                            Clanstvo novo = (Clanstvo) request.getArgument();
                            controller.dodajClanstvo(novo);
                            response.setResult(novo);
                            break;
                        case DODAJ_SPRAVU:
                            Sprava nova = (Sprava) request.getArgument();
                            controller.dodajSpravu(nova);
                            response.setResult(nova);
                            break;
                        case VRATI_SVE_TERETANE:
                            response.setResult(controller.vratiTeretane());
                            break;
                        case VRATI_SVE_VEZBE:
                            response.setResult(controller.vratiVezbe());
                            break;
                        case VRATI_SVE_KORISNIKE:
                            response.setResult(controller.vratiKorisnike());
                            break;
                        case VRATI_SVE_SPRAVE:
                            response.setResult(controller.vratiSprave());
                            break;
                        case OBRISI_TRENING:
                            Trening izabraniTrening = (Trening) request.getArgument();
                            controller.obrisiTrening(izabraniTrening);
                            response.setResult(izabraniTrening);
                            break;
                        case OBRISI_VEZBU:
                            Vezba izabranaVezba = (Vezba) request.getArgument();
                            controller.obrisiVezbu(izabranaVezba);
                            response.setResult(izabranaVezba);
                            break;
                        case IZMENI_TRENING:
                            Trening izmenjenTrening = (Trening) request.getArgument();
                            controller.izmeniTrening(izmenjenTrening);
                            response.setResult(izmenjenTrening);
                            break;
                        case PRETRAZI_TRENING:
                            Trening trening = (Trening) request.getArgument();
                            response.setResult(controller.pretraziTreninge(trening));
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

}
