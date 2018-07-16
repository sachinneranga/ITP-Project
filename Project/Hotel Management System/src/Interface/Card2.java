package Interface;

import MyCode.DBconnect;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Card2 extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    int x;
    int r;
          
    String C2PID;
    String C2CName;
    String C2Amount;
    String C2PMethod;
    String C2PayDate;
    
    String C2CNo;
    String C2Bank;
    String C2EDate;
    String C2CType;
    String C2CN;
    String C2CID;
    String C2CurDate;
    int C2CDay;
    int C2CMonth;
    int C2CYear;
    int C2EDay;
    int C2EMonth;
    int C2EYear;
    boolean C2Pass = false;
    boolean C2Expiry = false;
  
    String C2CuType;
    String C2PType;
    String C2SRoom;
    String C2DRoom;
    String C2TRoom;
    String C2NORoom;
    String C2Adults;
    String C2Children;
    
    public Card2() {

        initComponents();

        con = DBconnect.connect();
        
        C2loadlable1();
        C2loadlable2();
        C2loadtable();
        
    }
    
    public Card2(String PID, String CID, String CName, String Amount, String PMethod, String PayDate) {

        C2PID = PID;
        C2CID = CID;
        C2CName = CName;
        C2Amount = Amount;
        C2PMethod = PMethod;
        C2PayDate = PayDate;
        
        initComponents();

        con = DBconnect.connect();
        
        C2loadlable1();
        C2loadlable2();
        C2loadtable();
                
    }

    public void C2loadlable1() {
    
        pidlable.setText(C2PID);
    
    }
    
    public void C2loadlable2() {

        cnamelable.setText(C2CName);
                
    }
    
    public void C2loadtable() {
     
        try {
        
            sql = "SELECT PayID, CardNo, Bank, ExDate, CardType FROM card";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        
            cardtable.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void C2clear() {

        cnofield.setText("");
        bankfield.setText("");
        edatefield.setDate(null);
        ctypecombo.setSelectedItem("Select Type");
        
    }
     
    public void C2getvalue1() {

        C2CNo = cnofield.getText();
        C2Bank = bankfield.getText();
        DateFormat ExDate= new SimpleDateFormat("yyyy-MM-dd");
        C2EDate = ExDate.format(edatefield.getDate());
        C2CType = ctypecombo.getSelectedItem().toString();

    }

    public void C2updateroom() {
    
        try {

            String Room;
            String St;
            int Ava = 0;
            int SR = 0;
            int DR = 0;
            int TR = 0;
            
            sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, State FROM fullboardbooking WHERE CusID = '"+ C2CID +"'";
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
    
    public boolean C2getdate() {
  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        C2CurDate = df.format(d);
        
        String [] CdateParts = C2CurDate.split("-");
        String Cday = CdateParts[2];
        String Cmonth = CdateParts[1];
        String Cyear = CdateParts[0];
        
        C2CDay = Integer.valueOf(Cday);
        C2CMonth = Integer.valueOf(Cmonth);
        C2CYear = Integer.valueOf(Cyear);
        
        String [] EdateParts = C2EDate.split("-");
        String Eday = EdateParts[2];
        String Emonth = EdateParts[1];
        String Eyear = EdateParts[0];
        
        C2EDay = Integer.valueOf(Eday);
        C2EMonth = Integer.valueOf(Emonth);
        C2EYear = Integer.valueOf(Eyear);
        
        if(C2CYear < C2EYear) {
           
            C2Expiry = false;
            
        }
        
        else if(C2CYear > C2EYear) {
            
            C2Expiry = true;
            
        }
        
        else if(C2CYear == C2EYear) {
        
            if(C2CMonth < C2EMonth) {
            
                C2Expiry = false;
                
            }
        
            else if(C2CMonth > C2EMonth) {
                
                C2Expiry = true;
            
            }
            
            else if(C2CMonth == C2EMonth) {
            
                if(C2CDay < C2EDay) {
                    
                    C2Expiry = false;
                    
                }
        
                else if(C2CDay > C2EDay) {
                    
                    C2Expiry = true;
            
                }
            }
        }
        
        return C2Expiry;
        
    }
    
    public String C2getcname() {
    
        try {
            
            sql = "SELECT * FROM payment WHERE PayID = '"+ C2PID +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
            
                C2CID  = rs.getString("CusID");
                        
            }
            
            sql = "SELECT * FROM customer WHERE CusID = '"+ C2CID +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                
                C2CN = rs.getString("CusName");
                
            }
        } 
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
        
        return C2CN;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cnamelable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labletel1 = new javax.swing.JLabel();
        labletel = new javax.swing.JLabel();
        bankfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cardtable = new javax.swing.JTable();
        pidlable = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ctypecombo = new javax.swing.JComboBox<>();
        cnofield = new javax.swing.JTextField();
        edatefield = new com.toedter.calendar.JDateChooser();
        clearbutton = new javax.swing.JButton();
        paybutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        viewbutton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setText("Enter Card Details");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(320, 10, 280, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Card Information");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 40, 210, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        cnamelable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cnamelable.setText("Customer Name");
        jPanel2.add(cnamelable);
        cnamelable.setBounds(165, 80, 190, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Customer Name");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 80, 126, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Card Number");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 120, 126, 25);

        labletel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel1.setText("Bank");
        jPanel2.add(labletel1);
        labletel1.setBounds(20, 160, 126, 25);

        labletel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel.setText("Expiry Date");
        jPanel2.add(labletel);
        labletel.setBounds(20, 200, 126, 25);

        bankfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bankfield.setPreferredSize(new java.awt.Dimension(195, 25));
        bankfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bankfieldKeyTyped(evt);
            }
        });
        jPanel2.add(bankfield);
        bankfield.setBounds(165, 160, 195, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Pay ID");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 40, 126, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Card Details");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 240, 210, 30);

        cardtable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cardtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pay ID", "Card Number", "PIN Code", "Bank", "Ex Date", "Card Type"
            }
        ));
        cardtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cardtable);

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

        pidlable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pidlable.setText("001");
        jPanel2.add(pidlable);
        pidlable.setBounds(165, 40, 126, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Card Type");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(390, 40, 126, 25);

        ctypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctypecombo.setMaximumRowCount(4);
        ctypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Credit", "Debit" }));
        ctypecombo.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(ctypecombo);
        ctypecombo.setBounds(520, 40, 140, 25);

        cnofield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cnofield.setPreferredSize(new java.awt.Dimension(195, 25));
        cnofield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cnofieldKeyTyped(evt);
            }
        });
        jPanel2.add(cnofield);
        cnofield.setBounds(165, 120, 195, 25);

        edatefield.setDateFormatString("yyyy-MM-dd");
        edatefield.setPreferredSize(new java.awt.Dimension(195, 25));
        jPanel2.add(edatefield);
        edatefield.setBounds(165, 200, 195, 25);

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

        paybutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paybutton.setText("Pay");
        paybutton.setPreferredSize(new java.awt.Dimension(110, 31));
        paybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybuttonActionPerformed(evt);
            }
        });
        jPanel1.add(paybutton);
        paybutton.setBounds(730, 130, 110, 31);

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

        viewbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewbutton.setText("View Bill");
        viewbutton.setPreferredSize(new java.awt.Dimension(100, 31));
        viewbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(viewbutton);
        viewbutton.setBounds(720, 310, 120, 31);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/InnerBackgrounds.jpg"))); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 0, 880, 580);

        background.add(jPanel1);
        jPanel1.setBounds(230, 10, 880, 580);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IBackground.jpg"))); // NOI18N
        background.add(jLabel11);
        jLabel11.setBounds(0, 0, 1358, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paybuttonActionPerformed

        try {
            
            C2getvalue1();
            boolean D = C2getdate();

            if ((C2PID.isEmpty()) || C2CName.equals("Customer Name")) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
                
            }
            
            else if ((C2CNo.isEmpty()) || C2Bank.isEmpty()) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
                
            }
            
            else if (D == true) {
            
                JOptionPane.showMessageDialog(null, "Card is expired");
            
            }
            
            else if (C2CType.equals("Select Type")) {
            
                JOptionPane.showMessageDialog(null, "Please select the type of card");
            
            }

            else {
                
                x = JOptionPane.showConfirmDialog(null, "Do you want to add \n this record?");

                if(x == 0) {

                    sql = "INSERT INTO payment(PayID, CusID, Amount, Method, PayDate) VALUES('"+ C2PID +"', '"+ C2CID +"', '"+ C2Amount +"', '"+ C2PMethod +"', '"+ C2PayDate +"')";
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    if(true) {

                        sql = "INSERT INTO card(PayID, CardNo, Bank, ExDate, CardType) VALUES('"+ C2PID +"', '"+ C2CNo +"', '"+ C2Bank +"', '"+ C2EDate +"', '"+ C2CType +"')";
                        pst = con.prepareStatement(sql);
                        pst.execute();

                        JOption JOP = new JOption(1, "Payment Sucessful!");
                        JOP.setVisible(true);

                        C2loadtable();

                        FileOutputStream out = new FileOutputStream(new File("C:\\Hotel PDF\\Customer Receipts\\Bill "+ C2PID +".pdf"));
                        Document doc = new Document();
                        PdfWriter wr = PdfWriter.getInstance(doc, out);

                        doc.open ();

                        BaseFont b = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                        Font f = new Font(b,20);

                        BaseFont b1 = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                        Font f1 = new Font(b1,13);

                        sql = "SELECT CusType, PackageType, Adults, Children FROM customer WHERE CusID = '"+ C2CID +"'";
                        pst = con.prepareStatement(sql);
                        rs = pst.executeQuery();

                        while(rs.next()) {
                            
                            C2CuType = rs.getString("CusType");
                            C2PType = rs.getString("PackageType");
                            C2Adults = rs.getString("Adults");
                            C2Children = rs.getString("Children");

                        }

                        if("Full-Board".equals(C2PType)) {

                            sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, NoOfDate FROM fullboardbooking WHERE CusID = '"+ C2CID +"'";
                            pst = con.prepareStatement(sql);
                            rs = pst.executeQuery();

                            while(rs.next()) {

                                C2SRoom = rs.getString("SingleRoom");
                                C2DRoom = rs.getString("DoubleRoom");
                                C2TRoom = rs.getString("TripleRoom");
                                C2NORoom = rs.getString("NoOfDate");

                            }

                        }

                        doc.add(new Paragraph("               Muthuweli Beach Resort\n",f));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Muthuweli Beach Resort, \n" + "Moratuwa, \n" + "Sri Lanka.\n" + "011 2255355\n",f1));
                            doc.add(new Paragraph("Date: " + C2PayDate,f1));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Receipt No: " + C2PID,f1));
                            doc.add(new Paragraph("Method     : " + C2PMethod,f1));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Customer Type: " + C2CuType,f1));
                            doc.add(new Paragraph("Package Type  : " + C2PType,f1));
                            doc.add(new Paragraph("\n",f1));

                            if("Full-Board".equals(C2PType)) {

                                doc.add(new Paragraph("Single Rooms  : " + C2SRoom,f1));
                                doc.add(new Paragraph("Double Rooms: " + C2DRoom,f1));
                                doc.add(new Paragraph("Triple Rooms  : " + C2TRoom,f1));
                                doc.add(new Paragraph("No of Dates    : " + C2NORoom,f1));

                            }

                            else if("Half-Board".equals(C2PType)) {

                                doc.add(new Paragraph("Adults   : " + C2Adults,f1));
                                doc.add(new Paragraph("Children: " + C2Children,f1));

                            }

                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Total Bill Amount: " + C2Amount,f1));
                            doc.add(new Paragraph());

                            doc.close();

                    }
                }
            }
        }
        
        catch(Exception e) {
        
            System.out.println(e);
            
            JOption JO20 = new JOption(1, "Cannot do this payment");
            JO20.setVisible(true);
            
        }
    }//GEN-LAST:event_paybuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
  
        try {

            C2getvalue1();
            
            x = JOptionPane.showConfirmDialog(null, "Do you want to DELETE this record?");

            if(x == 0) {
                
                C2updateroom();
                
                if("Card".equals(C2PMethod)) {
                    
                    sql = "DELETE FROM card WHERE PayID = '"+ C2PID +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    
                }
                
                sql = "DELETE FROM payment WHERE PayID = '"+ C2PID +"'";
                pst = con.prepareStatement(sql);
                pst.execute();

                JOption JOD = new JOption(1, "Delete Sucessful!");
                JOD.setVisible(true);
                
                C2loadtable();

                if(true) {

                    sql = "DELETE FROM fullboardbooking WHERE CusID = '"+ C2CID +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    if(true) {
                        
                        sql = "DELETE FROM customer WHERE CusID = '"+ C2CID +"'";
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

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
  
        C2clear();
        
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        
        try {
            
            C2getvalue1();
            boolean D = C2getdate();

            if ((C2PID.isEmpty()) || C2CName.equals("Customer Name")) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
                
            }
            
            else if ((C2CNo.isEmpty()) || C2Bank.isEmpty()) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
                
            }
            
            else if (D == true) {
            
                JOptionPane.showMessageDialog(null, "Card is expired");
            
            }
            
            else if (C2CType.equals("Select Type")) {
            
                JOptionPane.showMessageDialog(null, "Please select the type of card");
            
            }

            else {

                if(x == 0) {

                    sql = "UPDATE payment SET CusID = '"+ C2CID +"', Amount = '"+ C2Amount +"', Method = '"+ C2PMethod +"' WHERE PayID = '"+ C2PID +"' ";
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    if(true) {

                        sql = "SELECT * FROM card WHERE PayID = '"+ C2PID +"'";
                        pst = con.prepareStatement(sql);
                        rs = pst.executeQuery();

                        while(rs.next()) {

                            String PI = rs.getString("PayID");

                            if(PI.equals(C2PID)) {

                                    C2Pass = true;

                            }
                        }

                        if(C2Pass == true) {

                            sql = "UPDATE card SET CardNo = '"+ C2CNo +"', Bank = '"+ C2Bank +"', ExDate = '"+ C2EDate +"', CardType = '"+ C2CType +"' WHERE PayID = '"+ C2PID +"'";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                            C2Pass = false;

                        }

                        else if(C2Pass == false) {

                            sql = "INSERT INTO card(PayID, CardNo, Bank, ExDate, CardType) VALUES('"+ C2PID +"', '"+ C2CNo +"', '"+ C2Bank +"', '"+ C2EDate +"', '"+ C2CType +"')";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                        }

                        JOption JOU = new JOption(1, "Update Sucessful!");
                        JOU.setVisible(true);

                        C2loadtable();

                        if(true) {

                            sql = "INSERT INTO card(PayID, CardNo, Bank, ExDate, CardType) VALUES('"+ C2PID +"', '"+ C2CNo +"', '"+ C2Bank +"', '"+ C2EDate +"', '"+ C2CType +"')";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                            JOption JOP = new JOption(1, "Payment Sucessful!");
                            JOP.setVisible(true);

                            C2loadtable();

                            FileOutputStream out = new FileOutputStream(new File("C:\\Hotel PDF\\Customer Receipts\\Bill "+ C2PID +".pdf"));
                            Document doc = new Document();
                            PdfWriter wr = PdfWriter.getInstance(doc, out);

                            doc.open ();

                            BaseFont b = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                            Font f = new Font(b,20);

                            BaseFont b1 = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                            Font f1 = new Font(b1,13);

                            sql = "SELECT CusType, PackageType, Adults, Children FROM customer WHERE CusID = '"+ C2CID +"'";
                            pst = con.prepareStatement(sql);
                            rs = pst.executeQuery();

                            while(rs.next()) {

                                C2CuType = rs.getString("CusType");
                                C2PType = rs.getString("PackageType");
                                C2Adults = rs.getString("Adults");
                                C2Children = rs.getString("Children");

                            }

                            if("Full-Board".equals(C2PType)) {

                                sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, NoOfDate FROM fullboardbooking WHERE CusID = '"+ C2CID +"'";
                                pst = con.prepareStatement(sql);
                                rs = pst.executeQuery();

                                while(rs.next()) {

                                    C2SRoom = rs.getString("SingleRoom");
                                    C2DRoom = rs.getString("DoubleRoom");
                                    C2TRoom = rs.getString("TripleRoom");
                                    C2NORoom = rs.getString("NoOfDate");

                                }

                            }

                            doc.add(new Paragraph("               Muthuweli Beach Resort\n",f));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Muthuweli Beach Resort, \n" + "Moratuwa, \n" + "Sri Lanka.\n" + "011 2255355\n",f1));
                            doc.add(new Paragraph("Date: " + C2PayDate,f1));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Receipt No: " + C2PID,f1));
                            doc.add(new Paragraph("Method     : " + C2PMethod,f1));
                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Customer Type: " + C2CuType,f1));
                            doc.add(new Paragraph("Package Type  : " + C2PType,f1));
                            doc.add(new Paragraph("\n",f1));

                            if("Full-Board".equals(C2PType)) {

                                doc.add(new Paragraph("Single Rooms  : " + C2SRoom,f1));
                                doc.add(new Paragraph("Double Rooms: " + C2DRoom,f1));
                                doc.add(new Paragraph("Triple Rooms  : " + C2TRoom,f1));
                                doc.add(new Paragraph("No of Dates    : " + C2NORoom,f1));

                            }

                            else if("Half-Board".equals(C2PType)) {

                                doc.add(new Paragraph("Adults   : " + C2Adults,f1));
                                doc.add(new Paragraph("Children: " + C2Children,f1));

                            }

                            doc.add(new Paragraph("\n",f1));
                            doc.add(new Paragraph("Total Bill Amount   : " + C2Amount,f1));
                            doc.add(new Paragraph());

                            doc.close();

                        }
                    }
                }
            }
        }
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void cardtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardtableMouseClicked
       
        try {
            
            r = cardtable.getSelectedRow();

            C2PID = cardtable.getValueAt(r, 0).toString();
            C2CNo = cardtable.getValueAt(r, 1).toString();
            C2Bank = cardtable.getValueAt(r, 2).toString();
            Date C2Edate = new SimpleDateFormat ("yyyy-MM-dd").parse((String)cardtable.getValueAt(r, 3).toString());
            C2CType = cardtable.getValueAt(r, 4).toString();

            C2CName = C2getcname();

            pidlable.setText(C2PID);
            cnamelable.setText(C2CName);
            cnofield.setText(C2CNo);
            bankfield.setText(C2Bank);
            edatefield.setDate(C2Edate);
            ctypecombo.setSelectedItem(C2CType);
            
        } 
        
        catch (Exception e) {
            
            System.out.println(e);
            
        }
    }//GEN-LAST:event_cardtableMouseClicked

    private void cnofieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnofieldKeyTyped
        
        char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
            
            cnofield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }
        
        else {
            
            cnofield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_cnofieldKeyTyped

    private void bankfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankfieldKeyTyped
        
        int enter = evt.getKeyChar();
    
        if(Character.isDigit(enter)) {
            
            bankfield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }

        else {
            
            bankfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_bankfieldKeyTyped

    private void viewbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbuttonActionPerformed
        
        if(Desktop.isDesktopSupported()) {
            
            try {
                
                File myFile = new File("C:\\Hotel PDF\\Customer Receipts");
                Desktop.getDesktop().open(myFile);
                
            }
            
            catch(Exception e) {
                
                System.out.println(e);
                
            }
        }
    }//GEN-LAST:event_viewbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JTextField bankfield;
    private javax.swing.JTable cardtable;
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel cnamelable;
    private javax.swing.JTextField cnofield;
    private javax.swing.JComboBox<String> ctypecombo;
    private javax.swing.JButton deletebutton;
    private com.toedter.calendar.JDateChooser edatefield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labletel;
    private javax.swing.JLabel labletel1;
    private javax.swing.JButton paybutton;
    private javax.swing.JLabel pidlable;
    private javax.swing.JButton updatebutton;
    private javax.swing.JButton viewbutton;
    // End of variables declaration//GEN-END:variables
}
