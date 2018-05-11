import java.util.*;

public class MKS extends Stock{

    public MKS(){
        
        super(328.30, "Marks&Spencer", "MKS");
    
    }
    
    //override
        public double updatePrice(){
            Random ran = new Random();
            double update = ran.nextInt(30)-10;
            double price = super.getPrice();
            super.setPrice((update+price));
            return update;
        }



}