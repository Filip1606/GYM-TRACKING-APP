/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Trening;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class NadjiTreninge extends AbstractSO{

    private List<Trening> treninzi;

    public List<Trening> getTreninzi() {
        return treninzi;
    }
    
    public NadjiTreninge() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.search((DomainObject) object);
        treninzi = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Trening) {
                treninzi.add((Trening) domainObject);
            }
        }
        if (treninzi.isEmpty()) {
            throw new Exception("Treninzi ne postoje.");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Trening)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
