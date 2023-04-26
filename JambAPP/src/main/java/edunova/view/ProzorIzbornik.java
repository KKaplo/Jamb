/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.util.Aplikacija;

/**
 *
 * @author Karlo
 */
public class ProzorIzbornik extends javax.swing.JFrame {

    /**
     * Creates new form ProzorIzbornik
     */
    public ProzorIzbornik() {
        initComponents();
        setTitle(Aplikacija.NAZIV_APP + ": " + 
                Aplikacija.IGRAC.getKorisnickoIme());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brnNastavakIgre = new javax.swing.JButton();
        btnPregledIgara = new javax.swing.JButton();
        brnOdjava = new javax.swing.JButton();
        btnNovaIgra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        brnNastavakIgre.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        brnNastavakIgre.setText("Nastavak Igre");
        brnNastavakIgre.setMaximumSize(new java.awt.Dimension(180, 50));
        brnNastavakIgre.setMinimumSize(new java.awt.Dimension(180, 50));
        brnNastavakIgre.setPreferredSize(new java.awt.Dimension(150, 30));
        brnNastavakIgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnNastavakIgreActionPerformed(evt);
            }
        });

        btnPregledIgara.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPregledIgara.setText("Pregled Igara");
        btnPregledIgara.setMaximumSize(new java.awt.Dimension(180, 50));
        btnPregledIgara.setMinimumSize(new java.awt.Dimension(180, 50));
        btnPregledIgara.setPreferredSize(new java.awt.Dimension(180, 50));
        btnPregledIgara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregledIgaraActionPerformed(evt);
            }
        });

        brnOdjava.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        brnOdjava.setText("Odjava");
        brnOdjava.setMaximumSize(new java.awt.Dimension(150, 30));
        brnOdjava.setMinimumSize(new java.awt.Dimension(150, 30));
        brnOdjava.setPreferredSize(new java.awt.Dimension(150, 30));
        brnOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnOdjavaActionPerformed(evt);
            }
        });

        btnNovaIgra.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNovaIgra.setText("Nova Igra");
        btnNovaIgra.setMaximumSize(new java.awt.Dimension(180, 50));
        btnNovaIgra.setMinimumSize(new java.awt.Dimension(180, 50));
        btnNovaIgra.setPreferredSize(new java.awt.Dimension(180, 50));
        btnNovaIgra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaIgraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(brnOdjava, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPregledIgara, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brnNastavakIgre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaIgra, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnNovaIgra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(brnNastavakIgre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnPregledIgara, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(brnOdjava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void brnNastavakIgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnNastavakIgreActionPerformed
        new ProzorPrikazIgara(true).setVisible(true);
        dispose();
    }//GEN-LAST:event_brnNastavakIgreActionPerformed

    private void btnPregledIgaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregledIgaraActionPerformed
        new ProzorPrikazIgara(false).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPregledIgaraActionPerformed

    private void brnOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnOdjavaActionPerformed
        new ProzorLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_brnOdjavaActionPerformed

    private void btnNovaIgraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaIgraActionPerformed
        new ProzorIgra().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNovaIgraActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnNastavakIgre;
    private javax.swing.JButton brnOdjava;
    private javax.swing.JButton btnNovaIgra;
    private javax.swing.JButton btnPregledIgara;
    // End of variables declaration//GEN-END:variables
}
