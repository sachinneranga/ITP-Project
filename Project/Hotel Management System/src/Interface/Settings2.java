package Interface;

import MyCode.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Settings2 extends javax.swing.JInternalFrame {
  
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    int x;
    
    String S2PType;
    String S2CType;
    String S2OTpye;
    String S2RType;
    int S2NORoom;
    int S2Available = 0;
    int S2Price;
    boolean S2Package = false;
    boolean S2Room = false;
    
    public Settings2() {
        
        initComponents();
        
        con = DBconnect.connect();

        S2activeedit1();
        S2activeedit2();
        
    }
    
    public void S2fillcombo() {
    
        S2PType = ptypecombo.getSelectedItem().toString();
            
        if("Full-Board".equals(S2PType)) {
        
            otypecombo.removeAllItems();
            otypecombo.addItem("Select Option");
            otypecombo.addItem("Single Room");
            otypecombo.addItem("Double Room");
            otypecombo.addItem("Triple Room");
            
        }
        
        if("Half-Board".equals(S2PType)) {
        
            otypecombo.removeAllItems();
            otypecombo.addItem("Select Option");
            otypecombo.addItem("Adults");
            otypecombo.addItem("Children");
            
        }
    }
    
    public void S2loadtable1() {
    
        try {
            
            S2PType = ptypecombo.getSelectedItem().toString();

            if("Full-Board".equals(S2PType)) {

                sql = "SELECT CusType, SingleRoomPrice, DoubleRoomPrice, TripleRoomPrice FROM fullboard";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                
                detailstable.setModel(DbUtils.resultSetToTableModel(rs));

            }

            else if("Half-Board".equals(S2PType)) {

                sql = "SELECT CusType, AdultsPrice, ChildrenPrice FROM halfboard";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                
                detailstable.setModel(DbUtils.resultSetToTableModel(rs));

            }
        } 
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void S2loadtable2() {
    
        try {
            
            S2Room = roomradio.isSelected();

            if(S2Room == true) {

                sql = "SELECT RoomType, NoOfRooms, Available FROM room";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                
                detailstable.setModel(DbUtils.resultSetToTableModel(rs));

            }
        } 
        
        catch(Exception e) {
            
            System.out.println(e);
            
        }
    }
    
    public void S2activeedit1() {
    
        S2Package = packageradio.isSelected();
                
        if(S2Package == false) {
        
            ptypecombo.setEnabled(false); 
            ctypecombo.setEnabled(false);
            otypecombo.setEnabled(false);
            pricefield.setEnabled(false);
   
        }
    
        else if(S2Package == true) {
        
            ptypecombo.setEnabled(true);
            ctypecombo.setEnabled(true);
            otypecombo.setEnabled(true);
            pricefield.setEnabled(true);
            rtypecombo.setEnabled(false);
            noroomfield.setEnabled(false);
   
        }
    }
    
    public void S2activeedit2() {
        
        S2Room = roomradio.isSelected();
        
        if(S2Room == false) {
        
            rtypecombo.setEnabled(false);
            noroomfield.setEnabled(false);
            
        }
        
        else if(S2Room == true) {
        
            rtypecombo.setEnabled(true);
            noroomfield.setEnabled(true);
            ptypecombo.setEnabled(false);
            ctypecombo.setEnabled(false);
            otypecombo.setEnabled(false);
            pricefield.setEnabled(false);
            
        }
    }
    
    public void S2getvalue() {
    
        S2PType = ptypecombo.getSelectedItem().toString();
        S2CType = ctypecombo.getSelectedItem().toString();
        S2OTpye = otypecombo.getSelectedItem().toString();
        S2Price = Integer.valueOf(pricefield.getText());
        S2RType = rtypecombo.getSelectedItem().toString();
        S2NORoom = Integer.valueOf(noroomfield.getText());
        S2Package = packageradio.isSelected();
        S2Room = roomradio.isSelected();
        
    }
    
    public void S2clear() {
    
        ptypecombo.setSelectedItem("Select Package");
        ctypecombo.setSelectedItem("Select Customer");
        otypecombo.setSelectedItem("Select Option");
        pricefield.setText("0");
        rtypecombo.setSelectedItem("Select Room");    
        noroomfield.setText("0");
        
    }
//--------------------------------------------------------- Update -----------------------------------------------------------------------------------    
    public void S2calcavailability() {
    
        try {
                      
            int NoR = 0;
            int Ava = 0;

            sql = "SELECT NoOfRooms, Available FROM room WHERE RoomType = '"+ S2RType +"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()) {

                NoR = Integer.valueOf(rs.getString("NoOfRooms"));
                Ava = Integer.valueOf(rs.getString("Available"));

                if(NoR < S2NORoom) {

                    S2Available = Ava + (S2NORoom - NoR);

                }

                else if(NoR > S2NORoom) {

                    S2Available = Ava - (NoR - S2NORoom);

                }
            }
        
            if(S2Available <= 0) {
            
                S2Available = 0;
                
            }
            
            else if(S2Available > 0) {   
            
                S2Available = S2Available;
                
            }
        } 
        
        catch(Exception e) {
        
            System.out.println(e);
            
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
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labletel2 = new javax.swing.JLabel();
        noroomfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailstable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        labletel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labletel4 = new javax.swing.JLabel();
        pricefield = new javax.swing.JTextField();
        ptypecombo = new javax.swing.JComboBox<>();
        ctypecombo = new javax.swing.JComboBox<>();
        otypecombo = new javax.swing.JComboBox<>();
        rtypecombo = new javax.swing.JComboBox<>();
        roomradio = new javax.swing.JRadioButton();
        packageradio = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        clearbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
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
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rooms & Packages Updating");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(290, 10, 280, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Room Updating");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(100, 40, 160, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Package Updating");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(470, 40, 180, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Room Type");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 90, 126, 25);

        labletel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel2.setText("No Of New Rooms");
        labletel2.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel2.add(labletel2);
        labletel2.setBounds(20, 125, 150, 25);

        noroomfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        noroomfield.setText("0");
        noroomfield.setPreferredSize(new java.awt.Dimension(120, 25));
        noroomfield.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                noroomfieldMouseMoved(evt);
            }
        });
        noroomfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noroomfieldMouseClicked(evt);
            }
        });
        noroomfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noroomfieldKeyPressed(evt);
            }
        });
        jPanel2.add(noroomfield);
        noroomfield.setBounds(170, 125, 120, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Updated Details");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 240, 210, 30);

        detailstable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        detailstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        detailstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailstableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(detailstable);

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Customer Type");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(380, 125, 126, 25);

        labletel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel3.setText("Option Type");
        jPanel2.add(labletel3);
        labletel3.setBounds(380, 160, 126, 25);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Package Type");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(380, 90, 126, 25);

        labletel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labletel4.setText("Price");
        jPanel2.add(labletel4);
        labletel4.setBounds(380, 195, 126, 25);

        pricefield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pricefield.setText("0");
        pricefield.setPreferredSize(new java.awt.Dimension(140, 25));
        pricefield.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pricefieldMouseMoved(evt);
            }
        });
        pricefield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pricefieldMouseClicked(evt);
            }
        });
        pricefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pricefieldKeyPressed(evt);
            }
        });
        jPanel2.add(pricefield);
        pricefield.setBounds(520, 195, 140, 25);

        ptypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ptypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Package", "Full-Board", "Half-Board" }));
        ptypecombo.setPreferredSize(new java.awt.Dimension(140, 25));
        ptypecombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ptypecomboFocusLost(evt);
            }
        });
        ptypecombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                ptypecomboPopupMenuWillBecomeVisible(evt);
            }
        });
        ptypecombo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                ptypecomboComponentHidden(evt);
            }
        });
        ptypecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptypecomboActionPerformed(evt);
            }
        });
        jPanel2.add(ptypecombo);
        ptypecombo.setBounds(520, 90, 140, 25);

        ctypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Customer", "Local", "Foreign" }));
        ctypecombo.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(ctypecombo);
        ctypecombo.setBounds(520, 125, 140, 25);

        otypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        otypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Option" }));
        otypecombo.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel2.add(otypecombo);
        otypecombo.setBounds(520, 160, 140, 25);

        rtypecombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rtypecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room", "Single Room", "Double Room", "Triple Room" }));
        rtypecombo.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(rtypecombo);
        rtypecombo.setBounds(170, 90, 120, 25);

        buttonGroup1.add(roomradio);
        roomradio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roomradio.setText("Room ");
        roomradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomradioActionPerformed(evt);
            }
        });
        jPanel2.add(roomradio);
        roomradio.setBounds(120, 40, 70, 23);

        buttonGroup1.add(packageradio);
        packageradio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        packageradio.setText("Package");
        packageradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packageradioActionPerformed(evt);
            }
        });
        jPanel2.add(packageradio);
        packageradio.setBounds(470, 40, 75, 23);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(4, 250));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(335, 0, 4, 250);

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
        clearbutton.setBounds(730, 180, 110, 31);

        updatebutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updatebutton.setText("Update");
        updatebutton.setPreferredSize(new java.awt.Dimension(110, 31));
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(updatebutton);
        updatebutton.setBounds(730, 130, 110, 31);

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

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
 
        S2clear();
        
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void detailstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailstableMouseClicked
    }//GEN-LAST:event_detailstableMouseClicked

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
   
        try {
            
            S2getvalue();
            S2calcavailability();
            
            if(S2Package == true) {
            
                if("Full-Board".equals(S2PType)) {
                
                    if("Single Room".equals(S2OTpye)) {
                    
                        sql = "UPDATE fullboard SET SingleRoomPrice = '"+ S2Price +"' WHERE CusType = '"+ S2CType +"'";
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        
                    }
                    
                    else if("Double Room".equals(S2OTpye)) {
                    
                        sql = "UPDATE fullboard SET DoubleRoomPrice = '"+ S2Price +"' WHERE CusType = '"+ S2CType +"'";
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        
                    }
                    
                    else if("Triple Room".equals(S2OTpye)) {
                    
                        sql = "UPDATE fullboard SET TripleRoomPrice = '"+ S2Price +"' WHERE CusType = '"+ S2CType +"'";
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        
                    }
                }
                
                else if("Half-Board".equals(S2PType)) {
                
                    if("Adults".equals(S2OTpye)) {
                        
                        sql = "UPDATE halfboard SET AdultsPrice = '"+ S2Price +"' WHERE CusType = '"+ S2CType +"'";
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        
                    }
                    
                    else if("Children".equals(S2OTpye)) {
                    
                        sql = "UPDATE halfboard SET ChildrenPrice = '"+ S2Price +"' WHERE CusType = '"+ S2CType +"'";
                        pst = con.prepareStatement(sql);
                        pst.execute();
                        
                    }
                }
                
                S2loadtable1();
                
            }
            
            else if(S2Room == true) {
            
                sql = "UPDATE room SET NoOfRooms = '"+ S2NORoom +"', Available = '"+ S2Available +"' WHERE RoomType = '"+ S2RType +"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                
                S2Available = 0;
                
                S2loadtable2();
                
            }
            
            JOption JOU = new JOption(1, "Update Sucessful!");
            JOU.setVisible(true);
                        
        } 
        
        catch (Exception e) {
            
            System.out.println(e);
            
        }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void ptypecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptypecomboActionPerformed
        
        S2fillcombo();
        S2loadtable1();
        
    }//GEN-LAST:event_ptypecomboActionPerformed

    private void ptypecomboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ptypecomboFocusLost
    }//GEN-LAST:event_ptypecomboFocusLost

    private void ptypecomboComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ptypecomboComponentHidden
    }//GEN-LAST:event_ptypecomboComponentHidden

    private void ptypecomboPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ptypecomboPopupMenuWillBecomeVisible
    }//GEN-LAST:event_ptypecomboPopupMenuWillBecomeVisible

    private void packageradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packageradioActionPerformed
        
        S2activeedit1();
       
    }//GEN-LAST:event_packageradioActionPerformed

    private void roomradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomradioActionPerformed
        
        S2activeedit2();
        S2loadtable2();
        
    }//GEN-LAST:event_roomradioActionPerformed

    private void noroomfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noroomfieldKeyPressed
        
        String NORooms = noroomfield.getText();
        
        if("0".equals(NORooms)) {
        
            noroomfield.setText("");
            
        }
    }//GEN-LAST:event_noroomfieldKeyPressed

    private void pricefieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricefieldKeyPressed
        
        String Price = pricefield.getText();
        
        if("0".equals(Price)) {
        
            pricefield.setText("");
            
        }
    }//GEN-LAST:event_pricefieldKeyPressed

    private void noroomfieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noroomfieldMouseMoved
        
        String NORooms = noroomfield.getText();
        
        if(NORooms.isEmpty()) {
        
            noroomfield.setText("0");
            
        }
    }//GEN-LAST:event_noroomfieldMouseMoved

    private void pricefieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pricefieldMouseMoved
        
        String Price = pricefield.getText();
        
        if(Price.isEmpty()) {
        
            pricefield.setText("0");
            
        }
    }//GEN-LAST:event_pricefieldMouseMoved

    private void noroomfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noroomfieldMouseClicked
        
        String NORooms = noroomfield.getText();
        
        if("0".equals(NORooms)) {
        
            noroomfield.setText("");
            
        }
    }//GEN-LAST:event_noroomfieldMouseClicked

    private void pricefieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pricefieldMouseClicked
        
        String Price = pricefield.getText();
        
        if("0".equals(Price)) {
        
            pricefield.setText("");
            
        }
    }//GEN-LAST:event_pricefieldMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearbutton;
    private javax.swing.JComboBox<String> ctypecombo;
    private javax.swing.JTable detailstable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labletel2;
    private javax.swing.JLabel labletel3;
    private javax.swing.JLabel labletel4;
    private javax.swing.JTextField noroomfield;
    private javax.swing.JComboBox<String> otypecombo;
    private javax.swing.JRadioButton packageradio;
    private javax.swing.JTextField pricefield;
    private javax.swing.JComboBox<String> ptypecombo;
    private javax.swing.JRadioButton roomradio;
    private javax.swing.JComboBox<String> rtypecombo;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
