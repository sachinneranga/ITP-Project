package Interface;

import MyCode.DBconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class CustomerReservation extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    int x;
    int y;
    int r;
    
    String CRState;
    
    String CRCID;
    String CRCName;
    String CRNic;
    String CRTelNo;
    String CRCType;
    String CRPType;
    String CRDate;
    String CRJOB;
    int CRAdults;
    int CRChildren;
    boolean CRNIC = false;
    boolean CRPassport = false;

    String CRAdultss;
    String CRChildrens;
    String CRAmount;
    String CRPType2;
    int CRAPrice;
    int CRCPrice;
    boolean CRhave = false;
    
    String CRBCID;
    String CRCDate;
    String CRBDate;
    int CRCDay;
    int CRCMonth;
    int CRCYear;
    int CRBDay;
    int CRBMonth;
    int CRBYear;
    int CRNDay;
    int CRNMonth;
    int CRNYear;
    int CRNCID;
    
    String CRCIDArray[];
    int CRDateArray[][];
    int CRNDataArray[][];
    
    public CustomerReservation() {

        initComponents();

        con = DBconnect.connect();
        
        CRloadlable();
        CRloadtable();
        CRupadterooms2();
        CRhidenicfield();
        
    }
    
    public CustomerReservation(String State, String JOB) {

        CRState = State;
        CRJOB = JOB;
                
        initComponents();

        con = DBconnect.connect();
        
        CRloadlable();
        CRloadtable();
        CRupadterooms2();
        CRhidenicfield();
        
    }
        
    public void CRloadlable() {
    
        try {
            
            sql = "SELECT CusID FROM customer ORDER BY CusID DESC LIMIT 1 ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
            
                int CI = Integer.valueOf(rs.getString("CusID"));
                
                int k = CI + 1;
                
                if(k < 10) {
                    
                    String d = String.valueOf(k);
                    String ci = "00" + d;
                    cidlable.setText(String.valueOf(ci));
                
                }
                
                else if(k >= 10) {
                
                    String d = String.valueOf(k);
                    String ci = "0" + d;
                    cidlable.setText(String.valueOf(ci));
                
                }
                
            }
        } 
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void CRloadtable() {
     
        try {
        
            sql = "SELECT * FROM customer";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        
            custable.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void CRclear() {
        
        CRloadlable();
        
        cnamefield.setText("");
        nicRadioButton.setSelected(false);
        passportRadioButton.setSelected(false);
        nicfield.setText("");
        telnofield.setText("");
        ctypecombo.setSelectedItem("Select Customer");
        ptypecombo.setSelectedItem("Select Package");
        adultsfield.setText("0");
        childrenfield.setText("0");
        
    }
    
    public void CRgetvalue1() {
    
        CRCID = cidlable.getText();
        CRCName = cnamefield.getText();
        CRNIC = nicRadioButton.isSelected();
        CRPassport = passportRadioButton.isSelected();
        CRTelNo = telnofield.getText();
        CRCType = ctypecombo.getSelectedItem().toString();
        CRPType = ptypecombo.getSelectedItem().toString();
        CRAdults = Integer.valueOf(adultsfield.getText());
        CRChildren = Integer.valueOf(childrenfield.getText());
        
        if((CRNIC == true) && (CRPassport == false)) {

            CRNic = nicfield.getText();
            
        }
        
        else if((CRNIC == false) && (CRPassport == true)) {
    
            CRNic = nicfield.getText();
            
        }   
    }
     
    public void CRgetdate() {
     
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        CRDate = df.format(d);

    }

    public void CRgethalfvalue() {
    
        try {
            
            CRgetvalue1();
            
            if("Half-Board".equals(CRPType)) {
                
                sql = "SELECT AdultsPrice, ChildrenPrice FROM halfboard WHERE CusType = '"+ CRCType +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
            
                while(rs.next()) {
                
                    CRAPrice = Integer.valueOf(rs.getString("AdultsPrice"));
                    CRCPrice = Integer.valueOf(rs.getString("ChildrenPrice"));
                    
                }
            }  
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
    }
 
    public void CRupdateroom() {
    
        try {

            String Room;
            String St;
            int Ava = 0;
            int SR = 0;
            int DR = 0;
            int TR = 0;
            
            sql = "SELECT SingleRoom, DoubleRoom, TripleRoom, State FROM fullboardbooking WHERE CusID = '"+ CRCID +"'";
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
    
    public String CRcalchalfamount() {
   
        CRgetvalue1();
        CRgethalfvalue();
        
        float amount = (CRAdults * CRAPrice) + (CRChildren * CRCPrice);
        
        CRAmount = String.valueOf(amount);
        
        return CRAmount;
        
    }
    
    public void CRgetdate2() {
     
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        CRCDate = df.format(d);
       
        String [] dateParts = CRCDate.split("-");
        String day = dateParts[2];
        String month = dateParts[1];
        String year = dateParts[0];
        
        CRCDay = Integer.valueOf(day);
        CRCMonth = Integer.valueOf(month);
        CRCYear = Integer.valueOf(year);
        
    }
    
    public void CRdecarray() {
    
        try {
            
            String St = "Check-in";
            int count=0;
            
            sql = "SELECT COUNT(*) FROM fullboardbooking WHERE State = '"+ St +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                
                count = Integer.valueOf(rs.getString(1));
                
            }
      
            CRCIDArray = new String[count];
            CRDateArray = new int[count][3];
            CRNDataArray = new int[count][4];
            
        } 
        
        catch(Exception e) {
           
            System.out.println(e);
            
        }
    }
    
    public void CRgetbooking() {
     
        try {
            
            CRdecarray();
            
            String ST = "Check-in";
            int i = 0;
 
            sql = "SELECT CusID FROM fullboardbooking WHERE State = '"+ ST +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                
                String cid = rs.getString("CusID");
         
                sql = "SELECT CusID, Date FROM customer WHERE CusID = '"+ cid +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while(rs.next()) {

                    CRBCID = rs.getString("CusID");
                    CRBDate = rs.getString("Date");
   
                    String [] dateParts = CRBDate.split("-");
                    String days = dateParts[2];
                    String months = dateParts[1];
                    String years = dateParts[0];

                    CRBDay = Integer.valueOf(days);
                    CRBMonth = Integer.valueOf(months);
                    CRBYear = Integer.valueOf(years);

                    CRCIDArray[i] = CRBCID;
                    CRDateArray[i][0] = CRBDay;
                    CRDateArray[i][1] = CRBMonth;
                    CRDateArray[i][2] = CRBYear;  

                    i++;

                }
            }
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }  
    }
        
    public void CRcalcdate() {
    
        try {
            
            CRgetbooking();

            String CID;
            int NCID;
            int nodate;
            int day;
            int month;
            int year;
                        
            for(int k=0; k<CRCIDArray.length; k++) {

                CID = CRCIDArray[k];
                NCID = Integer.valueOf(CID);
                
                sql = "SELECT NoOfDate FROM fullboardbooking WHERE CusID = '"+ CID +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
            
                while(rs.next()) {
                
                    nodate = Integer.valueOf(rs.getString("NoOfDate"));
                
                    day = CRDateArray[k][0];
                    month = CRDateArray[k][1];
                    year = CRDateArray[k][2];
                    
                    CRNDay = day + nodate;
                    
                    switch(month) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:

                            if(CRNDay > 31) {

                                int BDays = CRNDay - 31;
                                CRNDay = BDays;
                                CRNMonth = month + 1;
                                CRNYear = year;
                                
                            }

                            else {

                                CRNYear = year;
                                CRNMonth = month;

                            }
                        
                            break;

                        case 4:
                        case 6:
                        case 9:
                        case 11:

                            if(CRNDay > 30) {

                                int BDays = CRNDay - 30;
                                CRNDay = BDays;
                                CRNMonth = month + 1;
                                CRNYear = year;
                                
                            }

                            else {

                                CRNYear = year;
                                CRNMonth = month;

                            }
                        
                            break;

                        case 2:

                            if(CRNDay > 28) {

                                int BDays = CRNDay - 28;
                                CRNDay = BDays;
                                CRNMonth = month + 1;
                                CRNYear = year;
                                
                            }

                            else {

                                CRNYear = year;
                                CRNMonth = month;

                            }
                            
                            break;

                        case 12:

                            if(CRNDay > 31) {

                                int BDays = CRNDay - 31;
                                CRNDay = BDays;
                                CRNMonth = 1;
                                CRNYear = year + 1;
                                
                            }

                            else {

                                CRNYear = year;
                                CRNMonth = month;

                            }
                            
                            break;

                        default :

                            CRNYear = year;
                            CRNMonth = month;

                    } 
                }
            
                CRNDataArray[k][0] = NCID;
                CRNDataArray[k][1] = CRNDay;
                CRNDataArray[k][2] = CRNMonth;
                CRNDataArray[k][3] = CRNYear;
                
            }
        } 
            
        catch (Exception e) {
        
            System.out.println(e);
            
        }          
    }
    
    public void CRupdaterooms() {
    
        try {

            String NCID = "00" + String.valueOf(CRNCID);
            String Room;
            int Ava = 0;
            int SR = 0;
            int DR = 0;
            int TR = 0;
            
            sql = "SELECT SingleRoom, DoubleRoom, TripleRoom FROM fullboardbooking WHERE CusID = '"+ NCID +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()) {
                
                SR = Integer.valueOf(rs.getString("SingleRoom"));
                DR = Integer.valueOf(rs.getString("DoubleRoom"));
                TR = Integer.valueOf(rs.getString("TripleRoom"));
                
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
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }   
    }
    
    public void CRupadterooms2() {
    
        try {
            
            CRgetdate2();
            CRcalcdate();
        
            String CCid;
            int nday;
            int nmonth;
            int nyear;
            
            for(int d=0; d<CRCIDArray.length; d++) {
        
                CRNCID = CRNDataArray[d][0];
                CCid = "00" + String.valueOf(CRNCID);
                nday = CRNDataArray[d][1];
                nmonth = CRNDataArray[d][2];
                nyear = CRNDataArray[d][3];
            
                if(CRCYear == nyear) {
        
                    if(CRCMonth == nmonth) {
            
                        if(CRCDay > nday) {
                    
                            CRupdaterooms();
                            
                            String State = "Check-out";
                            
                            sql = "UPDATE fullboardbooking SET State = '"+ State +"' WHERE CusID = '"+ CCid +"'";
                            pst = con.prepareStatement(sql);
                            pst.execute();
                    
                        }
                    }
            
                    else if(CRCMonth > nmonth) {
                
                        CRupdaterooms();
                        
                        String State = "Check-out";
                            
                        sql = "UPDATE fullboardbooking SET State = '"+ State +"' WHERE CusID = '"+ CCid +"'";
                        pst = con.prepareStatement(sql);
                        pst.execute();
                                        
                    }
                }
        
                else if(CRCYear > nyear) {
            
                    CRupdaterooms();
                    
                    String State = "Check-out";
                            
                    sql = "UPDATE fullboardbooking SET State = '"+ State +"' WHERE CusID = '"+ CCid +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                                
                }
            }
        } 
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void CRhidenicfield() {
    
        CRNIC = nicRadioButton.isSelected();
        CRPassport = passportRadioButton.isSelected();
                
        if((CRNIC == false) && (CRPassport == false)) {
        
            nicfield.setEnabled(false); 
      
        }
    
        else if((CRNIC == true) || (CRPassport == true)) {
        
            nicfield.setEnabled(true);
         
        }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cidlable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labletel2 = new javax.swing.JLabel();
        labletel1 = new javax.swing.JLabel();
        labletel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nicfield = new javax.swing.JTextField();
        cnamefield = new javax.swing.JTextField();
        telnofield = new javax.swing.JTextField();
        adultsfield = new javax.swing.JTextField();
        childrenfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ptypecombo = new javax.swing.JComboBox<>();
        ctypecombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        custable = new javax.swing.JTable();
        passportRadioButton = new javax.swing.JRadioButton();
        nicRadioButton = new javax.swing.JRadioButton();
        clearbutton1 = new javax.swing.JButton();
        bookingbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setText("Reservation Management");
        jLabel1.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(400, 10, 250, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Customer Information");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 40, 210, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        cidlable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cidlable.setText("001");
        jPanel2.add(cidlable);
        cidlable.setBounds(185, 40, 126, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Customer Name");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 70, 126, 25);

        labletel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel2.setText("Tel No");
        jPanel2.add(labletel2);
        labletel2.setBounds(20, 135, 126, 25);

        labletel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel1.setText("Adults");
        jPanel2.add(labletel1);
        labletel1.setBounds(20, 170, 126, 25);

        labletel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel.setText("Children");
        jPanel2.add(labletel);
        labletel.setBounds(20, 200, 126, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Customer Type");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(390, 40, 126, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Package Type");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(390, 80, 126, 25);

        nicfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nicfield.setPreferredSize(new java.awt.Dimension(195, 25));
        nicfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nicfieldFocusLost(evt);
            }
        });
        nicfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nicfieldKeyTyped(evt);
            }
        });
        jPanel2.add(nicfield);
        nicfield.setBounds(185, 102, 195, 25);

        cnamefield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cnamefield.setPreferredSize(new java.awt.Dimension(195, 25));
        cnamefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cnamefieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnamefieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cnamefieldKeyTyped(evt);
            }
        });
        jPanel2.add(cnamefield);
        cnamefield.setBounds(185, 70, 195, 25);

        telnofield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        telnofield.setPreferredSize(new java.awt.Dimension(195, 25));
        telnofield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                telnofieldFocusLost(evt);
            }
        });
        telnofield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telnofieldKeyTyped(evt);
            }
        });
        jPanel2.add(telnofield);
        telnofield.setBounds(185, 135, 195, 25);

        adultsfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adultsfield.setText("0");
        adultsfield.setPreferredSize(new java.awt.Dimension(195, 25));
        adultsfield.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                adultsfieldMouseMoved(evt);
            }
        });
        adultsfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                adultsfieldFocusLost(evt);
            }
        });
        adultsfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adultsfieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adultsfieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adultsfieldMouseExited(evt);
            }
        });
        adultsfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adultsfieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adultsfieldKeyTyped(evt);
            }
        });
        jPanel2.add(adultsfield);
        adultsfield.setBounds(185, 170, 195, 25);

        childrenfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        childrenfield.setText("0");
        childrenfield.setPreferredSize(new java.awt.Dimension(195, 25));
        childrenfield.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                childrenfieldMouseMoved(evt);
            }
        });
        childrenfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                childrenfieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                childrenfieldMouseExited(evt);
            }
        });
        childrenfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                childrenfieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                childrenfieldKeyTyped(evt);
            }
        });
        jPanel2.add(childrenfield);
        childrenfield.setBounds(185, 200, 195, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Customer ID");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 40, 126, 25);

        ptypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ptypecombo.setMaximumRowCount(4);
        ptypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Package", "Half-Board", "Full-Board" }));
        ptypecombo.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(ptypecombo);
        ptypecombo.setBounds(520, 80, 140, 25);

        ctypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctypecombo.setMaximumRowCount(4);
        ctypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Customer", "Local", "Foreign" }));
        ctypecombo.setPreferredSize(new java.awt.Dimension(140, 25));
        ctypecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctypecomboActionPerformed(evt);
            }
        });
        jPanel2.add(ctypecombo);
        ctypecombo.setBounds(520, 40, 140, 25);

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
                "Cus ID", "Name", "NIC/Passport", "Tel No", "Adults", "Children", "Cus Type", "Package Type"
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

        buttonGroup1.add(passportRadioButton);
        passportRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passportRadioButton.setText("Passport");
        passportRadioButton.setPreferredSize(new java.awt.Dimension(90, 25));
        passportRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passportRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(passportRadioButton);
        passportRadioButton.setBounds(80, 100, 90, 25);

        buttonGroup1.add(nicRadioButton);
        nicRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nicRadioButton.setText("NIC");
        nicRadioButton.setPreferredSize(new java.awt.Dimension(55, 25));
        nicRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(nicRadioButton);
        nicRadioButton.setBounds(20, 100, 55, 25);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 50, 670, 520);

        clearbutton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clearbutton1.setText("Clear");
        clearbutton1.setPreferredSize(new java.awt.Dimension(110, 31));
        clearbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbutton1ActionPerformed(evt);
            }
        });
        jPanel1.add(clearbutton1);
        clearbutton1.setBounds(730, 250, 110, 31);

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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/InnerBackgrounds.jpg"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 0, 880, 580);

        background.add(jPanel1);
        jPanel1.setBounds(230, 10, 880, 580);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/IBackground.jpg"))); // NOI18N
        background.add(jLabel10);
        jLabel10.setBounds(0, 0, 1358, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
       
        try {

            CRgetvalue1();

            x = JOptionPane.showConfirmDialog(null, "Do you want to DELETE this record?");

            if(x == 0) {
                
                if("Full-Board".equals(CRPType)) {
                
                    CRupdateroom();
                    
                    sql = "DELETE FROM fullboardbooking WHERE CusID = '"+ CRCID +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    
                }
            
                sql = "DELETE FROM customer WHERE CusID = '"+ CRCID +"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                
                JOption JOD = new JOption(1, "Delete Sucessful!");
                JOD.setVisible(true);
                
                CRloadtable();
                CRclear();

            }
        }

        catch(Exception e) {

            System.out.println(e);
            JOption JO1 = new JOption(1, "This customer did the payment.", "Cannot delete this details.");
            JO1.setVisible(true);

        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void bookingbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbuttonActionPerformed
        
        try {
            
            CRgetvalue1();
            CRgetdate();
            CRcalchalfamount();
            
            if (CRCName.isEmpty() || (CRNic.isEmpty() || (CRTelNo.isEmpty()))) {
                
                JOptionPane.showMessageDialog(null, "You have null fields");   
            }
            
            else if((CRAdults == 0)) {
                
                JOptionPane.showMessageDialog(null, "Please put the number \n of adults");
            }
            
            else if (CRCType.equals("Select Customer")) {
            
                JOptionPane.showMessageDialog(null, "Please select the type of customer");
            }
            
            else if (CRPType.equals("Select Package")) {
            
                 JOptionPane.showMessageDialog(null, "Please select the type of package");
            }
            
            else {
                
                if("Half-Board".equals(CRPType)) {

                    x = JOptionPane.showConfirmDialog(null, "Do you want to add \n this record?");

                    if(x == 0) {

                        sql = "INSERT INTO customer(CusID, CusName, CusType, NIC_Passport, TelNo, PackageType, Adults, Children, Date) VALUES('"+ CRCID +"', '"+ CRCName +"', '"+ CRCType +"', '"+ CRNic +"', '"+ CRTelNo +"', '"+ CRPType +"', '"+ CRAdults +"', '"+ CRChildren +"', '"+ CRDate +"')";
                        pst = con.prepareStatement(sql);
                        pst.execute();

                        CRloadtable();

                        if(true) {

                            sql = "INSERT INTO amount(CusID, CusName, Amount) VALUES('"+ CRCID +"', '"+ CRCName +"', '"+ CRAmount +"')";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                        }

                        JOption JOB = new JOption(1, "Booking Sucessful!");
                        JOB.setVisible(true);

                        CRclear();

                    }
                }

                else if("Full-Board".equals(CRPType)) {

                    FullBoard FB = new FullBoard(CRCID, CRCName, CRNic, CRTelNo, CRAdults, CRChildren, CRCType, CRPType, CRDate, CRState, CRJOB);
                    JOption JO2 = new JOption(2, "Plese Fill More Details.", FB);
                    JO2.setVisible(true);
                    
                } 
            }
        }
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
    }//GEN-LAST:event_bookingbuttonActionPerformed

    private void custableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custableMouseClicked
        
        r = custable.getSelectedRow();

        CRCID = custable.getValueAt(r, 0).toString();
        CRCName = custable.getValueAt(r, 1).toString();
        CRNic = custable.getValueAt(r, 2).toString();
        CRTelNo = custable.getValueAt(r, 3).toString();
        CRCType = custable.getValueAt(r, 4).toString();
        CRPType = custable.getValueAt(r, 5).toString();
        CRAdultss = custable.getValueAt(r, 6).toString();
        CRChildrens =  custable.getValueAt(r, 7).toString();

        cidlable.setText(CRCID);
        cnamefield.setText(CRCName);
        nicfield.setText(CRNic);
        telnofield.setText(CRTelNo);
        ctypecombo.setSelectedItem(CRCType);
        ptypecombo.setSelectedItem(CRPType);
        adultsfield.setText(CRAdultss);
        childrenfield.setText(CRChildrens);
        
        if((CRNic.endsWith("V")) || (CRNic.endsWith("v"))) {
        
            nicRadioButton.setSelected(true);
        }
        
        else {
        
            passportRadioButton.setSelected(true);
            
        }
        
        CRhidenicfield();
        
    }//GEN-LAST:event_custableMouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
    
        try {
            
            CRgetvalue1();
            CRcalchalfamount();
 
            if (CRCName.isEmpty() || (CRNic.isEmpty() || (CRTelNo.isEmpty()))) {
            
                JOptionPane.showMessageDialog(null, "You have null fields");   
            }
            
            else if((CRAdults == 0)) {
            
                JOptionPane.showMessageDialog(null, "Please put the number \n of adults");
            }
            
            else if (CRCType.equals("Select Customer")) {
            
                JOptionPane.showMessageDialog(null, "Please select the type of customer");
            }
            
            else if (CRPType.equals("Select Package")) {
            
                 JOptionPane.showMessageDialog(null, "Please select the type of package");
            }
            
            else {
                
                sql = "SELECT * FROM payment WHERE CusID = '"+ CRCID +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while(rs.next()) {

                    String CI = rs.getString("CusID");

                    if(CRCID.equals(CI)) {

                        CRhave = true;

                    }
                }

                if(CRhave == true) {

                    JOption JO3 = new JOption(1, "This customer did the payment.", "Cannot update this details.");
                    JO3.setVisible(true);
                    
                    CRhave = false;

                }

                else if(CRhave == false) {

                    if("Half-Board".equals(CRPType)) {

                        x = JOptionPane.showConfirmDialog(null, "Do you want to update \n this record?");

                        if(x == 0) {

                            sql = "SELECT * FROM customer WHERE CusID = '"+ CRCID +"'";
                            pst = con.prepareStatement(sql);
                            rs = pst.executeQuery();

                            while(rs.next()) {

                                CRPType2 = rs.getString("PackageType");

                            }

                            if("Full-Board".equals(CRPType2)) {

                                sql = "DELETE FROM fullboardbooking WHERE CusID = '"+ CRCID +"'";
                                pst = con.prepareStatement(sql);
                                pst.execute();

                            }

                            sql = "UPDATE customer SET CusName = '"+ CRCName +"', NIC_Passport = '"+ CRNic +"', TelNo = '"+ CRTelNo +"', CusType = '"+ CRCType +"', PackageType = '"+ CRPType +"', Adults = '"+ CRAdults +"', Children = '"+ CRChildren +"' WHERE CusID = '"+ CRCID +"' ";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                            JOption JOU = new JOption(1, "Update Sucessful!");
                            JOU.setVisible(true);

                            CRloadtable();

                        }

                        if(true) {

                            sql = "INSERT INTO amount(CusID, CusName, Amount) VALUES('"+ CRCID +"', '"+ CRCName +"', '"+ CRAmount +"')";
                            pst = con.prepareStatement(sql);
                            pst.execute();

                        }
                    }

                    else if ("Full-Board".equals(CRPType)) {

                        FullBoard FB = new FullBoard(CRCID, CRCName, CRNic, CRTelNo, CRAdults, CRChildren, CRCType, CRPType, CRDate, CRState, CRJOB);
                        JOption JO4 = new JOption(2, "Plese Fill More Details.", FB);
                        JO4.setVisible(true);

                    }
                }
            }
        }
 
        catch(Exception e) {
        
            System.out.println(e);
            
        }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void adultsfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adultsfieldMouseClicked
        
        String Adults = adultsfield.getText();
        
        if("0".equals(Adults)) {
        
            adultsfield.setText("");
            
        }
    }//GEN-LAST:event_adultsfieldMouseClicked

    private void adultsfieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adultsfieldMouseMoved

        String Adults = adultsfield.getText();
        
        if(Adults.isEmpty()) {
            
            cnamefield.setBackground(Color.WHITE);
            adultsfield.setText("0");
            
        }
    }//GEN-LAST:event_adultsfieldMouseMoved

    private void adultsfieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adultsfieldMouseEntered
    }//GEN-LAST:event_adultsfieldMouseEntered

    private void adultsfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adultsfieldKeyPressed
        
        String Adults = adultsfield.getText();
        
        if("0".equals(Adults)) {
        
            adultsfield.setText("");
            
        }
    }//GEN-LAST:event_adultsfieldKeyPressed

    private void childrenfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_childrenfieldMouseClicked
        
        String Children = childrenfield.getText();
        
        if("0".equals(Children)) {
        
            childrenfield.setText("");
            
        }
    }//GEN-LAST:event_childrenfieldMouseClicked

    private void childrenfieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_childrenfieldMouseMoved
        
        String Children = childrenfield.getText();
        
        if(Children.isEmpty()) {
        
            childrenfield.setText("0");
            
        }
    }//GEN-LAST:event_childrenfieldMouseMoved

    private void childrenfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_childrenfieldKeyPressed

        String Children = childrenfield.getText();
        
        if("0".equals(Children)) {
        
            childrenfield.setText("");
            
        }
    }//GEN-LAST:event_childrenfieldKeyPressed

    private void cnamefieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnamefieldKeyTyped

        int enter = evt.getKeyChar();
    
        if(Character.isDigit(enter)) {
            
            cnamefield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }

        else {
            
            cnamefield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_cnamefieldKeyTyped

    private void ctypecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctypecomboActionPerformed
    }//GEN-LAST:event_ctypecomboActionPerformed

    private void cnamefieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnamefieldKeyPressed
    }//GEN-LAST:event_cnamefieldKeyPressed

    private void cnamefieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnamefieldKeyReleased
    }//GEN-LAST:event_cnamefieldKeyReleased

    private void telnofieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telnofieldFocusLost
        
        String tel = telnofield.getText();
      
        if((tel.length() != 10)) {
             
            telnofield.setBackground(new Color(255, 102, 102));
                            
        }
        
        else {
            
            telnofield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_telnofieldFocusLost

    private void adultsfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adultsfieldKeyTyped
        
        char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
            
            adultsfield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }
        
        else {
            
            adultsfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_adultsfieldKeyTyped

    private void childrenfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_childrenfieldKeyTyped

        char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
        
            childrenfield.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }
        
        else
        {
            
            childrenfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_childrenfieldKeyTyped

    private void telnofieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telnofieldKeyTyped
        
        char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
        
            telnofield.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else {
            
            telnofield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_telnofieldKeyTyped

    private void adultsfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adultsfieldMouseExited

        int enter = Integer.valueOf(adultsfield.getText());

        if(enter >= 0) {
        
            adultsfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_adultsfieldMouseExited

    private void adultsfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adultsfieldFocusLost
    }//GEN-LAST:event_adultsfieldFocusLost

    private void childrenfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_childrenfieldMouseExited
       
        int enter = Integer.valueOf(childrenfield.getText());

        if(enter >= 0) {
        
            childrenfield.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_childrenfieldMouseExited

    private void nicfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicfieldKeyTyped
    }//GEN-LAST:event_nicfieldKeyTyped

    private void nicfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nicfieldFocusLost
        
        String nic = nicfield.getText();
        
        if(nicRadioButton.isSelected()) {

            if(!(nic.matches("^\\d{9}[vV]$"))) {
 
                nicfield.setBackground(new Color(255, 102, 102));
   
            }
            
            else {
         
                nicfield.setBackground(Color.WHITE);
                
            }
        }
    }//GEN-LAST:event_nicfieldFocusLost

    private void nicRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicRadioButtonActionPerformed

        nicfield.setText(null);
        CRhidenicfield();
        
    }//GEN-LAST:event_nicRadioButtonActionPerformed

    private void passportRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passportRadioButtonActionPerformed
        
        nicfield.setText(null);
        CRhidenicfield();
        
    }//GEN-LAST:event_passportRadioButtonActionPerformed

    private void clearbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbutton1ActionPerformed
        
        CRhidenicfield();
        CRclear();
        
    }//GEN-LAST:event_clearbutton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adultsfield;
    private javax.swing.JPanel background;
    private javax.swing.JButton bookingbutton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField childrenfield;
    private javax.swing.JLabel cidlable;
    private javax.swing.JButton clearbutton1;
    private javax.swing.JTextField cnamefield;
    private javax.swing.JComboBox<String> ctypecombo;
    private javax.swing.JTable custable;
    private javax.swing.JButton deletebutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JRadioButton nicRadioButton;
    private javax.swing.JTextField nicfield;
    private javax.swing.JRadioButton passportRadioButton;
    private javax.swing.JComboBox<String> ptypecombo;
    private javax.swing.JTextField telnofield;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
