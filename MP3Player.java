public class MP3Player extends Gadget {
    private double memoryUsed;
    private double memoryAvailable;
    private double downloadSize;

    public MP3Player(String model, double price, double weight, double size, double memory) 
    {
        super(model, price, weight, size);
        this.memoryAvailable = memory;
    }

    public void downloadMusic(double downloadSize) 
    {
        if (downloadSize <= memoryAvailable) 
        {
            memoryUsed += downloadSize;
            memoryAvailable -= downloadSize;
            System.out.println("Music downloaded successfully.");
        } else {
            System.out.println("Not enough memory available for download.");
        }
    }

    public double getMemoryAvailable()
    {
        return memoryAvailable;
    }

    public void setMemoryAvailable(double memoryAvailable)
    {
        this.memoryAvailable = memoryAvailable;
    }

    public double getdownloadSize()
    {
        return downloadSize;
    }

    public void setdownloadSize(double downloadSize)
    {
        this.downloadSize = downloadSize;
    }

    public double getMemoryUsed()
    {
        return memoryUsed;
    }

    public void setMemoryUsed(double memoryUsed)
    {
        this.memoryUsed = memoryUsed;
    }

    public void deleteMusic(double memoryToFree) 
    {
        if (memoryToFree > 0 && memoryToFree <= memoryUsed) {
            memoryUsed -= memoryToFree;
            memoryAvailable += memoryToFree;
            System.out.println("Music deleted successfully. Memory freed: " + memoryToFree);
        }
    }

    public void displayMP3() 
    {
        System.out.println("Model: " + getModel());
        System.out.println("Size: " + getSize());
        System.out.println("Weight: " + getWeight());
        System.out.println("Price: " + getPrice());
        System.out.println("Memory available: " + memoryAvailable);
    }
}

