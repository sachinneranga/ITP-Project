package Interface;

import java.awt.print.PrinterException;
import java.util.Calendar;
import MyCode.DBconnect;
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

public class Payroll extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pst = null;
    ResultSet rs=null;
    String slip=null;
    String year4;
    public Payroll() {

        initComponents();
         //CONNECT TO DB
        con=DBconnect.connect();
         //load table
        tableload();
        namecombo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        titel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        monthcom = new javax.swing.JComboBox<>();
        allowlb = new javax.swing.JLabel();
        datec = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        namecombo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        etflb = new javax.swing.JLabel();
        empnolb = new javax.swing.JLabel();
        bslb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paytable = new javax.swing.JTable();
        otlb = new javax.swing.JLabel();
        yearlb = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        titel.setBackground(new java.awt.Color(204, 204, 255));
        titel.setFont(new java.awt.Font("Bodoni MT Black", 3, 36)); // NOI18N
        titel.setForeground(new java.awt.Color(255, 255, 255));
        titel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titel.setText("Payroll");
        titel.setPreferredSize(new java.awt.Dimension(1366, 40));
        background.add(titel);
        titel.setBounds(0, 20, 1366, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Month");
        background.add(jLabel6);
        jLabel6.setBounds(60, 260, 110, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EmpNo");
        background.add(jLabel2);
        jLabel2.setBounds(60, 150, 110, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date");
        background.add(jLabel3);
        jLabel3.setBounds(60, 210, 110, 22);

        monthcom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select month", "January", "February", "March", "April", "May", "June", "July", "Augest", "September", "Oct", "November", "Desember" }));
        monthcom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                monthcomItemStateChanged(evt);
            }
        });
        background.add(monthcom);
        monthcom.setBounds(250, 260, 190, 30);

        allowlb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        allowlb.setForeground(new java.awt.Color(204, 204, 255));
        allowlb.setText("Allowance");
        background.add(allowlb);
        allowlb.setBounds(250, 460, 190, 30);
        background.add(datec);
        datec.setBounds(250, 200, 190, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Basic Salary");
        background.add(jLabel7);
        jLabel7.setBounds(60, 310, 110, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("OT-Charge");
        background.add(jLabel8);
        jLabel8.setBounds(60, 360, 110, 22);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Allowance");
        background.add(jLabel10);
        jLabel10.setBounds(60, 460, 150, 22);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Name");
        background.add(jLabel11);
        jLabel11.setBounds(60, 102, 110, 20);

        namecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Employee Name" }));
        namecombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                namecomboItemStateChanged(evt);
            }
        });
        background.add(namecombo);
        namecombo.setBounds(250, 100, 190, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total ETF");
        background.add(jLabel14);
        jLabel14.setBounds(60, 410, 150, 22);

        etflb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etflb.setForeground(new java.awt.Color(204, 204, 255));
        etflb.setText("ETF");
        background.add(etflb);
        etflb.setBounds(250, 410, 190, 30);

        empnolb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        empnolb.setForeground(new java.awt.Color(204, 204, 255));
        empnolb.setText("EmpNo");
        background.add(empnolb);
        empnolb.setBounds(250, 150, 190, 30);

        bslb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bslb.setForeground(new java.awt.Color(204, 204, 255));
        bslb.setText("Basic Salary");
        background.add(bslb);
        bslb.setBounds(250, 310, 190, 30);

        paytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "EmpNo", "Name", "Date", "Month", "BasicSalary", "OTcharge", "TotalAllowance"
            }
        ));
        paytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paytableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(paytable);

        background.add(jScrollPane1);
        jScrollPane1.setBounds(550, 100, 780, 402);

        otlb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        otlb.setForeground(new java.awt.Color(204, 204, 255));
        otlb.setText("OT Charge");
        background.add(otlb);
        otlb.setBounds(250, 360, 190, 30);
        background.add(yearlb);
        yearlb.setBounds(450, 260, 90, 30);

        jButton3.setText("Payslip");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        background.add(jButton3);
        jButton3.setBounds(290, 520, 180, 40);

        jButton2.setText("Calculate Salary");
        jButton2.setPreferredSize(new java.awt.Dimension(110, 31));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2);
        jButton2.setBounds(60, 520, 180, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Untitled-1.jpg"))); // NOI18N
        background.add(jLabel12);
        jLabel12.setBounds(0, 0, 1358, 598);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        background.add(jScrollPane2);
        jScrollPane2.setBounds(930, 20, 166, 10);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namecomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_namecomboItemStateChanged
        String name = (String) namecombo.getSelectedItem();
        //String sq= "SELECT Empno,BasicSalary FROM employee WHERE FName like '"+name+"%'  ";
         try
            {
                String sq= "SELECT Empno,BasicSalary FROM employee WHERE FName like '"+name+"%'  ";
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
         
         try
            {
                String sq= "SELECT BasicSalary FROM employee WHERE FName like '"+name+"%'  ";
                pst=con.prepareStatement(sq);
                rs=pst.executeQuery();
                
                while (rs.next ()) 
                {
                    bslb.setText(rs.getString(1));
//                    String f = rs.getString(1);
//                    System.out.println(f);
                    
                }
                }
                
             catch (SQLException e)
            {
                System.out.println(e);
            }
    }//GEN-LAST:event_namecomboItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                String empno=empnolb.getText();
                String name=(String) namecombo.getSelectedItem();
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                String date1 =date.format(datec.getDate());
                String month=(String) monthcom.getSelectedItem();
                String year=yearlb.getText();
                String sal=bslb.getText();
   
                Double etf,bsal,petf;
                bsal=Double.valueOf(bslb.getText());
                
                try {
                    String sc="SELECT SUM(ETF) FROM salary WHERE Empno='"+empno+"'";
                    pst=con.prepareStatement(sc);
                    rs=pst.executeQuery();
                    
                    if(rs.next())
                    {
                        String b = rs.getString(1);
                        rs.close();
                        
                        if( b == null) {
                        petf = 0.0;
                        }
                        
                        else {
                        petf=Double.valueOf(b);
                        }
                        etf=((bsal*20)/100)+petf;
                        etflb.setText(String.valueOf(etf));
                        
                    }
            
        } catch (Exception e) {
        }
                
                
                
                try {
            String sql="SELECT sum(OThours) FROM atendance WHERE Empno = '"+empno+"' and Month='"+month+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
           
            
            if(rs.next())
            {
                String a = rs.getString(1);
                rs.close();
                
                Double ot,rate,oth;
                oth=Double.valueOf(a);
                rate=(bsal*0.7)/100;
                ot=oth*rate;
                otlb.setText(String.valueOf(ot));
                
                Double allow;
                allow=bsal+ot;
                allowlb.setText(String.valueOf(allow));
            }
            }
        catch (SQLException e) 
        {
            System.out.println(e);
        } 
                
              
        
                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String empno=empnolb.getText();
        String name=(String) namecombo.getSelectedItem();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String date1 =date.format(datec.getDate());
        String month=(String) monthcom.getSelectedItem();
        String year=yearlb.getText();
        String sal=bslb.getText();
        String ot=otlb.getText();
        String allow=allowlb.getText();
        String etf=etflb.getText();
        jTextArea1.append("Muthuwali Beach Restaurant\n" + "Moratuwe\n" + "011 2255355\n" + "_______________________________________\n" + "\tPayslip\n\n" + "Employee Number\t" + empno + "\nEmployee Name\t" + name + "\nMounth\t\t" + month +"\nYear\t\t" + year +  "\nDate\t\t" + date1 + "\n_______________________________________\n" + "\nOT charges\t\t" + ot+"\nTotal ETF\t\t" + etf +"\nBasic Salary\t\t" + sal +"\nTotal Salary\t\t" + allow + "\n\n\n" + "_______________________________________\n" + "\t\tThank you");
        
  
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

    private void monthcomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_monthcomItemStateChanged
        Calendar now = Calendar.getInstance();
        int year1= now.get(Calendar.YEAR);
        year4 = String.valueOf(year1);
        System.out.println(year4);
        
        yearlb.setText(year4);
    }//GEN-LAST:event_monthcomItemStateChanged

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        String empno=empnolb.getText();
        String name=(String) namecombo.getSelectedItem();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String date1 =date.format(datec.getDate());
        String month=(String) monthcom.getSelectedItem();
        String year=yearlb.getText();
        String sal=bslb.getText();
        String ot=otlb.getText();
        String allow=allowlb.getText();
        String etf=etflb.getText();
        
        
        if (date1.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "have to enter today date");
        }
        
        else if ("Select Employee Name".equals(namecombo) )
        {
            JOptionPane.showMessageDialog(null, "Invalid Selection \n HINT: Job title");
        }
        
        else if ("Select month".equals(monthcom) )
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
                        ceq = "INSERT INTO salary(Empno,Name,Date,Month,year,BasicSalary,OTcharge,TotalAllowance,ETF) VALUES('"+empno+"','"+name+"','"+date1+"','"+month+"','"+year+"','"+sal+"','"+ot+"','"+allow+"','"+etf+"')";
                        pst=con.prepareStatement(ceq);
                        pst.execute();
                        tableload();
                        
                         empnolb.setText("");
                         namecombo.setSelectedItem("Select Employee Name");
                         datec.setDate(null);
                         monthcom.setSelectedItem("Select month");
                         bslb.setText("");
                         yearlb.setText("");
                         otlb.setText("");
                         allowlb.setText("");
                         etflb.setText("");
                        
                        
                    }
                
                catch (SQLException ex) 
                {
                        Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(x==1) {
                        
                        empnolb.setText("");
                         namecombo.setSelectedItem("Select Employee Name");
                         datec.setDate(null);
                         monthcom.setSelectedItem("Select month");
                         bslb.setText("");
                         yearlb.setText("");
                         otlb.setText("");
                         allowlb.setText("");
                         etflb.setText("");
                        }
           
            
            
        }
    }//GEN-LAST:event_jButton2MouseExited

    private void paytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paytableMouseClicked
       empnolb.setText(null);
       namecombo.setSelectedItem("Select Employee Name");
       datec.setDate(null);
       monthcom.setSelectedItem("Select month");
       bslb.setText(null);
       yearlb.setText(null);
       otlb.setText(null);
       allowlb.setText(null);
       etflb.setText(null);
        
        

        int row = paytable.getSelectedRow();
        String eid = paytable.getValueAt(row, 0).toString();
        String name = paytable.getValueAt(row, 1).toString();
        try {
            Date date1 = new SimpleDateFormat ("yyyy-MM-dd").parse((String)paytable.getValueAt(row,2).toString());
              datec.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        String month = paytable.getValueAt(row, 3).toString();
        String year = paytable.getValueAt(row, 4).toString();
        String bsal = paytable.getValueAt(row, 5).toString();
        String ot = paytable.getValueAt(row, 6).toString();
        String allow = paytable.getValueAt(row, 7).toString();
        String etf = paytable.getValueAt(row, 8).toString();
    
        
        namecombo.setSelectedItem(name);
        empnolb.setText(eid);
        
        monthcom.setSelectedItem(month);
        yearlb.setText(year);
        bslb.setText(bsal);
        otlb.setText(ot);
        allowlb.setText(allow);
        etflb.setText(etf);
        
        
       
        
    }//GEN-LAST:event_paytableMouseClicked

    public void tableload() 
     {
         try {
         String sql5;
         sql5="SELECT * FROM salary";
         pst=con.prepareStatement(sql5);
         rs=pst.executeQuery();
         paytable.setModel(DbUtils.resultSetToTableModel(rs));
             
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
                   namecombo.addItem(nm);
               }
            } catch (SQLException e) {
            }
            
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allowlb;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bslb;
    private com.toedter.calendar.JDateChooser datec;
    private javax.swing.JLabel empnolb;
    private javax.swing.JLabel etflb;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> monthcom;
    private javax.swing.JComboBox<String> namecombo;
    private javax.swing.JLabel otlb;
    private javax.swing.JTable paytable;
    private javax.swing.JLabel titel;
    private javax.swing.JLabel yearlb;
    // End of variables declaration//GEN-END:variables
}
