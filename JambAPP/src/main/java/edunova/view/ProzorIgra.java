/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.model.Igra;
import edunova.model.Polje;
import edunova.util.Aplikacija;
import edunova.util.HibernateUtil;
import edunova.util.KreiranjePrazneIgre;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Renderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.hibernate.Session;

/**
 *
 * @author Karlo
 */
public class ProzorIgra extends javax.swing.JFrame {

    private Session session = HibernateUtil.getSession();
    private Igra igra;
    private List<Polje> polja;

    private boolean FlagBtn = true;

    public ProzorIgra() {
        initComponents();
        setTitle(Aplikacija.NAZIV_APP + ": " + Aplikacija.IGRAC.getKorisnickoIme() + " - Nova Igra");
        postavljanjeTablice();
        lblRezultat.setVisible(false);
        igra = napraviPraznaPolja();
        lblSifraIgre.setText(String.valueOf(igra.getSifra()));
        polja = igra.getPolja();
        napuniTablicu();

    }

    public ProzorIgra(Igra selectedIgra, boolean disableEdit) {
        initComponents();
        FlagBtn = disableEdit;
        if (disableEdit) {
            setTitle(Aplikacija.NAZIV_APP + ": " + Aplikacija.IGRAC.getKorisnickoIme() + " - Nastavak Igre");
        } else {
            promjeniTableModel();
            setTitle(Aplikacija.NAZIV_APP + ": " + Aplikacija.IGRAC.getKorisnickoIme() + " - Prikaz Igre");
            btnOsvjezi.setVisible(false);
        }
        postavljanjeTablice();
        this.igra = selectedIgra;
        lblSifraIgre.setText(String.valueOf(igra.getSifra()));
        polja = igra.getPolja();
        napuniTablicu();
        lblRezultatIspis.setText(String.valueOf(ukupniRezultat()));

    }

    private void promjeniTableModel() {
        tblIgra.setModel(new CustomTableModelPrikaz(
                new Object[][]{
                    {"1", null, null, null, null, null},
                    {"2", null, null, null, null, null},
                    {"3", null, null, null, null, null},
                    {"4", null, null, null, null, null},
                    {"5", null, null, null, null, null},
                    {"6", null, null, null, null, null},
                    {"ZBR", null, null, null, null, null},
                    {"MAX", null, null, null, null, null},
                    {"MIN", null, null, null, null, null},
                    {"ZBR", null, null, null, null, null},
                    {"2P", null, null, null, null, null},
                    {"SK", null, null, null, null, null},
                    {"FULL", null, null, null, null, null},
                    {"POK", null, null, null, null, null},
                    {"JAM", null, null, null, null, null},
                    {"ZBR", null, null, null, null, null}
                },
                new String[]{
                    "", "D", "G", "S", "N", "R"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class

            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        }
        );
    }

    private void ucitavanjeIzTablice() {

        session.beginTransaction();

        int br = 0;
        Polje polje;
        for (int i = 0; i < tblIgra.getRowCount() - 1; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            for (int j = 1; j < tblIgra.getColumnCount(); j++) {
                Object vrijednostObjekt = tblIgra.getValueAt(i, j);
                int vrijednost = -1;
                if (vrijednostObjekt.toString().equalsIgnoreCase("X")) {
                    vrijednost = 0;
                }
                try {
                    vrijednost = Integer.parseInt(vrijednostObjekt.toString());

                } catch (NumberFormatException ex) {
                }

                polje = polja.get(br);
                polje.setVrijednost(vrijednost);
                session.persist(polje);

                br++;

            }
        }

        session.getTransaction().commit();

    }

    private void racunanjeZbrojeva() {
        int zbroj;
        int vrijednost;
        //PrviZbroj
        for (int i = 1; i < 6; i++) {
            zbroj = 0;
            for (int j = 0; j < 6; j++) {
                Object vrijednostObjekt = tblIgra.getValueAt(j, i);

                try {
                    vrijednost = Integer.parseInt(vrijednostObjekt.toString());

                } catch (NumberFormatException ex) {
                    vrijednost = 0;
                }
                zbroj += vrijednost;
            }
            if (zbroj >= 60) {
                zbroj += 30;
            }
            tblIgra.setValueAt(String.valueOf(zbroj), 6, i);
        }

        //DrugiZbroj
        int min;
        int max;
        int jedinice;
        for (int i = 1; i < 6; i++) {
            try {
                jedinice = Integer.parseInt(tblIgra.getValueAt(0, i).toString());
                max = Integer.parseInt(tblIgra.getValueAt(7, i).toString());
                min = Integer.parseInt(tblIgra.getValueAt(8, i).toString());

            } catch (NumberFormatException ex) {
                min = 0;
                max = 0;
                jedinice = 0;
            }
            zbroj = (max - min) * jedinice;
            if (zbroj > 0) {
                tblIgra.setValueAt(String.valueOf(zbroj), 9, i);
            } else {
                tblIgra.setValueAt(String.valueOf(0), 9, i);
            }
        }
        //treciZbroj
        for (int i = 1; i < 6; i++) {
            zbroj = 0;
            for (int j = 10; j < 15; j++) {
                Object vrijednostObjekt = tblIgra.getValueAt(j, i);
                try {
                    vrijednost = Integer.parseInt(vrijednostObjekt.toString());

                } catch (NumberFormatException ex) {
                    vrijednost = 0;
                }
                zbroj += vrijednost;
            }
            tblIgra.setValueAt(String.valueOf(zbroj), 15, i);
        }
    }

    private void napuniTablicu() {

        int i = 0;
        for (int red = 0; red <= 14; red++) {
            if (red == 6 || red == 9) {
                continue;
            }
            for (int kolona = 1; kolona <= 5; kolona++) {
                tblIgra.setValueAt(vratiVrijednost(i), red, kolona);
                i++;
            }
        }
        racunanjeZbrojeva();

    }

    private int ukupniRezultat() {
        int zbroj = 0;
        zbroj += zbrojiRed(6);
        zbroj += zbrojiRed(9);
        zbroj += zbrojiRed(15);

        return zbroj;
    }

    private int zbrojiRed(int row) {
        int zbroj = 0;

        for (int i = 1; i < 6; i++) {
            Object vrijednostObjekt = tblIgra.getValueAt(row, i);
            try {
                zbroj += Integer.parseInt(vrijednostObjekt.toString());

            } catch (NumberFormatException ex) {
            }
        }
        return zbroj;
    }

    private String vratiVrijednost(int index) {
        if (polja.get(index).getVrijednost() < 0) {
            return "";
        } else if (polja.get(index).getVrijednost() == 0) {
            return "X";
        } else {
            return Integer.toString(polja.get(index).getVrijednost());
        }
    }

    private Igra napraviPraznaPolja() {
        KreiranjePrazneIgre kreiranjePrazneIgre = new KreiranjePrazneIgre();

        return kreiranjePrazneIgre.getIgra();

    }

    private void postavljanjeTablice() {
        setColumnWidths(tblIgra, 45, 55, 55, 55, 55, 55);
        tblIgra.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblIgra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblIgra.setRowHeight(22);

        JScrollPane scrollPane = this.jScrollPane1;
        scrollPane.setViewportView(tblIgra);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        tblIgra.setSize(320, 378);


        TableColumn tColumn = tblIgra.getColumnModel().getColumn(0);
        tColumn.setCellRenderer(new ColumnColorRenderer(new Color(79, 189, 229), Color.BLACK));
        tblIgra.getTableHeader().setBackground(new Color(79, 189, 229));

// define the renderer for the table cells
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            int[] rowsToColor = {6, 9, 15};
            

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                // get the default renderer
                this.setHorizontalAlignment(CENTER);
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                for (int i = 0; i < rowsToColor.length; i++) {
                    if (row == rowsToColor[i]) {
                        c.setBackground(new Color(189, 217, 236));
                        return c;
                    }
                }
                // for other rows, set the default background color
                c.setBackground(table.getBackground());
                return c;
            }
        };
        tblIgra.setDefaultRenderer(Object.class, renderer);

    }

    public static void setColumnWidths(JTable table, int... widths) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < widths.length; i++) {
            if (i < columnModel.getColumnCount()) {
                columnModel.getColumn(i).setMaxWidth(widths[i]);
            } else {
                break;
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblIgra = new javax.swing.JTable();
        btnZavrsi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblSifraIgre = new javax.swing.JLabel();
        lblRezultat = new javax.swing.JLabel();
        lblRezultatIspis = new javax.swing.JLabel();
        btnOsvjezi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setWheelScrollingEnabled(false);

        tblIgra.setModel(new CustomTableModel(
            new Object [][] {
                {"1", null, null, null, null, null},
                {"2", null, null, null, null, null},
                {"3", null, null, null, null, null},
                {"4", null, null, null, null, null},
                {"5", null, null, null, null, null},
                {"6", null, null, null, null, null},
                {"ZBR", null, null, null, null, null},
                {"MAX", null, null, null, null, null},
                {"MIN", null, null, null, null, null},
                {"ZBR", null, null, null, null, null},
                {"2P", null, null, null, null, null},
                {"SK", null, null, null, null, null},
                {"FULL", null, null, null, null, null},
                {"POK", null, null, null, null, null},
                {"JAM", null, null, null, null, null},
                {"ZBR", null, null, null, null, null}
            },
            new String [] {
                "", "D", "G", "S", "N", "R"
            }

            //dodajem

            //
        ) {
            Class[] types = new Class [] {
                java.lang.String.class

                , java.lang.String.class

                , java.lang.String.class

                , java.lang.String.class

                , java.lang.String.class

                , java.lang.String.class

            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        }
    );
    tblIgra.setMaximumSize(new java.awt.Dimension(320, 382));
    tblIgra.setMinimumSize(new java.awt.Dimension(320, 382));
    tblIgra.setPreferredSize(new java.awt.Dimension(320, 382));
    tblIgra.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            tblIgraMousePressed(evt);
        }
    });
    tblIgra.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            tblIgraKeyPressed(evt);
        }
    });
    jScrollPane1.setViewportView(tblIgra);

    btnZavrsi.setText("Završi");
    btnZavrsi.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnZavrsiActionPerformed(evt);
        }
    });

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel1.setText("Šifra Igre:");

    lblSifraIgre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

    lblRezultat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    lblRezultat.setText("Rezultat:");

    lblRezultatIspis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

    btnOsvjezi.setText("Osvježi");
    btnOsvjezi.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnOsvjeziActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblSifraIgre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblRezultat, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblRezultatIspis, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(48, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup()
            .addGap(76, 76, 76)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btnOsvjezi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnZavrsi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblSifraIgre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblRezultat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblRezultatIspis, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnZavrsi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnOsvjezi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(21, 21, 21))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnZavrsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZavrsiActionPerformed
        if (FlagBtn) {
            int n = JOptionPane.showConfirmDialog(
                    null,
                    "Jeste li sigurni?",
                    "",
                    JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.NO_OPTION) {
                ucitavanjeIzTablice();
                racunanjeZbrojeva();
            } else {
                JOptionPane.showMessageDialog(null, "Vaš rezultat: \n       " + ukupniRezultat());
                new ProzorIzbornik().setVisible(true);
                dispose();

            }
        } else {
            new ProzorPrikazIgara(FlagBtn).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnZavrsiActionPerformed

    private void tblIgraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblIgraKeyPressed

    }//GEN-LAST:event_tblIgraKeyPressed

    private void tblIgraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIgraMousePressed
        ucitavanjeIzTablice();
        racunanjeZbrojeva();
    }//GEN-LAST:event_tblIgraMousePressed

    private void btnOsvjeziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsvjeziActionPerformed
        napuniTablicu();
        ucitavanjeIzTablice();
    }//GEN-LAST:event_btnOsvjeziActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOsvjezi;
    private javax.swing.JButton btnZavrsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRezultat;
    private javax.swing.JLabel lblRezultatIspis;
    private javax.swing.JLabel lblSifraIgre;
    private javax.swing.JTable tblIgra;
    // End of variables declaration//GEN-END:variables

}

class ColumnColorRenderer extends DefaultTableCellRenderer {

    Color backgroundColor, foregroundColor;

    public ColumnColorRenderer(Color backgroundColor, Color foregroundColor) {
        super();
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setBackground(backgroundColor);
        cell.setForeground(foregroundColor);
        this.setHorizontalAlignment(CENTER);
        return cell;
    }
}

class CustomTableModel extends DefaultTableModel {

    public CustomTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Make the first column non-editable

        return !(column == 0 || row == 6 || row == 9 || row == 15);
    }
}

class CustomTableModelPrikaz extends DefaultTableModel {

    public CustomTableModelPrikaz(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {

        return false;
    }
}
