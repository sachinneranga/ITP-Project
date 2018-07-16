package Interface;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeHomePage extends javax.swing.JFrame {

    String EHPState;
    String EHPJOB;
    
    public EmployeeHomePage() {
        
        initComponents();
   
     }
   
    public EmployeeHomePage(String State, String JOB) {
        
        EHPState = State;
        EHPJOB = JOB;
        
        initComponents();
        
        EHPloaddatetime();
        EHPloadlable();
        
     }   

    public void EHPloaddatetime() {
        
        Thread DT = new Thread() {
             
            public void run() {
                
                try {
                
                    for(;;) {
                             
                        Date EHPDateTime = new Date();
                        
                        DateFormat DF1 = new SimpleDateFormat("hh:mm:ss");
                        String Clock = DF1.format(EHPDateTime);
                        timelable.setText(Clock);    
                             
                        DateFormat DF2 = new SimpleDateFormat("dd-MM-YYYY");
                        String Date = DF2.format(EHPDateTime);
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
    
    public void EHPloadlable() {
    
        if("Login".equals(EHPState)) {
        
            logoutlable.setText("Logout");
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        topheader = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logoutlable = new javax.swing.JLabel();
        datelable = new javax.swing.JLabel();
        timelable = new javax.swing.JLabel();
        titel = new javax.swing.JLabel();
        homebutton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        customerreservationButton = new javax.swing.JButton();
        paymentmanagmentButton = new javax.swing.JButton();
        customerreservationButton1 = new javax.swing.JButton();
        paymentmanagmentButton1 = new javax.swing.JButton();
        chomepage = new javax.swing.JDesktopPane();
        innerbackground = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1366, 728));
        background.setLayout(null);

        header.setBackground(new java.awt.Color(4, 4, 51));
        header.setPreferredSize(new java.awt.Dimension(1366, 100));
        header.setLayout(null);

        topheader.setBackground(new java.awt.Color(255, 255, 255));
        topheader.setPreferredSize(new java.awt.Dimension(1366, 25));
        topheader.setLayout(null);

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close.jpg"))); // NOI18N
        closeButton.setBorderPainted(false);
        closeButton.setPreferredSize(new java.awt.Dimension(25, 25));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        topheader.add(closeButton);
        closeButton.setBounds(1340, 0, 25, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.jpg"))); // NOI18N
        topheader.add(jLabel1);
        jLabel1.setBounds(0, 0, 25, 25);

        header.add(topheader);
        topheader.setBounds(0, 0, 1366, 25);

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
        logoutlable.setBounds(1300, 70, 50, 20);

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

        titel.setBackground(new java.awt.Color(13, 13, 101));
        titel.setFont(new java.awt.Font("Bodoni MT Black", 3, 36)); // NOI18N
        titel.setForeground(new java.awt.Color(204, 204, 255));
        titel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titel.setText("Employee Management");
        titel.setPreferredSize(new java.awt.Dimension(1366, 40));
        header.add(titel);
        titel.setBounds(0, 25, 1366, 40);

        homebutton.setBackground(new java.awt.Color(0, 0, 0));
        homebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home.jpg"))); // NOI18N
        homebutton.setPreferredSize(new java.awt.Dimension(35, 35));
        homebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebuttonActionPerformed(evt);
            }
        });
        header.add(homebutton);
        homebutton.setBounds(0, 65, 35, 35);

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.jpg"))); // NOI18N
        backButton.setPreferredSize(new java.awt.Dimension(35, 35));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        header.add(backButton);
        backButton.setBounds(35, 65, 35, 35);

        customerreservationButton.setBackground(new java.awt.Color(0, 0, 0));
        customerreservationButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customerreservationButton.setForeground(new java.awt.Color(102, 102, 255));
        customerreservationButton.setText("Leave Management");
        customerreservationButton.setPreferredSize(new java.awt.Dimension(340, 35));
        customerreservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerreservationButtonActionPerformed(evt);
            }
        });
        header.add(customerreservationButton);
        customerreservationButton.setBounds(750, 65, 340, 35);

        paymentmanagmentButton.setBackground(new java.awt.Color(0, 0, 0));
        paymentmanagmentButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paymentmanagmentButton.setForeground(new java.awt.Color(102, 102, 255));
        paymentmanagmentButton.setText("Payroll");
        paymentmanagmentButton.setPreferredSize(new java.awt.Dimension(200, 35));
        paymentmanagmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentmanagmentButtonActionPerformed(evt);
            }
        });
        header.add(paymentmanagmentButton);
        paymentmanagmentButton.setBounds(1090, 65, 200, 35);

        customerreservationButton1.setBackground(new java.awt.Color(0, 0, 0));
        customerreservationButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customerreservationButton1.setForeground(new java.awt.Color(102, 102, 255));
        customerreservationButton1.setText("Employee Registration");
        customerreservationButton1.setPreferredSize(new java.awt.Dimension(340, 35));
        customerreservationButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerreservationButton1ActionPerformed(evt);
            }
        });
        header.add(customerreservationButton1);
        customerreservationButton1.setBounds(70, 65, 340, 35);

        paymentmanagmentButton1.setBackground(new java.awt.Color(0, 0, 0));
        paymentmanagmentButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paymentmanagmentButton1.setForeground(new java.awt.Color(102, 102, 255));
        paymentmanagmentButton1.setText("Employee Atendance");
        paymentmanagmentButton1.setPreferredSize(new java.awt.Dimension(340, 35));
        paymentmanagmentButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentmanagmentButton1ActionPerformed(evt);
            }
        });
        header.add(paymentmanagmentButton1);
        paymentmanagmentButton1.setBounds(410, 65, 340, 35);

        background.add(header);
        header.setBounds(0, 0, 1366, 100);

        chomepage.setPreferredSize(new java.awt.Dimension(1366, 628));

        innerbackground.setPreferredSize(new java.awt.Dimension(1366, 628));
        innerbackground.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HOTEL.jpg"))); // NOI18N
        innerbackground.add(jLabel2);
        jLabel2.setBounds(0, 0, 1366, 628);

        chomepage.add(innerbackground);
        innerbackground.setBounds(0, 0, 1366, 628);

        background.add(chomepage);
        chomepage.setBounds(0, 100, 1366, 628);

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

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
       
        System.exit(0);
        
    }//GEN-LAST:event_closeButtonActionPerformed

    private void customerreservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerreservationButtonActionPerformed
   
        if("Admin".equals(EHPJOB)) {
            
            chomepage.removeAll();
            LeaveManagement LM = new LeaveManagement();
            chomepage.add(LM).setVisible(true);
            
        }
        
        else if("HR Manager".equals(EHPJOB)) {
        
           chomepage.removeAll();
           LeaveManagement LM = new LeaveManagement();
           chomepage.add(LM).setVisible(true); 
            
        }  
        
        else {
        
            JOption JO = new JOption(1, "Cannot Access Leave", "Management.");
            JO.setVisible(true);
            
        }
    }//GEN-LAST:event_customerreservationButtonActionPerformed

    private void paymentmanagmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentmanagmentButtonActionPerformed

        if("Admin".equals(EHPJOB)) {
            
            chomepage.removeAll();
            Payroll PR = new Payroll();
            chomepage.add(PR).setVisible(true);
            
        }
        
        else if("HR Manager".equals(EHPJOB)) {
        
            chomepage.removeAll();
            Payroll PR = new Payroll();
            chomepage.add(PR).setVisible(true); 
            
        } 
        
        else if("Accountant".equals(EHPJOB)) {
        
            chomepage.removeAll();
            Payroll PR = new Payroll();
            chomepage.add(PR).setVisible(true); 
            
        }
        
        else {
        
            JOption JO = new JOption(1, "Cannot Access Payroll.");
            JO.setVisible(true);
            
        }
    }//GEN-LAST:event_paymentmanagmentButtonActionPerformed

    private void customerreservationButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerreservationButton1ActionPerformed

        if("Admin".equals(EHPJOB)) {
            
            chomepage.removeAll();
            EmployeeRegistration ER = new EmployeeRegistration();
            chomepage.add(ER).setVisible(true);
            
        }
        
        else if("HR Manager".equals(EHPJOB)) {
        
            chomepage.removeAll();
            EmployeeRegistration ER = new EmployeeRegistration();
            chomepage.add(ER).setVisible(true);
            
        }
        
        else {
        
            JOption JO = new JOption(1, "Cannot Access Registration.");
            JO.setVisible(true);
            
        }
    }//GEN-LAST:event_customerreservationButton1ActionPerformed

    private void paymentmanagmentButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentmanagmentButton1ActionPerformed
       
        chomepage.removeAll();
        EmployeeAtendance EA = new EmployeeAtendance();
        chomepage.add(EA).setVisible(true);
        
    }//GEN-LAST:event_paymentmanagmentButton1ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        chomepage.removeAll();
        EmployeeHomePage1 EMP1 = new EmployeeHomePage1();
        chomepage.add(EMP1).setVisible(true);

    }//GEN-LAST:event_backButtonActionPerformed

    private void logoutlableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlableMouseClicked

        HomePage HP = new HomePage();
        HP.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_logoutlableMouseClicked

    private void logoutlableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlableMouseEntered

        logoutlable.setForeground(Color.YELLOW);
        
    }//GEN-LAST:event_logoutlableMouseEntered

    private void logoutlableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlableMouseExited

        logoutlable.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_logoutlableMouseExited

    private void homebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebuttonActionPerformed

        if("Login".equals(EHPState)) {

            HomePage HP = new HomePage(EHPState, EHPJOB);
            HP.setVisible(true);
            this.dispose();

        }

        else {

            HomePage HP = new HomePage();
            HP.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_homebuttonActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel background;
    private javax.swing.JDesktopPane chomepage;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton customerreservationButton;
    private javax.swing.JButton customerreservationButton1;
    private javax.swing.JLabel datelable;
    private javax.swing.JPanel header;
    private javax.swing.JButton homebutton;
    private javax.swing.JPanel innerbackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logoutlable;
    private javax.swing.JButton paymentmanagmentButton;
    private javax.swing.JButton paymentmanagmentButton1;
    private javax.swing.JLabel timelable;
    private javax.swing.JLabel titel;
    private javax.swing.JPanel topheader;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JDesktopPane chomepage1;
}
