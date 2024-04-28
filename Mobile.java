public class Mobile extends Gadget 
{
    private int creditRemaining;
    
    public Mobile(String model, double size, double weight, double price, int credit) 
    {
        super(model, size, weight, price);
        this.creditRemaining = credit;
    }
    
    public int getCreditRemaining() 
    {
        return creditRemaining;
    }
}

