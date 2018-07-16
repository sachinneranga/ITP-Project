package Interface;

import MyCode.DBconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import com.sun.glass.events.KeyEvent;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Paragraph;

public class Payment extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String item_price;
    String tot_amount;
    String bill_total;
    String bill_method;
    String bill_date;
    String bill_item[][];
    int count = 0;
    String full_tot;
    String bill_d;
    String item_qty = "0";
    
    String amount;
    String txt;
    String c;
    String e;
    String iname;
    String qty2;
    String tot1;
    String bdate;
    String bnet;
    String status;
        
    public Payment() {

        initComponents();

        con = DBconnect.connect();

        viewbill();
        maxget();
        combo();
        qmeal();
        
    }
    
    public void viewbill() {
        String b_id = bill_ID.getText();
        
        try 
        { 
            String sql = "Select ItemName,qty,total from res_bill_detail where billno= '"+b_id+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            bill_Details_Table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch (Exception e) 
        {
        }
    }//no 2 table (bill details table) loader
    
    public void netrecall(){
        String bi_id = bill_ID.getText();
           
        try 
        {
            String SQL ="SELECT billnet from res_bill_sum where billno='"+bi_id+"'";
            pst = con.prepareStatement(SQL);
            rs = pst.executeQuery();
            
            while(rs.next()) 
            {
                tot_amount = rs.getString("billnet");
            }
        }
        
        catch (Exception e)
        {
        }
        net_total.setText(tot_amount);
    }//get total amount in one bill
    
    public void qmeal() {
        try 
        {
            String SqL = "SELECT qitemNo, qmealName, qprice FROM res_quick_meal";
            pst = con.prepareStatement(SqL);
            rs = pst.executeQuery();
            
            item_Details_Table.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        
        catch (Exception e) 
        {
        }
    }//no 1 table loder
    
    public void combo() {
        try 
        {
            String sql ="SELECT * from res_quick_meal ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
             
            while(rs.next())
            {
                String mn=rs.getString("qmealName");
                item_Name.addItem(mn);
            }
        }
        
        catch (Exception e) 
        {
        }
    }//item combo loader
    
    public void maxget() {
        String maxid = "SELECT MAX(billno) FROM res_bill_sum";
        
        try 
        {
            pst = con.prepareStatement(maxid);
            rs = pst.executeQuery();
            while(rs.next()) 
            {
                txt = rs.getString(1);
            }
            bill_ID.setText(txt);
        } 
        
        catch (Exception e) 
        {
        }
                    
        if(txt==null)
        {
            bill_ID.setText("1");
            String zero="0";
            String sql2 = "Insert into res_bill_sum (billnet) values('"+zero+"')";
            
            try 
            {
                pst = con.prepareStatement(sql2);
                pst.execute();
            }
            
            catch (Exception e)
            {
            }
        }
    }//bill id field loader
    
    public void viewtable() {
        try 
        { 
            view_bill_table.setModel(null);
        }
            
        catch(Exception e)
        {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bill_Details_Table = new javax.swing.JTable();
        print = new javax.swing.JButton();
        bill_ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        net_total = new javax.swing.JTextField();
        order_Method = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        item_Name = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        item_Details_Table = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        search_bil_nol = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        view_bill_table = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        net_tot = new javax.swing.JLabel();
        bill_Date = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        view_location = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 0));
        jLabel25.setText("Billing For Restaurant");
        jLabel25.setPreferredSize(new java.awt.Dimension(340, 42));
        background.add(jLabel25);
        jLabel25.setBounds(500, 15, 360, 42);

        jPanel1.setPreferredSize(new java.awt.Dimension(1120, 490));
        jPanel1.setLayout(null);

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setPreferredSize(new java.awt.Dimension(660, 470));
        jPanel16.setLayout(null);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(400, 180));

        bill_Details_Table.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        bill_Details_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bill_Details_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bill_Details_TableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(bill_Details_Table);

        jPanel16.add(jScrollPane4);
        jScrollPane4.setBounds(10, 230, 400, 180);

        print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        print.setText("Print");
        print.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        print.setPreferredSize(new java.awt.Dimension(65, 40));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel16.add(print);
        print.setBounds(300, 420, 65, 40);

        bill_ID.setEditable(false);
        bill_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        bill_ID.setPreferredSize(new java.awt.Dimension(100, 30));
        bill_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_IDActionPerformed(evt);
            }
        });
        jPanel16.add(bill_ID);
        bill_ID.setBounds(165, 10, 100, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText("Bill ID:");
        jLabel1.setPreferredSize(new java.awt.Dimension(65, 30));
        jPanel16.add(jLabel1);
        jLabel1.setBounds(100, 10, 65, 30);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setText("Total:");
        jLabel28.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel16.add(jLabel28);
        jLabel28.setBounds(10, 420, 60, 30);

        net_total.setEditable(false);
        net_total.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        net_total.setText(" ");
        net_total.setPreferredSize(new java.awt.Dimension(100, 30));
        net_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                net_totalActionPerformed(evt);
            }
        });
        jPanel16.add(net_total);
        net_total.setBounds(70, 420, 100, 30);

        order_Method.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        order_Method.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Take Away", "RT1", "RT2", "RT3", "RT4", "RT5", "RT6", "RT7", "RT8" }));
        order_Method.setPreferredSize(new java.awt.Dimension(130, 30));
        jPanel16.add(order_Method);
        order_Method.setBounds(300, 10, 130, 30);

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setPreferredSize(new java.awt.Dimension(230, 160));
        jPanel10.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Store Items:");
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel10.add(jLabel2);
        jLabel2.setBounds(10, 10, 90, 30);

        item_Name.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        item_Name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item" }));
        item_Name.setPreferredSize(new java.awt.Dimension(120, 30));
        item_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_NameActionPerformed(evt);
            }
        });
        jPanel10.add(item_Name);
        item_Name.setBounds(100, 10, 120, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Quantity     :");
        jLabel3.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel10.add(jLabel3);
        jLabel3.setBounds(10, 45, 90, 30);

        qty.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        qty.setPreferredSize(new java.awt.Dimension(120, 30));
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });
        jPanel10.add(qty);
        qty.setBounds(100, 45, 120, 30);

        add.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        add.setText("ADD");
        add.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add.setPreferredSize(new java.awt.Dimension(70, 40));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel10.add(add);
        add.setBounds(10, 115, 70, 40);

        delete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        delete.setText("Delete");
        delete.setPreferredSize(new java.awt.Dimension(80, 40));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel10.add(delete);
        delete.setBounds(100, 115, 80, 40);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel29.setText("total            :");
        jLabel29.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel10.add(jLabel29);
        jLabel29.setBounds(10, 80, 90, 30);

        total.setEditable(false);
        total.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        total.setText(" ");
        total.setPreferredSize(new java.awt.Dimension(120, 30));
        jPanel10.add(total);
        total.setBounds(100, 80, 120, 30);

        jPanel16.add(jPanel10);
        jPanel10.setBounds(10, 55, 230, 160);

        jScrollPane10.setPreferredSize(new java.awt.Dimension(375, 160));

        item_Details_Table.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        item_Details_Table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(item_Details_Table);

        jPanel16.add(jScrollPane10);
        jScrollPane10.setBounds(250, 55, 375, 160);

        jPanel1.add(jPanel16);
        jPanel16.setBounds(10, 10, 640, 470);

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setLayout(null);

        search_bil_nol.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        search_bil_nol.setPreferredSize(new java.awt.Dimension(55, 30));
        search_bil_nol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_bil_nolActionPerformed(evt);
            }
        });
        search_bil_nol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_bil_nolKeyTyped(evt);
            }
        });
        jPanel15.add(search_bil_nol);
        search_bil_nol.setBounds(155, 10, 55, 30);

        search.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        search.setText("Search");
        search.setPreferredSize(new java.awt.Dimension(80, 40));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel15.add(search);
        search.setBounds(230, 10, 80, 40);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(430, 220));

        view_bill_table.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        view_bill_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ItemNamea", "qty", "total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(view_bill_table);

        jPanel15.add(jScrollPane1);
        jScrollPane1.setBounds(10, 58, 430, 220);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setText("Search By Bill No:");
        jLabel14.setPreferredSize(new java.awt.Dimension(140, 30));
        jPanel15.add(jLabel14);
        jLabel14.setBounds(10, 10, 140, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Net Total (Rs.):");
        jLabel4.setPreferredSize(new java.awt.Dimension(140, 30));
        jPanel15.add(jLabel4);
        jLabel4.setBounds(10, 290, 140, 30);

        date.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        date.setText("Date                 :");
        date.setPreferredSize(new java.awt.Dimension(140, 30));
        jPanel15.add(date);
        date.setBounds(10, 330, 140, 30);

        net_tot.setText(" ");
        net_tot.setPreferredSize(new java.awt.Dimension(250, 30));
        jPanel15.add(net_tot);
        net_tot.setBounds(150, 290, 250, 30);

        bill_Date.setText(" ");
        bill_Date.setPreferredSize(new java.awt.Dimension(250, 30));
        jPanel15.add(bill_Date);
        bill_Date.setBounds(150, 330, 250, 30);

        reset.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        reset.setText("Reset");
        reset.setPreferredSize(new java.awt.Dimension(130, 40));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel15.add(reset);
        reset.setBounds(179, 420, 130, 40);

        view_location.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        view_location.setText("View Location");
        view_location.setPreferredSize(new java.awt.Dimension(130, 40));
        view_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_locationActionPerformed(evt);
            }
        });
        jPanel15.add(view_location);
        view_location.setBounds(179, 375, 130, 40);

        jPanel1.add(jPanel15);
        jPanel15.setBounds(660, 9, 450, 470);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RestBack.jpg"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 1120, 490);

        background.add(jPanel1);
        jPanel1.setBounds(130, 75, 1120, 490);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Restuarant.jpg"))); // NOI18N
        background.add(jLabel10);
        jLabel10.setBounds(0, 0, 1366, 628);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_bil_nolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bil_nolKeyTyped
        
        char c =evt.getKeyChar();
        
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)))
        {
            search_bil_nol.setBackground(Color.yellow);
            getToolkit().beep();
            evt.consume();
        }

        else
        {
            search_bil_nol.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_search_bil_nolKeyTyped

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        
        String bill_no = search_bil_nol.getText();
                
        try 
        {
            String sql1 = "Select ItemName,qty,total from res_bill_detail where billno='"+bill_no+"'";
            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
            
            view_bill_table.setModel(DbUtils.resultSetToTableModel(rs));
System.out.println(bill_no);
            if(true) 
            {
                String sq12= "SELECT billdate, billnet FROM res_bill_sum WHERE billno = '"+bill_no+"'";
                pst = con.prepareStatement(sq12);
                rs = pst.executeQuery();
System.out.println(rs);
                while(rs.next()) 
                {
                    full_tot = rs.getString("billnet");
                    bill_date = rs.getString("billdate");
                    System.out.println(full_tot);
                }

                net_tot.setText(full_tot);
                bill_Date.setText(bill_date);
            }
        } 
        
        catch (Exception e) 
        {
        }
    }//GEN-LAST:event_searchActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        
        net_tot.setText("");
        bill_Date.setText("");
        search_bil_nol.setText("");
        
        viewtable();
        
    }//GEN-LAST:event_resetActionPerformed

    private void view_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_locationActionPerformed

        if(Desktop.isDesktopSupported())
        {
            try
            {
                File myFile = new File("C:\\Hotel PDF\\PaySheet");
                Desktop.getDesktop().open(myFile);
            }
            
            catch(Exception e)
            {
            }
        }
    }//GEN-LAST:event_view_locationActionPerformed

    private void bill_Details_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_Details_TableMouseClicked
        
        int r=bill_Details_Table.getSelectedRow();
        String itemname = bill_Details_Table.getValueAt(r, 0).toString();
        String quantity = bill_Details_Table.getValueAt(r, 1).toString();
        String totprice = bill_Details_Table.getValueAt(r, 2).toString();
        String id = bill_ID.getText();

        item_Name.setSelectedItem(itemname);
        qty.setText(quantity);
        total.setText(totprice);

    }//GEN-LAST:event_bill_Details_TableMouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
    
        String bill_id = bill_ID.getText();
        String method = order_Method.getSelectedItem().toString();
        
        int x = JOptionPane.showConfirmDialog(null, "Confirm Before Print");
        
        if(x==0)
        {
            try 
            {
                String sql = "update res_bill_sum set billdate=sysdate(),tblORtkaway='"+method+"' where billno='"+bill_id+"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                
                String zero="0";
                
                String sql1 = "Insert into res_bill_sum (billnet) values('"+zero+"')";
                pst = con.prepareStatement(sql1);
                pst.execute();
         
            }
            
            catch(Exception e)
            {
            } 
                
            try
            {
                FileOutputStream out = new FileOutputStream(new File("C:\\Hotel PDF\\PaySheet\\bill"+bill_id+".pdf"));
                Document doc = new Document();
                PdfWriter wr = PdfWriter.getInstance(doc, out);
                doc.open ();

                BaseFont b = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                Font f = new Font(b,20);

                BaseFont b1 = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
                Font f1 = new Font(b1,13);

                String SQL = "Select COUNT(*) FROM res_bill_detail where billno ='"+bill_id+"'";
                pst = con.prepareStatement(SQL);
                rs = pst.executeQuery();

                while(rs.next()) 
                {
                    count = Integer.valueOf(rs.getString(1));
                }

                bill_item = new String[count][3];

                String sql3 = "SELECT billnet, tblORtkaway, billdate FROM res_bill_sum WHERE billno = '"+ bill_id+"'";
                pst = con.prepareStatement(sql3);
                rs = pst.executeQuery();

                while(rs.next()) 
                {
                    bill_total = rs.getString("billnet") + ".0";
                    bill_method = rs.getString("tblORtkaway");
                    bill_date = rs.getString("billdate");

                    String sql4 = "Select ItemName, qty, total FROM res_bill_detail where billno ='"+bill_id+"'";
                    pst = con.prepareStatement(sql4);
                    rs = pst.executeQuery();

                    int i = 0;

                    while(rs.next())
                    {
                        bill_item[i][0] = rs.getString("ItemName");
                        bill_item[i][1] = rs.getString("qty");
                        bill_item[i][2] = rs.getString("total");

                        i++;
                    }
                }

                doc.add(new Paragraph("               Muthuweli Beach Resort\n",f));
                doc.add(new Paragraph("\n",f1));
                doc.add(new Paragraph("Muthuweli Beach Resort, \n" + "Moratuwa, \n" + "Sri Lanka.\n" + "+011 2255355\n",f1));
                doc.add(new Paragraph("Date: "+ bill_date,f1));
                doc.add(new Paragraph("\n",f1));
                doc.add(new Paragraph("Receipt No: "+ bill_id,f1));
                doc.add(new Paragraph("Method: "+ bill_method,f1));
                doc.add(new Paragraph("\n",f1));
                for(int k=0; k<bill_item.length; k++)
                {
                    int d = k + 1;
                    doc.add(new Paragraph(d + " " + bill_item[k][0] + "\t" + bill_item[k][1] + "\t" + bill_item[k][2],f1));
                }
                doc.add(new Paragraph("\n",f1));
                doc.add(new Paragraph("Bill Net Amount: "+ bill_total,f1));
                doc.add(new Paragraph());

                doc.close();

            }

            catch (Exception e)
            {
            }

            try 
            {
                for(int u=0; u<bill_item.length; u++)
                {
                    String i = bill_item[u][0];
                    String q = bill_item[u][1];

                    String sql10 = "UPDATE res_meal SET quantity = quantity - '"+ q +"' WHERE mealName = '"+ i +"'";
                    pst = con.prepareStatement(sql10);
                    pst.execute();
                }
            } 

            catch (Exception e) 
            {
            }
            
            try
            {
                String SqL = "SELECT qitemNo, qmealName, qprice FROM res_quick_meal";
                pst = con.prepareStatement(SqL);
                rs = pst.executeQuery();

                item_Details_Table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            
            catch (Exception e) 
            {
            }
 
            maxget();
            viewbill();
        }
        

        net_total.setText("");
        total.setText("");
        qty.setText("");
        item_Name.setSelectedItem("Select Item");
        
    }//GEN-LAST:event_printActionPerformed

    private void bill_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_IDActionPerformed

    }//GEN-LAST:event_bill_IDActionPerformed

    private void net_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_net_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_net_totalActionPerformed

    private void item_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_NameActionPerformed
        
        try 
        {
            String bitmname = item_Name.getSelectedItem().toString();
            String sql = "Select qitemNo,qmealName,qprice from res_quick_meal where qmealName='"+bitmname+"'";
            System.out.println(sql);
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_Details_Table.setModel(DbUtils.resultSetToTableModel(rs));
            // res_stock_txt_mealnm.setText("");//cleartextbox
        } 
        
        catch (Exception e) 
        {
        }
        
        qty.setText("");
        total.setText("");

    }//GEN-LAST:event_item_NameActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed

    }//GEN-LAST:event_qtyActionPerformed

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        
        char c =evt.getKeyChar();
        
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            qty.setBackground(Color.yellow);
            evt.consume();
        }
        
        else
        {
            qty.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_qtyKeyTyped

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        String quantity = qty.getText();//bqunty
        String item_name = item_Name.getSelectedItem().toString();//bitmname
        String bill_id = bill_ID.getText();//id

        try
        {
            String SqL2 ="SELECT quantity from res_meal where mealName='"+item_name+"'";
            pst = con.prepareStatement(SqL2);
            rs = pst.executeQuery();
    
            while(rs.next()) 
            {
                    item_qty = rs.getString("quantity");
            }
            
            int q = Integer.valueOf(item_qty);
            int q2 = Integer.valueOf(quantity);
            
            if(q >= q2) 
            {
                String sql1 ="SELECT qprice from res_quick_meal where qmealName='"+item_name+"'";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();

                while(rs.next()) 
                {
                     item_price = rs.getString(1);
                }

                int y = Integer.parseInt(quantity);
                double x = Double.parseDouble(item_price);
                double tot = x*y;//total
                total.setText(String.valueOf(tot));

                String sql2 = "Insert into res_bill_detail (billno,ItemName,qty,total) values('"+bill_id+"','"+item_name+"','"+quantity+"','"+tot+"')";
                pst = con.prepareStatement(sql2);
                pst.execute();

                if(true) 
                {
                    String sql4 ="update res_bill_sum set billnet= billnet + '"+tot+"' where billno='"+bill_id+"'";
                    pst = con.prepareStatement(sql4);
                    pst.execute();

                    netrecall();
                }
            }
            
            else if(q < q2)
            {
                JOptionPane.showMessageDialog(null,"Quantity is not enough!!!");
            }
        }
        
        catch (Exception e)
        {
        }

        viewbill();

    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        int x =JOptionPane.showConfirmDialog(null,"Do you need cancel this?");
        
        if(x==0)
        {
            String bill_id = bill_ID.getText();
            String item_name = item_Name.getSelectedItem().toString();
            String tot = total.getText();

            try
            {
                String sql1 = "DELETE from res_bill_detail where ItemName='"+item_name+"' and billno='"+bill_id+"'";
                pst = con.prepareStatement(sql1);
                pst.execute();
                
                String sql2 ="update res_bill_sum set billnet= billnet - '"+tot+"' where billno='"+bill_id+"'";
                pst = con.prepareStatement(sql2);
                pst.execute();
            }
            
            catch (Exception e) 
            {
            }
            
            viewbill();
            netrecall();
            item_Name.setSelectedItem("Select Item");
            qty.setText("");
            total.setText("");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void search_bil_nolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_bil_nolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_bil_nolActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bill_Date;
    private javax.swing.JTable bill_Details_Table;
    private javax.swing.JTextField bill_ID;
    private javax.swing.JLabel date;
    private javax.swing.JButton delete;
    private javax.swing.JTable item_Details_Table;
    private javax.swing.JComboBox<String> item_Name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel net_tot;
    private javax.swing.JTextField net_total;
    private javax.swing.JComboBox<String> order_Method;
    private javax.swing.JButton print;
    private javax.swing.JTextField qty;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    private javax.swing.JTextField search_bil_nol;
    private javax.swing.JTextField total;
    private javax.swing.JTable view_bill_table;
    private javax.swing.JButton view_location;
    // End of variables declaration//GEN-END:variables
}
