package Interface;

import MyCode.DBconnect;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.PageAttributes;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class PaymentManagement extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    int x;
    int y;
    int r;
    
    String PMCID;
    String PMCName;
    String PMAmount; 
    String PMState;
    String PMJOB;
    
    String PMPID;
    String PMPMethod;
    String PMPayDate;
    String PMPMethod2;
    String PMCN;  
    
    String PMCuType;
    String PMPType;
    String PMSRoom;
    String PMDRoom;
    String PMTRoom;
    String PMNORoom;
    String PMAdults;
    String PMChildren;
       
    public PaymentManagement() {

        initComponents();
        
        con = DBconnect.connect();
        
        PMloadlable1();
        PMloadlable2();
        PMloadtable();

    }

    public PaymentManagement(String CID, String CName, String Amount, String State, String JOB) {

        PMCID = CID;
        PMCName = CName;
        PMAmount = Amount;
        PMState = State;
        PMJOB = JOB;
        
        initComponents();
        
        con = DBconnect.connect();
        
        PMloadlable1();
        PMloadlable2();
        PMloadtable();

    }

    public void PMloadlable1() {
    
        try {
            
            sql = "SELECT PayID FROM payment ORDER BY PayID DESC LIMIT 1 ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
            
                int PI = Integer.valueOf(rs.getString("PayID"));
                
                int k = PI + 1;
                
                if(k < 10) {
                    
                    String d = String.valueOf(k);
                    String pi = "00" + d;
                    pidlable.setText(String.valueOf(pi));
                
                }
                
                else if(k >= 10) {
                
                    String d = String.valueOf(k);
                    String pi = "0" + d;
                    pidlable.setText(String.valueOf(pi));
                    
                }
            }
        } 
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void PMloadlable2() {

        cnamelable.setText(PMCName);
        amountlable.setText(PMAmount);
        
    }
    
    public void PMloadtable() {
     
        try {
        
            sql = "SELECT * FROM payment";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        
            paytable.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void PMgetvalue1() {
    
        PMPID = pidlable.getText(); 
        PMPMethod = pmethodcombo.getSelectedItem().toString();
        
    }
    
    public String PMgetcname() {
    
        try {
            
            sql = "SELECT * FROM customer WHERE CusID = '"+ PMCID +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                
                PMCN = rs.getString("CusName");
                
            }
        } 
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
        
        return PMCN;
        
    }
    
    public void PMgetdate() {
     
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        PMPayDate = df.format(d);

    }

    public void PMupdateroom() {
    
        try {

            String Room;
            String St;
            int Ava = 0;
            int SR = 0;
            int DR = 0;
            int TR = 0;
            
            sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, State FROM fullboardbooking WHERE CusID = '"+ PMCID +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()) {
                
                St = rs.getString("State");
                SR = Integer.valueOf(rs.getString("SingleRoom"));
                DR = Integer.valueOf(rs.getString("DoubleRoom"));
                TR = Integer.valueOf(rs.getString("TripleRoom"));
                
                if("Check-in".equals(St)) {
                    
                    sql = "SELECT RoomType, Available FROM room";
                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();

                    while(rs.next()) {

                        Room = rs.getString("RoomType");
                        Ava = Integer.valueOf(rs.getString("Available"));

                        if("Single Room".equals(Room)) {

                            int SRoom = Ava + SR;

                            sql = "UPDATE room SET Available = '"+ SRoom +"' WHERE RoomType = '"+ Room +"'";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                            Ava = 0;

                        }

                        else if("Double Room".equals(Room)) {

                            int DRoom = Ava + DR;

                            sql = "UPDATE room SET Available = '"+ DRoom +"' WHERE RoomType = '"+ Room +"'";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                            Ava = 0;

                        }

                        else if("Triple Room".equals(Room)) {

                            int TRoom = Ava + TR;

                            sql = "UPDATE room SET Available = '"+ TRoom +"' WHERE RoomType = '"+ Room +"'";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                            Ava = 0;

                        }
                    }
                }
            }
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
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
        amountlable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labletel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pmethodcombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paytable = new javax.swing.JTable();
        pidlable = new javax.swing.JLabel();
        cnamelable = new javax.swing.JLabel();
        viwebutton = new javax.swing.JButton();
        cancelbutton = new javax.swing.JButton();
        paybutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setText("Payment Management");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(384, 10, 210, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Payment Information");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 40, 210, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        amountlable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        amountlable.setText("0.0");
        jPanel2.add(amountlable);
        amountlable.setBounds(164, 100, 190, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Customer Name");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 70, 126, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Amount");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 100, 126, 25);

        labletel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel2.setText("Payment Method");
        jPanel2.add(labletel2);
        labletel2.setBounds(20, 135, 126, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Pay ID");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 40, 126, 25);

        pmethodcombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pmethodcombo.setMaximumRowCount(4);
        pmethodcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Method", "Cash", "Card" }));
        pmethodcombo.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(pmethodcombo);
        pmethodcombo.setBounds(164, 135, 140, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Payment Details");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(240, 180, 210, 30);

        paytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pay ID", "Cus ID", "Amount", "Method"
            }
        ));
        paytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paytableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(paytable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 210, 650, 300);

        pidlable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pidlable.setText("001");
        jPanel2.add(pidlable);
        pidlable.setBounds(165, 40, 126, 25);

        cnamelable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cnamelable.setText("Customer Name");
        jPanel2.add(cnamelable);
        cnamelable.setBounds(164, 70, 190, 25);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 50, 670, 520);

        viwebutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viwebutton.setText("View Bill");
        viwebutton.setPreferredSize(new java.awt.Dimension(100, 31));
        viwebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viwebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(viwebutton);
        viwebutton.setBounds(720, 310, 120, 31);

        cancelbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelbutton.setText("Cancel");
        cancelbutton.setPreferredSize(new java.awt.Dimension(100, 31));
        cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelbutton);
        cancelbutton.setBounds(730, 250, 100, 31);

        paybutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paybutton.setText("Pay");
        paybutton.setPreferredSize(new java.awt.Dimension(100, 31));
        paybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybuttonActionPerformed(evt);
            }
        });
        jPanel1.add(paybutton);
        paybutton.setBounds(730, 130, 100, 31);

        updatebutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updatebutton.setText("Update");
        updatebutton.setPreferredSize(new java.awt.Dimension(100, 31));
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(updatebutton);
        updatebutton.setBounds(730, 170, 100, 31);

        deletebutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deletebutton.setText("Delete");
        deletebutton.setPreferredSize(new java.awt.Dimension(100, 31));
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(deletebutton);
        deletebutton.setBounds(730, 210, 100, 31);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/InnerBackgrounds.jpg"))); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, 0, 880, 580);

        background.add(jPanel1);
        jPanel1.setBounds(230, 10, 880, 580);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IBackground.jpg"))); // NOI18N
        background.add(jLabel12);
        jLabel12.setBounds(0, 0, 1358, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
 
        try {
            
            PMgetvalue1();
           
            x = JOptionPane.showConfirmDialog(null, "Do you want to DELETE this record?");
            
            if(x == 0) {
               
                PMupdateroom();
                
                if("Card".equals(PMPMethod)) {
                    
                    sql = "DELETE FROM card WHERE PayID = '"+ PMPID +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    
                }
                
                sql = "DELETE FROM payment WHERE PayID = '"+ PMPID +"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                
                JOption JOD = new JOption(1, "Delete Sucessful!");
                JOD.setVisible(true);
                
                PMloadtable();
        
                if(true) {

                    sql = "DELETE FROM fullboardbooking WHERE CusID = '"+ PMCID +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    if(true) {
                        
                        sql = "DELETE FROM customer WHERE CusID = '"+ PMCID +"'";
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        
                    }
                }
            }
        }
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void paybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paybuttonActionPerformed
       
         try {
            
            PMgetvalue1();
            PMgetdate();
            
            if ((PMPID.isEmpty()) || (PMCName.equals("Customer Name") || (PMAmount.equals("0.0")))) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
                
            }
            
            else if (PMPMethod.equals("Select Method")) {
            
                JOptionPane.showMessageDialog(null, "Please select the method of payment.");
            
            }

            else {
                
                if("Cash".equals(PMPMethod)) {

                    x = JOptionPane.showConfirmDialog(null, "Do you want to add \n this record?");

                    if(x == 0) {

                        sql = "INSERT INTO payment(PayID, CusID, Amount, Method, PayDate) VALUES('"+ PMPID +"', '"+ PMCID +"', '"+ PMAmount +"', '"+ PMPMethod +"', '"+ PMPayDate +"')";
                        pst = con.prepareStatement(sql);
                        pst.execute();

                        JOption JOP = new JOption(1, "Payment Sucessful!");
                        JOP.setVisible(true);

                        PMloadtable();

                        if(true) {
                        
                            FileOutputStream out = new FileOutputStream(new File("C:\\Hotel PDF\\Customer Receipts\\Bill "+ PMPID +".pdf"));
                            Document doc = new Document();
                            PdfWriter wr = PdfWriter.getInstance(doc, out);

                            doc.open ();

                            BaseFont b = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                            Font f = new Font(b,20);

                            BaseFont b1 = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                            Font f1 = new Font(b1,13);

                            sql = "SELECT CusType, PackageType, Adults, Children FROM customer WHERE CusID = '"+ PMCID +"'";
                            pst = con.prepareStatement(sql);
                            rs = pst.executeQuery();

                            while(rs.next()) {
                                
                                PMCuType = rs.getString("CusType");
                                PMPType = rs.getString("PackageType");
                                PMAdults = rs.getString("Adults");
                                PMChildren = rs.getString("Children");

                            }

                            if("Full-Board".equals(PMPType)) {

                                sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, NoOfDate FROM fullboardbooking WHERE CusID = '"+ PMCID +"'";
                                pst = con.prepareStatement(sql);
                                rs = pst.executeQuery();

                                while(rs.next()) {

                                    PMSRoom = rs.getString("SingleRoom");
                                    PMDRoom = rs.getString("DoubleRoom");
                                    PMTRoom = rs.getString("TripleRoom");
                                    PMNORoom = rs.getString("NoOfDate");

                                }

                            }

                            doc.add(new Paragraph("               Muthuweli Beach Resort\n",f));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Muthuweli Beach Resort, \n" + "Moratuwa, \n" + "Sri Lanka.\n" + "011 2255355\n",f1));
                            doc.add(new Paragraph("Date: " + PMPayDate,f1));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Receipt No: " + PMPID,f1));
                            doc.add(new Paragraph("Method     : " + PMPMethod,f1));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Customer Type: " + PMCuType,f1));
                            doc.add(new Paragraph("Package Type  : " + PMPType,f1));
                            doc.add(new Paragraph("\n",f1));

                            if("Full-Board".equals(PMPType)) {

                                doc.add(new Paragraph("Single Rooms  : " + PMSRoom,f1));
                                doc.add(new Paragraph("Double Rooms: " + PMDRoom,f1));
                                doc.add(new Paragraph("Triple Rooms  : " + PMTRoom,f1));
                                doc.add(new Paragraph("No of Dates    : " + PMNORoom,f1));

                            }

                            else if("Half-Board".equals(PMPType)) {

                                doc.add(new Paragraph("Adults   : " + PMAdults,f1));
                                doc.add(new Paragraph("Children: " + PMChildren,f1));

                            }

                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Total Bill Amount: " + PMAmount,f1));
                            doc.add(new Paragraph());

                            doc.close();
                            
                        }
                    }
                }

                else if("Card".equals(PMPMethod)) {

                    Card C = new Card(PMPID, PMCID, PMCName, PMAmount, PMPMethod, PMPayDate, PMState, PMJOB);
                    JOption JO1 = new JOption(2, "Plese Fill More Details.", C);
                    JO1.setVisible(true);

                }
            }
        }
        
        catch(Exception e) {
         
            System.out.println(e);
            
            JOption JO20 = new JOption(1, "Cannot do this payment");
            JO20.setVisible(true);
                    
        }    
    }//GEN-LAST:event_paybuttonActionPerformed

    private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbuttonActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_cancelbuttonActionPerformed

    private void paytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paytableMouseClicked
         
        r = paytable.getSelectedRow();

        PMPID = paytable.getValueAt(r, 0).toString();
        PMCID = paytable.getValueAt(r, 1).toString();
        PMAmount = paytable.getValueAt(r, 2).toString();
        PMPMethod = paytable.getValueAt(r, 3).toString();

        PMCName = PMgetcname();
        
        pidlable.setText(PMPID);
        cnamelable.setText(PMCName);
        amountlable.setText(PMAmount);
        pmethodcombo.setSelectedItem(PMPMethod);
        
    }//GEN-LAST:event_paytableMouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        
        try {
            
            PMgetvalue1();

            if ((PMPID.isEmpty()) || (PMCName.equals("Customer Name") || (PMAmount.equals("0.0")))) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
                
            }
            
            else if (PMPMethod.equals("Select Method")) {
            
                JOptionPane.showMessageDialog(null, "Please select the method of payment.");
            
            }

            else {
                
                if("Cash".equals(PMPMethod)) {

                    x = JOptionPane.showConfirmDialog(null, "Do you want to update \n this record?");

                    if(x == 0) {

                        sql = "SELECT * FROM payment WHERE PayID = '"+ PMPID +"'";
                        pst = con.prepareStatement(sql);
                        rs = pst.executeQuery();

                        while(rs.next()) {

                            PMPMethod2 = rs.getString("Method");

                        }

                        if("Card".equals(PMPMethod2)) {

                            sql = "DELETE FROM card WHERE PayID = '"+ PMPID +"'";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                        }

                        sql = "UPDATE payment SET CusID = '"+ PMCID +"', Amount = '"+ PMAmount +"', Method = '"+ PMPMethod +"' WHERE PayID = '"+ PMPID +"' ";
                        pst = con.prepareStatement(sql);
                        pst.execute();

                        JOption JOU = new JOption(1, "Update Sucessful!");
                        JOU.setVisible(true);

                        PMloadtable();
                        
                        if(true) {
                        
                            FileOutputStream out = new FileOutputStream(new File("C:\\Hotel PDF\\Customer Receipts\\Bill "+ PMPID +".pdf"));
                            Document doc = new Document();
                            PdfWriter wr = PdfWriter.getInstance(doc, out);

                            doc.open ();

                            BaseFont b = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                            Font f = new Font(b,20);

                            BaseFont b1 = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                            Font f1 = new Font(b1,13);

                            sql = "SELECT CusType, PackageType, Adults, Children FROM customer WHERE CusID = '"+ PMCID +"'";
                            pst = con.prepareStatement(sql);
                            rs = pst.executeQuery();

                            while(rs.next()) {
                                
                                PMCuType = rs.getString("CusType");
                                PMPType = rs.getString("PackageType");
                                PMAdults = rs.getString("Adults");
                                PMChildren = rs.getString("Children");

                            }

                            if("Full-Board".equals(PMPType)) {

                                sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, NoOfDate FROM fullboardbooking WHERE CusID = '"+ PMCID +"'";
                                pst = con.prepareStatement(sql);
                                rs = pst.executeQuery();

                                while(rs.next()) {

                                    PMSRoom = rs.getString("SingleRoom");
                                    PMDRoom = rs.getString("DoubleRoom");
                                    PMTRoom = rs.getString("TripleRoom");
                                    PMNORoom = rs.getString("NoOfDate");

                                }

                            }

                            doc.add(new Paragraph("               Muthuweli Beach Resort\n",f));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Muthuweli Beach Resort, \n" + "Moratuwa, \n" + "Sri Lanka.\n" + "011 2255355\n",f1));
                            doc.add(new Paragraph("Date: " + PMPayDate,f1));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Receipt No: " + PMPID,f1));
                            doc.add(new Paragraph("Method     : " + PMPMethod,f1));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Customer Type: " + PMCuType,f1));
                            doc.add(new Paragraph("Package Type  : " + PMPType,f1));
                            doc.add(new Paragraph("\n",f1));

                            if("Full-Board".equals(PMPType)) {

                                doc.add(new Paragraph("Single Rooms  : " + PMSRoom,f1));
                                doc.add(new Paragraph("Double Rooms: " + PMDRoom,f1));
                                doc.add(new Paragraph("Triple Rooms  : " + PMTRoom,f1));
                                doc.add(new Paragraph("No of Dates    : " + PMNORoom,f1));

                            }

                            else if("Half-Board".equals(PMPType)) {

                                doc.add(new Paragraph("Adults   : " + PMAdults,f1));
                                doc.add(new Paragraph("Children: " + PMChildren,f1));

                            }

                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Total Bill Amount: " + PMAmount,f1));
                            doc.add(new Paragraph());

                            doc.close();
                            
                        }
                    }
                }

                else if ("Card".equals(PMPMethod)) {

                    Card C = new Card(PMPID, PMCID, PMCName, PMAmount, PMPMethod, PMPayDate, PMState, PMJOB);
                    JOption JO2 = new JOption(2, "Plese Fill More Details.", C);
                    JO2.setVisible(true);

                }
            }
        }
         
        catch(Exception e) {
        
            System.out.println(e);
            
        }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void viwebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viwebuttonActionPerformed
        
        if(Desktop.isDesktopSupported()) {
            
            try {
                
                File myFile = new File("C:\\Hotel PDF\\Customer Receipts");
                Desktop.getDesktop().open(myFile);
                
            }
            
            catch(Exception e) {
                
                System.out.println(e);
                
            }
        }
    }//GEN-LAST:event_viwebuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountlable;
    private javax.swing.JPanel background;
    private javax.swing.JButton cancelbutton;
    private javax.swing.JLabel cnamelable;
    private javax.swing.JButton deletebutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JButton paybutton;
    private javax.swing.JTable paytable;
    private javax.swing.JLabel pidlable;
    private javax.swing.JComboBox<String> pmethodcombo;
    private javax.swing.JButton updatebutton;
    private javax.swing.JButton viwebutton;
    // End of variables declaration//GEN-END:variables
}
