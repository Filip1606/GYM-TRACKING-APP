/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui.form;

import domain.Sprava;
import domain.Trening;
import domain.Vezba;
import java.awt.Frame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import table.model.TableModelVezba;
import ui.controller.Controller;

/**
 *
 * @author Filip
 */
public class FrmKreirajVezbu extends javax.swing.JDialog {

    private JTable tbl;
    
    /**
     * Creates new form FrmKreirajVezbu
     */
    public FrmKreirajVezbu(java.awt.Frame parent, boolean modal, JTable tbl) {
        super(parent, modal);
        initComponents();
        this.tbl = tbl;
        setLocationRelativeTo(null);
        setTitle("Kreiranje nove vežbe");
        napuniCmb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtPonavljanja = new javax.swing.JTextField();
        txtTezina = new javax.swing.JTextField();
        cmbSprava = new javax.swing.JComboBox();
        btnSacuvaj = new javax.swing.JButton();
        btnNovaSprava = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv:");

        jLabel2.setText("Broj ponavljanja:");

        jLabel3.setText("Težina (kg):");

        jLabel4.setText("Sprava:");

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSacuvaj.setForeground(new java.awt.Color(255, 255, 255));
        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnNovaSprava.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovaSprava.setText("Kreiraj novu spravu");
        btnNovaSprava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaSpravaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNaziv)
                            .addComponent(txtPonavljanja)
                            .addComponent(txtTezina, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(cmbSprava, 0, 173, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnNovaSprava))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnSacuvaj)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPonavljanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTezina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSprava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaSprava))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnSacuvaj)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        String naziv = txtNaziv.getText();
        String ponavljanja = txtPonavljanja.getText();
        String tezina = txtTezina.getText();
        Sprava IDSprave = (Sprava) cmbSprava.getSelectedItem();
        if (validate(naziv, ponavljanja, tezina, cmbSprava)) {
                Vezba vezba = new Vezba();
                vezba.setNaziv(naziv);
                vezba.setPonavljanja(Integer.parseInt(ponavljanja));
                vezba.setTezina(Integer.parseInt(tezina));
                Sprava s = (Sprava) cmbSprava.getSelectedItem();
                vezba.setIDSprave(s);
                
                TableModelVezba model = (TableModelVezba) tbl.getModel();
                model.getLista().add(vezba);
                model.fireTableDataChanged();
                
                cmbSprava.setSelectedIndex(-1);
                txtNaziv.setText("");
                txtPonavljanja.setText("");
                txtTezina.setText("");
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnNovaSpravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaSpravaActionPerformed
        new FrmKreirajSpravu((Frame) this.getParent(), true, cmbSprava).setVisible(true);
    }//GEN-LAST:event_btnNovaSpravaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovaSprava;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbSprava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPonavljanja;
    private javax.swing.JTextField txtTezina;
    // End of variables declaration//GEN-END:variables

    private boolean validate(String naziv, String ponavljanja, String tezina, JComboBox cmbSprava) {
        boolean signal = true;
        if (naziv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Polje naziv ne sme da bude prazno", "Greška", JOptionPane.ERROR_MESSAGE);
            signal = false;
        }
        if (ponavljanja.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Polje ponavljanja ne sme da bude prazno", "Greška", JOptionPane.ERROR_MESSAGE);
            signal = false;
        }
        if (tezina.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Polje tezina ne sme da bude prazno", "Greška", JOptionPane.ERROR_MESSAGE);
            signal = false;
        }
        
        if (cmbSprava.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Morate odabrati spravu", "Greška", JOptionPane.ERROR_MESSAGE);
            signal = false;
        }
        
        if (!naziv.isEmpty()) {
            if (naziv.length() > 30) {
                JOptionPane.showMessageDialog(this, "Polje naziv ne sme biti duze od 30 karaktera", "Greška", JOptionPane.ERROR_MESSAGE);
                signal = false;
            }
        }
        
        if (!ponavljanja.isEmpty()) {
            if (ponavljanja.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Broj ponavljanja mora biti broj", "Greška", JOptionPane.ERROR_MESSAGE);
                signal = false;
            }
        }
        
        if (!tezina.isEmpty()) {
            if (tezina.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Tezina mora biti broj", "Greška", JOptionPane.ERROR_MESSAGE);
                signal = false;
            }
        }
        
        return signal;
    }

    public void napuniCmb() {
        cmbSprava.removeAllItems();
        try {
            List<Sprava> sprave = Controller.getInstance().vratiSprave();
            for (Sprava sprava : sprave) {
                cmbSprava.addItem(sprava);
            }
            cmbSprava.setSelectedIndex(-1);
        } catch (Exception ex) {
            Logger.getLogger(FrmKreirajVezbu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
