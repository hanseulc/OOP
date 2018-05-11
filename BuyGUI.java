import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.table.*;
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;

public class BuyGUI extends JFrame implements ActionListener{
    private Button buystock;
    private Button sellstock;
    private Button saveButton, loadButton;
    private JComboBox<Object> companylist;
    static Investor investor1 ;
    static ArrayList<Stock> stocks = new ArrayList<Stock>();
    static AccountGUI accountwindow;
    static Object[][] data;
    static JTable table;

    public BuyGUI(){
        super("Buy stock");
        setSize(500,500);
        setLocation(400,200);

        setLayout(new FlowLayout());

        this.stocks = stocks;

        //headers for the table
        String[] columns = new String[] {
                "Company Name", "Stock Name", "Stock Market Name", "Price(USD)", "Up+/Down-"
            };

        //actual data for the table in a 2d array
        data = new Object[][] {
            {"Apple", "AAPL", "NASDAQ", "144.12", "- 0.01 (0.1%)" },
            {"Google", "GOOGL", "NASDAQ", "868.23", "- 0.16 (0.02%)" },
            {"Samsung", "SMSN", "ADR", "937.00", "+2.5 (0.27%)" },
            {"Marks&Spencer", "MKS","LON", "328.30", "-7.5(2.21%)" }
        };

        companylist = new JComboBox<Object>();
        companylist.addItem("Apple");
        companylist.addItem("Google");
        companylist.addItem("Samsung");
        companylist.addItem("Marks&Spencer");
        companylist.setSelectedIndex(0);
        companylist.addActionListener(this);

        //create table with data
        table = new JTable(data, columns);
        JScrollPane tablescroll = new JScrollPane(table);
        this.add(tablescroll);

        buystock = new Button("Buy");
        buystock.addActionListener(this);

        sellstock = new Button("Sell");
        sellstock.addActionListener(this);

        this.setTitle("Buy stock");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.setVisible(true);
        
        saveButton = new Button("Save");
        loadButton = new Button("Load");
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);

        add(companylist);
        add(buystock);
        add(sellstock);
        add(saveButton);
        add(loadButton);

        setVisible(true);
        accountwindow = new AccountGUI();
        accountwindow.updateAccNum(investor1.getaccountNum());
        accountwindow.updateAcc(investor1.getBalance());
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == buystock){

            if(companylist.getSelectedIndex() == 0){

                investor1.buyApple(1, stocks.get(0).getPrice());
                accountwindow.updateAcc(investor1.getBalance());
                stocks.get(0).incTotalStock(1);
                accountwindow.updateStock(stocks.get(0).getTotalStock(), 0);
            }
            else if(companylist.getSelectedIndex()==1){

                investor1.buyGoogle(1, stocks.get(1).getPrice());
                accountwindow.updateAcc(investor1.getBalance());
                stocks.get(1).incTotalStock(1);
                accountwindow.updateStock(stocks.get(1).getTotalStock(), 1);
            }
            else if(companylist.getSelectedIndex()==2){

                investor1.buySamsung(1, stocks.get(2).getPrice());
                accountwindow.updateAcc(investor1.getBalance());
                stocks.get(2).incTotalStock(1);
                accountwindow.updateStock(stocks.get(2).getTotalStock(), 2);
            }
            

        }
        else if (source == sellstock){

            if(companylist.getSelectedIndex() == 0 && stocks.get(0).getTotalStock() > 0){

                investor1.sellApple(1, stocks.get(0).getPrice());
                accountwindow.updateAcc(investor1.getBalance());
                
                stocks.get(0).incTotalStock(-1);
                accountwindow.updateStock(stocks.get(0).getTotalStock(), 0);
            }
            else if(companylist.getSelectedIndex()==1 && stocks.get(1).getTotalStock() > 0){

                investor1.sellGoogle(1, stocks.get(1).getPrice());
                accountwindow.updateAcc(investor1.getBalance());
                
                stocks.get(1).incTotalStock(-1);
                accountwindow.updateStock(stocks.get(1).getTotalStock(), 1);
            }
            else if(companylist.getSelectedIndex()==2 && stocks.get(2).getTotalStock() > 0){

                investor1.sellSamsung(1, stocks.get(2).getPrice());
                accountwindow.updateAcc(investor1.getBalance());
                
                stocks.get(2).incTotalStock(-1);
                accountwindow.updateStock(stocks.get(2).getTotalStock(), 2);
            }
            else if(companylist.getSelectedIndex()==3 && stocks.get(3).getTotalStock() >0){
                investor1.sellMKS(1, stocks.get(3).getPrice());
                accountwindow.updateAcc(investor1.getBalance());
                
                stocks.get(3).incTotalStock(-1);
                accountwindow.updateStock(stocks.get(3).getTotalStock(), 3);
            
            
            }
        }
        else if (source == saveButton){
            save();
        }
        else if (source == loadButton){
            load();
        }
        this.addWindowListener (new WindowAdapter(){
                public void windowClosing(WindowEvent ev) {System.exit(0);}});
    }

    public static void main(String [] args)
    {

        Stock Google = new Google(); 
        Stock Apple = new Apple();
        Stock Samsung = new Samsung();
        Stock MKS = new MKS();
        stocks.add(Apple);
        stocks.add(Google);
        stocks.add(Samsung);
        stocks.add(MKS);

        investor1 = new Investor(10000, 12345678);
        BuyGUI window = new BuyGUI();
        
        int delay = 7000;
        ActionListener task = new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    table.getModel().setValueAt(Double.toString(stocks.get(0).updatePrice()), 0, 4);
                    table.getModel().setValueAt(Double.toString(stocks.get(0).getPrice()), 0, 3); 
                    table.getModel().setValueAt(Double.toString(stocks.get(0).updatePrice()), 1, 4);
                    table.getModel().setValueAt(Double.toString(stocks.get(0).getPrice()), 1, 3); 
                    table.getModel().setValueAt(Double.toString(stocks.get(0).updatePrice()), 2, 4);
                    table.getModel().setValueAt(Double.toString(stocks.get(0).getPrice()), 2, 3); 
                    table.getModel().setValueAt(Double.toString(stocks.get(0).updatePrice()), 3, 4);
                    table.getModel().setValueAt(Double.toString(stocks.get(0).getPrice()), 3, 3);
                }
            };
        new Timer(delay, task).start();

    }
    
    
    public void save(){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter("Stock.txt");
        }catch(Exception e){}
        
        String print = investor1.getBalance() + "";
        
        for(int i = 0; i < stocks.size(); i++){
            print += "\n" + stocks.get(i).getTotalStock();
        }
        
        writer.print(print);

        writer.close();
    }
    
    public void load(){
        BufferedReader txt = null;
        try{
            txt = new BufferedReader(new FileReader("Stock.txt"));
        }catch(Exception e){
            //nothing
        }
        
        String[] text = new String[1 + stocks.size()]; //stocks.size=how many shares investor bought
        
        for(int i = 0; i < text.length; i++){
            try{
                text[i] = txt.readLine();
            }catch(Exception e){
                //nothing
            }
        }
    
        try{
            investor1.setBalance(Double.parseDouble(text[0]));
        }catch(Exception e){}
        
        for(int i = 0; i < stocks.size(); i++){
            try{
                stocks.get(i).setTotalStock(Integer.parseInt(text[i+1]));
            }catch(Exception e){}
        }
        
        for(int i = 0; i < stocks.size(); i++){
            accountwindow.updateStock(stocks.get(i).getTotalStock(), i);
        }
        accountwindow.updateAcc(investor1.getBalance());
                
    }
}