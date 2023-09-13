/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.KlijentController;
import domain.Narudzbina;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ана
 */
public class TableModelNarudzbine extends AbstractTableModel implements Runnable {

    private ArrayList<Narudzbina> lista;
    private String[] kolone = {"ID", "Klijent", "Kurir", "Datum", "Ukupna cena"};
    private String parametar = "";

    public TableModelNarudzbine() {
        try {
            lista = KlijentController.getInstance().getAllNarudzbina();
        } catch (Exception ex) {
            Logger.getLogger(TableModelNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
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
        Narudzbina n = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (column) {
            case 0:
                return n.getNarudzbinaID();
            case 1:
                return n.getKlijent();
            case 2:
                return n.getKurir();
            case 3:
                return sdf.format(n.getDatumVreme());
            case 4:
                return n.getUkupnaCena() + "din";

            default:
                return null;
        }
    }

    public Narudzbina getSelectedNarudzbina(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentController.getInstance().getAllNarudzbina();
            if (!parametar.equals("")) {
                ArrayList<Narudzbina> novaLista = new ArrayList<>();
                for (Narudzbina n : lista) {
                    if (n.getKlijent().getImeKlijenta()
                            .toLowerCase().contains(parametar.toLowerCase())
                            || n.getKlijent().getPrezimeKlijenta()
                                    .toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(n);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
