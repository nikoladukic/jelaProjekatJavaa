/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.KlijentController;
import domain.Narudzbina;
import domain.StavkaNarudzbine;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ана
 */
public class TableModelStavke extends AbstractTableModel {

    private ArrayList<StavkaNarudzbine> lista;
    private String[] kolone = {"Rb", "Jelo", "Kolicina", "Cena"};
    private int rb = 0;

    public TableModelStavke() {
        lista = new ArrayList<>();
    }

    public TableModelStavke(Narudzbina n) {
        try {
            lista = KlijentController.getInstance().getAllStavkaNarudzbine(n);
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        StavkaNarudzbine sn = lista.get(row);

        switch (column) {
            case 0:
                return sn.getRbStavke();
            case 1:
                return sn.getJelo().getNazivJela();
            case 2:
                return sn.getKolicina();
            case 3:
                return sn.getCenaStavke() + "din";

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaNarudzbine sn) {

        for (StavkaNarudzbine stavkaNarudzbine : lista) {
            if (stavkaNarudzbine.getJelo().getJeloID().equals(sn.getJelo().getJeloID())) {
                stavkaNarudzbine.setKolicina(stavkaNarudzbine.getKolicina() + sn.getKolicina());
                stavkaNarudzbine.setCenaStavke(stavkaNarudzbine.getCenaStavke() + sn.getCenaStavke());
                fireTableDataChanged();
                return;
            }
        }

        rb = lista.size();
        sn.setRbStavke(++rb);
        lista.add(sn);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);

        rb = 0;
        for (StavkaNarudzbine stavkaNarudzbine : lista) {
            stavkaNarudzbine.setRbStavke(++rb);
        }

        fireTableDataChanged();
    }

    public double vratiUkupnuCenu() {
        double ukupnaCena = 0;
        
        for (StavkaNarudzbine stavkaNarudzbine : lista) {
            ukupnaCena += stavkaNarudzbine.getCenaStavke();
        }
        
        return ukupnaCena;
    }

    public ArrayList<StavkaNarudzbine> getLista() {
        return lista;
    }

}
