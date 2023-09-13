/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.KlijentController;
import domain.Jelo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ана
 */
public class TableModelJela extends AbstractTableModel implements Runnable {

    private ArrayList<Jelo> lista;
    private String[] kolone = {"ID", "Naziv", "Cena"};
    private String parametar = "";

    public TableModelJela() {
        try {
            lista = KlijentController.getInstance().getAllJelo();
        } catch (Exception ex) {
            Logger.getLogger(TableModelJela.class.getName()).log(Level.SEVERE, null, ex);
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
        Jelo j = lista.get(row);

        switch (column) {
            case 0:
                return j.getJeloID();
            case 1:
                return j.getNazivJela();
            case 2:
                return j.getCena() + "din";

            default:
                return null;
        }
    }

    public Jelo getSelectedJelo(int row) {
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
            Logger.getLogger(TableModelJela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentController.getInstance().getAllJelo();
            if (!parametar.equals("")) {
                ArrayList<Jelo> novaLista = new ArrayList<>();
                for (Jelo j : lista) {
                    if (j.getNazivJela().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(j);
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
