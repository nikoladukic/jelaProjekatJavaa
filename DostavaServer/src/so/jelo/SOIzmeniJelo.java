/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.jelo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Jelo;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Ана
 */
public class SOIzmeniJelo extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Jelo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Jelo!");
        }

        Jelo j = (Jelo) ado;

        if (j.getCena() < 100 || j.getCena() > 10000) {
            throw new Exception("Cena mora biti izmedju 100 i 10000 dinara!");
        }

        ArrayList<Jelo> jela = (ArrayList<Jelo>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Jelo jelo : jela) {
            if (!jelo.getJeloID().equals(j.getJeloID())) {
                if (jelo.getNazivJela().equals(j.getNazivJela())) {
                    throw new Exception("Jelo sa tim nazivom vec postoji!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
