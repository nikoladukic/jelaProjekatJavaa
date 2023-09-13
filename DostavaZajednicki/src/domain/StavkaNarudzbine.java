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
public class StavkaNarudzbine extends AbstractDomainObject {

    private Narudzbina narudzbina;
    private int rbStavke;
    private int kolicina;
    private double cenaStavke;
    private Jelo jelo;

    public StavkaNarudzbine() {
    }
    
    public StavkaNarudzbine(Narudzbina narudzbina, int rbStavke, int kolicina, double cenaStavke, Jelo jelo) {
        this.narudzbina = narudzbina;
        this.rbStavke = rbStavke;
        this.kolicina = kolicina;
        this.cenaStavke = cenaStavke;
        this.jelo = jelo;
    }

    @Override
    public String nazivTabele() {
        return " StavkaNarudzbine ";
    }

    @Override
    public String alijas() {
        return " sn ";
    }

    @Override
    public String join() {
        return " JOIN JELO J ON (J.JELOID = SN.JELOID) "
                + "JOIN NARUDZBINA N ON (N.NARUDZBINAID = SN.NARUDZBINAID) "
                + "JOIN KLIJENT KL ON (KL.KLIJENTID = N.KLIJENTID) "
                + "JOIN KURIR K ON (K.KURIRID = N.KURIRID) "
                + "JOIN MENADZERRESTORANA MR ON (MR.MENADZERID = N.MENADZERID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            MenadzerRestorana mr = new MenadzerRestorana(rs.getLong("menadzerID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Klijent kl = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("ImeKlijenta"), rs.getString("PrezimeKlijenta"),
                    rs.getString("Email"), rs.getString("Telefon"));

            Kurir k = new Kurir(rs.getLong("KurirID"),
                    rs.getString("ImeKurira"), rs.getString("PrezimeKurira"),
                    rs.getString("Kontakt"));

            Narudzbina n = new Narudzbina(rs.getLong("narudzbinaID"),
                    rs.getTimestamp("datumVreme"), rs.getDouble("ukupnaCena"),
                    kl, k, mr, null);

            Jelo j = new Jelo(rs.getLong("JeloID"),
                    rs.getString("NazivJela"), rs.getDouble("cena"),
                    rs.getString("opis"));

            StavkaNarudzbine stavkaNarudzbine = new StavkaNarudzbine(n, rs.getInt("rbStavke"),
                    rs.getInt("kolicina"), rs.getDouble("cena"), j);

            lista.add(stavkaNarudzbine);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (narudzbinaID, rbStavke, kolicina, cena, jeloID) ";
    }

    @Override
    public String uslov() {
        return " narudzbinaID = " + narudzbina.getNarudzbinaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + narudzbina.getNarudzbinaID() + ", " + rbStavke + ", " + kolicina + ", "
                + " " + cenaStavke + ", " + jelo.getJeloID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return " WHERE N.NARUDZBINAID = " + narudzbina.getNarudzbinaID();
    }

    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Narudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

}
