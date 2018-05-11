
/**
 * Miniproject 
 * 
 * Hanseul Cho
 * March 2
 */

import java.util.*;

public class Stock
{
    private double price;
    private String companyName;
    private String stockName;
    private int totalStock;
    
    public Stock(double price, String companyName, String stockName)
    {
       this.price = price;
       this.companyName = companyName;
       this.stockName = stockName;
       totalStock = 0;
    }
    
    public void printInfo()
    {
        System.out.println("The company that holds the stock is " + 
            companyName + "(" + stockName + ").");
        System.out.println("The buying price is " + price);
    }
    
    public double getPrice(){
        return price;
    
    }
    
    public void setPrice(double pprice){
        price = pprice;
    
    }
    
    public String getcompanyName(){
        return companyName;
    }
    
    public String stockName(){
        return stockName;
    }
    
    public int getTotalStock(){
        return totalStock;
    }
    
    public void incTotalStock(int a){
        totalStock += a;
    }
    
    public void setTotalStock(int a){
        totalStock = a;
    }
    
    public double updatePrice(){
    
        Random ran = new Random();
        double update = ran.nextInt(15)-5;
        price = price + update;
        return update;
    }
    
    
    
}
