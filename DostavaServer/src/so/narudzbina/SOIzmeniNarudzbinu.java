/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narudzbina;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Narudzbina;
import domain.StavkaNarudzbine;
import so.AbstractSO;

/**
 *
 * @author Ана
 */
public class SOIzmeniNarudzbinu extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Narudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Narudzbina!");
        }

        Narudzbina narudzbina = (Narudzbina) ado;

        if (narudzbina.getStavkeNarudzbine().isEmpty()) {
            throw new Exception("Narudzbina mora imati barem jednu stavku!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        // updatujemo narudzbinu
        DBBroker.getInstance().update(ado);

        Narudzbina narudzbina = (Narudzbina) ado;
        // obrisemo stare stavke
        // u sledecoj liniji koda uzimamo prvu stavku koja ima ID nase narudzbine
        // cime se izvrsava naredba DELETE FROM STAVKANARUDZBINE WHERE NARUDZBINAID = nasID
        // cime se brisu SVE stavke nase narudzbine ODJEDNOM !!!
        DBBroker.getInstance().delete(narudzbina.getStavkeNarudzbine().get(0));
        
        // dodamo nove
        for (StavkaNarudzbine stavkaNarudzbine : narudzbina.getStavkeNarudzbine()) {
            DBBroker.getInstance().insert(stavkaNarudzbine);
        }

        // ovaj nacin nije optimalan, mogu da te pitaju sta ako imas 
        // milion stavki, onda bi milion brisala i milion novih dodavala
        // sto oduzima mnogo resursa
        // optimalan nacin je da imamo uvid u to (neki status) koja stavka je 
        // obrisana, koja izmenjena, koja dodata i te odredjene
        // da brisemo, menjamo i dodajemo
        // ali mi smo odradili na ovaj daleko laksi i brzi nacin
        // ako te pitaju za bolji nacin i zasto si ovako radila, samo ovo ispricas
    }

}
