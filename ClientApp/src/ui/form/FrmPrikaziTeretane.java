/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui.form;

import domain.Korisnik;
import domain.Teretana;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import table.model.TableModelTeretana;
import ui.controller.Controller;

/**
 *
 * @author Filip
 */
public class FrmPrikaziTeretane extends javax.swing.JDialog {

    private Korisnik korisnik;
    private Teretana izabrana;
    private List<Teretana> teretane = new ArrayList<>();
    /**
     * Creates new form FrmPrikaziteretane
     */
    public FrmPrikaziTeretane(java.awt.Frame parent, boolean modal, Korisnik korisnik) {
        super(parent, modal);
        initComponents();
        napuniTabelu();
        this.korisnik = korisnik;
        setLocationRelativeTo(null);
        setTitle("Prikaz teretana");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTeretane = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblTeretane.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTeretane);

        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(255, 255, 255));
        btnDodaj.setText("Dodaj članstvo");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDodaj)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDodaj)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        int red = tblTeretane.getSelectedRow();
        if (red!= -1) {
            izabrana = teretane.get(red);
            new FrmKreirajClanstvo((Frame) this.getParent(), true, korisnik, izabrana).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Morate izabrati teretanu",  "Greška",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnDodajActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTeretane;
    // End of variables declaration//GEN-END:variables

    private void napuniTabelu() {
        try {
            teretane = Controller.getInstance().vratiTeretane();
            TableModelTeretana tmt = new TableModelTeretana();
            tmt.setLista(teretane);
            tblTeretane.setModel(tmt);
        } catch (Exception ex) {
            Logger.getLogger(FrmPrikaziTeretane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
