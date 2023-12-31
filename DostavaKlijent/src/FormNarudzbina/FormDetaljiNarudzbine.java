/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormNarudzbina;

import controller.KlijentController;
import domain.Jelo;
import domain.Kurir;
import domain.Narudzbina;
import domain.StavkaNarudzbine;
import forme.MainForm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import models.TableModelStavke;

/**
 *
 * @author Ана
 */
public class FormDetaljiNarudzbine extends javax.swing.JDialog {
    
    private Narudzbina n;
    private double ukupnaCena;
    
    public FormDetaljiNarudzbine(JDialog parent, boolean modal, Narudzbina n) {
        super(parent, modal);
        initComponents();
        this.n = n;
        setLocationRelativeTo(null);
        setTitle("Detalji narudzbine");
        popuniKurire();
        popuniJela();
        cmbKlijent.setEnabled(false);
        cmbKlijent.getModel().setSelectedItem(n.getKlijent());
        cmbKurir.getModel().setSelectedItem(n.getKurir());
        ukupnaCena = n.getUkupnaCena();
        lblUkupnaCena.setText(String.valueOf(ukupnaCena) + "din");
        tblStavke.setModel(new TableModelStavke(n));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String datumVreme = sdf.format(n.getDatumVreme());
        
        if (!datumVreme.equals(sdf.format(new Date()))) {
            cmbKurir.setEnabled(false);
            cmbJelo.setEnabled(false);
            btnDodaj.setEnabled(false);
            btnObrisi.setEnabled(false);
            btnObrisiStavku.setEnabled(false);
            btnIzmeni.setEnabled(false);
            txtKolicina.setEditable(false);
            JOptionPane.showMessageDialog(this, "Ova narudzbina je isporucena!");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbJelo = new javax.swing.JComboBox();
        txtKolicina = new javax.swing.JTextField();
        txtCenaStavke = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblUkupnaCena = new javax.swing.JLabel();
        cmbKurir = new javax.swing.JComboBox();
        cmbKlijent = new javax.swing.JComboBox();
        btnZatvori = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos narudzbine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(153, 0, 153))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Kurir:");

        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("Klijent:");

        jPanel2.setBackground(new java.awt.Color(204, 0, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos stavki narudzbine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jelo:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kolicina:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cena stavke:");

        cmbJelo.setBackground(new java.awt.Color(255, 204, 255));
        cmbJelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbJelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbJeloItemStateChanged(evt);
            }
        });

        txtKolicina.setBackground(new java.awt.Color(255, 204, 255));
        txtKolicina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKolicinaKeyReleased(evt);
            }
        });

        txtCenaStavke.setBackground(new java.awt.Color(255, 204, 255));

        btnDodaj.setBackground(new java.awt.Color(255, 204, 255));
        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(153, 0, 153));
        btnDodaj.setText("Dodaj stavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisiStavku.setBackground(new java.awt.Color(255, 204, 255));
        btnObrisiStavku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisiStavku.setForeground(new java.awt.Color(153, 0, 153));
        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        tblStavke.setBackground(new java.awt.Color(255, 204, 255));
        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavke);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbJelo, 0, 377, Short.MAX_VALUE)
                    .addComponent(txtKolicina)
                    .addComponent(txtCenaStavke))
                .addGap(58, 58, 58)
                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbJelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCenaStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisiStavku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jLabel3.setText("Ukupna cena:");

        lblUkupnaCena.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblUkupnaCena.setText("0.00din");

        cmbKurir.setBackground(new java.awt.Color(204, 0, 204));
        cmbKurir.setForeground(new java.awt.Color(255, 255, 255));
        cmbKurir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbKlijent.setBackground(new java.awt.Color(204, 0, 204));
        cmbKlijent.setForeground(new java.awt.Color(255, 255, 255));
        cmbKlijent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnZatvori.setBackground(new java.awt.Color(204, 0, 204));
        btnZatvori.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnZatvori.setForeground(new java.awt.Color(255, 255, 255));
        btnZatvori.setText("Zatvori");
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnObrisi.setBackground(new java.awt.Color(204, 0, 204));
        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnObrisi.setForeground(new java.awt.Color(255, 255, 255));
        btnObrisi.setText("Obrisi narudzbinu");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setBackground(new java.awt.Color(204, 0, 204));
        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIzmeni.setForeground(new java.awt.Color(255, 255, 255));
        btnIzmeni.setText("Izmeni narudzbinu");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(lblUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbKurir, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnIzmeni, btnObrisi, btnZatvori});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKurir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblUkupnaCena))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnIzmeni, btnObrisi, btnZatvori});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "obrisete ovu narudzbinu?", "Konfirmacija", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.NO_OPTION) {
            return;
        }
        
        if (result == JOptionPane.YES_OPTION) {
            try {
                KlijentController.getInstance().deleteNarudzbina(n);
                FormPretragaNarudzbine fp = (FormPretragaNarudzbine) getParent();
                fp.refreshTable();
                JOptionPane.showMessageDialog(this, "Uspesno obrisana narudzbina.");
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(FormDetaljiNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        
        try {
            
            Kurir kurir = (Kurir) cmbKurir.getSelectedItem();
            TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
            
            n.setKurir(kurir);
            n.setUkupnaCena(ukupnaCena);
            n.setStavkeNarudzbine(tm.getLista());
            
            KlijentController.getInstance().updateNarudzbina(n);
            FormPretragaNarudzbine fp = (FormPretragaNarudzbine) getParent();
            fp.refreshTable();
            JOptionPane.showMessageDialog(this, "Uspesno izmenjena narudzbina.");
            this.dispose();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(FormDetaljiNarudzbine.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void cmbJeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbJeloItemStateChanged
        
        if (cmbJelo.getSelectedItem() != null) {
            if (txtKolicina.getText().isEmpty()) {
                txtCenaStavke.setText("");
                return;
            }
            
            Jelo j = (Jelo) cmbJelo.getSelectedItem();
            int kolicina = Integer.parseInt(txtKolicina.getText());
            
            if (kolicina == 0) {
                txtKolicina.setText("");
                txtCenaStavke.setText("");
                return;
            }
            
            txtCenaStavke.setText(String.valueOf(j.getCena() * kolicina));
        }
    }//GEN-LAST:event_cmbJeloItemStateChanged

    private void txtKolicinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKolicinaKeyReleased
        
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            
            if (txtKolicina.getText().isEmpty()) {
                txtCenaStavke.setText("");
                return;
            }
            
            Jelo j = (Jelo) cmbJelo.getSelectedItem();
            int kolicina = Integer.parseInt(txtKolicina.getText());
            
            if (kolicina == 0) {
                txtKolicina.setText("");
                txtCenaStavke.setText("");
                return;
            }
            
            txtCenaStavke.setText(String.valueOf(j.getCena() * kolicina));
            
        } else {
            txtKolicina.setText("");
            txtCenaStavke.setText("");
        }
    }//GEN-LAST:event_txtKolicinaKeyReleased

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        
        if (txtKolicina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti kolicinu!");
            return;
        }
        
        Jelo j = (Jelo) cmbJelo.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        double cenaStavke = Double.parseDouble(txtCenaStavke.getText());
        
        StavkaNarudzbine sn = new StavkaNarudzbine(n, -1, kolicina, cenaStavke, j);
        
        TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
        tm.dodajStavku(sn);
        
        ukupnaCena = tm.vratiUkupnuCenu();
        
        lblUkupnaCena.setText(String.valueOf(ukupnaCena) + "din");
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed
        
        int row = tblStavke.getSelectedRow();
        
        if (row >= 0) {
            TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
            tm.obrisiStavku(row);
            
            ukupnaCena = tm.vratiUkupnuCenu();
            
            lblUkupnaCena.setText(String.valueOf(ukupnaCena) + "din");
        }
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JComboBox cmbJelo;
    private javax.swing.JComboBox cmbKlijent;
    private javax.swing.JComboBox cmbKurir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUkupnaCena;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtCenaStavke;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables

    private void popuniKurire() {
        try {
            ArrayList<Kurir> kuriri = KlijentController.getInstance().getAllKurir();
            
            cmbKurir.removeAllItems();
            
            for (Kurir kurir : kuriri) {
                cmbKurir.addItem(kurir);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void popuniJela() {
        try {
            ArrayList<Jelo> jela = KlijentController.getInstance().getAllJelo();
            
            cmbJelo.removeAllItems();
            
            for (Jelo jelo : jela) {
                cmbJelo.addItem(jelo);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
