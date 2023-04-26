/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.controller.ObradaIgrac;
import edunova.model.Igrac;
import edunova.util.Aplikacija;
import edunova.util.EdunovaException;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Karlo
 */
public class ProzorNoviKorisnik extends javax.swing.JFrame {

    private ObradaIgrac obrada;

    /**
     * Creates new form ProzorNoviKorisnik
     */
    public ProzorNoviKorisnik() {
        initComponents();
        obrada = new ObradaIgrac();
        obrada.setEntitet(new Igrac());
        setTitle(Aplikacija.NAZIV_APP + ": " + "Unos novog korisnika");
        
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
        txtUnosIme = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUnosPrezime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUnosKorisnickoIme = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pswUnosLozinke = new javax.swing.JPasswordField();
        pswProvjeraLozinke = new javax.swing.JPasswordField();
        Unos = new javax.swing.JButton();
        btnPovratak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Unos novog korisnika:");

        jLabel2.setText("Ime:");

        txtUnosIme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUnosImeKeyPressed(evt);
            }
        });

        jLabel3.setText("Prezime");

        txtUnosPrezime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUnosPrezimeKeyPressed(evt);
            }
        });

        jLabel4.setText("Korisnicko ime:");

        txtUnosKorisnickoIme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUnosKorisnickoImeKeyPressed(evt);
            }
        });

        jLabel5.setText("Lozinka:");

        jLabel6.setText("Ponovi lozinku:");

        pswUnosLozinke.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswUnosLozinkeKeyPressed(evt);
            }
        });

        pswProvjeraLozinke.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswProvjeraLozinkeKeyPressed(evt);
            }
        });

        Unos.setText("Unesi");
        Unos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnosActionPerformed(evt);
            }
        });

        btnPovratak.setText("Povratak");
        btnPovratak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPovratakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnosIme)
                            .addComponent(txtUnosPrezime)
                            .addComponent(txtUnosKorisnickoIme)
                            .addComponent(pswUnosLozinke)
                            .addComponent(pswProvjeraLozinke, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnPovratak, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(Unos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUnosIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUnosPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUnosKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswUnosLozinke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswProvjeraLozinke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Unos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPovratak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnosActionPerformed
        
        napuniModel();

    }//GEN-LAST:event_UnosActionPerformed

    private void btnPovratakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPovratakActionPerformed
        new ProzorLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPovratakActionPerformed

    private void txtUnosImeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnosImeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtUnosPrezime.requestFocus();
        }
    }//GEN-LAST:event_txtUnosImeKeyPressed

    private void txtUnosPrezimeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnosPrezimeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtUnosKorisnickoIme.requestFocus();
        }
    }//GEN-LAST:event_txtUnosPrezimeKeyPressed

    private void txtUnosKorisnickoImeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnosKorisnickoImeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            pswUnosLozinke.requestFocus();
        }
    }//GEN-LAST:event_txtUnosKorisnickoImeKeyPressed

    private void pswUnosLozinkeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswUnosLozinkeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            pswProvjeraLozinke.requestFocus();
        }
    }//GEN-LAST:event_pswUnosLozinkeKeyPressed

    private void pswProvjeraLozinkeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswProvjeraLozinkeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            napuniModel();
        }
    }//GEN-LAST:event_pswProvjeraLozinkeKeyPressed

    private void napuniModel() {
        var igr = obrada.getEntitet();
        StringBuilder lozinka = new StringBuilder();

        if (txtUnosIme.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    getRootPane(), "Obavezno ime");
            return;
        }
        
        if (txtUnosPrezime.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    getRootPane(), "Obavezno prezime");
            return;
        }

        if (txtUnosKorisnickoIme.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    getRootPane(), "Obavezno korisnicko ime");
            return;
        }

        if (pswUnosLozinke.getPassword().length == 0) {
            JOptionPane.showMessageDialog(
                    getRootPane(),
                    "Obavezno unesi lozinku");
            return;
        }

        if (pswProvjeraLozinke.getPassword().length == 0) {
            JOptionPane.showMessageDialog(
                    getRootPane(),
                    "Obavezno ponovi lozinku");
            return;
        }

        if (!Arrays.equals(pswUnosLozinke.getPassword(),pswProvjeraLozinke.getPassword())) {
            JOptionPane.showMessageDialog(
                    getRootPane(),
                    "Lozinke se ne poklapaju");
            return;
        }

        igr.setIme(txtUnosIme.getText());
        igr.setPrezime(txtUnosPrezime.getText());
        igr.setKorisnickoIme(txtUnosKorisnickoIme.getText());
        
        lozinka.append(pswUnosLozinke.getPassword());
        igr.setLozinka(BCrypt.hashpw(lozinka.toString(),
                BCrypt.gensalt()).toCharArray());
        

        try {
            obrada.create();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(
                    getRootPane(),
                    ex.getPoruka());
            return;
        }
        new ProzorLogin().setVisible(true);
        dispose();

    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Unos;
    private javax.swing.JButton btnPovratak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField pswProvjeraLozinke;
    private javax.swing.JPasswordField pswUnosLozinke;
    private javax.swing.JTextField txtUnosIme;
    private javax.swing.JTextField txtUnosKorisnickoIme;
    private javax.swing.JTextField txtUnosPrezime;
    // End of variables declaration//GEN-END:variables
}
