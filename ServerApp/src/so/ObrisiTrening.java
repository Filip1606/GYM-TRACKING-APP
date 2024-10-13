/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Trening;

/**
 *
 * @author Filip
 */
public class ObrisiTrening extends AbstractSO{

    public ObrisiTrening() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.delete((Trening) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Trening)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
