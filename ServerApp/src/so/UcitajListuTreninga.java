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
public class UcitajListuTreninga extends AbstractSO{

    private List<Trening> treninzi;

    public UcitajListuTreninga() throws Exception {
        super();
    }

    public List<Trening> getTreninzi() {
        return treninzi;
    }
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.getAllWithInnerJoin((DomainObject) object);
        treninzi = new ArrayList<>();
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Trening) {
                treninzi.add((Trening) domainObject);
            }
        }
        if (treninzi.isEmpty()) {
            throw new Exception("Treninzi ne postoje");
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Trening)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
