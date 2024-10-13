/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Vezba;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class UcitajListuVezbi extends AbstractSO{

    public UcitajListuVezbi() throws Exception {
        super();
    }

    private List<Vezba> vezbe = new ArrayList<>();

    public List<Vezba> getVezbe() {
        return vezbe;
    }
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.getAllWithInnerJoin((DomainObject) object);
        vezbe = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Vezba) {
                vezbe.add((Vezba) domainObject);
            }
        }
        if (vezbe.isEmpty()) {
            throw new Exception("Vežbe ne postoje");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Vezba)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
