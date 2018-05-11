import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class AccountGUI extends JFrame {
    private JLabel accBalance, accNumber;
    private JTextField balance, accNum;
    private JTable table;
    private Object[][] data;
    private String[] columns;
    
    public AccountGUI(){
        super("Account status");
        setLocation(900,200);
        setLayout(new GridLayout(2,1));
        
        JPanel p = new JPanel();
        add(p);
        p.setLayout(new GridLayout(2,2));
        
        accBalance = new JLabel("Account Balance: ");
        balance = new JTextField("0");
        balance.setEditable(false);
        
        accNumber = new JLabel("Account Number: ");
        accNum = new JTextField("0");
        accNum.setEditable(false);
        
        
        p.add(accNumber);
        p.add(accNum);
        p.add(accBalance);
        p.add(balance);
        
        
        String[] columns = new String[] {
                "Company Name", "Stock Name", "Stock Market Name", "Stock Owned"
            };
        data = new Object[][] {
            {"Apple", "AAPL", "NASDAQ", "0"},
            {"Google", "GOOGL", "NASDAQ", "0"},
            {"Samsung", "SMSN", "ADR", "0"},
            {"Marks&Spencer", "MKS", "LON", "0"}
            
        };
        
        table = new JTable(data, columns);
        
        
        JPanel pt = new JPanel();
        add(pt);
        pt.add(table);
        
        pack();
        setVisible(true);
    
    }
    
    public void updateAcc(double balance){
        
        int k = (int)(balance*100);
        double b = (double)(k) / 100.0;
        
        this.balance.setText(Double.toString(b));
        
    
    }
    
    public void updateAccNum(int accNumber){
        
        this.accNum.setText(Integer.toString(accNumber));
    
    
    }
    
    public void updateStock(int i, int j){
        table.getModel().setValueAt(Integer.toString(i), j, 3);
    }

}