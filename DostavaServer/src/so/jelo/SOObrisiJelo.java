/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.jelo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Jelo;
import so.AbstractSO;

/**
 *
 * @author Ана
 */
public class SOObrisiJelo extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Jelo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Jelo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
