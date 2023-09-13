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
public class SOVratiSvaJela extends AbstractSO {

    private ArrayList<Jelo> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Jelo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Jelo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> jela = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Jelo>) (ArrayList<?>) jela;
    }

    public ArrayList<Jelo> getLista() {
        return lista;
    }

    public ArrayList<Jelo> templateExecute() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
