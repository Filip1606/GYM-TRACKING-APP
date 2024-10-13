/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Korisnik;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class UcitajListuKorisnika extends AbstractSO{

    public UcitajListuKorisnika() throws Exception {
        super();
    }

    private List<Korisnik> korisnici = new ArrayList<>();

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);
        korisnici = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Korisnik) {
                korisnici.add((Korisnik) domainObject);
            }
        }
        if (korisnici.isEmpty()) {
            throw new Exception("Korisnici ne postoje");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Korisnik)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
