/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import controller.ServerController;
import domain.Jelo;
import domain.MenadzerRestorana;
import domain.Narudzbina;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Ана
 */
public class NitKlijent extends Thread {

    private Socket socket;

    NitKlijent(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.ADD_JELO:
                    ServerController.getInstance().addJelo((Jelo) request.getData());
                    break;
                case Operation.ADD_NARUDZBINA:
                    ServerController.getInstance().addNarudzbina((Narudzbina) request.getData());
                    break;
                case Operation.DELETE_JELO:
                    ServerController.getInstance().deleteJelo((Jelo) request.getData());
                    break;
                case Operation.DELETE_NARUDZBINA:
                    ServerController.getInstance().deleteNarudzbina((Narudzbina) request.getData());
                    break;
                case Operation.UPDATE_JELO:
                    ServerController.getInstance().updateJelo((Jelo) request.getData());
                    break;
                case Operation.UPDATE_NARUDZBINA:
                    ServerController.getInstance().updateNarudzbina((Narudzbina) request.getData());
                    break;
                case Operation.GET_ALL_JELO:
                    response.setData(ServerController.getInstance().getAllJelo());
                    break;
                case Operation.GET_ALL_KLIJENT:
                    response.setData(ServerController.getInstance().getAllKlijent());
                    break;
                case Operation.GET_ALL_KURIR:
                    response.setData(ServerController.getInstance().getAllKurir());
                    break;
                case Operation.GET_ALL_NARUDZBINA:
                    response.setData(ServerController.getInstance().getAllNarudzbina());
                    break;
                case Operation.GET_ALL_STAVKA_NARUDZBINE:
                    response.setData(ServerController.getInstance().getAllStavkaNarudzbine((Narudzbina) request.getData()));
                    break;
                case Operation.LOGIN:
                    MenadzerRestorana menadzer = (MenadzerRestorana) request.getData();
                    MenadzerRestorana ulogovani = ServerController.getInstance().login(menadzer);
                    response.setData(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
