/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import MyCode.DBconnect;
import java.awt.Color;
//import static database.Database.connect;
import java.awt.HeadlessException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author computer corner
 */
public class Expense extends javax.swing.JFrame  {
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form Expense1
     */
    
    String AState;
    String AJOB;
    
    public Expense() {
        initComponents();
    }
    
    public Expense(String State, String JOB) {
        
        AState = State;
        AJOB = JOB;
        
        initComponents();
        
        Aloadlable();
        Aloaddatetime();
    }
    public void tableload(){
    try{
        con = DBconnect.connect();
        //con= connect.ConnectDB();
        String sql="select * from expences";
        pst=con.prepareStatement(sql);
        rs= pst.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}
    public void Aloaddatetime() {
        
        Thread DT = new Thread() {
             
            public void run() {
                
                try {
                
                    for(;;) {
                             
                        Date ADateTime = new Date();
                        
                        DateFormat DF1 = new SimpleDateFormat("hh:mm:ss");
                        String Clock = DF1.format(ADateTime);
                        timelable.setText(Clock);    
                             
                        DateFormat DF2 = new SimpleDateFormat("dd-MM-YYYY");
                        String Date = DF2.format(ADateTime);
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
    
    public void Aloadlable() {
    
        if("Login".equals(AState)) {
        
            logoutlable.setText("Logout");
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fire = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtWater = new javax.swing.JTextField();
        txtElectricity = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();
        txtInsurance = new javax.swing.JTextField();
        txtSmallExpense = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtBankLoan = new javax.swing.JTextField();
        txtOverDraft = new javax.swing.JTextField();
        txtAd = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnTotal = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        topheader = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        logoutlable = new javax.swing.JLabel();
        datelable = new javax.swing.JLabel();
        timelable = new javax.swing.JLabel();
        titel = new javax.swing.JLabel();
        homebutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 728));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 728));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(802, 506));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Administration Expenses");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(12, 329, 161, 15);

        jLabel3.setText("Electicity bill");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(12, 97, 57, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Financial expenses");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(350, 40, 120, 15);

        jLabel6.setText("Water bill");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(12, 137, 45, 14);

        jLabel7.setText("Telephone bill");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(12, 177, 65, 14);

        jLabel8.setText("Insurance");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(12, 230, 48, 14);

        jLabel9.setText("Small Expenses");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(12, 275, 73, 14);

        txtWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWaterActionPerformed(evt);
            }
        });
        jPanel1.add(txtWater);
        txtWater.setBounds(117, 134, 97, 20);

        txtElectricity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtElectricityActionPerformed(evt);
            }
        });
        jPanel1.add(txtElectricity);
        txtElectricity.setBounds(117, 94, 97, 20);
        jPanel1.add(txtTelephone);
        txtTelephone.setBounds(117, 174, 97, 20);
        jPanel1.add(txtInsurance);
        txtInsurance.setBounds(117, 227, 97, 20);
        jPanel1.add(txtSmallExpense);
        txtSmallExpense.setBounds(117, 272, 97, 20);

        jLabel10.setText("Bank loan interest");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(443, 97, 86, 14);

        jLabel12.setText("Overdraft");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(443, 137, 48, 14);

        jLabel13.setText("Advertisements");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(443, 177, 75, 14);
        jPanel1.add(txtBankLoan);
        txtBankLoan.setBounds(652, 94, 130, 20);
        jPanel1.add(txtOverDraft);
        txtOverDraft.setBounds(652, 134, 130, 20);
        jPanel1.add(txtAd);
        txtAd.setBounds(652, 174, 130, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Total");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(12, 436, 30, 17);
        jPanel1.add(txtTotal);
        txtTotal.setBounds(117, 434, 97, 20);

        btnTotal.setText("Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });
        jPanel1.add(btnTotal);
        btnTotal.setBounds(233, 464, 57, 23);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(380, 420, 84, 23);

        jButton3.setText("view");
        jPanel1.add(jButton3);
        jButton3.setBounds(560, 420, 55, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(289, 329, 482, 76);

        jLabel5.setText("Date");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(12, 468, 23, 14);
        jPanel1.add(txtDate);
        txtDate.setBounds(118, 465, 97, 20);

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(630, 420, 65, 23);

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(310, 420, 65, 23);

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(470, 420, 80, 23);

        jButton1.setLabel("Expenses Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(630, 470, 115, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(290, 150, 802, 506);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 1370, 730);

        header.setBackground(new java.awt.Color(0, 0, 0));
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

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.jpg"))); // NOI18N
        topheader.add(jLabel14);
        jLabel14.setBounds(0, 0, 25, 25);

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
        titel.setForeground(new java.awt.Color(255, 255, 255));
        titel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titel.setText("Account Management");
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

        getContentPane().add(header);
        header.setBounds(0, 0, 1366, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWaterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWaterActionPerformed

    private void txtElectricityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtElectricityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtElectricityActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        txtTotal.setText("");
        int ele, wat, tele, insu, sma, loan, draft, ads;
        String s = "Electricity Bill";
        try{
            ele = Integer.parseInt(txtElectricity.getText());
            s = "Water Bill";
            wat = Integer.parseInt(txtWater.getText());
            s = "Telephone Bill";
            tele = Integer.parseInt(txtTelephone.getText());
            s = "Insurance Bill";
            insu = Integer.parseInt(txtInsurance.getText());
            s = "Small Ecpenses";
            sma = Integer.parseInt(txtSmallExpense.getText());
            s = "Overdraft";
            draft = Integer.parseInt(txtOverDraft.getText());
            s = "Advertisements";
            ads = Integer.parseInt(txtAd.getText());
            s= "Bank Loan Interest";
            loan = Integer.parseInt(txtBankLoan.getText());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Please Enter Numbers Only on "+s+" Field", "Error", JOptionPane.OK_OPTION);
            return;
        }
        txtTotal.setText(Integer.toString(ele+wat+tele+insu+sma+loan+draft+ads));
    }//GEN-LAST:event_btnTotalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.hide();
        Acc s =new Acc(AState, AJOB);
        s.show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            con = DBconnect.connect();
            //con= connect.ConnectDB();
            if(txtElectricity.getText().equals("")){
                JOptionPane.showMessageDialog(this, "please retrieve electricity bill ammount ","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txtWater.getText().equals("")){
                JOptionPane.showMessageDialog(this, "please retrieve water bill ammount ","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txtTelephone.getText().equals("")){
                JOptionPane.showMessageDialog(this, "please retrieve Telephone bill ammount ","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txtInsurance.getText().equals("")){
                JOptionPane.showMessageDialog(this, "please retrieve insurance bill ammount ","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txtSmallExpense.getText().equals("")){
                JOptionPane.showMessageDialog(this, "please retrieve small expences  ammount ","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txtBankLoan.getText().equals("")){
                JOptionPane.showMessageDialog(this, "please retrieve bank loan  ammount ","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txtOverDraft.getText().equals("")){
                JOptionPane.showMessageDialog(this, "please retrieve overdraft ammount ","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txtAd.getText().equals("")){
                JOptionPane.showMessageDialog(this, "please retrieve advertisement  ammount ","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Statement stmt;
            stmt= con.createStatement();
            String query="INSERT INTO `expences`(`electicitybill`, `waterbill`, `telephonebill`, `insurance`, `smallexpences`, `bankloaninterest`, `overdraft`, `advertisement`, `date`) VALUES "
                    + "('"+txtElectricity.getText()+"' ,'"+txtWater.getText()+"', '"+txtTelephone.getText()+"', '"+txtInsurance.getText()+"', '"+txtBankLoan.getText()+"', '"+txtBankLoan.getText()+"', '"+txtOverDraft.getText()+"', '"+txtAd.getText()+"', '"+txtDate.getText()+"')"; 
            System.out.println(query);   
            stmt.execute(query);
                tableload();
               JOptionPane.showMessageDialog(this,"Successfully saved","Record",JOptionPane.INFORMATION_MESSAGE);

        }
        catch(HeadlessException ex){
            JOptionPane.showMessageDialog(this,ex);
        } catch (SQLException ex) {
            Logger.getLogger(Expense.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       tableload();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            JasperDesign jd =
            JRXmlLoader.load("C:\\Users\\computer corner\\Desktop\\ITP Interfaces\\Final Interface\\src\\Interface\\report5.jrxml");
            String sql = "select * from expences";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp);
            
        }
        catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Successfully Deleted","Error",JOptionPane.ERROR_MESSAGE);
       // String t1=jTable1.getSelectedRow();
        try {
            con = DBconnect.connect();
            //con= connect.ConnectDB();
             String query="DELETE FROM expences WHERE type='"+jTable1.getSelectedRow()+"' "; 
            pst=con.prepareStatement(query);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Successfully Deleted","Error",JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            
            
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed

        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

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

        if("Login".equals(AState)) {

            HomePage HP = new HomePage(AState, AJOB);
            HP.setVisible(true);
            this.dispose();

        }

        else {

            HomePage HP = new HomePage();
            HP.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_homebuttonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Expense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expense().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTotal;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel datelable;
    private javax.swing.JTextField fire;
    private javax.swing.JPanel header;
    private javax.swing.JButton homebutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logoutlable;
    private javax.swing.JLabel timelable;
    private javax.swing.JLabel titel;
    private javax.swing.JPanel topheader;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtBankLoan;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtElectricity;
    private javax.swing.JTextField txtInsurance;
    private javax.swing.JTextField txtOverDraft;
    private javax.swing.JTextField txtSmallExpense;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtWater;
    // End of variables declaration//GEN-END:variables
}
