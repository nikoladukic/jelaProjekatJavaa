/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.MenadzerRestorana;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Ана
 */
public class SOLogin extends AbstractSO {
    
    MenadzerRestorana ulogovani;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MenadzerRestorana)) {
            throw new Exception("Prosledjeni objekat nije instanca klase MenadzerRestorana!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        MenadzerRestorana mr = (MenadzerRestorana) ado;

        ArrayList<MenadzerRestorana> menadzeri
                = (ArrayList<MenadzerRestorana>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (MenadzerRestorana menadzer : menadzeri) {
            if (menadzer.getUsername().equals(mr.getUsername())
                    && menadzer.getPassword().equals(mr.getPassword())) {
                ulogovani = menadzer;
                return;
            }
        }

        throw new Exception("Ne postoji menadzer sa tim kredencijalima.");
        
    }

    public MenadzerRestorana getUlogovani() {
        return ulogovani;
    }
    
    

}
