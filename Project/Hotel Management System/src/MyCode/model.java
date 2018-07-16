package MyCode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;


public class model extends AbstractTableModel{
    
     private String[] colums;
    private Object[][] rows;
    
    public model(){}
    
    public model(Object[][] data,String[] columnName){
        this.rows=data;
        this.colums=columnName;
    }
    
    public Class getColumnClass(int column){
        if(column==11){
           return Icon.class;
            
        }
        else{
            return getValueAt(0, column).getClass();
        }
            
   }

    
    public int getRowCount() {
        return this.rows.length;
    }

 
    public int getColumnCount() {
       return this.colums.length;
    }

  
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
        
    }
    
    public String getColumnName(int col){
        return this.colums[col];
    }

 
}
