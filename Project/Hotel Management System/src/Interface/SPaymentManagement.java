package Interface;

import static MyCode.DBUtils.getBillDet;
import static MyCode.DBUtils.getSupName;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class SPaymentManagement extends javax.swing.JInternalFrame {

    public SPaymentManagement() {

        initComponents();
        loadSupToDropDown();
        loadBillTable();

    }
    public void loadBillTable(){
        ResultSet rs = getBillDet();
        custable.setModel(DbUtils.resultSetToTableModel(rs));
    }
    public void loadSupToDropDown() {
        ResultSet rs = getSupName();

        try {
            while (rs.next()) {
//                ctypecombo.addItem(rs.getString(1).trim());
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
        cidlable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labletel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        custable = new javax.swing.JTable();
        cidlable1 = new javax.swing.JLabel();
        cidlable2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bookingbutton1 = new javax.swing.JButton();
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
        jLabel1.setText("Payment Management");
        jLabel1.setPreferredSize(new java.awt.Dimension(240, 22));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(400, 10, 240, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Bill Information");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 40, 210, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        cidlable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cidlable.setText("DD-MM-YYYY");
        jPanel2.add(cidlable);
        cidlable.setBounds(165, 130, 126, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Supplier Name");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 70, 126, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Amount");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 100, 126, 25);

        labletel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel2.setText("Date");
        jPanel2.add(labletel2);
        labletel2.setBounds(20, 135, 126, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Bill ID");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 40, 126, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Request Payment");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 240, 210, 30);

        custable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        custable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Biil ID", "Sup Name", "Amount", "Date"
            }
        ));
        custable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(custable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 270, 650, 240);

        cidlable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cidlable1.setText("001");
        jPanel2.add(cidlable1);
        cidlable1.setBounds(165, 40, 126, 25);

        cidlable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cidlable2.setText("0.0");
        jPanel2.add(cidlable2);
        cidlable2.setBounds(165, 100, 126, 25);

        jLabel2.setText("-");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(170, 80, 100, 14);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 50, 670, 520);

        bookingbutton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bookingbutton1.setText("Print");
        bookingbutton1.setPreferredSize(new java.awt.Dimension(110, 31));
        bookingbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingbutton1ActionPerformed(evt);
            }
        });
        jPanel1.add(bookingbutton1);
        bookingbutton1.setBounds(730, 90, 110, 31);

        background.add(jPanel1);
        jPanel1.setBounds(230, 10, 880, 580);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/InventoryB.jpg"))); // NOI18N
        background.add(jLabel10);
        jLabel10.setBounds(0, 0, 1358, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custableMouseClicked

        int row = custable.getSelectedRow();
        String id = custable.getModel().getValueAt(row, 0).toString();
        String supName = custable.getModel().getValueAt(row, 1).toString();
        String amount = custable.getModel().getValueAt(row, 2).toString();
        String date = custable.getModel().getValueAt(row, 3).toString();
        cidlable1.setText(id); 
        jLabel2.setText(supName); 
        cidlable2.setText(amount);
        cidlable.setText(date);
    }//GEN-LAST:event_custableMouseClicked

    private void bookingbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbutton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingbutton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton bookingbutton1;
    private javax.swing.JLabel cidlable;
    private javax.swing.JLabel cidlable1;
    private javax.swing.JLabel cidlable2;
    private javax.swing.JTable custable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labletel2;
    // End of variables declaration//GEN-END:variables
}
