package Interface;

import static MyCode.DBUtils.getItemByName;
import static MyCode.DBUtils.getSupName;
import static MyCode.DBUtils.getsTypeName;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class CostValue extends javax.swing.JInternalFrame {

    public CostValue() {

        initComponents();
        loadSupToDropDown();
    }

    public void loadSupToDropDown() {
        ResultSet rs = getsTypeName();

        try {
            while (rs.next()) {
                ctypecombo.addItem(rs.getString(1).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ctypecombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setText("Cost & Value");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(400, 10, 118, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Stock Information");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(350, 40, 210, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Item Informations");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 150, 360, 25);

        ctypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctypecombo.setMaximumRowCount(4);
        ctypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type" }));
        ctypecombo.setPreferredSize(new java.awt.Dimension(140, 25));
        ctypecombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctypecomboMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ctypecomboMousePressed(evt);
            }
        });
        ctypecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctypecomboActionPerformed(evt);
            }
        });
        ctypecombo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ctypecomboPropertyChange(evt);
            }
        });
        jPanel2.add(ctypecombo);
        ctypecombo.setBounds(140, 70, 140, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Item Name");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 70, 126, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Item Name                 :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 210, 150, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Quantity Available     :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 270, 160, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Total Coast                :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 320, 160, 16);

        jLabel5.setText("-");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(280, 210, 80, 14);

        jLabel8.setText("-");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(280, 270, 80, 14);

        jLabel11.setText("-");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(280, 320, 70, 14);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(130, 30));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(500, 70, 130, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(530, 120, 100, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(120, 50, 670, 520);

        background.add(jPanel1);
        jPanel1.setBounds(230, 10, 880, 580);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/InventoryB.jpg"))); // NOI18N
        background.add(jLabel10);
        jLabel10.setBounds(0, 0, 1358, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ctypecomboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctypecomboMouseClicked
        //System.out.println("adasd");
    }//GEN-LAST:event_ctypecomboMouseClicked

    private void ctypecomboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctypecomboMousePressed
        // System.out.println("sasdasdasd");
    }//GEN-LAST:event_ctypecomboMousePressed

    private void ctypecomboPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ctypecomboPropertyChange
        //System.out.println("cccccc");
    }//GEN-LAST:event_ctypecomboPropertyChange

    private void ctypecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctypecomboActionPerformed
        String stname = ctypecombo.getSelectedItem().toString();
        double tot = 0;
        int qty = 0;
        ResultSet rs = getItemByName(stname);
        ResultSet rs1 = null;
        try {
            while (rs.next()) {
                int qt = Integer.parseInt(rs.getString("qty"));
                double val = Double.parseDouble(rs.getString("value"));
                double totamt = qt * val;
                tot = tot + totamt;
                qty = qty + qt;

                //rs1.updateString("first_name", "MyName");
               
                //jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            jLabel5.setText(stname);
            jLabel8.setText(Integer.toString(qty));
            jLabel11.setText(Double.toString(tot));
        } catch (SQLException ex) {
            Logger.getLogger(CostValue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ctypecomboActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String stname = jTextField1.getText();
        double tot = 0;
        int qty = 0;
        ResultSet rs = getItemByName(stname);
        ResultSet rs1 = null;
        try {
            while (rs.next()) {
                int qt = Integer.parseInt(rs.getString("qty"));
                double val = Double.parseDouble(rs.getString("value"));
                double totamt = qt * val;
                tot = tot + totamt;
                qty = qty + qt;

                //rs1.updateString("first_name", "MyName");
               
                //jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            jLabel5.setText(stname);
            jLabel8.setText(Integer.toString(qty));
            jLabel11.setText(Double.toString(tot));
        } catch (SQLException ex) {
            Logger.getLogger(CostValue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JComboBox<String> ctypecombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
