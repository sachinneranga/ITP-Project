package Interface;

import MyCode.DBconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static org.mozilla.javascript.Context.enter;

public class EmployeeRegistration extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pst = null;
    ResultSet rs=null;
    
    public EmployeeRegistration() {

        initComponents();
         //CONNECT TO DB
        con=DBconnect.connect();
         //load table
        tableload();

    }
    
    
    public void tableload() 
     {
         try {
         String sql1;
         sql1="SELECT * FROM employee";
         pst=con.prepareStatement(sql1);
         rs=pst.executeQuery();
         regitable.setModel(DbUtils.resultSetToTableModel(rs));
             
         } catch (Exception e) {
             System.out.println(e); 
         }
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jticom = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lnamebox = new javax.swing.JTextField();
        nicbox = new javax.swing.JTextField();
        pnbox = new javax.swing.JTextField();
        fnamebox = new javax.swing.JTextField();
        jddc = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        titel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addresslb = new javax.swing.JLabel();
        gendercom = new javax.swing.JComboBox<>();
        addressbox = new javax.swing.JTextField();
        dobdc = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        bsbox1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        regitable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jticom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Job Title", "Admin", "HR Manager", "Reciptionist", "Accountant", "Cashier" }));
        background.add(jticom);
        jticom.setBounds(220, 370, 200, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name");
        background.add(jLabel2);
        jLabel2.setBounds(60, 40, 110, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name");
        background.add(jLabel3);
        jLabel3.setBounds(60, 80, 110, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone Number");
        background.add(jLabel4);
        jLabel4.setBounds(20, 160, 150, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date Of Birth");
        background.add(jLabel5);
        jLabel5.setBounds(40, 290, 130, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NIC");
        background.add(jLabel6);
        jLabel6.setBounds(120, 120, 50, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gender");
        background.add(jLabel1);
        jLabel1.setBounds(90, 330, 90, 22);

        lnamebox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lnamebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnameboxKeyTyped(evt);
            }
        });
        background.add(lnamebox);
        lnamebox.setBounds(220, 80, 200, 28);

        nicbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nicbox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nicboxFocusLost(evt);
            }
        });
        background.add(nicbox);
        nicbox.setBounds(220, 120, 200, 28);

        pnbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnbox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pnboxFocusLost(evt);
            }
        });
        pnbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pnboxKeyTyped(evt);
            }
        });
        background.add(pnbox);
        pnbox.setBounds(220, 160, 200, 30);

        fnamebox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fnamebox.setText(" ");
        fnamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameboxActionPerformed(evt);
            }
        });
        fnamebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnameboxKeyTyped(evt);
            }
        });
        background.add(fnamebox);
        fnamebox.setBounds(220, 40, 200, 28);

        jddc.setDateFormatString("yyyy-MM-dd");
        background.add(jddc);
        jddc.setBounds(220, 460, 200, 20);

        jButton1.setText("Register");
        jButton1.setPreferredSize(new java.awt.Dimension(110, 31));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        background.add(jButton1);
        jButton1.setBounds(20, 510, 110, 40);

        jButton2.setText("Change Ditails");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2);
        jButton2.setBounds(150, 510, 150, 40);

        jButton3.setText("Resign");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        background.add(jButton3);
        jButton3.setBounds(320, 510, 100, 40);

        titel.setBackground(new java.awt.Color(204, 204, 255));
        titel.setFont(new java.awt.Font("Bodoni MT Black", 3, 36)); // NOI18N
        titel.setForeground(new java.awt.Color(255, 255, 255));
        titel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titel.setText("Employee Registration");
        titel.setPreferredSize(new java.awt.Dimension(1366, 40));
        background.add(titel);
        titel.setBounds(0, 0, 1366, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Join date");
        background.add(jLabel9);
        jLabel9.setBounds(70, 460, 90, 22);

        addresslb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addresslb.setForeground(new java.awt.Color(255, 255, 255));
        addresslb.setText("Address");
        background.add(addresslb);
        addresslb.setBounds(80, 230, 80, 22);

        gendercom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female" }));
        background.add(gendercom);
        gendercom.setBounds(220, 330, 200, 20);

        addressbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        background.add(addressbox);
        addressbox.setBounds(220, 200, 200, 80);

        dobdc.setDateFormatString("yyyy-MM-dd");
        background.add(dobdc);
        dobdc.setBounds(220, 290, 200, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Job Title");
        background.add(jLabel8);
        jLabel8.setBounds(90, 370, 90, 22);

        bsbox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bsbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsbox1ActionPerformed(evt);
            }
        });
        bsbox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bsbox1KeyTyped(evt);
            }
        });
        background.add(bsbox1);
        bsbox1.setBounds(220, 410, 200, 28);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Basic Salary");
        background.add(jLabel11);
        jLabel11.setBounds(40, 410, 120, 22);

        jButton4.setText("Refrish");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        background.add(jButton4);
        jButton4.setBounds(440, 510, 100, 40);

        regitable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "EmpNo", "FName", "LName", "NIC", "PhoneNumber", "DOB", "Gender", "Email", "BasicSalary", "JoinDate"
            }
        ));
        regitable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regitableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(regitable);

        background.add(jScrollPane1);
        jScrollPane1.setBounds(470, 60, 870, 420);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Untitled-1.jpg"))); // NOI18N
        background.add(jLabel10);
        jLabel10.setBounds(0, 0, 1358, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                String fname=fnamebox.getText();
                String lname=lnamebox.getText();
                String nic=nicbox.getText();
                String address=addressbox.getText();
                String pn=pnbox.getText();
                SimpleDateFormat dob = new SimpleDateFormat("yyyy-MM-dd");
                String dob1 =dob.format(jddc.getDate());
                //String email=mailbox.getText();
                String jtitle=(String) jticom.getSelectedItem();
                String bsalary=bsbox1.getText();
                String gender = (String) gendercom.getSelectedItem();
                DateFormat jdate1= new SimpleDateFormat("yyyy-MM-dd");
                String jdate =jdate1.format(jddc.getDate());
                
                
                
        if (fname.isEmpty() || lname.isEmpty() || nic.isEmpty() ||address.isEmpty()|| pn.isEmpty() || dob1.isEmpty() || bsalary.isEmpty()|| jdate.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You missed some feield(s)");
        }
        
        else if ("Select Job title".equals(jtitle) )
        {
            JOptionPane.showMessageDialog(null, "Invalid Selection \n HINT: Job title");
        }
        
        else if ("Select Gender".equals(gender) )
        {
            JOptionPane.showMessageDialog(null, "Invalid Selection \n HINT: Job title");
        }
        else
        {
            int x=JOptionPane.showConfirmDialog(null, "Are you sure, Do you want to add this record");
            if (x==0)
            {
                try {
                        String ceq ;
                        ceq = "INSERT INTO employee(FName,LName,NIC,PhoneNumber,Address,DOB,Gender,JobTitel,BasicSalary,JoinDate) VALUES('"+fname+"','"+lname+"','"+nic+"','"+pn+"','"+address+"','"+dob1+"','"+gender+"','"+jtitle+"','"+bsalary+"','"+jdate+"')";
                        pst=con.prepareStatement(ceq);
                        pst.execute();
                        tableload();
                        
                        if(true) {
                        
                            int ENo;
                            
                            String Sql = "SELECT Empno FROM employee WHERE NIC = '"+ nic +"'";
                            pst=con.prepareStatement(Sql);
                            rs = pst.executeQuery();
                            
                            while(rs.next()) {
                                
                                ENo = Integer.valueOf(rs.getString("Empno"));
                                
                                String SQL = "INSERT INTO login (EmpID, UserName, Password) VALUES('"+ ENo +"', '"+ fname +"', '"+ fname +"')";
                                pst=con.prepareStatement(SQL);
                                pst.execute();
                            
                            }
                        }
                        fnamebox.setText(null);
                        lnamebox.setText(null);
                        nicbox.setText(null);
                        addressbox.setText(null);
                        pnbox.setText(null);
                        dobdc.setDate(null);
                        //mailbox.setText(null);
                        jticom.setSelectedItem("Select Job Title");
                        bsbox1.setText(null);
                        gendercom.setSelectedItem("Select Gender");
                        jddc.setDate(null);
                    } 
                catch (SQLException ex) 
                {
                        Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                        fnamebox.setText(null);
                        lnamebox.setText(null);
                        nicbox.setText(null);
                        addressbox.setText(null);
                        pnbox.setText(null);
                        dobdc.setDate(null);
                        //mailbox.setText(null);
                        jticom.setSelectedItem("Select Job Title");
                        bsbox1.setText(null);
                        gendercom.setSelectedItem("Select Gender");
                        jddc.setDate(null);
            }
            
            
            
        }
                
               
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                String fname=fnamebox.getText();
                String lname=lnamebox.getText();
                String nic=nicbox.getText();
                String address=addressbox.getText();
                String pn=pnbox.getText();
                SimpleDateFormat dob = new SimpleDateFormat("yyyy-MM-dd");
                String dob1 =dob.format(jddc.getDate());
                //String email=mailbox.getText();
                String jtitle=(String) jticom.getSelectedItem();
                String bsalary=bsbox1.getText();
                String gender = (String) gendercom.getSelectedItem();
                DateFormat jdate1= new SimpleDateFormat("yyyy-MM-dd");
                String jdate =jdate1.format(jddc.getDate());
                
                       
         if (fname.isEmpty() || lname.isEmpty() || nic.isEmpty() ||address.isEmpty()|| pn.isEmpty() || dob1.isEmpty() || bsalary.isEmpty()|| jdate.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You missed some feield(s)");
        }
        else if (!(Pattern.matches("^[0]{1}[0-9]{9}$",pnbox.getText())))
        {
            JOptionPane.showMessageDialog(null,"Please enter valide phone number","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(!(Pattern.matches("^[0-9]{9}[V]{1}$",nicbox.getText())))
        {
            JOptionPane.showMessageDialog(null,"Please enter a valid NIC","Error",JOptionPane.ERROR_MESSAGE);
        } 
//        else if(!(Pattern.matches("^[0-9][a-z]+[@]{1}[a-z]+[.][a-z+]$",mailbox.getText())))
//        {
//            JOptionPane.showMessageDialog(null,"Please enter a valid e-mail address","Error",JOptionPane.ERROR_MESSAGE);
//        } 
        else if ("Select Job title".equals(jtitle) )
        {
            JOptionPane.showMessageDialog(null, "Invalid Selection \n HINT: Job title");
        }
        
        else if ("Select Gender".equals(gender) )
        {
            JOptionPane.showMessageDialog(null, "Invalid Selection \n HINT: Job title");
        }
         
        
        else
        {
        
            
            int x=JOptionPane.showConfirmDialog(null, "Are you sure, Do you want to add this record");
            
            
            if (x==0)
            {
  
         
            try {
                int row=regitable.getSelectedRow();
                String eid=regitable.getValueAt(row,0).toString();
                
                String ceq1 ;
                ceq1 ="UPDATE employee SET FName='"+fname+"',LName='"+lname+"',NIC='"+nic+"',PhoneNumber='"+pn+"',Address='"+address+"',DOB='"+dob1+"',Gender='"+gender+"',JobTitel='"+jtitle+"',BasicSalary='"+bsalary+"',JoinDate='"+jdate+"' WHERE EmpNo='"+eid+"'";
                pst=con.prepareStatement(ceq1);
                pst.execute();
                tableload();
                
                        fnamebox.setText(null);
                        lnamebox.setText(null);
                        nicbox.setText(null);
                        addressbox.setText(null);
                        pnbox.setText(null);
                        dobdc.setDate(null);
                       // mailbox.setText(null);
                        jticom.setSelectedItem("Select Job Title");
                        bsbox1.setText(null);
                        gendercom.setSelectedItem("Select Gender");
                        jddc.setDate(null);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
         }
            
            else
            {
                        fnamebox.setText(null);
                        lnamebox.setText(null);
                        nicbox.setText(null);
                        addressbox.setText(null);
                        pnbox.setText(null);
                        dobdc.setDate(null);
                        //mailbox.setText(null);
                        jticom.setSelectedItem("Select Job Title");
                        bsbox1.setText(null);
                        gendercom.setSelectedItem("Select Gender");
                        jddc.setDate(null);
            }
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int x=JOptionPane.showConfirmDialog(null, "Are you sure, Do you want to delete this record");
            
            
            if (x==0)
        {
            try {
                
                String nic=nicbox.getText();
                System.out.println(nic);
                String dq1="DELETE FROM employee WHERE NIC = '"+ nic +"'";
                pst=con.prepareStatement(dq1);
                pst.execute();
                
                //lode table
                 tableload();
            }
            catch (SQLException e) {
            }
            
        }
        
        else
        {
                        fnamebox.setText(null);
                        lnamebox.setText(null);
                        nicbox.setText(null);
                        addressbox.setText(null);
                        pnbox.setText(null);
                        dobdc.setDate(null);
                        //mailbox.setText(null);
                        jticom.setSelectedItem("Select Job Title");
                        bsbox1.setText(null);
                        gendercom.setSelectedItem("Select Gender");
                        jddc.setDate(null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bsbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bsbox1ActionPerformed

    private void regitableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regitableMouseClicked
        fnamebox.setText(null);
        lnamebox.setText(null);
        nicbox.setText(null);
        addressbox.setText(null);
        pnbox.setText(null);
        dobdc.setDate(null);
       // mailbox.setText(null);
        jticom.setSelectedItem("Select Job Title");
        bsbox1.setText(null);
        gendercom.setSelectedItem("Select Gender");
        jddc.setDate(null);
        
        DefaultTableModel model = (DefaultTableModel)regitable.getModel();
        int row=regitable.getSelectedRow();
        String eid=regitable.getValueAt(row,0).toString();
        String fname=regitable.getValueAt(row,1).toString();
        String lname=regitable.getValueAt(row,2).toString();
        String nic=regitable.getValueAt(row,3).toString();
        String address=regitable.getValueAt(row,5).toString();
        String pn=regitable.getValueAt(row,4).toString();
        
        try {
            Date date = new SimpleDateFormat ("yyyy-MM-dd").parse((String)model.getValueAt(row, 6).toString());
            dobdc.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String dob=regitable.getValueAt(row,6).toString();
        //String mail=regitable.getValueAt(row,8).toString();
        String jtitel=regitable.getValueAt(row,8).toString();
        String bsalary=regitable.getValueAt(row,9).toString();
        String gender=regitable.getValueAt(row,7).toString();
        //String jdate=regitable.getValueAt(row,10).toString();
        
        try {
            Date date1 = new SimpleDateFormat ("yyyy-MM-dd").parse((String)model.getValueAt(row,10).toString());
              jddc.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        fnamebox.setText(fname);
        lnamebox.setText(lname);
        nicbox.setText(nic);
        addressbox.setText(address);
        pnbox.setText(pn);
        //dobdc.setDate((Date).day.parse(rs.getString("DOB")));
      
        //mailbox.setText(mail);
        jticom.setSelectedItem(jtitel);
        bsbox1.setText(bsalary);
        gendercom.setSelectedItem(gender);
      
        
        
        
    }//GEN-LAST:event_regitableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       fnamebox.setText(null);
       lnamebox.setText(null);
       nicbox.setText(null);
       addressbox.setText(null);
       pnbox.setText(null);
       dobdc.setDate(null);
       // mailbox.setText(null);
       jticom.setSelectedItem("Select Job Title");
       bsbox1.setText(null);
       gendercom.setSelectedItem("Select Gender");
       jddc.setDate(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void fnameboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameboxKeyTyped
       
      char enter = evt.getKeyChar();
        
        if(Character.isDigit(enter)) {
        
            fnamebox.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else {
            
            fnamebox.setBackground(Color.WHITE);
            
        }
        
        
        
    }//GEN-LAST:event_fnameboxKeyTyped

    private void lnameboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameboxKeyTyped
 
               char enter = evt.getKeyChar();
        
        if(Character.isDigit(enter)) {
        
            lnamebox.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else {
            
            lnamebox.setBackground(Color.WHITE);
            
        }

// TODO add your handling code here:
    }//GEN-LAST:event_lnameboxKeyTyped

    private void nicboxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nicboxFocusLost
        
        if(!(Pattern.matches("^[0-9]{9}[V]{1}$", nicbox.getText())))
        {
        
            nicbox.setBackground(new Color(255, 102, 102));
            JOptionPane.showMessageDialog(null, "Pleasse enter a valid NIC!");
        
        
        }
        else
        {
            nicbox.setBackground(Color.WHITE);
        
        }
        
    }//GEN-LAST:event_nicboxFocusLost

    private void pnboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnboxKeyTyped
       
             char enter = evt.getKeyChar();
        
        if(!(Character.isDigit(enter))) {
        
            pnbox.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else {
            
            pnbox.setBackground(Color.WHITE);
            
        }
        
    }//GEN-LAST:event_pnboxKeyTyped

    private void pnboxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnboxFocusLost
        
        String tel = pnbox.getText();
        
         if((tel.length() != 10))
        {
        
            pnbox.setBackground(new Color(255, 102, 102));
            JOptionPane.showMessageDialog(null, "Invalid telephone number!");
        
        
        }
        else
        {
            pnbox.setBackground(Color.WHITE);
        
        }
        
        
    }//GEN-LAST:event_pnboxFocusLost

    private void bsbox1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bsbox1KeyTyped
      
        char enter = evt.getKeyChar();
        
         if(!(Character.isDigit(enter))) {
        
            bsbox1.setBackground(new Color(255, 102, 102));
            evt.consume();
        
        }
        
        else {
            
            bsbox1.setBackground(Color.WHITE);
            
        }
        
    }//GEN-LAST:event_bsbox1KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressbox;
    private javax.swing.JLabel addresslb;
    private javax.swing.JPanel background;
    private javax.swing.JTextField bsbox1;
    private com.toedter.calendar.JDateChooser dobdc;
    private javax.swing.JTextField fnamebox;
    private javax.swing.JComboBox<String> gendercom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jddc;
    private javax.swing.JComboBox<String> jticom;
    private javax.swing.JTextField lnamebox;
    private javax.swing.JTextField nicbox;
    private javax.swing.JTextField pnbox;
    private javax.swing.JTable regitable;
    private javax.swing.JLabel titel;
    // End of variables declaration//GEN-END:variables

    
    
}
