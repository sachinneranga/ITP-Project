package Interface;

import MyCode.DBconnect;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class LeaveManagement extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pst = null;
    ResultSet rs=null;

    public LeaveManagement() {

        initComponents();
         //CONNECT TO DB
        con=DBconnect.connect();
         //load table
        
        
        tableload1();
        namecombo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        background = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        titel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rebox = new javax.swing.JTextField();
        edc = new com.toedter.calendar.JDateChooser();
        applydc = new com.toedter.calendar.JDateChooser();
        sdc = new com.toedter.calendar.JDateChooser();
        empnamebox = new javax.swing.JComboBox<>();
        empnolb = new javax.swing.JLabel();
        lenbox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        applytable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EmpNo");
        background.add(jLabel2);
        jLabel2.setBounds(60, 150, 110, 22);

        titel.setBackground(new java.awt.Color(204, 204, 255));
        titel.setFont(new java.awt.Font("Bodoni MT Black", 3, 36)); // NOI18N
        titel.setForeground(new java.awt.Color(255, 255, 255));
        titel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titel.setText("Leave Managment");
        titel.setPreferredSize(new java.awt.Dimension(1366, 40));
        background.add(titel);
        titel.setBounds(0, 20, 1366, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date");
        background.add(jLabel3);
        jLabel3.setBounds(60, 190, 110, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Number of Days");
        background.add(jLabel4);
        jLabel4.setBounds(60, 230, 150, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Reason");
        background.add(jLabel5);
        jLabel5.setBounds(60, 400, 110, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name");
        background.add(jLabel6);
        jLabel6.setBounds(60, 100, 110, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Start Date");
        background.add(jLabel7);
        jLabel7.setBounds(60, 270, 110, 22);
        background.add(rebox);
        rebox.setBounds(250, 350, 200, 110);
        background.add(edc);
        edc.setBounds(250, 310, 200, 30);
        background.add(applydc);
        applydc.setBounds(250, 190, 200, 30);
        background.add(sdc);
        sdc.setBounds(250, 270, 200, 30);

        empnamebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Employee Name" }));
        empnamebox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                empnameboxItemStateChanged(evt);
            }
        });
        empnamebox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empnameboxMouseClicked(evt);
            }
        });
        empnamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empnameboxActionPerformed(evt);
            }
        });
        background.add(empnamebox);
        empnamebox.setBounds(250, 100, 200, 30);

        empnolb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        empnolb.setForeground(new java.awt.Color(204, 204, 255));
        empnolb.setText("EmpNo");
        background.add(empnolb);
        empnolb.setBounds(250, 150, 160, 30);

        lenbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lenboxKeyTyped(evt);
            }
        });
        background.add(lenbox);
        lenbox.setBounds(250, 230, 200, 30);

        jButton1.setText("Apply Leave");
        jButton1.setPreferredSize(new java.awt.Dimension(110, 31));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        background.add(jButton1);
        jButton1.setBounds(60, 490, 130, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("End Date");
        background.add(jLabel8);
        jLabel8.setBounds(60, 310, 110, 22);

        jButton2.setText("Refresh");
        jButton2.setPreferredSize(new java.awt.Dimension(110, 31));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2);
        jButton2.setBounds(270, 490, 110, 40);

        applytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EmpNo", "Name", "Date", "Numofleave", "SDate", "EDate"
            }
        ));
        applytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applytableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(applytable);

        background.add(jScrollPane3);
        jScrollPane3.setBounds(500, 110, 840, 320);

        jButton3.setText("Accept Leave");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        background.add(jButton3);
        jButton3.setBounds(1050, 490, 160, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Untitled-1.jpg"))); // NOI18N
        background.add(jLabel12);
        jLabel12.setBounds(0, -50, 1420, 700);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        background.add(jScrollPane1);
        jScrollPane1.setBounds(1010, 10, 166, 30);

        getContentPane().add(background);
        background.setBounds(-2, 0, 1360, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empnameboxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_empnameboxActionPerformed

    private void empnameboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empnameboxMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_empnameboxMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        empnamebox.setSelectedItem("Select Employee Name");
        empnolb.setText(null);
        applydc.setDate(null);
        rebox.setText(null);
        sdc.setDate(null);
        edc.setDate(null);
        lenbox.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void empnameboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_empnameboxItemStateChanged
        String name = (String) empnamebox.getSelectedItem();
        String sq= "SELECT Empno FROM employee WHERE FName like '"+name+"%'  ";
         try
            {
                pst=con.prepareStatement(sq);
                rs=pst.executeQuery();
                
                while (rs.next ()) 
                {
                    empnolb.setText(rs.getString(1));
//                    String f = rs.getString(1);
//                    System.out.println(f);
                    
                }
                }
                
             catch (SQLException e)
            {
                System.out.println(e);
            }
    }//GEN-LAST:event_empnameboxItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        String name = (String) empnamebox.getSelectedItem();
        String empid=empnolb.getText();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String date1 =date.format(applydc.getDate());
        String nol=lenbox.getText();
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
        String sdate1 =date.format(sdc.getDate());
        SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
        String edate1 =date.format(edc.getDate());
        String reason=rebox.getText();
        
        if (nol.isEmpty() || date1.isEmpty() || sdate1.isEmpty() ||edate1.isEmpty()|| reason.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You missed some feield(s)");
        }
        else if ("Select Employee Name".equals(empnamebox) )
        {
            JOptionPane.showMessageDialog(null, "Invalid Selection \n HINT: Job title");
        }
        
        else
        {
        int x=JOptionPane.showConfirmDialog(null, "Are you sure, Do you want to add this record");
        if (x==0)
        {
        try {
            String ceq ;
            ceq = "INSERT INTO applyleave(Empno,Name,Date,Numofleave,SDate,EDate,Reason) VALUES('"+empid+"','"+name+"','"+date1+"','"+nol+"','"+sdate1+"','"+edate1+"','"+reason+"')";
            pst=con.prepareStatement(ceq);
            pst.execute();
            tableload1();
            
            empnamebox.setSelectedItem("Select Employee Name");
            empnolb.setText(null);
            applydc.setDate(null);
            rebox.setText(null);
            sdc.setDate(null);
            edc.setDate(null);
            lenbox.setText(null);
            
        } catch (Exception e) {
        }
            } 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         String name = (String) empnamebox.getSelectedItem();
        String empid=empnolb.getText();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String date1 =date.format(applydc.getDate());
        String nol=lenbox.getText();
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
        String sdate1 =date.format(sdc.getDate());
        SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd");
        String edate1 =date.format(edc.getDate());
        String reason=rebox.getText();
        jTextArea1.append("Muthuwali Beach Restaurant\n" + "Moratuwe\n" + "011 2255355\n" + "_______________________________________\n" + "\tLeave accepted slip\n\n" + "Employee Number\t" + empid + "\nEmployee Name\t" + name + "\nRequst Date\t\t" + date1 + "\nLeave Date\t\t" + sdate1 + "\nLeave end date\t" + edate1 + "\n\n\n" + "_______________________________________\n" + "\nLeave Requst accepted\n\n\nSignature\n\n\n.............................."); 
        try{

            boolean complete = jTextArea1.print();
            if(complete){

                JOptionPane.showMessageDialog(null, "Done printing","Information",JOptionPane.INFORMATION_MESSAGE);
            }
            else{

                JOptionPane.showMessageDialog(null,"printing","Printer",JOptionPane.ERROR_MESSAGE);
            }
        }catch(PrinterException e){

            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void applytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applytableMouseClicked
        empnamebox.setSelectedItem("Select Employee Name");
        empnolb.setText(null);
        applydc.setDate(null);
        rebox.setText(null);
        sdc.setDate(null);
        edc.setDate(null);
        lenbox.setText(null);
        
        

        int row = applytable.getSelectedRow();
        String eid = applytable.getValueAt(row, 0).toString();
        String name = applytable.getValueAt(row, 1).toString();
        try {
            Date date1 = new SimpleDateFormat ("yyyy-MM-dd").parse((String)applytable.getValueAt(row,2).toString());
             applydc.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nol = applytable.getValueAt(row, 3).toString();
        try {
            Date date1 = new SimpleDateFormat ("yyyy-MM-dd").parse((String)applytable.getValueAt(row,4).toString());
              sdc.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Date date1 = new SimpleDateFormat ("yyyy-MM-dd").parse((String)applytable.getValueAt(row,5).toString());
              edc.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        String reason = applytable.getValueAt(row, 6).toString();
        
    
        
        empnamebox.setSelectedItem(name);
        empnolb.setText(eid);
        rebox.setText(reason);
        lenbox.setText(nol);
        
        
       
    }//GEN-LAST:event_applytableMouseClicked

    private void lenboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lenboxKeyTyped
        
         char enter = evt.getKeyChar();
        
         if(!(Character.isDigit(enter))) {
        
            lenbox.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else {
            
            lenbox.setBackground(Color.WHITE);
            
        }
        
        
    }//GEN-LAST:event_lenboxKeyTyped

   
    
     public void tableload1() 
     {
         try {  
         
         String sql4;
         sql4="SELECT * FROM applyleave";
         pst=con.prepareStatement(sql4);
         rs=pst.executeQuery();
         applytable.setModel(DbUtils.resultSetToTableModel(rs));
             
         } catch (Exception e) {
             System.out.println(e); 
         }
     }
     
     
      public void namecombo()
        {
            try 
            {
               String getcombo = "SELECT FName From employee"; 
               
               pst = con.prepareStatement(getcombo);
               rs = pst.executeQuery();
               
               while (rs.next())
               {
                   System.out.println(rs);
                   String nm = rs.getString("FName");
                   System.out.println(nm);
                   empnamebox.addItem(nm);
               }
            } catch (SQLException e) {
            }
            
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser applydc;
    private javax.swing.JTable applytable;
    private javax.swing.JPanel background;
    private com.toedter.calendar.JDateChooser edc;
    private javax.swing.JComboBox<String> empnamebox;
    private javax.swing.JLabel empnolb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField lenbox;
    private javax.swing.JTextField rebox;
    private com.toedter.calendar.JDateChooser sdc;
    private javax.swing.JLabel titel;
    // End of variables declaration//GEN-END:variables

    
}
