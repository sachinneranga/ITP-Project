package Interface;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.xml.internal.bind.unmarshaller.Messages.format;
import MyCode.DBconnect;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.format;
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
import javax.swing.Timer;
import static jdk.nashorn.api.scripting.ScriptUtils.format;
import net.proteanit.sql.DbUtils;

public class EmployeeAtendance extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public EmployeeAtendance() {

        initComponents();
        //CONNECT TO DB
        con = DBconnect.connect();
        //load table
        tableload();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        titel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        namelb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datelb = new javax.swing.JLabel();
        monthcom = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        enobox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        atentable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ltbox = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        etbox = new javax.swing.JLabel();
        otbox = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

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
        titel.setText("Employee Atendance");
        titel.setPreferredSize(new java.awt.Dimension(1366, 40));
        background.add(titel);
        titel.setBounds(0, 20, 1366, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Name");
        background.add(jLabel13);
        jLabel13.setBounds(60, 130, 110, 20);

        namelb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        namelb.setForeground(new java.awt.Color(204, 204, 255));
        background.add(namelb);
        namelb.setBounds(250, 130, 260, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EmpNo");
        background.add(jLabel2);
        jLabel2.setBounds(60, 80, 110, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date");
        background.add(jLabel3);
        jLabel3.setBounds(60, 170, 110, 22);

        datelb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        datelb.setForeground(new java.awt.Color(204, 204, 255));
        background.add(datelb);
        datelb.setBounds(250, 170, 160, 30);

        monthcom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        monthcom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select month", "January", "February", "March", "April", "May", "June", "July", "Augest", "September", "Oct", "November", "Desember" }));
        background.add(monthcom);
        monthcom.setBounds(250, 220, 160, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Month");
        background.add(jLabel7);
        jLabel7.setBounds(60, 220, 110, 22);

        enobox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enoboxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enoboxKeyTyped(evt);
            }
        });
        background.add(enobox);
        enobox.setBounds(250, 80, 160, 30);

        atentable.setModel(new javax.swing.table.DefaultTableModel(
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
                "EmpNo", "Name", "Date", "Month", "EnterTime", "LeaveTime", "OThours"
            }
        ));
        atentable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atentableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(atentable);

        background.add(jScrollPane1);
        jScrollPane1.setBounds(520, 100, 800, 402);

        jButton1.setText("Mark Entering Records");
        jButton1.setPreferredSize(new java.awt.Dimension(110, 31));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        background.add(jButton1);
        jButton1.setBounds(30, 290, 200, 40);

        jButton3.setText("OT Hours");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        background.add(jButton3);
        jButton3.setBounds(130, 520, 120, 50);

        jButton2.setText("Mark Leaving Records");
        jButton2.setPreferredSize(new java.awt.Dimension(110, 31));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2);
        jButton2.setBounds(30, 360, 200, 40);
        background.add(ltbox);
        ltbox.setBounds(260, 360, 140, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("OT Hours");
        background.add(jLabel9);
        jLabel9.setBounds(50, 470, 110, 22);
        background.add(etbox);
        etbox.setBounds(260, 290, 130, 30);

        otbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otboxActionPerformed(evt);
            }
        });
        otbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                otboxKeyPressed(evt);
            }
        });
        background.add(otbox);
        otbox.setBounds(250, 456, 190, 40);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Untitled-1.jpg"))); // NOI18N
        background.add(jLabel11);
        jLabel11.setBounds(0, 0, 1358, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enoboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enoboxKeyPressed
        String empid = enobox.getText();

        try {
            String sq = "SELECT FName FROM employee WHERE Empno = '" + empid + "'";
            pst = con.prepareStatement(sq);
            rs = pst.executeQuery();
            while (rs.next()) {
                namelb.setText(rs.getString(1));
                String f = rs.getString(1);
                System.out.println(f);
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                datelb.setText(s.format(d));
            }

        } catch (SQLException e) {
        }

        


    }//GEN-LAST:event_enoboxKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String empid = enobox.getText();
        String name = namelb.getText();
        String date = datelb.getText();
        String month = (String) monthcom.getSelectedItem();

        if (empid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You missed Empno feield");
        } else if ("Select month".equals(monthcom)) {
            JOptionPane.showMessageDialog(null, "Invalid Selection \n HINT: Month");
        } else {
             new Timer(0, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date d = new Date();
                    SimpleDateFormat s = new SimpleDateFormat("hh:mm");
                    etbox.setText(s.format(d));
                }
            }).start();
            
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
                 new Timer(0, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date d = new Date();
                    SimpleDateFormat s = new SimpleDateFormat("hh:mm");
                    ltbox.setText(s.format(d));
                }
            }).start();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void atentableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atentableMouseClicked
        enobox.setText(null);
        namelb.setText(null);
        datelb.setText(null);
        monthcom.setSelectedItem("Select month");
        etbox.setText(null);
        
        

        int row = atentable.getSelectedRow();
        String eid = atentable.getValueAt(row, 0).toString();
        String name = atentable.getValueAt(row, 1).toString();
        String date = atentable.getValueAt(row, 2).toString();
        String month = atentable.getValueAt(row, 3).toString();
        String etime = atentable.getValueAt(row, 4).toString();
    
        

        enobox.setText(eid);
        namelb.setText(name);
        datelb.setText(date);
        monthcom.setSelectedItem(month);
        etbox.setText(etime);
        
        
    }//GEN-LAST:event_atentableMouseClicked

    private void otboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otboxActionPerformed

    private void otboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otboxKeyPressed
        

    }//GEN-LAST:event_otboxKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String ltime = ltbox.getText();
        String empid = enobox.getText();
        String date = datelb.getText();
        String ot = otbox.getText();
            
            try {
                String ceq1;
                ceq1 = "UPDATE atendance SET LeaveTime='"+ltime+"',OThours='"+ot+"' WHERE EmpNo='" + empid + "' AND Date='"+date+"'";
                pst = con.prepareStatement(ceq1);
                pst.execute();
                tableload();
                
                enobox.setText(null);
                namelb.setText(null);
                datelb.setText(null);
                monthcom.setSelectedItem("Select month");
                etbox.setText(null);
                ltbox.setText(null);
                otbox.setText(null);
                
           } catch (SQLException e) {
               JOptionPane.showMessageDialog ( null, "You have already made your leaving" );
                
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        getoth();
    }//GEN-LAST:event_jButton1MouseExited

    private void enoboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enoboxKeyTyped
        
         char enter = evt.getKeyChar();
        
         if(!(Character.isDigit(enter))) {
        
            enobox.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else {
            
            enobox.setBackground(Color.WHITE);
            
        }
        
        
    }//GEN-LAST:event_enoboxKeyTyped

    public void tableload() {
        try {
            String sql2;
            sql2 = "SELECT * FROM atendance";
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            atentable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getoth(){
         try {
                String empid = enobox.getText();
                String name = namelb.getText();
                String date = datelb.getText();
                String month = (String) monthcom.getSelectedItem();
                String etime=etbox.getText();
                
                String ceq;
                ceq = "INSERT INTO atendance (Empno,Name,Date,Month,EnterTime) VALUES('" + empid + "','" + name + "','" + date + "','" + month + "','" + etime + "')";
                pst = con.prepareStatement(ceq);
                pst.execute();
                tableload();

                enobox.setText(null);
                namelb.setText(null);
                datelb.setText(null);
                monthcom.setSelectedItem("Select month");
                etbox.setText(null);

            } catch (Exception e) {
                JOptionPane.showMessageDialog ( null, "You have already made your attendance" );
            }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable atentable;
    private javax.swing.JPanel background;
    private javax.swing.JLabel datelb;
    private javax.swing.JTextField enobox;
    private javax.swing.JLabel etbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ltbox;
    private javax.swing.JComboBox<String> monthcom;
    private javax.swing.JLabel namelb;
    private javax.swing.JTextField otbox;
    private javax.swing.JLabel titel;
    // End of variables declaration//GEN-END:variables

}
