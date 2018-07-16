package MyCode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author qaisf
 */
public class products {
    private String pid;
    private String pname;
    private Long bcode;
    private String catogary;
    private String description;
    private int cprice;
    private int sellprice;
    private int reorder;
    private int optainstk;
    private int discount;
    private int tax;
    
    
    public products(){}
    
    public products(String pids, String pnames, Long bcodes, String catogarys, String descriptions, int cprices, int sellprices, int reorders,int optainstks,int discounts,int taxs){
        this.pid=pids;
        this.pname=pnames;
        this.bcode=bcodes;
        this.catogary=catogarys;
        this.description=descriptions;
        this.cprice=cprices;
        this.sellprice=sellprices;
        this.reorder=reorders;
        this.optainstk=optainstks;
        this.discount=discounts;
        this.tax=taxs;
        
    }
    
    public String getpID(){
        return pid;
    }
    
    public String getName(){
        return pname;
    }
    
    public Long getBcode(){
        return bcode;
    }
    
    public String getCat(){
        return catogary;
    }
    
    public String getDes(){
        return description;
    }
    
    public int getCprice(){
        return cprice;
    }
    
    public int getSprice(){
        return sellprice;
    }
    
    public int getRorder(){
        return reorder;
    }
    
    public int getOstk(){
        return optainstk;
    }
    
    public int getDis(){
        return discount;
    }
    
    public int getTax(){
        return tax;
    }
    
    
    
    
}
