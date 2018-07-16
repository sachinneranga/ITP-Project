package Interface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MyCode.DBconnect;
import MyCode.model;
import MyCode.products;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
//import static stockentry.jTextField4;
//import static stockentry.jTextField5;
//import static stockentry.jTextField6;


/**
 *
 * @author qaisf
 */
public class bill extends javax.swing.JFrame {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;

    /**
     * Creates new form bill
     */
    private String roll2,ivid,date,pid,pnme,proid,proname,amount,paymeth;
    private int totamt,sprice,dis,cpay,cdpay,ostk;
    
    public bill() {
        initComponents();
        con = DBconnect.connect();
        //con=dbcon.java_db();
        showdate();
        getid();
        getpay();
      //  showbal();

       // getpay();
        jTextField10.grabFocus();
        
        
    }
    public void showdate(){
       Date dte=new Date();
       jDateChooser1.setDate(dte);
    }
    
      public void getid(){
        try {
            String sql="SELECT invoiceID FROM invoice ORDER BY invoiceID DESC LIMIT 1";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String rl=rs.getString("invoiceID");
                int ln=rl.length();
                String stxt=rl.substring(0,2);
                String snum=rl.substring(2,ln);
                int n=Integer.parseInt(snum);
                
                n++;
                snum=Integer.toString(n);
                String roll=stxt+snum;
                
                jLabel8.setText(roll);
                
                
            }
            else{
                jLabel8.setText("IN1001");
            }
        jLabel5.setOpaque(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }
      
      
       public int getsum(){
         int r=jTable1.getRowCount();
         int sum=0;
         for(int i=0;i<r;i++){
             sum=sum+Integer.parseInt(jTable1.getValueAt(i, 4).toString());
          //   jLabel12.setText(sum+"");
             
         }
         jLabel12.setText(sum+"");
         
         return sum;     
     }
       
       public int getsumpay(){
         int r=jTable2.getRowCount();
         int sum=0;
         for(int i=0;i<r;i++){
             sum=sum+Integer.parseInt(jTable2.getValueAt(i, 1).toString());
          //   jLabel12.setText(sum+"");
             
         }
         jLabel16.setText(sum+"");
         
         return sum;     
     }

       public void getpay(){
        try {
            String sql="SELECT paymentID FROM billpayments ORDER BY paymentID DESC LIMIT 1";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String rl=rs.getString("paymentID");
                int ln=rl.length();
                String stxt=rl.substring(0,2);
                String snum=rl.substring(2,ln);
                int n=Integer.parseInt(snum);
                
                n++;
                snum=Integer.toString(n);
                 roll2=stxt+snum;
                
          
                
                
            }
            else{
                //jLabel10.setText("ST1001");
                roll2="CP1001";
            }
        jLabel5.setOpaque(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"pay Error"+e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        
    }
       
       public void setnull(){
           jTextField10.setText("");
           jTextField2.setText("");
           jTextField3.setText("");
           jTextField7.setText("");
           jTextField6.setText("");
           jTextField9.setText("");
           jComboBox1.setSelectedIndex(0);
           jTable1.setModel(new DefaultTableModel(null,new String[]{"Product_code","Product_Name","Price","Qty","Total_Amount"}));
           jTable2.setModel(new DefaultTableModel(null,new String[]{"Payment_method","Amount"}));
           
           
    }
       public int showbal(){
           int gt=0,at=0;
             gt=Integer.parseInt(jLabel12.getText());
         at=Integer.parseInt(jLabel12.getText());
        int ans=gt-at;
        jLabel18.setText(ans+"");
        return ans;
       }
       
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        jMenuItem1.setText("Edit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Delete");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 728));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Billing");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 4));
        jPanel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel4KeyPressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Invoice info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Invoice No");

        jLabel3.setText("Invoice Date");

        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyPressed(evt);
            }
        });

        jLabel8.setText("ID");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Product Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11)))); // NOI18N

        jLabel4.setText("Product Code ");

        jLabel5.setText("Product Name");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Price");

        jLabel7.setText("Quantity");

        jTextField6.setText("1");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jLabel19.setText("Barcode");

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(54, 54, 54)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(98, 98, 98))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add To Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_code", "Product_Name", "Price", "Qty", "Total_Amount"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Grand Total");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("           0.00");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Total Payment");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("           0.00");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Balance");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("           0.00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Payment Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel13.setText("Payment Method");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Card" }));

        jLabel14.setText("Payment");

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "payment_method", "Amount"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton12.setText("Add");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Remove");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, 166, Short.MAX_VALUE)
                            .addComponent(jTextField9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        jButton5.setText("New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton11.setText("Close");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        try {
            String s="INSERT INTO billpayments VALUES(?,?,?,?,?)";
            pst=con.prepareStatement(s);
            pst.setString(1, roll2);
            pst.setString(2, jLabel8.getText());
            pst.setInt(3, Integer.parseInt(jLabel12.getText()));
            pst.setInt(4, cpay);
            pst.setInt(5, cdpay);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        getpay();
        getid();
        
         String r1="";
        TableModel mod=jTable1.getModel();
       
        for(int i=0;i<jTable1.getRowCount();i++){
            r1=r1+String.valueOf(jTable1.getValueAt(i,0))+" "+String.valueOf(jTable1.getValueAt(i, 1))+" "+String.valueOf(jTable1.getValueAt(i, 2)+" "+String.valueOf(jTable1.getValueAt(i, 3))+" "+String.valueOf(jTable1.getValueAt(i, 4)))+"\n\n";
        }
        
        String date=jDateChooser1.getDate().toString();
        
          int  gt=Integer.parseInt(jLabel12.getText());
        int at=Integer.parseInt(jLabel12.getText());
        int ans=gt-at;
        
        
         invoicearea n=new invoicearea();
        n.jTextArea1.setText("================================================================================================================\n"+
                "\t\tBeach Resort\t\t\n"+
                "================================================================================================================\n\n"+
                "\t077108397 /0525106038\t\n\n"+
                date+"\t"+"Invoice ID:"+jLabel8.getText()+"\t\n"+
                "================================================================================================================\n"+
                "ItemId\t"+"ItemName\t"+"Price\t"+"Qty\t"+"Amount"+
                "-----------------------------\n"+
                r1+
                "-----------------------------\n"+
                "Gross Amount\t\t\t\t"+jLabel12.getText()+"\n"+
                "Cash\t\t\t\t"+jLabel16.getText()+"\n"+
                "------------------------------\n"+
                "Balance\t\t\t\t"+jLabel18.getText()+"\n"+
                "================================================================================================================\n"+
                "\tThank You For Your Valued Patronage!\t\n"+
                "================================================================================================================");
        
           try {
            boolean com=n.jTextArea1.print();
            if(com)
            {
                JOptionPane.showMessageDialog(null,"done print");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"printing....");
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
           
         setnull();
           
           
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        main m=new main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int tot,qty,price,st = 0,stk=0;
         
        ivid=jLabel8.getText();
        pid=jTextField2.getText();
        pnme=jTextField3.getText();
        qty=Integer.parseInt(jTextField6.getText());
        price=Integer.parseInt(jTextField7.getText());
        tot=qty*price;

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        date=sdf.format(jDateChooser1.getDate());
        
        
          try {
            String sql="SELECT * FROM product WHERE productID='"+pid+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                st=rs.getInt("optainstock");
                //ostk=st-qty;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }
        
        if(st>=qty){
         DefaultTableModel mod=(DefaultTableModel) jTable1.getModel();
        mod.addRow(new Object[]{pid,pnme,price,qty,tot});
        getsum();
        
        stk=st-qty;
        
        
          try{
            
            String u="UPDATE product SET optainstock='"+stk+"' WHERE productID='"+pid+"'";
            pst=con.prepareStatement(u);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        
            
        try {
            String sql="INSERT INTO invoice VALUES(?,?,?,?,?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,ivid);
            pst.setString(2,date);
            pst.setString(3,pid);
            pst.setString(4,pnme);
            pst.setInt(5,price);
            pst.setInt(6,qty);
            pst.setInt(7,dis);
            pst.execute();

        } catch (Exception e) {
            System.out.println(e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        
    
        
        jTextField10.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField7.setText(null);
        jTextField6.setText(null);
        jTextField10.grabFocus();
        }
        else {
            JOptionPane.showMessageDialog(null,"Product Quantity Out of Stock");
            jTextField6.setText(null);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             
             
              String bcod=jTextField10.getText();
              
              if(!jTextField10.getText().equals("")){
              
        try {
            String s="SELECT * from product WHERE barcode='"+bcod+"'";
            pst=con.prepareStatement(s);
            rs=pst.executeQuery();
            if(rs.next()){
                proid=rs.getString("productID");
                proname=rs.getString("productName");
                sprice=rs.getInt("sellprice");
                dis=rs.getInt("discount");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
      /*  jTextField5.setEditable(false);
        jTextField4.setEditable(false);*/
        
        jTextField2.setText(proid);
        jTextField3.setText(proname);
        jTextField7.setText(sprice+"");
        
        jTextField6.grabFocus();
              }
              else {
                  JOptionPane.showMessageDialog(null,"Please Enter Barcode ");
              }
            
        }
         
         if(evt.getKeyCode()==KeyEvent.VK_F2){
        minpro m=new minpro();
        m.setVisible(true);
      //  minpro.jTextField1.grabFocus();
        //minpro.jTable1.grabFocus();
        }
                                           

    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
      //  cpay=0;
        //cdpay=0;
        
        paymeth=jComboBox1.getSelectedItem().toString();
        String pt=jTextField9.getText();
        if(paymeth=="Cash"){
            cpay=Integer.parseInt(jTextField9.getText());
           
        }
         if(paymeth=="Card"){
            cdpay=Integer.parseInt(jTextField9.getText());
        }
        
        DefaultTableModel mod=(DefaultTableModel) jTable2.getModel();
        mod.addRow(new Object[]{paymeth,pt});
        getsumpay();
        
        int gt=Integer.parseInt(jLabel16.getText());
        int at=Integer.parseInt(jLabel12.getText());
        int ans=gt-at;
        jLabel18.setText(ans+"");
        
        //getpay();
        jTextField9.setText(null);
        jComboBox1.setSelectedIndex(0);
       
        
        
        
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            int tot,qty,price,st = 0,stk=0;
         
        ivid=jLabel8.getText();
        pid=jTextField2.getText();
        pnme=jTextField3.getText();
        qty=Integer.parseInt(jTextField6.getText());
        price=Integer.parseInt(jTextField7.getText());
        tot=qty*price;

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        date=sdf.format(jDateChooser1.getDate());
        
        
          try {
            String sql="SELECT * FROM product WHERE productID='"+pid+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                st=rs.getInt("optainstock");
                //ostk=st-qty;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }
        
        if(st>=qty){
         DefaultTableModel mod=(DefaultTableModel) jTable1.getModel();
        mod.addRow(new Object[]{pid,pnme,price,qty,tot});
        getsum();
        
        stk=st-qty;
        
        
          try{
            
            String u="UPDATE product SET optainstock='"+stk+"' WHERE productID='"+pid+"'";
            pst=con.prepareStatement(u);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        
            
        try {
            String sql="INSERT INTO invoice VALUES(?,?,?,?,?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,ivid);
            pst.setString(2,date);
            pst.setString(3,pid);
            pst.setString(4,pnme);
            pst.setInt(5,price);
            pst.setInt(6,qty);
            pst.setInt(7,dis);
            pst.execute();

        } catch (Exception e) {
            System.out.println(e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        
    
        
        jTextField10.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField7.setText(null);
        jTextField6.setText(null);
       jTextField10.grabFocus();
        }
        else {
            JOptionPane.showMessageDialog(null,"Product Quantity Out of Stock");
            jTextField6.setText(null);
        }
        
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        minpro m=new minpro();
        m.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel4KeyPressed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jPanel4KeyPressed

    private void jDateChooser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyPressed
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_jDateChooser1KeyPressed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
         /*  String bcod=jTextField10.getText();
        try {
            String s="SELECT * from product WHERE barcode='"+bcod+"'";
            pst=con.prepareStatement(s);
            rs=pst.executeQuery();
            if(rs.next()){
                proid=rs.getString("productID");
                proname=rs.getString("productName");
                sprice=rs.getInt("sellprice");
                dis=rs.getInt("discount");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }*/
      /*  jTextField5.setEditable(false);
        jTextField4.setEditable(false);*/
        
       /* jTextField2.setText(proid);
        jTextField3.setText(proname);
        jTextField7.setText(sprice+"");
        
        jTextField6.grabFocus();*/
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel mod1=(DefaultTableModel) jTable1.getModel();
         int r=jTable1.getSelectedRow();
        
        int tot,qty,price,rst=0,rosk=0;
        
        String pidr=jTextField2.getText();
        pnme=jTextField3.getText();
        qty=Integer.parseInt(jTextField6.getText());
        price=Integer.parseInt(jTextField7.getText());
        tot=qty*price;
        
        
        
        
         try {
            String sql="SELECT * FROM product WHERE productID='"+pidr+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                rst=rs.getInt("optainstock");
                //ostk=st-qty;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }
        
        if(rst>=qty){
            
        rosk=rst-qty;
        
        
          try{
            
            String u="UPDATE product SET optainstock='"+rosk+"' WHERE productID='"+pidr+"'";
            pst=con.prepareStatement(u);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }   
        
         if(r>=0){
        mod1.setValueAt(pidr, r, 0);
        mod1.setValueAt(pnme, r, 1);
        mod1.setValueAt(price, r, 2);
        mod1.setValueAt(qty, r, 3);
        mod1.setValueAt(tot, r, 4);
        }
        else{
            JOptionPane.showMessageDialog(null,"Error");
        }
         getsum();
         
        jTextField10.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField7.setText(null);
        jTextField6.setText(null);
         
   }   
           
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
      /*  int r=jTable1.getSelectedRow();
        jTextField2.setText(jTable1.getValueAt(r,0).toString());
        jTextField3.setText(jTable1.getValueAt(r,1).toString());
        jTextField7.setText(jTable1.getValueAt(r,2).toString());        
        jTextField6.setText(jTable1.getValueAt(r,3).toString());
        
       int pro=Integer.parseInt(jTable1.getValueAt(r,3).toString());
       String pids=jTable1.getValueAt(r,0).toString();
       
       int stu=0,ostku=0;
       
        try {
            String sql="SELECT * FROM product WHERE productID='"+pids+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                stu=rs.getInt("optainstock");
                //ostku=stu+pro;
            }
        }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
            }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }
        
        ostku=stu+pro;
        
        
        
        
            try{
            String u="UPDATE product SET optainstock='"+ostku+"' WHERE productID='"+pids+"'";
            pst=con.prepareStatement(u);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }*/
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger()){
            jPopupMenu1.show(jTable1,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         int r=jTable1.getSelectedRow();
        jTextField2.setText(jTable1.getValueAt(r,0).toString());
        jTextField3.setText(jTable1.getValueAt(r,1).toString());
        jTextField7.setText(jTable1.getValueAt(r,2).toString());        
        jTextField6.setText(jTable1.getValueAt(r,3).toString());
        
        jButton2.setEnabled(false);
        
       int pro=Integer.parseInt(jTable1.getValueAt(r,3).toString());
       String pids=jTable1.getValueAt(r,0).toString();
       
       int stu=0,ostku=0;
       
        try {
            String sql="SELECT * FROM product WHERE productID='"+pids+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                stu=rs.getInt("optainstock");
                //ostku=stu+pro;
            }
        }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
            }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }
        
        ostku=stu+pro;
        
        
            try{
            String u="UPDATE product SET optainstock='"+ostku+"' WHERE productID='"+pids+"'";
            pst=con.prepareStatement(u);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int r=jTable1.getSelectedRow();
        
       int pro=Integer.parseInt(jTable1.getValueAt(r,3).toString());
       String pids=jTable1.getValueAt(r,0).toString();
       
       int stu=0,ostku=0;
       
        try {
            String sql="SELECT * FROM product WHERE productID='"+pids+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                stu=rs.getInt("optainstock");
                //ostku=stu+pro;
            }
        }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
            }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }
        
        ostku=stu+pro;
        
        
            try{
            String u="UPDATE product SET optainstock='"+ostku+"' WHERE productID='"+pids+"'";
            pst=con.prepareStatement(u);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                  rs.close();
                  pst.close();
            } catch (Exception e) {
            }
        }
      
        DefaultTableModel mod1=(DefaultTableModel) jTable1.getModel();
        int[] index=jTable1.getSelectedRows();
        
        for(int i=0;i<index.length;i++){
            mod1.removeRow(index[i]);
        }
        
        getsum();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        // TODO add your handling code here:
                String bcod=jTextField10.getText();
                
        try {
            String s="SELECT * from product WHERE barcode='"+bcod+"'";
            pst=con.prepareStatement(s);
           // pst.setString(1, jTextField10.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                jTextField2.setText(rs.getString("productID"));
                jTextField3.setText(rs.getString("productName"));
                jTextField7.setText(rs.getInt("sellprice")+"");
                dis=rs.getInt("discount");
                jTextField6.grabFocus();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        
       // jTextField2.setText(proid);
        //jTextField3.setText(proname);
        //jTextField7.setText(sprice+"");
        
       // jTextField6.grabFocus();
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
             if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             String bcod=jTextField2.getText();
             
              if(!jTextField2.getText().equals("")){
        try {
            String s="SELECT * from product WHERE barcode='"+bcod+"'";
            pst=con.prepareStatement(s);
            rs=pst.executeQuery();
            if(rs.next()){
                proid=rs.getString("productID");
                proname=rs.getString("productName");
                sprice=rs.getInt("sellprice");
                dis=rs.getInt("discount");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
      
        jTextField3.setText(proname);
        jTextField7.setText(sprice+"");
        
        jTextField6.grabFocus();
        }
        else{
                  JOptionPane.showMessageDialog(null,"Please Enter the ProductID");
        }      
        
            
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int r=jTable2.getSelectedRow();
        jTextField9.setText(jTable2.getValueAt(r, 1).toString());
        jComboBox1.setSelectedItem(jTable2.getValueAt(r, 0).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
          DefaultTableModel mod1=(DefaultTableModel) jTable2.getModel();
        int[] index=jTable2.getSelectedRows();
        
        for(int i=0;i<index.length;i++){
            mod1.removeRow(index[i]);
        }
        getsumpay();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setnull();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
       int enter = evt.getKeyChar();
    
        if(!(Character.isDigit(enter))) {
            
            jTextField9.setBackground(new Color(255, 102, 102));
            evt.consume();
            
        }

        else {
            
            jTextField9.setBackground(Color.WHITE);
            
        }
    }//GEN-LAST:event_jTextField9KeyTyped

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
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public static javax.swing.JTextField jTextField10;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
