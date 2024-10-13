/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Korisnik;
import domain.DomainObject;



public class UlogujKorisnika extends AbstractSO{

    private Korisnik korisnik;

    public UlogujKorisnika() throws Exception {
        super();
    }
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        DomainObject domainObject=databaseBroker.getKorisnik((DomainObject)object);
        if (domainObject instanceof Korisnik) {
            korisnik=(Korisnik)domainObject;
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Korisnik)) {
            throw new Exception("Objekat nije validan!");
        }
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    
}
