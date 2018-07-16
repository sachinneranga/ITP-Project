package Interface;

import MyCode.DBconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class FullBoard2 extends javax.swing.JInternalFrame {
  
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    int x;
    int r;
    
    int FB2SRoom;
    int FB2DRoom;
    int FB2TRoom;
    int FB2NODate;
    
    String FB2CID;
    String FB2CName;
    String FB2Nic;
    String FB2TelNo;
    String FB2CType;
    String FB2PType;
    String FB2Date;
    String FB2BState = "Check-in";
    int FB2Adults;
    int FB2Children;
    
    String FB2SRooms;
    String FB2DRooms;
    String FB2TRooms;
    String FB2NODates;
    String FB2CN;
    String FB2Amount;
    String FB2AState;
    int FB2SPrice;
    int FB2DPrice;
    int FB2TPrice;
    int FB2SR;
    int FB2DR;
    int FB2TR;
    int FB2AvaSRoom;
    int FB2AvaDRoom;
    int FB2AvaTRoom;
    boolean FB2Pass = false;
    boolean FB2Have = false;
    boolean FB2Available = false;    
    
    public FullBoard2() {
        
        initComponents();
        
        con = DBconnect.connect();
        
        FB2loadlable();
        FB2loadtable();
        FB2fillfield1();
        FB2fillfield2();
        
    }
    
    public FullBoard2(String CID, String CName, String Nic, String TelNo, int Adults, int Children, String CType, String PType, String Date) {
    
        
        FB2CID = CID;
        FB2CName = CName;
        FB2Nic = Nic;
        FB2TelNo = TelNo;
        FB2Adults = Adults;
        FB2Children = Children;
        FB2CType = CType;
        FB2PType = PType;
        FB2Date = Date;
        
        initComponents();
        
        con = DBconnect.connect();
        
        FB2loadlable();
        FB2loadtable();
        FB2fillfield1();
        FB2fillfield2();

    } 

    public void FB2loadlable() {
      
        cidlable.setText(FB2CID);
        cnamelable.setText(FB2CName);
        
    }
    
    public void FB2loadtable() {
     
        try {
        
            sql = "SELECT CusID, SingleRoom, DoubleRoom, TripleRoom, NoOfDate, State FROM fullboardbooking";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        
            custable.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void FB2clear() {

        sroomfield.setText("0");
        droomfield.setText("0");
        troomfield.setText("0");
        nodatefield.setText("0");
        
    }
    
    public void FB2getvalue1() {
 
        FB2SRoom = Integer.valueOf(sroomfield.getText());
        FB2DRoom = Integer.valueOf(droomfield.getText());
        FB2TRoom = Integer.valueOf(troomfield.getText());
        FB2NODate = Integer.valueOf(nodatefield.getText());

    }
    
    public String FB2getcname() {
    
        try {
            
            sql = "SELECT * FROM customer WHERE CusID = '"+ FB2CID +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                
                FB2CN = rs.getString("CusName");
                
            }
        } 
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
        
        return FB2CN;
        
    }
    
    public void FB2fillfield1() {
    
        try {
            
            sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, NoOfDate FROM fullboardbooking WHERE CusID = '"+ FB2CID +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
            
                String sr = rs.getString("SingleRoom");
                String dr = rs.getString("DoubleRoom");
                String tr = rs.getString("TripleRoom");
                String nod = rs.getString("NoOfDate");
                
                sroomfield.setText(sr);
                droomfield.setText(dr);
                troomfield.setText(tr);
                nodatefield.setText(nod);
                
            }
        } 
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void FB2fillfield2() {
    
        int sum = FB2Adults + FB2Children;

        if(sum >= 3) {
        
            int tcount = sum / 3;
            int tre = sum % 3;
            
            String TRN = String.valueOf(tcount);
            troomfield.setText(TRN);
          
            if(tre >= 2) {
            
                int dcount = tre / 2;
                int dre = tre % 2;
                
                String DRN = String.valueOf(dcount);
                droomfield.setText(DRN);
                
                if(dre == 1) {
                
                    sroomfield.setText("1");
                
                }
                
                else if(dre == 0){
                
                    sroomfield.setText("0");
                
                }
            }
            
            else if(tre < 2) {
            
                if(tre == 1) {
                
                    sroomfield.setText("1");
                
                }
                
                else if(tre == 0){
                
                    sroomfield.setText("0");
                
                }
            }
        }
        
        else if(sum < 3) {
            
            if(sum >= 2) {
            
                int dcount = sum / 2;
                int dre = sum % 2;
                
                String DRN = String.valueOf(dcount);
                droomfield.setText(DRN);
                
                if(dre == 1) {
                
                    sroomfield.setText("1");
                
                }
                
                else if(dre == 0){
                
                    sroomfield.setText("0");
                
                }
            }
            
            else if(sum < 2) {
            
                if(sum == 1) {
                
                    sroomfield.setText("1");
                
                }
                
                else if(sum == 0){
                
                    sroomfield.setText("0");
                
                }
            }
        }
    }
    
    public void FB2getfullfvalue() {
    
        try {
            
            if("Full-Board".equals(FB2PType)) {
                
                sql = "SELECT SingleRoomPrice, DoubleRoomPrice, TripleRoomPrice FROM fullboard WHERE CusType = '"+ FB2CType +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
            
                while(rs.next()) {
                
                    FB2SPrice = Integer.valueOf(rs.getString("SingleRoomPrice"));
                    FB2DPrice = Integer.valueOf(rs.getString("DoubleRoomPrice"));
                    FB2TPrice = Integer.valueOf(rs.getString("TripleRoomPrice"));
                    
                }
            }  
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
    }
 
    public void FB2updateroom() {
    
        try {

            String Room;
            int Ava = 0;

            sql = "SELECT RoomType, Available FROM room";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()) {

                Room = rs.getString("RoomType");
                Ava = Integer.valueOf(rs.getString("Available"));
     
                if("Single Room".equals(Room)) {

                    FB2AvaSRoom = Ava - FB2SRoom;
                    
                    sql = "UPDATE room SET Available = '"+ FB2AvaSRoom +"' WHERE RoomType = '"+ Room +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    
                    Ava = 0;

                }

                else if("Double Room".equals(Room)) {

                    FB2AvaDRoom = Ava - FB2DRoom;
                    
                    sql = "UPDATE room SET Available = '"+ FB2AvaDRoom +"' WHERE RoomType = '"+ Room +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    
                    Ava = 0;
                    
                }
                
                else if("Triple Room".equals(Room)) {

                    FB2AvaTRoom = Ava - FB2TRoom;
                    
                    sql = "UPDATE room SET Available = '"+ FB2AvaTRoom +"' WHERE RoomType = '"+ Room +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    
                    Ava = 0;
                    
                }
            }
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }   
    }

    public void FB2updateroom2() {
    
        try {

            String Room;
            String St;
            int Ava = 0;
            int SR = 0;
            int DR = 0;
            int TR = 0;
            
            sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, State FROM fullboardbooking WHERE CusID = '"+ FB2CID +"'";
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
    
    public String FB2calcfullfamount() {
   
        FB2getvalue1();
        FB2getfullfvalue();
        
        float amounts = (FB2SRoom * FB2SPrice) + (FB2DRoom * FB2DPrice) + (FB2TRoom * FB2TPrice);
        float amount = amounts * FB2NODate;
        
        FB2Amount = String.valueOf(amount);
        
        return FB2Amount;
        
    }
    
    public int FB2getavailablesingle() {
    
        try {
            
            String sr = "Single Room";
            
            sql = "SELECT * FROM room WHERE RoomType = '"+ sr +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
            
                FB2SR = Integer.valueOf(rs.getString("Available"));
                
            }
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
        
        return FB2SR;
        
    }
    
    public int FB2getavailabledouble() {
    
        try {
            
            String dr = "Double Room";
            
            sql = "SELECT * FROM room WHERE RoomType = '"+ dr +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
            
                FB2DR = Integer.valueOf(rs.getString("Available"));
                
            }
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
        
        return FB2DR;
        
    }
    
    public int FB2getavailabletriple() {
    
        try {
            
            String tr = "Triple Room";
            
            sql = "SELECT * FROM room WHERE RoomType = '"+ tr +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
            
                FB2TR = Integer.valueOf(rs.getString("Available"));
                
            }
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
        
        return FB2TR;
        
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
        labletel2 = new javax.swing.JLabel();
        labletel1 = new javax.swing.JLabel();
        labletel = new javax.swing.JLabel();
        droomfield = new javax.swing.JTextField();
        nodatefield = new javax.swing.JTextField();
        troomfield = new javax.swing.JTextField();
        sroomfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        custable = new javax.swing.JTable();
        cidlable = new javax.swing.JLabel();
        clearbutton = new javax.swing.JButton();
        bookingbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
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
        jLabel1.setText("Full-Board Room Reservation");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(290, 10, 280, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Room Information");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 40, 210, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        cnamelable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cnamelable.setText("Customer Name");
        jPanel2.add(cnamelable);
        cnamelable.setBounds(164, 70, 190, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Customer Name");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 70, 126, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Single Room");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 100, 126, 25);

        labletel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel2.setText("Double Room");
        jPanel2.add(labletel2);
        labletel2.setBounds(20, 135, 126, 25);

        labletel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel1.setText("Triple Room");
        jPanel2.add(labletel1);
        labletel1.setBounds(20, 170, 126, 25);

        labletel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel.setText("No of Dates");
        jPanel2.add(labletel);
        labletel.setBounds(20, 200, 126, 25);

        droomfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        droomfield.setText("0");
        droomfield.setPreferredSize(new java.awt.Dimension(195, 25));
        droomfield.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                droomfieldMouseMoved(evt);
            }
        });
        droomfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                droomfieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                droomfieldMouseExited(evt);
            }
        });
        droomfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                droomfieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                droomfieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                droomfieldKeyTyped(evt);
            }
        });
        jPanel2.add(droomfield);
        droomfield.setBounds(164, 135, 195, 25);

        nodatefield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nodatefield.setText("1");
        nodatefield.setPreferredSize(new java.awt.Dimension(195, 25));
        nodatefield.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                nodatefieldMouseMoved(evt);
            }
        });
        nodatefield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nodatefieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nodatefieldMouseExited(evt);
            }
        });
        nodatefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nodatefieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nodatefieldKeyTyped(evt);
            }
        });
        jPanel2.add(nodatefield);
        nodatefield.setBounds(164, 200, 195, 25);

        troomfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        troomfield.setText("0");
        troomfield.setPreferredSize(new java.awt.Dimension(195, 25));
        troomfield.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                troomfieldMouseMoved(evt);
            }
        });
        troomfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                troomfieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                troomfieldMouseExited(evt);
            }
        });
        troomfield.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                troomfieldInputMethodTextChanged(evt);
            }
        });
        troomfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                troomfieldActionPerformed(evt);
            }
        });
        troomfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                troomfieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                troomfieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                troomfieldKeyTyped(evt);
            }
        });
        jPanel2.add(troomfield);
        troomfield.setBounds(164, 170, 195, 25);

        sroomfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sroomfield.setText("0");
        sroomfield.setPreferredSize(new java.awt.Dimension(195, 25));
        sroomfield.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sroomfieldMouseMoved(evt);
            }
        });
        sroomfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sroomfieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sroomfieldMouseExited(evt);
            }
        });
        sroomfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sroomfieldActionPerformed(evt);
            }
        });
        sroomfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sroomfieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sroomfieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sroomfieldKeyTyped(evt);
            }
        });
        jPanel2.add(sroomfield);
        sroomfield.setBounds(164, 100, 195, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Customer ID");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 40, 126, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reserved Customers");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 240, 210, 30);

        custable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        custable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cus ID", "Single Room", "Double Room", "triple Room", "No Of Dates"
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

        cidlable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cidlable.setText("001");
        jPanel2.add(cidlable);
        cidlable.setBounds(165, 40, 126, 25);

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
        bookingbutton.setText("Book");
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

    private void bookingbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbuttonActionPerformed

        try {
            
            FB2getvalue1();
            
            int asr = FB2getavailablesingle();
            int adr = FB2getavailabledouble();
            int atr = FB2getavailabletriple();
         
            if ((FB2CID.isEmpty()) || (FB2CName.equals("Customer Name"))) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
                
            }
            
            else if((FB2SRoom == 0) && (FB2DRoom == 0) && (FB2TRoom == 0)) {
            
                JOptionPane.showMessageDialog(null, "Please put the number \n of room");
                
            }

            else {
                
                x = JOptionPane.showConfirmDialog(null, "Do you want to add \n this record?");

                if(x == 0) {

                    if(asr < FB2SRoom) {

                        if(adr < FB2DRoom) {

                            if(atr < FB2TRoom) {

                                JOption JO1 = new JOption(1, "Not available room.");
                                JO1.setVisible(true);
    
                                sroomfield.setBackground(new Color(255, 102, 102));
                                droomfield.setBackground(new Color(255, 102, 102));
                                troomfield.setBackground(new Color(255, 102, 102));

                            }

                            else if(atr >= FB2TRoom) {

                                JOption JO2 = new JOption(1, "Not available single and", "double room.");
                                JO2.setVisible(true);

                                sroomfield.setBackground(new Color(255, 102, 102));
                                droomfield.setBackground(new Color(255, 102, 102));

                            }
                        }

                        else if(adr >= FB2DRoom) {

                            if(atr < FB2TRoom) {

                                JOption JO3 = new JOption(1, "Not available single and", "triple room.");
                                JO3.setVisible(true);

                                sroomfield.setBackground(new Color(255, 102, 102));
                                troomfield.setBackground(new Color(255, 102, 102));

                            }

                            else if(atr >= FB2TRoom) {

                                JOption JO4 = new JOption(1, "Not available single room.");
                                JO4.setVisible(true);

                                sroomfield.setBackground(new Color(255, 102, 102));

                            }
                        }
                    }

                    else if(asr >= FB2SRoom) {

                        if(adr < FB2DRoom) {

                            if(atr < FB2TRoom) {

                                JOption JO5 = new JOption(1, "Not available double and", "triple room.");
                                JO5.setVisible(true);

                                droomfield.setBackground(new Color(255, 102, 102));
                                troomfield.setBackground(new Color(255, 102, 102));

                            }

                            else if(atr >= FB2TRoom) {

                                JOption JO6 = new JOption(1, "Not available double room.");
                                JO6.setVisible(true);

                                droomfield.setBackground(new Color(255, 102, 102));

                            }
                        }

                        else if(adr >= FB2DRoom) {

                            if(atr < FB2TRoom) {

                                JOption JO7 = new JOption(1, "Not available triple room.");
                                JO7.setVisible(true);

                                troomfield.setBackground(new Color(255, 102, 102));

                            }

                            else if(atr >= FB2TRoom) {

                                String Amount = FB2calcfullfamount();

                                sql = "INSERT INTO customer(CusID, CusName, CusType, NIC_Passport, TelNo, PackageType, Adults, Children, Date) VALUES('"+ FB2CID +"', '"+ FB2CName +"', '"+ FB2CType +"', '"+ FB2Nic +"', '"+ FB2TelNo +"', '"+ FB2PType +"', '"+ FB2Adults +"', '"+ FB2Children +"', '"+ FB2Date +"')";
                                pst = con.prepareStatement(sql);
                                pst.execute();

                                if(true) {

                                    sql = "INSERT INTO fullboardbooking(CusID, SingleRoom, DoubleRoom, TripleRoom, NoOfDate, State) VALUES('"+ FB2CID +"', '"+ FB2SRoom +"', '"+ FB2DRoom +"', '"+ FB2TRoom +"', '"+ FB2NODate +"', '"+ FB2BState +"')";
                                    pst = con.prepareStatement(sql);
                                    pst.execute();

                                    if(true) {

                                        sql = "INSERT INTO amount(CusID, CusName, Amount) VALUES('"+ FB2CID +"', '"+ FB2CName +"', '"+ Amount +"')";
                                        pst = con.prepareStatement(sql);
                                        pst.execute();

                                        if(true) {

                                            FB2updateroom();

                                        }
                                    }

                                    JOption JOB = new JOption(1, "Booking Sucessful!");
                                    JOB.setVisible(true);

                                    FB2loadtable();

                                }  
                            }
                        }
                    }            
                }
            }
        }

        catch(Exception e) {

            System.out.println(e);

            JOption JO20 = new JOption(1, "Cannot do this booking");
            JO20.setVisible(true);
            
        }
    }//GEN-LAST:event_bookingbuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
 
        try {

            FB2getvalue1();
        
            x = JOptionPane.showConfirmDialog(null, "Do you want to DELETE this record?");

            if(x == 0) {
                
                if("Full-Board".equals(FB2PType)) {
                
                    FB2updateroom2();
                    
                    sql = "DELETE FROM fullboardbooking WHERE CusID = '"+ FB2CID +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    
                }
            
                sql = "DELETE FROM customer WHERE CusID = '"+ FB2CID +"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                
                JOption JOD = new JOption(1, "Delete Sucessful!");
                JOD.setVisible(true);
                
                FB2loadtable();
                FB2clear();

            }
        }

        catch(Exception e) {

            System.out.println(e);
            JOption JO8 = new JOption(1, "This customer did the payment.", "Cannot delete this details.");
            JO8.setVisible(true);

        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
 
        FB2clear();
        
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void custableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custableMouseClicked
    
        r = custable.getSelectedRow();

        FB2CID = custable.getValueAt(r, 0).toString();
        FB2SRooms = custable.getValueAt(r, 1).toString();
        FB2DRooms = custable.getValueAt(r, 2).toString();
        FB2TRooms = custable.getValueAt(r, 3).toString();
        FB2NODates = custable.getValueAt(r, 4).toString();
  
        FB2CName = FB2getcname();
        
        cidlable.setText(FB2CID);
        cnamelable.setText(FB2CName);
        sroomfield.setText(FB2SRooms);
        droomfield.setText(FB2DRooms);
        troomfield.setText(FB2TRooms);
        nodatefield.setText(FB2NODates);
        
    }//GEN-LAST:event_custableMouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
   
        try {
            
            FB2getvalue1();
            int asr = FB2getavailablesingle();
            int adr = FB2getavailabledouble();
            int atr = FB2getavailabletriple();
           
            if ((FB2CID.isEmpty()) || (FB2CName.equals("Customer Name"))) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
                
            }
            
            else if((FB2SRoom == 0) && (FB2DRoom == 0) && (FB2TRoom == 0)) {
            
                JOptionPane.showMessageDialog(null, "Please put the number \n of room");
                
            }

            else {
                
                sql = "SELECT * FROM payment WHERE CusID = '"+ FB2CID +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while(rs.next()) {

                    String CI = rs.getString("CusID");

                    if(FB2CID.equals(CI)) {

                        FB2Have = true;

                    }
                }

                if(FB2Have == true) {

                    JOption JO9 = new JOption(1, "This customer did the payment.", "Cannot update this details.");
                    JO9.setVisible(true);

                }

                else if(FB2Have == false) {

                    x = JOptionPane.showConfirmDialog(null, "Do you want to update \n this record?");

                    if(x == 0) {

                        if(asr < FB2SRoom) {

                        if(adr < FB2DRoom) {

                            if(atr < FB2TRoom) {

                                JOption JO10 = new JOption(1, "Not available room.");
                                JO10.setVisible(true);

                                sroomfield.setBackground(new Color(255, 102, 102));
                                droomfield.setBackground(new Color(255, 102, 102));
                                troomfield.setBackground(new Color(255, 102, 102));

                            }

                            else if(atr >= FB2TRoom) {

                                JOption JO11 = new JOption(1, "Not available single and", "double room.");
                                JO11.setVisible(true);

                                sroomfield.setBackground(new Color(255, 102, 102));
                                droomfield.setBackground(new Color(255, 102, 102));

                            }
                        }

                        else if(adr >= FB2DRoom) {

                            if(atr < FB2TRoom) {

                                JOption JO12 = new JOption(1, "Not available single and", "triple room.");
                                JO12.setVisible(true);

                                sroomfield.setBackground(new Color(255, 102, 102));
                                troomfield.setBackground(new Color(255, 102, 102));

                            }

                            else if(atr >= FB2TRoom) {

                                JOption JO13 = new JOption(1, "Not available single room.");
                                JO13.setVisible(true);

                                sroomfield.setBackground(new Color(255, 102, 102));

                            }
                        }
                    }

                    else if(asr >= FB2SRoom) {

                        if(adr < FB2DRoom) {

                            if(atr < FB2TRoom) {

                                JOption JO14 = new JOption(1, "Not available double and", "triple room.");
                                JO14.setVisible(true);

                                droomfield.setBackground(new Color(255, 102, 102));
                                troomfield.setBackground(new Color(255, 102, 102));

                            }

                            else if(atr >= FB2TRoom) {

                                JOption JO15 = new JOption(1, "Not available double room.");
                                JO15.setVisible(true);

                                droomfield.setBackground(new Color(255, 102, 102));

                            }
                        }

                        else if(adr >= FB2DRoom) {

                            if(atr < FB2TRoom) {

                                JOption JO16 = new JOption(1, "Not available triple room.");
                                JO16.setVisible(true);

                                troomfield.setBackground(new Color(255, 102, 102));

                            }

                                else if(atr >= FB2TRoom) {

                                    FB2calcfullfamount();

                                    sql = "UPDATE customer SET CusName = '"+ FB2CName +"', NIC_Passport = '"+ FB2Nic +"', TelNo = '"+ FB2TelNo +"', CusType = '"+ FB2CType +"', PackageType = '"+ FB2PType +"', Adults = '"+ FB2Adults +"', Children = '"+ FB2Children +"' WHERE CusID = '"+ FB2CID +"' ";
                                    pst = con.prepareStatement(sql);
                                    pst.execute();

                                    if(true) {

                                        sql = "SELECT * FROM fullboardbooking WHERE CusID = '"+ FB2CID +"'";
                                        pst = con.prepareStatement(sql);
                                        rs = pst.executeQuery();

                                        while(rs.next()) {

                                            String CI = rs.getString("CusID");

                                            if(CI.equals(FB2CID)) {

                                                FB2Pass = true;

                                            }
                                        }

                                        if(FB2Pass == true) {

                                            FB2updateroom2();

                                            sql = "UPDATE fullboardbooking SET SingleRoom = '"+ FB2SRoom +"', DoubleRoom = '"+ FB2DRoom +"', TripleRoom = '"+ FB2TRoom +"', NoOfDate = '"+ FB2NODate +"' WHERE CusID = '"+ FB2CID +"'";
                                            pst = con.prepareStatement(sql);
                                            pst.execute();

                                        }

                                        else if(FB2Pass == false) {

                                            sql = "INSERT INTO fullboardbooking(CusID, SingleRoom, DoubleRoom, TripleRoom, NoOfDate, State) VALUES('"+ FB2CID +"', '"+ FB2SRoom +"', '"+ FB2DRoom +"', '"+ FB2TRoom +"', '"+ FB2NODate +"', '"+ FB2BState +"')";
                                            pst = con.prepareStatement(sql);
                                            pst.execute();

                                        }

                                        JOption JOU = new JOption(1, "Update Sucessful!");
                                        JOU.setVisible(true);

                                        FB2loadtable();

                                        if(true) {

                                            sql = "INSERT INTO amount(CusID, CusName, Amount) VALUES('"+ FB2CID +"', '"+ FB2CName +"', '"+ FB2Amount +"')";
                                            pst = con.prepareStatement(sql);
                                            pst.execute();

                                        }

                                        if(true) {

                                            FB2updateroom();

                                        }
                                    }  
                                }
                            }
                        }            
                    }
                }
            }
        }
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void sroomfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sroomfieldActionPerformed
    }//GEN-LAST:event_sroomfieldActionPerformed

    private void troomfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_troomfieldActionPerformed
    }//GEN-LAST:event_troomfieldActionPerformed

    private void troomfieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_troomfieldInputMethodTextChanged
    }//GEN-LAST:event_troomfieldInputMethodTextChanged

    private void troomfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_troomfieldMouseClicked

        String TRm = troomfield.getText();
        
        if("0".equals(TRm)) {
        
            troomfield.setText("");
            
        }
    }//GEN-LAST:event_troomfieldMouseClicked

    private void troomfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_troomfieldKeyReleased

        String TRm = troomfield.getText();
        int TRM = Integer.valueOf(TRm);
        int ATR = FB2getavailabletriple();
        
        if("0".equals(TRm)) {

            troomfield.setBackground(Color.white);
            
        }
        
        else if(ATR < TRM) {
        
            troomfield.setBackground(new Color(255, 102, 102));
            
        }
        
        else {
        
            troomfield.setBackground(Color.white);
            
        }
    }//GEN-LAST:event_troomfieldKeyReleased

    private void sroomfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sroomfieldMouseClicked
        
        String SRm = sroomfield.getText();
        
        if("0".equals(SRm)) {
        
            sroomfield.setText("");
            
        }
    }//GEN-LAST:event_sroomfieldMouseClicked

    private void droomfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_droomfieldMouseClicked
        
        String DRm = droomfield.getText();
        
        if("0".equals(DRm)) {
        
            droomfield.setText("");
            
        }
    }//GEN-LAST:event_droomfieldMouseClicked

    private void nodatefieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nodatefieldMouseClicked
       
        String NDt = nodatefield.getText();
        
        if("1".equals(NDt)) {
        
            nodatefield.setText("");
            
        }
    }//GEN-LAST:event_nodatefieldMouseClicked

    private void sroomfieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sroomfieldMouseMoved
        
        String SRm = sroomfield.getText();
        
        if(SRm.isEmpty()) {
        
            sroomfield.setText("0");
            
        }
    }//GEN-LAST:event_sroomfieldMouseMoved

    private void droomfieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_droomfieldMouseMoved
        
        String DRm = droomfield.getText();
        
        if(DRm.isEmpty()) {
        
            droomfield.setText("0");
            
        }
    }//GEN-LAST:event_droomfieldMouseMoved

    private void troomfieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_troomfieldMouseMoved
        
        String TRm = troomfield.getText();
        
        if(TRm.isEmpty()) {
        
            troomfield.setText("0");
            
        }
    }//GEN-LAST:event_troomfieldMouseMoved

    private void nodatefieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nodatefieldMouseMoved
        
        String NDt = nodatefield.getText();
        
        if(NDt.isEmpty()) {
        
            nodatefield.setText("1");
            
        }
        
        else if("0".equals(NDt)) {
        
            nodatefield.setText("1");
            
        }
    }//GEN-LAST:event_nodatefieldMouseMoved

    private void sroomfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sroomfieldKeyPressed
        
        String SRm = sroomfield.getText();

        if("0".equals(SRm)) {
        
            sroomfield.setText("");
            
        }
    }//GEN-LAST:event_sroomfieldKeyPressed

    private void droomfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_droomfieldKeyPressed
        
        String DRm = droomfield.getText();
        
        if("0".equals(DRm)) {
        
            droomfield.setText("");
            
        }
    }//GEN-LAST:event_droomfieldKeyPressed

    private void troomfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_troomfieldKeyPressed
        
        String TRm = troomfield.getText();
        
        if("0".equals(TRm)) {
        
            troomfield.setText("");
            
        }
    }//GEN-LAST:event_troomfieldKeyPressed

    private void nodatefieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nodatefieldKeyPressed
        
        String NDt = nodatefield.getText();
        
        if("0".equals(NDt)) {
        
            nodatefield.setText("");
            
        }
    }//GEN-LAST:event_nodatefieldKeyPressed

    private void droomfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_droomfieldKeyReleased
        
        String DRm = droomfield.getText();
        int DRM = Integer.valueOf(DRm);
        int ADR = FB2getavailabledouble();
        
        if("0".equals(DRm)) {

            droomfield.setBackground(Color.white);
            
        }
        
        else if(ADR < DRM) {
        
            droomfield.setBackground(new Color(255, 102, 102));
            
        }
        
        else {
        
            droomfield.setBackground(Color.white);
            
        }
    }//GEN-LAST:event_droomfieldKeyReleased

    private void sroomfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sroomfieldKeyReleased
        
        String SRm = sroomfield.getText();
        int SRM = Integer.valueOf(SRm);
        int ASR = FB2getavailablesingle();
        
        if("0".equals(SRm)) {

            sroomfield.setBackground(Color.white);
            
        }
        
        else if(ASR < SRM) {
        
            sroomfield.setBackground(new Color(255, 102, 102));
            
        }
        
        else {
        
            sroomfield.setBackground(Color.white);
            
        }
    }//GEN-LAST:event_sroomfieldKeyReleased

    private void sroomfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sroomfieldKeyTyped
        
        char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
        
            sroomfield.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else
        {
            
            sroomfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_sroomfieldKeyTyped

    private void droomfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_droomfieldKeyTyped
        
        char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
        
            droomfield.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else
        {
            
            droomfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_droomfieldKeyTyped

    private void troomfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_troomfieldKeyTyped
        
        char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
        
            troomfield.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else
        {
            
            troomfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_troomfieldKeyTyped

    private void nodatefieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nodatefieldKeyTyped
        
        char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
        
            nodatefield.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else
        {
            
            nodatefield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_nodatefieldKeyTyped

    private void sroomfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sroomfieldMouseExited
        
        int enter = Integer.valueOf(sroomfield.getText());

        if(enter >= 0) {
        
            sroomfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_sroomfieldMouseExited

    private void droomfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_droomfieldMouseExited
        
        int enter = Integer.valueOf(droomfield.getText());

        if(enter >= 0) {
        
            droomfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_droomfieldMouseExited

    private void troomfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_troomfieldMouseExited
        
        int enter = Integer.valueOf(troomfield.getText());

        if(enter >= 0) {
        
            troomfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_troomfieldMouseExited

    private void nodatefieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nodatefieldMouseExited
        
        int enter = Integer.valueOf(nodatefield.getText());

        if(enter >= 1) {
        
            nodatefield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_nodatefieldMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton bookingbutton;
    private javax.swing.JLabel cidlable;
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel cnamelable;
    private javax.swing.JTable custable;
    private javax.swing.JButton deletebutton;
    private javax.swing.JTextField droomfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel labletel2;
    private javax.swing.JTextField nodatefield;
    private javax.swing.JTextField sroomfield;
    private javax.swing.JTextField troomfield;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
