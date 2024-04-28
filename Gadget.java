
public class Gadget 
{
    private String model;
    private double price;
    private double weight;
    private double size;

    public Gadget(String model, double price, double weight, double size) 
    {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    public String getModel() 
    {
        return model;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public double getWeight() 
    {
        return weight;
    }

    public void setWeight(double weight) 
    {
        this.weight = weight;
    }

    public double getSize() 
    {
        return size;
    }

    public void setSize(double size) 
    {
        this.size = size;
    }
}
