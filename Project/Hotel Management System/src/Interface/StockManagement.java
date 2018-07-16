package Interface;

import static MyCode.DBUtils.addStockDet;
import static MyCode.DBUtils.getAllStock;
import static MyCode.DBUtils.getAllSup;
import static MyCode.DBUtils.getStockId;
import static MyCode.DBUtils.getSupId;
import static MyCode.DBUtils.getSupName;
import static MyCode.DBUtils.getSupWiseVal;
import static MyCode.DBUtils.removeStockDet;
import static MyCode.DBUtils.searchStock;
import static MyCode.DBUtils.updateStockDet;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Date;

public class StockManagement extends javax.swing.JInternalFrame {

    public StockManagement() {

        initComponents();
        updateStockTable();
        loadSupToDropDown();
        loadStockId();

    }

    public void updateStockTable() {
        ResultSet rs = getAllStock();
        custable.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public void loadStockId() {
        String curId = getStockId();
        int newid = Integer.parseInt(curId);
        newid++;
        cidlable.setText(Integer.toString(newid));
    }

    public void loadSupToDropDown() {
        ResultSet rs = getSupName();

        try {
            while (rs.next()) {
                ctypecombo1.addItem(rs.getString(1).trim());
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
        labletel1 = new javax.swing.JLabel();
        nicfield = new javax.swing.JTextField();
        telnofield = new javax.swing.JTextField();
        adultsfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ctypecombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        custable = new javax.swing.JTable();
        bookingbutton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        ctypecombo1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        labletel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        jLabel1.setText("Stock Management");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(400, 10, 176, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Stock Information");
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
        jLabel6.setText("Stock Type");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(420, 40, 90, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Item Name");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 80, 126, 25);

        labletel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel2.setText("Quantity");
        jPanel2.add(labletel2);
        labletel2.setBounds(20, 120, 126, 25);

        labletel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel1.setText("Date");
        jPanel2.add(labletel1);
        labletel1.setBounds(20, 200, 126, 25);

        nicfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nicfield.setPreferredSize(new java.awt.Dimension(195, 25));
        nicfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nicfieldKeyTyped(evt);
            }
        });
        jPanel2.add(nicfield);
        nicfield.setBounds(160, 80, 195, 25);

        telnofield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        telnofield.setPreferredSize(new java.awt.Dimension(195, 25));
        telnofield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telnofieldActionPerformed(evt);
            }
        });
        telnofield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telnofieldKeyTyped(evt);
            }
        });
        jPanel2.add(telnofield);
        telnofield.setBounds(160, 120, 195, 25);

        adultsfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adultsfield.setPreferredSize(new java.awt.Dimension(195, 25));
        adultsfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adultsfieldKeyTyped(evt);
            }
        });
        jPanel2.add(adultsfield);
        adultsfield.setBounds(160, 160, 195, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Stock ID");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 40, 126, 25);

        ctypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctypecombo.setMaximumRowCount(4);
        ctypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Food Materials", "Furniture", "Clothing", "Other", " " }));
        ctypecombo.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(ctypecombo);
        ctypecombo.setBounds(530, 40, 130, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Stock");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 240, 210, 30);

        custable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        custable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock ID", "Stock Type", "Item Name", "Quantity", "Value", "Supplier", "Date"
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

        bookingbutton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bookingbutton1.setText("Search");
        bookingbutton1.setPreferredSize(new java.awt.Dimension(110, 31));
        bookingbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingbutton1ActionPerformed(evt);
            }
        });
        jPanel2.add(bookingbutton1);
        bookingbutton1.setBounds(540, 190, 110, 31);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jTextField1);
        jTextField1.setBounds(510, 140, 140, 30);

        ctypecombo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctypecombo1.setMaximumRowCount(4);
        ctypecombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier" }));
        ctypecombo1.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(ctypecombo1);
        ctypecombo1.setBounds(530, 80, 130, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Supplier");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(420, 80, 60, 25);

        labletel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel3.setText("Value");
        jPanel2.add(labletel3);
        labletel3.setBounds(20, 160, 126, 25);
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(160, 200, 190, 30);

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

        int input = JOptionPane.showConfirmDialog(null, "Do you want to delete this Record?");
        String id = cidlable.getText();
        if (input == 0) {
            boolean i = removeStockDet(id);

            if (i = true) {
                JOptionPane.showMessageDialog(rootPane, "Stock Removal Successful!!!!");
                updateStockTable();
                loadStockId();
                nicfield.setText("");
                telnofield.setText("");
                adultsfield.setText("");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Stock Removal Unsuccessful!!!!");
            }
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    //validations
    private void bookingbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbuttonActionPerformed

        String id = cidlable.getText();
        String sname = nicfield.getText();
        String qty = telnofield.getText();
        String vlu = adultsfield.getText();
        //String date = jDateChooser1.getDateFormatString();
        Date dt = jDateChooser1.getDate();
        String stype = ctypecombo.getSelectedItem().toString();
        String sup = ctypecombo1.getSelectedItem().toString();
       
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date =df.format(dt);
        
        
        boolean stat = addStockDet(id, sname, qty, vlu, date, stype, sup);

      if(sname.isEmpty())
      {
          JOptionPane.showMessageDialog(null, "You have null fields! \n HINT:Item name");
      }
      
     else if(qty.isEmpty())
      {
        JOptionPane.showMessageDialog(null, "You have null fields! \n HINT:Quantity");
      
      }
      
      else if(vlu.isEmpty())
      {
       JOptionPane.showMessageDialog(null, "You have null fields! \n HINT:value");
      }
      
      else if (dt==null)
      {
          JOptionPane.showMessageDialog(null, "You have null fields! \n HINT:Date");
      }
      
      else if(stype.equals("Select Type"))
      {
      
          JOptionPane.showMessageDialog(null, "Please select the stock type!");
      
      }
      
      else if (sup.equalsIgnoreCase("Select Supplier"))
      {
      
            JOptionPane.showMessageDialog(null, "Please select the supplier!");
      
      }
      
      else
      {
       double tot = Double.parseDouble(qty) * Double.parseDouble(vlu);
          
        if (stat = true) {
            JOptionPane.showMessageDialog(rootPane, "Stock Registration Successful!!!!");
            updateStockTable();
            loadStockId();
            getSupWiseVal(sname, date, tot);
            nicfield.setText("");
            telnofield.setText("");
            adultsfield.setText("");

        } else {
            JOptionPane.showMessageDialog(rootPane, "Stock Registration Unsuccessful!!!!");
        }
      
      
      
      }
    }//GEN-LAST:event_bookingbuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed

        updateStockTable();
        loadStockId();
        nicfield.setText("");
        telnofield.setText("");
        adultsfield.setText("");
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void custableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custableMouseClicked

        try {
            
             int row = custable.getSelectedRow();
        String sid = custable.getModel().getValueAt(row, 0).toString();
        String itmeName = custable.getModel().getValueAt(row, 1).toString();
        String qty = custable.getModel().getValueAt(row, 2).toString();
        String val = custable.getModel().getValueAt(row, 3).toString();
        //String date = custable.getModel().getValueAt(row, 4).toString();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) custable.getValueAt(row, 4).toString());
        String sttype = custable.getModel().getValueAt(row, 5).toString();
        String sup = custable.getModel().getValueAt(row, 6).toString();

        cidlable.setText(sid);
        nicfield.setText(itmeName);
        telnofield.setText(qty);
        adultsfield.setText(val);
        jDateChooser1.setDate(date);
        if (sttype.equals("Food Materials")) {
            ctypecombo.setSelectedIndex(1);
        } else if (sttype.equals("Furniture")) {
            ctypecombo.setSelectedIndex(2);
        } else if (sttype.equals("Clothing")) {
            ctypecombo.setSelectedIndex(3);
        } else {
            ctypecombo.setSelectedIndex(4);
        }
        ctypecombo1.setSelectedItem(sup);

        /*if (sttype.equals("Food Materials")) {
            ctypecombo1.setSelectedIndex(1);
        } else if (sttype.equals("Furniture")) {
            ctypecombo1.setSelectedIndex(2);
        } else if (sttype.equals("Clothing")) {
            ctypecombo1.setSelectedIndex(3);
        } else {
            ctypecombo1.set;
        }*/

            
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_custableMouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed

        String id = cidlable.getText();
        String sname = nicfield.getText();
        String qty = telnofield.getText();
        String vlu = adultsfield.getText();
        //String date = jDateChooser1.getDateFormatString();
        Date dt =jDateChooser1.getDate();
        String stype = ctypecombo.getSelectedItem().toString();
        String sup = ctypecombo1.getSelectedItem().toString();

       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date =df.format(dt);
        
        
        
        boolean stat = updateStockDet(id, sname, qty, vlu, date, stype, sup);

        if(sname.isEmpty())
      {
          JOptionPane.showMessageDialog(null, "You have null fields! \n HINT:Item name");
      }
      
     else if(qty.isEmpty())
      {
        JOptionPane.showMessageDialog(null, "You have null fields! \n HINT:Quantity");
      
      }
      
      else if(vlu.isEmpty())
      {
       JOptionPane.showMessageDialog(null, "You have null fields! \n HINT:value");
      }
      
      else if (dt==null)
      {
          JOptionPane.showMessageDialog(null, "You have null fields! \n HINT:Date");
      }
      
      else if(stype.equals("Select Type"))
      {
      
          JOptionPane.showMessageDialog(null, "Please select the stock type!");
      
      }
      
      else if (sup.equalsIgnoreCase("Select Supplier"))
      {
      
            JOptionPane.showMessageDialog(null, "Please select the supplier!");
      
      }
        
       else
      {
      
           
        if (stat = true) {
            JOptionPane.showMessageDialog(rootPane, "Stock Detail Update Successful!!!!");
            updateStockTable();
            nicfield.setText("");
            telnofield.setText("");
            adultsfield.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Stock Detail Update Unsuccessful!!!!");
        }
      
      }
        
   

    }//GEN-LAST:event_updatebuttonActionPerformed

    private void bookingbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbutton1ActionPerformed
        String name = jTextField1.getText();

        ResultSet rs = searchStock(name);

        try {
            if (rs.next()) {
                custable.setModel(DbUtils.resultSetToTableModel(rs));
            } else {
                JOptionPane.showMessageDialog(rootPane, "No Item Found!!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookingbutton1ActionPerformed

    private void telnofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telnofieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telnofieldActionPerformed

    private void nicfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicfieldKeyTyped
        
           int enter = evt.getKeyChar();
    
        if(Character.isDigit(enter)) {
            
            nicfield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }

        else {
            
            nicfield.setBackground(Color.WHITE);
            
        }
        
        
    }//GEN-LAST:event_nicfieldKeyTyped

    private void telnofieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telnofieldKeyTyped
        
        
           int enter = evt.getKeyChar();
    
        if(!(Character.isDigit(enter))) {
            
            telnofield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }

        else {
            
            telnofield.setBackground(Color.WHITE);
            
        }
        
        
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
    private javax.swing.JComboBox<String> ctypecombo;
    private javax.swing.JComboBox<String> ctypecombo1;
    private javax.swing.JTable custable;
    private javax.swing.JButton deletebutton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labletel1;
    private javax.swing.JLabel labletel2;
    private javax.swing.JLabel labletel3;
    private javax.swing.JTextField nicfield;
    private javax.swing.JTextField telnofield;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
