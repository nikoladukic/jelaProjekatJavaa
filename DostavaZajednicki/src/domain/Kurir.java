/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ана
 */
public class Kurir extends AbstractDomainObject {

    private Long kurirID;
    private String imeKurira;
    private String prezimeKurira;
    private String kontakt;

    @Override
    public String toString() {
        return imeKurira + " " + prezimeKurira;
    }

    public Kurir(Long kurirID, String imeKurira, String prezimeKurira, String kontakt) {
        this.kurirID = kurirID;
        this.imeKurira = imeKurira;
        this.prezimeKurira = prezimeKurira;
        this.kontakt = kontakt;
    }

    public Kurir() {
    }

    @Override
    public String nazivTabele() {
        return " Kurir ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Kurir k = new Kurir(rs.getLong("KurirID"),
                    rs.getString("ImeKurira"), rs.getString("PrezimeKurira"),
                    rs.getString("Kontakt"));

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String uslov() {
        return " KurirID = " + kurirID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getKurirID() {
        return kurirID;
    }

    public void setKurirID(Long kurirID) {
        this.kurirID = kurirID;
    }

    public String getImeKurira() {
        return imeKurira;
    }

    public void setImeKurira(String imeKurira) {
        this.imeKurira = imeKurira;
    }

    public String getPrezimeKurira() {
        return prezimeKurira;
    }

    public void setPrezimeKurira(String prezimeKurira) {
        this.prezimeKurira = prezimeKurira;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

}
