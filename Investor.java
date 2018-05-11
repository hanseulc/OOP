
/**
 * 
 * Hanseul Cho
 * March 2
 */

import java.util.ArrayList;

public class Investor
{
    private double balance;
    private int accountNum;

    public Investor(double balance, int accountNum){

        this.balance = balance;
        this.accountNum = accountNum;

    }

    public double getBalance(){

        return balance;

    }

    public void setBalance(double b){

        balance = b;

    }

    public int getaccountNum(){

        return accountNum;

    }
    
    public void sellApple(int quantity, double price){

        balance = balance + (quantity*price);

    }
    public void buyApple(int quantity, double price){
        balance = balance - (quantity*price);
    
    }

    public void buySamsung(int quantity, double price){
        balance = balance - (quantity*price);
    }

    public void sellSamsung(int quantity, double price){

        balance = balance + (quantity*price);
    }
    public void sellGoogle(int quantity, double price){
        balance = balance + (quantity*price);
    
    }

    public void buyGoogle(int quantity, double price){

        balance = balance - (quantity*price);
    
    }
    
    public void sellMKS(int quantity, double price){

        balance = balance + (quantity*price);
    
    }
    
    public void buyMKS(int quantity, double price){
        balance = balance + (quantity*price);
    
    }
    
}
