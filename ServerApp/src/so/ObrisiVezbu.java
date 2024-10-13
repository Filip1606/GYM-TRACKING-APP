/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Vezba;

/**
 *
 * @author Filip
 */
public class ObrisiVezbu extends AbstractSO{

    public ObrisiVezbu() throws Exception {
        super();
    }
    
    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.delete((Vezba) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Vezba)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
