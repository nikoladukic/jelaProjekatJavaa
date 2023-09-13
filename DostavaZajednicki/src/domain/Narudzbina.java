/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ана
 */
public class Narudzbina extends AbstractDomainObject {

    private Long narudzbinaID;
    private Date datumVreme;
    private double ukupnaCena;
    private Klijent klijent;
    private Kurir kurir;
    private MenadzerRestorana menadzerRestorana;
    private ArrayList<StavkaNarudzbine> stavkeNarudzbine;

    public Narudzbina() {
    }

    public Narudzbina(Long narudzbinaID, Date datumVreme, double ukupnaCena, Klijent klijent, Kurir kurir, 
            MenadzerRestorana menadzerRestorana, ArrayList<StavkaNarudzbine> stavkeNarudzbine) {
        this.narudzbinaID = narudzbinaID;
        this.datumVreme = datumVreme;
        this.ukupnaCena = ukupnaCena;
        this.klijent = klijent;
        this.kurir = kurir;
        this.menadzerRestorana = menadzerRestorana;
        this.stavkeNarudzbine = stavkeNarudzbine;
    }

    @Override
    public String nazivTabele() {
        return " Narudzbina ";
    }

    @Override
    public String alijas() {
        return " n ";
    }

    @Override
    public String join() {
        return " JOIN KLIJENT KL ON (KL.KLIJENTID = N.KLIJENTID) "
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

            lista.add(n);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (datumVreme, ukupnaCena, klijentID, kurirID, menadzerID) ";
    }

    @Override
    public String uslov() {
        return " narudzbinaID = " + narudzbinaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', " + ukupnaCena + ", "
                + " " + klijent.getKlijentID() + ", "
                + " " + kurir.getKurirID() + ", " + menadzerRestorana.getMenadzerID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " ukupnaCena = " + ukupnaCena + ", kurirID = " + kurir.getKurirID() + " ";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getNarudzbinaID() {
        return narudzbinaID;
    }

    public void setNarudzbinaID(Long narudzbinaID) {
        this.narudzbinaID = narudzbinaID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Kurir getKurir() {
        return kurir;
    }

    public void setKurir(Kurir kurir) {
        this.kurir = kurir;
    }

    public MenadzerRestorana getMenadzerRestorana() {
        return menadzerRestorana;
    }

    public void setMenadzerRestorana(MenadzerRestorana menadzerRestorana) {
        this.menadzerRestorana = menadzerRestorana;
    }

    public ArrayList<StavkaNarudzbine> getStavkeNarudzbine() {
        return stavkeNarudzbine;
    }

    public void setStavkeNarudzbine(ArrayList<StavkaNarudzbine> stavkeNarudzbine) {
        this.stavkeNarudzbine = stavkeNarudzbine;
    }

}
