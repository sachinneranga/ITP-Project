package Interface;

import MyCode.DBconnect;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    
    String HPUName;
    String HPPassword;
    String HPState;
    String HPJOB;
    
    String HPEID;
    boolean HPIUState = false;
    
    public HomePage() {
        
        initComponents();
        
        con = DBconnect.connect();
        
        HPloaddatetime();
        HPloadlable();
              
    }
    
    public HomePage(String State, String JOB) {
        
        HPState = State;
        HPJOB = JOB;
        
        initComponents();
        
        con = DBconnect.connect();
        
        HPloaddatetime();
        HPloadlable();
        HPloadwelcomepage();
        
    }
    
    public void HPloaddatetime() {
        
        Thread DT = new Thread() {
             
            public void run() {
                
                try {
                
                    for(;;) {
                             
                        Date CRHDateTime = new Date();
                        
                        DateFormat DF1 = new SimpleDateFormat("hh:mm:ss");
                        String Clock = DF1.format(CRHDateTime);
                        timelable.setText(Clock);    
                             
                        DateFormat DF2 = new SimpleDateFormat("dd-MM-YYYY");
                        String Date = DF2.format(CRHDateTime);
                        datelable.setText(Date); 
                             
                        sleep(1000);
                    
                    }
                } 
                
                catch(Exception e) {
                    
                    System.out.println(e);
                
                }
            }
        };
        
        DT.start();
        
    }

    public void HPgetvalue() {
    
        HPUName = usernamefield.getText();
        HPPassword = passwordfield.getText();
        
    }
    
    public void HPloadlable() {
    
        if("Login".equals(HPState)) {
        
            logoutlable.setText("Logout");
            
        }
    }
    
    public void HPloadwelcomepage() {
    
        homepage.removeAll();
        WelcomePage WP = new WelcomePage();
        homepage.add(WP).setVisible(true);
                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        topheader = new javax.swing.JPanel();
        closebutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        datelable = new javax.swing.JLabel();
        timelable = new javax.swing.JLabel();
        logoutlable = new javax.swing.JLabel();
        titel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        employeemanagementpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        customerreservationpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        eventsmanagementpanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        restaurantmanagementpanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        inventorymanagementpanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        hotelmainteancepanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        accountsmanagementpanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        homepage = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usernamefield = new javax.swing.JTextField();
        passwordfield = new javax.swing.JPasswordField();
        loginbutton = new javax.swing.JButton();
        resetlable = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        background1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1366, 728));
        background.setLayout(null);

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setPreferredSize(new java.awt.Dimension(1366, 100));
        header.setLayout(null);

        topheader.setBackground(new java.awt.Color(255, 255, 255));
        topheader.setPreferredSize(new java.awt.Dimension(1366, 25));
        topheader.setLayout(null);

        closebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close.jpg"))); // NOI18N
        closebutton.setBorderPainted(false);
        closebutton.setPreferredSize(new java.awt.Dimension(25, 25));
        closebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebuttonActionPerformed(evt);
            }
        });
        topheader.add(closebutton);
        closebutton.setBounds(1340, 0, 25, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.jpg"))); // NOI18N
        topheader.add(jLabel1);
        jLabel1.setBounds(0, 0, 25, 25);

        header.add(topheader);
        topheader.setBounds(0, 0, 1366, 25);

        datelable.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        datelable.setForeground(new java.awt.Color(255, 255, 255));
        datelable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datelable.setText("Date");
        datelable.setPreferredSize(new java.awt.Dimension(100, 40));
        header.add(datelable);
        datelable.setBounds(1166, 25, 100, 40);

        timelable.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        timelable.setForeground(new java.awt.Color(255, 255, 255));
        timelable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timelable.setText("Time");
        timelable.setPreferredSize(new java.awt.Dimension(100, 40));
        header.add(timelable);
        timelable.setBounds(1266, 25, 100, 40);

        logoutlable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logoutlable.setForeground(new java.awt.Color(255, 255, 255));
        logoutlable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutlableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutlableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutlableMouseExited(evt);
            }
        });
        header.add(logoutlable);
        logoutlable.setBounds(1290, 70, 50, 20);

        titel.setFont(new java.awt.Font("Bodoni MT Black", 3, 36)); // NOI18N
        titel.setForeground(new java.awt.Color(255, 255, 255));
        titel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titel.setText("Muthuweli Beach Resort");
        titel.setPreferredSize(new java.awt.Dimension(1366, 75));
        header.add(titel);
        titel.setBounds(0, 25, 1366, 75);

        background.add(header);
        header.setBounds(0, 0, 1366, 100);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 628));
        jPanel1.setLayout(null);

        employeemanagementpanel.setBackground(new java.awt.Color(255, 255, 255));
        employeemanagementpanel.setPreferredSize(new java.awt.Dimension(300, 50));
        employeemanagementpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeememployeemanagementpanelnagmentpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeemanagementpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                employeemanagementpanelMouseExited(evt);
            }
        });
        employeemanagementpanel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Employee Management");
        jLabel2.setPreferredSize(new java.awt.Dimension(300, 50));
        employeemanagementpanel.add(jLabel2);
        jLabel2.setBounds(0, 0, 300, 50);

        jPanel1.add(employeemanagementpanel);
        employeemanagementpanel.setBounds(0, 0, 300, 50);

        customerreservationpanel.setBackground(new java.awt.Color(255, 255, 255));
        customerreservationpanel.setPreferredSize(new java.awt.Dimension(300, 50));
        customerreservationpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerreservationpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerreservationpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerreservationpanelMouseExited(evt);
            }
        });
        customerreservationpanel.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Customer Reservation");
        jLabel3.setPreferredSize(new java.awt.Dimension(300, 50));
        customerreservationpanel.add(jLabel3);
        jLabel3.setBounds(0, 0, 300, 50);

        jPanel1.add(customerreservationpanel);
        customerreservationpanel.setBounds(0, 70, 300, 50);

        eventsmanagementpanel.setBackground(new java.awt.Color(255, 255, 255));
        eventsmanagementpanel.setPreferredSize(new java.awt.Dimension(300, 50));
        eventsmanagementpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventsmanagementpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eventsmanagementpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eventsmanagementpanelMouseExited(evt);
            }
        });
        eventsmanagementpanel.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Events Management");
        jLabel9.setPreferredSize(new java.awt.Dimension(300, 50));
        eventsmanagementpanel.add(jLabel9);
        jLabel9.setBounds(0, 0, 300, 50);

        jPanel1.add(eventsmanagementpanel);
        eventsmanagementpanel.setBounds(0, 140, 300, 50);

        restaurantmanagementpanel.setBackground(new java.awt.Color(255, 255, 255));
        restaurantmanagementpanel.setPreferredSize(new java.awt.Dimension(300, 50));
        restaurantmanagementpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restaurantmanagementpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restaurantmanagementpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restaurantmanagementpanelMouseExited(evt);
            }
        });
        restaurantmanagementpanel.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Restaurant Management");
        jLabel10.setPreferredSize(new java.awt.Dimension(300, 50));
        restaurantmanagementpanel.add(jLabel10);
        jLabel10.setBounds(0, 0, 300, 50);

        jPanel1.add(restaurantmanagementpanel);
        restaurantmanagementpanel.setBounds(0, 210, 300, 50);

        inventorymanagementpanel.setBackground(new java.awt.Color(255, 255, 255));
        inventorymanagementpanel.setPreferredSize(new java.awt.Dimension(300, 50));
        inventorymanagementpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventorymanagementpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventorymanagementpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventorymanagementpanelMouseExited(evt);
            }
        });
        inventorymanagementpanel.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Inventory Management");
        jLabel11.setPreferredSize(new java.awt.Dimension(300, 50));
        inventorymanagementpanel.add(jLabel11);
        jLabel11.setBounds(0, 0, 300, 50);

        jPanel1.add(inventorymanagementpanel);
        inventorymanagementpanel.setBounds(0, 280, 300, 50);

        hotelmainteancepanel.setBackground(new java.awt.Color(255, 255, 255));
        hotelmainteancepanel.setPreferredSize(new java.awt.Dimension(300, 50));
        hotelmainteancepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hotelmainteancepanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hotelmainteancepanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hotelmainteancepanelMouseExited(evt);
            }
        });
        hotelmainteancepanel.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Boutique Management");
        jLabel12.setPreferredSize(new java.awt.Dimension(300, 50));
        hotelmainteancepanel.add(jLabel12);
        jLabel12.setBounds(0, 0, 300, 50);

        jPanel1.add(hotelmainteancepanel);
        hotelmainteancepanel.setBounds(0, 350, 300, 50);

        accountsmanagementpanel.setBackground(new java.awt.Color(255, 255, 255));
        accountsmanagementpanel.setPreferredSize(new java.awt.Dimension(300, 50));
        accountsmanagementpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountsmanagementpanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountsmanagementpanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountsmanagementpanelMouseExited(evt);
            }
        });
        accountsmanagementpanel.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Accounts Management");
        jLabel13.setPreferredSize(new java.awt.Dimension(300, 50));
        accountsmanagementpanel.add(jLabel13);
        jLabel13.setBounds(0, 0, 300, 50);

        jPanel1.add(accountsmanagementpanel);
        accountsmanagementpanel.setBounds(0, 420, 300, 50);

        background.add(jPanel1);
        jPanel1.setBounds(0, 100, 300, 628);

        homepage.setPreferredSize(new java.awt.Dimension(1066, 628));

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(1066, 628));
        jPanel4.setLayout(null);

        jPanel2.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Login");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(224, 20, 130, 22);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel3.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Password");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 110, 90, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("User Name");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(30, 70, 90, 17);

        usernamefield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usernamefield.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel3.add(usernamefield);
        usernamefield.setBounds(150, 60, 160, 30);

        passwordfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordfield.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel3.add(passwordfield);
        passwordfield.setBounds(150, 100, 160, 30);

        loginbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(loginbutton);
        loginbutton.setBounds(213, 150, 100, 31);

        resetlable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resetlable.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        resetlable.setText("Reset Password");
        resetlable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                resetlableMouseMoved(evt);
            }
        });
        resetlable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetlableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetlableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetlableMouseExited(evt);
            }
        });
        jPanel3.add(resetlable);
        resetlable.setBounds(220, 190, 90, 15);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(50, 60, 400, 220);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeInnerBackground.jpg"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 510, 320);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(300, 110, 510, 320);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeBackground.jpg"))); // NOI18N
        jPanel4.add(jLabel7);
        jLabel7.setBounds(0, 0, 1066, 628);

        homepage.add(jPanel4);
        jPanel4.setBounds(0, 0, 1066, 628);

        background1.setBackground(new java.awt.Color(255, 255, 255));
        background1.setPreferredSize(new java.awt.Dimension(1066, 628));
        background1.setLayout(null);
        homepage.add(background1);
        background1.setBounds(0, 0, 1066, 628);

        background.add(homepage);
        homepage.setBounds(300, 100, 1066, 628);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebuttonActionPerformed
       
        System.exit(0);
        
    }//GEN-LAST:event_closebuttonActionPerformed

    private void employeememployeemanagementpanelnagmentpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeememployeemanagementpanelnagmentpanelMouseClicked
        
        if("Login".equals(HPState)) {

            EmployeeHomePage EHPM = new EmployeeHomePage(HPState, HPJOB);
            EHPM.setVisible(true);
            this.dispose();

        }
        
        else {
        
            JOption JO2 = new JOption(1, "Please Login to the System.");
            JO2.setVisible(true);
            
        }      
    }//GEN-LAST:event_employeememployeemanagementpanelnagmentpanelMouseClicked

    private void customerreservationpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerreservationpanelMouseClicked
        
        if("Login".equals(HPState)) {
            
            if("Admin".equals(HPJOB)) {
               
                CustomerReservationsHome CRHM = new CustomerReservationsHome(HPState, HPJOB);
                CRHM.setVisible(true);
                this.dispose();
            
            }
            
            else if("Receptionist".equals(HPJOB)) {
               
                CustomerReservationsHome CRHM = new CustomerReservationsHome(HPState, HPJOB);
                CRHM.setVisible(true);
                this.dispose();
            
            }
            
            else {
            
                JOption JO1 = new JOption(1, "Cannot Access Customer", "Reservation.");
                JO1.setVisible(true);
               
            }
        }
        
        else {
        
            JOption JO2 = new JOption(1, "Please Login to the System.");
            JO2.setVisible(true);
                      
        } 
    }//GEN-LAST:event_customerreservationpanelMouseClicked

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        
        try {
 
            String UN;
            String PW;
            
            HPgetvalue();
        
            sql = "SELECT EmpID, Password FROM login WHERE UserName = '"+ HPUName +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                
                HPEID = rs.getString("EmpID");
                PW = rs.getString("Password");

                if(PW.equals(HPPassword)) {
                    
                    HPIUState = true;
                        
                }

                else {
                
                    HPIUState = false;
                   
                }
            }

            if(HPIUState == true) {
            
                HPState = "Login";
                
                HPloadwelcomepage();
                HPloadlable();
                        
                sql = "SELECT JobTitel FROM employee WHERE Empno = '"+ HPEID +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                       
                while(rs.next()) {
                        
                    HPJOB = rs.getString("JobTitel");
                            
                }
            }
            
            else if(HPIUState == false) {
            
                JOption JO3 = new JOption(1, "Invalid UserName or Password.");
                JO3.setVisible(true);

            }
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
        }
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void eventsmanagementpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventsmanagementpanelMouseClicked
        
//        if("Login".equals(HPState)) {
//            
//            if("Admin".equals(HPJOB)) {
//               
//                EVENT EM = new EVENT();
//                EM.setVisible(true);
//                this.dispose();
//            
//            }
//            
//            else if("Cashier".equals(HPJOB)) {
//               
//                RestaurantHome RM = new RestaurantHome(HPState, HPJOB);
//                RM.setVisible(true);
//                this.dispose();
//            
//            }
//            
//            else {
//            
//                JOption JO1 = new JOption(1, "Cannot Access Restaurant", "Management.");
//                JO1.setVisible(true);
//                
//            }
//        }
//        
//        else {
//        
//            JOption JO2 = new JOption(1, "Please Login to the System.");
//            JO2.setVisible(true);
//                      
//        } 
//        
//        
    }//GEN-LAST:event_eventsmanagementpanelMouseClicked

    private void restaurantmanagementpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurantmanagementpanelMouseClicked

        if("Login".equals(HPState)) {
            
            if("Admin".equals(HPJOB)) {
               
                RestaurantHome RM = new RestaurantHome(HPState, HPJOB);
                RM.setVisible(true);
                this.dispose();
            
            }
            
            else if("Cashier".equals(HPJOB)) {
               
                RestaurantHome RM = new RestaurantHome(HPState, HPJOB);
                RM.setVisible(true);
                this.dispose();
            
            }
            
            else {
            
                JOption JO1 = new JOption(1, "Cannot Access Restaurant", "Management.");
                JO1.setVisible(true);
                
            }
        }
        
        else {
        
            JOption JO2 = new JOption(1, "Please Login to the System.");
            JO2.setVisible(true);
                      
        }                 
    }//GEN-LAST:event_restaurantmanagementpanelMouseClicked

    private void inventorymanagementpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventorymanagementpanelMouseClicked
       
        if("Login".equals(HPState)) {
            
            if("Admin".equals(HPJOB)) {
               
                InventoryHome IHM = new InventoryHome(HPState, HPJOB);
                IHM.setVisible(true);
                this.dispose();
            
            }
            
            else if("Inventory Manager".equals(HPJOB)) {
               
                InventoryHome IHM = new InventoryHome(HPState, HPJOB);
                IHM.setVisible(true);
                this.dispose();
                
            }
            
            else {
            
                JOption JO1 = new JOption(1, "Cannot Access Inventory", "Management.");
                JO1.setVisible(true);
                
            }
        }
        
        else {
        
            JOption JO2 = new JOption(1, "Please Login to the System.");
            JO2.setVisible(true);
                      
        }        
    }//GEN-LAST:event_inventorymanagementpanelMouseClicked

    private void hotelmainteancepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotelmainteancepanelMouseClicked
     
        if("Login".equals(HPState)) {
            
            if("Admin".equals(HPJOB)) {
               
                main M = new main();
                M.setVisible(true);
                this.dispose();
            
            }

            else {
            
                JOption JO1 = new JOption(1, "Cannot Access Hotel", "Mainteance.");
                JO1.setVisible(true);
                
            }
        }
        
        else {
        
            JOption JO2 = new JOption(1, "Please Login to the System.");
            JO2.setVisible(true);
                      
        }
    }//GEN-LAST:event_hotelmainteancepanelMouseClicked

    private void accountsmanagementpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountsmanagementpanelMouseClicked
      
        if("Login".equals(HPState)) {
            
            if("Admin".equals(HPJOB)) {
               
                Acc AM = new Acc(HPState, HPJOB);
                AM.setVisible(true);
                this.dispose();
            
            }
            
            else if("Accountant".equals(HPJOB)) {
               
                Acc AM = new Acc(HPState, HPJOB);
                AM.setVisible(true);
                this.dispose();
            
            }
            
            else {
            
                JOption JO1 = new JOption(1, "Cannot Access Account", "Management.");
                JO1.setVisible(true);
               
            }
        }
        
        else {
        
            JOption JO2 = new JOption(1, "Please Login to the System.");
            JO2.setVisible(true);
                      
        }        
    }//GEN-LAST:event_accountsmanagementpanelMouseClicked

    private void employeemanagementpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeemanagementpanelMouseEntered
        
        employeemanagementpanel.setBackground(new Color(46, 140, 254));
        
    }//GEN-LAST:event_employeemanagementpanelMouseEntered

    private void employeemanagementpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeemanagementpanelMouseExited
        
        employeemanagementpanel.setBackground(new Color(255, 255, 255));
        
    }//GEN-LAST:event_employeemanagementpanelMouseExited

    private void customerreservationpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerreservationpanelMouseEntered
        
        customerreservationpanel.setBackground(new Color(46, 140, 254));
        
    }//GEN-LAST:event_customerreservationpanelMouseEntered

    private void customerreservationpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerreservationpanelMouseExited
        
        customerreservationpanel.setBackground(new Color(255, 255, 255));
        
    }//GEN-LAST:event_customerreservationpanelMouseExited

    private void restaurantmanagementpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurantmanagementpanelMouseEntered
        
        restaurantmanagementpanel.setBackground(new Color(46, 140, 254));
        
    }//GEN-LAST:event_restaurantmanagementpanelMouseEntered

    private void restaurantmanagementpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurantmanagementpanelMouseExited
        
        restaurantmanagementpanel.setBackground(new Color(255, 255, 255));
        
    }//GEN-LAST:event_restaurantmanagementpanelMouseExited

    private void eventsmanagementpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventsmanagementpanelMouseEntered
        
        eventsmanagementpanel.setBackground(new Color(46, 140, 254));
        
    }//GEN-LAST:event_eventsmanagementpanelMouseEntered

    private void eventsmanagementpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventsmanagementpanelMouseExited
        
        eventsmanagementpanel.setBackground(new Color(255, 255, 255));
        
    }//GEN-LAST:event_eventsmanagementpanelMouseExited

    private void inventorymanagementpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventorymanagementpanelMouseEntered
        
        inventorymanagementpanel.setBackground(new Color(46, 140, 254));
        
    }//GEN-LAST:event_inventorymanagementpanelMouseEntered

    private void inventorymanagementpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventorymanagementpanelMouseExited
        
        inventorymanagementpanel.setBackground(new Color(255, 255, 255));
        
    }//GEN-LAST:event_inventorymanagementpanelMouseExited

    private void hotelmainteancepanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotelmainteancepanelMouseEntered
       
        hotelmainteancepanel.setBackground(new Color(46, 140, 254));
        
    }//GEN-LAST:event_hotelmainteancepanelMouseEntered

    private void hotelmainteancepanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotelmainteancepanelMouseExited
        
        hotelmainteancepanel.setBackground(new Color(255, 255, 255));
        
    }//GEN-LAST:event_hotelmainteancepanelMouseExited

    private void accountsmanagementpanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountsmanagementpanelMouseEntered
        
        accountsmanagementpanel.setBackground(new Color(46, 140, 254));
        
    }//GEN-LAST:event_accountsmanagementpanelMouseEntered

    private void accountsmanagementpanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountsmanagementpanelMouseExited
        
        accountsmanagementpanel.setBackground(new Color(255, 255, 255));
        
    }//GEN-LAST:event_accountsmanagementpanelMouseExited

    private void logoutlableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlableMouseEntered
        
        logoutlable.setForeground(Color.YELLOW);
        
    }//GEN-LAST:event_logoutlableMouseEntered

    private void logoutlableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlableMouseExited
       
        logoutlable.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_logoutlableMouseExited

    private void logoutlableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlableMouseClicked
        
        HomePage HP = new HomePage();
        HP.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_logoutlableMouseClicked

    private void resetlableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetlableMouseMoved
    }//GEN-LAST:event_resetlableMouseMoved

    private void resetlableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetlableMouseEntered
        
        resetlable.setForeground(Color.blue);
        
    }//GEN-LAST:event_resetlableMouseEntered

    private void resetlableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetlableMouseExited
        
        resetlable.setForeground(Color.black);
        
    }//GEN-LAST:event_resetlableMouseExited

    private void resetlableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetlableMouseClicked
        
        ResetPassword RP = new ResetPassword();
        RP.setVisible(true);
        
    }//GEN-LAST:event_resetlableMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountsmanagementpanel;
    private javax.swing.JPanel background;
    private javax.swing.JPanel background1;
    private javax.swing.JButton closebutton;
    private javax.swing.JPanel customerreservationpanel;
    private javax.swing.JLabel datelable;
    private javax.swing.JPanel employeemanagementpanel;
    private javax.swing.JPanel eventsmanagementpanel;
    private javax.swing.JPanel header;
    private javax.swing.JDesktopPane homepage;
    private javax.swing.JPanel hotelmainteancepanel;
    private javax.swing.JPanel inventorymanagementpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton loginbutton;
    private javax.swing.JLabel logoutlable;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JLabel resetlable;
    private javax.swing.JPanel restaurantmanagementpanel;
    private javax.swing.JLabel timelable;
    private javax.swing.JLabel titel;
    private javax.swing.JPanel topheader;
    private javax.swing.JTextField usernamefield;
    // End of variables declaration//GEN-END:variables
   
}
