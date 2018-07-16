package Interface;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InventoryHome extends javax.swing.JFrame {
    
    String IMState;
    String IMJOB;
    
    public InventoryHome() {
        
        initComponents();
        
        CRHloadinterface();
        
    }
    
    public InventoryHome(String State, String JOB) {
        
        IMState = State;
        IMJOB = JOB;
        
        initComponents();
        
        CRHloadinterface();
        
        CRHloaddatetime();
        CRHloadlable();
        
    }
    
    public void CRHloadinterface() {
    
        chomepage.removeAll();
        InventoryHome2 IH = new InventoryHome2();
        chomepage.add(IH).setVisible(true);
        
    }
    
    public void CRHloaddatetime() {
        
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
    
    public void CRHloadlable() {
    
        if("Login".equals(IMState)) {
        
            logoutlable.setText("Logout");
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        topheader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        closebutton = new javax.swing.JButton();
        titel = new javax.swing.JLabel();
        backbutton = new javax.swing.JButton();
        customerreservationbutton = new javax.swing.JButton();
        paymentmanagmentbutton = new javax.swing.JButton();
        paymentmanagmentbutton1 = new javax.swing.JButton();
        paymentmanagmentbutton2 = new javax.swing.JButton();
        homebutton = new javax.swing.JButton();
        datelable = new javax.swing.JLabel();
        timelable = new javax.swing.JLabel();
        logoutlable = new javax.swing.JLabel();
        chomepage = new javax.swing.JDesktopPane();
        innerbackground = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.jpg"))); // NOI18N
        topheader.add(jLabel1);
        jLabel1.setBounds(0, 0, 25, 25);

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

        header.add(topheader);
        topheader.setBounds(0, 0, 1366, 25);

        titel.setFont(new java.awt.Font("Bodoni MT Black", 3, 36)); // NOI18N
        titel.setForeground(new java.awt.Color(255, 255, 255));
        titel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titel.setText("Inventory Management");
        titel.setPreferredSize(new java.awt.Dimension(1366, 40));
        header.add(titel);
        titel.setBounds(0, 25, 1366, 40);

        backbutton.setBackground(new java.awt.Color(0, 0, 0));
        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.jpg"))); // NOI18N
        backbutton.setPreferredSize(new java.awt.Dimension(35, 35));
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });
        header.add(backbutton);
        backbutton.setBounds(35, 65, 35, 35);

        customerreservationbutton.setBackground(new java.awt.Color(0, 0, 0));
        customerreservationbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customerreservationbutton.setForeground(new java.awt.Color(255, 255, 255));
        customerreservationbutton.setText("Stock Management");
        customerreservationbutton.setPreferredSize(new java.awt.Dimension(250, 35));
        customerreservationbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerreservationbuttonActionPerformed(evt);
            }
        });
        header.add(customerreservationbutton);
        customerreservationbutton.setBounds(70, 65, 250, 35);

        paymentmanagmentbutton.setBackground(new java.awt.Color(0, 0, 0));
        paymentmanagmentbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paymentmanagmentbutton.setForeground(new java.awt.Color(255, 255, 255));
        paymentmanagmentbutton.setText("Payment Management");
        paymentmanagmentbutton.setPreferredSize(new java.awt.Dimension(250, 35));
        paymentmanagmentbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentmanagmentbuttonActionPerformed(evt);
            }
        });
        header.add(paymentmanagmentbutton);
        paymentmanagmentbutton.setBounds(570, 64, 250, 35);

        paymentmanagmentbutton1.setBackground(new java.awt.Color(0, 0, 0));
        paymentmanagmentbutton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paymentmanagmentbutton1.setForeground(new java.awt.Color(255, 255, 255));
        paymentmanagmentbutton1.setText("Supplier Management");
        paymentmanagmentbutton1.setPreferredSize(new java.awt.Dimension(250, 35));
        paymentmanagmentbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentmanagmentbutton1ActionPerformed(evt);
            }
        });
        header.add(paymentmanagmentbutton1);
        paymentmanagmentbutton1.setBounds(320, 65, 250, 35);

        paymentmanagmentbutton2.setBackground(new java.awt.Color(0, 0, 0));
        paymentmanagmentbutton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        paymentmanagmentbutton2.setForeground(new java.awt.Color(255, 255, 255));
        paymentmanagmentbutton2.setText("Cost & Value");
        paymentmanagmentbutton2.setPreferredSize(new java.awt.Dimension(250, 35));
        paymentmanagmentbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentmanagmentbutton2ActionPerformed(evt);
            }
        });
        header.add(paymentmanagmentbutton2);
        paymentmanagmentbutton2.setBounds(820, 65, 250, 35);

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
        logoutlable.setBounds(1280, 70, 50, 20);

        background.add(header);
        header.setBounds(0, 0, 1366, 100);

        chomepage.setPreferredSize(new java.awt.Dimension(1366, 628));

        innerbackground.setPreferredSize(new java.awt.Dimension(1366, 628));
        innerbackground.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Inventory.jpg"))); // NOI18N
        innerbackground.add(jLabel2);
        jLabel2.setBounds(0, 0, 0, 0);

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

    private void customerreservationbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerreservationbuttonActionPerformed
   
        chomepage.removeAll();
        StockManagement SM = new StockManagement();
        chomepage.add(SM).setVisible(true);
        
    }//GEN-LAST:event_customerreservationbuttonActionPerformed

    private void paymentmanagmentbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentmanagmentbuttonActionPerformed

        chomepage.removeAll();
        SPaymentManagement PM = new SPaymentManagement();
        chomepage.add(PM).setVisible(true);
   
    }//GEN-LAST:event_paymentmanagmentbuttonActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        
        chomepage.removeAll();
        InventoryHome2 IH = new InventoryHome2();
        chomepage.add(IH).setVisible(true);
        
    }//GEN-LAST:event_backbuttonActionPerformed

    private void paymentmanagmentbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentmanagmentbutton1ActionPerformed
        
        chomepage.removeAll();
        SupplierManagement SM = new SupplierManagement();
        chomepage.add(SM).setVisible(true);
        
    }//GEN-LAST:event_paymentmanagmentbutton1ActionPerformed

    private void paymentmanagmentbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentmanagmentbutton2ActionPerformed
        
        chomepage.removeAll();
        CostValue CV = new CostValue();
        chomepage.add(CV).setVisible(true);
        
    }//GEN-LAST:event_paymentmanagmentbutton2ActionPerformed

    private void homebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebuttonActionPerformed

        if("Login".equals(IMState)) {

            HomePage HP = new HomePage(IMState, IMJOB);
            HP.setVisible(true);
            this.dispose();

        }

        else {

            HomePage HP = new HomePage();
            HP.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_homebuttonActionPerformed

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

    private void closebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebuttonActionPerformed

        System.exit(0);

    }//GEN-LAST:event_closebuttonActionPerformed

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
            java.util.logging.Logger.getLogger(InventoryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton;
    private javax.swing.JPanel background;
    private javax.swing.JDesktopPane chomepage;
    private javax.swing.JButton closebutton;
    private javax.swing.JButton customerreservationbutton;
    private javax.swing.JLabel datelable;
    private javax.swing.JPanel header;
    private javax.swing.JButton homebutton;
    private javax.swing.JPanel innerbackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logoutlable;
    private javax.swing.JButton paymentmanagmentbutton;
    private javax.swing.JButton paymentmanagmentbutton1;
    private javax.swing.JButton paymentmanagmentbutton2;
    private javax.swing.JLabel timelable;
    private javax.swing.JLabel titel;
    private javax.swing.JPanel topheader;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JDesktopPane chomepage1;
}
