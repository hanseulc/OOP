
import java.util.*;

public class Samsung extends Stock
{
    public Samsung()
    {
        super(937.00, "Samsung", "SMSN");
    }
    
    
    //override
      public double updatePrice(){
        Random ran = new Random();
        double update = ran.nextInt(20)-7;
        double price = super.getPrice();
        super.setPrice((update+price));
        return update;
    }
    
    
}
