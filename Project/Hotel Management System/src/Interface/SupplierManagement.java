package Interface;

import MyCode.DBUtils;
import static MyCode.DBUtils.getAllSup;
import static MyCode.DBUtils.getSupId;
import static MyCode.DBUtils.removeSupDet;
import static MyCode.DBUtils.searchSup;
import static MyCode.DBUtils.updateSupDet;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class SupplierManagement extends javax.swing.JInternalFrame {

    public SupplierManagement() {

        initComponents();
        loadSupId();
        updateSupTable();

    }

    public void resetTable() {
        DefaultTableModel model = (DefaultTableModel) this.custable.getModel();
        model.setRowCount(0);
    }

    public void loadSupId() {
        String curId = getSupId();
        int newid = Integer.parseInt(curId);
        newid++;
        cidlable.setText(Integer.toString(newid));
    }

    public void updateSupTable() {
        ResultSet rs = getAllSup();
        custable.setModel(DbUtils.resultSetToTableModel(rs));
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
        labletel1 = new javax.swing.JLabel();
        cnamefield = new javax.swing.JTextField();
        telnofield = new javax.swing.JTextField();
        adultsfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ctypecombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        custable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        bookingbutton1 = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        bookingbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
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
        jLabel1.setText("Supplier Management");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(400, 10, 199, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Supplier Information");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 40, 210, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        cidlable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cidlable.setText("001");
        jPanel2.add(cidlable);
        cidlable.setBounds(165, 40, 126, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Supplier Name");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 70, 126, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Supplier Type");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 100, 126, 25);

        labletel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel2.setText("Address");
        jPanel2.add(labletel2);
        labletel2.setBounds(20, 135, 126, 25);

        labletel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel1.setText("Tel No");
        jPanel2.add(labletel1);
        labletel1.setBounds(20, 170, 126, 25);

        cnamefield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cnamefield.setPreferredSize(new java.awt.Dimension(195, 25));
        cnamefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cnamefieldKeyTyped(evt);
            }
        });
        jPanel2.add(cnamefield);
        cnamefield.setBounds(164, 70, 195, 25);

        telnofield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        telnofield.setPreferredSize(new java.awt.Dimension(195, 25));
        telnofield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telnofieldKeyTyped(evt);
            }
        });
        jPanel2.add(telnofield);
        telnofield.setBounds(164, 135, 195, 25);

        adultsfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adultsfield.setPreferredSize(new java.awt.Dimension(195, 25));
        adultsfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adultsfieldKeyTyped(evt);
            }
        });
        jPanel2.add(adultsfield);
        adultsfield.setBounds(164, 170, 195, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Supplier ID");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 40, 126, 25);

        ctypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctypecombo.setMaximumRowCount(4);
        ctypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Food Materials", "Furniture", "Clothing", "Other" }));
        ctypecombo.setPreferredSize(new java.awt.Dimension(191, 25));
        ctypecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctypecomboActionPerformed(evt);
            }
        });
        jPanel2.add(ctypecombo);
        ctypecombo.setBounds(165, 100, 191, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Supplier");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 240, 210, 30);

        custable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        custable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sup ID", "Name", "Type", "Add", "Tel No", "Total"
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

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jTextField1);
        jTextField1.setBounds(500, 70, 140, 30);

        bookingbutton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bookingbutton1.setText("Search");
        bookingbutton1.setPreferredSize(new java.awt.Dimension(110, 31));
        bookingbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingbutton1ActionPerformed(evt);
            }
        });
        jPanel2.add(bookingbutton1);
        bookingbutton1.setBounds(530, 120, 110, 31);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 50, 670, 520);

        clearbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clearbutton.setText("Clear");
        clearbutton.setPreferredSize(new java.awt.Dimension(110, 31));
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(clearbutton);
        clearbutton.setBounds(730, 250, 110, 31);

        bookingbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bookingbutton.setText("Add");
        bookingbutton.setPreferredSize(new java.awt.Dimension(110, 31));
        bookingbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(bookingbutton);
        bookingbutton.setBounds(730, 130, 110, 31);

        updatebutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updatebutton.setText("Update");
        updatebutton.setPreferredSize(new java.awt.Dimension(110, 31));
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(updatebutton);
        updatebutton.setBounds(730, 170, 110, 31);

        deletebutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deletebutton.setText("Delete");
        deletebutton.setPreferredSize(new java.awt.Dimension(110, 31));
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(deletebutton);
        deletebutton.setBounds(730, 210, 110, 31);

        background.add(jPanel1);
        jPanel1.setBounds(230, 10, 880, 580);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/InventoryB.jpg"))); // NOI18N
        background.add(jLabel10);
        jLabel10.setBounds(0, 0, 1358, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed

        String supId = cidlable.getText();
        int input = JOptionPane.showConfirmDialog(null, "Do you want to delete this Record?");
        if (input == 0) {
            boolean stat = removeSupDet(supId);
            if (stat = true) {
                JOptionPane.showMessageDialog(rootPane, "Supplier Removal Successful!!!!");
                loadSupId();
                cnamefield.setText("");
                telnofield.setText("");
                adultsfield.setText("");
                updateSupTable();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Supplier Removal Unsuccessful!!!!");
            }
        }

    }//GEN-LAST:event_deletebuttonActionPerformed

    private void bookingbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbuttonActionPerformed

        String supId = cidlable.getText();
        String supName = cnamefield.getText();
        String supType = (String) ctypecombo.getSelectedItem();
        String supAddress = telnofield.getText();
        String supCon = adultsfield.getText();

        boolean stat = DBUtils.addSupplier(supId, supName, supType, supAddress, supCon);

        if(supName.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You have Null fields! \n HINT: Supplier name");
            
        }
        else if(supType == "Select Type")
        {
        
             JOptionPane.showMessageDialog(null, "Please select the Supplier type!");
        
        }
        else if(supAddress.isEmpty())
        {
        
             JOptionPane.showMessageDialog(null, "You have Null fields! \n HINT: Supplier address");
            
        }
        else if(supCon.isEmpty())
        {
        
             JOptionPane.showMessageDialog(null, "You have Null fields! \n HINT: Telephone number");
        
        }
        else if(supCon.length()!=10)
        {
        
            JOptionPane.showMessageDialog(null, "Invalid Telephone Number");
            
        }
        
        else
        {
        
          if (stat = true) {
            JOptionPane.showMessageDialog(rootPane, "Supplier Registration Successful!!!!");
            loadSupId();
            cnamefield.setText("");
            telnofield.setText("");
            adultsfield.setText("");
            updateSupTable();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Supplier Registration Unsuccessful!!!!");
        }
            
        }
        
      
    }//GEN-LAST:event_bookingbuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed

        loadSupId();
        cnamefield.setText("");
        telnofield.setText("");
        adultsfield.setText("");
        ctypecombo.setSelectedIndex(0);
        jTextField1.setText("");
        updateSupTable();

    }//GEN-LAST:event_clearbuttonActionPerformed

    private void custableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custableMouseClicked

        int row = custable.getSelectedRow();
        String supId = custable.getModel().getValueAt(row, 0).toString();
        String supName = custable.getModel().getValueAt(row, 1).toString();
        String supType = custable.getModel().getValueAt(row, 2).toString();
        String supAddress = custable.getModel().getValueAt(row, 3).toString();
        String supCon = custable.getModel().getValueAt(row, 4).toString();

        cidlable.setText(supId);
        cnamefield.setText(supName);
        if (supType.equals("Food Materials")) {
            ctypecombo.setSelectedIndex(1);
        } else if (supType.equals("Furniture")) {
            ctypecombo.setSelectedIndex(2);
        } else if (supType.equals("Clothing")) {
            ctypecombo.setSelectedIndex(3);
        } else {
            ctypecombo.setSelectedIndex(4);
        }
        telnofield.setText(supAddress);
        adultsfield.setText(supCon);
    }//GEN-LAST:event_custableMouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed

        String supId = cidlable.getText();
        String supName = cnamefield.getText();
        String supType = (String) ctypecombo.getSelectedItem();
        String supAddress = telnofield.getText();
        String supCon = adultsfield.getText();
        boolean stat = updateSupDet(supId, supName, supType, supAddress, supCon);

        
         if(supName.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You have Null fields! \n HINT: Supplier name");
            
        }
        else if(supType == "Select Type")
        {
        
             JOptionPane.showMessageDialog(null, "Please select the Supplier type!");
        
        }
        else if(supAddress.isEmpty())
        {
        
             JOptionPane.showMessageDialog(null, "You have Null fields! \n HINT: Supplier address");
            
        }
        else if(supCon.isEmpty())
        {
        
             JOptionPane.showMessageDialog(null, "You have Null fields! \n HINT: Telephone number");
        
        }
        else if(supCon.length()!=10)
        {
        
            JOptionPane.showMessageDialog(null, "Invalid Telephone Number");
            
        }
         
         else
        {
        
        if (stat = true) {
            JOptionPane.showMessageDialog(rootPane, "Supplier Detail Update Successful!!!!");
            loadSupId();
            cnamefield.setText("");
            telnofield.setText("");
            adultsfield.setText("");
            updateSupTable();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Supplier Detail Update Unsuccessful!!!!");
        }
        }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void bookingbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbutton1ActionPerformed
        try {
            String supName = jTextField1.getText();
            ResultSet rs = searchSup(supName);

            if (rs.isBeforeFirst()) {
                do {
                    custable.setModel(DbUtils.resultSetToTableModel(rs));
                    jTextField1.setText("");
                } while (rs.next());
                jTextField1.setText("");
            } else {
                JOptionPane.showMessageDialog(rootPane, "No Supplier Found!!!!");
                resetTable();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookingbutton1ActionPerformed

    private void ctypecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctypecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctypecomboActionPerformed

    private void cnamefieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnamefieldKeyTyped
        
          int enter = evt.getKeyChar();
    
        if((Character.isDigit(enter))) {
            
            cnamefield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }

        else {
            
            cnamefield.setBackground(Color.WHITE);
            
        }
        
        
    }//GEN-LAST:event_cnamefieldKeyTyped

    private void telnofieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telnofieldKeyTyped
        
        
    }//GEN-LAST:event_telnofieldKeyTyped

    private void adultsfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adultsfieldKeyTyped
       
          int enter = evt.getKeyChar();
    
        if(!(Character.isDigit(enter))) {
            
            adultsfield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }

        else {
            
            adultsfield.setBackground(Color.WHITE);
            
        }
        
    }//GEN-LAST:event_adultsfieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adultsfield;
    private javax.swing.JPanel background;
    private javax.swing.JButton bookingbutton;
    private javax.swing.JButton bookingbutton1;
    private javax.swing.JLabel cidlable;
    private javax.swing.JButton clearbutton;
    private javax.swing.JTextField cnamefield;
    private javax.swing.JComboBox<String> ctypecombo;
    private javax.swing.JTable custable;
    private javax.swing.JButton deletebutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labletel1;
    private javax.swing.JLabel labletel2;
    private javax.swing.JTextField telnofield;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
