package Interface;

import MyCode.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.glass.events.KeyEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jdk.nashorn.internal.ir.BreakNode;

public class ReFillingStore extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public ReFillingStore() {

        initComponents();

        con = DBconnect.connect();

        tablemeal();  
        ordroutgone();
        ShowTodayExpire();
        Show_Below_10();

    }
    
    public void tablemeal() {
        try 
        {
            String sql = "Select itemNo,mealName,expDate,quantity from res_meal";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            meal_table.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        
        catch (Exception e) 
        {
        }
    }//no 1 table (meal table) loader 
    
    public void ShowTodayExpire() {
        LocalDate localDate = LocalDate.now();
        String Exdate = localDate.toString();
            
        try 
        {
            String sql = "Select itemNo,mealName,quantity from res_meal where expDate='"+Exdate+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            expire_item.setModel(DbUtils.resultSetToTableModel(rs));
        } 
            
        catch (Exception e) 
        {
        }
    }//no 2 table (expire item) loader
    
    public void ordroutgone() {
        try 
        {
            String N = "N";
            
            String sql = "Select itmno,quantity,OrderedDate from res_order where status = '"+N+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            Oreder_table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch (Exception e) 
        {
        }
    }//no 4 table (order table) loader
      
    public void Show_Below_10(){
        try 
        {
            String sql = "Select itemNo,mealName,quantity from res_meal where quantity between 0 and 10";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            low_item.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch (Exception e) 
        {
        }
    }//no 3 table (low table) loader
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        item_no = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        search_meal = new javax.swing.JCheckBox();
        meal_name = new javax.swing.JTextField();
        reset_table = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        meal_table = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Oreder_table = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Qty = new javax.swing.JTextField();
        ITEM_NO = new javax.swing.JTextField();
        Order = new javax.swing.JButton();
        ITEM_Name = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        expire_item = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        low_item = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 0));
        jLabel38.setText("Store");
        background.add(jLabel38);
        jLabel38.setBounds(650, 15, 82, 42);

        jPanel8.setBackground(new java.awt.Color(153, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.setLayout(null);

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel21.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Item No:");
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel21.add(jLabel6);
        jLabel6.setBounds(10, 10, 70, 30);

        item_no.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        item_no.setPreferredSize(new java.awt.Dimension(50, 30));
        item_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_noActionPerformed(evt);
            }
        });
        item_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                item_noKeyTyped(evt);
            }
        });
        jPanel21.add(item_no);
        item_no.setBounds(82, 10, 50, 30);

        search.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        search.setText("Search");
        search.setPreferredSize(new java.awt.Dimension(90, 40));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel21.add(search);
        search.setBounds(470, 80, 90, 40);

        search_meal.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        search_meal.setText("Search By Meal Name");
        search_meal.setPreferredSize(new java.awt.Dimension(190, 30));
        search_meal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_mealActionPerformed(evt);
            }
        });
        jPanel21.add(search_meal);
        search_meal.setBounds(170, 10, 190, 30);

        meal_name.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        meal_name.setEnabled(false);
        meal_name.setPreferredSize(new java.awt.Dimension(140, 30));
        meal_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meal_nameActionPerformed(evt);
            }
        });
        meal_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                meal_nameKeyTyped(evt);
            }
        });
        jPanel21.add(meal_name);
        meal_name.setBounds(367, 10, 140, 30);

        reset_table.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        reset_table.setText("Reset");
        reset_table.setPreferredSize(new java.awt.Dimension(90, 40));
        reset_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_tableActionPerformed(evt);
            }
        });
        jPanel21.add(reset_table);
        reset_table.setBounds(360, 80, 90, 40);

        meal_table.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        meal_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item No", "Meal Name", "Exp Date", "Price", "Quantity", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        meal_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meal_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(meal_table);

        jPanel21.add(jScrollPane5);
        jScrollPane5.setBounds(10, 135, 550, 120);

        jPanel8.add(jPanel21);
        jPanel21.setBounds(10, 10, 570, 270);

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setLayout(null);

        Oreder_table.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Oreder_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Oreder_table);

        jPanel14.add(jScrollPane2);
        jScrollPane2.setBounds(10, 260, 360, 200);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Create Orders"));
        jPanel13.setPreferredSize(new java.awt.Dimension(360, 190));
        jPanel13.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Quantity");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel13.add(jLabel8);
        jLabel8.setBounds(25, 100, 100, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Item No: ");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel13.add(jLabel10);
        jLabel10.setBounds(25, 30, 100, 30);

        Qty.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Qty.setPreferredSize(new java.awt.Dimension(100, 30));
        Qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QtyKeyTyped(evt);
            }
        });
        jPanel13.add(Qty);
        Qty.setBounds(114, 100, 148, 30);

        ITEM_NO.setEditable(false);
        ITEM_NO.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ITEM_NO.setPreferredSize(new java.awt.Dimension(100, 30));
        ITEM_NO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ITEM_NOKeyTyped(evt);
            }
        });
        jPanel13.add(ITEM_NO);
        ITEM_NO.setBounds(114, 30, 148, 30);

        Order.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Order.setText("Order");
        Order.setPreferredSize(new java.awt.Dimension(75, 40));
        Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderActionPerformed(evt);
            }
        });
        jPanel13.add(Order);
        Order.setBounds(270, 140, 75, 40);

        ITEM_Name.setEditable(false);
        ITEM_Name.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ITEM_Name.setText(" ");
        ITEM_Name.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel13.add(ITEM_Name);
        ITEM_Name.setBounds(114, 65, 148, 30);

        jPanel14.add(jPanel13);
        jPanel13.setBounds(12, 7, 360, 190);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setText("Send Orders");
        jLabel16.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel14.add(jLabel16);
        jLabel16.setBounds(150, 220, 150, 30);

        jPanel8.add(jPanel14);
        jPanel14.setBounds(600, 10, 390, 480);

        expire_item.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        expire_item.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        expire_item.setModel(new javax.swing.table.DefaultTableModel(
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
        expire_item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expire_itemMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(expire_item);

        jPanel8.add(jScrollPane7);
        jScrollPane7.setBounds(20, 315, 290, 130);

        low_item.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        low_item.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        low_item.setModel(new javax.swing.table.DefaultTableModel(
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
        low_item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                low_itemMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(low_item);

        jPanel8.add(jScrollPane8);
        jScrollPane8.setBounds(320, 315, 260, 130);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel24.setText("Today Expired Items");
        jLabel24.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel8.add(jLabel24);
        jLabel24.setBounds(90, 280, 150, 30);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel27.setText("Low Level Items");
        jLabel27.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel8.add(jLabel27);
        jLabel27.setBounds(370, 280, 150, 30);

        remove.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        remove.setText("Remove Expire Item");
        remove.setPreferredSize(new java.awt.Dimension(190, 40));
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel8.add(remove);
        remove.setBounds(20, 450, 190, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RestBack2.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1010, 500));
        jPanel8.add(jLabel1);
        jLabel1.setBounds(0, 0, 1010, 500);

        background.add(jPanel8);
        jPanel8.setBounds(200, 75, 1010, 500);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Restuarant.jpg"))); // NOI18N
        background.add(jLabel11);
        jLabel11.setBounds(0, 0, 1366, 628);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_noActionPerformed

    private void item_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_noKeyTyped
        
        char c =evt.getKeyChar();
        
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)))
        {
            item_no.setBackground(Color.yellow);
            getToolkit().beep();
            evt.consume();
        }
        
        else
        {
            item_no.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_item_noKeyTyped

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        
        String meal_Name =meal_name.getText();
        String meal_id =item_no.getText();

        if(search_meal.isSelected())
        {
            try 
            {
                String sql1 = "Select itemNo,mealName,expDate,quantity from res_meal where mealName like '%"+meal_Name+"%'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                
                meal_table.setModel(DbUtils.resultSetToTableModel(rs));
            } 
            
            catch (Exception e) 
            {
            }
        }

        else
        {
            try
            {
                String sql = "Select itemNo,mealName,expDate,quantity from res_meal where itemNo='"+meal_id+"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                
                meal_table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            
            catch(Exception e)
            {
            }
        }
    }//GEN-LAST:event_searchActionPerformed

    private void search_mealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_mealActionPerformed
        
        if(search_meal.isSelected())
        {
            item_no.setText("");
            meal_name.setEnabled(true);
            item_no.setEnabled(false);
        } 
        
        else
        {
            meal_name.setEnabled(false);
            item_no.setEnabled(true);
            meal_name.setText("");
        }
    }//GEN-LAST:event_search_mealActionPerformed

    private void meal_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meal_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meal_nameActionPerformed

    private void meal_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_meal_nameKeyTyped
        
        char c =evt.getKeyChar();
        
        if((Character.isDigit(c)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            meal_name.setBackground(Color.red);
            evt.consume();
        }
        
        else
        {
            meal_name.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_meal_nameKeyTyped

    private void reset_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_tableActionPerformed
        
        item_no.setText("");
        meal_name.setText("");
       
        tablemeal();
        
    }//GEN-LAST:event_reset_tableActionPerformed

    private void meal_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meal_tableMouseClicked
        
        int r = meal_table.getSelectedRow();
        String reoder = meal_table.getValueAt(r, 0).toString();
        String reodern = meal_table.getValueAt(r, 1).toString();
        ITEM_NO.setText(reoder);
        ITEM_Name.setText(reodern);
        
    }//GEN-LAST:event_meal_tableMouseClicked

    private void QtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyKeyTyped
        
        char c =evt.getKeyChar();
        
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)))
        {
            Qty.setBackground(Color.yellow);
            getToolkit().beep();
            evt.consume();
        }
        
        else
        {
            Qty.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_QtyKeyTyped

    private void ITEM_NOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ITEM_NOKeyTyped
       
        char c =evt.getKeyChar();
       
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)))
        {
            ITEM_NO.setBackground(Color.yellow);
            getToolkit().beep();
            evt.consume();
        }
        
        else
        {
            ITEM_NO.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_ITEM_NOKeyTyped

    private void OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderActionPerformed
        
        String Item_No = ITEM_NO.getText();
        String Qauntity = Qty.getText();

        int x = JOptionPane.showConfirmDialog(null, "Confirm This To Order");
       
        if(x==0)
        {
            try 
            {
                String SQl = "INSERT INTO res_order (itmno,quantity,OrderedDate,status) values ('"+Item_No+"','"+Qauntity+"',sysdate(),'N')";
                pst = con.prepareStatement(SQl);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Order Completed");
            }
            
            catch (Exception e)
            {
            }
        }
        
        ordroutgone();
        ITEM_NO.setText("");
        Qty.setText("");
        ITEM_Name.setText("");
        
    }//GEN-LAST:event_OrderActionPerformed

    private void expire_itemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expire_itemMouseClicked
    }//GEN-LAST:event_expire_itemMouseClicked

    private void low_itemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_low_itemMouseClicked
        
        int r = low_item.getSelectedRow();
        String reoder = low_item.getValueAt(r, 0).toString();
        String reodern = low_item.getValueAt(r, 1).toString();
        ITEM_Name.setText(reodern);
        ITEM_NO.setText(reoder);
        
    }//GEN-LAST:event_low_itemMouseClicked

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
    
        int x = JOptionPane.showConfirmDialog(null, "Confirm This Take Out");
        
        if(x==0)
        {
            LocalDate localDate = LocalDate.now();
            String EDate = localDate.toString();
            
            String item_No;
            String item_Name;
            
            try 
            {
                String sql1 = "Select itemNo,mealName from res_meal where expDate='"+EDate+"'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                
                while(rs.next()) 
                {
                    item_No = rs.getString("itemNo");
                    item_Name = rs.getString("mealName");
                    
                    String sql2="update res_meal set quantity ='0' where mealName='"+item_Name+"' and itemNo = '"+item_No+"'";
                    pst = con.prepareStatement(sql2);
                    pst.execute();
                }
            } 
            
            catch (Exception e) 
            {
            }
           
            tablemeal();
            ShowTodayExpire();
            Show_Below_10();
        }  
    }//GEN-LAST:event_removeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ITEM_NO;
    private javax.swing.JTextField ITEM_Name;
    private javax.swing.JButton Order;
    private javax.swing.JTable Oreder_table;
    private javax.swing.JTextField Qty;
    private javax.swing.JPanel background;
    private javax.swing.JTable expire_item;
    private javax.swing.JTextField item_no;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable low_item;
    private javax.swing.JTextField meal_name;
    private javax.swing.JTable meal_table;
    private javax.swing.JButton remove;
    private javax.swing.JButton reset_table;
    private javax.swing.JButton search;
    private javax.swing.JCheckBox search_meal;
    // End of variables declaration//GEN-END:variables
}
