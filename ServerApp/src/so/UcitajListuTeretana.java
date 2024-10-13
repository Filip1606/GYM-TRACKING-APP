/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Teretana;
import domain.Trening;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class UcitajListuTeretana extends AbstractSO{

    public UcitajListuTeretana() throws Exception {
        super();
    }

    private List<Teretana> teretane = new ArrayList<>();

    public List<Teretana> getTeretane() {
        return teretane;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);
        teretane = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Teretana) {
                teretane.add((Teretana) domainObject);
            }
        }
        if (teretane.isEmpty()) {
            throw new Exception("Teretane ne postoje");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Teretana)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
