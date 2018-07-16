package MyCode;

import static MyCode.ConnectionUtils.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {
    
    public static ResultSet searchStock(String name) {
        ResultSet rs = null;

        String query = "select * from stock where itemname=? and status=?";

        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, 1);
            rs = stmt.executeQuery();
            /*if(!rs.next()){
                rs = null;
            }*/
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
    
    public static ResultSet getItemByName(String name) {

       // ResultSet.CONCUR_UPDATABLE;
        ResultSet rs = null;
        String query = "select itemname,qty,value from stock where itemname=? and status=?";

        Connection con;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, 1);
            rs = stmt.executeQuery();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
    
    public static ResultSet getsTypeName() {

        ResultSet rs = null;
        String query = "select DISTINCT itemname from stock where status=?";

        Connection con;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, 1);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
    
    public static ResultSet getBillDet(){
        ResultSet rs = null;
        String query = "select * from bill where status = 1";
        Connection con;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static String getBillId() {
        String query = "SELECT * FROM bill ORDER BY bid DESC LIMIT 1";
        int newid = 0;
        String b="";
        //int newid = 0;
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String curID = rs.getString("bid");
                newid = Integer.parseInt(curID);
                newid++;
                 b = Integer.toString(newid);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public static ResultSet getSupWiseVal(String spname, String date, double tot) {
        ResultSet rs = null;
        ResultSet rs1 = null;
        String query1 = "select * from bill where supnname=? and status=?";
        String query2 = "insert into bill value (?,?,?,?,?)";
        String query3 = "UPDATE bill SET amount=?,date=? WHERE supnname =?";
        String query4 = "select amount from bill where supnname=? and status=? ";
        Connection con;
        
        String id = getBillId();
        if(id.equals("")){
            id = "1";
        }

        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query1);
            stmt.setString(1, spname);
            stmt.setInt(2, 1);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                //String amount = rs.getString("amount");
                //double total = Double.parseDouble(amount) + tot;
                
                PreparedStatement stmt1 = con.prepareStatement(query2);
                stmt1.setString(1, id);
                stmt1.setString(2, spname);
                stmt1.setDouble(3, tot);
                stmt1.setString(4, date);
                stmt1.setInt(5, 1);
                stmt1.execute();
            }
            else{
                PreparedStatement stmt2 = con.prepareStatement(query4);
                stmt2.setString(1, spname);
                stmt2.setInt(2, 1);
                rs1 = stmt2.executeQuery();
                if(rs1.next()){
                    String amount = rs1.getString("amount");
                    double total = Double.parseDouble(amount) + tot;
                    
                    PreparedStatement stmt3 = con.prepareStatement(query3);
                    stmt3.setDouble(1, total);
                    stmt3.setString(2, date);
                    stmt3.setString(3, spname);
                    stmt3.execute();
                }
                
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static boolean removeStockDet(String id) {
        boolean stat = false;

        String query = "UPDATE stock SET status=? WHERE stid =?";

        Connection con;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, id);

            boolean i = stmt.execute();
            if (i == true) {
                stat = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stat;
    }

    public static boolean updateStockDet(String id, String sname, String qty, String vlu, String date, String stype, String sup) {
        String query = "UPDATE stock SET itemname=?,qty=?,value=?,date=?,stype=?,supplier=?,status=? WHERE stid =? ";
        boolean stat = false;
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, sname);
            stmt.setString(2, qty);
            stmt.setString(3, vlu);
            stmt.setString(4, date);
            stmt.setString(5, stype);
            stmt.setString(6, sup);
            stmt.setInt(7, 1);
            stmt.setString(8, id);
            boolean i = stmt.execute();
            if (i == true) {
                stat = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stat;
    }

    public static ResultSet getAllStock() {
        ResultSet rs = null;
        String query = "select * from stock where status = 1";
        Connection con;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static boolean addStockDet(String id, String name, String qty, String vlu, String date, String stype, String sup) {
        boolean stat = false;
        String query = "insert into stock values (?,?,?,?,?,?,?,?)";

        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, qty);
            stmt.setString(4, vlu);
            stmt.setString(5, date);
            stmt.setString(6, stype);
            stmt.setString(7, sup);
            stmt.setInt(8, 1);

            boolean i = stmt.execute();
            if (i == true) {
                stat = true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stat;
    }

    public static String getStockId() {
        String query = "SELECT stid FROM stock ORDER BY stid DESC LIMIT 1";
        String curID = "";
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                curID = rs.getString("stid");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return curID;
    }

    public static ResultSet getSupName() {

        ResultSet rs = null;
        String query = "select supname from supplier where supstatus=?";

        Connection con;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, 1);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static ResultSet searchSup(String supname) {
        ResultSet rs = null;

        String query = "select * from supplier where supname=? and supstatus=?";

        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, supname);
            stmt.setInt(2, 1);
            rs = stmt.executeQuery();
            /*if(!rs.next()){
                rs = null;
            }*/
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static boolean removeSupDet(String id) {
        boolean stat = false;

        String query = "UPDATE supplier SET supstatus=? WHERE supid =?";

        Connection con;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, id);

            boolean i = stmt.execute();
            if (i == true) {
                stat = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stat;
    }

    public static boolean updateSupDet(String id, String name, String type, String addrs, String contct) {
        String query = "UPDATE supplier SET supname=?,suptype=?,supaddress=?,supcontact=? WHERE supid =? ";
        boolean stat = false;
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setString(3, addrs);
            stmt.setString(4, contct);
            stmt.setString(5, id);
            boolean i = stmt.execute();
            if (i == true) {
                stat = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stat;
    }

    public static ResultSet getAllSup() {
        ResultSet rs = null;
        String query = "select * from supplier where supstatus = 1";
        Connection con;
        try {
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static String getSupId() {
        String query = "SELECT * FROM supplier ORDER BY supid DESC LIMIT 1";
        String curID = "";
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                curID = rs.getString("supid");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return curID;
    }

    public static boolean addSupplier(String id, String name, String type, String addrs, String contct) {
        boolean stat = false;
        String query = "insert into supplier values (?,?,?,?,?,?)";

        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, type);
            stmt.setString(4, addrs);
            stmt.setString(5, contct);
            stmt.setInt(6, 1);

            boolean i = stmt.execute();
            if (i == true) {
                stat = true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stat;
    }

}
