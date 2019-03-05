/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.racun;

import domain.Drzava;
import domain.Gost;
import forme.glavna.FrmMode;
import forme.gost.FrmPretragaGosta;
import forme.gost.FrmUnosGosta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import komunikacija.Komunikacija;
import kontroler.racun.KontrolerRacuna;
import org.jdesktop.swingx.JXDatePicker;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author marij
 */
public class FrmRacun extends javax.swing.JDialog {

    /**
     * Creates new form FrmRacun
     */
    KontrolerRacuna kontrolerR;
    public FrmRacun(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kontrolerR=new KontrolerRacuna();
        kontrolerR.srediFormu(this);
        popuniComboBox();
        popuniComboBoxGosti();
        setScreenCenter();

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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblJMBG = new javax.swing.JLabel();
        lblPozivnBroj = new javax.swing.JLabel();
        lblKontakt = new javax.swing.JLabel();
        lblDrzava = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtHotel = new javax.swing.JTextField();
        txtRacunId = new javax.swing.JTextField();
        txtZiroRacun = new javax.swing.JTextField();
        jdpDatum = new org.jdesktop.swingx.JXDatePicker();
        jLabel12 = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmbSmestajneJedinice = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jdpDolazak = new org.jdesktop.swingx.JXDatePicker();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jdpOdlazak = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        lblIznos = new javax.swing.JLabel();
        lblDin = new javax.swing.JLabel();
        lblUkupanIznos = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbGosti = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiranje racuna");

        jLabel1.setText("RacunId: ");

        jLabel3.setText("Ziro racun: ");

        jLabel5.setText("Datum:");

        jLabel7.setText("JMBG:");

        jLabel8.setText("Pozivni broj: ");

        jLabel9.setText("Kontakt: ");

        jLabel10.setText("Drzava: ");

        jLabel11.setText("Naziv hotela: ");

        txtHotel.setEditable(false);
        txtHotel.setText("\"Hotel 123\"");

        txtRacunId.setEditable(false);
        txtRacunId.setEnabled(false);

        jdpDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdpDatumActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Sitka Subheading", 3, 24)); // NOI18N
        jLabel12.setText("Iznos: ");

        btnSacuvaj.setText("Sacuvaj ");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavka racuna"));

        jLabel14.setText("Smestajna jedinica: ");

        cmbSmestajneJedinice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Dolazak: ");

        jdpDolazak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdpDolazakActionPerformed(evt);
            }
        });

        jButton2.setText("Izbrisi stavku");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Dodaj stavku");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tblStavke);

        jLabel16.setText("Odlazak:");

        jdpOdlazak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdpOdlazakActionPerformed(evt);
            }
        });

        jLabel6.setText("Iznos: ");

        lblIznos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIznos.setText("1000");

        lblDin.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDin.setText("jLabel17");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSmestajneJedinice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdpDolazak, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblIznos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDin)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(jdpOdlazak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbSmestajneJedinice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jdpDolazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(jdpOdlazak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(lblDin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblUkupanIznos.setFont(new java.awt.Font("Sitka Subheading", 1, 24)); // NOI18N
        lblUkupanIznos.setText("jLabel17");

        jLabel18.setText("Gost: ");

        cmbGosti.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGostiItemStateChanged(evt);
            }
        });
        cmbGosti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGostiActionPerformed(evt);
            }
        });

        jLabel4.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(28, 28, 28)
                                            .addComponent(txtRacunId, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jdpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtZiroRacun, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(155, 155, 155)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPozivnBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblKontakt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDrzava, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbGosti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblID)
                                            .addComponent(lblJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(432, 558, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnOdustani)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSacuvaj))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblUkupanIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtRacunId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(cmbGosti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lblID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(lblJMBG)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtZiroRacun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblPozivnBroj)
                            .addComponent(jLabel5)
                            .addComponent(jdpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblKontakt))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblDrzava))
                .addGap(44, 44, 44)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUkupanIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdustani)
                    .addComponent(btnSacuvaj))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            kontrolerR.izbrisiIzTabele(this);
        } catch (Exception ex) {
            Logger.getLogger(FrmRacun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jdpDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdpDatumActionPerformed
        kontrolerR.azuriraj(this);
        kontrolerR.azurirajRacunId(this);
    }//GEN-LAST:event_jdpDatumActionPerformed

    private void jdpDolazakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdpDolazakActionPerformed
     kontrolerR.azurirajIznos(this);
    }//GEN-LAST:event_jdpDolazakActionPerformed

    private void jdpOdlazakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdpOdlazakActionPerformed
        kontrolerR.azurirajIznos(this);
    }//GEN-LAST:event_jdpOdlazakActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     boolean ispravno= kontrolerR.validirajDatum(this);
     if(ispravno){
        kontrolerR.dodajStavku(this);}
     else{
                  JOptionPane.showMessageDialog(this, "Nepravilno uneti datumi boravka.");
     return;}
       //kontrolerR.azurirajUkupanIznos(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void cmbGostiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGostiItemStateChanged
      kontrolerR.podesiPodatkeGost(this);
      kontrolerR.azurirajRacunId(this);
    }//GEN-LAST:event_cmbGostiItemStateChanged

    private void cmbGostiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGostiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGostiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
       kontrolerR.sacuvajRacun(this);
    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRacun dialog = new FrmRacun(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JLabel getLblID() {
        return lblID;
    }

   
    public JButton getBtnOdustani() {
        return btnOdustani;
    }

    public void setBtnOdustani(JButton btnOdustani) {
        this.btnOdustani = btnOdustani;
    }

    public JTextField getTxtRacunId() {
        return txtRacunId;
    }

    public JComboBox getCmbGosti() {
        return cmbGosti;
    }

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public JLabel getLblUkupanIznos() {
        return lblUkupanIznos;
    }

    public void setBtnSacuvaj(JButton btnSacuvaj) {
        this.btnSacuvaj = btnSacuvaj;
    }

    public JTextField getTxtZiroRacun() {
        return txtZiroRacun;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setLblIznos(JLabel lblIznos) {
        this.lblIznos = lblIznos;
    }

    public JLabel getLblIznos() {
        return lblIznos;
    }

    public JComboBox getCmbSmestajneJedinice() {
        return cmbSmestajneJedinice;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTextField getjTextField1() {
        return txtRacunId;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.txtRacunId = jTextField1;
    }

  

    public JLabel getLblDin() {
        return lblDin;
    }

    public JXDatePicker getJdpOdlazak() {
        return jdpOdlazak;
    }

    public JXDatePicker getJdpDolazak() {
        return jdpDolazak;
    }

  

    public JTextField getjTextField3() {
        return txtZiroRacun;
    }

   

    public void setjTextField3(JTextField jTextField3) {
        this.txtZiroRacun = jTextField3;
    }

    public JLabel getLblDrzava() {
        return lblDrzava;
    }

    public void setLblDrzava(JLabel lblDrzava) {
        this.lblDrzava = lblDrzava;
    }

//    public JLabel getLblImePrezime() {
//        return lblImePrezime;
//    }
//
//    public void setLblImePrezime(JLabel lblImePrezime) {
//        this.lblImePrezime = lblImePrezime;
//    }

    public JLabel getLblJMBG() {
        return lblJMBG;
    }

    public void setLblJMBG(JLabel lblJMBG) {
        this.lblJMBG = lblJMBG;
    }

    public JLabel getLblKontakt() {
        return lblKontakt;
    }

    public void setLblKontakt(JLabel lblKontakt) {
        this.lblKontakt = lblKontakt;
    }

    public JLabel getLblPozivnBroj() {
        return lblPozivnBroj;
    }

    public void setLblPozivnBroj(JLabel lblPozivnBroj) {
        this.lblPozivnBroj = lblPozivnBroj;
    }

    public JTable getTblStavke() {
        return tblStavke;
    }

    public void setTblStavke(JTable tblStavke) {
        this.tblStavke = tblStavke;
    }

    public JTextField getTxtHotel() {
        return txtHotel;
    }

    public void setTxtHotel(JTextField txtHotel) {
        this.txtHotel = txtHotel;
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbGosti;
    private javax.swing.JComboBox cmbSmestajneJedinice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXDatePicker jdpDatum;
    private org.jdesktop.swingx.JXDatePicker jdpDolazak;
    private org.jdesktop.swingx.JXDatePicker jdpOdlazak;
    private javax.swing.JLabel lblDin;
    private javax.swing.JLabel lblDrzava;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIznos;
    private javax.swing.JLabel lblJMBG;
    private javax.swing.JLabel lblKontakt;
    private javax.swing.JLabel lblPozivnBroj;
    private javax.swing.JLabel lblUkupanIznos;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtHotel;
    private javax.swing.JTextField txtRacunId;
    private javax.swing.JTextField txtZiroRacun;
    // End of variables declaration//GEN-END:variables

    public JXDatePicker getJdpDatum() {
        return jdpDatum;
    }

    private void popuniComboBox() {
   
        Zahtev zahtev= new Zahtev();
        zahtev.setOperation(Operacija.UCITAJ_SVE_SJEDINICE);
        try {
            Komunikacija.getInstance().posaljiZahtev(zahtev);
        
        Odgovor odg=Komunikacija.getInstance().primiOdgovor();
       
        if(odg.getStatus()==StatusOdgovora.ERROR){
            throw new Exception(odg.getPoruka());
        }
        cmbSmestajneJedinice.setModel(new DefaultComboBoxModel(((List<Drzava>)odg.getData()).toArray()));
         cmbSmestajneJedinice.setSelectedItem(null);
         } catch (Exception ex) {
            Logger.getLogger(FrmUnosGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniComboBoxGosti() {
       
        Zahtev zahtev= new Zahtev();
        zahtev.setOperation(Operacija.UCITAJ_SVE_GOSTE);
        try {
            Komunikacija.getInstance().posaljiZahtev(zahtev);
        
        Odgovor odg=Komunikacija.getInstance().primiOdgovor();
       
        if(odg.getStatus()==StatusOdgovora.ERROR){
            throw new Exception(odg.getPoruka());
        }
        cmbGosti.setModel(new DefaultComboBoxModel(((List<Gost>)odg.getData()).toArray()));
         cmbGosti.setSelectedItem(null);
         } catch (Exception ex) {
            Logger.getLogger(FrmUnosGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void setScreenCenter() {
        setLocationRelativeTo(null);
    }
 }


    

