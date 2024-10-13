/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Clanstvo;
import domain.Sprava;

/**
 *
 * @author Filip
 */
public class ZapamtiSpravu extends AbstractSO{
    
    public ZapamtiSpravu() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.add((Sprava) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Sprava)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
