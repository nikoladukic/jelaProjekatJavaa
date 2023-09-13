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
public class Jelo extends AbstractDomainObject {

    private Long jeloID;
    private String nazivJela;
    private double cena;
    private String opis;
    
    @Override
    public String toString() {
        return nazivJela + " (Cena: " + cena + "din)";
    }

    public Jelo(Long jeloID, String nazivJela, double cena, String opis) {
        this.jeloID = jeloID;
        this.nazivJela = nazivJela;
        this.cena = cena;
        this.opis = opis;
    }

    public Jelo() {
    }
    
    @Override
    public String nazivTabele() {
        return " Jelo ";
    }

    @Override
    public String alijas() {
        return " j ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Jelo j = new Jelo(rs.getLong("JeloID"),
                    rs.getString("NazivJela"), rs.getDouble("cena"),
                    rs.getString("opis"));

            lista.add(j);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivJela, cena, opis) ";
    }

    @Override
    public String uslov() {
        return " JeloID = " + jeloID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivJela + "', " + cena + ", "
                + "'" + opis + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivJela = '" + nazivJela + "', cena = " + cena + ", "
                + "opis = '" + opis + "' ";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getJeloID() {
        return jeloID;
    }

    public void setJeloID(Long jeloID) {
        this.jeloID = jeloID;
    }

    public String getNazivJela() {
        return nazivJela;
    }

    public void setNazivJela(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}
