
import java.util.*;

public class Apple extends Stock
{
    public Apple()
    {
        super(140.47, "Apple", "AAPL");
    }

    
     //override
      public double updatePrice(){
        Random ran = new Random();
        double update = ran.nextInt(10)-7;
        double price = super.getPrice();
        super.setPrice((update+price));
        return update;
    }
    
}
