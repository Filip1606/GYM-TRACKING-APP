/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Trening;
import domain.Vezba;

/**
 *
 * @author Filip
 */
public class ZapamtiTrening extends AbstractSO{

    public ZapamtiTrening() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.add((Trening) object);
        
        Trening trening = (Trening) object;
        
        for (Vezba vezba : trening.getVezbe()) {
            vezba.setIDTreninga(trening);
            databaseBroker.add(vezba);
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Trening)) {
            throw new Exception("Objekat nije validan");
        }
        
        Trening trening = (Trening) object;
        
        if (trening.getNaziv().isEmpty()) {
            throw new Exception("Naziv treninga je prazan");
        }
    }
    
}
