/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kurir;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Kurir;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Ана
 */
public class SOVratiSveKurire extends AbstractSO {

    private ArrayList<Kurir> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Kurir)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kurir!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> kuriri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Kurir>) (ArrayList<?>) kuriri;
    }

    public ArrayList<Kurir> getLista() {
        return lista;
    }

}
