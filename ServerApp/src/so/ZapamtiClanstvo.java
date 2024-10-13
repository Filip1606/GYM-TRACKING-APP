/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Clanstvo;

/**
 *
 * @author Filip
 */
public class ZapamtiClanstvo extends AbstractSO{

    public ZapamtiClanstvo() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.add((Clanstvo) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Clanstvo)) {
            throw new Exception("Objekat nije validan");
        }
    }
    
}
