/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Jelo;
import domain.Klijent;
import domain.Kurir;
import domain.MenadzerRestorana;
import domain.Narudzbina;
import domain.StavkaNarudzbine;
import java.util.ArrayList;
import so.jelo.SOKreirajJelo;
import so.jelo.SOObrisiJelo;
import so.jelo.SOVratiSvaJela;
import so.jelo.SOIzmeniJelo;
import so.klijent.SOVratiSveKlijente;
import so.kurir.SOVratiSveKurire;
import so.login.SOLogin;
import so.narudzbina.SOKreirajNarudzbinu;
import so.narudzbina.SOObrisiNarudzbinu;
import so.narudzbina.SOVratiSveNarudzbine;
import so.narudzbina.SOIzmeniNarudzbinu;
import so.stavkaNarudzbine.SOVratiSveStavkeNarudzbine;

/**
 *
 * @author Ана
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public MenadzerRestorana login(MenadzerRestorana menadzerRestorana) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(menadzerRestorana);
        return so.getUlogovani();
    }

    public void addJelo(Jelo jelo) throws Exception {
        (new SOKreirajJelo()).templateExecute(jelo);
    }

    public void addNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SOKreirajNarudzbinu()).templateExecute(narudzbina);
    }

    public void deleteJelo(Jelo jelo) throws Exception {
        (new SOObrisiJelo()).templateExecute(jelo);
    }

    public void deleteNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SOObrisiNarudzbinu()).templateExecute(narudzbina);
    }

    public void updateJelo(Jelo jelo) throws Exception {
        (new SOIzmeniJelo()).templateExecute(jelo);
    }

    public void updateNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SOIzmeniNarudzbinu()).templateExecute(narudzbina);
    }

    public ArrayList<Jelo> getAllJelo() throws Exception {
        SOVratiSvaJela so = new SOVratiSvaJela();
        so.templateExecute(new Jelo());
        return so.getLista();
    }

    public ArrayList<Narudzbina> getAllNarudzbina() throws Exception {
        SOVratiSveNarudzbine so = new SOVratiSveNarudzbine();
        so.templateExecute(new Narudzbina());
        return so.getLista();
    }

    public ArrayList<Kurir> getAllKurir() throws Exception {
        SOVratiSveKurire so = new SOVratiSveKurire();
        so.templateExecute(new Kurir());
        return so.getLista();
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOVratiSveKlijente so = new SOVratiSveKlijente();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<StavkaNarudzbine> getAllStavkaNarudzbine(Narudzbina n) throws Exception {
        SOVratiSveStavkeNarudzbine so = new SOVratiSveStavkeNarudzbine();
        
        StavkaNarudzbine sn = new StavkaNarudzbine();
        sn.setNarudzbina(n);
        
        so.templateExecute(sn);
        return so.getLista();
    }

}
