package Interface;

import MyCode.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResetPassword extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    
    public ResetPassword() {
        
        initComponents();
        
        con = DBconnect.connect();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        topheader = new javax.swing.JPanel();
        closebutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usernamefield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cpasswordfield = new javax.swing.JPasswordField();
        resetbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        crpasswordfield = new javax.swing.JPasswordField();
        npasswordfield = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 200, 0, 0));
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(380, 365));
        jPanel1.setLayout(null);

        topheader.setBackground(new java.awt.Color(255, 255, 255));
        topheader.setPreferredSize(new java.awt.Dimension(380, 25));
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
        closebutton.setBounds(355, 0, 25, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.jpg"))); // NOI18N
        topheader.add(jLabel1);
        jLabel1.setBounds(0, 0, 25, 25);

        jPanel1.add(topheader);
        topheader.setBounds(0, 0, 380, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("User Name");
        jLabel5.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 110, 150, 30);

        usernamefield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usernamefield.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel1.add(usernamefield);
        usernamefield.setBounds(185, 110, 160, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Confirm Password");
        jLabel4.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 230, 150, 30);

        cpasswordfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cpasswordfield.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel1.add(cpasswordfield);
        cpasswordfield.setBounds(185, 230, 160, 30);

        resetbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resetbutton.setText("Reset");
        resetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(resetbutton);
        resetbutton.setBounds(240, 290, 100, 31);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Reset Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 42, 380, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Current Password");
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 150, 150, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("New Password");
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 190, 150, 30);

        crpasswordfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        crpasswordfield.setPreferredSize(new java.awt.Dimension(160, 30));
        crpasswordfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crpasswordfieldActionPerformed(evt);
            }
        });
        jPanel1.add(crpasswordfield);
        crpasswordfield.setBounds(185, 150, 160, 30);

        npasswordfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        npasswordfield.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel1.add(npasswordfield);
        npasswordfield.setBounds(185, 190, 160, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Reset.jpg"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(380, 340));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 25, 380, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebuttonActionPerformed

        this.dispose();

    }//GEN-LAST:event_closebuttonActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed

        try {

            String UName = usernamefield.getText();
            String CrPW = crpasswordfield.getText();
            String NPW = npasswordfield.getText();
            String CPW = cpasswordfield.getText();

            String PW = "Null";

            if(NPW.equals(CPW)) {
            
                sql = "SELECT Password FROM login WHERE UserName = '"+ UName +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while(rs.next()) {

                    PW = rs.getString("Password");
                
                }
                
                if(PW.equals(CrPW)) {
                
                    sql = "UPDATE login SET Password = '"+ NPW +"' WHERE UserName = '"+ UName +"'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    
                    JOption JO1 = new JOption(1, "Successful.");
                    JO1.setVisible(true);
                    
                    this.dispose();
                    
                }
                
                else {
                
                    JOption JO2 = new JOption(1, "Invalid User Name or Password.");
                    JO2.setVisible(true);
                    
                }
            }
            
            else {
            
                JOption JO3 = new JOption(1, "Passwords not match.");
                JO3.setVisible(true);
                
            }
        }

        catch(Exception e) {

            System.out.println(e);

        }
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void crpasswordfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crpasswordfieldActionPerformed
    }//GEN-LAST:event_crpasswordfieldActionPerformed

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
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closebutton;
    private javax.swing.JPasswordField cpasswordfield;
    private javax.swing.JPasswordField crpasswordfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField npasswordfield;
    private javax.swing.JButton resetbutton;
    private javax.swing.JPanel topheader;
    private javax.swing.JTextField usernamefield;
    // End of variables declaration//GEN-END:variables
}
