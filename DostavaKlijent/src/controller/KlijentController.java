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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Ана
 */
public class KlijentController {

    private static KlijentController instance;

    private KlijentController() {
    }

    public static KlijentController getInstance() {
        if (instance == null) {
            instance = new KlijentController();
        }
        return instance;
    }

    public MenadzerRestorana login(MenadzerRestorana menadzer) throws Exception {
        return (MenadzerRestorana) sendRequest(Operation.LOGIN, menadzer);
    }

    public void addJelo(Jelo jelo) throws Exception {
        sendRequest(Operation.ADD_JELO, jelo);
    }

    public void addNarudzbina(Narudzbina narudzbina) throws Exception {
        sendRequest(Operation.ADD_NARUDZBINA, narudzbina);
    }

    public void deleteJelo(Jelo jelo) throws Exception {
        sendRequest(Operation.DELETE_JELO, jelo);
    }

    public void deleteNarudzbina(Narudzbina narudzbina) throws Exception {
        sendRequest(Operation.DELETE_NARUDZBINA, narudzbina);
    }

    public void updateJelo(Jelo jelo) throws Exception {
        sendRequest(Operation.UPDATE_JELO, jelo);
    }

    public void updateNarudzbina(Narudzbina narudzbina) throws Exception {
        sendRequest(Operation.UPDATE_NARUDZBINA, narudzbina);
    }

    public ArrayList<Jelo> getAllJelo() throws Exception {
        return (ArrayList<Jelo>) sendRequest(Operation.GET_ALL_JELO, null);
    }

    public ArrayList<Narudzbina> getAllNarudzbina() throws Exception {
        return (ArrayList<Narudzbina>) sendRequest(Operation.GET_ALL_NARUDZBINA, null);
    }

    public ArrayList<Kurir> getAllKurir() throws Exception {
        return (ArrayList<Kurir>) sendRequest(Operation.GET_ALL_KURIR, null);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        return (ArrayList<Klijent>) sendRequest(Operation.GET_ALL_KLIJENT, null);
    }

    public ArrayList<StavkaNarudzbine> getAllStavkaNarudzbine(Narudzbina n) throws Exception {
        return (ArrayList<StavkaNarudzbine>) sendRequest(Operation.GET_ALL_STAVKA_NARUDZBINE, n);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }
}
