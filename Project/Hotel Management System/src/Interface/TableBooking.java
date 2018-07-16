package Interface;

import MyCode.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.glass.events.KeyEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jdk.nashorn.internal.ir.BreakNode;

public class TableBooking extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String N = "N";
    String y = "Y";
    String id;
    String ll;
    String mm;
    String nn;
    String bb;
    String x1;
    String time;
    String iname1;
    String qty22;
    String tot13;
    String bdate4;
    String bnet5;
    String status6;
    
    public TableBooking() {

        initComponents();

        con = DBconnect.connect();
        
        tableloadV();
        
    }
    
    public void tableloadV() {
        try 
        {
            String sql = "Select billno,cusName,cuscontact,tbleno,tprice,date,stime from res_table";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            res_tabler_vtable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch (Exception e) 
        {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        res_tabler_vtable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        res_tabler_txt_vcname = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        res_tabler_chkbx_billid = new javax.swing.JCheckBox();
        res_tabler_txt_vbid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tbleview_txt_cname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tbleview_txt_ccontact = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tbleview_txt_tblID = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tbleview_txt_price = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tbleview_datec = new org.freixas.jcalendar.JCalendarCombo();
        tbl_rs_Printbtn = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        morning = new javax.swing.JRadioButton();
        lunch = new javax.swing.JRadioButton();
        evening = new javax.swing.JRadioButton();
        night = new javax.swing.JRadioButton();
        jButton19 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton42 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1366, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1358, 598));
        background.setLayout(null);

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 0));
        jLabel45.setText("Table Reservation");
        background.add(jLabel45);
        jLabel45.setBounds(550, 15, 277, 42);

        jPanel12.setBackground(new java.awt.Color(153, 0, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel12.setLayout(null);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setMinimumSize(new java.awt.Dimension(530, 353));
        jPanel11.setPreferredSize(new java.awt.Dimension(530, 470));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        res_tabler_vtable.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        res_tabler_vtable.setModel(new javax.swing.table.DefaultTableModel(
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
        res_tabler_vtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                res_tabler_vtableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(res_tabler_vtable);

        jPanel11.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 510, 290));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("Name:");
        jLabel11.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, -1, -1));

        res_tabler_txt_vcname.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        res_tabler_txt_vcname.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        res_tabler_txt_vcname.setEnabled(false);
        res_tabler_txt_vcname.setPreferredSize(new java.awt.Dimension(80, 30));
        res_tabler_txt_vcname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                res_tabler_txt_vcnameKeyTyped(evt);
            }
        });
        jPanel11.add(res_tabler_txt_vcname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 75, -1, -1));

        jButton21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton21.setText("Search");
        jButton21.setPreferredSize(new java.awt.Dimension(110, 40));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton1.setText("Reset");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, -1));

        res_tabler_chkbx_billid.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        res_tabler_chkbx_billid.setText("Select");
        res_tabler_chkbx_billid.setPreferredSize(new java.awt.Dimension(100, 30));
        res_tabler_chkbx_billid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res_tabler_chkbx_billidActionPerformed(evt);
            }
        });
        jPanel11.add(res_tabler_chkbx_billid, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 75, -1, -1));

        res_tabler_txt_vbid.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        res_tabler_txt_vbid.setPreferredSize(new java.awt.Dimension(80, 30));
        res_tabler_txt_vbid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                res_tabler_txt_vbidKeyTyped(evt);
            }
        });
        jPanel11.add(res_tabler_txt_vbid, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setText("SEARCH BILL DETAILS");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setText("BIll ID:");
        jLabel18.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jButton20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton20.setText("Delete Order");
        jButton20.setPreferredSize(new java.awt.Dimension(140, 40));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jPanel12.add(jPanel11);
        jPanel11.setBounds(584, 10, 530, 470);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(555, 290));
        jPanel5.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Customer Name :");
        jLabel7.setPreferredSize(new java.awt.Dimension(130, 30));
        jPanel5.add(jLabel7);
        jLabel7.setBounds(12, 10, 130, 30);

        tbleview_txt_cname.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tbleview_txt_cname.setPreferredSize(new java.awt.Dimension(180, 30));
        tbleview_txt_cname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbleview_txt_cnameKeyTyped(evt);
            }
        });
        jPanel5.add(tbleview_txt_cname);
        tbleview_txt_cname.setBounds(146, 10, 180, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setText("Customer Contact:");
        jLabel13.setPreferredSize(new java.awt.Dimension(130, 30));
        jPanel5.add(jLabel13);
        jLabel13.setBounds(12, 45, 130, 30);

        tbleview_txt_ccontact.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tbleview_txt_ccontact.setText(" ");
        tbleview_txt_ccontact.setPreferredSize(new java.awt.Dimension(180, 30));
        tbleview_txt_ccontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbleview_txt_ccontactActionPerformed(evt);
            }
        });
        tbleview_txt_ccontact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbleview_txt_ccontactKeyTyped(evt);
            }
        });
        jPanel5.add(tbleview_txt_ccontact);
        tbleview_txt_ccontact.setBounds(146, 45, 180, 30);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setText("Table ID:");
        jLabel19.setPreferredSize(new java.awt.Dimension(130, 30));
        jPanel5.add(jLabel19);
        jLabel19.setBounds(12, 80, 130, 30);

        tbleview_txt_tblID.setEditable(false);
        tbleview_txt_tblID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tbleview_txt_tblID.setText("Select Table");
        tbleview_txt_tblID.setPreferredSize(new java.awt.Dimension(180, 30));
        tbleview_txt_tblID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbleview_txt_tblIDActionPerformed(evt);
            }
        });
        jPanel5.add(tbleview_txt_tblID);
        tbleview_txt_tblID.setBounds(146, 80, 180, 30);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setText("Price:");
        jLabel20.setPreferredSize(new java.awt.Dimension(130, 30));
        jPanel5.add(jLabel20);
        jLabel20.setBounds(12, 115, 130, 30);

        tbleview_txt_price.setEditable(false);
        tbleview_txt_price.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tbleview_txt_price.setText("Select Table");
        tbleview_txt_price.setPreferredSize(new java.awt.Dimension(180, 30));
        jPanel5.add(tbleview_txt_price);
        tbleview_txt_price.setBounds(146, 115, 180, 30);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setText("Date");
        jLabel21.setPreferredSize(new java.awt.Dimension(130, 30));
        jPanel5.add(jLabel21);
        jLabel21.setBounds(12, 150, 130, 30);

        tbleview_datec.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel5.add(tbleview_datec);
        tbleview_datec.setBounds(146, 150, 200, 30);

        tbl_rs_Printbtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tbl_rs_Printbtn.setText("Add");
        tbl_rs_Printbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tbl_rs_Printbtn.setPreferredSize(new java.awt.Dimension(60, 40));
        tbl_rs_Printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbl_rs_PrintbtnActionPerformed(evt);
            }
        });
        jPanel5.add(tbl_rs_Printbtn);
        tbl_rs_Printbtn.setBounds(10, 240, 60, 40);

        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton11.setText("Reset");
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.setPreferredSize(new java.awt.Dimension(75, 40));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton11);
        jButton11.setBounds(75, 240, 75, 40);

        morning.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        morning.setText("0600-1000");
        morning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                morningActionPerformed(evt);
            }
        });
        jPanel5.add(morning);
        morning.setBounds(335, 23, 95, 27);

        lunch.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lunch.setText("1000-1400");
        jPanel5.add(lunch);
        lunch.setBounds(435, 23, 95, 27);

        evening.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        evening.setText("1400-1800");
        jPanel5.add(evening);
        evening.setBounds(335, 53, 95, 27);

        night.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        night.setText("1800-2200");
        jPanel5.add(night);
        night.setBounds(435, 53, 95, 27);

        jButton19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton19.setText("View Bill Folder");
        jButton19.setPreferredSize(new java.awt.Dimension(140, 40));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton19);
        jButton19.setBounds(325, 240, 140, 40);

        jButton22.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton22.setText("Update");
        jButton22.setPreferredSize(new java.awt.Dimension(80, 40));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton22);
        jButton22.setBounds(155, 240, 80, 40);

        jButton24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton24.setText("Print");
        jButton24.setPreferredSize(new java.awt.Dimension(80, 40));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton24);
        jButton24.setBounds(240, 240, 80, 40);

        jPanel12.add(jPanel5);
        jPanel5.setBounds(10, 190, 555, 290);

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(91, 170));
        jPanel4.setLayout(null);

        jButton42.setBackground(new java.awt.Color(255, 255, 102));
        jButton42.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton42.setText("Table 20");
        jButton42.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton42);
        jButton42.setBounds(0, 140, 91, 31);

        jButton41.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton41.setText("Table 16");
        jButton41.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton41);
        jButton41.setBounds(0, 105, 91, 31);

        jButton40.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton40.setText("Table 12");
        jButton40.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton40);
        jButton40.setBounds(0, 70, 91, 31);

        jButton39.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton39.setText("Table 8");
        jButton39.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton39);
        jButton39.setBounds(0, 35, 91, 31);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton2.setText("Table 4");
        jButton2.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(0, 0, 91, 31);

        jPanel12.add(jPanel4);
        jPanel4.setBounds(313, 10, 91, 170);

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(91, 170));
        jPanel3.setLayout(null);

        jButton26.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton26.setText("Table 3");
        jButton26.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton26);
        jButton26.setBounds(0, 0, 91, 31);

        jButton29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton29.setText("Table 7");
        jButton29.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton29);
        jButton29.setBounds(0, 35, 91, 31);

        jButton32.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton32.setText("Table 11");
        jButton32.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton32);
        jButton32.setBounds(0, 70, 91, 31);

        jButton35.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton35.setText("Table 15");
        jButton35.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton35);
        jButton35.setBounds(0, 105, 91, 31);

        jButton38.setBackground(new java.awt.Color(255, 255, 102));
        jButton38.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton38.setText("Table 19");
        jButton38.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton38);
        jButton38.setBounds(0, 140, 91, 31);

        jPanel12.add(jPanel3);
        jPanel3.setBounds(212, 10, 91, 170);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(91, 170));
        jPanel2.setLayout(null);

        jButton14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton14.setText("Table 2");
        jButton14.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(0, 0, 91, 31);

        jButton28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton28.setText("Table 6");
        jButton28.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton28);
        jButton28.setBounds(0, 35, 91, 31);

        jButton31.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton31.setText("Table 10");
        jButton31.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton31);
        jButton31.setBounds(0, 70, 91, 31);

        jButton34.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton34.setText("Table 14");
        jButton34.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton34);
        jButton34.setBounds(0, 105, 91, 31);

        jButton37.setBackground(new java.awt.Color(255, 255, 102));
        jButton37.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton37.setText("Table 18");
        jButton37.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton37);
        jButton37.setBounds(0, 140, 91, 31);

        jPanel12.add(jPanel2);
        jPanel2.setBounds(111, 10, 91, 170);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(91, 170));
        jPanel1.setLayout(null);

        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton10.setText("Table 1");
        jButton10.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(0, 0, 91, 31);

        jButton27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton27.setText("Table 5");
        jButton27.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton27);
        jButton27.setBounds(0, 35, 91, 31);

        jButton30.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton30.setText("Table 9");
        jButton30.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton30);
        jButton30.setBounds(0, 70, 91, 31);

        jButton33.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton33.setText("Table 13");
        jButton33.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton33);
        jButton33.setBounds(0, 105, 91, 31);

        jButton36.setBackground(new java.awt.Color(255, 255, 102));
        jButton36.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton36.setText("Table 17");
        jButton36.setPreferredSize(new java.awt.Dimension(91, 31));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton36);
        jButton36.setBounds(0, 140, 91, 31);

        jPanel12.add(jPanel1);
        jPanel1.setBounds(10, 10, 91, 170);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RestBack.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1120, 490));
        jPanel12.add(jLabel1);
        jLabel1.setBounds(0, 0, 1120, 490);

        background.add(jPanel12);
        jPanel12.setBounds(150, 75, 1120, 490);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Restuarant.jpg"))); // NOI18N
        background.add(jLabel10);
        jLabel10.setBounds(0, 0, 1366, 628);

        getContentPane().add(background);
        background.setBounds(0, 0, 1358, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        String tableid ="table1";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        
        String tableid ="table2";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        
        String tableid ="table3";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
       
        String tableid ="table5";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        
        String tableid ="table6";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        
        String tableid ="table7";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
      
        String tableid ="table9";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
      
        String tableid ="table10";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
       
        String tableid ="table11";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
      
        String tableid ="table13";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
    
        String tableid ="table14";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
      
        String tableid ="table15";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        String tableid ="table4";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
     
        String tableid ="table8";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
       
        String tableid ="table12";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        
        String tableid ="table16";
        String price="500";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton41ActionPerformed

    private void res_tabler_vtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_res_tabler_vtableMouseClicked
        
        //String bid= res_tabler_txt_vbid.getText();
        int r = res_tabler_vtable.getSelectedRow();
        String billid = res_tabler_vtable.getValueAt(r, 0).toString();
        String cusName = res_tabler_vtable.getValueAt(r, 1).toString();
        String cuscon = res_tabler_vtable.getValueAt(r, 2).toString();
        String tbleno = res_tabler_vtable.getValueAt(r, 3).toString();
        String tprice = res_tabler_vtable.getValueAt(r, 4).toString();
        String date = res_tabler_vtable.getValueAt(r, 5).toString();
        String stime = res_tabler_vtable.getValueAt(r, 6).toString();
        //String etime = res_tabler_vtable.getValueAt(r, 7).toString();

        res_tabler_txt_vbid.setText(billid);
        res_tabler_txt_vcname.setText(cusName);
        tbleview_txt_cname.setText(cusName);
        tbleview_txt_ccontact.setText(cuscon);
        tbleview_txt_tblID.setText(tbleno);
        tbleview_txt_price.setText(tprice);
        //tbleview_datec.setDateFormat(date);
        
    }//GEN-LAST:event_res_tabler_vtableMouseClicked

    private void res_tabler_txt_vcnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_res_tabler_txt_vcnameKeyTyped
        
        char c =evt.getKeyChar();
        
        if((Character.isDigit(c)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            res_tabler_txt_vcname.setBackground(Color.YELLOW);
            evt.consume();
        }
        
        else
        {
            res_tabler_txt_vcname.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_res_tabler_txt_vcnameKeyTyped

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        
        String bid= res_tabler_txt_vbid.getText();
        String bname=res_tabler_txt_vcname.getText();
        //SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        // String vdate = dformat.format(res_tabler_vdatec.getDate());

        if(res_tabler_chkbx_billid.isSelected())
        {
            String sql = "Select cusName,cuscontact,tbleno,tprice,date,stime from res_table where cusName like '%"+bname+"%'";
            System.out.println(sql);
            
            try 
            {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                res_tabler_vtable.setModel(DbUtils.resultSetToTableModel(rs));
                res_tabler_txt_vcname.setText("");
            }
            
            catch (Exception e) 
            {
            }
        }

        else
        {
            String sql = "Select cusName,cuscontact,tbleno,tprice,date,stime from res_table where billno = '"+bid+"'";
            System.out.println(sql);
            
            try 
            {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                res_tabler_vtable.setModel(DbUtils.resultSetToTableModel(rs));
            } 
            
            catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        tableloadV();
        res_tabler_txt_vbid.setText("");
        tbleview_txt_cname.setText("");
        tbleview_txt_ccontact.setText("");
        tbleview_txt_tblID.setText("Select Table");
        tbleview_txt_price.setText("Select Table");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void res_tabler_chkbx_billidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res_tabler_chkbx_billidActionPerformed
        
        if(res_tabler_chkbx_billid.isSelected())
        {   
            res_tabler_txt_vbid.setEnabled(false);
            res_tabler_txt_vcname.setEnabled(true);
        }
        
        else
        {
            res_tabler_txt_vbid.setEnabled(true);
            res_tabler_txt_vcname.setEnabled(false);
        }
    }//GEN-LAST:event_res_tabler_chkbx_billidActionPerformed

    private void res_tabler_txt_vbidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_res_tabler_txt_vbidKeyTyped
       
        char c =evt.getKeyChar();
        
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)))
        {
            res_tabler_txt_vbid.setBackground(Color.yellow);
            getToolkit().beep();
            evt.consume();
        }
        
        else
        {
            res_tabler_txt_vbid.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_res_tabler_txt_vbidKeyTyped

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        
        String bid= res_tabler_txt_vbid.getText();
        
        try
        {
            String sql = "delete from res_table where billno='"+bid+"'";
            pst = con.prepareStatement(sql);
            pst.execute();
        }
        
        catch(Exception e)
        {
        }
        
        tableloadV();
        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void tbleview_txt_cnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbleview_txt_cnameKeyTyped
        
        char c =evt.getKeyChar();
        
        if((Character.isDigit(c)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            tbleview_txt_cname.setBackground(Color.yellow);
            evt.consume();
        }
        
        else
        {
            tbleview_txt_cname.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_tbleview_txt_cnameKeyTyped

    private void tbleview_txt_ccontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbleview_txt_ccontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbleview_txt_ccontactActionPerformed

    private void tbleview_txt_ccontactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbleview_txt_ccontactKeyTyped
        
        if (tbleview_txt_ccontact.getText().length()>=11) 
        {
            JOptionPane.showMessageDialog(null, "Only 10 numbers");
            getToolkit().beep();
            evt.consume();
        }
        
        char c =evt.getKeyChar();
        
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            tbleview_txt_ccontact.setBackground(Color.yellow);
            evt.consume();
        }
        
        else
        {
            tbleview_txt_ccontact.setBackground(Color.WHITE);
        }

        // getToolkit().beep();
        // evt.consume();
    }//GEN-LAST:event_tbleview_txt_ccontactKeyTyped

    private void tbleview_txt_tblIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbleview_txt_tblIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbleview_txt_tblIDActionPerformed

    private void tbl_rs_PrintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbl_rs_PrintbtnActionPerformed

        String ASD[][];
        int c = 0;
        boolean s = false;

        String cname=tbleview_txt_cname.getText();
        String ccontact=tbleview_txt_ccontact.getText();
        String tbleID=tbleview_txt_tblID.getText();
        String price=tbleview_txt_price.getText();

        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        String vdate = dformat.format(tbleview_datec.getDate());

        try 
        {
            String a = "SELECT COUNT(*) FROM res_table ";
            pst = con.prepareStatement(a);
            rs = pst.executeQuery();

            while(rs.next()) 
            {
                c = Integer.valueOf(rs.getString(1));
            }
        }

        catch(Exception e) 
        {
        }

        ASD = new String[c][4];

        try 
        {
            int i = 0;

            String a = "SELECT tbleno, date, stime, status FROM res_table ";
            pst = con.prepareStatement(a);
            rs = pst.executeQuery();

            while(rs.next())
            {
                ll = rs.getString(1);
                mm = rs.getString(2);
                nn = rs.getString(3);
                bb = rs.getString(4);

                ASD[i][0] = ll;
                ASD[i][1] = mm;
                ASD[i][2] = nn;
                ASD[i][3] = bb;

                i++;

            }
        }

        catch (Exception e) 
        {
        }

        try 
        {
            x1 = y;

            if(morning.isSelected())
            {
                time = "Morning";
            }

            else if(lunch.isSelected())
            {
                time = "Lunch";
            }

            else if(evening.isSelected())
            {
                time = "Evening";
            }

            else if(night.isSelected())
            {
                time = "Night";
            }

            for(int i=0; i<ASD.length; i++) 
            {
                String a1 = ASD[i][0];
                String a2 = ASD[i][1];
                String a3 = ASD[i][2];
                String a4 = ASD[i][3];
                //                System.out.println("e "+a1);
                if(a1.equals(tbleID)) 
                {
                    System.out.println("e "+a1);
                    if(a2.equals(vdate)) 
                    {
                        System.out.println("a "+a2);
                        if (a3.equals(time)) 
                        {
                            System.out.println("e "+a3);
                            if(a4.equals(x1)) 
                            {
                                System.out.println("e "+a4);
                                s = true;
                            }
                        }
                    }
                }
            }
            System.out.println(s);
            if(s == false) 
            {
                String q = "INSERT INTO res_table (cusName,cuscontact,tbleno,tprice,date,stime,status) values ('"+cname+"','"+ccontact+"','"+tbleID+"','"+price+"','"+vdate+"','"+time+"','"+x1+"')";
                //System.out.println(q);
                pst = con.prepareStatement(q);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successful");
            }

            else if(s == true) 
            {
                JOptionPane.showMessageDialog(null, "Already Reserved");
            }

            tableloadV();
        }

        catch(Exception e) 
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_tbl_rs_PrintbtnActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       
        tbleview_txt_cname.setText("");
        tbleview_txt_ccontact.setText("");
        tbleview_txt_tblID.setText("Select Table");
        tbleview_txt_price.setText("Select Table");
        tableloadV();
     
    }//GEN-LAST:event_jButton11ActionPerformed

    private void morningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_morningActionPerformed
       
    }//GEN-LAST:event_morningActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        
        if(Desktop.isDesktopSupported())
        {
            // System.out.println("jj");
            try
            {
                File myFile = new File("C:\\Hotel PDF\\Table PaySheet");
                Desktop.getDesktop().open(myFile);
            }
            
            catch(Exception e)
            {
            }
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        
        String cname=tbleview_txt_cname.getText();
        String bid= res_tabler_txt_vbid.getText();
        String ccontact=tbleview_txt_ccontact.getText();
        String tbleID=tbleview_txt_tblID.getText();
        String price=tbleview_txt_price.getText();

        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        String vdate = dformat.format(tbleview_datec.getDate());

        if(morning.isSelected())
        {
            try 
            {
                x1=y;
                time = "Morning";
                
                try
                {
                    String sql1="update res_table set cusName='"+cname+"',cuscontact='"+ccontact+"',tbleno='"+tbleID+"',tprice='"+price+"',date='"+vdate+"',stime='"+time+"',status='"+x1+"' where billno='"+bid+"'";
                    // System.out.print(sql1);
                    pst = con.prepareStatement(sql1);
                    pst.execute();
                }
                
                catch(Exception e)
                {
                }
            }
            
            catch(Exception e)
            {
            }
        }

        else if(lunch.isSelected())
        {
            try 
            {
                x1=y;
                time = "Lunch";
            
                try
                {
                    String sql1="update res_table set cusName='"+cname+"',cuscontact='"+ccontact+"',tbleno='"+tbleID+"',tprice='"+price+"',date='"+vdate+"',stime='"+time+"',status='"+x1+"' where billno='"+bid+"'";
                    // System.out.print(sql1);
                    pst = con.prepareStatement(sql1);
                    pst.execute();
                }
                
                catch(Exception e)
                {
                }
            }
            
            catch(Exception e)
            {
            }
        }

        else if(evening.isSelected())
        {
            try 
            {
                x1=y;
                time = "Evening";
            
                try
                {
                    String sql1="update res_table set cusName='"+cname+"',cuscontact='"+ccontact+"',tbleno='"+tbleID+"',tprice='"+price+"',date='"+vdate+"',stime='"+time+"',status='"+x1+"' where billno='"+bid+"'";
                    // System.out.print(sql1);
                    pst = con.prepareStatement(sql1);
                    pst.execute();
                }
                
                catch(Exception e)
                {
                }
            }
            
            catch(Exception e)
            {
            }
        }

        else if(night.isSelected())
        {
            try 
            {
                x1=y;
                time = "Night";
            
                try
                {
                    String sql1="update res_table set cusName='"+cname+"',cuscontact='"+ccontact+"',tbleno='"+tbleID+"',tprice='"+price+"',date='"+vdate+"',stime='"+time+"',status='"+x1+"' where billno='"+bid+"'";
                    // System.out.print(sql1);
                    pst = con.prepareStatement(sql1);
                    pst.execute();
                }
                
                catch(Exception e)
                {
                }
            }
            
            catch(Exception e)
            {
            }
        }

        tableloadV();

    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed

        String bill = res_tabler_txt_vbid.getText();
        String date= java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        try
        {
            FileOutputStream out = new FileOutputStream(new File("C:\\Hotel PDF\\Table PaySheet\\bill"+bill+".pdf"));
            Document doc = new Document();
            PdfWriter wr = PdfWriter.getInstance(doc, out);
            PdfPTable tab = new PdfPTable(5);
            PdfPCell cel;
            doc.open ();

            BaseFont b = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font f = new Font(b,20);

            BaseFont b1 = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font f1 = new Font(b1,13);

            String sql = "Select cusName, cuscontact, tbleno, tprice, date, stime FROM res_table where billno='"+bill+"' ";
            System.out.println(sql);
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        
            while(rs.next())
            {
                iname1 = rs.getString(1);
                qty22 = rs.getString(2);
                tot13 = rs.getString(3);
                bdate4 = rs.getString(4);
                bnet5 = rs.getString(5);
                status6 = rs.getString(6);

                doc.add(new Paragraph("             MANORA RESIDENCE",f));
                doc.add(new Paragraph("Manora Residence Hotel , \n" +
                    "Weniwelawatta Road,\n" +
                    "Wariyagoda, \n" +
                    "Alawwa, \n" +
                    "Sri Lanka.\n"+"+94 37 2277101\n",f1));
                doc.add(new Paragraph("Date & Time            :  "+date,f1));
                doc.add(new Paragraph("Receipt No:"+bill,f1));
                doc.add(new Paragraph("\n",f));
                doc.add(new Paragraph("Customer Name    :"+iname1,f1));
                doc.add(new Paragraph("Customer Contact :"+qty22,f1));
                doc.add(new Paragraph("Table No         :"+tot13,f1));
                doc.add(new Paragraph("Total Price      :"+bdate4,f1));
                doc.add(new Paragraph("Reserved Date    :"+bnet5,f1));
                doc.add(new Paragraph("Time Slot        :"+status6,f1));
                doc.add(new Paragraph("\n"));
                doc.add(new Paragraph("     Thank You!!!      :",f1));

                doc.close();
            }
        }
        
        catch(Exception e)
        {
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        
        String tableid ="table17";
        String price="1000";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        
        String tableid ="table18";
        String price="1000";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
       
        String tableid ="table19";
        String price="1000";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        
        String tableid ="table20";
        String price="1000";
        tbleview_txt_tblID.setText(tableid);
        tbleview_txt_price.setText(price);
        
    }//GEN-LAST:event_jButton42ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JRadioButton evening;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JRadioButton lunch;
    private javax.swing.JRadioButton morning;
    private javax.swing.JRadioButton night;
    private javax.swing.JCheckBox res_tabler_chkbx_billid;
    private javax.swing.JTextField res_tabler_txt_vbid;
    private javax.swing.JTextField res_tabler_txt_vcname;
    private javax.swing.JTable res_tabler_vtable;
    private javax.swing.JButton tbl_rs_Printbtn;
    private org.freixas.jcalendar.JCalendarCombo tbleview_datec;
    private javax.swing.JTextField tbleview_txt_ccontact;
    private javax.swing.JTextField tbleview_txt_cname;
    private javax.swing.JTextField tbleview_txt_price;
    private javax.swing.JTextField tbleview_txt_tblID;
    // End of variables declaration//GEN-END:variables
}
