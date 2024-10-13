/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Sprava;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class UcitajListuSprava extends AbstractSO{
    
    public UcitajListuSprava() throws Exception {
        super();
    }

    private List<Sprava> sprave;

    public List<Sprava> getSprave() {
        return sprave;
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);
        sprave = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Sprava) {
                sprave.add((Sprava) domainObject);
            }
        }
        if (sprave.isEmpty()) {
            throw new Exception("Teretane ne postoje");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Sprava)) {
            throw new Exception("Objekat nije validan");
        }
    }
}
